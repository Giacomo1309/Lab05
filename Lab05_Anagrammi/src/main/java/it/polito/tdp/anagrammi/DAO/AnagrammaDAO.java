package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ConnectDB;
import it.polito.tdp.anagrammi.model.*;

public class AnagrammaDAO {
	Set<String> vocabolario = new HashSet<String>();

/*
 * 	public Set<String> ottieniVocabolario() {final String sql = "SELECT * FROM parola";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("nome"));
				vocabolario.add(rs.getString("nome"));

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return vocabolario;
	}
 */

	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT * FROM parola where nome=? ";
		boolean returnValue = false;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			if (rs.next())
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

		return returnValue;

	}
		//public boolean provo(String anagramma) {
		
		//	return vocabolario.contains(anagramma);

		//	}
}