import java.util.Random;
import java.util.Scanner;
public class CoinToss {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter how many flips you want:");
        int userTosses = scnr.nextInt();

        int numTosses = userTosses;

        int headsCount = 0;
        int tailsCount = 0;


        for (int i = 0; i < numTosses; i++) {
            int result = random.nextInt(2); // 0 represents heads, 1 represents tails

            if (result == 0) {
                headsCount++;
            } else {
                tailsCount++;
            }


            System.out.println("Toss " + (i + 1) + ": " + (result == 0 ? "Heads" : "Tails"));
        }

        // Print the statistics
        System.out.println("Number of Heads: " + headsCount);
        System.out.println("Number of Tails: " + tailsCount);
    }
}
