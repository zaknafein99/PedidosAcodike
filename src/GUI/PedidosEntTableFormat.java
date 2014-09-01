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
public class PedidosEntTableFormat implements WritableTableFormat{

    public boolean isEditable(Object arg0, int column) {
        if(column < 5 )
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
            art = (Articulos) cellObject;
            ped.setIdArticulo(art);

        }
        else if(column == 6){
            Moviles mov = new Moviles();
            mov = p.buscarMovilPorID(Integer.valueOf(cellObject.toString()));
            ped.setIdMovil(mov);

        }
        else if(column == 7){
            Moviles mov2 = new Moviles();
            mov2 = p.buscarMovilPorID(Integer.valueOf(cellObject.toString()));
            ped.setIdMovil2(mov2);

        }
        else if(column == 8){
            ped.setCantidad(Integer.valueOf(cellObject.toString()));
        }
        else if(column == 10) {
            ped.setFlete(Integer.valueOf(cellObject.toString()));
        }
        else if(column == 11){
            ped.setEntregado(cellObject.toString().charAt(0));
        }
        else if(column == 12){
            Moviles movAs = new Moviles();
            movAs = p.buscarMovilPorID(Integer.valueOf(cellObject.toString()));
            ped.setMovilAsignado(movAs);
        }
        ped.setTotal();
        p.actualizarPedido(ped);

        return ped;
    }

    public int getColumnCount() {
        return 13;
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
        else if (column==11)
            return "Entregado";
        else if (column==12)
            return "Movil que entregó";

        throw new IllegalStateException();
    }

    public Object getColumnValue(Object ped1, int column) {
        Pedidos ped = (Pedidos) ped1;
        if (column==0) return ped.getId();
        else if (column==1) return ped.getFechaPedido();
        else if (column==2) return ped.getIdcliente().getApellidonombre();
        else if (column==3) return ped.getIdcliente().getDireccion();
        else if (column==4) return ped.getIdcliente().getTelefono();
        else if (column==5) return ped.getIdArticulo().getNombre();
        else if (column==6) return ped.getIdMovil().getNromovil();
        else if (column==7) 
            if (ped.getIdMovil2()==null)
                return "";
            else
                return ped.getIdMovil2();
        else if (column==8) return ped.getCantidad();
        else if (column==9) return ped.getFlete();
        else if (column==10) return ped.getTotal();
        else if (column==11) return ped.getEntregado();
        else if (column==12) return ped.getMovilAsignado();


        throw new IllegalStateException();
    }





}
