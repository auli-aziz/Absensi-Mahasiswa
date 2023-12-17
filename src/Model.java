import javax.swing.table.DefaultTableModel;

/**
 * @author Kelompok 6
 *
 */
public class Model extends DefaultTableModel {

    public Model() {
        super(Constants.DATA, Constants.TABLE_HEADER);
    }

}