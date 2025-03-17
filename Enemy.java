public class Enemy extends Entity{
    private boolean canMove;
    public Enemy(){
        super("basic",3,"X",4,4);
        canMove = true;
    }
    public Enemy(String n, int h, String c, int x, int y, boolean b){
        super(n,h,c,x,y);
        canMove = b;
    }
    public boolean canMove(){
        return canMove;
    }
    public void setMove(boolean b){
        canMove = b;
    }
    public String toString(){
        return getCharacter();
    }
}
