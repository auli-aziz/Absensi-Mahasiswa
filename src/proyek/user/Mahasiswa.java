package proyek.user;

public class Mahasiswa {
    protected String id;
    protected String password;
    protected String nama;
    private String NPM;
    private boolean isHadir;

    public Mahasiswa(String nama, String id, String password, String NPM) {
        this.nama = nama;
        this.id = id;
        this.password = password;
        this.NPM = NPM;
    }

    public Mahasiswa(Dosen dosen1, Dosen dosen2) {}

    /**
     * Method otentikasi mahasiswa dengan ID dan password yang diberikan.
     *
     * @param id       -> ID anggota yang akan diautentikasi.
     * @param password -> password anggota untuk mengautentikasi.
     * @return true jika ID dan password sesuai dengan instance mahasiswa, false jika
     *         tidak.
     */
    public boolean login(String id, String password) {
        return id.equals(this.id) && this.password.equals(password);
    }
    
    public String getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setHadir() {
        this.isHadir = true;
    }

    @Override
    public String toString() {
        return this.getNama() + " (" + this.NPM +") | Kehadiran: " + this.isHadir;
    }

    public Mahasiswa getMahasiswa(String nama) {
        if(this.nama.equals(nama)) {
            return this;
        }
        return null;
    }
}
