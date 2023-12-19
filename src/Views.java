import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Kelompok 6
 *
 */
public class Views {

    public Views() {
        // Membuat views swing UI components 
        JTextField searchTermTextField = new JTextField(26);
        JButton filterButton = new JButton("Filter");
        JTable table = new JTable();

        // Membuat table model
        Model model = new Model();
        table.setModel(model); 

        // Membuat controller
        Controller controller = new Controller(searchTermTextField, model);
        filterButton.addActionListener(controller);

        // Melakukan setting terhadap view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Data Mahasiswa",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display semuanya dalam scrolling window dan membuat window terlihat
        JFrame frame = new JFrame("Tugas Software Design Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}