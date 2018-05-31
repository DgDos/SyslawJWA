/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Demanda;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class Verify {

    private String id;
    private String titulo;
    private String content;
    private int code;

    public Verify() {
    }

    public Verify(String id, String titulo, String content, int code) {
        this.id = id;
        this.titulo = titulo;
        this.content = content;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //1 es cambio obligatorio, 2 es cambio sugerido, 3 es que está bien el campo (no necesita ni título ni mensaje, puede llegar vacío)
    public ArrayList<Verify> getCorrections(Demanda demanda) {
        ArrayList<Verify> corrections = new ArrayList<>();
        ArrayList<Verify> emptys = empty(demanda);
        return emptys;
    }

    private ArrayList<Verify> empty(Demanda demanda) {
        ArrayList<Verify> empty = new ArrayList<>();
        Verify ver = new Verify();
        if (demanda.getJuez_nombre().equals("")) {
            ver = new Verify("juez_nombre", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("juez_nombre", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDte_apo_tiene()) {
            if (demanda.getDte_apo_nom().equals("")) {
                ver = new Verify("dte_apo_nom", "Campo vacio", "Este campo es obligatorio", 1);
                empty.add(ver);
            } else {
                ver = new Verify("dte_apo_nom", "", "", 3);
                empty.add(ver);
            }
            if (demanda.getDte_apo_id().equals("")) {
                ver = new Verify("dte_apo_id", "Campo vacio", "Este campo es obligatorio", 1);
                empty.add(ver);
            } else {
                ver = new Verify("dte_apo_id", "", "", 3);
                empty.add(ver);
            }
            if (demanda.getDte_apo_tar_pro().equals("")) {
                ver = new Verify("dte_apo_tar_pro", "Campo vacio", "Este campo es obligatorio", 1);
                empty.add(ver);
            } else {
                ver = new Verify("dte_apo_tar_pro", "", "", 3);
                empty.add(ver);
            }
            if (demanda.getDte_apo_id_tipo() == -1) {
                ver = new Verify("dte_apo_id_tipo", "Campo vacio", "Este campo es obligatorio", 1);
                empty.add(ver);
            } else {
                ver = new Verify("dte_apo_id_tipo", "", "", 3);
                empty.add(ver);
            }
        }
        if (demanda.getDem_nom().equals("")) {
            ver = new Verify("dem_nom", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("dem_nom", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDem_id().equals("")) {
            ver = new Verify("dem_id", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("dem_id", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDem_id_tipo() == -1) {
            ver = new Verify("dem_id_tipo", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("dem_id_tipo", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDem_ciu().equals("")) {
            ver = new Verify("dem_ciu", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("dem_ciu", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDem_dir_not().equals("")) {
            ver = new Verify("dem_dir_not", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("dem_dir_not", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getDem_email().equals("")) {
            ver = new Verify("dem_email", "Campo vacio", "Este campo es opcional, pero se recomienda llenarlo", 2);
            empty.add(ver);
        }else{
            ver = new Verify("dem_email", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getPretensiones().equals("")) {
            ver = new Verify("pretensiones", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            Boolean correction = search(demanda.getPretensiones());
            if (!correction) {
                ver = new Verify("pretensiones", "Error en escritura", "El sistema no encontro enumeración, si ya la tiene haga caso omiso de este mensaje", 2);
                empty.add(ver);
            } else {
                ver = new Verify("pretensiones", "", "", 3);
                empty.add(ver);
            }
        }
        if (demanda.getHechos().equals("")) {
            ver = new Verify("hechos", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            Boolean correction = search(demanda.getHechos());
            if (!correction) {
                ver = new Verify("hechos", "Error en escritura", "El sistema no encontro enumeración, si ya la tiene haga caso omiso de este mensaje", 2);
                empty.add(ver);
            } else {
                ver = new Verify("hechos", "", "", 3);
                empty.add(ver);
            }
        }
        if (demanda.getPruebas().equals("")) {
            ver = new Verify("pruebas", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            Boolean correction = search(demanda.getPruebas());
            if (!correction) {
                ver = new Verify("pruebas", "Error en escritura", "El sistema no encontro enumeración, si ya la tiene haga caso omiso de este mensaje", 2);
                empty.add(ver);
            } else {
                ver = new Verify("pruebas", "", "", 3);
                empty.add(ver);
            }
        }
        if (demanda.getFundamentos().equals("")) {
            ver = new Verify("fundamentos", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            ver = new Verify("fundamentos", "", "", 3);
            empty.add(ver);
        }
        if (demanda.getAnexos().equals("")) {
            ver = new Verify("anexos", "Campo vacio", "Este campo es obligatorio", 1);
            empty.add(ver);
        } else {
            Boolean correction = search(demanda.getAnexos());
            if (!correction) {
                ver = new Verify("anexos", "Error en escritura", "El sistema no encontro enumeración, si ya la tiene haga caso omiso de este mensaje", 2);
                empty.add(ver);
            } else {
                ver = new Verify("anexos", "", "", 3);
                empty.add(ver);
            }
        }
        if (demanda.getSolicito_cautelares()) {
            if (demanda.getCautelares_que_solicita().equals("")) {
                ver = new Verify("cautelares_que_solicita", "Campo vacio", "Este campo es obligatorio", 1);
                empty.add(ver);
            }
        }
        return empty;
    }

    private Boolean search(String pretensiones) {
        int cont = 0;
        for (int i = 0; i < pretensiones.length(); i++) {
            if (cont == 0) {
                if (pretensiones.charAt(i) == '1') {
                    cont++;
                }
            } else {
                if (cont == 1) {
                    if (pretensiones.charAt(i) == '.') {
                        cont++;
                    } else {
                        cont = 0;
                    }
                } else {
                    if (cont == 2) {
                        if (pretensiones.charAt(i) == ' ') {
                            return true;
                        } else {
                            cont = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

}
