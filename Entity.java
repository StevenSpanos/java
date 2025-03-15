public class Entity{
    private int health;
    private String name;
    private String character;
    private int x = 0;
    private int y = 0;
    public Entity(){
        name = "[]";
        health = 5;
        character = " ";
        x = 0;
        y = 0;
    }
    public Entity(String n, int h, String c, int x, int y){
        name = n;
        health = h;
        character = c;
        this.x = x;
        this.y = y;
    }
    public void move(int x, int y){
        setX(getX() + x);
        setY(getY() + y);
        if(getY() > 4) setY(0);
        if(getY() < 0) setY(4);
        if(getX() > 4) setX(0);
        if(getX() < 0) setX(4);
    }

    public String toString(){
        return "Health: " + health + " Name: " + name + " Character: " + character + " (X,Y): ("+x+","+y+")";
    }
    public String getName(){return name;}
    public int getHealth(){return health;}
    public String getCharacter(){return character;}
    public int getX(){return x;}
    public int getY(){return y;}

    public void setName(String s){name = s;}
    public void setHealth(int h){health = h;}
    public void setCharacter(String c){character = c;}
    public void setX(int a){x = a;}
    public void setY(int a){y = a;}
}
