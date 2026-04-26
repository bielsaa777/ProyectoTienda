package dao;
import java.util.List;
import java.util.ArrayList;
import models.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class PedidoDAO {

    public List<Pedido> getAll() {
		List<Pedido> productos = new ArrayList<>();
		String sql = "SELECT * FROM productos";
		
		try (Connection conn = Conexion.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Pedido p = new Pedido(
						rs.getInt("id"), 
						rs.getInt("idCliente"), 
						rs.getInt("cantidad"),
						rs.getString("fecha")
				);
				
				productos.add(p);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
	}
	
	public boolean add(Pedido p) {
		
		String sql = "INSERT INTO pedidos (id, idCliente, cantidad, fecha) VALUES (?, ?, ?, CURDATE())";
		
		try (Connection conn = Conexion.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getId());
			pstmt.setInt(parameterIndex 2, p.getIdCliente());
			pstmt.setInt(3, p.getCantidad());
			pstmt.setString(parameterIndex 4, p.getFecha());

			return pstmt.executeUpdate() > 0;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
