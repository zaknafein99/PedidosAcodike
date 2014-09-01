/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;
import dominio.*;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.persistence.*;
/**
 *
 * @author Administrador
 */
public class Persistir {
static private Persistir pers = new Persistir();
    private Persistir(){}

    static public Persistir getInstancia(){
        return pers;
    }

public void guardar(Object object) {
   EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
   EntityManager em = emf.createEntityManager();
   EntityTransaction  tx = em.getTransaction();
   tx.begin();
   try {
       em.persist(object);
       tx.commit();
   } catch (Exception e) {
       e.printStackTrace();
       tx.rollback();
   } finally {
       em.close();
       emf.close();

   }
   }

public void darDeBajaCliente(Cliente cli){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Cliente existingCli = em.find(Cliente.class, cli.getId());
        existingCli.setEstado('B');
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}

public void actualizarCliente(Cliente cli){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Cliente existingCli = em.find(Cliente.class, cli.getId());
        existingCli.setApellidonombre(cli.getApellidonombre());
        existingCli.setDireccion(cli.getDireccion());
        existingCli.setEstado(cli.getEstado());
        existingCli.setTelefono(cli.getTelefono());
        existingCli.setTipocliente(cli.getTipocliente());
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}

public void actualizarArticulo(Articulos ar){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Articulos existingArt = em.find(Articulos.class, ar.getCodigo());
        existingArt.setKgs(ar.getCodigo());
        existingArt.setNombre(ar.getNombre());
        existingArt.setPrecio(ar.getPrecio());
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}

public void actualizarPedido(Pedidos ped){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Pedidos existingPed = em.find(Pedidos.class, ped.getId());
        existingPed.setCantidad(ped.getCantidad());
        existingPed.setEntregado(ped.getEntregado());
        existingPed.setFechaPedido(ped.getFechaPedido());
        existingPed.setFlete(ped.getFlete());
        existingPed.setIdArticulo(ped.getIdArticulo());
        existingPed.setIdMovil(ped.getIdMovil());
        existingPed.setIdMovil2(ped.getIdMovil2());
        existingPed.setIdcliente(ped.getIdcliente());
        existingPed.setMovilAsignado(ped.getMovilAsignado());
        existingPed.setObservaciones(ped.getObservaciones());
        existingPed.setTotal();
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}

public void darAltaClienteExistente(Cliente cli){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Cliente existingCli = em.find(Cliente.class, cli.getId());
        existingCli.setEstado('A');
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}

public void eliminarPedido(Pedidos ped){
   EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
   EntityManager em = emf.createEntityManager();
   em.getTransaction().begin();
   
    try {
        Pedidos ped0 = em.merge(ped);
        em.remove(ped0);
        em.getTransaction().commit();
        
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
        em.close();
        emf.close();
   }
}

public void eliminarCliente(Cliente cli){
   EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
   EntityManager em = emf.createEntityManager();
   em.getTransaction().begin();

    try {
        Cliente cli0 = em.merge(cli);
        em.remove(cli0);
        em.getTransaction().commit();
        
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
        em.close();
        emf.close();
   }
}

public void eliminarArticulo(Articulos art){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PedidosPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Articulos art0 = em.merge(art);
        em.remove(art0);
        em.getTransaction().commit();

    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
        em.close();
        emf.close();
   }
}

public Cliente buscarClientePorTelefono(String telefono){
    
EntityManagerFactory emf = Persistence.createEntityManagerFactory(
    "PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
        Cliente cli = null;
        
  try {
    Query query = em.createNamedQuery("Cliente.findByTelefono");
    query.setParameter("telefono",telefono);
    cli =   (Cliente) query.getSingleResult();
    return cli;

  } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
  } finally {
    em.close();
    emf.close();
  }
   return cli;
}



public Articulos buscarArticuloPorNombre(String NombreArt){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
    "PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
        Articulos art = null;

  try {
    Query query = em.createNamedQuery("Articulos.findByNombre");
    query.setParameter("nombre", NombreArt);
    art =   (Articulos) query.getSingleResult();
    return art;

  } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
  } finally {
    em.close();
    emf.close();
  }
   return art;
}

public Collection<Articulos> listarArticulos2(){
  List list = null;
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();

  try {
    Query query = em.createNamedQuery("Articulos.findAll");

    list =  query.getResultList();


  } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
  } finally {
    em.close();
    emf.close();
    return list;
  }
}

public List<Articulos> listarArticulos(){
  List list = null;
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();

  try {
    Query query = em.createNamedQuery("Articulos.findAll");

    list = query.getResultList();


  } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
  } finally {
    em.close();
    emf.close();
    return list;
  }

   
}

public List listarClientes(){
    List list = null;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
    Query query = em.createNamedQuery("Cliente.findAll");

    list = query.getResultList();
    } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
    } finally {
    em.close();
    emf.close();
    return list;
}
}

public List<Cliente> listarClientesPorTelefono(String tel){
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    Query query = null;
    tx.begin();
    List<Cliente> list = null;
    try {
        query = em.createNamedQuery("Cliente.findByTelefono");
        query.setParameter("telefono", tel);
        list = query.getResultList();

        
    
    } catch (Exception e) {
        System.out.println( e.getMessage() );
        tx.rollback();
    } finally {
        em.close();
        emf.close();

    return list;
}
}

public List listarClientesPorApellido(String ape){
    String param = "%"+ape+"%";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    Query query = null;
    tx.begin();
    List<Cliente> list = null;

    try {
        query = em.createNamedQuery("Cliente.findByApellido");
        query.setParameter("apellido", param);
        list = query.getResultList();



    } catch (Exception e) {
        System.out.println( e.getMessage() );
        tx.rollback();
    } finally {
        em.close();
        emf.close();

    return list;
}
}

public List listarClientesPorDireccion(String dir){
    String param = "%"+dir+"%";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    Query query = null;
    tx.begin();
    List<Cliente> list = null;

    try {
        query = em.createNamedQuery("Cliente.findByDireccion");
//        query = em.createNativeQuery("SELECT * FROM cliente Where telefono = '"+ tel + "'");
        query.setParameter("direccion", param);
        list = query.getResultList();



    } catch (Exception e) {
        System.out.println( e.getMessage() );
        tx.rollback();
    } finally {
        em.close();
        emf.close();

    return list;
}

}

public List listarClientesDeBaja(){
    List list = null;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
    Query query = em.createNativeQuery("SELECT * FROM cliente WHERE estado = 'B'");

    list = query.getResultList();
    } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
    } finally {
    em.close();
    emf.close();
    return list;
}
}

public Vector listarPedidos(){
  Vector<Articulos> lista = null;
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();

  try {
    Query query = em.createNativeQuery("SELECT * FROM pedidosview WHERE ENTREGADO='P' ORDER BY fecha_pedido");

    lista = (Vector) query.getResultList();
  } catch (Exception e) {
    System.out.println( e.getMessage() );
    em.getTransaction().rollback();
  } finally {
    em.close();
    emf.close();
  }
    return lista;
}

public Vector listarPedidosAsignados(){
    Vector<Articulos> lista = null;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

     try {
      Query query = em.createNativeQuery("SELECT * FROM pedidosview WHERE ENTREGADO='E' and id > (SELECT MAX(id) FROM pedidosview) - 100 ORDER BY id");
      lista = (Vector<Articulos>) query.getResultList();
    } catch (Exception e) {
        System.out.println( e.getMessage() );
        em.getTransaction().rollback();
    } finally {
        em.close();
        emf.close();
    }
    return lista;
}

public Articulos buscarArticulosPorID(int id){
  Articulos ar = null;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  try{
    ar = new Articulos();
    ar=em.find(Articulos.class, id);
  }catch (Exception e) {
      System.out.println( e.getMessage() );
      em.getTransaction().rollback();
  }finally {
      em.close();
      emf.close();
  }
  return ar;

}

public Moviles buscarMovilPorID(int id){
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  Moviles mov = new Moviles();
  mov=em.find(Moviles.class, id);
  return mov;
}

public Pedidos buscarPedidoPorId(int id){
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  Pedidos ped = new Pedidos();
  ped = em.find(Pedidos.class, id);
  return ped;
}

public Cliente buscarClientePorId(int id){
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  Cliente cli = new Cliente();
  cli = em.find(Cliente.class, id);
  return cli;
}
}
