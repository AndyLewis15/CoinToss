import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CoinToss extends JFrame {
    private JLabel coinLabel;
    private ImageIcon headsIcon;
    private ImageIcon tailsIcon;
    private ImageIcon sideIcon;

    public CoinToss() {
        // Create an instance of the Random class
        Random random = new Random();

        // Load the heads and tails images
        headsIcon = new ImageIcon("Heads.jpg");
        tailsIcon = new ImageIcon("Tails.jpg");
        sideIcon = new ImageIcon("Side.jpg");


        // Create the coin label
        coinLabel = new JLabel();
        coinLabel.setPreferredSize(new Dimension(headsIcon.getIconWidth(), headsIcon.getIconHeight()));
        coinLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the button
        JButton tossButton = new JButton("Toss Coin");
        tossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a coin toss
                int result = random.nextInt(25);

                // Display the corresponding image
                if (result < 12) {
                    coinLabel.setIcon(headsIcon);
                } else if (result < 24){
                    coinLabel.setIcon(tailsIcon);
                }
                else {
                    coinLabel.setIcon(sideIcon);
                }
            }
        });

        // Create the layout
        JPanel coinPanel = new JPanel();
        coinPanel.add(coinLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(tossButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(coinPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("Coin Toss Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CoinToss coinTossSimulation = new CoinToss();
                coinTossSimulation.setVisible(true);
            }
        });
    }
}
