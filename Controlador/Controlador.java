
package Controlador;

import Modeloo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modeloo.EmpleadosDAO;
import Modeloo.EmpleadoProvider2;
import Modeloo.Empleado;
import Modeloo.ClienteProvider2;
import Modeloo.Cliente;
import Modeloo.ClienteDAO;
import Modeloo.Producto;
import Modeloo.ProductoDAO;
import Modeloo.ProductoProvider2;


public class Controlador extends HttpServlet {
  Empleado admi = new Empleado();
    EmpleadoProvider2 ADM = new  EmpleadoProvider2();
    EmpleadosDAO ado=new EmpleadosDAO();
    
    Cliente cli = new Cliente();
    ClienteProvider2 aBD = new ClienteProvider2();
    ClienteDAO dao=new ClienteDAO();
   
    
    Producto doc = new Producto();
    ProductoProvider2 DOC = new ProductoProvider2();
    ProductoDAO DAO=new ProductoDAO();
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;   
    double totalpagar;
    
    int id;
    
   


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
       if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
              
                    List lista=aBD.obtenerTodos();
                    request.setAttribute("Clientes", lista);
                    break;                           
                    case "Agregar":                     
  
                    cli.setMatricula(request.getParameter("matricula"));
                    cli.setNombre(request.getParameter("nombre"));
                    cli.setApellido(request.getParameter("apellido"));
                    cli.setTelefono(request.getParameter("telefono"));
                    cli.setCorreo(request.getParameter("correo"));
                    cli.setSemestre(request.getParameter("semestre"));
                    cli.setCarrera(request.getParameter("carrera"));
                    cli.setSexo(request.getParameter("sexo"));
                    
                    aBD.registrar(cli); 
                    
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                    case "Editar":
                        
                    id = Integer.parseInt(request.getParameter("id_cliente"));
                      
                    cli.setMatricula(request.getParameter("matricula"));
                    cli.setNombre(request.getParameter("nombre"));
                    cli.setApellido(request.getParameter("apellido"));
                    cli.setTelefono(request.getParameter("telefono"));
                    cli.setCorreo(request.getParameter("correo"));  
                    cli.setSemestre(request.getParameter("semestre"));
                    cli.setCarrera(request.getParameter("carrera"));
                    cli.setSexo(request.getParameter("sexo"));
                    request.setAttribute("Cliente", cli);
                    
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                        
                case "Actualizar":
                    
                    cli.setId(id);
                    cli.setMatricula(request.getParameter("matricula"));
                    cli.setNombre(request.getParameter("nombre"));
                    cli.setApellido(request.getParameter("apellido"));
                    cli.setTelefono(request.getParameter("telefono"));
                    cli.setCorreo(request.getParameter("correo"));
                    cli.setSemestre(request.getParameter("semestre"));
                    cli.setCarrera(request.getParameter("carrera"));
                    cli.setSexo(request.getParameter("sexo"));

                    aBD.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                
                case "Delete":
                                        
                    id = Integer.parseInt(request.getParameter("id_cliente"));
                    cli.setId(id);
                    dao.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
    
        
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
              
                    List lista=DOC.obtenerTodos();
                    request.setAttribute("Productos", lista);
                    break;                           
                    
                case "Agregar":                     
  
                    doc.setPrecio(request.getParameter("precio"));
                    doc.setNombre(request.getParameter("nombre"));
                    doc.setStock(request.getParameter("stock"));
                    doc.setEstado(request.getParameter("estado"));
                   
                    
                    DOC.registrar(doc); 
                    
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);

                    break;
                 
                   
                    case "Editar":  
                    id = Integer.parseInt(request.getParameter("id_producto"));
                      
                    doc.setPrecio(request.getParameter("precio"));
                    doc.setNombre(request.getParameter("nombre"));
                    doc.setStock(request.getParameter("stock"));
                    doc.setEstado(request.getParameter("estado"));
                   
         
                    request.setAttribute("Producto", doc);
                    
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                             
                case "Actualizar":
                    
                    doc.setId(id);
                    
                    doc.setPrecio(request.getParameter("precio"));
                    doc.setNombre(request.getParameter("nombre"));
                    doc.setStock(request.getParameter("stock"));
                    doc.setEstado(request.getParameter("estado"));
                   

                    DOC.actualizar(doc);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                    
                case "Delete":
                                        
                    id = Integer.parseInt(request.getParameter("id_producto"));
                    doc.setId(id);
                    DAO.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;

                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("Empleados")) {
             switch (accion) {
                case "Listar":
              
                    List lista=ADM.obtenerTodos();
                    request.setAttribute("Empleados", lista);
                    break;  
                    
                    case "Agregar":                     
  
                    admi.setMatricula(request.getParameter("matricula"));
                    admi.setNombre(request.getParameter("nombre"));
                    admi.setApellido(request.getParameter("apellido"));
                    admi.setTelefono(request.getParameter("telefono"));
                    admi.setCorreo(request.getParameter("correo"));

                    admi.setSexo(request.getParameter("sexo"));
                    
                    ADM.registrar(admi); 
                    
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                 
                     case "Editar":  
                    id = Integer.parseInt(request.getParameter("id_empleado"));
                      
                    admi.setMatricula(request.getParameter("matricula"));
                    admi.setNombre(request.getParameter("nombre"));
                    admi.setApellido(request.getParameter("apellido"));
                    admi.setTelefono(request.getParameter("telefono"));
                    admi.setCorreo(request.getParameter("correo"));                   
                    admi.setSexo(request.getParameter("sexo"));
         
                    request.setAttribute("Empleado", admi);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    
                    admi.setId(id);
                    admi.setMatricula(request.getParameter("matricula"));
                    admi.setNombre(request.getParameter("nombre"));
                    admi.setApellido(request.getParameter("apellido"));
                    admi.setTelefono(request.getParameter("telefono"));
                    admi.setCorreo(request.getParameter("correo"));
                    admi.setSexo(request.getParameter("sexo"));

                    ADM.actualizar(admi);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                    
                case "Delete":
                                        
                 id = Integer.parseInt(request.getParameter("id_empleado"));
                    admi.setId(id);
                    ado.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;

                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }
        
        
        if (menu.equals("NuevaVenta")) {
            switch (accion){
                case "Buscarcliente": 
                   String matricula= request.getParameter("codigocliente");
                    cli.setMatricula(matricula);
                   Cliente cl=dao.buscar(matricula);
                    request.setAttribute("Cliente", cl);
                    break;
                case "Buscarproducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    doc=DAO.listarId(id);
                    request.setAttribute("producto", doc);
                    request.setAttribute("lista", lista);
                    break;
                
                case "Agregar":
                    totalpagar=0.0;
                    item= item+1;
                    cod=doc.getId();
                    descripcion=request.getParameter("nombreproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal= precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setId(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalpagar=totalpagar+lista.get(i).getSubtotal();
                        
                        
                    }
                     request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", lista);
                    break;
                    case "Generarventa":
            
                    //request.getRequestDispatcher("Home.jsp").forward(request, response);
            
                    break;                        
                    case "Cancelar":
            
                    request.getRequestDispatcher("Home.jsp").forward(request, response);
            
                    break;
                        
                default:
                throw new AssertionError();
            }
            request.getRequestDispatcher("Registroventas.jsp").forward(request, response);
        }
        if (menu.equals("Entrar")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
         
        
        if (menu.equals("Salir")) {
            request.getRequestDispatcher("Registrar.jsp").forward(request, response);
        }

        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
