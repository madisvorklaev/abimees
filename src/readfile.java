import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class readfile {
    String name;
    double power = 0;
    double voolutarve = 0;
    double voolKokku = 0;
    int channels = 0;
    int dmx = 0;
    int dmxUniv = 0;


    public void createDatabase() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            // System.out.println("Openeeeed database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE DEVICES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " POWER            DOUBLE     NOT NULL, " +
                    " CHANNELS        INT)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //  System.out.println("Table created successfully");

    }

    private Scanner x;

    public void openFile() {
        try {
            x = new Scanner(new File("data.txt"));
        } catch (Exception e) {
            System.out.println("Faili ei leitud");
        }
    }

    public void readFile() {
        boolean tableExists = false;
        while (x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String d = x.next();
            String e = x.next();
            String value = "VALUES (" + a + ", '" + b + "', " + d + ", " + e + " );";
            sql(value);
            // System.out.printf("%s %s %s %s\n", a, b, d, e);
            // String device[] = {a, b, d, e};


        }
    }


    public void closeFile() {
        x.close();
    }


    public void sql(String value) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Opened database successfully");

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            Statement stmt = null;
            c.setAutoCommit(false);
            //  System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO DEVICES (ID,NAME,POWER,CHANNELS) " +
                    value;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //  System.out.println("Records created successfully");
    }

    public void getTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            c.setAutoCommit(false);
            //  System.out.println("Opened database successfully");
            Statement stmt = null;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DEVICES;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double power = rs.getDouble("power");
                int channels = rs.getInt("channels");
                System.out.println(id + " " + name);
                   /* System.out.println( "NAME = " + name );
                    System.out.println( "POWER = " + power );
                    System.out.println( "CHANNELS = " + channels );
                    System.out.println(); */
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Operation done successfully");
    }

    public void getValues(int devNumber) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            c.setAutoCommit(false);
            //  System.out.println("Opened database successfully");
            Statement stmt = null;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DEVICES;");
            while (rs.next()) {
                if (devNumber == rs.getInt("id")) {
                    //int id = rs.getInt("id");
                    name = rs.getString("name");
                    power = rs.getDouble("power");
                    channels = rs.getInt("channels");
                    System.out.println("NAME = " + name);
                    System.out.println("POWER = " + power);
                    System.out.println("CHANNELS = " + channels);
                    System.out.println();
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Operation done successfully");
    }

    public void paljuVoolu(int mituSeadet) {
        voolutarve = power * mituSeadet;
        System.out.println(mituSeadet + "tk " + name + " võtab voolu " + voolutarve + "A.");
        voolKokku = voolKokku + voolutarve;
        System.out.println("Kogutarbivus " + voolKokku + "A või " + voolKokku / 3 + "A per faas või " + voolKokku * 230 + "W");
    }

  /*  public void dmx(int mituSeadet) {
        dmx = dmx + channels * mituSeadet;
        if ((dmxUniv + dmx / 512) % > 5) {
            dmxUniv = dmxUniv + dmx / 512;
        } else {
            dmxUniv = dmxUniv + dmx + 1;
        }
        System.out.println(dmx + " " + dmxUniv);


    } */
}



