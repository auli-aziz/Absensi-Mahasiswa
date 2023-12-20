import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Kelas Controller bertindak sebagai pengontrol untuk interaksi antara view dan model.
 * Implementasi ActionListener untuk mengatur aksi yang dilakukan ketika ada interaksi dengan komponen GUI.
 *
 * Kelas ini merupakan bagian dari aplikasi yang terkait dengan pengelolaan tampilan dan manipulasi data.
 */
public class Controller implements ActionListener {
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;

    /**
     * Konstruktor untuk kelas Controller.
     *
     * @param searchTermTextField JTextField yang digunakan untuk memasukkan kata kunci pencarian.
     * @param model              DefaultTableModel yang merepresentasikan model data pada tabel.
     */
    public Controller(JTextField searchTermTextField, DefaultTableModel model) {
        super();
        this.searchTermTextField = searchTermTextField;
        this.model = model;
    }

    /**
     * Metode actionPerformed dari ActionListener interface.
     * Menangani aksi yang terjadi ketika tombol atau input lainnya diklik atau diaktifkan.
     *
     * @param e ActionEvent yang terjadi, mengandung informasi mengenai aksi yang dilakukan.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchTermTextField.getText();
        if (searchTerm != null && !"".equals(searchTerm)) {
            Object[][] newData = new Object[Constants.DATA.length][];
            int idx = 0;
            for (Object[] o : Constants.DATA) {
                if ("*".equals(searchTerm.trim())) {
                    newData[idx++] = o;
                } else {
                    if (String.valueOf(o[0]).startsWith(searchTerm.toUpperCase().trim())) {
                        newData[idx++] = o;
                    }
                }
            }
            model.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
