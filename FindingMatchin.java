import java.util.Random;
import java.util.Scanner;

public class FindingMatchin {
    
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(11) + 10;
        int[] num = new int[n];

        Scanner scan = new Scanner(System.in);

        //RANDOM NUMBERS
        System.out.println("--- Random Numbers [" + n + "] ---");
        for(int i=0; i<n; i++){
            int count=0;
            num[i] = random.nextInt(101);
            int bound = i;

            for(int ii=0; ii<=bound; ii++){
                if(num[i] == num[ii]){
                    count++;
                }
            }

            if(count > 1){
                System.out.print("!" + num[i] + " ");
                i--;
            }else if(count == 1) System.out.print(num[i] + " ");
        }
        System.out.println();

        //HASH TABLE
        System.out.println("--- Hash Table [" + n + "] ---");
        int[] hash = new int[2*n];
        for(int i=0; i<n*2; i++){
            hash[i] = -1;
        }

        for(int i=0; i<n*2; i++){
            for(int ii=0; ii<n; ii++){
                if(i == num[ii]%(2*n) && hash[num[ii]%(2*n)] == -1){
                    hash[num[ii]%(2*n)] = num[ii];
                    System.out.print(num[ii]%(2*n) + ":" + num[ii] + " ");
                }else if(i == num[ii]%(2*n)){
                    for(int iii=0; iii<n; iii++){
                        if((hash[(num[ii]%(2*n) + iii)%(2*n)]) == -1){
                        hash[(num[ii]%(2*n) + iii)%(2*n)] = num[ii];
                        System.out.print((num[ii]%(2*n) + iii)%(2*n) + ":" + num[ii] + "* ");
                        break;
                        }
                    }
                }
            }
        }
        System.out.println();

        //FINDING MATCH
        System.out.println("--- Finding Match ----");
        int m;
        int finding=0;
        for(int count=0; count<3;) {
            m = random.nextInt(101);

            boolean founded = false;
            for(int i=0; i<n*2; i++){
                if(hash[i]+m == 100){
                    System.out.print(m + " ");
                    hash[i] = -2;
                    founded = true;
                    count++;
                }
            }

            if(founded == false){
                System.out.print("!" + m + " ");
            }

            finding++;
        }
        System.out.println();
        System.out.println("Total Finding: " + finding);

        //HASH TABLE
        System.out.println("--- Hash Table [" + (n-3) + "] ---");
        for(int i=0; i<n*2; i++){
            if(hash[i] != -1 && hash[i] != -2){
                if(i == hash[i]%(2*n)){
                    System.out.print(i + ":" + hash[i] + " ");
                }else{
                    System.out.print(i + ":" + hash[i] + "* ");
                }
            }
        }

    }
}
