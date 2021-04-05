package Model.frontend;

import java.util.*;

/**
 * 
 */
public class Admin extends Personne {
    static String[][]matriceUser=new String[40][2];
    static String[][]matriceAdmin=new String[20][2];
    private static int i=0;
    /**
     *
     */
    public static void inscrireUser() {int counter=0;
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom du nouveau utilisateur:");
        String name= clavier1.nextLine();
        for (int i = 0; i < 40; i++) {
            if (name.equals(Admin.matriceUser[i][0])) {
                System.out.println("l'utilisateur existe déjà");
                break;
            }counter++;
        }
        if(counter==40) {
            matriceUser[i][0] = name;
            System.out.println("entrez son mot de passe");
            matriceUser[i][1] = clavier1.nextLine();
            i++;
            System.out.println("l'utilisateur " + matriceUser[i - 1][0] + " est inscrit avec succés");
        }

    }

    /**
     *
     */
    public static void inscrireAdmin() {int counter=0;
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom du nouveau administrateur:");
        String name= clavier1.nextLine();
        for (int i = 0; i < 20; i++) {
            if (name.equals(Admin.matriceAdmin[i][0])) {
                System.out.println("Cette administrateur existe déjà");
                break;
            }counter++;
        }
        if(counter==20) {
            matriceAdmin[i][0] = name;
            System.out.println("entrez son mot de passe");
            matriceAdmin[i][1] = clavier1.nextLine();
            i++;
            System.out.println("l'administrateur " + matriceAdmin[i - 1][0] + " est inscrit avec succés");
        }
    }

    /**
     *
     */
    public static void supprimerUser() {int count=0;
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom de l'utilisateur que vous voulez supprimer");
        String name=clavier1.nextLine();
        for (int i = 0; i < 40; i++) {
            if (name.equals(Admin.matriceUser[i][0])) {Admin.matriceUser[i][0]=null;
                System.out.println("L'Utilisateur "+name+" est supprimé");
                break;
            }
            count++;


        }
        if (count == 40) {
            System.out.println("ce username n'existe pas!");}


        // TODO implement here
    }

    /**
     *
     */
    public static boolean sauthentifier() {
        int count = 0;
        Scanner login = new Scanner(System.in);
        System.out.println("entrez votre username:");
        String username = login.nextLine();
        for (int i = 0; i < 20; i++) {
            if (username.equals(Admin.matriceAdmin[i][0])) {
                System.out.println("Entrez votre mot de passe");
                break;
            }
            count++;


        }
        if (count == 20) {
            System.out.println("ce username n'existe pas!");
            return false;
        }
        String password = login.nextLine();
        if (password.equals(Admin.matriceAdmin[count][1])) {
            return true;}
        System.out.println("wrong password");
        return false;
        // TODO implement here
    }

}