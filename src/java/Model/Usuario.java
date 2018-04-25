/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FiJus
 */
public class Usuario {
    private String documento;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String correo;
    private int tipo_usuario;
    private int tipo_id;

    public Usuario() {
    }

    public Usuario(String documento, String nombre, String ciudad, String direccion, String correo, int tipo_usuario, int tipo_id) {
        this.documento = documento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.correo = correo;
        this.tipo_usuario = tipo_usuario;
        this.tipo_id = tipo_id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    
    
}
