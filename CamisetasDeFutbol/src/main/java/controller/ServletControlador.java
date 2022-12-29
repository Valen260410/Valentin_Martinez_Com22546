package controller;

import data.CamisetaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Camiseta;

@WebServlet("/servletControlador")

public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "editar":
                    editarCamisetas(req, res);
                    break;
                case "eliminar":
                    eliminarCamisetas(req, res);
                    break;

                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "insertar":
                    insertarCamisetas(req, res);
                    break;
                case "modificar":
                    modificarCamisetas(req, res);
                    break;

                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    private Integer calcularStock(List <Camiseta> camisetasLista) {
        Integer cantidad = 0;

        for (int i = 0; i < camisetasLista.size(); i++) {
            cantidad += camisetasLista.get(i).getStock();
        }
        return cantidad;
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List <Camiseta> camisetas = new CamisetaDAO().seleccionar();
        camisetas.forEach(System.out::println);

        HttpSession sesion = req.getSession();

        sesion.setAttribute("camisetas", camisetas);
        sesion.setAttribute("cantEquipos", camisetas.size());
        sesion.setAttribute("stockTotal", calcularStock(camisetas));
        res.sendRedirect("camisetas.jsp");
    }

    private void insertarCamisetas(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String equipo = req.getParameter("equipo");
        String pais = req.getParameter("pais");
        String tipo = req.getParameter("tipo");
        String talle = req.getParameter("talle");
        int año = 0, stock = 0;
        double valor = 0;
        String añoString = req.getParameter("año");
        if (añoString != null && !añoString.equals("")) {
            año = Integer.parseInt(añoString);
        }
        String valorString = req.getParameter("valor");
        if (valorString != null && !valorString.equals("")) {
            valor = Double.parseDouble(valorString);
        }
        String stockString = req.getParameter("stock");
        if (stockString != null && !stockString.equals("")) {
            stock = Integer.parseInt(stockString);
        }

        Camiseta camiseta = new Camiseta(equipo, pais, tipo, talle, año, valor, stock);

        int regMod = new CamisetaDAO().insertar(camiseta);

        System.out.println("Registros guardados: " + regMod);

        accionDefault(req, res);
    }

    private void editarCamisetas(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idcamiseta = Integer.parseInt(req.getParameter("idCamiseta"));

        Camiseta camiseta = new CamisetaDAO().seleccionarPorId(idcamiseta);

        req.setAttribute("camiseta", camiseta);
        String jspEditar = "WEB-INF/paginas/operaciones/editarCamisetas.jsp";

        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarCamisetas(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idCamiseta = Integer.parseInt(req.getParameter("idCamiseta"));
        String equipo = req.getParameter("equipo");
        String pais = req.getParameter("pais");
        String tipo = req.getParameter("tipo");
        String talle = req.getParameter("talle");
        int año = 0, stock = 0;
        double valor = 0;
        String añoString = req.getParameter("año");
        if (añoString != null && !añoString.equals("")) {
            año = Integer.parseInt(añoString);
        }
        String valorString = req.getParameter("valor");
        if (valorString != null && !valorString.equals("")) {
            valor = Double.parseDouble(valorString);
        }
        String stockString = req.getParameter("stock");
        if (stockString != null && !stockString.equals("")) {
            stock = Integer.parseInt(stockString);
        }

        Camiseta camiseta = new Camiseta(idCamiseta, equipo, pais, tipo, talle, año, valor, stock);

        int regMod = new CamisetaDAO().actualizar(camiseta);

        System.out.println("Registros actualizados: " + regMod);

        accionDefault(req, res);
    }
    
    private void eliminarCamisetas(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int idCamiseta = Integer.parseInt(req.getParameter("idCamiseta"));
        
        int regBorrados = new CamisetaDAO().eliminar(idCamiseta);
        
        System.out.println("Registros eliminados: "+ regBorrados);
        
        accionDefault(req, res);
    }
}
