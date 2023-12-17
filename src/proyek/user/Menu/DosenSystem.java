package proyek.user.Menu;

import proyek.user.Dosen;
import proyek.user.Mahasiswa;
import proyek.database.AbsensiManager;
import proyek.database.DaftarAbsensi;

import static proyek.database.AbsensiManager.listDaftarAbsensi;

import java.util.Scanner;

public class DosenSystem extends SystemCLI{
    Scanner input = new Scanner(System.in);
    
    public DosenSystem() {
        memberList = new Dosen[] {
                new Dosen("Gde Dharma", "pakGede"),
                new Dosen("Firdaus Syawaludin", "pakDaus")
        };
    }

    /**
     * Memproses pilihan dari dosen yang masuk ke sistem ini sesuai dengan menu
     * specific.
     *
     * @param choice -> pilihan pengguna.
     * @return true jika user log.
     */
    @Override
    protected boolean processChoice(int choice) {
        boolean logout = false;
        // switch menu ketika sudah login
        switch (choice) {
            case 1:
            System.out.print("Masukkan nama mahasiswa: ");
                String nama = input.nextLine();
                for(DaftarAbsensi daftar : listDaftarAbsensi) {
                    System.out.println(daftar.absen(nama));
                }
                break;
            case 2:
                if(listDaftarAbsensi.length != 0) {
                    for(DaftarAbsensi d : listDaftarAbsensi) {
                        System.out.println(d.getStatusAbsensi());
                    }
                } else {
                    System.out.println("Tidak ada daftar Absensi!");
                }
                break;
            case 3:
                generateDaftarAbsensi();
                break;
            case 4:
                logout = true;
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
        }
        return logout;
    }

    /**
     * Displays specific menu untuk Dosen.
     */
    @Override
    protected void displaySpecificMenu() {
        System.out.println("1. Absensi Mahasiswa");
        System.out.println("2. Cek Status Daftar Absensi");
        System.out.println("3. Add daftar absensi");
        System.out.println("4. Logout");
    }

    public void addDosen(Dosen[] dosen) {
        Mahasiswa[] result = new Mahasiswa[dosen.length + memberList.length];

        System.arraycopy(memberList, 0, result, 0, memberList.length);
        System.arraycopy(dosen, 0, result, memberList.length, dosen.length);

        memberList = result;
    }
    

    private void generateDaftarAbsensi() {
        DaftarAbsensi daftar = new DaftarAbsensi(this.loginMember, AbsensiManager.fmt.format(AbsensiManager.cal.getTime()));

        AbsensiManager.addDaftarAbsensi(daftar);
        System.out.println("Add Daftar Absensi berhasil!");
    }

    @Override
    public boolean isMemberExist(String id) {
        for (Mahasiswa member : memberList) {
            if (member.getId().equals(id) && member.getId().contains("DOSEN")) {
                return true;
            }
        }
        return false;
    }
}
