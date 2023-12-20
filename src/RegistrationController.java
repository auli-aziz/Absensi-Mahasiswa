import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author Kelompok 6
 *
 */
public class RegistrationController implements ActionListener {
    
    private StudentRegisterView view;

    public RegistrationController(StudentRegisterView view) {
        this.view = view;
    }

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

    private Object[][] addRowToData(Object[][] data, Object[] row) {
        int originalLength = data.length;
        int newLength = originalLength + 1;
        Object[][] newData = Arrays.copyOf(data, newLength);
        newData[originalLength] = row;
        return newData;
    }

    protected void handleBack() {
        Main.getInstance().navigateTo(HomeViews.KEY);
        view.nameTextField.setText("");
        view.passwordField.setText("");
        view.npmTextField.setText("");
        view.facultyTextField.setText("");
        view.majorTextField.setText("");
    }
}
