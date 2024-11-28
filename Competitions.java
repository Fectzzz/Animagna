import java.util.Random;
import java.util.Scanner;

public class Competitions {
    // Codes ANSI pour les couleurs
    public static final String RESET = "\u001B[0m"; // Réinitialiser la couleur
    public static final String RED = "\u001B[31m";  // Couleur Rouge
    public static final String GREEN = "\u001B[32m"; // Couleur Verte
    public static final String YELLOW = "\u001B[33m"; // Couleur Jaune
    public static final String BLUE = "\u001B[34m"; // Couleur Bleu
    public static final String PURPLE = "\u001B[35m"; // Couleur Violette
    public static final String CYAN = "\u001B[36m"; // Couleur Cyan
    public static final String WHITE = "\u001B[37m"; // Couleur Blanche

    @SuppressWarnings({ "resource", "unlikely-arg-type" })
    public static void StartCombat(String name) throws InterruptedException {
        // Est-ce qu'il a des créatures ?
        if (Main.listeCreaturesPossédés.isEmpty()) {
            System.out.println(RED + "Vous n'avez aucune créature pour combattre !" + RESET);
            Thread.sleep(2000);
            return;
        }
    
        // Introduction au combat
        System.out.println(PURPLE + "L'arbitre : Vous êtes prêt à affronter " + name + " ?" + RESET);
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2500);
        System.out.println(YELLOW + "1/ Oui 2/ Non" + RESET);
        String readyInput = sc.nextLine();
    
        // Qu'est-ce qu'il a choisi ?
        if (readyInput.equals("1") || readyInput.equalsIgnoreCase("Oui")) { // Option 1
            System.out.println(PURPLE + "L'arbitre : Alors, commençons !" + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(YELLOW + "Choisissez une créature parmi vos " + RED + Main.listeCreaturesPossédés.size() + YELLOW + " créatures à jouer : " + RESET);
        
            // Afficher toutes les créatures
            for (int i = 0; i < Main.listeCreaturesPossédés.size(); i++) {
                System.out.println((i + 1) + "/ " + Main.listeCreaturesPossédés.get(i));
            }

            // Choisir une créature
            String choiceCreatureInput = sc.nextLine();
            int choiceCreature = Integer.parseInt(choiceCreatureInput) - 1;
            Creatures choiceCreatureFight = Main.listeCreaturesPossédés.get(choiceCreature);
            System.out.println(CYAN + "Vous avez choisi : " + choiceCreatureFight + " !" + RESET);
            Thread.sleep(2000);
            
            // Choix aléatoire de la créature de l'adversaire
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(CYAN + "L'adversaire choisit sa créature..." + RESET);
            Random rand = new Random();
            int n = rand.nextInt(Main.allCreatures.size()); // Index aléatoire
            Creatures chosenCreature = Main.allCreatures.get(n);
            Thread.sleep(3000);
            System.out.println("L'adversaire a choisi : " + chosenCreature.getName());
            Thread.sleep(2500);

            // Qui commence ?
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(PURPLE + "on va faire un pile ou face pour savoir qui commence !" + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Choisissez entre : 1/ Pile  2/ Face !" + RESET);
            String choicePileFaceInput = sc.nextLine();
            int choicePileFace = Integer.parseInt(choicePileFaceInput);
            int pileFaceRandom = (int)(Math.random() * 2 + 1);
            boolean firstAtFight = false;
            @SuppressWarnings("unused")
            boolean canFight = false;

            // Pile ou Face ?
            if (choicePileFace == 1 || choicePileFaceInput.equalsIgnoreCase("Pile") && pileFaceRandom == 1){
                System.out.println(PURPLE + "Pile ! Vous commencez !" + RESET);
                firstAtFight = true;
                canFight = true;
            } else if (choicePileFace == 2 || choicePileFaceInput.equalsIgnoreCase("Face") && pileFaceRandom == 2){
                System.out.println(PURPLE + "Face ! Vous commencez !" + RESET);
                firstAtFight = true;
                canFight = true;
            } else if (choicePileFace == 2 || choicePileFaceInput.equalsIgnoreCase("Face") && pileFaceRandom == 1){
                System.out.println(PURPLE + "Pile ! L'adversaire commence !" + RESET);
                firstAtFight = false;
                canFight = true;
            } else if (choicePileFace == 1 || choicePileFaceInput.equalsIgnoreCase("Pile") && pileFaceRandom == 2){
                System.out.println(PURPLE + "Face ! L'adversaire commence !" + RESET);
                firstAtFight = false;
                canFight = true;
            } else{
                System.out.println(PURPLE + "Erreur ! Pile ou Face !" + RESET);
                canFight = false;
            }

            // Peut-il évoluer ?
            boolean canEvolve = true;

            // Peut-il évoluer ?
            boolean canEvolveBot = true;

            // While 1
            boolean while1 = false;

            // Boules d'énérgies
            int bouleEnergie = 0;

            // Boucle du jeu
            while (chosenCreature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0) {
                // Si le joueur commence
                if (firstAtFight) {
                    while(!while1){
                        if(chosenCreature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
                            System.out.println(PURPLE + "C'est à vous !" + RESET);
                            Thread.sleep(2000);
                            System.out.println(YELLOW + "Que voulez-vous faire ? 1/Attaquer 2/Charger de la puissance 3/Voir les stats de l'adversaire 4/Évoluer 5/Retraite" + RESET);
                            String choiceFightInput = sc.nextLine();
                            int choiceFight = Integer.parseInt(choiceFightInput);
        
                            // Regarder qu'est-ce qu'il a choisi 
                            if (choiceFight == 1){ // Si il choisi 1 alors il attaque
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous attaquez votre adversaire !" + RESET);
                                chosenCreature.TakeDamage(choiceCreatureFight.getDamage());
                                Thread.sleep(2000);
                                System.out.println(GREEN + "Vous avez infligé " + RED + choiceCreatureFight.getDamage() + GREEN + " de dêgats !" + RESET);
                                Thread.sleep(2000);
                                System.out.println(RED + "L'adversaire n'a plus que " + chosenCreature.getHealth() + " de vies !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                            } else if(choiceFight == 2){ // Si il a choisi 2 alors il charge de la puissance pour le prochain Round
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous chargez de la puissance !" + RESET);
                                Thread.sleep(2000);
                                bouleEnergie++;
                                System.out.println(GREEN + "Vous avec maintenant " + bouleEnergie + " !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                            } else if(choiceFight == 3){ // Si il a choisi 3 alors il regarde les stats de l'adversaire
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous regardez les stats de votre adversaire !" + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Nom : " + chosenCreature.getName() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Type : " + chosenCreature.getType() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Level : " + chosenCreature.getLevel() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "PV : " + chosenCreature.getHealth() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Dêgats : " + chosenCreature.getDamage() + RESET);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                while1 = false;
                            } else if(choiceFight == 4){ // Si il a choisi 4 alors il évolue (si il peut)
                                if (canEvolve && bouleEnergie >= 3) {
                                    // Effacer la console avec des séquences ANSI
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(CYAN + "VOUS ÉVOLUEZ !" + RESET);
                                    Thread.sleep(2000);
                                    int indexChoiceCreatureFight = Main.allCreatures.indexOf(choiceCreatureFight.getName().toLowerCase());
                                    choiceCreatureFight = Main.allCreatures.get(indexChoiceCreatureFight + 1);
                                    System.out.println(GREEN + "Vous êtes maintenant " + choiceCreatureFight.getName() + " !" + RESET);
                                    canEvolve = false;
                                    Thread.sleep(2000);
                                    while1 = true;
                                } else{ // Si il a déjà évolué 
                                    System.out.println(RED + "Vous avez déjà évoluer !" + RESET);
                                    Thread.sleep(2000);
                                    while1 = false;
                                }
                            } else if(choiceFight == 5){ // Si il a choisi 5 alors il se retire...
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous vous retirez !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                                break;
                            } else{ // Si c'est autre chose 
                                System.out.println(RED + "Choix non valide !" + RESET);
                                Thread.sleep(2000);
                                while1 = false;
                            }
                        }else{
                            return;
                        }
                    }
        
                    // ---------------------------- Au tour de l'adversaire ! ------------------------ \\
        
                    if(chosenCreature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
                        // Effacer la console avec des séquences ANSI
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Thread.sleep(2000);
                        System.out.println(PURPLE + "C'est au tour de l'adversaire !" + RESET);
                        Thread.sleep(2000);
                        System.out.println(CYAN + "L'adversaire choisi..." + RESET);
                        Thread.sleep(4000);
                        int choiceFightBotRound;
        
                        if(canEvolveBot && bouleEnergie >= 3){
                            choiceFightBotRound = (int)(Math.random() * 3 + 1);
                        }else{
                            choiceFightBotRound = (int)(Math.random() * 2 + 1);
                        }
                        
                        // Regarder ce qu'il a choisi
                        if (choiceFightBotRound == 1){ // Si c'est 1 il attaque
                        // Effacer la console avec des séquences ANSI
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(RED + "L'adversaire a choisi d'attaquer !" + RESET);
                        Thread.sleep(2000);
                        choiceCreatureFight.TakeDamage(chosenCreature.getDamage());
                        System.out.println(RED + "L'adversaire vous a infligé : " + chosenCreature.getDamage() + " dêgats !" + RESET);
                        Thread.sleep(2000);
                        System.out.println(RED + "Vous n'avez plus que : " + choiceCreatureFight.getHealth() + " PV !" + RESET);
                        Thread.sleep(2000);
                        while1 = false;
                        } else if(choiceFightBotRound == 2){ // Si c'est 2 il charge de l'énergie
                            // Effacer la console avec des séquences ANSI
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println(RED + "L'adversaire charge de l'énergie !" + RESET);
                            chosenCreature.AddDamage(5);
                            Thread.sleep(2000);
                            System.out.println(CYAN + "Dêgats qu'il inflige maintenant : " + chosenCreature.getDamage() + " !" + RESET);
                            Thread.sleep(2000);
                            while1 = false;
                        } else if(choiceFightBotRound == 3){ // Si c'est 3 il évolue !
                            if(canEvolveBot && bouleEnergie >= 3){
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(RED + "L'adversaire ÉVOLUE !" + RESET);
                                Thread.sleep(2000);
                                int indexChoiceCreatureFightBot = Main.allCreatures.indexOf(chosenCreature.getName().toLowerCase());
                                chosenCreature = Main.allCreatures.get(indexChoiceCreatureFightBot + 1);
                                canEvolveBot = false;
                                System.out.println(CYAN + "L'adversaire a évolué en : " + chosenCreature.getName() + " !" + RESET);
                                Thread.sleep(2000);
                                while1 = false;
                            }
                        }
                    } else {
                        return;
                    }

                } else {
                    if(chosenCreature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
                        // Effacer la console avec des séquences ANSI
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Thread.sleep(2000);
                        System.out.println(PURPLE + "C'est au tour de l'adversaire !" + RESET);
                        Thread.sleep(2000);
                        System.out.println(CYAN + "L'adversaire choisi..." + RESET);
                        Thread.sleep(4000);
                        int choiceFightBotRound;
        
                        if(canEvolveBot && bouleEnergie >= 3){
                            choiceFightBotRound = (int)(Math.random() * 3 + 1);
                        }else{
                            choiceFightBotRound = (int)(Math.random() * 2 + 1);
                        }
                        
                        // Regarder ce qu'il a choisi
                        if (choiceFightBotRound == 1){ // Si c'est 1 il attaque
                        // Effacer la console avec des séquences ANSI
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(RED + "L'adversaire a choisi d'attaquer !" + RESET);
                        Thread.sleep(2000);
                        choiceCreatureFight.TakeDamage(chosenCreature.getDamage());
                        System.out.println(RED + "L'adversaire vous a infligé : " + chosenCreature.getDamage() + " dêgats !" + RESET);
                        Thread.sleep(2000);
                        System.out.println(RED + "Vous n'avez plus que : " + choiceCreatureFight.getHealth() + " PV !" + RESET);
                        Thread.sleep(2000);
                        while1 = false;
                        } else if(choiceFightBotRound == 2){ // Si c'est 2 il charge de l'énergie
                            // Effacer la console avec des séquences ANSI
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println(RED + "L'adversaire charge de l'énergie !" + RESET);
                            chosenCreature.AddDamage(5);
                            Thread.sleep(2000);
                            System.out.println(CYAN + "Dêgats qu'il inflige maintenant : " + chosenCreature.getDamage() + " !" + RESET);
                            Thread.sleep(2000);
                            while1 = false;
                        } else if(choiceFightBotRound == 3){ // Si c'est 3 il évolue !
                            if(canEvolveBot && bouleEnergie >= 3){
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(RED + "L'adversaire ÉVOLUE !" + RESET);
                                Thread.sleep(2000);
                                int indexChoiceCreatureFightBot = Main.allCreatures.indexOf(chosenCreature.getName().toLowerCase());
                                chosenCreature = Main.allCreatures.get(indexChoiceCreatureFightBot + 1);
                                canEvolveBot = false;
                                System.out.println(CYAN + "L'adversaire a évolué en : " + chosenCreature.getName() + " !" + RESET);
                                Thread.sleep(2000);
                                while1 = false;
                            }
                        }
                    } else {
                        return;
                    }

                    while(!while1){
                        if(chosenCreature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
                            System.out.println(PURPLE + "C'est à vous !" + RESET);
                            Thread.sleep(2000);
                            System.out.println(YELLOW + "Que voulez-vous faire ? 1/Attaquer 2/Charger de la puissance 3/Voir les stats de l'adversaire 4/Évoluer 5/Retraite" + RESET);
                            String choiceFightInput = sc.nextLine();
                            int choiceFight = Integer.parseInt(choiceFightInput);
        
                            // Regarder qu'est-ce qu'il a choisi 
                            if (choiceFight == 1){ // Si il choisi 1 alors il attaque
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous attaquez votre adversaire !" + RESET);
                                chosenCreature.TakeDamage(choiceCreatureFight.getDamage());
                                Thread.sleep(2000);
                                System.out.println(GREEN + "Vous avez infligé " + RED + choiceCreatureFight.getDamage() + GREEN + " de dêgats !" + RESET);
                                Thread.sleep(2000);
                                System.out.println(RED + "L'adversaire n'a plus que " + chosenCreature.getHealth() + " de vies !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                            } else if(choiceFight == 2){ // Si il a choisi 2 alors il charge de la puissance pour le prochain Round
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous chargez de la puissance !" + RESET);
                                Thread.sleep(2000);
                                bouleEnergie++;
                                System.out.println(GREEN + "Vous avec maintenant " + bouleEnergie + " !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                            } else if(choiceFight == 3){ // Si il a choisi 3 alors il regarde les stats de l'adversaire
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous regardez les stats de votre adversaire !" + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Nom : " + chosenCreature.getName() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Type : " + chosenCreature.getType() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Level : " + chosenCreature.getLevel() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "PV : " + chosenCreature.getHealth() + RESET);
                                Thread.sleep(2000);
                                System.out.println(YELLOW + "Dêgats : " + chosenCreature.getDamage() + RESET);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                while1 = false;
                            } else if(choiceFight == 4){ // Si il a choisi 4 alors il évolue (si il peut)
                                if (canEvolve && bouleEnergie >= 3) {
                                    // Effacer la console avec des séquences ANSI
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(CYAN + "VOUS ÉVOLUEZ !" + RESET);
                                    Thread.sleep(2000);
                                    int indexChoiceCreatureFight = Main.allCreatures.indexOf(choiceCreatureFight.getName().toLowerCase());
                                    choiceCreatureFight = Main.allCreatures.get(indexChoiceCreatureFight + 1);
                                    System.out.println(GREEN + "Vous êtes maintenant " + choiceCreatureFight.getName() + " !" + RESET);
                                    canEvolve = false;
                                    Thread.sleep(2000);
                                    while1 = true;
                                } else{ // Si il a déjà évolué 
                                    System.out.println(RED + "Vous avez déjà évoluer !" + RESET);
                                    Thread.sleep(2000);
                                    while1 = false;
                                }
                            } else if(choiceFight == 5){ // Si il a choisi 5 alors il se retire...
                                // Effacer la console avec des séquences ANSI
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println(CYAN + "Vous vous retirez !" + RESET);
                                Thread.sleep(2000);
                                while1 = true;
                                break;
                            } else{ // Si c'est autre chose 
                                System.out.println(RED + "Choix non valide !" + RESET);
                                Thread.sleep(2000);
                                while1 = false;
                            }
                        }else{
                            return;
                        }
                    }
                }
            }

        } else if (readyInput.equals("2") || readyInput.equalsIgnoreCase("Non")) { // Option 2
            System.out.println(RED + "L'arbitre : D'accord, vous ne combattrez pas ce soir !" + RESET);
            return;
        } else { // Autre
            System.out.println(RED + "L'arbitre : Je ne comprends pas votre choix" + RESET);
            Thread.sleep(2000);
        }
    }
}