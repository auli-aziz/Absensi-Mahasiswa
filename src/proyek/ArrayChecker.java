package proyek;

import static proyek.user.Menu.SystemCLI.memberList;

import proyek.user.Mahasiswa;

public class ArrayChecker {

    //Untuk ngecek isi Array
    public static void printDataArray() {
        // for (Mahasiswa m : memberList){
        //     System.out.println(m );
        // }
        for (Object[] row : Constants.DATA){
            for (Object cell : row){
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}