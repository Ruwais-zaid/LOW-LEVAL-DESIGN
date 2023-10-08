package TICTAC;

public class main {
    public  static void main(String[] args){
        System.out.println(" -----------------------------------WELCOME TO TIC-TAC TOE GAME::---------------------------------------  ");
        TicTacGame game=new TicTacGame();
        game.intializegame();
        System.out.print("game winner is : " + game.startGame());
    }
}
