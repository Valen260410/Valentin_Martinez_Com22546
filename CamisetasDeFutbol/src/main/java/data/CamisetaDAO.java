package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Camiseta;

public class CamisetaDAO {
    private static final String SQL_SELECT = "SELECT * FROM camisetas_futbol.camisetas";
    
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM camisetas_futbol.camisetas WHERE idCamiseta = ?";
   
    private static final String SQL_INSERT = "INSERT INTO camisetas_futbol.camisetas (equipo, pais, tipo, talle, año, valor, stock) VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE camisetas_futbol.camisetas SET equipo = ?, pais = ?, tipo = ?, talle = ?, año = ?, valor = ?, stock = ? WHERE idCamiseta = ?";
    
    private static final String SQL_DELETE = "DELETE FROM camisetas_futbol.camisetas WHERE idCamiseta = ?";
   
    
    public List <Camiseta> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Camiseta camiseta = null;
        List<Camiseta> Camisetas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCamiseta = rs.getInt(1);
                String equipo = rs.getString("equipo");
                String pais = rs.getString("pais");
                String tipo = rs.getString("tipo");
                String talle = rs.getString("talle");
                int año = rs.getInt("año");
                double valor = rs.getDouble("valor");
                int stock = rs.getInt("stock");

                camiseta = new Camiseta(idCamiseta, equipo, pais, tipo, talle, año, valor, stock);

                Camisetas.add(camiseta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return Camisetas;
    }
    
    public int insertar(Camiseta camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, camiseta.getEquipo());
            stmt.setString(2, camiseta.getPais());
            stmt.setString(3, camiseta.getTipo());
            stmt.setString(4, camiseta.getTalle());
            stmt.setInt(5, camiseta.getAño());
            stmt.setDouble(6, camiseta.getValor());
            stmt.setInt(7, camiseta.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Camiseta camiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, camiseta.getEquipo());
            stmt.setString(2, camiseta.getPais());
            stmt.setString(3, camiseta.getTipo());
            stmt.setString(4, camiseta.getTalle());
            stmt.setInt(5, camiseta.getAño());
            stmt.setDouble(6, camiseta.getValor());
            stmt.setInt(7, camiseta.getStock());
            stmt.setInt(8, camiseta.getIdCamiseta());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
//    
//    public int actualizarNombre(String username,String newname){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registros = 0;
//        Users user = seleccionarPorNombre(username);
//        user.setUsername(newname);
//        try {
//            conn = getConexion();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            stmt.setInt(3, user.getIduser());
//            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
//        finally{
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return registros;
//    }
    
     public int eliminar(int idCamiseta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, idCamiseta);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
    public Camiseta seleccionarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Camiseta camiseta = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idCamiseta = rs.getInt("idCamiseta");
                String equipo = rs.getString("equipo");
                String pais = rs.getString("pais");
                String tipo = rs.getString("tipo");
                String talle = rs.getString("talle");
                int año = rs.getInt("año");
                double valor = rs.getDouble("valor");
                int stock = rs.getInt("stock");

                camiseta = new Camiseta (idCamiseta, equipo, pais, tipo, talle, año, valor, stock);
                            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return camiseta;
    }
}
