public class Entity{
    private int health;
    private String name;
    private String character;
    private int x;
    private int y;
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
    public void move(int dx, int dy){
        setX(getX() + dx);
        setY(getY() + dy);
        if((dx > 0) && (getX() > 4)) move(-dx,0);
        if((dx < 0) && (getX() < 0)) move(-dx,0);
        if((dy > 0) && (getY() > 4)) move(0,-dy);
        if((dy < 0) && (getY() < 0)) move(0,-dy);
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
