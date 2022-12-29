<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/3786983018.js" crossorigin="anonymous"></script>
        <title>Editar Camisetas</title>
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"/>

        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idCamiseta=${camiseta.idCamiseta}" method="POST" class="was-validated">
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>
            <section id="details">
                <div class="container">
                    <div clas="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar Camisetas</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="equipo">Equipo</label>
                                        <input type="text" class="form-control" name="equipo" value="${camiseta.equipo}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="pais">País</label>
                                        <input type="text" class="form-control" name="pais" value="${camiseta.pais}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo">Tipo</label>
                                        <input type="text" class="form-control" name="tipo" value="${camiseta.tipo}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="talle">Talles</label>
                                        <input type="text" class="form-control" name="talle" value="${camiseta.talle}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="año">Año</label>
                                        <input type="number" class="form-control" name="año" value="${camiseta.año}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="valor">Valor</label>
                                        <input type="number" class="form-control" name="valor" value="${camiseta.valor}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="stock">Stock</label>
                                        <input type="number" class="form-control" name="stock" value="${camiseta.stock}" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <jsp:include page="../comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>