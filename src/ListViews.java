import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ListViews extends JPanel {
    public static final String KEY = "LIST";
    private JTable mahasiswaTable, dosenTable;
    private DefaultTableModel mahasiswaTableModel, dosenTableModel;
    public static boolean userLoggedIn = false;

    public ListViews() {
        initializeUI();
    }

    protected void initializeUI() {

        mahasiswaTableModel = new DefaultTableModel(Constants.DATA, Constants.TABLE_HEADER);
        dosenTableModel = new DefaultTableModel(Constants.DATA2, Constants.TABLE_HEADER2);

        mahasiswaTable = new JTable(mahasiswaTableModel);
        dosenTable = new JTable(dosenTableModel);

        // Set lebar kolom (misalnya, setiap kolom menjadi 150 piksel)
        setColumnWidth(mahasiswaTable);
        setColumnWidth(dosenTable);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mahasiswaTable, dosenTable);
        add(splitPane);

        setVisible(true);

        mahasiswaTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object[] rowData = Constants.DATA[row];

                if (rowData[0].equals(LoginViews.getLoggedInUserName())) {
                    c.setBackground(Color.decode("#97BFB1"));
                } else {
                    c.setBackground(table.getBackground());
                }

                return c;
            }
        });
        setVisible(true);
    }

    private void setColumnWidth(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            TableColumn col = columnModel.getColumn(column);
            col.setMinWidth(150); // Atur lebar minimum
            col.setMaxWidth(200); // Atur lebar maksimum
            col.setPreferredWidth(150); // Atur lebar preferensi
        }
    }
}
