/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easypos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author deepalsuranga
 */
public class DBB {

    public static Connection c;

    public static String ip="localhost";
    public static String port="3306";
    public static String dbName="wariyapola_rice_mill_july_24";
    public static String un="root";
    public static String pw="dcs2019";
    public static String CDPort;
    public static String machineType;
    public static boolean autoAddInvoiceItem;

    public static Connection mlwsConnection() throws Exception {

        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName + "?autoReconnect=true", "" + un + "", "" + pw + "");

        }
        return c;
    }

    public static int SUD(String query) throws Exception {
        int ret = 0;
        if (c == null) {
            mlwsConnection();
        }
        ret = c.createStatement().executeUpdate(query);

        return ret;
    }

    public static ResultSet Search(String query) throws Exception {
        if (c == null) {
            mlwsConnection();
        }
        ResultSet rs = c.createStatement().executeQuery(query);
        return rs;

    }

    public static int SUDwithKeys(String query) throws Exception {
        int ret = 0;
        if (c == null) {
            mlwsConnection();
        }
        Statement stmt = c.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            ret = rs.getInt(1);
        }

        return ret;
    }
}
