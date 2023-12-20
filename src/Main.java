import java.awt.CardLayout;
import javax.swing.*;

/**
 * Kelas Main merupakan kelas utama yang mengendalikan fungsi utama dari aplikasi Absensi Mahasiswa.
 * Menyediakan logika navigasi antara tampilan utama, login, registrasi, dan daftar mahasiswa.
 */
public class Main extends JFrame {
    private static Main instance;
    public static CardLayout cards = new CardLayout();
    public static JPanel mainPanel = new JPanel(cards);
    private final HomeViews homeGUI = new HomeViews();
    private final ListViews listMahasiswaViews = new ListViews();
    private final LoginViews loginViews = new LoginViews();
    private final StudentRegisterView registerView = new StudentRegisterView();

    /**
     * Konstruktor untuk kelas Main.
     * Menginisialisasi GUI utama dan menampilkan tampilan awal (HomeViews).
     */
    public Main() {
        super("Absensi Mahasiswa");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 432);
        setVisible(true);

        initGUI();
        cards.show(mainPanel, HomeViews.KEY);
        add(mainPanel);
    }

    /**
     * Method untuk menginisialisasi GUI.
     * Menambahkan tampilan ke panel utama menggunakan CardLayout.
     */
    public void initGUI() {
        mainPanel.add(homeGUI, HomeViews.KEY);
        mainPanel.add(loginViews, LoginViews.KEY);
        mainPanel.add(registerView, StudentRegisterView.KEY);
        mainPanel.add(listMahasiswaViews, ListViews.KEY);
    }

    /**
     * Method untuk mendapatkan instance dari kelas Main.
     *
     * @return Instance dari kelas Main.
     */
    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    /**
     * Method untuk berpindah tampilan ke halaman yang ditentukan.
     *
     * @param page String kunci halaman yang akan ditampilkan.
     */
    public static void navigateTo(String page) {
        cards.show(mainPanel, page);
    }

    /**
     * Method utama untuk menjalankan aplikasi.
     * Membuat instance dari kelas Main dan menampilkan GUI.
     *
     * @param args Argumen baris perintah yang diabaikan.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::getInstance);
    }

    /**
     * Method untuk membuat dan menampilkan tampilan registrasi.
     *
     * @throws Exception jika terjadi kesalahan saat membuat tampilan registrasi.
     */
    public static void createAndShowReg() throws Exception {
        new StudentRegisterView();
    }
}
