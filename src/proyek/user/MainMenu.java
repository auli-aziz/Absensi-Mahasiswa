package proyek.user;

import proyek.database.AbsensiManager;
import proyek.user.Mahasiswa;
import proyek.user.Menu.DosenSystem;
import proyek.user.Menu.MahasiswaSystem;
import proyek.user.Menu.SystemCLI;

import java.util.Scanner;

import static proyek.database.AbsensiManager.cal;
import static proyek.database.AbsensiManager.fmt;

public class MainMenu {
    private final Scanner in;
    private final LoginManager loginManager;

    public MainMenu(Scanner in, LoginManager loginManager) {
        this.in = in;
        this.loginManager = loginManager;
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu(new Scanner(System.in),
        new LoginManager(new DosenSystem(), new MahasiswaSystem()));
        mainMenu.run();
    }

    public void run() {
        boolean exit = false;
        while(!exit) {
            displayMenu();
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("Selamat datang di Absensi Mahasiswa!");
        System.out.printf("Sekarang tanggal %s\n", fmt.format(cal.getTime()));
        System.out.println("1. Login");
        System.out.println("2. Register Mahasiswa");
        System.out.println("3. Exit");
        System.out.print("Apa yang ingin Anda lakukan hari ini? ");
    }

    private void login() {
        System.out.print("Masukan ID Anda: ");
        String inputId = in.nextLine();
        System.out.print("Masukan password Anda: ");
        String inputPassword = in.nextLine();
        SystemCLI systemCLI = loginManager.getSystem(inputId);
        if (systemCLI == null) {
            System.out.println("ID atau password invalid.\n");
            return;
        }
        systemCLI.login(in, inputId, inputPassword);
    }

    void register() {
        System.out.println("Masukan nama Anda: ");
        String nama = in.nextLine();
        System.out.println("Masukan NPM Anda: ");
        String npm = in.nextLine();
        while (!LoginManager.isNumeric(npm)) {
            System.out.println("Harap masukkan nomor NPM");
            npm = in.nextLine();
        }
        System.out.println("Masukan password Anda: ");
        String password = in.nextLine();

        Mahasiswa registeredMember = loginManager.register(nama, password, npm);
        if (registeredMember == null) {
            System.out.printf("User dengan nama %s dan nomor NPM %s sudah ada!\n\n", nama, npm);
            return;
        }
        System.out.printf("Berhasil membuat user dengan ID %s!\n\n", registeredMember.getId());
    }
}
