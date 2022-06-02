/*
 * MenuDom Draft.
 *
 * Copyright 2022 Rodney <>
 *
 */

/*                                               Example  Default class not used for now.
public class untitled {
	public static void main (String[] args) {
	}
}
*/
package com.revature.Pi2a1000Places.customer;

import com.revature.Pi2a1000Places.util.ConnectionFactory;
import java.sql.Connection;               // These 4 are the require libraries need to perform features inside them.
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDao {                  // The default required class for code to work.

    public static Menu create(Menu newItem) {           // The typical primary method of the Java code.

        System.out.println("Here is the newItem as it enters our DAO layer: " + newItem);
        // The above, Java knows to invoke the toString() method when printing the object to the terminal

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "add additional selection to the menu (item_name, cost, protein, is_substitutable) values (?, ?, ?, ?)";

            PreparedStatement psmenu = conn.prepareStatement(sql);
            psmenu.setString(1, newItem.getItem_name());
            psmenu.setString(2, newItem.getCost());
            psmenu.setString(3, newItem.getProtein());
            psmenu.setString(4, newItem.getIs_substitutable());

            int checkInsert = psmenu.executeUpdate();
            if (checkInsert == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return newUser;
    }
/* the rest of labels must be changed to process the menu table values*/

    public Boolean pullmenuitem(String iname) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select menu item to substitute =  with?";
            PreparedStatement psmenu = conn.prepareStatement(sql);
            psmenu.setString(1, iname);

            ResultSet rsmenu = psmenu.executeQuery();

            if (!rs.isBeforeFirst()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
/*          For menu transactions this code is not needed yet. Depends on method coded to give menu changing privileges.
                If used in the project, change variables name to correct names and modify method to pass parameters
                    the parameters will handle variables or methods assigned to variables, for menu to be change or substituted.
    }
  */          //  End of code block authenticate values in parameters passed.
}       // End of primary block of code the main.
