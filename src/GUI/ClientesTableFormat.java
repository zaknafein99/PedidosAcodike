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
public class ClientesTableFormat implements WritableTableFormat{

    public boolean isEditable(Object arg0, int column) {
        if(column != 0)
           return true;
        else
           return false;
    }

    public Object setColumnValue(Object rowObject, Object cellObject, int column) {
        Cliente cli = (Cliente) rowObject;

        if(column == 1)
            { cli.setApellidonombre(cellObject.toString()); }
        else if(column == 2)
            { cli.setDireccion(cellObject.toString());}
        else if(column == 3)
            { cli.setTelefono(cellObject.toString());}
        else if(column == 4)
            { cli.setTipocliente(cellObject.toString());}
        else if(column == 5)
            { cli.setEstado(cellObject.toString().charAt(0));}
            Persistir p = Persistir.getInstancia();
            p.actualizarCliente(cli);
        return cli;
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int column) {
        if (column==0) return "Nro Cliente";
        else if (column==1) return "Apellido, Nombre";
        else if (column==2) return "Dirección";
        else if (column==3) return "Teléfono";
        else if (column==4) return "Tipo";
        else if (column==5) return "Estado";
        throw new IllegalStateException();
    }

    public Object getColumnValue(Object cli0, int column) {
        Cliente cli = (Cliente) cli0;
        if (column==0) return cli.getId();
        else if (column==1) return cli.getApellidonombre();
        else if (column==2) return cli.getDireccion();
        else if (column==3) return cli.getTelefono();
        else if (column==4) return cli.getTipocliente();
        else if (column==5) return cli.getEstado();
        throw new IllegalStateException();
    }

}
