/**
 * Kelas ArrayChecker berfungsi untuk mengecek isi dari sebuah array.
 */
public class ArrayChecker {

    /**
     * Metode printDataArray() digunakan untuk mencetak isi dari array yang disimpan dalam Constants.DATA.
     * Metode ini melakukan iterasi melalui setiap elemen array dan mencetak nilai dari setiap elemen.
     */
    public static void printDataArray() {
        for (Object[] row : Constants.DATA){
            for (Object cell : row){
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
