package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        //use hashset to store unique elements from each row, each col, and each box
        Set<String> seenNums = new HashSet<>();
        //loop through the board to store each element into the hashset
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                //if the currentChar is not equal to empty element('.'), then add element to hashset
                if(currentChar != '.') {
                    //hashset.add() returns true if it can add value to the hashset
                    //hashset.add() returns false, if the current element is already present in the hashset
                    //if it returns false either 'for adding row element' or 'for adding col element' or 'for adding box element'
                    //means the element is not a unique one, thus return false;
                    //as each 3 rows, 3 cols forms a box, divide row by 3, col by 3 to get the box number it is in.
                    if(!seenNums.add(currentChar + " found at row " + i) ||
                    !seenNums.add(currentChar + " found at col " + j) ||
                    !seenNums.add(currentChar + " found at box " + (i/3) + (j/3))) {
                        return  false;
                    }
                    //if board has duplicate elements, hashset looks like
                    /* ["5 found at row 0", "5 found at col 0", "5 found at box 0",
                        "3 found at row 0", "3 found at col 1", "3 found at box 0",
                    duplicate -> "5 found at row 0", "5 found at col 2", "5 found at box 0"]
                      */
                }
            }
        }
        //if we didn't return false earlier in the above for loop, means every element at (row , col, box) positions are unique
        return  true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
}
