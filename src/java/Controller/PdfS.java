package Controller;

import Dao.DemandaDAO;
import Model.Demanda;
import Util.PDF;
import Util.Verify;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FiJus
 */
public class PdfS extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int idDemanda=Integer.parseInt(request.getParameter("id_demanda"));
            DemandaDAO d=new DemandaDAO();
            Demanda demanda=d.getDemandaById(idDemanda);
            Verify v=new Verify();
            ArrayList<Verify> corrections=v.getCorrections(demanda);
            Gson gson=new Gson();
            out.print(gson.toJson(corrections));
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(PdfS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int idDemanda=Integer.parseInt(request.getParameter("id_demanda"));
            DemandaDAO d=new DemandaDAO();
            Demanda demanda=d.getDemandaById(idDemanda);
            PDF pdf=new PDF();
            String url=pdf.makePDF(demanda);
            Gson gson=new Gson();
            out.print(gson.toJson("./docs/"+demanda.getDte_id()+".pdf"));
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(PdfS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
