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
 * @author Administrador
 */
public class PedidosTableFormat implements WritableTableFormat{

    public boolean isEditable(Object arg0, int column) {
        if(column < 4 )
            return false;
        else if (column == 9)
            return false;
        else
             return true;
    }

    public Object setColumnValue(Object rowObject, Object cellObject, int column) {
        Persistir p = Persistir.getInstancia();
        Pedidos ped = (Pedidos) rowObject;

        if(column == 5){
            Articulos art = new Articulos();
            art = p.buscarArticuloPorNombre((String)cellObject) ;
            ped.setIdArticulo(art);

        }
        else if(column == 6){
            Moviles mov = new Moviles();
            if (cellObject.toString().equals(""))
                mov = p.buscarMovilPorID(1);
            mov = p.buscarMovilPorID(Integer.valueOf(cellObject.toString()));
            ped.setIdMovil(mov);

        }
        else if(column == 7){
            Moviles mov2 = new Moviles();
            if (cellObject.toString().equals(""))
                mov2 = p.buscarMovilPorID(1);
            mov2 = p.buscarMovilPorID(Integer.valueOf(cellObject.toString()));
            ped.setIdMovil2(mov2);

        }
        else if(column == 8){
            ped.setCantidad(Integer.valueOf(cellObject.toString()));
        }
        else if(column == 9) {
            ped.setFlete(Integer.valueOf(cellObject.toString()));
        }
        ped.setTotal();
        p.actualizarPedido(ped);
        return ped;
    }

    public int getColumnCount() {
        return 11;
    }

    public String getColumnName(int column) {
        if (column==0)
            return "Nro Ped";
        else if (column==1)
            return "Fecha Pedido";
        else if (column==2)
            return "Cliente";
        else if (column==3)
            return "Direccion";
         else if (column==4)
            return "Tel";
        else if (column==5)
            return "Articulo";
        else if (column==6)
            return "Movil";
        else if (column==7)
            return "Movil prox";
        else if (column==8)
            return "Cantidad";
        else if (column==9)
            return "Flete";
        else if (column==10)
            return "Total";

        throw new IllegalStateException();
    }

    public Object getColumnValue(Object ped1, int column) {
        Pedidos ped = (Pedidos) ped1;
        
        if (column==0) return ped.getId();
        else if (column==1) return ped.getFechaPedido();
        else if (column==2) return ped.getIdcliente().getApellidonombre();
        else if (column==3) return ped.getIdcliente().getDireccion();
        else if (column==4) return ped.getIdcliente().getTelefono();
        else if (column==5)
            if (ped.getIdArticulo()==null)
                return null;
            else
                return ped.getIdArticulo().getNombre();

        else if (column==6)
            if (ped.getIdMovil()==null)
                return null;
            else
                return ped.getIdMovil().getNromovil();
        else if (column==7)
            if (ped.getIdMovil2()==null)
                return null;
            else
            return ped.getIdMovil2().getNromovil();
        else if (column==8)
            if (ped.getCantidad()==null)
                return null;
            else
                return ped.getCantidad();
        else if (column==9) return ped.getFlete();
        else if (column==10) return ped.getTotal();


        throw new IllegalStateException();
    }


}
