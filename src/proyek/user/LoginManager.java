package proyek.user;

import proyek.user.Menu.DosenSystem;
import proyek.user.Menu.MahasiswaSystem;
import proyek.user.Menu.SystemCLI;

public class LoginManager {
    private final DosenSystem dosenSystem;
    private final MahasiswaSystem mahasiswaSystem;

    public LoginManager(DosenSystem dosenSystem, MahasiswaSystem mahasiswaSystem) {
        this.dosenSystem = dosenSystem;
        this.mahasiswaSystem = mahasiswaSystem;
    }

    public SystemCLI getSystem(String id) {
        if (dosenSystem.isMemberExist(id)) {
            return dosenSystem;
        } else if (mahasiswaSystem.isMemberExist(id)) {
            return mahasiswaSystem;
        } 
        return null;
    }

    public static String generateId(String nama) {
        int idNumber = 0;

        String id = "";
        id += (nama.split(" ")[0] + "-").toUpperCase();
        id += Integer.toString(idNumber);

        idNumber++;
        return id;
    }

    public Mahasiswa register(String nama, String password, String NPM) {
        // cek ketersediaan member dengan id, jika belum maka akan dimasukkan ke dalam
        // member array
        if (mahasiswaSystem.isMemberExist(generateId(nama))) {
            return null;
        } else {
            Mahasiswa mahasiswaEntry = new Mahasiswa(nama, generateId(nama), password, NPM);
            // getSystem(generateId(nama, noHp));
            mahasiswaSystem.addMahasiswa(mahasiswaEntry);
            return mahasiswaEntry;
        }
    }

    public static boolean isNumeric(String str) {
        // cek numerik
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
