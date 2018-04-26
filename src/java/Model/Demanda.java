package Model;

import java.util.Date;

/**
 *
 * @author FiJus
 */
public class Demanda {

    private int id_demanda;
    private String id_usuario;
    private String id_ayudante;
    private String titulo;
    private String juez_nombre;
    private String dte_nom;
    private String dte_ciudad;
    private int dte_id_tipo;
    private String dte_id;
    private Boolean dte_rep_tiene;
    private String dte_rep_nom;
    private int dte_rep_id_tipo;
    private String dte_rep_id;
    private Boolean dte_apo_tiene;
    private String dte_apo_nom;
    private int dte_apo_id_tipo;
    private String dte_apo_id;
    private String dte_apo_tar_pro;
    private String dte_dir_not;
    private String dte_email;
    private String dem_nom;
    private String dem_ciu;
    private Boolean dem_rep_tiene;
    private String dem_rep_nom;
    private Boolean dem_apo_tiene;
    private String dem_apo_nom;
    private String dem_dir_not;
    private String dem_email;
    private String pretensiones;
    private String hechos;
    private Boolean depende_cumplimiento;
    private Boolean tengo_pruebas;
    private String pruebas;
    private Boolean estaba_obligado;
    private String fundamentos;
    private String anexos;
    private Boolean solicito_cautelares;
    private String cautelares_que_solicita;
    private float porcentaje;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private Date fecha_autoguardado;
    private int id_autoguardado;
    private int paso;
    private String dem_id;
    private int dem_id_tipo;

    public Demanda() {
    }

    public Demanda(int id_demanda, String id_usuario, String id_ayudante, String titulo, String juez_nombre, String dte_nom, String dte_ciudad, int dte_id_tipo, String dte_id, Boolean dte_rep_tiene, String dte_rep_nom, int dte_rep_id_tipo, String dte_rep_id, Boolean dte_apo_tiene, String dte_apo_nom, int dte_apo_id_tipo, String dte_apo_id, String dte_apo_tar_pro, String dte_dir_not, String dte_email, String dem_nom, String dem_ciu, Boolean dem_rep_tiene, String dem_rep_nom, Boolean dem_apo_tiene, String dem_apo_nom, String dem_dir_not, String dem_email, String pretensiones, String hechos, Boolean depende_cumplimiento, Boolean tengo_pruebas, String pruebas, Boolean estaba_obligado, String fundamentos, String anexos, Boolean solicito_cautelares, String cautelares_que_solicita, float porcentaje, Date fecha_creacion, Date fecha_modificacion, Date fecha_autoguardado, int id_autoguardado, int paso, String dem_id, int dem_id_tipo) {
        this.id_demanda = id_demanda;
        this.id_usuario = id_usuario;
        this.id_ayudante = id_ayudante;
        this.titulo = titulo;
        this.juez_nombre = juez_nombre;
        this.dte_nom = dte_nom;
        this.dte_ciudad = dte_ciudad;
        this.dte_id_tipo = dte_id_tipo;
        this.dte_id = dte_id;
        this.dte_rep_tiene = dte_rep_tiene;
        this.dte_rep_nom = dte_rep_nom;
        this.dte_rep_id_tipo = dte_rep_id_tipo;
        this.dte_rep_id = dte_rep_id;
        this.dte_apo_tiene = dte_apo_tiene;
        this.dte_apo_nom = dte_apo_nom;
        this.dte_apo_id_tipo = dte_apo_id_tipo;
        this.dte_apo_id = dte_apo_id;
        this.dte_apo_tar_pro = dte_apo_tar_pro;
        this.dte_dir_not = dte_dir_not;
        this.dte_email = dte_email;
        this.dem_nom = dem_nom;
        this.dem_ciu = dem_ciu;
        this.dem_rep_tiene = dem_rep_tiene;
        this.dem_rep_nom = dem_rep_nom;
        this.dem_apo_tiene = dem_apo_tiene;
        this.dem_apo_nom = dem_apo_nom;
        this.dem_dir_not = dem_dir_not;
        this.dem_email = dem_email;
        this.pretensiones = pretensiones;
        this.hechos = hechos;
        this.depende_cumplimiento = depende_cumplimiento;
        this.tengo_pruebas = tengo_pruebas;
        this.pruebas = pruebas;
        this.estaba_obligado = estaba_obligado;
        this.fundamentos = fundamentos;
        this.anexos = anexos;
        this.solicito_cautelares = solicito_cautelares;
        this.cautelares_que_solicita = cautelares_que_solicita;
        this.porcentaje = porcentaje;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_autoguardado = fecha_autoguardado;
        this.id_autoguardado = id_autoguardado;
        this.paso = paso;
        this.dem_id = dem_id;
        this.dem_id_tipo = dem_id_tipo;
    }

    public int getId_demanda() {
        return id_demanda;
    }

    public void setId_demanda(int id_demanda) {
        this.id_demanda = id_demanda;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_ayudante() {
        return id_ayudante;
    }

    public void setId_ayudante(String id_ayudante) {
        this.id_ayudante = id_ayudante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getJuez_nombre() {
        return juez_nombre;
    }

    public void setJuez_nombre(String juez_nombre) {
        this.juez_nombre = juez_nombre;
    }

    public String getDte_nom() {
        return dte_nom;
    }

    public void setDte_nom(String dte_nom) {
        this.dte_nom = dte_nom;
    }

    public String getDte_ciudad() {
        return dte_ciudad;
    }

    public void setDte_ciudad(String dte_ciudad) {
        this.dte_ciudad = dte_ciudad;
    }

    public int getDte_id_tipo() {
        return dte_id_tipo;
    }

    public void setDte_id_tipo(int dte_id_tipo) {
        this.dte_id_tipo = dte_id_tipo;
    }

    public String getDte_id() {
        return dte_id;
    }

    public void setDte_id(String dte_id) {
        this.dte_id = dte_id;
    }

    public Boolean getDte_rep_tiene() {
        return dte_rep_tiene;
    }

    public void setDte_rep_tiene(Boolean dte_rep_tiene) {
        this.dte_rep_tiene = dte_rep_tiene;
    }

    public String getDte_rep_nom() {
        return dte_rep_nom;
    }

    public void setDte_rep_nom(String dte_rep_nom) {
        this.dte_rep_nom = dte_rep_nom;
    }

    public int getDte_rep_id_tipo() {
        return dte_rep_id_tipo;
    }

    public void setDte_rep_id_tipo(int dte_rep_id_tipo) {
        this.dte_rep_id_tipo = dte_rep_id_tipo;
    }

    public String getDte_rep_id() {
        return dte_rep_id;
    }

    public void setDte_rep_id(String dte_rep_id) {
        this.dte_rep_id = dte_rep_id;
    }

    public Boolean getDte_apo_tiene() {
        return dte_apo_tiene;
    }

    public void setDte_apo_tiene(Boolean dte_apo_tiene) {
        this.dte_apo_tiene = dte_apo_tiene;
    }

    public String getDte_apo_nom() {
        return dte_apo_nom;
    }

    public void setDte_apo_nom(String dte_apo_nom) {
        this.dte_apo_nom = dte_apo_nom;
    }

    public int getDte_apo_id_tipo() {
        return dte_apo_id_tipo;
    }

    public void setDte_apo_id_tipo(int dte_apo_id_tipo) {
        this.dte_apo_id_tipo = dte_apo_id_tipo;
    }

    public String getDte_apo_id() {
        return dte_apo_id;
    }

    public void setDte_apo_id(String dte_apo_id) {
        this.dte_apo_id = dte_apo_id;
    }

    public String getDte_apo_tar_pro() {
        return dte_apo_tar_pro;
    }

    public void setDte_apo_tar_pro(String dte_apo_tar_pro) {
        this.dte_apo_tar_pro = dte_apo_tar_pro;
    }

    public String getDte_dir_not() {
        return dte_dir_not;
    }

    public void setDte_dir_not(String dte_dir_not) {
        this.dte_dir_not = dte_dir_not;
    }

    public String getDte_email() {
        return dte_email;
    }

    public void setDte_email(String dte_email) {
        this.dte_email = dte_email;
    }

    public String getDem_nom() {
        return dem_nom;
    }

    public void setDem_nom(String dem_nom) {
        this.dem_nom = dem_nom;
    }

    public String getDem_ciu() {
        return dem_ciu;
    }

    public void setDem_ciu(String dem_ciu) {
        this.dem_ciu = dem_ciu;
    }

    public Boolean getDem_rep_tiene() {
        return dem_rep_tiene;
    }

    public void setDem_rep_tiene(Boolean dem_rep_tiene) {
        this.dem_rep_tiene = dem_rep_tiene;
    }

    public String getDem_rep_nom() {
        return dem_rep_nom;
    }

    public void setDem_rep_nom(String dem_rep_nom) {
        this.dem_rep_nom = dem_rep_nom;
    }

    public Boolean getDem_apo_tiene() {
        return dem_apo_tiene;
    }

    public void setDem_apo_tiene(Boolean dem_apo_tiene) {
        this.dem_apo_tiene = dem_apo_tiene;
    }

    public String getDem_apo_nom() {
        return dem_apo_nom;
    }

    public void setDem_apo_nom(String dem_apo_nom) {
        this.dem_apo_nom = dem_apo_nom;
    }

    public String getDem_dir_not() {
        return dem_dir_not;
    }

    public void setDem_dir_not(String dem_dir_not) {
        this.dem_dir_not = dem_dir_not;
    }

    public String getDem_email() {
        return dem_email;
    }

    public void setDem_email(String dem_email) {
        this.dem_email = dem_email;
    }

    public String getPretensiones() {
        return pretensiones;
    }

    public void setPretensiones(String pretensiones) {
        this.pretensiones = pretensiones;
    }

    public String getHechos() {
        return hechos;
    }

    public void setHechos(String hechos) {
        this.hechos = hechos;
    }

    public Boolean getDepende_cumplimiento() {
        return depende_cumplimiento;
    }

    public void setDepende_cumplimiento(Boolean depende_cumplimiento) {
        this.depende_cumplimiento = depende_cumplimiento;
    }

    public Boolean getTengo_pruebas() {
        return tengo_pruebas;
    }

    public void setTengo_pruebas(Boolean tengo_pruebas) {
        this.tengo_pruebas = tengo_pruebas;
    }

    public String getPruebas() {
        return pruebas;
    }

    public void setPruebas(String pruebas) {
        this.pruebas = pruebas;
    }

    public Boolean getEstaba_obligado() {
        return estaba_obligado;
    }

    public void setEstaba_obligado(Boolean estaba_obligado) {
        this.estaba_obligado = estaba_obligado;
    }

    public String getFundamentos() {
        return fundamentos;
    }

    public void setFundamentos(String fundamentos) {
        this.fundamentos = fundamentos;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public Boolean getSolicito_cautelares() {
        return solicito_cautelares;
    }

    public void setSolicito_cautelares(Boolean solicito_cautelares) {
        this.solicito_cautelares = solicito_cautelares;
    }

    public String getCautelares_que_solicita() {
        return cautelares_que_solicita;
    }

    public void setCautelares_que_solicita(String cautelares_que_solicita) {
        this.cautelares_que_solicita = cautelares_que_solicita;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Date getFecha_autoguardado() {
        return fecha_autoguardado;
    }

    public void setFecha_autoguardado(Date fecha_autoguardado) {
        this.fecha_autoguardado = fecha_autoguardado;
    }

    public int getId_autoguardado() {
        return id_autoguardado;
    }

    public void setId_autoguardado(int id_autoguardado) {
        this.id_autoguardado = id_autoguardado;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public String getDem_id() {
        return dem_id;
    }

    public void setDem_id(String dem_id) {
        this.dem_id = dem_id;
    }

    public int getDem_id_tipo() {
        return dem_id_tipo;
    }

    public void setDem_id_tipo(int dem_id_tipo) {
        this.dem_id_tipo = dem_id_tipo;
    }

    

   

    
}
