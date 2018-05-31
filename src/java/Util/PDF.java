/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Demanda;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class PDF {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static Font myBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);

    public PDF() {

    }

    public String makePDF(Demanda demanda) {
        try {
            Document document = new Document();
            File f=new File("");
            String file = "" + demanda.getDte_id() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document, demanda.getDte_nom(), demanda.getFecha_creacion(), demanda.getTitulo(), demanda.getDem_nom());
            addTitlePage(document, demanda);
            addContent(document, demanda);
            document.close();
            return f.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document, String demandante, Date fecha, String titulo, String demandado) {
        document.addTitle("Demanda de " + demandante + " contra " + demandado);
        document.addKeywords("Demanda, Monitorio, " + titulo + ", " + fecha);
        document.addAuthor(demandante);
        document.addCreator(demandante);
    }

    private static void addTitlePage(Document document, Demanda demanda)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        addEmptyLine(preface, 1);
        String start = "SEÑOR JUEZ CIVIL MUNICIPAL DE: " + demanda.getJuez_nombre();
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(start, smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);
//        // Start a new page
//        document.newPage();
    }

    private static void addContent(Document document, Demanda demanda) throws DocumentException {
        Paragraph p = new Paragraph();
        //DEMANDANTE
        String demandante1 = "1. DEMANDANTE";
        p.add(new Paragraph(demandante1, catFont));
        String demandante = "Nombre: " + demanda.getDte_nom() + "\n"
                + "Ciudad de domicilio del demandante: " + demanda.getDte_ciudad() + "\n"
                + "Documento de identificación: C.C. (";
        if (demanda.getDte_id_tipo() == 0) {
            demandante += "X) NIT(_) TI(_) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDte_id_tipo() == 1) {
            demandante += "_) NIT(X) TI(_) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDte_id_tipo() == 2) {
            demandante += "_) NIT(_) TI(X) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDte_id_tipo() == 4) {
            demandante += "_) NIT(_) TI(_) CE(X) PASAPORTE(_)\n";
        }
        if (demanda.getDte_id_tipo() == 3) {
            demandante += "_) NIT(_) TI(_) CE(_) PASAPORTE(X)\n";
        }
        demandante += "Número: " + demanda.getDte_id() + "\n"
                + "Dirección donde recibe notificaciones: " + demanda.getDte_dir_not() + "\n"
                + "Dirección de correo electrónico: " + demanda.getDte_email();
        if (demanda.getDte_apo_tiene()) {
            demandante += "\n\nNombre del apoderado: " + demanda.getDte_apo_nom()
                    + "\nDocumento de identificación: C.C. (";
            if (demanda.getDte_apo_id_tipo() == 0) {
                demandante += "X) NIT(_) TI(_) CE(_) PASAPORTE(_)\n";
            }
            if (demanda.getDte_apo_id_tipo() == 1) {
                demandante += "_) NIT(X) TI(_) CE(_) PASAPORTE(_)\n";
            }
            if (demanda.getDte_apo_id_tipo() == 2) {
                demandante += "_) NIT(_) TI(X) CE(_) PASAPORTE(_)\n";
            }
            if (demanda.getDte_apo_id_tipo() == 4) {
                demandante += "_) NIT(_) TI(_) CE(X) PASAPORTE(_)\n";
            }
            if (demanda.getDte_apo_id_tipo() == 3) {
                demandante += "_) NIT(_) TI(_) CE(_) PASAPORTE(X)\n";
            }
            demandante += "Número: " + demanda.getDte_apo_id() + "\n"
                    + "Tarjeta profesional No.: " + demanda.getDte_apo_tar_pro() + "\n";
        }
        p.add(new Paragraph(demandante, myBold));
        //DEMANDADO
        String demandado1 = "2.DEMANDANDO";
        p.add(new Paragraph(demandado1, catFont));
        String demandado = "Nombre: " + demanda.getDem_nom() + "\n"
                + "Ciudad de domicilio del demandante: " + demanda.getDem_ciu() + "\n"
                + "Documento de identificación: C.C. (";
        if (demanda.getDem_id_tipo() == 0) {
            demandado += "X) NIT(_) TI(_) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDem_id_tipo() == 1) {
            demandado += "_) NIT(X) TI(_) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDem_id_tipo() == 2) {
            demandado += "_) NIT(_) TI(X) CE(_) PASAPORTE(_)\n";
        }
        if (demanda.getDem_id_tipo() == 4) {
            demandado += "_) NIT(_) TI(_) CE(X) PASAPORTE(_)\n";
        }
        if (demanda.getDem_id_tipo() == 3) {
            demandado += "_) NIT(_) TI(_) CE(_) PASAPORTE(X)\n";
        }
        demandado += "Número: " + demanda.getDem_id() + "\n"
                + "Dirección donde recibe notificaciones: " + demanda.getDem_dir_not() + "\n";
        if (!demanda.getDem_email().equals("")) {
            demandado += "Dirección de correo electrónico: " + demanda.getDte_email() + "\n";
        }
        p.add(new Paragraph(demandado, myBold));
        // now add all this to the document
        String pretensiones = "3. PRETENSIONES";
        p.add(new Paragraph(pretensiones, catFont));
        pretensiones = demanda.getPretensiones() + "\n";
        p.add(new Paragraph(pretensiones, myBold));
        String hechos = "4. HECHOS";
        p.add(new Paragraph(hechos, catFont));
        hechos = demanda.getHechos() + "\n";
        p.add(new Paragraph(hechos, myBold));
        String p5 = "5- Manifiesto que el pago de la suma adeudada SI (";
        if (demanda.getDepende_cumplimiento()) {
            p5 += "X) NO ( ) depende del cumplimiento de una obligación a mi cargo.\n";
        } else {
            p5 += " ) NO (X) depende del cumplimiento de una obligación a mi cargo.\n";
        }
        p.add(new Paragraph(p5, myBold));
        String p6 = "6- Manifiesto bajo juramento que SI (";
        if (demanda.getTengo_pruebas()) {
            p6 += "X) NO ( ) tengo en mi poder pruebas documentales sobre la existencia de la obligación cuyo pago pretendo.\n";
        } else {
            p6 += " ) NO (X) tengo en mi poder pruebas documentales sobre la existencia de la obligación cuyo pago pretendo.\n";
        }
        p.add(new Paragraph(p6, myBold));
        String pruebas = "7. PRUEBAS";
        p.add(new Paragraph(pruebas, catFont));
        pruebas = demanda.getPruebas() + "\n";
        p.add(new Paragraph(pruebas, myBold));
        String fundamentos = "8. FUNDAMENTOS DE DERECHO";
        p.add(new Paragraph(fundamentos, catFont));
        fundamentos = demanda.getFundamentos() + "\n";
        p.add(new Paragraph(fundamentos, myBold));
        String anexos = "9. ANEXOS";
        p.add(new Paragraph(anexos, catFont));
        anexos = demanda.getAnexos() + "\n";
        p.add(new Paragraph(anexos, myBold));
        String cautelares = "10. CAUTELARES";
        p.add(new Paragraph(cautelares, catFont));
        cautelares = "Manifiesto bajo juramento que SI (";
        if (demanda.getSolicito_cautelares()) {
            cautelares += "X) o NO ( ), la práctica de medidas cautelares.\n"
                    + demanda.getCautelares_que_solicita() + "\n\n";
        } else {
            cautelares += " ) o NO (X), la práctica de medidas cautelares.\n\n";
        }
        p.add(new Paragraph(cautelares, myBold));
        String inal = "Respetuosamente,\n\n"
                + "_____________________________________________________________\n"
                + "Firma\n"
                + "Documento: " + demanda.getDem_id();
        p.add(new Paragraph(inal, myBold));
        document.add(p);

    }

    private static void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
