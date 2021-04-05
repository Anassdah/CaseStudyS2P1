package Model.backend;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 */
public class Dossier extends ArrayList {
    static Random rand = new Random();
    String name;

    /**
     * Default constructor
     */
    public Dossier(String name) {
        this.add(name);
    }

    /**
     *
     */


    /**
     *
     */
    public static void afficher() {boolean check=false;
        Scanner clavier1 = new Scanner(System.in);
        System.out.println("entrez le nom du dossier que vous voulez afficher:");
        String nom = clavier1.nextLine();
        for (Object elt : Disque.disqueLocal.keySet()) {
            if (elt instanceof Dossier) {
                if (((Dossier) elt).contains(nom)) {check=true;
                    System.out.println("nom du dossier: " + nom + " ,taille du dossier: "
                            + Disque.disqueLocal.get(elt));
                }
            }


        } if(!check) System.out.println("ce dossier n'existe pas");
    }

    /**
     *
     */
    public int getTaille() {
        int taille = 0;
        for (Object elt : this) {
            if (elt instanceof Fichier) {
                taille += ((Fichier) elt).taille;
            }


        }
        return taille+rand.nextInt(2000)+89;
    }


    /**
     *
     */
    public static void modifier() {
        Scanner clavier1 = new Scanner(System.in);
        System.out.println("Entrez le nom du dossier à modifier:");
        String nom = clavier1.nextLine();
        for (Object elt : Disque.disqueLocal.keySet()) {
            if (elt instanceof Dossier) {
                if (((Dossier) elt).contains(nom)) {
                    System.out.println("Entrez le nouveau nom");
                    nom = clavier1.nextLine();
                    ((Dossier) elt).set(0, nom);
                    System.out.println("le nom du dossier a été modifié");
                    break;
                }
            }
        }
        // TODO implement here
    }

    /**
     *
     */
    public static void supprimer() {boolean check=false;
        Scanner clavier1 = new Scanner(System.in);
        System.out.println("Entrez le nom du dossier à supprimer:");
        String nom = clavier1.nextLine();
        for (Object elt : Disque.disqueLocal.keySet()) {
            if (elt instanceof Dossier) {
                if (((Dossier) elt).contains(nom)) {
                    Disque.disqueLocal.remove(elt);
                    check=true;
                    System.out.println("le dossier " + nom + " est supprimé");
                    break;

                }
            }
        }
        if(!check) {
            System.out.println("le dossier que vous voulez supprimé n'existe pas!");
        }


    }

    /**
     *
     */
    public static void ajouterDossier() {
        Scanner clavier1=new Scanner(System.in);
        System.out.println("entrez le nom du dossier à ajouter:");
        String nom=clavier1.nextLine();
        Dossier dossier=new Dossier(nom);
        Disque.disqueLocal.put(dossier, rand.nextInt(2000)+89);
        System.out.println("le dossier "+nom+ " a été ajouté avec succès!");
        // TODO implement here
    }

    /**
     *
     */


    public static void ajouterFichier() {Scanner clavier1=new Scanner(System.in);
        System.out.println("Entrez le nom du dossier où vous voulez créer ce fichier:");
        String nom=clavier1.nextLine();
        for (Object elt:Disque.disqueLocal.keySet()) {
            if (elt instanceof Dossier) {
                if (((Dossier) elt).contains(nom)) {
                    System.out.println("Entrez le nom du fichier que vous voulez créer");
                    nom= clavier1.nextLine();
                    Fichier fichier=new Fichier(nom);
                    ((Dossier) elt).add(String.valueOf(fichier.name));
                    System.out.println("le fichier a été crée");
                    break;
                }
                else System.out.println("le dossier n'existe pas!");
            }
        }
    }


}