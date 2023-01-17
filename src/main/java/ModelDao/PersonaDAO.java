package ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Persona;
import Utils.Conexion;

public class PersonaDAO extends Persona {
	/**
	 * Todas las consultas para consultar,eliminar y editar los usuarios
	 */
	private static final String SELECTALL = "SELECT id,nombre `personas`";
	private static final String GETBYID = "SELECT id,nombre FROM personas WHERE id=";
	private final static String SELECTBYDNI = "SELECT id,nombre,edad,dni FROM user WHERE dni LIKE ?";
	private static final String DELETE = "DELETE FROM user WHERE id=?";
	private final static String INSERTINTO = "INSERT INTO personas (nombre) " + "VALUES (?) ";
	private final static String UPDATE = "UPDATE `user` SET `nombre` = ?, `edad` = ?, `dni` = ? WHERE id = ?";

	public PersonaDAO(int id, String nombre) {
		super(id, nombre);

	}
	public PersonaDAO() {
		super();

	}

	public PersonaDAO(Persona p) {
		this.id = p.id;
		this.nombre = p.nombre;

	}
	

	/**
	 * constructor de usuario que devuelve un usuario entero solo con el id
	 * 
	 * @param id
	 */
	public Persona PersonaID(int id) {
		Persona p = null;
		Connection con = Conexion.getConextion();
		// Stament
		if (con != null) {
			try {
				Statement st = con.createStatement();
				String q = GETBYID + id;
				ResultSet rs = st.executeQuery(q);
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.nombre = rs.getString("nombre");
				}
				p= new Persona(id, nombre);
				// this.notas=NotasDao.getNotasbyUser(this.id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public int guardarPersona(Persona p1) {
		int rs = 0;
		Connection con = Conexion.getConextion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(INSERTINTO);
				// q.setInt(1, this.id);
				q.setString(1, p1.getNombre());
				rs = q.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
}
