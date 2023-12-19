package proyek.database;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AbsensiManager {
    public static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    public static Calendar cal = Calendar.getInstance();
    public static DaftarAbsensi[] listDaftarAbsensi = new DaftarAbsensi[0];

    /**
     * Menambahkan absensi baru ke listAbsensi.
     *
     * @param daftarAbsensi absensi object untuk ditambahkan.
     */
    public static void addDaftarAbsensi(DaftarAbsensi daftarAbsensi) {
        DaftarAbsensi[] tempListDaftarAbsensi = new DaftarAbsensi[listDaftarAbsensi.length + 1];
        for(int i = 0; i < listDaftarAbsensi.length; i++) {
            tempListDaftarAbsensi[i] = listDaftarAbsensi[i];
            System.out.println("add");
        }

        // menyamakan alamat dari array
        listDaftarAbsensi = tempListDaftarAbsensi;
        listDaftarAbsensi[listDaftarAbsensi.length - 1] = daftarAbsensi;
    }
}
