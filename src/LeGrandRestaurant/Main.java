package LeGrandRestaurant;

import LeGrantRestaurant.Test.Utilities.ServeurBuilder;
import LeGrantRestaurant.Test.Utilities.ServeurGenerator;
import com.sun.tools.jconsole.JConsoleContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ServeurBuilder builder = new ServeurBuilder();
        ArrayList<Serveur> list = new ArrayList<>();
        list.add(builder.Build());
        list.add(builder.Build());
        Serveur[] serveurs = list.toArray(new Serveur[0]);
        serveurs[0].PrendreCommande(50);
        System.out.println(serveurs[0].ChiffreAffaires);
        System.out.println(serveurs[1].ChiffreAffaires);

        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/gleb/epsi/tests-unitaires/testjava.db");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                                " (name TEXT, phone INTEGER, email TEXT)") ;


//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Joe', 444444, 'joe@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Jane', 111111, 'jane@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Dale', 888888, 'dale@email.com')");

//            statement.execute("UPDATE contacts SET phone=000333 WHERE name='Jane'");
            statement.execute("DELETE FROM contacts WHERE name='Jane'");
            statement.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Something went wrong " + e.getMessage());
        }

    }
}