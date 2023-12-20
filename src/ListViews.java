import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Kelas ListViews bertanggung jawab untuk menampilkan daftar mahasiswa dan dosen dalam tabel terpisah.
 */
public class ListViews extends JPanel {
    public static final String KEY = "LIST";
    private JTable mahasiswaTable, dosenTable;
    private DefaultTableModel mahasiswaTableModel, dosenTableModel;
    public static boolean userLoggedIn = false;

    /**
     * Konstruktor untuk kelas ListViews.
     * Menginisialisasi tampilan UI dengan tabel untuk daftar mahasiswa dan dosen.
     */
    public ListViews() {
        initializeUI();
    }

    /**
     * Method untuk menginisialisasi tampilan UI.
     * Memuat tabel untuk daftar mahasiswa dan dosen dalam satu frame menggunakan JSplitPane.
     * Tabel mahasiswa memiliki highlight pada baris yang sesuai dengan pengguna yang sedang login.
     */
    protected void initializeUI() {

        mahasiswaTableModel = new DefaultTableModel(Constants.DATA, Constants.TABLE_HEADER);
        dosenTableModel = new DefaultTableModel(Constants.DATA2, Constants.TABLE_HEADER2);

        mahasiswaTable = new JTable(mahasiswaTableModel);
        dosenTable = new JTable(dosenTableModel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mahasiswaTable, dosenTable);
        add(splitPane);

        setVisible(true);

        mahasiswaTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object[] rowData = Constants.DATA[row];

                // Menandai baris yang sesuai dengan pengguna yang sedang login dengan warna hijau
                if (rowData[0].equals(LoginViews.getLoggedInUserName())) {
                    c.setBackground(Color.GREEN);
                } else {
                    c.setBackground(table.getBackground());
                }

                return c;
            }
        });
        setVisible(true);
    }
}
