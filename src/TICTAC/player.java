package TICTAC;

public class player {
    public String name;
    public playingpeice p;

    public  player(String name,playingpeice p){
        this.name=name;
        this.p=p;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public playingpeice getP(){
        return p;
    }
    public void setP(playingpeice p){ this.p=p; };

}
