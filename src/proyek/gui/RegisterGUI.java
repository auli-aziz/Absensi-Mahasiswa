package proyek.gui;

import javax.swing.*;

import proyek.MainFrame;

import java.awt.*;
import java.awt.event.*;

public class RegisterGUI extends JPanel {
    public static final String KEY = "REGISTER";
    public JTextField nameTextField;
    public JTextField npmTextField;
    public JTextField facultyTextField;
    public JTextField majorTextField;
    public JPasswordField passwordTextField;
    private JButton backButton;

    public RegisterGUI() {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7, 2, 10, 10));
        setBackground(Color.WHITE);

        initGUI();
    }

    private void initGUI() {
        // Membuat views swing UI components 
        nameTextField = new JTextField(26);
        npmTextField = new JTextField(26);
        passwordTextField = new JPasswordField(26);
        facultyTextField = new JTextField(26);
        majorTextField = new JTextField(26);

        Dimension textFieldSize = new Dimension(300, 30);
        nameTextField.setPreferredSize(textFieldSize);
        npmTextField.setPreferredSize(textFieldSize);
        facultyTextField.setPreferredSize(textFieldSize);
        majorTextField.setPreferredSize(textFieldSize);

        backButton = new JButton("Kembali");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBack();
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegistrationController(this));

        Dimension buttonSize = new Dimension(150, 40);
        registerButton.setPreferredSize(buttonSize);

        add(new JLabel("Name:"));
        add(nameTextField);
        add(new JLabel("NPM:"));
        add(npmTextField);
        add(new JLabel("Faculty:"));
        add(facultyTextField);
        add(new JLabel("Major:"));
        add(majorTextField);
        add(new JLabel("Password:"));
        add(passwordTextField);
        add(backButton);
        add(registerButton);
    }

    private void handleBack() {
        MainFrame.getInstance().navigateTo(HomeGUI.KEY);
        nameTextField.setText("");
        npmTextField.setText("");
        facultyTextField.setText("");
        majorTextField.setText("");
    }
}
