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
    private int id_contestacion;
    private int id_demanda;
    private String nombre_demandado;
    private String documento_demandado;
    private int tipo_documento_demandado;
    private String nombre_representante_legal;
    private String domicilio_representante_legal;
    private String documento_representante_legal;
    private int tipo_documento_representante;
    private String nombre_apoderado;
    private String domicilio_apoderado;
    private String documento_apoderado;
    private int tipo_documento_apoderado;
    private String tarjeta_profesional_apoderado;   
    private String direccion_notificaciones;
    private String email;
    private boolean pretenciones;
    private String hechos_admitidos;
    private String hechos_negados;
    private String explicacion_negados;
    private String hechos_no_constan;
    private String explicacion_no_constan;
    private String excepciones;
    private String pruebas;
    private float porcentaje;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private Date fecha_autoguardado;
    private int id_autoguardado;
    private String id_usuario;
    private String id_ayudante;
    private String titulo;
    private int delete;

    public Contestacion(int id_contestacion, int id_demanda, String nombre_demandado, String documento_demandado, int tipo_documento_demandado, String nombre_representante_legal, String domicilio_representante_legal, String documento_representante_legal, int tipo_documento_representante, String nombre_apoderado, String domicilio_apoderado, String documento_apoderado, int tipo_documento_apoderado, String tarjeta_profesional_apoderado, String direccion_notificaciones, String email, boolean pretenciones, String hechos_admitidos, String hechos_negados, String explicacion_negados, String hechos_no_constan, String explicacion_no_constan, String excepciones, String pruebas, float porcentaje, Date fecha_creacion, Date fecha_modificacion, Date fecha_autoguardado, int id_autoguardado, String id_usuario, String id_ayudante, String titulo, int delete) {
        this.id_contestacion = id_contestacion;
        this.id_demanda = id_demanda;
        this.nombre_demandado = nombre_demandado;
        this.documento_demandado = documento_demandado;
        this.tipo_documento_demandado = tipo_documento_demandado;
        this.nombre_representante_legal = nombre_representante_legal;
        this.domicilio_representante_legal = domicilio_representante_legal;
        this.documento_representante_legal = documento_representante_legal;
        this.tipo_documento_representante = tipo_documento_representante;
        this.nombre_apoderado = nombre_apoderado;
        this.domicilio_apoderado = domicilio_apoderado;
        this.documento_apoderado = documento_apoderado;
        this.tipo_documento_apoderado = tipo_documento_apoderado;
        this.tarjeta_profesional_apoderado = tarjeta_profesional_apoderado;
        this.direccion_notificaciones = direccion_notificaciones;
        this.email = email;
        this.pretenciones = pretenciones;
        this.hechos_admitidos = hechos_admitidos;
        this.hechos_negados = hechos_negados;
        this.explicacion_negados = explicacion_negados;
        this.hechos_no_constan = hechos_no_constan;
        this.explicacion_no_constan = explicacion_no_constan;
        this.excepciones = excepciones;
        this.pruebas = pruebas;
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

    public Contestacion() {
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

    public String getNombre_apoderado() {
        return nombre_apoderado;
    }

    public void setNombre_apoderado(String nombre_apoderado) {
        this.nombre_apoderado = nombre_apoderado;
    }

    public String getDomicilio_apoderado() {
        return domicilio_apoderado;
    }

    public void setDomicilio_apoderado(String domicilio_apoderado) {
        this.domicilio_apoderado = domicilio_apoderado;
    }

    public String getDocumento_apoderado() {
        return documento_apoderado;
    }

    public void setDocumento_apoderado(String documento_apoderado) {
        this.documento_apoderado = documento_apoderado;
    }

    public int getTipo_documento_apoderado() {
        return tipo_documento_apoderado;
    }

    public void setTipo_documento_apoderado(int tipo_documento_apoderado) {
        this.tipo_documento_apoderado = tipo_documento_apoderado;
    }

    public String getTarjeta_profesional_apoderado() {
        return tarjeta_profesional_apoderado;
    }

    public void setTarjeta_profesional_apoderado(String tarjeta_profesional_apoderado) {
        this.tarjeta_profesional_apoderado = tarjeta_profesional_apoderado;
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

    public String getPruebas() {
        return pruebas;
    }

    public void setPruebas(String pruebas) {
        this.pruebas = pruebas;
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

  

 

   
    
    

    
}
