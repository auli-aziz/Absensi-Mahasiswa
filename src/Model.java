import javax.swing.table.DefaultTableModel;

/**
 * Kelas Model merupakan turunan dari DefaultTableModel.
 * Menyediakan model data untuk tampilan tabel dengan data dan header yang telah ditentukan.
 */
public class Model extends DefaultTableModel {

    /**
     * Konstruktor untuk kelas Model.
     * Menginisialisasi model data dengan data dan header yang telah ditentukan pada kelas Constants.
     */
    public Model() {
        super(Constants.DATA, Constants.TABLE_HEADER);
    }

}
