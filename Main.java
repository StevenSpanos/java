import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Player player = new Player();
        while(true){
            System.out.println(player);
            Entity[][] map = makeMap(5,5);
            printMap(map);
            map[player.getY()][player.getX()] = player;
            printMap(map);
            collectInput(player);
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

}