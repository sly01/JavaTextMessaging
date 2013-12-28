
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author erkoc
 */
public class Main extends JFrame {

    public static void main(String[] args) {

        final StringBuffer test = new StringBuffer();

        JFrame frame = new JFrame();
        frame.setTitle("Text Message Application");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        int counter = 0;

        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        JLabel lbl3 = new JLabel();
        JLabel lbl4 = new JLabel();
        JLabel lbl5 = new JLabel();
        JLabel lbl6 = new JLabel();
        final JTextField txtField = new JTextField(30);
        final JLabel lblFrame = new JLabel();
        final JTextArea txtArea  = new JTextArea();
        txtArea.setEditable(false);
        JButton send = new JButton("Send");
        JButton space = new JButton("Space");
        JButton backSpace = new JButton("BackSpace");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel bos = new JLabel();
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(4, 2));
        panel1.add(txtArea);
        panel2.add(lbl1);
        panel2.add(lbl2);
        panel2.add(lbl3);
        panel2.add(lbl4);
        panel2.add(lbl5);
        panel2.add(lbl6);
        panel2.add(txtField);
        panel2.add(send);
        panel3.setLayout(new GridLayout(4, 1));

        String row1 = "1234567890";
        String row2 = "qwertyuiop";
        String row3 = "asdfghjkl;";
        String row4 = "zxcvbnm,./";
        String[] rows = {row1, row2, row3, row4};
        for (int i = 0; i < rows.length; i++) {
            char[] keys = rows[i].toCharArray();
            for (int j = 0; j < keys.length; j++) {
                JButton buton = new JButton(Character.toString(keys[j]));
                counter++;
                buton.setSize(5, 5);
                panel3.add(buton);
                if (counter == 10) {
                    panel3.add(backSpace);
                }

                panel3.add(space);



                buton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.append(e.getActionCommand());
                        txtField.setText(test.toString());
                    }
                });
            }
        }

        send.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtArea.append(txtField.getText()+"\n"+"\n");
                txtField.setText("");
                test.delete(0, test.length());
                
            }
        });

        backSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //String s = txtField.getText();
              if(txtField.getText().length() ==0)
                  return;
                test.setLength(test.length()-1);
                txtField.setText(test.toString());
            }
        });
        space.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test.append(" ");
            }
        });
       
        panel2.setBackground(Color.black);
        panel3.setBackground(Color.white);


        Container container = frame.getContentPane();
        container.add(panel1, BorderLayout.NORTH);
        container.add(panel2, BorderLayout.CENTER);
        container.add(panel3, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
