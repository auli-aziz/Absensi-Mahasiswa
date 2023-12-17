public class ArrayChecker {

    //Untuk ngecek isi Array
    public static void printDataArray() {
        for (Object[] row : Constants.DATA){
            for (Object cell : row){
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
