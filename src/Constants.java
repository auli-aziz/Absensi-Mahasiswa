/**
 * Kelas Constants berisi data konstan yang digunakan dalam aplikasi.
 * Berisi informasi seperti tabel header dan data mahasiswa dan dosen.
 */
public class Constants {

    /**
     * TABLE_HEADER berisi header kolom untuk tabel data mahasiswa.
     * Kolom-kolomnya adalah "Nama", "NPM", "Password", "Fakultas", dan "Jurusan".
     */
    public static final Object[] TABLE_HEADER = { "Nama", "NPM", "Password", "Fakultas", "Jurusan" };

    /**
     * DATA berisi informasi mahasiswa yang terdiri dari beberapa array 1D.
     * Setiap elemen array menyimpan informasi mengenai nama, NPM, password, fakultas, dan jurusan mahasiswa.
     */
    public static Object[][] DATA = {
            { "AULIA ANUGRAH AZIZ", "2206059364", "passwordAziz", "Teknik", "Teknik Komputer" },
            { "CHRISTOPHER SUTANDAR", "2206810414", "passwordChristopher", "Teknik", "Teknik Komputer" },
            { "DANIEL NIKO", "2206026183", "passwordDaniel", "Teknik", "Teknik Komputer" },
            { "FARHAN NUZUL NOUFENDRI", "2206024442", "passwordNuzul", "Teknik", "Teknik Komputer" },
            { "RADITYA AKHILA GANAPATI", "2206026151", "passwordRaditya", "Teknik", "Teknik Komputer" },
    };

    /**
     * TABLE_HEADER2 berisi header kolom untuk tabel data dosen.
     * Kolom-kolomnya adalah "Nama", "NIP", "Fakultas", dan "Jurusan".
     */
    public static final Object[] TABLE_HEADER2 = { "Nama", "NIP", "Fakultas", "Jurusan" };

    /**
     * DATA2 berisi informasi dosen yang terdiri dari beberapa array 1D.
     * Setiap elemen array menyimpan informasi mengenai nama, NIP, fakultas, dan jurusan dosen.
     */
    public static Object[][] DATA2 = {
            { "Setiadi", "1231231", "Teknik", "Teknik Komputer" },
            { "Laode", "23123123", "Teknik", "Teknik Komputer" },
    };
}
