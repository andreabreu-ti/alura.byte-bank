package br.com.alura.bytebank;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	public Connection recuperarConexao() {
		try {
			
			return createDataSource().getConnection();
			
			/*return DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/alura.byte_bank?user=postgres&password=admin");
			*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private HikariDataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/alura.byte_bank");
		config.setUsername("postgres");
		config.setPassword("admin");
		config.setMaximumPoolSize(10); //Máximo de conexões disponíveis

		return new HikariDataSource(config);
	}
}
