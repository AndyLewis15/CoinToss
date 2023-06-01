import java.util.Random;

public class CoinToss {
    public static void main(String[] args) {
        // Create an instance of the Random class
        Random random = new Random();

        // Simulate a coin toss
        int result = random.nextInt(2); // 0 represents heads, 1 represents tails

        // Print the result
        if (result == 0) {
            System.out.println("Heads");
        } else {
            System.out.println("Tails");
        }
    }
}