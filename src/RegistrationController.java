import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author Kelompok 6
 *
 */
public class RegistrationController implements ActionListener {

    private StudentRegisterView view;

    /**
     * Konstruktor untuk RegistrationController.
     * Menerima parameter view yang digunakan untuk mengakses komponen-komponen UI.
     *
     * @param view Tampilan formulir pendaftaran mahasiswa.
     */

    public RegistrationController(StudentRegisterView view) {
        this.view = view;
    }

    /**
     * Metode yang dipanggil ketika tombol "Register" ditekan.
     * Mengambil data dari komponen-komponen UI pada StudentRegisterView,
     * menambahkannya ke array data, kembali ke tampilan utama, dan menampilkan list mahasiswa terdaftar.
     *
     * @param e Objek ActionEvent yang menandakan aksi pengguna.
     *
     * @see Constants
     * @see ListViews
     * @see ArrayChecker
     * @see HomeViews
     * @see Main
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.nameTextField.getText();
        String npm = view.npmTextField.getText();
        String pass = String.valueOf(view.passwordField.getPassword());
        String faculty = view.facultyTextField.getText();
        String major = view.majorTextField.getText();

        Object[] data = {name, npm, pass, faculty, major};
        Constants.DATA = addRowToData(Constants.DATA, data);

        handleBack();
        ListViews listMahasiswaViews = new ListViews();
        Main.mainPanel.add(listMahasiswaViews, ListViews.KEY);
        ArrayChecker.printDataArray();
    }

    /**
     * Menambahkan baris data baru ke array data yang ada.
     *
     * @param data Array data yang sudah ada.
     * @param row Baris data yang akan ditambahkan.
     * @return Array data yang baru setelah ditambahkan baris baru.
     */

    private Object[][] addRowToData(Object[][] data, Object[] row) {
        int originalLength = data.length;
        int newLength = originalLength + 1;
        Object[][] newData = Arrays.copyOf(data, newLength);
        newData[originalLength] = row;
        return newData;
    }

    /**
     * Metode yang dipanggil untuk membersihkan input pada komponen-komponen UI
     * setelah proses registrasi selesai.
     *
     * @see HomeViews
     */
    protected void handleBack() {
        Main.getInstance().navigateTo(HomeViews.KEY);
        view.nameTextField.setText("");
        view.passwordField.setText("");
        view.npmTextField.setText("");
        view.facultyTextField.setText("");
        view.majorTextField.setText("");
    }
}