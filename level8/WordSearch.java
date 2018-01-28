package com.dr.level8;

import java.util.ArrayList;
/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
or vertically neighboring. The cell itself does not count as an adjacent cell.
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.
*/
public class WordSearch {
    public int exist(final ArrayList<String> board, final String word) {
        if (board == null || word == null) {
            return 0;
        }

        int rows = board.size();
        int columns = board.get(0).length();

        if (rows == 0 || columns == 0) {
            return 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j=  0; j < columns; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean dfs(ArrayList<String> board, String word, int rowIndex, int columnIndex, int wordIndex) {
        int rows = board.size();
        int columns = board.get(0).length();

        if (rowIndex < 0 || rowIndex >= rows || columnIndex < 0 || columnIndex >= columns) {
            return false;
        } else if (board.get(rowIndex).charAt(columnIndex) != word.charAt(wordIndex)) {
            return false;
        } else if (wordIndex == word.length() - 1){
            return true;
        } else {
            return  dfs(board, word, rowIndex - 1, columnIndex, wordIndex + 1) ||
                    dfs(board, word, rowIndex + 1, columnIndex, wordIndex + 1) ||
                    dfs(board, word, rowIndex, columnIndex - 1, wordIndex + 1) ||
                    dfs(board, word, rowIndex, columnIndex + 1, wordIndex + 1);
        }
    }


    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("FEDCBECD");
        a.add("FABBGACG");
        a.add("CDEDGAEC");
        a.add("BFFEGGBA");
        a.add("FCEEAFDA");
        a.add("AGFADEAC");
        a.add("ADGDCBAA");
        a.add("EAABDDFF");

        String b = "BCDCB";
       
        if(new WordSearch().exist(a, b) == 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
