package Model.frontend;
import Model.backend.*;

import java.util.Scanner;


public class Main {private static int saisie=1;
    public static void main(String[]args){
        /**
         * initialisation des deux administrateurs principaux
         */
        Admin.matriceAdmin[0][0]="Anass";Admin.matriceAdmin[0][1]="Dahchour";
        Admin.matriceAdmin[1][0]="Ferdaous";Admin.matriceAdmin[1][1]="Azhari";
        /**
         * pour tester directement sans créer un utilisateur a partir dun admin
         */
        Admin.matriceUser[0][0]="test";Admin.matriceUser[0][1]="test";
        /**
         *
         */

        System.out.println("Bienvenue");
        /**
         * menu principal
         */
        while(saisie !=0){
        System.out.println("Entrez 1 pour s'authentifier si vous etes un utilisateur");
        System.out.println("Entrez 2 pour s'authentifier si vous etes un administrateur");
        System.out.println("Entrez 0 pour quitter");
        Scanner clavier=new Scanner(System.in);
        saisie =clavier.nextInt();
        if(saisie ==1){
            boolean authentification=User.sauthentifer();

            /** Après authentification du user:*/
            if(authentification){
                /**
                 * menu de l'utilisateur
                 */
                while(saisie !=4){
                System.out.println("Veuillez choisir l'action à effectuer:");
                System.out.println("entrez 1 pour gérer les  fichiers");
                System.out.println("entrez 2 pour gérer les dossiers");
                System.out.println("entrez 3 pour afficher les élements de votre espace disque");
                System.out.println("entrez 4 pour terminer");
                saisie = clavier.nextInt();
                switch(saisie) {
                    case 4:break;
                    case 1:
                        /**
                         * menu de la gestion des fichiers
                         */
                        System.out.println("Veuillez choisir l'action à effectuer concernant les fichiers:");
                        System.out.println("entrez 1 pour ajouter un fichier");
                        System.out.println("entrez 2 pour supprimer un fichier");
                        System.out.println("entrez 3 pour modifier un fichier");
                        System.out.println("entrez 4 pour afficher le nom et la taille d'un fichier");
                        System.out.println("entrez 5 pour retourner vers le menu principal");
                        saisie = clavier.nextInt();
                        switch(saisie){
                            case 1:
                                Fichier.ajouter();
                                break;
                            case 2:
                                Fichier.supprimer();
                                break;
                            case 3:
                                Fichier.modifier();
                                break;
                            case 4:
                                Fichier.afficher();
                                /**
                                 * pour que le programme ne quitte pas le menu du fichier
                                 * (parceque 4 est aussi la condition de sortie du menu de l'utilisateur)
                                 */
                                saisie--;
                                break;
                            case 5:
                                break;
                        }

                        break;
                    case 2:
                        /**
                         * menu de la gestion des dossiers
                         */
                        System.out.println("Veuillez choisir l'action à effectuer concernant les dossiers:");
                        System.out.println("entrez 1 pour créer un dossier");
                        System.out.println("entrez 10 pour ajouter un fichier à un dossier");
                        System.out.println("entrez 2 pour supprimer un dossier");
                        System.out.println("entrez 3 pour modifier un dossier");
                        System.out.println("entrez 4 pour calculer la taille d'un dossier");
                        System.out.println("entrez 5 pour afficher un dossier");
                        System.out.println("entrez 6 pour retourner vers le menu principal");
                        saisie = clavier.nextInt();
                        switch(saisie){
                            case 10:
                                Dossier.ajouterFichier();
                                break;
                            case 1:
                                Dossier.ajouterDossier();
                                break;
                            case 2:
                                Dossier.supprimer();
                                break;
                            case 3:
                                Dossier.modifier();
                                break;
                            case 4:
                                Scanner clavier1 = new Scanner(System.in);
                                System.out.println("Entrez le nom du dossier que vous voulez calculer sa taille:");
                                String nom = clavier1.nextLine();
                                for (Object elt : Disque.disqueLocal.keySet()) {
                                    if (elt instanceof Dossier) {
                                        if (!((Dossier) elt).contains(nom)) {
                                            System.out.println("ce dossier n'existe pas!");
                                            break;
                                        } else System.out.println(((Dossier) elt).getTaille());
                                        break;
                                    }
                                }

                                /**
                                 * pour que le programme revient au menu de l'utilisateur
                                 */
                                saisie--;
                                break;
                            case 5:
                                Dossier.afficher();
                                break;
                            case 6:
                                break;
                        }
                        break;
                    case 3:
                        Element.afficher();
                        break;
                    default:
                        System.out.println("choix invalide");
                        // code block
                }
                }
                System.out.println("à la prochaine!");
            }

        }
        else if(saisie ==2){
            //Admin.sauthentifier();
            /** Après authentification de ladmin:*/
            if(Admin.sauthentifier()){
                /**
                 * menu de l'administrateur
                 */
                while(saisie !=4) {
                    System.out.println("Veuillez choisir l'action à effectuer:");
                    System.out.println("entrez 1 pour inscrire un utilisateur");
                    System.out.println("entrez 2 pour inscrire un administrateur");
                    System.out.println("entrez 3 pour supprimer un utilisateur");
                    System.out.println("entrez 4 pour terminer");
                    saisie = clavier.nextInt();
                    switch (saisie) {
                        case 4:
                            break;
                        case 1:
                            Admin.inscrireUser();
                            break;
                        case 2:
                            Admin.inscrireAdmin();
                            break;
                        case 3:
                            Admin.supprimerUser();
                            break;
                    }
                }
                System.out.println("à la prochaine!");


            }

        }
        else if(saisie ==0) break;
        else System.out.println("choix invalide!");}
        /**
         *message de sortie
         */
        System.out.println("Vous avez quitté le programme");




    }
}
