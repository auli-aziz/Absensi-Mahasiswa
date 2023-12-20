import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Kelas LoginController bertanggung jawab untuk mengontrol logika dari proses login pengguna.
 * Menangani interaksi antara tampilan login dan model data untuk otentikasi pengguna.
 */
public class LoginController implements ActionListener {
    private DefaultTableModel model;
    private JTextField userTextField;
    private JTextField NPMTextField;
    private JPasswordField passwordField;

    /**
     * Konstruktor untuk kelas LoginController.
     * Menerima JTextField untuk nama pengguna, NPM, dan JPasswordField untuk kata sandi.
     *
     * @param nama     JTextField untuk nama pengguna.
     * @param NPM      JTextField untuk NPM pengguna.
     * @param password JPasswordField untuk kata sandi pengguna.
     */
    public LoginController(JTextField nama, JTextField NPM, JPasswordField password) {
        super();
        this.userTextField = nama;
        this.NPMTextField = NPM;
        this.passwordField = password;
    }

    /**
     * Metode actionPerformed dari ActionListener interface.
     * Menangani aksi yang dilakukan ketika tombol login diklik.
     *
     * @param e ActionEvent yang terjadi, mengandung informasi mengenai aksi yang dilakukan.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = userTextField.getText();
        String npm = NPMTextField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (!"".equals(name) && !"".equals(npm) && !"".equals(password)) {
            for (Object[] o : Constants.DATA) {
                if (o[0].equals(name) && o[1].equals(npm) && o[2].equals(password)) {
                    // Set flag bahwa user sudah login
                    ListViews.userLoggedIn = true;
                    LoginViews.handleSuccessfulLogin(name);

                    // Pindah ke ListMahasiswaViews
                    ListViews listMahasiswaViews = new ListViews();

                    // Tutup frame LoginViews
                    // ((LoginViews) userTextField.getTopLevelAncestor()).dispose();
                    Main.navigateTo("LIST");

                    return;
                }
            }

            for (Object[] o : Constants.DATA2) {
                if (o[0].equals(name) && o[1].equals(npm) && o[2].equals(password)) {
                    // Set flag bahwa user sudah login
                    ListViews.userLoggedIn = true;
                    LoginViews.handleSuccessfulLogin(name);

                    // Pindah ke ListMahasiswaViews
                    ListViews listMahasiswaViews = new ListViews();

                    // Tutup frame LoginViews
                    // ((LoginViews) userTextField.getTopLevelAncestor()).dispose();
                    Main.navigateTo("LIST");

                    return;
                }
            }
            JOptionPane.showMessageDialog(null,
                    "Input is Incorrect", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Field cannot be empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
