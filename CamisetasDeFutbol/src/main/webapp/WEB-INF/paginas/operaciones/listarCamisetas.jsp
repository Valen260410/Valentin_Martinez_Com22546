<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_AR"/>
<section id="camisetas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card mb-4">
                    <div class="card-header">
                        <h4>Listado de Camisetas</h4>
                    </div>                   
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Equipo</th>
                                <th>Pais</th>
                                <th>Tipo</th>
                                <th>Talles</th>
                                <th>Año</th>
                                <th>Valor</th>
                                <th>Stock</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="camiseta" items="${camisetas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${camiseta.equipo}</td>
                                    <td>${camiseta.pais}</td>
                                    <td>${camiseta.tipo}</td>
                                    <td>${camiseta.talle}</td>
                                    <td>${camiseta.año}</td>
                                    <td><fmt:formatNumber value="${camiseta.valor}" type="currency"/></td>
                                    <td>${camiseta.stock}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idCamiseta=${camiseta.idCamiseta}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad total de modelos</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${cantEquipos}</h4>
                    </div>
                </div>
                
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Stock total de camisetas</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${stockTotal}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarCamisetas.jsp"/>