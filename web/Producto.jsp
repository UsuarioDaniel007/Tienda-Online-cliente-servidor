<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO DE PRODUCTOS!</h1>
        <div class="d-flex">
            <div class="card col-sm-6">
            <div class="card-body">
                 <form action="Controlador?menu=Productos" method="POST">
                   
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="text" value="${Producto.getPrecio()}" name="precio"class="form-control">
                    </div>
                    <div class="form-group">
                        <label>NOMBRE</label>
                        <input type="text" value="${Producto.getNombre()}" name="nombre"class="form-control">
                    </div>
                    <div class="form-group">
                        <label>STOCK</label>
                        <input type="text" value="${Producto.getStock()}" name="stock"class="form-control">
                    </div>
                    <div class="form-group">
                        <label>ESTADO</label>
                        <input type="text"value="${Producto.getEstado()}" name="estado"class="form-control">
                    </div>
                    
                   
                    
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
        <div class=" col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                      
                        <th>PRECIO</th>
                        <th>NOMBRE</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cli" items="${Productos}">
                          <tr>
                        
                        <td>${cli.getPrecio()}</td>
                        <td>${cli.getNombre()}</td>
                        <td>${cli.getStock()}</td>
                        <td>${cli.getEstado()}</td>
                        
                        <td>
                          <a class="btn btn-warning" href="Controlador?menu=Productos&accion=Editar&id_producto=${cli.getId()}&precio=${cli.getPrecio()}&nombre=${cli.getNombre()}&stock=${cli.getStock()}&estado=${cli.getEstado()}" >Editar</a>
                          <a class="btn btn-danger" href="Controlador?menu=Productos&accion=Delete&id_producto=${cli.getId()}" >Eliminar</a>
                        </td>
                    </tr>
                    </c:forEach>
                   
                    
                </tbody>

            </table>
        </div>

        </div>
       

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
