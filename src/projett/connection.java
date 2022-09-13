package projett;

import java.sql.*;
import javax.swing.JOptionPane;

public class connection {

    static PreparedStatement connectbd(String select__from_article_WHERE_Designation_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Connection conn = null;

    public static Connection connectbd() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/serniehkdb", "root", "");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
