package proyek.user.Menu;

import proyek.database.DaftarAbsensi;
import proyek.user.Mahasiswa;
import proyek.user.Mahasiswa;

import static proyek.database.AbsensiManager.listDaftarAbsensi;

import java.util.Scanner;

public class MahasiswaSystem extends SystemCLI{
    Scanner input = new Scanner(System.in);
    public static Mahasiswa[] mahasiswas;

    @Override
    protected boolean processChoice(int choice) {
        boolean logout = false;
        // switch menu ketika sudah login
        switch (choice) {
            case 1:
                System.out.print("Masukkan nama anda: ");
                String nama = input.nextLine();
                if(listDaftarAbsensi.length == 0) {
                    for(DaftarAbsensi daftar : listDaftarAbsensi) {
                        System.out.println(daftar.absen(nama));
                    }
                } else {
                    System.out.println("Daftar absensi kosong.");
                }
                break;
            case 2:
                for(DaftarAbsensi daftar : listDaftarAbsensi) {
                    System.out.println(daftar.toString());
                }
                break;
            case 3:
                logout = true;
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
        }
        return logout;
    }

    @Override
    protected void displaySpecificMenu() {
        System.out.println("1. Saya ingin absensi");
        System.out.println("2. Lihat detail absensi kelas saya");
        System.out.println("3. Logout");
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        Mahasiswa[] mahasiswaListTemp = new Mahasiswa[memberList.length + 1];

        System.arraycopy(memberList, 0, mahasiswaListTemp, 0, memberList.length);
        mahasiswaListTemp[memberList.length] = mahasiswa;

        memberList = mahasiswaListTemp;
    }
}
