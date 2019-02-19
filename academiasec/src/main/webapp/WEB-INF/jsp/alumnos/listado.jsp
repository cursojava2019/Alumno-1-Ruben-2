<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.model.entities.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 
  String texto="Texto muy guay";
  session.setAttribute("texto", texto);
 
 %>
   
    
<c:if test="${param.mensaje eq 'correcto'}">
 <c:set var="mensajeOK" value="true" ></c:set>
</c:if>

<c:if test="${param.mensaje=='errorId'}">
 <c:set var="mensajeError" value="true" ></c:set>
</c:if>
<!DOCTYPE html>
<html>
<c:import url="../plantilla/head.jsp"></c:import>

<body>

<c:out  value=""></c:out>
	<script>
	function confirmarEliminacion(id){
		if (confirm("¿Está seguro que desea eliminar este alumno?")){
			location.href='${ruta}/admin/alumnos/eliminar.html?id='+id;
		}
		
		
	}
	</script>
    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="../plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Alumnos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">
                        <c:if test="${mensajeOK}">
                             <div class="alert alert-success" id="mensaje">
                               Operación realizada correctamente
                            </div>
                        </c:if>
                            <c:if test="${mensajeError}">
                        <div class="alert alert-danger" id="mensaje">
                               Id no encontrado. No es posible realizar la operación.
                            </div>
                            </c:if>
                            
                            
                        <div class="panel-heading">
                            Listado de Alumnos
                        </div>
                        
                        <form name="buscador" action="./listado.html" method="post">
                        <div class="">
                        <div class="col-6">
                        <label>Buscar Alumno</label>
                        </div>
                        <div style="float:right;">  <button class="btn btn-default"  onclick="location.href='<%=request.getContextPath()%>/admin/alumnos/nuevo.html';" type="button"><i class="fa fa-user"> Nuevo Usuario</i>
                                                </button></div>
                        <div class="col-6">
                                            <input class="" name="patron" type="text" value="${param.patron}">
                                            <span class="">
                                                <button class="btn btn-default" type="submit"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                            <c:if test="${not empty param.patron}">
                                            
                                            <span>Busqueda filtrada por <strong>${param.patron} </strong></span>
                                            
                                           </c:if>
                                            </div>
                                        </div>
                                        
                                        
                        </form>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>DNI</th>
                                        <th>Telefono</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="alumno" items="${listado}"> 
                               
                                    <tr class="odd gradeX">
                                        <td>${alumno.nombre}</td>
                                        <td>${alumno.apellido1} ${alumno.apellido2}</td>
                                        <td>${alumno.nif}</td>
                                        <td>${alumno.telefono}</td>
                                        <td ><a href="${ruta}/admin/alumnos/modificar.html?id=${alumno.id}">Modificar</a> <a href="#" onclick="confirmarEliminacion(${alumno.id})">Eliminar</a></td>
                                    </tr>
                              </c:forEach>   
                                </tbody>
                            </table>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="../plantilla/javascriptPie.jsp" %>
	 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        setTimeout(function() {
            $("#mensaje").toggle(2000);
        },3000);
    });
    
    
   
    </script>
    </script>
	
</body>
</html>