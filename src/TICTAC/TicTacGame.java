package TICTAC;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacGame {
    Deque<player> players;
    Board gameboard;
    public void intializegame(){
        //creating 2 playerr.
        //WELCOME TO TIC - TAC TOE GAME::
        players=new LinkedList<>();//create deque for easy remove and addfirst of cross and nough
        System.out.println(" WHAT YOU WANT TO CHOOSE::: " + piecetype.X + " OR " + piecetype.O);
        Scanner sc=new Scanner(System.in);
        String convert1=String.valueOf(piecetype.X);
        String Choose=sc.nextLine();
        if(Choose.equals(convert1)) {
            playingX cross = new playingX();//create object for cross
            player p1 = new player("PLAYER1", cross);//initialize player 1  by intialize player constructor;
            players.add(p1);


        }
        playingO nough=new playingO();
        player p2=new player("PLAYER2",nough);
        players.add(p2);
        //initializa board;
        System.out.print("THE BOARD IS 3 X 3 ");
        System.out.println();
        gameboard=new Board(3);
    }
    public String startGame(){
        boolean nowinner=true;
        while(nowinner){

            //take out the player whose turn is and also put the player in list back;
            player playerturn=players.removeFirst();

            //get the free space from board
            gameboard.printboard();
            List<Pair<Integer,Integer>> freepsace=gameboard.getfreecells();
            if(freepsace.isEmpty()){
                nowinner=false;
                continue;
            }

            //read the user input;
            System.out.print("PLAYER : " + playerturn.name + " ENTER ROW ,COLOUMN : ");
            Scanner inputscan=new Scanner(System.in);
            String s=inputscan.nextLine();
            String[] values=s.split(",");
            int inputrow=Integer.valueOf(values[0]);
            int iputcol=Integer.valueOf(values[1]);

            //place the piece
            boolean peiceadd=gameboard.addpeice(inputrow,iputcol,playerturn.p);
            if(!peiceadd){
                //player cannot choose that cell they have to another cell;
                System.out.println("incorrect postion::,try again");
                players.addFirst(playerturn);
                continue;
            }
            players.addLast(playerturn);
            boolean winner =iswinner(inputrow,iputcol,playerturn.p.piece);
            if(winner){
                gameboard.printboard();
                return playerturn.name;
            }
        }
        return "tie";
    }
    public boolean iswinner(int row,int col,piecetype p) {
        boolean rowmatch = true;
        boolean colmatch = true;
        boolean diagmatch = true;
        boolean antidiagmatch = true;
        //row check
        for (int i = 0; i < gameboard.size; i++) {
            if (gameboard.board[row][i] == null || gameboard.board[row][i].piece != p) {
                rowmatch = false;

            }
        }
        //col check
        for (int j = 0; j < gameboard.size; j++) {
            if (gameboard.board[j][col] == null || gameboard.board[j][col].piece != p) {
                colmatch = false;
            }

        }
            //diagnoal check
        for(int i=0,j=0;i<gameboard.size;i++,j++){
            if(gameboard.board[i][j]==null || gameboard.board[i][j].piece!=p){
                diagmatch=false;

            }

        }
        //antidiagno math
        for(int i=0,j=gameboard.size-1;i<gameboard.size;i++,j--){
            if(gameboard.board[i][j]==null || gameboard.board[i][j].piece!=p){
                antidiagmatch=false;
            }
        }
        return rowmatch || colmatch || diagmatch || antidiagmatch;

    }
}
