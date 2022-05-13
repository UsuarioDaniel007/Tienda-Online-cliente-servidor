<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>VENTAS</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <h1>Registro de ventas!</h1>
        <div class ="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            
                            <div class="form-group">
                                <label>Datos del cliente </label>
                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-8 d-flex">
                                    <input type="text" name="codigocliente" value="${Cliente.getMatricula()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="Buscarcliente" class="btn btn-outline-info">Buscar</button>
                                </div>                          
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="nombrecliente" value="${Cliente.getNombre()}" placeholder="Cliente" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del producto </label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="Buscarproducto" class="btn btn-outline-info">Buscar</button>

                                </div>

                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nombreproducto" value="${producto.getNombre()}" placeholder="Datos" class="form-control">
                                </div>
                            </div>

                            <div class="form-group d-flex">   
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="S/.0.00">

                                </div>

                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant"  placeholder="" class="form-control">

                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="text" name="Stock"  value="${producto.getStock()}"placeholder="Stock" class="form-control">

                                </div>
                            </div>
                                    
                            <!-- Boton agregar prducto al registro-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn-outline-info">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card" >
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>serie</label> 
                            <input type="text" name="NroSerie"  class="form-control">

                        </div> 
                        <br>
                        <table class="table table-hover">

                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${lista}">

                                    <tr>
                                        <td>${lista.getItem()}</td>
                                        
                                        <td>${lista.getDescripcionP()}</td>
                                        <td>${lista.getPrecio()}</td>
                                        <td>${lista.getCantidad()}</td>
                                        <td>${lista.getSubtotal()}</td> 
                                        <td>
                          
                          <a  href="#" class="btn btn-danger" style="margin-left: 10px" >Eliminar</a>
                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col-sm-6">
                             <a href="Controlador?menu=NuevaVenta&accion=Generarventa" onclick="print()" class="btn btn-success">Generar Venta </a>
                             <button href="Controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-danger">Cancelar</button>

                        </div> 
                        </div>
                        
                        <div class="col-sm-6 ml-auto d-flex">
                            <label class=" col-sm-6 text-right mt-2">Total a pagar</label>
                            <input type="text" name="txtTotal" value="$ ${totalpagar}" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
