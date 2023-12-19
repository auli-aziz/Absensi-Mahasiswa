package proyek.gui.member.dosen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.Dimension;

import static proyek.database.AbsensiManager.addDaftarAbsensi;

import java.awt.Color;
import java.awt.event.ActionListener;

import proyek.gui.member.AbstractMemberGUI;
import proyek.user.Menu.SystemCLI;
import proyek.database.DaftarAbsensi;
import proyek.database.AbsensiManager;

public class DosenSystemGUI extends AbstractMemberGUI {
    public static final String KEY = "DOSEN";
    private JLabel absensiStatus;
    private JLabel absensiProses;

    public DosenSystemGUI(SystemCLI systemCLI) {
        super(systemCLI);
    }

    @Override
    public String getPageName() {
        return KEY;
    }

    /**
     * Method ini mensupply buttons yang sesuai dengan requirements Dosen.
     * Button yang disediakan method ini BELUM memiliki ActionListener.
     *
     * @return Array of JButton, berisi button yang sudah stylize namun belum ada
     *         ActionListener.
     */
    @Override
    protected JButton[] createButtons() {
        JButton absenButton = new JButton("Masukkan nama mahasiswa: ");
        absenButton.setBackground(Color.decode("#97BFB1"));
        absenButton.setForeground(Color.WHITE);
        absenButton.setPreferredSize(new Dimension(200, 50));

        JButton cekStatusAbsensiButton = new JButton("Cek Status Daftar Absensi");
        cekStatusAbsensiButton.setBackground(Color.decode("#97BFB1"));
        cekStatusAbsensiButton.setForeground(Color.WHITE);
        cekStatusAbsensiButton.setPreferredSize(new Dimension(200, 50));

        // JButton addDaftarAbsensiButton = new JButton("Add Daftar Absensi");
        // addDaftarAbsensiButton.setBackground(Color.decode("#97BFB1"));
        // addDaftarAbsensiButton.setForeground(Color.WHITE);
        // addDaftarAbsensiButton.setPreferredSize(new Dimension(200, 50));

        return new JButton[] { absenButton, cekStatusAbsensiButton };
    }

    /**
     * Method ini mensupply ActionListener korespondensi dengan button yang dibuat
     * createButtons()
     * sesuai dengan requirements MemberSystem.
     *
     * @return Array of ActionListener.
     */
    @Override
    protected ActionListener[] createActionListeners() {
        return new ActionListener[] {
                e -> absen(),
                e -> displayStatusAbsensi(),
                // e -> addDaftarAbsensi()
        };
    }

    /**
     * Menampilkan semua Absensi yang ada pada sistem.
     * Akan dipanggil jika pengguna menekan button pertama pada createButtons
     */
    private void displayStatusAbsensi() {
        // display semua status absensi yang ada
        String daftarAbsensi = "";
        if (AbsensiManager.listDaftarAbsensi.length == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada Daftar Absensi", "List Daftar Absensi", JOptionPane.ERROR_MESSAGE);
        } else {
            daftarAbsensi += "<html>";
            for (DaftarAbsensi daftarAbsensis : AbsensiManager.listDaftarAbsensi) {
                daftarAbsensi += daftarAbsensis.getStatusAbsensi();
                daftarAbsensi += "<br>";
            }
            daftarAbsensi += "</html>";
            absensiStatus = new JLabel(daftarAbsensi);
            JOptionPane.showMessageDialog(this, absensiStatus, "Status Absensi", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void absen() {
        JOptionPane.showMessageDialog(this, "Masukkan nama mahasiswa: ",
                "Absen Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
        if (AbsensiManager.listDaftarAbsensi.length == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada daftar absensi yang dibuat", "Absen Result",
                    JOptionPane.ERROR_MESSAGE);
        } else {
        }
    }

    // public void actionPerformed(ActionEvent e)
    // {
    //     String s = e.getActionCommand();
    //     if (s.equals("submit")) {
    //         l.setText(t.getText());
 
    //         t.setText("  ");
    //     }
    // }
}
