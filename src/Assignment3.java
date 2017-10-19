import java.sql.*;
import java.util.*;

// names of stored procedures: bobbykain_931a()

public class Assignment3 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cpsc408db"; // use database 'cpsc408db'

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "B0bbykain";

    public static void main(String[] args) {
        menu();
    }


    // Example 931a procedure
    public static void callEx931a() {
        Scanner input = new Scanner(System.in);
        System.out.println("We will find a PC whose price is closest to the one you give us.");
        System.out.println("Price: ");
        int price = input.nextInt();
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_931a(?)}");
            cStmt.setInt(1, price);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure " + "{call bobbykain_931a(?)}");
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931a

    // Example 931b procedure
    public static void callEx931b() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the minimun values of the speed, RAM, hard-disk size, and screen size that you will accept for a Laptop.");
        System.out.println("Min Speed: ");
        float speed = input.nextFloat();
        System.out.println("Min RAM: ");
        int ram = input.nextInt();
        System.out.println("Min hard-disk size: ");
        int hd = input.nextInt();
        System.out.println("Min Screen Size: ");
        float screen = input.nextFloat();
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_931b(?, ?, ?, ?)}");
            cStmt.setFloat(1, speed);
            cStmt.setInt(2, ram);
            cStmt.setInt(3, hd);
            cStmt.setFloat(4, screen);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931b

    // Example 931c procedure
    public static void callEx931c() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a manufacturer.");
        System.out.print("Manufacturer: ");
        String manufacturer = input.nextLine();
        char man = manufacturer.charAt(0);
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_931c(?)}");
            cStmt.setString(1, manufacturer);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            /* process second result set */
            if (cStmt.getMoreResults()) {
               ResultSet rs2 = cStmt.getResultSet();
               ResultSetMetaData rsmd2 = rs2.getMetaData();
               System.out.println("Procdure " + "{call bobbykain_931a(?)}");
               System.out.println("Procdure Result:");
               int columnsNumber2 = rsmd2.getColumnCount();
               while (rs2.next()) {
                  for (int i = 1; i <= columnsNumber2; i++) {
                      if (i > 1) System.out.print(",  ");
                      String columnValue2 = rs2.getString(i);
                      System.out.print(columnValue2 + " " + rsmd2.getColumnName(i));
                  }
                  System.out.println("");
               }
            }
            /* process second third set */
            if (cStmt.getMoreResults()) {
               ResultSet rs3 = cStmt.getResultSet();
               ResultSetMetaData rsmd3 = rs3.getMetaData();
               System.out.println("Procdure Result:");
               int columnsNumber3 = rsmd3.getColumnCount();
               while (rs3.next()) {
                  for (int i = 1; i <= columnsNumber3; i++) {
                      if (i > 1) System.out.print(",  ");
                      String columnValue3 = rs3.getString(i);
                      System.out.print(columnValue3 + " " + rsmd3.getColumnName(i));
                  }
                  System.out.println("");
               }
            }
          cStmt.close();
            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931c

    public static void callEx931d() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a budget (total price of a PC and printer, and a minimum speed of the PC.)");
        System.out.println("Budget: ");
        float budget = input.nextFloat();
        System.out.println("Min Speed: ");
        float speed = input.nextFloat();
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_931d(?, ?)}");
            cStmt.setFloat(1, budget);
            cStmt.setFloat(2, speed);
            rs = cStmt.getResultSet();

            String pc_model = rs.getString(1);
            int pc_price = rs.getInt(2);

            float restBudget = budget - pc_price;
            CallableStatement cStmt2 = conn.prepareCall("{call bobbykain_931da(?)}");
            cStmt.setFloat(1, restBudget);

            boolean hadResults = cStmt2.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            cStmt.close();
            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931d

    public static void callEx931e() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a manufacturer, model nubmer, speed, RAM, hd size, and price or a new PC.");
        System.out.println("Manufacturer: ");
        String manufacturer = input.nextLine();
        char man = manufacturer.charAt(0);
        System.out.println("Model Number: ");
        int modelNum = input.nextInt();
        System.out.println("Speed: ");
        float speed = input.nextFloat();
        System.out.println("RAM: ");
        int ram = input.nextInt();
        System.out.println("HD size: ");
        int hd = input.nextInt();
        System.out.println("Price: ");
        int price = input.nextInt();

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_931e(?, ?, ?, ?, ?, ?)}");
            cStmt.setInt(1, modelNum);
            cStmt.setFloat(2, speed);
            cStmt.setInt(3, ram);
            cStmt.setInt(4, hd);
            cStmt.setInt(5, price);
            cStmt.setString(6, manufacturer);
            cStmt.executeUpdate();
            // boolean hadResults = cStmt.execute();
            // if (hadResults) {
            //     rs = cStmt.getResultSet();
            //     ResultSetMetaData rsmd = rs.getMetaData();
            //     System.out.println("Procdure " + "{call bobbykain_931a(?)}");
            //     System.out.println("Procdure Result:");
            //     int columnsNumber = rsmd.getColumnCount();
            //     while (rs.next()) {
            //        for (int i = 1; i <= columnsNumber; i++) {
            //            if (i > 1) System.out.print(",  ");
            //            String columnValue = rs.getString(i);
            //            System.out.print(columnValue + " " + rsmd.getColumnName(i));
            //        }
            //        System.out.println("");
            //     }
            // }
            System.out.println("test");


            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931e

    public static void callEx942a() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a price. We will find a PC whose price is closest to the one you gave us.");
        System.out.println("Price: ");
        int price = input.nextInt();

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_942a(?)}");
            cStmt.setInt(1, price);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            System.out.println("test");


            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931e

    public static void callEx942b() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a maker and model and we will return the price.");
        System.out.println("Maker: ");
        String maker = input.nextLine();
        System.out.println("Model: ");
        int model = input.nextInt();

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_942b(?, ?)}");
            cStmt.setString(1, maker);
            cStmt.setInt(2, model);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }


            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931e

    public static void callEx942c() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a model, speed, ram, hd, and price of a new pc. If it already exists we will let you know.");
        System.out.println("Model: ");
        int model = input.nextInt();
        System.out.println("Speed: ");
        float speed = input.nextFloat();
        System.out.println("Ram: ");
        int ram = input.nextInt();
        System.out.println("HD: ");
        int hd = input.nextInt();
        System.out.println("Price:");
        int price = input.nextInt();

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_942c(?, ?, ?, ?, ?)}");
            cStmt.setInt(1, model);
            cStmt.setFloat(2, speed);
            cStmt.setInt(3, ram);
            cStmt.setInt(4, hd);
            cStmt.setInt(5, price);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }


            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931e

    public static void callEx942d() {
        Scanner input = new Scanner(System.in);
        System.out.println("We will count all the products with a price greater than what you enter.");
        System.out.println("Price: ");
        int price = input.nextInt();

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //  Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //  Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected Successfully.");

            //  Execute a query
            System.out.println("Executing Procedure...");
            stmt = conn.createStatement();

            CallableStatement cStmt = conn.prepareCall("{call bobbykain_942d(?)}");
            cStmt.setInt(1, price);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                rs = cStmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("Procdure Result:");
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                   for (int i = 1; i <= columnsNumber; i++) {
                       if (i > 1) System.out.print(",  ");
                       String columnValue = rs.getString(i);
                       System.out.print(columnValue + " " + rsmd.getColumnName(i));
                   }
                   System.out.println("");
                }
            }
            /* process second result set */
            if (cStmt.getMoreResults()) {
               ResultSet rs2 = cStmt.getResultSet();
               ResultSetMetaData rsmd2 = rs2.getMetaData();
               System.out.println("Procdure " + "{call bobbykain_931a(?)}");
               System.out.println("Procdure Result:");
               int columnsNumber2 = rsmd2.getColumnCount();
               while (rs2.next()) {
                  for (int i = 1; i <= columnsNumber2; i++) {
                      if (i > 1) System.out.print(",  ");
                      String columnValue2 = rs2.getString(i);
                      System.out.print(columnValue2 + " " + rsmd2.getColumnName(i));
                  }
                  System.out.println("");
               }
            }
            /* process second third set */
            if (cStmt.getMoreResults()) {
               ResultSet rs3 = cStmt.getResultSet();
               ResultSetMetaData rsmd3 = rs3.getMetaData();
               System.out.println("Procdure " + "{call bobbykain_931a(?)}");
               System.out.println("Procdure Result:");
               int columnsNumber3 = rsmd3.getColumnCount();
               while (rs3.next()) {
                  for (int i = 1; i <= columnsNumber3; i++) {
                      if (i > 1) System.out.print(",  ");
                      String columnValue3 = rs3.getString(i);
                      System.out.print(columnValue3 + " " + rsmd3.getColumnName(i));
                  }
                  System.out.println("");
               }
            }
            System.out.println("test");


            System.out.println("Procedure Exexuted Successfully.");
        }catch(SQLException se) {
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //  Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //  finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
            }//  nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }//  end finally try
        }//  end try
        System.out.println("Goodbye!");
    } //  End of example 931e


    public static void menu()
    {
        //Complete exercises 9.3.1, 9.4.2, and 9.6.1. Extra Credit: 9.3.1 (d)
        System.out.println("Welcome to Akash and Bobby's Homework");
        char part;

        for (int i = 0; i < 100; i++) {
            System.out.println("______________________________________\n\n");
            System.out.println("\n");
            System.out.println("(a) Exercise 9.3.1 [Parts a - c, e]");
            System.out.println("(b) Exercise 9.4.2 [Parts a - d]");
            System.out.println("(c) Exercise 9.3.1 d [Extra Credit]");
            System.out.println("Enter [exit] to quit.");
            char choice = getResponse("Exercise", false); // a,b,c,d or x
            if (choice == 'g') {
                System.out.println("Bye, thanks for playing.");
                break;
            }
            while (choice == 'x') {
                choice = getResponse("Exercise", true);
            }
            System.out.println("-----------------------------------------------");
            if (choice == 'a') {
                System.out.println("Exercise 9.3.1 [parts a - c, e]");
                part = getResponse("Part", false);
                while (part == 'x') {
                    part = getResponse("Part", true);
                }
                System.out.println("Exercise 9.3.1: " + part);
                Exercise931(part);
                //Call Exercise931(choice);
            } else if (choice == 'b') {
                System.out.println("Exercise 9.4.2 [parts a - d]");
                part = getResponse("Part", false);
                while (part == 'x') {
                    part = getResponse("Part", true);
                }
                System.out.println("Exercise 9.4.2: " + part);
                Exercise942(part);
                //Call Exercise942(choice);
            } else if (choice == 'c') {
                System.out.println("Exercise 9.3.1 d");
                //Call Exercise931d;
            } else if (choice == 'd') {
                //Exercise931(d);
            }
        }
    } //  End of Menu

    public static void Exercise931(char part) {
        if (part == 'a') {
            callEx931a();
        } else if (part == 'b') {
            callEx931b();
        } else if (part == 'c') {
            callEx931c();
        } else if (part == 'd') {
            //callEx931d();
        } else if (part == 'e') {
            callEx931e();
        }
    }

    public static void Exercise942(char part) {
        if (part == 'a') {
            callEx942a();
        } else if (part == 'b') {
            callEx942b();
        } else if (part == 'c') {
            callEx942c();
        } else if (part == 'd') {
            callEx942d();
        }
    }

    public static char getResponse (String specific, boolean enteredWrongInput) {
        Scanner input = new Scanner(System.in);
        if (enteredWrongInput) {
            System.out.println("Please enter a valid choice.");
        }
        System.out.println("Please select which " + specific + " you would like to test");
        String selection = input.nextLine();
        if (selection.equals("exit")) {
            return 'g';
        }
        char choice = selection.charAt(0);
        if (choice == 'a' || choice == 'b' || choice == 'c' || choice == 'd' || choice == 'e') {
            return choice;
        } else {
            return 'x'; // throw error here
        }
    }  //  End of getResponse*/

} //  End of Assignment Last Parantheses
