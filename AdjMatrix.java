import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0 , 1}, 
                        {0, 0, 0, 1}, 
                        {1, 1, 0, 0}, 
                        {0, 0, 1, 0}};

        int[][] adjMatrix = new int[4][4];
        for(int i=0; i<adjMatrix.length; i++){
            for(int ii=0; ii<adjMatrix.length; ii++){
                for(int iii=0; iii<adjMatrix.length; iii++){
                    adjMatrix[i][ii] += matrix[i][iii]*matrix[iii][ii];
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Source Vertex: ");
        char source = scan.nextLine().charAt(0);
        System.out.print("Enter Target Vertex: ");
        char target = scan.nextLine().charAt(0);

        int sourceNum = source-'A';
        int targetNum = target-'A';
        
        System.out.println("From " + source + " to " + target);
        System.out.println("#path (length=2) : " + adjMatrix[sourceNum][targetNum]);
    }
}