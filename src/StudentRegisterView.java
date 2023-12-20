import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kelompok 6
 *
 */
public class StudentRegisterView extends JPanel{
    public static final String KEY = "REGISTER";

    public JTextField nameTextField;
    public JTextField npmTextField;
    public JTextField facultyTextField;
    public JTextField majorTextField;
    public JPasswordField passwordField;
    private JButton backButton;

    /**
     * Konstruktor kelas StudentRegisterView.
     * Membuat dan mengatur tata letak komponen-komponen UI untuk formulir pendaftaran mahasiswa.
     *
     * @see Main
     */

    public StudentRegisterView() {
        JFrame frame = new JFrame("Registration Form");

        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 2, 10, 10));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Membuat views swing UI components
        nameTextField = new JTextField(26);
        npmTextField = new JTextField(26);
        facultyTextField = new JTextField(26);
        majorTextField = new JTextField(26);

        // Dimension textFieldSize = new Dimension(300, 30);
        // nameTextField.setPreferredSize(textFieldSize);
        // npmTextField.setPreferredSize(textFieldSize);
        // facultyTextField.setPreferredSize(textFieldSize);
        // majorTextField.setPreferredSize(textFieldSize);

        passwordField = new JPasswordField();

        backButton = new JButton("Kembali");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBack();
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegistrationController(this));

        // Dimension buttonSize = new Dimension(150, 40);
        // registerButton.setPreferredSize(buttonSize);

        add(new JLabel("Name:"));
        add(nameTextField);
        add(new JLabel("Masukkan password Anda:"));
        add(passwordField);
        add(new JLabel("NPM:"));
        add(npmTextField);
        add(new JLabel("Faculty:"));
        add(facultyTextField);
        add(new JLabel("Major:"));
        add(majorTextField);
        add(backButton);
        add(registerButton);

        // frame.getContentPane().add(panel);
        // frame.pack();
        // frame.setLocationRelativeTo(null); //center
    }
    /**
     * Metode yang dipanggil ketika tombol "Kembali" ditekan.
     * Kembali ke tampilan utama dan menghapus semua input pada TextField.
     *
     * @see HomeViews
     * @see Main
     */

    protected void handleBack() {
        Main.getInstance().navigateTo(HomeViews.KEY);
        nameTextField.setText("");
        passwordField.setText("");
        npmTextField.setText("");
        facultyTextField.setText("");
        majorTextField.setText("");
    }

}