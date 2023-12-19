package proyek.gui.member.mahasiswa;

import java.lang.reflect.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import proyek.database.AbsensiManager;
import proyek.database.DaftarAbsensi;
import proyek.gui.member.AbstractMemberGUI;
import proyek.user.Mahasiswa;
import proyek.user.Menu.SystemCLI;

import static proyek.database.AbsensiManager.listDaftarAbsensi;;

public class MahasiswaSystemGUI extends AbstractMemberGUI {
    public static final String KEY = "MAHASISWA";

    public MahasiswaSystemGUI(SystemCLI systemCLI) {
        super(systemCLI);
    }

    @Override
    public String getPageName() {
        return KEY;
    }

    public Mahasiswa getLoggedInMember() {
        return loggedInMahasiswa;
    }

    @Override
    protected JButton[] createButtons() {
        // Membuat button absensi
        JButton absensiButton = new JButton("Saya ingin absensi");
        absensiButton.setBackground(Color.decode("#97BFB1"));
        absensiButton.setForeground(Color.WHITE);
        absensiButton.setPreferredSize(new Dimension(200, 50));

        // membuat button show absensi kelas
        JButton showDetailAbsensiButton = new JButton("Lihat detail absensi kelas saya");
        showDetailAbsensiButton.setBackground(Color.decode("#97BFB1"));
        showDetailAbsensiButton.setForeground(Color.WHITE);
        showDetailAbsensiButton.setPreferredSize(new Dimension(200, 50));

        return new JButton[] { absensiButton, showDetailAbsensiButton };
    }

    protected ActionListener[] createActionListeners() {
        return new ActionListener[] {
                e -> absen(),
                e -> showAbsensi(),
        };
    }

    private void absen() {
        String status = "";
        JOptionPane.showMessageDialog(this, "Masukkan nama mahasiswa: ",
                "Absen Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
        if (AbsensiManager.listDaftarAbsensi.length == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada daftar absensi yang dibuat", "Absen Result",
                    JOptionPane.ERROR_MESSAGE);
        } 
        // else {
        //     status += "<html>";
        //     for (Nota notas : NotaManager.notaList) {
        //         status += notas.kerjakan();
        //         status += "<br>";
        //     }
        //     status += "</html>";
        //     notaProses = new JLabel(status);
        //     JOptionPane.showMessageDialog(this, notaProses, "Nyuci Result", JOptionPane.INFORMATION_MESSAGE);
        // }
    }

    private void showAbsensi() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries
        scrollPane.setPreferredSize(new Dimension(400, 200));
        if (listDaftarAbsensi.length == 0) {
            textArea.setText("Daftar Absensi belum dibuat oleh dosen.");
        } else {
            String daftarAbsensiString = "";
            for (DaftarAbsensi daftar : listDaftarAbsensi) {
                daftarAbsensiString += daftar.toString();
                daftarAbsensiString += "\n";
            }
            textArea.setText(daftarAbsensiString);
        }
        JOptionPane.showMessageDialog(this, scrollPane, "Detail Absesnsi kelas", JOptionPane.INFORMATION_MESSAGE);
    }
}
