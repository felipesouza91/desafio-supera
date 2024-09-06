import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static void main(String[] args) {
        int[][] vet1 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[][] vet2 = new int[][]{
                {1,2,3,1},
                {4,5,6,4},
                {7,8,9,7},
                {7,8,9,7}
        };
        int[][] vet3 = new int[][]{
                {1,2,3,1},
                {4,5,6,4},
        };
        int[][] vet4 = new int[][]{
                {1,2,3,4},
                {14,15,16,5},
                {13,20,17,6},
                {12,19,18,7},
                {11,10,9,8}
        };
        int[][] vet5 = new int[][]{};
        System.out.println(snailOrder(vet1));
        System.out.println(snailOrder(vet2));
        System.out.println(snailOrder(vet3));
        System.out.println(snailOrder(vet4));
        System.out.println(snailOrder(vet5));
    }


    public static List<Integer> snailOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        if( matrix == null || matrix.length == 0) {
            return list;
        }
        int rowStart = 0;
        int rowFinish = matrix.length;

        int colStart =0;
        int colFinsh = matrix[0].length;
        while (rowStart <  rowFinish && colStart < colFinsh) {
            for(int col = colStart; col < colFinsh; col++) {
                list.add(matrix[rowStart][col]);
            }
            rowStart++;
            for(int row = rowStart; row < rowFinish; row++) {
                list.add(matrix[row][colFinsh-1]);
            }
            colFinsh--;
            if(rowStart < rowFinish) {
                for(int col = colFinsh; col > colStart; col--) {
                    list.add(matrix[rowFinish-1][col-1]);
                }
                rowFinish--;
            }
            if(colStart < colFinsh) {
                for(int row = rowFinish; row > rowStart; row--) {
                    list.add(matrix[row-1][colStart]);
                }
                colStart++;
            }
        }
        return list;
    }
}
