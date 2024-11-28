import java.util.Scanner;

public class Combats {
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
    public static void StartFightAleatoire(Creatures creature) throws InterruptedException {
        // Est-ce qu'il a des créatures ?
        if (Main.listeCreaturesPossédés.isEmpty()) {
            System.out.println(RED + "Vous n'avez aucune créature pour combattre !" + RESET);
            Thread.sleep(2000);
            return;
        }

        // ------------------------ VARIABLES -------------------------- \\

        // Peut-il évoluer ?
        boolean canEvolve = true;

        // Peut-il évoluer ?
        boolean canEvolveBot = true;

        // Nouveau Scanner
        Scanner sc = new Scanner(System.in);

        // Boules d'énérgies
        int bouleEnergie = 0;

        // While 1
        boolean while1 = false;

        // ------------------------ INTRODUCTION -------------------------- \\

        // Introduction au combat
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(RED + "Vous avez choisi de combattre avec " + creature.getName() + " !" + RESET);
        Thread.sleep(2000);       
        
        // Il faudra choisir !
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
        
        // Les statistiques
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(CYAN + "Vos statistiques :" + RESET);
        Thread.sleep(2000);
        System.out.println(YELLOW + "Son nom : " + creature.getName() + " ----- Votre nom : " + choiceCreatureFight.getName() + RESET);
        Thread.sleep(2000);
        System.out.println(YELLOW + "Sa vie : " + creature.getHealth() + " ----- Votre vie : " + choiceCreatureFight.getHealth() + RESET); 
        Thread.sleep(2000);
        System.out.println(YELLOW + "Ses dêgats : " + creature.getDamage() + " ----- Vos dêgats : " + choiceCreatureFight.getDamage() + RESET); 
        Thread.sleep(2000);
        System.out.println(YELLOW + "Son niveau : " + creature.getLevel() + " ----- Votre niveau : " + choiceCreatureFight.getLevel() + RESET);
        Thread.sleep(2000);
        System.out.println(YELLOW + "Son type : " + creature.getType() + " ----- Votre type : " + choiceCreatureFight.getType() + RESET);
        Thread.sleep(2000);
        
        // Commencer combat
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(CYAN + "Le combat commence !" + RESET);
        Thread.sleep(2000);

        // ------------------------------- COMBAT -------------------------------------- \\

        // Boucle de combat
        while (creature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0) {
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            while(!while1){
                if(creature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
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
                        creature.TakeDamage(choiceCreatureFight.getDamage());
                        Thread.sleep(2000);
                        System.out.println(GREEN + "Vous avez infligé " + RED + choiceCreatureFight.getDamage() + GREEN + " de dêgats !" + RESET);
                        Thread.sleep(2000);
                        System.out.println(RED + "L'adversaire n'a plus que " + creature.getHealth() + " de vies !" + RESET);
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
                        System.out.println(YELLOW + "Nom : " + creature.getName() + RESET);
                        Thread.sleep(2000);
                        System.out.println(YELLOW + "Type : " + creature.getType() + RESET);
                        Thread.sleep(2000);
                        System.out.println(YELLOW + "Level : " + creature.getLevel() + RESET);
                        Thread.sleep(2000);
                        System.out.println(YELLOW + "PV : " + creature.getHealth() + RESET);
                        Thread.sleep(2000);
                        System.out.println(YELLOW + "Dêgats : " + creature.getDamage() + RESET);
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

            if(creature.getHealth() > 0 && choiceCreatureFight.getHealth() > 0){
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
                choiceCreatureFight.TakeDamage(creature.getDamage());
                System.out.println(RED + "L'adversaire vous a infligé : " + creature.getDamage() + " dêgats !" + RESET);
                Thread.sleep(2000);
                System.out.println(RED + "Vous n'avez plus que : " + choiceCreatureFight.getHealth() + " PV !" + RESET);
                Thread.sleep(2000);
                while1 = false;
                } else if(choiceFightBotRound == 2){ // Si c'est 2 il charge de l'énergie
                    // Effacer la console avec des séquences ANSI
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(RED + "L'adversaire charge de l'énergie !" + RESET);
                    creature.AddDamage(5);
                    Thread.sleep(2000);
                    System.out.println(CYAN + "Dêgats qu'il inflige maintenant : " + creature.getDamage() + " !" + RESET);
                    Thread.sleep(2000);
                    while1 = false;
                } else if(choiceFightBotRound == 3){ // Si c'est 3 il évolue !
                    if(canEvolveBot && bouleEnergie >= 3){
                        // Effacer la console avec des séquences ANSI
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(RED + "L'adversaire ÉVOLUE !" + RESET);
                        Thread.sleep(2000);
                        int indexChoiceCreatureFightBot = Main.allCreatures.indexOf(creature.getName().toLowerCase());
                        creature = Main.allCreatures.get(indexChoiceCreatureFightBot + 1);
                        canEvolveBot = false;
                        System.out.println(CYAN + "L'adversaire a évolué en : " + creature.getName() + " !" + RESET);
                        Thread.sleep(2000);
                        while1 = false;
                    }
                }
            } else {
                return;
            }
        }
    }
}
