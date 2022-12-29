<div class="modal fade" id="agregarCamisetaModal" tabindex="-1" aria-labelledby="agregarCamisetaModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Camisetas</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="equipo">Equipo</label>
                        <input type="text" class="form-control" name="equipo" required/>
                    </div>
                    <div class="form-group">
                        <label for="pais">País</label>
                        <input type="text" class="form-control" name="pais" required/>
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo</label>
                        <input type="text" class="form-control" name="tipo" required/>
                    </div>
                    <div class="form-group">
                        <label for="talle">Talles</label>
                        <input type="text" class="form-control" name="talle" required/>
                    </div>
                    <div class="form-group">
                        <label for="año">Año</label>
                        <input type="number" class="form-control" name="año" required/>
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor</label>
                        <input type="number" class="form-control" name="valor" required/>
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" class="form-control" name="stock" required/>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
