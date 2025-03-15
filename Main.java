import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static void main(String[] args){
        Player player = new Player();
        createEnemy("baller",5,"X");
        while(true){
            Entity[][] map = makeMap(5,5);
            printMap(map);
            map[player.getY()][player.getX()] = player;
            setEnemies(map);
            printMap(map);
            collectInput(player);
            updateEnemies();
    }
    }
    public static Entity[][] makeMap(int r, int c){
        Entity[][] map = new Entity[r][c];
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[row].length; col++){
                map[row][col] = new Entity();
            }
        }
        return map;
    }
    public static void printMap(Entity[][] map){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  //clears console

        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[0].length; c++){
                System.out.print("["+map[r][c].getCharacter()+"]");
            }
            System.out.println();
        }
    }
    public static void collectInput(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("up, down, left, right");
        String choice = input.nextLine();
        while (!choice.equals("up") && !choice.equals("down") && !choice.equals("left") && !choice.equals("right")){
            if(choice.equals("enemies")){
                for(int i = 0; i < enemies.size(); i++){
                    System.out.println(enemies.get(i));
                }
            }
            choice = input.nextLine();
        }
        player.move(choice);
    }
    public static void createEnemy(String n, int h, String c){
        Enemy enemy = new Enemy(n,h,c,(int) (Math.random()*5), (int) (Math.random()*5));
        //Enemy enemy = new Enemy();
        enemies.add(enemy);
    }
    //fix please it doesn't workkk
    public static void updateEnemies(){
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).move((int) (Math.random()*2)-1,(int) (Math.random()*2)-1);
        }
    }
    public static void setEnemies(Entity[][] map){
        int count = 0;
        for(int r = 0; r < map.length; r++){
            if(count >= enemies.size()){
                break;
            }
            for(int c = 0; c < map[r].length; c++){
                if(r == enemies.get(count).getY()){
                    if(c == enemies.get(count).getX()){
                        map[r][c] = enemies.get(count);
                        break;
                    }
                }
            }
        }
    }

}