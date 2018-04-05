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
public class Estadisticas {
    private String id_usuario;
    private int veces;

    public Estadisticas() {
    }

    public Estadisticas(String id_usuario, int veces) {
        this.id_usuario = id_usuario;
        this.veces = veces;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }
    
    
}
