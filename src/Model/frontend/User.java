package Model.frontend;

import java.util.*;

import static java.util.Arrays.*;

/**
 * 
 */
public class User extends Personne {

    /**
     * Default constructor
     */

    public static boolean sauthentifer() {
        int count = 0;
        Scanner login = new Scanner(System.in);
        System.out.println("entrez votre username:");
        String username = login.nextLine();
        for (int i = 0; i < 40; i++) {
            if (username.equals(Admin.matriceUser[i][0])) {
                System.out.println("Entrez votre mot de passe");
                break;
            }
            count++;


        }
        if (count == 40) {
            System.out.println("ce username n'existe pas!");
            return false;
        }
        String password = login.nextLine();
        if (password.equals(Admin.matriceUser[count][1])) {
            return true;}
        System.out.println("wrong password");
        return false;

        }

        /**
         *
         */
    }
