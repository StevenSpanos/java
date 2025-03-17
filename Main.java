import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Player player = new Player();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies = createEnemy("baller",5,"X",true,4,4,enemies);
        enemies = createEnemy("peepee",5,"B",false,2,2,enemies);
        while(true){
            Entity[][] map = makeMap(5,5);
            map[player.getY()][player.getX()] = player;
            setEnemies(map, enemies);
            printMap(map);
            //printEnemies(enemies);
            collectInput(player);
            updateEnemies(enemies);
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
            choice = input.nextLine();
        }
        player.move(choice);
    }

    public static ArrayList<Enemy> createEnemy(String n, int h, String c, boolean b, int x, int y, ArrayList<Enemy> enemies){
        //Enemy enemy = new Enemy(n,h,c,(int) Math.random()*5, (int) Math.random()*5);
        Enemy enemy = new Enemy(n,h,c,x,y,b);
        enemies.add(enemy);
        return enemies;
    }

    public static void updateEnemies(ArrayList<Enemy> enemies){
        for(int i = 0; i < enemies.size(); i++){
            //enemies.get(i).move((int) Math.round(Math.random()-0.4),(int) Math.round(Math.random()-0.4));
            if(enemies.get(i).canMove()){
            enemies.get(i).move((int) (Math.random()*3)-1,(int) (Math.random()*3)-1);
            }
        }
    }
    public static void setEnemies(Entity[][] map, ArrayList<Enemy> enemies){
        int count = 0;
        for(int r = 0; r < map.length; r++){
            if(count >= enemies.size()){
                return;
            }
            for(int c = 0; c < map[r].length; c++){
                if(r == enemies.get(count).getY()){
                    if(c == enemies.get(count).getX()){
                        map[r][c] = enemies.get(count);
                        count++;
                    }
                }
            }
        }
    }
    public static void printEnemies(ArrayList<Enemy> enemies){
        for(Enemy e : enemies){
            System.out.println(e.toString());
        }
    }

}
