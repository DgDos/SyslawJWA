/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author super
 */
public class Contestacion {
    private String proceso;
    private String contra;
    private int id_contestacion;
    private int id_demanda;
    private String nombre_demandado;
    private String ciudad_demandado;
    private String documento_demandado;
    private int tipo_documento_demandado;
    private String nombre_representante_legal;
    private String domicilio_representante_legal;
    private String documento_representante_legal;
    private int tipo_documento_representante;
    private Boolean ddo_apo_tiene;
    private String ddo_apo_nom;
    private String ddo_apo_dir;
    private String ddo_apo_id;
    private int ddo_apo_id_tipo;
    private String ddo_apo_tar_pro;   
    private String direccion_notificaciones;
    private String email;
    private boolean pretenciones;
    private String hechos_admitidos;
    private String hechos_negados;
    private String explicacion_negados;
    private String hechos_no_constan;
    private String explicacion_no_constan;
    private String excepciones;
    private String reconocimiento;
    private Boolean retencion;
    private String pruebas;
    private String anexos;
    private float porcentaje;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private Date fecha_autoguardado;
    private int id_autoguardado;
    private String id_usuario;
    private String id_ayudante;
    private String titulo;
    private int delete;

    public Contestacion() {
    }

    public Contestacion(String proceso, String contra, int id_contestacion, int id_demanda, String nombre_demandado, String ciudad_demandado, String documento_demandado, int tipo_documento_demandado, String nombre_representante_legal, String domicilio_representante_legal, String documento_representante_legal, int tipo_documento_representante, Boolean ddo_apo_tiene, String ddo_apo_nom, String ddo_apo_dir, String ddo_apo_id, int ddo_apo_id_tipo, String ddo_apo_tar_pro, String direccion_notificaciones, String email, boolean pretenciones, String hechos_admitidos, String hechos_negados, String explicacion_negados, String hechos_no_constan, String explicacion_no_constan, String excepciones, String reconocimiento, Boolean retencion, String pruebas, String anexos, float porcentaje, Date fecha_creacion, Date fecha_modificacion, Date fecha_autoguardado, int id_autoguardado, String id_usuario, String id_ayudante, String titulo, int delete) {
        this.proceso = proceso;
        this.contra = contra;
        this.id_contestacion = id_contestacion;
        this.id_demanda = id_demanda;
        this.nombre_demandado = nombre_demandado;
        this.ciudad_demandado = ciudad_demandado;
        this.documento_demandado = documento_demandado;
        this.tipo_documento_demandado = tipo_documento_demandado;
        this.nombre_representante_legal = nombre_representante_legal;
        this.domicilio_representante_legal = domicilio_representante_legal;
        this.documento_representante_legal = documento_representante_legal;
        this.tipo_documento_representante = tipo_documento_representante;
        this.ddo_apo_tiene = ddo_apo_tiene;
        this.ddo_apo_nom = ddo_apo_nom;
        this.ddo_apo_dir = ddo_apo_dir;
        this.ddo_apo_id = ddo_apo_id;
        this.ddo_apo_id_tipo = ddo_apo_id_tipo;
        this.ddo_apo_tar_pro = ddo_apo_tar_pro;
        this.direccion_notificaciones = direccion_notificaciones;
        this.email = email;
        this.pretenciones = pretenciones;
        this.hechos_admitidos = hechos_admitidos;
        this.hechos_negados = hechos_negados;
        this.explicacion_negados = explicacion_negados;
        this.hechos_no_constan = hechos_no_constan;
        this.explicacion_no_constan = explicacion_no_constan;
        this.excepciones = excepciones;
        this.reconocimiento = reconocimiento;
        this.retencion = retencion;
        this.pruebas = pruebas;
        this.anexos = anexos;
        this.porcentaje = porcentaje;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_autoguardado = fecha_autoguardado;
        this.id_autoguardado = id_autoguardado;
        this.id_usuario = id_usuario;
        this.id_ayudante = id_ayudante;
        this.titulo = titulo;
        this.delete = delete;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getId_contestacion() {
        return id_contestacion;
    }

    public void setId_contestacion(int id_contestacion) {
        this.id_contestacion = id_contestacion;
    }

    public int getId_demanda() {
        return id_demanda;
    }

    public void setId_demanda(int id_demanda) {
        this.id_demanda = id_demanda;
    }

    public String getNombre_demandado() {
        return nombre_demandado;
    }

    public void setNombre_demandado(String nombre_demandado) {
        this.nombre_demandado = nombre_demandado;
    }

    public String getCiudad_demandado() {
        return ciudad_demandado;
    }

    public void setCiudad_demandado(String ciudad_demandado) {
        this.ciudad_demandado = ciudad_demandado;
    }

    public String getDocumento_demandado() {
        return documento_demandado;
    }

    public void setDocumento_demandado(String documento_demandado) {
        this.documento_demandado = documento_demandado;
    }

    public int getTipo_documento_demandado() {
        return tipo_documento_demandado;
    }

    public void setTipo_documento_demandado(int tipo_documento_demandado) {
        this.tipo_documento_demandado = tipo_documento_demandado;
    }

    public String getNombre_representante_legal() {
        return nombre_representante_legal;
    }

    public void setNombre_representante_legal(String nombre_representante_legal) {
        this.nombre_representante_legal = nombre_representante_legal;
    }

    public String getDomicilio_representante_legal() {
        return domicilio_representante_legal;
    }

    public void setDomicilio_representante_legal(String domicilio_representante_legal) {
        this.domicilio_representante_legal = domicilio_representante_legal;
    }

    public String getDocumento_representante_legal() {
        return documento_representante_legal;
    }

    public void setDocumento_representante_legal(String documento_representante_legal) {
        this.documento_representante_legal = documento_representante_legal;
    }

    public int getTipo_documento_representante() {
        return tipo_documento_representante;
    }

    public void setTipo_documento_representante(int tipo_documento_representante) {
        this.tipo_documento_representante = tipo_documento_representante;
    }

    public Boolean getDdo_apo_tiene() {
        return ddo_apo_tiene;
    }

    public void setDdo_apo_tiene(Boolean ddo_apo_tiene) {
        this.ddo_apo_tiene = ddo_apo_tiene;
    }

    public String getDdo_apo_nom() {
        return ddo_apo_nom;
    }

    public void setDdo_apo_nom(String ddo_apo_nom) {
        this.ddo_apo_nom = ddo_apo_nom;
    }

    public String getDdo_apo_dir() {
        return ddo_apo_dir;
    }

    public void setDdo_apo_dir(String ddo_apo_dir) {
        this.ddo_apo_dir = ddo_apo_dir;
    }

    public String getDdo_apo_id() {
        return ddo_apo_id;
    }

    public void setDdo_apo_id(String ddo_apo_id) {
        this.ddo_apo_id = ddo_apo_id;
    }

    public int getDdo_apo_id_tipo() {
        return ddo_apo_id_tipo;
    }

    public void setDdo_apo_id_tipo(int ddo_apo_id_tipo) {
        this.ddo_apo_id_tipo = ddo_apo_id_tipo;
    }

    public String getDdo_apo_tar_pro() {
        return ddo_apo_tar_pro;
    }

    public void setDdo_apo_tar_pro(String ddo_apo_tar_pro) {
        this.ddo_apo_tar_pro = ddo_apo_tar_pro;
    }

    public String getDireccion_notificaciones() {
        return direccion_notificaciones;
    }

    public void setDireccion_notificaciones(String direccion_notificaciones) {
        this.direccion_notificaciones = direccion_notificaciones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPretenciones() {
        return pretenciones;
    }

    public void setPretenciones(boolean pretenciones) {
        this.pretenciones = pretenciones;
    }

    public String getHechos_admitidos() {
        return hechos_admitidos;
    }

    public void setHechos_admitidos(String hechos_admitidos) {
        this.hechos_admitidos = hechos_admitidos;
    }

    public String getHechos_negados() {
        return hechos_negados;
    }

    public void setHechos_negados(String hechos_negados) {
        this.hechos_negados = hechos_negados;
    }

    public String getExplicacion_negados() {
        return explicacion_negados;
    }

    public void setExplicacion_negados(String explicacion_negados) {
        this.explicacion_negados = explicacion_negados;
    }

    public String getHechos_no_constan() {
        return hechos_no_constan;
    }

    public void setHechos_no_constan(String hechos_no_constan) {
        this.hechos_no_constan = hechos_no_constan;
    }

    public String getExplicacion_no_constan() {
        return explicacion_no_constan;
    }

    public void setExplicacion_no_constan(String explicacion_no_constan) {
        this.explicacion_no_constan = explicacion_no_constan;
    }

    public String getExcepciones() {
        return excepciones;
    }

    public void setExcepciones(String excepciones) {
        this.excepciones = excepciones;
    }

    public String getReconocimiento() {
        return reconocimiento;
    }

    public void setReconocimiento(String reconocimiento) {
        this.reconocimiento = reconocimiento;
    }

    public Boolean getRetencion() {
        return retencion;
    }

    public void setRetencion(Boolean retencion) {
        this.retencion = retencion;
    }

    public String getPruebas() {
        return pruebas;
    }

    public void setPruebas(String pruebas) {
        this.pruebas = pruebas;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
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

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Contestacion{" + "proceso=" + proceso + ", contra=" + contra + ", id_contestacion=" + id_contestacion + ", id_demanda=" + id_demanda + ", nombre_demandado=" + nombre_demandado + ", ciudad_demandado=" + ciudad_demandado + ", documento_demandado=" + documento_demandado + ", tipo_documento_demandado=" + tipo_documento_demandado + ", nombre_representante_legal=" + nombre_representante_legal + ", domicilio_representante_legal=" + domicilio_representante_legal + ", documento_representante_legal=" + documento_representante_legal + ", tipo_documento_representante=" + tipo_documento_representante + ", ddo_apo_tiene=" + ddo_apo_tiene + ", ddo_apo_nom=" + ddo_apo_nom + ", ddo_apo_dir=" + ddo_apo_dir + ", ddo_apo_id=" + ddo_apo_id + ", ddo_apo_id_tipo=" + ddo_apo_id_tipo + ", ddo_apo_tar_pro=" + ddo_apo_tar_pro + ", direccion_notificaciones=" + direccion_notificaciones + ", email=" + email + ", pretenciones=" + pretenciones + ", hechos_admitidos=" + hechos_admitidos + ", hechos_negados=" + hechos_negados + ", explicacion_negados=" + explicacion_negados + ", hechos_no_constan=" + hechos_no_constan + ", explicacion_no_constan=" + explicacion_no_constan + ", excepciones=" + excepciones + ", reconocimiento=" + reconocimiento + ", retencion=" + retencion + ", pruebas=" + pruebas + ", anexos=" + anexos + ", porcentaje=" + porcentaje + ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", fecha_autoguardado=" + fecha_autoguardado + ", id_autoguardado=" + id_autoguardado + ", id_usuario=" + id_usuario + ", id_ayudante=" + id_ayudante + ", titulo=" + titulo + ", delete=" + delete + '}';
    }

   
    
    

    
}
