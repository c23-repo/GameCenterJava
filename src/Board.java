import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel {

    JButton buttons[] = new JButton[9];
    int changePlayers = 0;

    public Board()
    {
        setLayout(new GridLayout(3,3));
        initializebuttons();
    }


    public void initializebuttons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new Board.buttonListener());

            add(buttons[i]);
        }
    }

    public  class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
            if (changePlayers % 2 == 0)
                buttonClicked.setText("Clicked first");
            else
                buttonClicked.setText("Clicked second");

            changePlayers++;

        }


    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Board");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Board());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}