package proyek.gui;

import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static proyek.user.Menu.SystemCLI.memberList;


import proyek.ArrayChecker;
import proyek.Constants;

public class RegistrationController implements ActionListener{
    private RegisterGUI view;

    public RegistrationController(RegisterGUI view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.nameTextField.getText();
        String npm = view.npmTextField.getText();
        String faculty = view.facultyTextField.getText();
        String major = view.majorTextField.getText();

        Object[] data = {name, npm, faculty, major};
        Constants.DATA = addRowToData(Constants.DATA, data);

        ArrayChecker.printDataArray();
    }

    private Object[][] addRowToData(Object[][] data, Object[] row) {
        int originalLength = data.length;
        int newLength = originalLength + 1;
        Object[][] newData = Arrays.copyOf(data, newLength);
        newData[originalLength] = row;
        return newData;
    }
}
