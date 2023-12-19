package proyek.gui.member;

import proyek.user.Mahasiswa;
import proyek.user.Menu.SystemCLI;
import proyek.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMemberGUI extends JPanel implements Loginable{
    private JLabel welcomeLabel;
    private JLabel loggedInAsLabel;
    protected Mahasiswa loggedInMahasiswa;
    private final SystemCLI systemCLI;

    public AbstractMemberGUI(SystemCLI systemCLI) {
        super(new BorderLayout());
        this.systemCLI = systemCLI;
        setBackground(Color.WHITE);

        // Set up welcome label
        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.NORTH);

        // Set up footer
        loggedInAsLabel = new JLabel("", SwingConstants.CENTER);
        add(loggedInAsLabel, BorderLayout.SOUTH);

        // Initialize buttons
        JPanel buttonsPanel = initializeButtons();
        add(buttonsPanel, BorderLayout.CENTER);
    }

    protected JPanel initializeButtons() {
        JButton[] buttons = createButtons();
        ActionListener[] listeners = createActionListeners();

        if (buttons.length != listeners.length) {
            System.out.println(buttons.length);
            System.out.println(listeners.length);
            throw new IllegalStateException("Number of buttons and listeners must be equal.");
        }

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            button.addActionListener(listeners[i]);
            buttonsPanel.add(button, gbc);
        }

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.decode("#97BFB1"));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setPreferredSize(new Dimension(200, 50));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().logout();
            }
        });
        buttonsPanel.add(logoutButton, gbc);
        return buttonsPanel;
    }

    public boolean login(String id, String password) {
        // autheticate user id dan password, jika berhasil set welcome
        loggedInMahasiswa = systemCLI.authUser(id, password);
        if (loggedInMahasiswa == null) {
            return false;
        } else {
            welcomeLabel.setText("Welcome! " + loggedInMahasiswa.getNama());
            loggedInAsLabel.setText("logged in as " + loggedInMahasiswa.getId());
            return loggedInMahasiswa.login(id, password);
        }
    }

    public void logout() {
        loggedInMahasiswa = null;
    }

    protected abstract JButton[] createButtons();

    protected abstract ActionListener[] createActionListeners();

}
