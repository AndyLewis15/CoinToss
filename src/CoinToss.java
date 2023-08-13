import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CoinToss extends JFrame {
    private JLabel coinLabel;
    private JLabel headsCountLabel;
    private JLabel tailsCountLabel;
    private JLabel sidesCountLabel;
    private ImageIcon headsIcon;
    private ImageIcon tailsIcon;
    private ImageIcon sideIcon;

    private int headsCount = 0;
    private int tailsCount = 0;
    private int sidesCount = 0;

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

                // Update the tally counts
                if (result < 12) {
                    headsCount++;
                } else if (result < 24) {
                    tailsCount++;
                } else {
                    sidesCount++;
                }

                // Update the tally labels
                updateTallyLabels();

                // Display the corresponding image
                if (result < 12) {
                    coinLabel.setIcon(headsIcon);
                } else if (result < 24) {
                    coinLabel.setIcon(tailsIcon);
                } else {
                    coinLabel.setIcon(sideIcon);
                }
            }
        });

        // Create the tally labels
        headsCountLabel = new JLabel("Heads: 0");
        tailsCountLabel = new JLabel("Tails: 0");
        sidesCountLabel = new JLabel("Sides: 0");
        updateTallyLabels();

        // Create the layout
        JPanel coinPanel = new JPanel();
        coinPanel.add(coinLabel);

        JPanel tallyPanel = new JPanel();
        tallyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tallyPanel.add(headsCountLabel);
        tallyPanel.add(tailsCountLabel);
        tallyPanel.add(sidesCountLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(tossButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(tallyPanel, BorderLayout.PAGE_END);
        bottomPanel.add(buttonPanel, BorderLayout.PAGE_START);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(coinPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.PAGE_END);

        // Set up the frame
        setTitle("Coin Toss Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateTallyLabels() {
        headsCountLabel.setText("Heads: " + headsCount);
        tailsCountLabel.setText("Tails: " + tailsCount);
        sidesCountLabel.setText("Sides: " + sidesCount);
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
