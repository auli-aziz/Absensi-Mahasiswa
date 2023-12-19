package proyek.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proyek.MainFrame;
import proyek.user.LoginViews;

import static proyek.database.AbsensiManager.fmt;
import static proyek.database.AbsensiManager.cal;

public class HomeGUI extends JPanel {
    public static final String KEY = "HOME";
    private JLabel titleLabel;
    private JLabel dateLabel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton loginButton;
    private JButton registerButton;

    public HomeGUI() {
        super(new BorderLayout()); // Setup layout

        // Set up main panel
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        initGUI();

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Method untuk menginisialisasi GUI.
     * Selama funsionalitas sesuai dengan soal, tidak apa apa tidak 100% sama.
     * Be creative and have fun!
     */
    private void initGUI() {
        // Modifikasi label judul
        titleLabel = new JLabel("Selamat datang di Absensi Mahasiswa!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setOpaque(true);
        add(titleLabel, BorderLayout.NORTH);

        // Membuat panel untuk button
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10));

        // Modifikasi loginButton
        loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#97BFB1"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleToLogin();
            }
        });

        // Modifikasi registerButton
        registerButton = new JButton("Register");
        registerButton.setBackground(Color.decode("#97BFB1"));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleToRegister();
            }
        });

        // Add semua button ke buttonPanel
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // memasukkan buttonPanel ke mainPanel
        mainPanel.add(buttonPanel);

        // Modifikasi label tanggal
        dateLabel = new JLabel("Hari ini: " + (String) fmt.format(cal.getTime()));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setBackground(Color.WHITE);
        dateLabel.setOpaque(true);
        add(dateLabel, BorderLayout.SOUTH);
    }

    /**
     * Method untuk pergi ke halaman register.
     * Akan dipanggil jika pengguna menekan "registerButton"
     */
    private static void handleToRegister() {
        MainFrame.getInstance().navigateTo(RegisterGUI.KEY);
    }

    /**
     * Method untuk pergi ke halaman login.
     * Akan dipanggil jika pengguna menekan "loginButton"
     */
    private static void handleToLogin() {
        MainFrame.getInstance().navigateTo(LoginViews.KEY);
    }
}
