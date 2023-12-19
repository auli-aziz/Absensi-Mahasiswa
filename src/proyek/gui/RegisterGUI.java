package proyek.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterGUI extends JPanel {
    public static final String KEY = "REGISTER";
    public JTextField nameTextField;
    public JTextField npmTextField;
    public JTextField facultyTextField;
    public JTextField majorTextField;

    public RegisterGUI() {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Membuat views swing UI components 
        nameTextField = new JTextField(26);
        npmTextField = new JTextField(26);
        facultyTextField = new JTextField(26);
        majorTextField = new JTextField(26);

        Dimension textFieldSize = new Dimension(300, 30);
        nameTextField.setPreferredSize(textFieldSize);
        npmTextField.setPreferredSize(textFieldSize);
        facultyTextField.setPreferredSize(textFieldSize);
        majorTextField.setPreferredSize(textFieldSize);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegistrationController(this));

        Dimension buttonSize = new Dimension(150, 40);
        registerButton.setPreferredSize(buttonSize);

        panel.add(new JLabel("Name:"));
        panel.add(nameTextField);
        panel.add(new JLabel("NPM:"));
        panel.add(npmTextField);
        panel.add(new JLabel("Faculty:"));
        panel.add(facultyTextField);
        panel.add(new JLabel("Major:"));
        panel.add(majorTextField);
        panel.add(registerButton);

        // frame.getContentPane().add(panel);
        // frame.pack();
        // frame.setLocationRelativeTo(null); //center
        // frame.setVisible(false); //visibility
    }
}
