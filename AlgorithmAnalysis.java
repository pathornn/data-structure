import java.util.Random;

public class AlgorithmAnalysis{
    static int maxSubsquenceSum_ON3(int A[], int N){
        int ThisSum, MaxSum, i, j, k;
        MaxSum = 0;
        for(i=0; i<N; i++){
            for(j=i; j<N; j++){
                ThisSum = 0;
                for(k=i; k<=j; k++) ThisSum += A[k];
                if(ThisSum > MaxSum) MaxSum = ThisSum;
            }
        }
        return MaxSum;
    }

    static int maxSubsquenceSum_ON2(int A[], int N){
        int ThisSum, MaxSum, i, j;
        MaxSum = 0;
        for(i=0; i<N; i++){
            ThisSum = 0;
            for(j=i; j<N; j++){
                ThisSum += A[j];
                if(ThisSum > MaxSum) MaxSum = ThisSum;
            }
        }
        return MaxSum;
    }

    static int maxSubsquenceSum_ONlogN(int A[], int Left, int Right){
        int MaxLeftSum, MaxRightSum;
        int MaxLeftBorderSum, MaxRightBorderSum;
        int LeftBorderSum, RightBorderSum;
        int Center, i;

        if(Left == Right)
            if(A[Left] > 0)
                return A[Left];
            else return 0;
        
        Center = (Left + Right)/2;
        MaxLeftSum = maxSubsquenceSum_ONlogN(A, Left, Center);
        MaxRightSum = maxSubsquenceSum_ONlogN(A, Center + 1, Right);

        MaxLeftBorderSum = 0; LeftBorderSum = 0;
        for(i = Center; i >= Left; i--){
            LeftBorderSum += A[i];
            if(LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }
        
        MaxRightBorderSum = 0; RightBorderSum = 0;
        for(i=Center + 1; i<=Right; i++){
            RightBorderSum += A[i];
            if(RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }

        return MaxLeftBorderSum + MaxRightBorderSum;
    }

    static int maxSubsquenceSum_ON(int A[], int N){
        int ThisSum, MaxSum, j;
        
        ThisSum = MaxSum = 0;
        for(j=0; j<N; j++){
            ThisSum += A[j];
            if(ThisSum > MaxSum)
                MaxSum = ThisSum;
            else if(ThisSum < 0)
                ThisSum = 0;
        }
        return MaxSum;
    }

    public static void main(String[] args) {

        //N = 10
        Random random = new Random();
        int N = random.nextInt(100001);
        System.out.println("N = " + N);
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = random.nextInt(-5000, 5001);
        }
        double startTime = System.nanoTime();
        maxSubsquenceSum_ON3(A, N);
        double stopTime = System.nanoTime();
        System.out.println("Time : " + (stopTime - startTime)/1000000);

        startTime = System.nanoTime();
        maxSubsquenceSum_ON2(A, N);
        stopTime = System.nanoTime();
        System.out.println("Time : " + (stopTime - startTime)/1000000);

        startTime = System.nanoTime();
        maxSubsquenceSum_ONlogN(A, 0, A.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time : " + (stopTime - startTime)/1000000);

        startTime = System.nanoTime();
        maxSubsquenceSum_ON(A, N);
        stopTime = System.nanoTime();
        System.out.println("Time : " + (stopTime - startTime)/1000000);

    }
}
