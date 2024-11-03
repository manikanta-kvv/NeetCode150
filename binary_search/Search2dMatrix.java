package binary_search;

public class Search2dMatrix {

    /* just like a binary search, but search in the rows first if the target belongs to any one of the rows
     * topRowPointer to indicate top row and bottomRowPointer to indicate bottom row
     * as we find the middle element in binary search, just do the same to calculate the middle row
     * as the matrix is sorted,
     * if the target > middle row's last element (matrix[middleRow][m-1]),
     * search in the second half of the matrix from middle row to bottom row
     * if the target < middle row's first element (matrix[middleRow][0]),
     * search in the first half of the matrix from top row to middle row
     *  if the target is within the middle row, then check for the target in the middle row using binary search
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; //rows
        int m = matrix[0].length; //cols

        int topRowPointer = 0;
        int bottomRowPointer = n - 1;

        while(topRowPointer <= bottomRowPointer) {
            int middleRow = (topRowPointer + bottomRowPointer) / 2;
            if(target > matrix[middleRow][m-1]) {
                topRowPointer = middleRow + 1;
            }
            else if(target < matrix[middleRow][0]) {
                bottomRowPointer = middleRow - 1;
            }
            //means we are at the correct row where the target may be found
            else break;
        }

        //as we are at the correct row, search in this row using binary search
        int currentRow = (topRowPointer + bottomRowPointer) / 2;
        int left = 0;
        int right = m - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(target > matrix[currentRow][middle]) {
                left = middle + 1;
            }
            else if(target < matrix[currentRow][middle]) {
                right = middle - 1;
            }
            else return true;
        }

        return false;

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }
}
