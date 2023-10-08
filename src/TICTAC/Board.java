package TICTAC;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //size
    public int size;
    public playingpeice[][]board;//inherit HAS-A relationship of class playing peice
    public Board(int size){
        this.size=size;
        board=new playingpeice[size][size];
    }
    public boolean addpeice(int row,int col,playingpeice p) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = p;//create matrix if row && col;
        return true;
    }
        //check for free cell

    public List<Pair<Integer,Integer>> getfreecells(){
        List<Pair<Integer,Integer>> freecells=new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair<Integer,Integer> p=new Pair<>(i,j);
                    freecells.add(p);
                }
            }


        }
        return freecells;

    }
    public void printboard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].piece.name() + "  ");
                } else{
                    System.out.print("   ");
                }
                System.out.print("  |  ");
            }
            System.out.println();
        }
    }
}
