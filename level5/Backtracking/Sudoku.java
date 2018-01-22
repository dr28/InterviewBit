package com.dr.level5.Backtracking;

import java.util.ArrayList;
/*Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'
You may assume that there will be only one unique solution.

[5  3  .  .  7  .  .  .  .]
[6  .  .  1  9  5  .  .  .]
[.  9  8  .  .  .  .  6  .]
[8  .  .  .  6  .  .  .  3]
[4  .  .  8  .  3  .  .  1]
[7  .  .  .  2  .  .  .  6]
[.  6  .  .  .  .  2  8  .]
[.  .  .  4  1  9  .  .  5]
[.  .  .  .  8  .  .  7  9]

A sudoku puzzle,

[5  3  4  6  7  8  9  1  2]
[6  7  2  1  9  5  3  4  8]
[1  9  8  3  4  2  5  6  7]
[8  5  9  7  6  1  4  2  3]
[4  2  6  8  5  3  7  9  1]
[7  1  3  9  2  4  8  5  6]
[9  6  1  5  3  7  2  8  4]
[2  8  7  4  1  9  6  3  5]
[3  4  5  2  8  6  1  7  9]


and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
See Expected Output
Seen this question in a real interview before*/
public class Sudoku {

    int N = 0;

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

        if (a.size() != a.get(0).size())
            return;

        N = a.size();
        sudoku(a, 0, 0);
    }

    boolean sudoku(ArrayList<ArrayList<Character>> A, int row, int col) {
        if (row == 9)
            return true;

        int nextRow, nextCol;

        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (A.get(row).get(col) != '.') {
            if (!isValid(A, row, col))
                return false;
            return sudoku(A, nextRow, nextCol);
        }

        for (int i = 1; i<=N; ++i) {
            A.get(row).set(col, (char)(i + '0'));
            if (isValid(A, row, col) && sudoku(A, nextRow, nextCol))
                return true;
        }
        A.get(row).set(col, '.');
        return false;
    }
    boolean isValid(ArrayList<ArrayList<Character>> A, int row, int col) {
        char elem = A.get(row).get(col);

        //check range
        if (elem - '0' < 1 || elem - '0' > 9)
            return false;

        //check row and column for duplicates
        for (int p = 0; p<N; ++p) {
            if (A.get(p).get(col) == elem && p != row)
                return false;
            if (A.get(row).get(p) == elem && p != col)
                return false;
        }

        //check 3x3 subgrid for duplicates
        int subRow = (row/3)*3; //Ex: row = 2 belongs to first subgrid, so to bring back row to index 0
        int subCol = (col/3)*3; //so as to start iterating first subgrid, we do 2/3 = 0 then 0*3 = 0.

        for (int i = subRow; i<subRow+3; ++i) {
            for (int j = subCol; j<subCol+3; ++j) {
                if (A.get(i).get(j) == elem && (i != row || j != col))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Character>> s = new ArrayList<ArrayList<Character>>();

        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add('5'); temp.add('3'); temp.add('.'); temp.add('.'); temp.add('7'); temp.add('.'); temp.add('.');
        temp.add('.'); temp.add('.');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('6'); temp.add('.'); temp.add('.'); temp.add('1'); temp.add('9'); temp.add('5'); temp.add('.');
        temp.add('.'); temp.add('.');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('.'); temp.add('9'); temp.add('8'); temp.add('.'); temp.add('.'); temp.add('.'); temp.add('.');
        temp.add('6'); temp.add('.');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('8'); temp.add('.'); temp.add('.'); temp.add('.'); temp.add('6'); temp.add('.');
        temp.add('.'); temp.add('.'); temp.add('3');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('4'); temp.add('.'); temp.add('.'); temp.add('8'); temp.add('.'); temp.add('3');
        temp.add('.'); temp.add('.'); temp.add('1');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('7'); temp.add('.'); temp.add('.'); temp.add('.'); temp.add('2'); temp.add('.');
        temp.add('.'); temp.add('.'); temp.add('6');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('.'); temp.add('6'); temp.add('.'); temp.add('.'); temp.add('.'); temp.add('.');
        temp.add('2'); temp.add('8'); temp.add('.');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('.'); temp.add('.'); temp.add('.'); temp.add('4'); temp.add('1'); temp.add('9');
        temp.add('.'); temp.add('.'); temp.add('5');
        s.add(temp);

        temp = new ArrayList<Character>();
        temp.add('.'); temp.add('.'); temp.add('.'); temp.add('.'); temp.add('8'); temp.add('.');
        temp.add('.'); temp.add('7'); temp.add('9');
        s.add(temp);

        new Sudoku().solveSudoku(s);
        System.out.println(s);

    }
}
