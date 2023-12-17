package proyek.user;

public class Dosen extends Mahasiswa {
    public static int dosenCount = 0;

    public Dosen(String nama, String password) {
        super(nama, generateId(nama), password, "0");
    }

    private static String generateId(String nama) {
        String dosenID = nama.split(" ")[0].toUpperCase() + "-" + String.valueOf(dosenCount) + "-DOSEN";
        dosenCount++;
        return dosenID;
    }
}
