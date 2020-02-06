/*
 * SubirArchivoBean.java
 *
 * Created on 04-oct-2007, 11:56:03
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class SubirArchivoBean implements Serializable {

    private String nombre;
    private Long longitud;
    private List<String> archivos;

    public List<String> getArchivos() {
        if (archivos == null) {
            archivos = new ArrayList<String>();
        }
        return archivos;
    }

    public void setArchivos(List<String> archivos) {
        this.archivos = archivos;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}