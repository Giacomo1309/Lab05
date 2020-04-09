package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.polito.tdp.anagrammi.DAO.ConnectDB;
import it.polito.tdp.anagrammi.model.*;



public class AnagrammaDAO {

	
		public boolean isCorrect(String anagramma) {

				final String sql = "SELECT * FROM parola";
				boolean returnValue = false;

				try {
					Connection conn = ConnectDB.getConnection();
					PreparedStatement st = conn.prepareStatement(sql);
					
					ResultSet rs = st.executeQuery();

					while (rs.next()) {
					//	System.out.println(rs.getString("nome"));
						if(anagramma.compareTo(rs.getString("nome"))==0)
							return true;
					//	Corso corso = new Corso(rs.getString("codins"), rs.getString("nome"), rs.getInt("crediti"), rs.getInt("pd"));
					//	corsi.add(corso);
					}
					conn.close();

				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("Errore Db");
				}

		return false;
}
}
