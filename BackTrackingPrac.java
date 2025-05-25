
public class BackTrackingPrac {

    final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
            { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static boolean solveMaze(int maze[][], int x, int y) {
        int n = maze.length;
        int sol[][] = new int[n][n];

        if (solveMazeUti(maze, x, y, sol) == false) {
            System.out.println("solution does not exist");
            return false;
        }

        printSol(sol);
        return true;

    }

    public static void printSol(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMazeUti(int maze[][], int x, int y, int sol[][]) {

        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // recursion place

        if (isSafe(maze, x, y) == true) {
            if (sol[x][y] == 1) {
                return false;
            }
            sol[x][y] = 1;

            if (solveMazeUti(maze, x + 1, y, sol)) {
                return true;
            }

            if (solveMazeUti(maze, x, y + 1, sol)) {
                return true;
            }

            sol[x][y] = 0;

        }

        return false;

    }

    public static void mapNoToString(String d){
         int len = d.length();

         if(len == 0){
            System.out.println(" ");
            return;
         }

         bfs(0,len,new StringBuilder(),d);
    }

    public static void bfs(int pos,int length, StringBuilder sb,String s){
        if(pos == length){
            System.out.println(sb.toString());
            return;
        }else{
            System.out.println(pos);
            char l [] = L[Character.getNumericValue(s.charAt(pos))];
            System.out.println(l);
            for (int i = 0; i < l.length; i++) {
                bfs(pos+1, length, new StringBuilder(sb).append(l[i]), s);
            }
        }
    }


    static int tour = 1;


    public static void knightTour(int chess[][],int x,int y){
        int n = chess.length;
        int sol[][] = new int[n][n];

        if(kfg(chess,sol,x,y) == false){
           System.out.println("soltuion doent exits");
           return;
        }

        printSol(sol);
    }


    public static boolean kfg(int chess[][],int sol[][],int x,int y){
        if(x < 0 || x >= chess.length || y < 0 || y >= chess.length){

            return false;
        }

        
    }

    public static void main(String[] args) {
        
           mapNoToString("23");
    }
}