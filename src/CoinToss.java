import java.util.Random;
import java.util.Scanner;
public class CoinToss {
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {

        Random random = new Random();
        System.out.println("Enter how many flips you want:");
        int userTosses = scnr.nextInt();

        int numTosses = userTosses;



        for (int i = 0; i < numTosses; i++) {
            int result = random.nextInt(2); // 0 represents heads, 1 represents tails


            if (result == 0) {
                System.out.println("Toss " + (i + 1) + ": Heads");
            } else {
                System.out.println("Toss " + (i + 1) + ": Tails");
            }
        }
    }
}
