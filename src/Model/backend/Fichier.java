package Model.backend;
import java.util.Random;
import java.util.Scanner;


/**
 *
 */
public class Fichier extends Element {
    static Random rand = new Random();
    /**
     * Pour génerer une taille aléatoire
     */
    String name;
    protected int taille;

    /**
     *
     * constructeur
     */

    public Fichier(String name) {this.name=name;this.taille= rand.nextInt(2000);

    }

    public static int getTaille() {
        return rand.nextInt();}
    /**
     *
     */
    public static void afficher() {
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom du fichier que vous voulez afficher:");
        String nom=clavier1.nextLine();
        if(Disque.disqueLocal.containsKey(nom)) {
            System.out.println("nom du fichier: " + nom + " ,taille du fichier: "+Disque.disqueLocal.get(nom));
        }
        else System.out.println("ce fichier n'existe pas");

    }
    /**
     *
     */
    public static void modifier() {
        Scanner clavier1 = new Scanner(System.in);
        System.out.println("entrez le nom du fichier que vous voulez modifier:");
        String nom = clavier1.nextLine();
        if (Disque.disqueLocal.containsKey(nom)) {
            int oldtaille = Disque.disqueLocal.get(nom);
            Disque.disqueLocal.remove(nom);
            System.out.println("Entrez le nouveau nom du fichier:");
            nom = clavier1.nextLine();
            Disque.disqueLocal.put(nom, oldtaille);
            System.out.println("le fichier a été mis à jour");
        } else System.out.println("ce fichier n'existe pas");
    }

    /**
     *
     */
    public static void supprimer() {
        Scanner clavier1=new Scanner(System.in);
        System.out.println("Entrez le nom du fichier à supprimer:");
        String nom=clavier1.nextLine();
        for (Object elt:Disque.disqueLocal.keySet()) {
            if (elt instanceof Dossier) {
                if (((Dossier) elt).contains(nom)) {
                    ((Dossier) elt).remove(nom);
                    System.out.println("le fichier est supprimé");
                    break;
                }
            }
        }
        if(Disque.disqueLocal.containsKey(nom)){Disque.disqueLocal.remove(nom);
            System.out.println("le fichier est supprimé");

        }
        else System.out.println("le fichier que vous voulez supprimé n'existe pas!");

    }

    /**
     *
     */
    public static void ajouter() {
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom du fichier à ajouter:");
        String nom=clavier1.nextLine();
        Fichier fichier=new Fichier(nom);
        Disque.disqueLocal.put(fichier.name, fichier.taille);
        System.out.println(nom+" a été crée avec succès!");



    }

}