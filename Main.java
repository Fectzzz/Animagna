import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    // Codes ANSI pour les couleurs
    public static final String RESET = "\u001B[0m"; // Réinitialiser la couleur
    public static final String RED = "\u001B[31m";  // Couleur Rouge
    public static final String GREEN = "\u001B[32m"; // Couleur Verte
    public static final String YELLOW = "\u001B[33m"; // Couleur Jaune
    public static final String BLUE = "\u001B[34m"; // Couleur Bleu
    public static final String PURPLE = "\u001B[35m"; // Couleur Violette
    public static final String CYAN = "\u001B[36m"; // Couleur Cyan
    public static final String WHITE = "\u001B[37m"; // Couleur Blanche

    // Créatures qu'il possède
    static ArrayList<Creatures> listeCreaturesPossédés = new ArrayList<>();

    // Création de la liste pour toutes les créatures
    static ArrayList<Creatures> allCreatures = new ArrayList<>();

    @SuppressWarnings("unused")
    public static void main(String[] args) throws InterruptedException {

        // -------------------- Variables ------------------- \\

        // Tableaux noms des créatures
        String[] namesCreaturesTypeFeu = {"Pyrolisk", "Flamara", "Volcanyx", "Igniflare", "Charbère"};
        String[] namesCreaturesTypeEau = {"Aquafyn", "Maristol", "Hyrava", "Nautilor", "Océara"};
        String[] namesCreaturesTypePlante = {"Florivy", "Branchelon", "Tropivy", "Verdignis", "Arbormyst"};
        String[] namesCreaturesTypeÉlectrique = {"Zappix", "Boltano", "Sparktus", "Chargale", "Electrixie"};
        String[] namesCreaturesTypeAir = {"Ventraptor", "Skyvora", "Zephyro", "Aerodust", "Windrelle"};
        String[] namesCreaturesTypeGlace = {"Cryonix", "Frystar", "Glacione", "Icyanix", "Neviros"};
        String[] namesCreaturesTypeOmbre = {"Spectrana", "Duskorn", "Teneborn", "Umbrosaur", "Phantoxis"};
        String[] namesCreaturesTypeAcier = {"Ferronyx", "Metalord", "Chromidon", "Stelladon", "Magnevril"};
        String[] namesCreaturesTypeDragons = {"Dracolythe", "Wyveris", "Hydraxa", "Scalithor", "Dragorb"};
        String[] namesCreaturesTypeMagiques = {"Lumivelle", "Mystarion", "Enchanta", "Runeflare", "Arcanis"};

        // Vie des créatures
        Integer[] healthCreaturesTypeFeu = {70, 90, 130, 180, 220}; // Des PV modérés, car les créatures de feu misent souvent sur l'attaque.
        Integer[] healthCreaturesTypeEau = {80, 100, 150, 200, 250}; // Des PV un peu plus élevés, car les créatures d'eau sont souvent équilibrées.
        Integer[] healthCreaturesTypePlante = {60, 80, 120, 140, 170}; // Des PV intermédiaires, la résistance physique étant souvent leur point faible.
        Integer[] healthCreaturesTypeÉlectrique = {70, 90, 130, 170, 210}; // Des PV moyens, reflétant leur orientation vers la vitesse et l'attaque spéciale.
        Integer[] healthCreaturesTypeAir = {60, 75, 100, 120, 160}; // Faibles en défense, avec un accent sur la mobilité.
        Integer[] healthCreaturesTypeGlace = {80, 110, 140, 170, 200}; // Moyenne à haute endurance pour refléter une certaine résilience au combat.
        Integer[] healthCreaturesTypeOmbre = {70, 85, 110, 150, 190}; // PV décents pour leur côté mystérieux et leur force dans la furtivité.
        Integer[] healthCreaturesTypeAcier = {90, 120, 150, 200, 250}; // Les créatures d'acier sont très robustes et axées sur la défense.
        Integer[] healthCreaturesTypeDragons = {100, 130, 180, 220, 280}; // Les dragons, en tant que créatures puissantes, méritent des PV élevés.
        Integer[] healthCreaturesTypeMagiques = {70, 100, 130, 160, 190}; // Moyens à hauts, car ces créatures compensent souvent par leurs pouvoirs spéciaux.


        // Attaque des créatures
        Integer[] damageCreaturesTypeFeu = {30, 60, 90, 120, 150}; // Type Feu privilégie l'attaque, avec des dégâts élevés.
        Integer[] damageCreaturesTypeEau = {25, 50, 75, 100, 130}; // Type Eau est équilibré, avec des dégâts modérés à élevés.
        Integer[] damageCreaturesTypePlante = {20, 40, 60, 80, 100}; // Type Plante mise davantage sur les effets secondaires que sur les dégâts directs.
        Integer[] damageCreaturesTypeÉlectrique = {35, 70, 90, 120, 150}; // Type Électrique favorise l'attaque rapide et efficace.
        Integer[] damageCreaturesTypeAir = {20, 50, 60, 80, 120}; // Type Air a des dégâts modérés, souvent combinés à une grande vitesse.
        Integer[] damageCreaturesTypeGlace = {25, 50, 75, 100, 125}; // Type Glace offre des attaques solides, souvent associées à des ralentissements.
        Integer[] damageCreaturesTypeOmbre = {30, 55, 75, 110, 140}; // Type Ombre a des dégâts moyens à élevés, reflétant leur nature rusée.
        Integer[] damageCreaturesTypeAcier = {20, 40, 60, 80, 100}; // Type Acier privilégie la défense, avec des dégâts plus faibles.
        Integer[] damageCreaturesTypeDragons = {40, 70, 100, 130, 170}; // Type Dragon est conçu pour infliger des dégâts massifs.
        Integer[] damageCreaturesTypeMagiques = {25, 60, 85, 110, 140}; // Type Magique inflige des dégâts modérés à élevés avec des capacités variées.


        // Type des créatures
        String[] typesCreatures = {"Feu", "Eau", "Plante", "Électrique", "Air", "Glace", "Ombre", "Acier", "Dragon", "Magique"};
        
        // Variables des niveaux des Créatures
        int levelPyrolisk = 1;
        int levelFlamara = 1;
        int levelVolcanyx = 1;
        int levelIgniflare = 1;
        int levelCharbère = 1;

        int levelAquafyn = 1;
        int levelMaristol = 1;
        int levelHyrava = 1;
        int levelNautilor = 1;
        int levelOcéara = 1;

        int levelFlorivy = 1;
        int levelBranchelon = 1;
        int levelTropivy = 1;
        int levelVerdignis = 1;
        int levelArbormyst = 1;

        int levelZappix = 1;
        int levelBoltano = 1;
        int levelSparktus = 1;
        int levelChargale = 1;
        int levelElectrixie = 1;

        int levelVentraptor = 1;
        int levelSkyvora = 1;
        int levelZephyro = 1;
        int levelAerodust = 1;
        int levelWindrelle = 1;

        int levelCryonix = 1;
        int levelFrystar = 1;
        int levelGlacione = 1;
        int levelIcyanix = 1;
        int levelNeviros = 1;
 
        int levelSpectrana = 1;
        int levelDuskorn = 1;
        int levelTeneborn = 1;
        int levelUmbrosaur = 1;
        int levelPhantoxis = 1;

        int levelFerronyx = 1;
        int levelMetalord = 1;
        int levelChromidon = 1;
        int levelStelladon = 1;
        int levelMagnevril = 1;

        int levelDracolythe = 1;
        int levelWyveris = 1;
        int levelHydraxa = 1;
        int levelScalithor = 1;
        int levelDragorb = 1;

        int levelLumivelle = 1;
        int levelMystarion = 1;
        int levelEnchanta = 1;
        int levelRuneflare = 1;
        int levelArcanis = 1;

        // Création des créatures 
        Creatures pyrolisk = new Creatures(namesCreaturesTypeFeu[0], healthCreaturesTypeFeu[0], damageCreaturesTypeFeu[0], levelPyrolisk, typesCreatures[0]);
        Creatures flamara = new Creatures(namesCreaturesTypeFeu[1], healthCreaturesTypeFeu[1], damageCreaturesTypeFeu[1], levelFlamara, typesCreatures[0]);
        Creatures volcanyx = new Creatures(namesCreaturesTypeFeu[2], healthCreaturesTypeFeu[2], damageCreaturesTypeFeu[2], levelVolcanyx, typesCreatures[0]);
        Creatures igniflare = new Creatures(namesCreaturesTypeFeu[3], healthCreaturesTypeFeu[3], damageCreaturesTypeFeu[3], levelIgniflare, typesCreatures[0]);
        Creatures charbère = new Creatures(namesCreaturesTypeFeu[4], healthCreaturesTypeFeu[4], damageCreaturesTypeFeu[4], levelCharbère, typesCreatures[0]);

        Creatures aquafyn = new Creatures(namesCreaturesTypeEau[0], healthCreaturesTypeEau[0], damageCreaturesTypeEau[0], levelAquafyn, typesCreatures[1]);
        Creatures maristol = new Creatures(namesCreaturesTypeEau[1], healthCreaturesTypeEau[1], damageCreaturesTypeEau[1], levelMaristol, typesCreatures[1]);
        Creatures hyrava = new Creatures(namesCreaturesTypeEau[2], healthCreaturesTypeEau[2], damageCreaturesTypeEau[2], levelHyrava, typesCreatures[1]);
        Creatures nautilor = new Creatures(namesCreaturesTypeEau[3], healthCreaturesTypeEau[3], damageCreaturesTypeEau[3], levelNautilor, typesCreatures[1]);
        Creatures océara = new Creatures(namesCreaturesTypeEau[4], healthCreaturesTypeEau[4], damageCreaturesTypeEau[4], levelOcéara, typesCreatures[1]);

        Creatures florivy = new Creatures(namesCreaturesTypePlante[0], healthCreaturesTypePlante[0], damageCreaturesTypePlante[0], levelFlorivy, typesCreatures[2]);
        Creatures branchelon = new Creatures(namesCreaturesTypePlante[1], healthCreaturesTypePlante[1], damageCreaturesTypePlante[1], levelBranchelon, typesCreatures[2]);
        Creatures tropivy = new Creatures(namesCreaturesTypePlante[2], healthCreaturesTypePlante[2], damageCreaturesTypePlante[2], levelTropivy, typesCreatures[2]);
        Creatures verdignis = new Creatures(namesCreaturesTypePlante[3], healthCreaturesTypePlante[3], damageCreaturesTypePlante[3], levelVerdignis, typesCreatures[2]);
        Creatures arbormyst = new Creatures(namesCreaturesTypePlante[4], healthCreaturesTypePlante[4], damageCreaturesTypePlante[4], levelArbormyst, typesCreatures[2]);

        Creatures zappix = new Creatures(namesCreaturesTypeÉlectrique[0], healthCreaturesTypeÉlectrique[0], damageCreaturesTypeÉlectrique[0], levelZappix, typesCreatures[3]);
        Creatures boltano = new Creatures(namesCreaturesTypeÉlectrique[1], healthCreaturesTypeÉlectrique[1], damageCreaturesTypeÉlectrique[1], levelBoltano, typesCreatures[3]);
        Creatures sparktus = new Creatures(namesCreaturesTypeÉlectrique[2], healthCreaturesTypeÉlectrique[2], damageCreaturesTypeÉlectrique[2], levelSparktus, typesCreatures[3]);
        Creatures chargale = new Creatures(namesCreaturesTypeÉlectrique[3], healthCreaturesTypeÉlectrique[3], damageCreaturesTypeÉlectrique[3], levelChargale, typesCreatures[3]);
        Creatures electrixie = new Creatures(namesCreaturesTypeÉlectrique[4], healthCreaturesTypeÉlectrique[4], damageCreaturesTypeÉlectrique[4], levelElectrixie, typesCreatures[3]);

        Creatures ventraptor = new Creatures(namesCreaturesTypeAir[0], healthCreaturesTypeAir[0], damageCreaturesTypeAir[0], levelVentraptor, typesCreatures[4]);
        Creatures skyvora = new Creatures(namesCreaturesTypeAir[1], healthCreaturesTypeAir[1], damageCreaturesTypeAir[1], levelSkyvora, typesCreatures[4]);
        Creatures zephyro = new Creatures(namesCreaturesTypeAir[2], healthCreaturesTypeAir[2], damageCreaturesTypeAir[2], levelZephyro, typesCreatures[4]);
        Creatures aerodust = new Creatures(namesCreaturesTypeAir[3], healthCreaturesTypeAir[3], damageCreaturesTypeAir[3], levelAerodust, typesCreatures[4]);
        Creatures windrelle = new Creatures(namesCreaturesTypeAir[4], healthCreaturesTypeAir[4], damageCreaturesTypeAir[4], levelWindrelle, typesCreatures[4]);

        Creatures cryonix = new Creatures(namesCreaturesTypeGlace[0], healthCreaturesTypeGlace[0], damageCreaturesTypeGlace[0], levelCryonix, typesCreatures[5]);
        Creatures frystar = new Creatures(namesCreaturesTypeGlace[1], healthCreaturesTypeGlace[1], damageCreaturesTypeGlace[1], levelFrystar, typesCreatures[5]);
        Creatures glacione = new Creatures(namesCreaturesTypeGlace[2], healthCreaturesTypeGlace[2], damageCreaturesTypeGlace[2], levelGlacione, typesCreatures[5]);
        Creatures icyanix = new Creatures(namesCreaturesTypeGlace[3], healthCreaturesTypeGlace[3], damageCreaturesTypeGlace[3], levelIcyanix, typesCreatures[5]);
        Creatures neviros = new Creatures(namesCreaturesTypeGlace[4], healthCreaturesTypeGlace[4], damageCreaturesTypeGlace[4], levelNeviros, typesCreatures[5]);

        Creatures spectrana = new Creatures(namesCreaturesTypeOmbre[0], healthCreaturesTypeOmbre[0], damageCreaturesTypeOmbre[0], levelSpectrana, typesCreatures[6]);
        Creatures duskorn = new Creatures(namesCreaturesTypeOmbre[1], healthCreaturesTypeOmbre[1], damageCreaturesTypeOmbre[1], levelDuskorn, typesCreatures[6]);
        Creatures teneborn = new Creatures(namesCreaturesTypeOmbre[2], healthCreaturesTypeOmbre[2], damageCreaturesTypeOmbre[2], levelTeneborn, typesCreatures[6]);
        Creatures umbrosaur = new Creatures(namesCreaturesTypeOmbre[3], healthCreaturesTypeOmbre[3], damageCreaturesTypeOmbre[3], levelUmbrosaur, typesCreatures[6]);
        Creatures phantoxis = new Creatures(namesCreaturesTypeOmbre[4], healthCreaturesTypeOmbre[4], damageCreaturesTypeOmbre[4], levelPhantoxis, typesCreatures[6]);

        Creatures ferronyx = new Creatures(namesCreaturesTypeAcier[0], healthCreaturesTypeAcier[0], damageCreaturesTypeAcier[0], levelFerronyx, typesCreatures[7]);
        Creatures metalord = new Creatures(namesCreaturesTypeAcier[1], healthCreaturesTypeAcier[1], damageCreaturesTypeAcier[1], levelMetalord, typesCreatures[7]);
        Creatures chromidon = new Creatures(namesCreaturesTypeAcier[2], healthCreaturesTypeAcier[2], damageCreaturesTypeAcier[2], levelChromidon, typesCreatures[7]);
        Creatures stelladon = new Creatures(namesCreaturesTypeAcier[3], healthCreaturesTypeAcier[3], damageCreaturesTypeAcier[3], levelStelladon, typesCreatures[7]);
        Creatures magnevril = new Creatures(namesCreaturesTypeAcier[4], healthCreaturesTypeAcier[4], damageCreaturesTypeAcier[4], levelMagnevril, typesCreatures[7]);

        Creatures dracolythe = new Creatures(namesCreaturesTypeDragons[0], healthCreaturesTypeDragons[0], damageCreaturesTypeDragons[0], levelDracolythe, typesCreatures[8]);
        Creatures wyveris = new Creatures(namesCreaturesTypeDragons[1], healthCreaturesTypeDragons[1], damageCreaturesTypeDragons[1], levelWyveris, typesCreatures[8]);
        Creatures hydraxa = new Creatures(namesCreaturesTypeDragons[2], healthCreaturesTypeDragons[2], damageCreaturesTypeDragons[2], levelHydraxa, typesCreatures[8]);
        Creatures scalithor = new Creatures(namesCreaturesTypeDragons[3], healthCreaturesTypeDragons[3], damageCreaturesTypeDragons[3], levelScalithor, typesCreatures[8]);
        Creatures dragorb = new Creatures(namesCreaturesTypeDragons[4], healthCreaturesTypeDragons[4], damageCreaturesTypeDragons[4], levelDragorb, typesCreatures[8]);

        Creatures lumivelle = new Creatures(namesCreaturesTypeMagiques[0], healthCreaturesTypeMagiques[0], damageCreaturesTypeMagiques[0], levelLumivelle, typesCreatures[9]);
        Creatures mystarion = new Creatures(namesCreaturesTypeMagiques[1], healthCreaturesTypeMagiques[1], damageCreaturesTypeMagiques[1], levelMystarion, typesCreatures[9]);
        Creatures enchanta = new Creatures(namesCreaturesTypeMagiques[2], healthCreaturesTypeMagiques[2], damageCreaturesTypeMagiques[2], levelEnchanta, typesCreatures[9]);
        Creatures runeflare = new Creatures(namesCreaturesTypeMagiques[3], healthCreaturesTypeMagiques[3], damageCreaturesTypeMagiques[3], levelRuneflare, typesCreatures[9]);
        Creatures arcanis = new Creatures(namesCreaturesTypeMagiques[4], healthCreaturesTypeMagiques[4], damageCreaturesTypeMagiques[4], levelArcanis, typesCreatures[9]);
        
        // Ajout des créatures de type Feu
        allCreatures.add(pyrolisk);
        allCreatures.add(flamara);
        allCreatures.add(volcanyx);
        allCreatures.add(igniflare);
        allCreatures.add(charbère);

        // Ajout des créatures de type Eau
        allCreatures.add(aquafyn);
        allCreatures.add(maristol);
        allCreatures.add(hyrava);
        allCreatures.add(nautilor);
        allCreatures.add(océara);

        // Ajout des créatures de type Plante
        allCreatures.add(florivy);
        allCreatures.add(branchelon);
        allCreatures.add(tropivy);
        allCreatures.add(verdignis);
        allCreatures.add(arbormyst);

        // Ajout des créatures de type Électrique
        allCreatures.add(zappix);
        allCreatures.add(boltano);
        allCreatures.add(sparktus);
        allCreatures.add(chargale);
        allCreatures.add(electrixie);

        // Ajout des créatures de type Air
        allCreatures.add(ventraptor);
        allCreatures.add(skyvora);
        allCreatures.add(zephyro);
        allCreatures.add(aerodust);
        allCreatures.add(windrelle);

        // Ajout des créatures de type Glace
        allCreatures.add(cryonix);
        allCreatures.add(frystar);
        allCreatures.add(glacione);
        allCreatures.add(icyanix);
        allCreatures.add(neviros);

        // Ajout des créatures de type Ombre
        allCreatures.add(spectrana);
        allCreatures.add(duskorn);
        allCreatures.add(teneborn);
        allCreatures.add(umbrosaur);
        allCreatures.add(phantoxis);

        // Ajout des créatures de type Acier
        allCreatures.add(ferronyx);
        allCreatures.add(metalord);
        allCreatures.add(chromidon);
        allCreatures.add(stelladon);
        allCreatures.add(magnevril);

        // Ajout des créatures de type Dragons
        allCreatures.add(dracolythe);
        allCreatures.add(wyveris);
        allCreatures.add(hydraxa);
        allCreatures.add(scalithor);
        allCreatures.add(dragorb);

        // Ajout des créatures de type Magiques
        allCreatures.add(lumivelle);
        allCreatures.add(mystarion);
        allCreatures.add(enchanta);
        allCreatures.add(runeflare);
        allCreatures.add(arcanis);

        // Variables vérifications
        boolean canPlay = false; // Il peut jouer ?
        boolean lieVentraptor = false; // Il a menti à propos de sa capture de Ventraptor ?
        boolean lieSchool = false; // Il a menti pour ne pas aller à l'école ?
        
        // ------------------ Code principal ---------------------- \\

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in); // Nouveau Scanner
        System.out.println(YELLOW + "Bienvenue dans Animagna !" + RESET); // Bienvenue
        Thread.sleep(1000);
        System.out.println(GREEN + "1/ Jouer " + BLUE + "2/ Paramètres " + YELLOW + "3/ Guide " + RED + "4/ Quitter" + RESET); // Options du menu
        String menuChoice = sc.nextLine();

        // Qu'est-ce qu'il a choisi dans le menu ?
        if (menuChoice.equalsIgnoreCase("1")) {
            System.out.println(GREEN + "Vous avez choisi de jouer !" + RESET);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            canPlay = true;
        } else if (menuChoice.equalsIgnoreCase("2")) {
            System.out.println(CYAN + "Vous avez choisi les paramètres !" + RESET);
            System.out.println(YELLOW + "Nom : " + RESET + "Animagna");
            System.out.println(YELLOW + "Version : " + RESET + "1.0");
            System.out.println(YELLOW + "Auteur : " + RESET + "Anwar");
            System.out.println(YELLOW + "Date de sortie : " + RESET + "23/11/2024");
            System.exit(0);
        } else if (menuChoice.equalsIgnoreCase("3")) {
            System.out.println(CYAN + "Vous avez choisi le guide !" + RESET);
            System.out.println(YELLOW + "Guide en cours de développement..." + RESET);
            System.exit(0);
        } else if (menuChoice.equalsIgnoreCase("4")) {
            System.exit(0);
        } else {
            System.out.println(RED + "Veuillez choisir une option valide !" + RESET);
        }

        // Si il peut jouer !
        if (canPlay) {
            // Introduction à l'histoire
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(CYAN + "C'est parti pour une nouvelle aventure !" + RESET);
            Thread.sleep(4000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(CYAN + "Vous êtes dans un monde où les créatures sont en guerre !" + RESET);
            Thread.sleep(3000);
            System.out.println(CYAN + "Vous êtes un enfant qui doit dominer le monde des créatures !" + RESET);
            Thread.sleep(3000);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(CYAN + "Il y a 534 ans en 1490..." + RESET);
            Thread.sleep(4000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Dialogues
            System.out.println(PURPLE + "Votre mère : Où vas-tu filston ?" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Je vais jouer à Animaland avec mes amis !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Votre mère : D'accord mais ne tarde pas !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : D'accord, promis !" + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Narration
            System.out.println(CYAN + "Vous arrivez à Animaland et vous vous rendez directement dans la forêt avec vos amis." + RESET);
            Thread.sleep(3000);
            System.out.println(PURPLE + "Vous : Eh les gars, je suis sûr qu'il y a des créatures ici !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Un ami : Oui, mais elles sont beaucoup trop rares !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Pas grave, on va les chercher !" + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Action et suspens
            System.out.println(CYAN + "Vous commencez à explorer la forêt et d'un coup vous entendez un *CRACK !*" + RESET);
            Thread.sleep(2500);
            System.out.println(PURPLE + "Vous : Qu'est-ce que c'est ?" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Un ami : Je ne sais pas mais je pense que c'est une créature..." + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Alors on va la chercher !" + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Découverte
            System.out.println(PURPLE + "Vous : OH ! C'est quoi ça ??" + RESET);
            Thread.sleep(1200);
            System.out.println(PURPLE + "Vous : C'est un... un... un... un... un... un pigeon..." + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Un ami : Un pigeon ?" + RESET);
            Thread.sleep(1500);
            System.out.println(PURPLE + "Vous : Oui, un pigeon..." + RESET);
            Thread.sleep(1500);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Suspens et humour
            System.out.println(CYAN + "*Le pigeon se lève*" + RESET);
            Thread.sleep(1500);
            System.out.println(PURPLE + "Un ami : Mais c'est un pigeon géant !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Oui, c'est un pigeon géant !" + RESET);
            Thread.sleep(2000);

            // Capture
            System.out.println(GREEN + "Vous : Capturons-le avec une AstraBall !" + RESET);
            Thread.sleep(2000);
            System.out.println(CYAN + "*L'AstraBall est faite pour capturer les grandes créatures*" + RESET);
            Thread.sleep(2200);
            System.out.println(GREEN + "Vous : C'est parti pour la capturer !" + RESET);
            Thread.sleep(2000);
            System.out.println(CYAN + "*Vous lancez l'AstraBall et elle frappe le pigeon géant*" + RESET);
            Thread.sleep(2000);
            System.out.println(GREEN + "Vous : Oui, oui je L'AI EU !" + RESET);
            Thread.sleep(2000);
            System.out.println(GREEN + "Bravo ! Vous avez capturé Ventraptor !" + RESET);
            Thread.sleep(2000);
            listeCreaturesPossédés.add(ventraptor);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Statistiques
            System.out.println(CYAN + "Statistiques du Pigeon Géant : " + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Nom : " + ventraptor.getName() + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Vie : " + ventraptor.getHealth() + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Attaque : " + ventraptor.getDamage() + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Niveau : " + ventraptor.getLevel() + RESET);
            Thread.sleep(2000);
            System.out.println(YELLOW + "Type : " + ventraptor.getType() + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(PURPLE + "Vous : Je vais le ramener à la maison et le montrer à ma mère !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Votre ami : Tu vas la faire rire !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Oui, effectivement !" + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Rentrer à la maison
            System.out.println(CYAN + "1 heure plus tard..." + RESET);
            Thread.sleep(2000);
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Salutations
            System.out.println(PURPLE + "Vous : Maman, je suis rentré !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Votre mère : Ah, salut ! Qu'est-ce que tu as fait alors ?" + RESET);
            Thread.sleep(2500);

            // Choix 1
            System.out.println(YELLOW + "1/ Tout lui dire  2/ Ne pas lui dire à propos de Ventraptor" + RESET);
            String choice1 = sc.nextLine();

            // Si il a choisi l'option 1
            if (choice1.equals("1")) {
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(PURPLE + "Vous : Je suis allé dans la forêt avec mes amis et j'ai capturé un Ventraptor !" + RESET);
                Thread.sleep(2500);
                System.out.println(PURPLE + "Votre mère : Un Ventraptor ? Mais c'est un monstre ! On peut pas le garder, désolé !" + RESET);
                Thread.sleep(2500);
                System.out.println(PURPLE + "Vous : Mais pourquoi pas ?" + RESET);
                Thread.sleep(2500);
                System.out.println(PURPLE + "Votre mère : Parce que c'est un monstre, il va tout détruire !" + RESET);
                Thread.sleep(2500);
                System.out.println(PURPLE + "Vous : Mais je l'ai capturé avec une AstraBall !" + RESET);
                Thread.sleep(2500);
                System.out.println(PURPLE + "Votre mère : Ah, c'est vrai ! Je suis désolée alors mais ne le sort pas !" + RESET);
                Thread.sleep(2500);
                lieVentraptor = false;
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(GREEN + "Bravo vous n'avez pas menti à votre mère et elle est d'accord !" + RESET);
                Thread.sleep(2500);
                System.out.println(GREEN + "Succès débloqué : Je ne mens pas, c'est une promesse !" + RESET);
                Thread.sleep(2500);
            } else if (choice1.equals("2")) { // Ou la 2
                System.out.println(PURPLE + "Vous : Je suis allé dans la forêt avec mes amis et on a construit une cabane !" + RESET);
                Thread.sleep(3000);
                System.out.println(PURPLE + "Votre mère : Ah, c'est super ! Je suis fière de toi !" + RESET);
                lieVentraptor = true;
                Thread.sleep(2500);
                System.out.println(RED + "Vous avez menti à votre mère, succès non débloqué !" + RESET);
                Thread.sleep(2500);
            }

            // Le lendemain
            // Effacer la console avec des séquences ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(CYAN + "Le lendemain..." + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vous : Maman, je suis prêt à aller à l'école !" + RESET);
            Thread.sleep(2000);
            System.out.println(PURPLE + "Vote mère : A ce soir mon grand !" + RESET);
            Thread.sleep(2000);

            // Choix 2
            System.out.println(YELLOW + "1/ Aller à l'école  2/ Faire des combats avec Ventraptor" + RESET);
            String choice2 = sc.nextLine();
            
            // Si il a choisi l'option 1
            if (choice2.equals("1")){
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(CYAN + "*Vous allez à l'école...*" + RESET);
                lieSchool = false;
                Thread.sleep(2000);
                System.out.println(GREEN + "Vous allez à l'école sans mentir !" + RESET);
                Thread.sleep(2000);
                System.out.println(CYAN + "*A la fin des cours...*");
                Thread.sleep(2000);
                System.out.println(PURPLE + "Vous : Oh ! Il y a une compétition qui va commencer dans l'arène de ma ville !" + RESET);
                Thread.sleep(3000);
                System.out.println(PURPLE + "Vous : Je vais y aller !" + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Vous : Heuu attends 2 petites secondes.. je n'ai qu'une seule créature mais il en faut minimum 2 !" + RESET);
                Thread.sleep(3000);
            } else if(choice2.equals("2")){
                System.out.println(CYAN + "Vous allez à l'arène de combat pour participer à votre première compétition..." + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Vous : Je suis prêt à affronter mes adversaires mais.. j'ai que 1 créature et il en faut minimum 2 au cas où l'autre perd !" + RESET);
                Thread.sleep(3000);                
            } else{
                System.out.println(RED + "Vous n'avez pas choisi une option valide ! Tapez 1 ou 2 !" + RESET);
                Thread.sleep(2000);
            }
           
            // Choix 3
            System.out.println(YELLOW + "1/ Aller quand même  2/ Aller chercher d'autres créatures" + RESET);
            String choice3 = sc.nextLine();

            // Regarder ce qu'il a répondu
            if (choice3.equals("1")){
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(CYAN + "Vous allez quand même faire la compétition !" + RESET);
                Thread.sleep(2000);
                System.out.println(CYAN + "*Arrivé à la compétition*" + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Commentateur : Bonjour à toute et à tous !" + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Commentateur : Nous allons commencez le premier combat avec une jeune recru..." + RESET);
                Thread.sleep(3000);
                System.out.println(PURPLE + "Commentateur : Merci de tous l'acclamer !" + RESET);
                Thread.sleep(2000);
                System.out.println(CYAN + "*Le public applaudit*" + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Commentateur : Pour ce premier combat, vous allez affronter Gabriel !" + RESET);
                Thread.sleep(2000);
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Competitions.StartCombat("Gabriel");
            } else if(choice3.equals("2")){
                // Effacer la console avec des séquences ANSI
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(CYAN + "Vous allez chercher d'autres créatures pour participer !" + RESET);
                Thread.sleep(2000);
                System.out.println(CYAN + "Vous arrivez dans une montagne pour essayer de trouver une créature !" + RESET);
                Thread.sleep(2000);
                System.out.println(PURPLE + "Vous : Je vais essayer de trouver une créature dans cette grotte !" + RESET);
                Thread.sleep(2000);
                Random rand = new Random();
                int n2 = rand.nextInt(allCreatures.size()); // Index aléatoire
                Creatures creatureGrotte = allCreatures.get(n2);
                System.out.println(RED + "Attention ! Vous tombez sur " + creatureGrotte.getName() + " !");
                Thread.sleep(2000);
                System.out.println(YELLOW + "1/Essayer de le capturer 2/Fuir");
                String choiceGrotte = sc.nextLine();

                // Quel choix il a fait ?
                if (choiceGrotte.equals("1")){
                    // Effacer la console avec des séquences ANSI
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Combats.StartFightAleatoire(creatureGrotte);
                } else if (choiceGrotte.equals("2") || choiceGrotte.equals("Fuir")){
                    // Effacer la console avec des séquences ANSI
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(CYAN + "Vous avez fui la grotte !" + RESET);
                    Thread.sleep(2000);
                    System.out.println(RED + "Succès non débloqué !");
                }
            }
        }

    }
}