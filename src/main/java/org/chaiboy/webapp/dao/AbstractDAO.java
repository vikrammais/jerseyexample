package org.chaiboy.webapp.dao;

import java.sql.*;

import static java.lang.System.out;

/**
 * Created by Vikram Aditya on 6/23/2017.
 */
public class AbstractDAO {

    public Connection createConnection() throws Exception {
        try {
            String url = getConnectioinURL();
            String databaseName = "lexxington";
            String instanceConnectionName = "userauthentication-171608:asia-northeast1:myinstance";
            String jdbcUrl = String.format("jdbc:google:mysql://userauthentication-171608:asia-northeast1:myinstance/lexxington?user=root&amp;password=sherlock");
//            String jdbcUrl = String.format(
//                    "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
//                            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
//                    databaseName,
//                    instanceConnectionName);
            url = "jdbc:mysql://104.198.114.105:3306/lexxington";
//            url = "jdbc:mysql://localhost:3306/lexxington";
//            return DriverManager.getConnection(jdbcUrl, "root");
            System.out.println("url :" + url);


//            Connection ct = DriverManager.getConnection("jdbc:google:mysql://104.198.114.105:3306/lexxington", "root", "sherlock");;

            return  DriverManager.getConnection(url, "root", "sherlock");
        } catch (SQLException e) {
            throw new Exception("SQL error", e);
        }
    }

    private String getConnectioinURL() throws Exception {
        String url;
//        if (System.getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
//            url = System.getProperty("ae-cloudsql.cloudsql-database-url");
            url = "jdbc:mysql://104.198.114.105:3306/lexxington";
//            url = "jdbc:google:mysql://userauthentication-171608:asia-northeast1:myinstance/lexxington?user=root&password=sherlock";
//            try {
//                Class.forName("com.mysql.jdbc.GoogleDriver");
//            } catch (ClassNotFoundException e) {
//                throw new Exception("Error loading Google JDBC Driver", e);
//            }
//        } else {

//            url = System.getProperty("ae-cloudsql.local-database-url");
//            url = "jdbc:mysql://google/lexxington?cloudSqlInstance=userauthentication-171608:asia-northeast1:myinstance&amp;socketFactory=com.google.cloud.sql.mysql.SocketFactory&amp;user=root&amp;password=sherlock&amp;useSSL=false";
//        }
        return url;
    }

}
