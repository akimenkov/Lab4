import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Label extends JFrame {
    public void teamButton(JButton team, String teamName, Color color) {
        team.setText(teamName);
        team.setVerticalTextPosition(JButton.BOTTOM);
        team.setHorizontalTextPosition(JButton.CENTER);
        team.setForeground(color);
        team.setFont(fnt);
    }
    JButton ACMilan = new JButton();
    ImageIcon ACMilanIcon = new ImageIcon((new ImageIcon("C:\\Users\\Saint\\IdeaProjects\\lAB4AAVJAVA\\acmilan.jpg").getImage()
            .getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
    JButton RealMadrid = new JButton();
    ImageIcon RealMadridIcon = new ImageIcon(new ImageIcon("C:\\Users\\Saint\\IdeaProjects\\lAB4AAVJAVA\\madr.jpg").getImage()
            .getScaledInstance(700, 500, Image.SCALE_SMOOTH));
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel lastScore = new JLabel("N/A");
    JLabel winner = new JLabel("Winner: DRAW");
    JLabel ACMilanTeam = new JLabel("AC Milan");
    Font fnt = new Font("Bernard MT", Font.BOLD, 65);
    int ACMilanScore = 0, RealMadridScore = 0;
    public void printWinner() {
        if (ACMilanScore > RealMadridScore) {
            winner.setText("Winner: AC Milan");
        } else if (ACMilanScore < RealMadridScore) {
            winner.setText("Winner: Real Madrid");
        } else {
            winner.setText("DRAW");
        }
    }
    public void JLabelSettings(JLabel jlabel) {
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        jlabel.setForeground(Color.BLACK);
        jlabel.setFont(fnt);
    }
    Label() {
        super("Real Madrid vs AC Milan");
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1280, 800));
        ACMilan.setIcon(ACMilanIcon);
        RealMadrid.setBackground(Color.BLUE);
        ACMilan.setBackground(Color.RED);
        RealMadrid.setIcon(RealMadridIcon);
        add(ACMilan, BorderLayout.EAST);
        ActionListener ACMilanListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACMilanScore++;
                result.setText("Result: " + RealMadridScore + " X " + ACMilanScore);
                printWinner();
                lastScore.setText("Last score: AC Milan");
            }
        };
        teamButton(ACMilan, "AC Milan", Color.BLACK);
        ACMilan.addActionListener(ACMilanListener);
        add(RealMadrid, BorderLayout.WEST);
        ActionListener RealMadridListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RealMadridScore++;
                result.setText("Result: " + RealMadridScore + " X " + ACMilanScore);
                printWinner();
                lastScore.setText("Last score: Real Madrid");
            }
        };
        teamButton(RealMadrid, "Real Madrid", Color.WHITE);
        RealMadrid.addActionListener(RealMadridListener);
        add(result, BorderLayout.CENTER);
        JLabelSettings(result);
        add(winner, BorderLayout.NORTH);
        JLabelSettings(winner);
        add(lastScore, BorderLayout.SOUTH);
        JLabelSettings(lastScore);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Label();
    }
}


