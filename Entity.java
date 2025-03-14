public class Entity{
    private int health;
    private String name;
    private String character;
    public Entity(){
        name = "[]";
        health = 5;
        character = " ";
    }
    public Entity(String n, int h, String c){
        name = n;
        health = h;
        character = c;
    }
    public String toString(){
        return "Health: " + health + " Name: " + name + " Character: " + character;
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void setName(String s){
        name = s;
    }
    public void setHealth(int h){
        health = h;
    }
    public String getCharacter(){
        return character;
    }
    public void setCharacter(String c){
        character = c;
    }
}