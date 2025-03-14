public class Main{
    public static void main(String[] args){
        Player player = new Player();
        System.out.println(player);

        Entity[][] map = makeMap(5,5);
        printMap(map);
        map[0][0] = player;
        printMap(map);
    }
    public static Entity[][] makeMap(int r, int c){
        Entity[][] map = new Entity[r][c];
        for(int row = 0; row < map.length-1; row++){
            for(int col = 0; col < map[row].length-1; col++){
                map[row][col] = new Entity();
            }
        }
        return map;
    }
    public static void printMap(Entity[][] map){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  //clears console
        for(int r = 0; r < map.length -1; r++){
            for(int c = 0; c < map[r].length -1; c++){
                System.out.print("["+map[r][c].getCharacter()+"]");
            }
            System.out.println();
        }
    }
}