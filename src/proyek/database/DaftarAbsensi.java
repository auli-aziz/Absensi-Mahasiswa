package proyek.database;

import proyek.user.Dosen;
import proyek.user.Mahasiswa;
import static proyek.user.Menu.SystemCLI.memberList;

import java.util.Calendar;

public class DaftarAbsensi {
    static public int totalDaftarMahasiswa = 0;
    private final int id;
    private final Mahasiswa member;
    private final String tanggal;
    private boolean isDone;

    public DaftarAbsensi(Mahasiswa member, String tanggal) {
        this.id = totalDaftarMahasiswa;
        this.member = member; // daftar absensi ini kepemilikan siapa
        this.tanggal = tanggal;
        this.isDone = false;
        totalDaftarMahasiswa++;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public String absen(String mahasiswa) {
        String message = String.format("Daftar Absensi %d : ", id);
        for(Mahasiswa m : memberList) {
            if(m.getNama().equals(mahasiswa)) {
                m.setHadir();
                return m.getNama() + " telah diabsensi.";
            } 

            if(m == memberList[memberList.length - 1]) {
                this.isDone = true;
            }
        }
        return message + " sudah selesai.";
    }

    @Override
    public String toString() {
        StringBuilder daftar = new StringBuilder(String.format("[ID Daftar Absensi = %d]\n", id));

        daftar.append(generateDaftarAbsensi(String.valueOf(member.getId()), tanggal));
        daftar.append("\n--- STUDENT LIST ---\n");
        int counter = 0;
        for(Mahasiswa m: memberList) {
            daftar.append(++counter + ". " + m.toString() + "\n");
        }

        return daftar.toString();
    }

    public static String generateDaftarAbsensi(String id, String tanggal) {
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(tanggal.substring(6));
        int month = Integer.parseInt(tanggal.substring(3, 5)) - 1;
        int date = Integer.parseInt(tanggal.substring(0, 2));
        cal.set(year, month, date);

        String daftar = "";
        daftar += "ID   :" + id + "\n";
        daftar += "Tanggal  : " + tanggal + "\n";

        return daftar;
    }

    public String getStatusAbsensi() {
        String message = String.format("Daftar kehadiran kelas OOP %d", id+1);
        if(isDone) {
            return message + " sudah selesai absensi.";
        }
        return message + " belum selesai absensi.";
    }
}
