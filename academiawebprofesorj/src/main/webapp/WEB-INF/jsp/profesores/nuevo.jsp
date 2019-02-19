<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.controller.profesor.ProfesorForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<c:import url="../plantilla/head.jsp"></c:import>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <c:import url="../plantilla/cabecera.jsp"></c:import>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Nuevo Profesor</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
              <div class="panel panel-default">
                        <div class="panel-heading">
                            Formulario de Alta
                        </div>
                        <div class="panel-body">
                        
                            <div class="row">
                                <div class="col-lg-6">
                                <c:if test="${not empty errores}">
									<div class="alert alert-danger">
										<c:forEach var="error" items="${errores}"> 
											<p>${error}</p>
										</c:forEach>
									</div>
								</c:if>
                                    <form role="form" action="./nuevo.html" method="post">
                                        <div class="form-group">
                                            <label>NIF</label>
                                            <input name="nif" class="form-control" value="${formulario.nif}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input name="nombre" class="form-control" value="${formulario.nombre}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Primer Apellido </label>
                                            <input name="apellido1" class="form-control" value="${formulario.apellido1}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Segundo Apellido</label>
                                            <input name="apellido2" class="form-control" value="${formulario.apellido2}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                            <input name="telefono" class="form-control" type="text" value="${formulario.telefono}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input name="email" class="form-control" type="email" value="${formulario.correo}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Titulacion</label>
                                            <input name="titulacion" class="form-control" type="text" value="${formulario.titulacion}">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">Enviar</button>
                                        <button type="reset" class="btn btn-default">Limpiar</button>
                                    </form>
                                </div>
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
            </div>            
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	<c:import url="../plantilla/javascriptPie.jsp"></c:import>
</body>
</html>