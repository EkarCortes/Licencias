package DaoBD;

import java.sql.Connection;//permite conectar a la base de datos
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoBD {

    private Connection Connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    
    public DaoBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el Driver");
        }
    }    

    public void connect() {
        try {
            this.Connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/licencias", "root", "");
        } catch (SQLException ex) {
            System.out.println("Error al conectar" + ex.toString());
        }
    }

    public void createStatement(String sql) {
        try {
            this.statement = this.Connection.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia" + ex.toString());
        }
        
    }

    public void set(int index, Object param) {
        try {
            this.statement.setObject(index, param);
        } catch (SQLException ex) {
            System.out.println("Error al agregar parámetro" + ex.toString());
        }
    }

    public boolean execute(boolean result) {
        if (result) {
            try {
                this.resultset = this.statement.executeQuery();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar" + ex.toString());
                return false;
            }
        } else {
            try {
                return this.statement.executeUpdate() > 0;
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar" + ex.toString());
                return false;
            }
            
        }
    }

    public ResultSet getData() {        
        return this.resultset;
        
    }
}
        