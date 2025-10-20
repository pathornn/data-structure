import java.util.Random;

class SArr{
    private int[] arr;
    
    public SArr(int num) {
        arr = new int[num];
    }

    public void randVal(int m){
        Random random = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = random.nextInt((-1)*m, m + 1);
            //System.out.println(arr[i]);
        }
    }

    public void quickSort(){
        recQuickSort(arr, 0, arr.length - 1);
    }

    public void recQuickSort(int[] arr, int L, int R){
        int i=L; 
        int ii=R;
        int pivot = arr[(L + R)/2];
        int temp;
        do{
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[ii] > pivot) {
                ii--;
            }
            if(i <= ii){
                temp = arr[i];
                arr[i] = arr[ii];
                arr[ii] = temp;
                i++;
                ii--;
            }
        }while(i <= ii);
        if(L < ii) recQuickSort(arr, L, ii);
        if(i < R) recQuickSort(arr, i, R);
        
    }

    public void printVal(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int n, m;
        
        SArr sa;

        //QUICK SORT
        n = random.nextInt(10, 21);
        m = random.nextInt(10, 51);
        sa = new SArr(n);
        sa.randVal(m);
        System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
        sa.printVal();
        System.out.println("Quick Sort : ");
        sa.quickSort();
        sa.printVal();
        System.out.println("-------------------");

    }
}