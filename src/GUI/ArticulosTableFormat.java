/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import ca.odell.glazedlists.gui.WritableTableFormat;
import dominio.*;
import persistencia.Persistir;
/**
 *
 * @author Docente
 */
public class ArticulosTableFormat implements WritableTableFormat{
    public ArticulosTableFormat(){

    }
    public int getColumnCount() {
                return 4;
            }

    public String getColumnName(int column) {
        if (column==0) return "Codigo";
        else if (column==1) return "Articulo";
        else if (column==2) return "Precio";
        else if (column==3) return "Kgs";

        throw new IllegalStateException();
    }

    public Object getColumnValue(Object arti, int column) {
        Articulos art = (Articulos) arti;
        if (column==0) return art.getCodigo();
        else if (column==1) return art.getNombre();
        else if (column==2) return art.getPrecio();
        else if (column==3) return art.getKgs();

        throw new IllegalStateException();
    }

    public boolean isEditable(Object arg0, int column) {
        if(column != 0)
           return true;
        else
           return false;
    }

     public Articulos setColumnValue(Object rowObject, Object cellObject, int column){
         Articulos art = (Articulos) rowObject;

        if(column == 1)
            { art.setNombre(cellObject.toString()); }
        else if(column == 2)
            { art.setPrecio(Integer.valueOf(cellObject.toString()));}
        else if(column == 3)
            { art.setKgs(Integer.valueOf(cellObject.toString()));}
            Persistir p = Persistir.getInstancia();
            p.actualizarArticulo(art);
        return art;
     }






}
