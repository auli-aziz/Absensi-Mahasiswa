import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListMahasiswaViews extends JPanel {
    public static final String KEY = "LIST";
    private JTable mahasiswaTable, dosenTable;
    private JScrollPane mahasiswaScrollPane, dosenScrollPane;
    private DefaultTableModel mahasiswaTableModel, dosenTableModel;
    public static boolean userLoggedIn = false;

    public ListMahasiswaViews() {
        initializeUI();
    }

    protected void initializeUI() {
        setSize(800, 800);

        mahasiswaTableModel = new DefaultTableModel(Constants.DATA, Constants.TABLE_HEADER);
        dosenTableModel = new DefaultTableModel(Constants.DATA2, Constants.TABLE_HEADER2);

        mahasiswaTable = new JTable(mahasiswaTableModel);
        dosenTable = new JTable(dosenTableModel);

        mahasiswaScrollPane = new JScrollPane(mahasiswaTable);
        dosenScrollPane = new JScrollPane(dosenTable);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mahasiswaScrollPane, dosenScrollPane);
        add(splitPane);

        setVisible(true);

        mahasiswaTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object[] rowData = Constants.DATA[row];

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
