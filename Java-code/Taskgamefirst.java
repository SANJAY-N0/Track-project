import java.util.Scanner;

public class Taskgamefirst {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Player stats
        int playerHP = 100;
        int playerAttack = 10;
        int potions = 3;

        // Enemy stats
        int enemyHP = 80;
        int enemyAttack = 8;

        // UI Header
        System.out.println("--------------------------------------");
        System.out.println("        MINI RPG — OPERATOR MODE      ");
        System.out.println("--------------------------------------");

        while (playerHP > 0 && enemyHP > 0)
        {

            // Show stats
            System.out.println("\n--------------------------------------");
            System.out.println("Your HP: " + playerHP + " | Enemy HP: " + enemyHP);
            System.out.println("--------------------------------------");

            // Menu
            System.out.println("1. Attack");
            System.out.println("2. Heal (Potions: " + potions + ")");
            System.out.println("3. Power Boost (+5 Attack)");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            System.out.println("--------------------------------------");

            // PLAYER TURN
            if (choice == 1) 
            {
                System.out.println("you hit the enemy for " + playerAttack + " damage!");
                enemyHP -= playerAttack; 
            }
            else if (choice == 2 && potions > 0) 
            {
                System.out.println("You healed +20 HP!");
                playerHP += 20; 
                potions--;
            }
            else if (choice == 3)
            {
                System.out.println("Power Boost! Attack +5");
                playerAttack += 5;        
            }
            else
            {
                System.out.println("Invalid choice or no potions!");
            }

            if (enemyHP <= 0) break;
            System.out.println("Enemy hits you for " + enemyAttack + " damage!");
            playerHP -= enemyAttack;     
        }

        System.out.println("\n-----------------------------------");

        if (playerHP <= 0)
            System.out.println("You were defeated!");
        else
            System.out.println("You defeated the enemy!");

        System.out.println("-------------------------------------");
        sc.close();
    }
}
