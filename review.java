import java.util.Scanner;

public class review {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Created by 670710631 Pathorn Nancha");
        int count=0;
        int n = scan.nextInt();
        double sum=0;

        for (int i=0; i<n; i++) {
            int input = scan.nextInt();
            if(input%2 == 0){
                count++;
                sum += input;
            }else{
                n++;
            }
        }
        System.out.printf("%.2f", sum/count);
    }
}