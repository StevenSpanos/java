public class Player extends Entity{

    public Player(){
        super("player",10,"O",0,0);
    }
    public Player(String n, int h, String c, int x, int y){
        super(n,h,c,x,y);
    }
    public void move(String input){
        if(input.equals("up")) setY(getY()-1);
        if(input.equals("down")) setY(getY()+1);
        if(input.equals("right")) setX(getX()+1);
        if(input.equals("left")) setX(getX()-1);
        if(getY() > 4) setY(0);
        if(getY() < 0) setY(4);
        if(getX() > 4) setX(0);
        if(getX() < 0) setX(4);
    }

}