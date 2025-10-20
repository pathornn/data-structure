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

    public void insertSort(){
        int i, ii, temp;
        for(i=0; i<arr.length; i++){
            temp = arr[i];
            for(ii=i; ii>0 && arr[ii - 1] > temp; ii--){
                arr[ii] = arr[ii - 1];
            }
            arr[ii] = temp;
        }
    }

    public void selectionSort(){
        int i, ii, minIndex, temp;
        for(i=0; i < arr.length - 1; i++){
            minIndex = i;
            for(ii = i + 1; ii<arr.length; ii++){
                if(arr[ii] < arr[minIndex]) minIndex = ii;
            }
            if(minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public void bubbleSort(){
        boolean swapped = true;
        int ii = 0;
        int temp;
        while (swapped) {
            swapped = false;
            ii++;
            for(int i=0; i<arr.length - ii; i++){
                if(arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public void shellSort(){
        int ii;
        for(int gap = arr.length/2; gap > 0; gap/=2){
            for(int i=gap; i < arr.length; i++){
                int temp = arr[i];
                for(ii = i; ii >= gap && temp < (arr[i - gap]); ii -= gap){
                    arr[ii] = arr[ii - gap];
                }
                arr[ii] = temp;
            }
        }
    }

    public void printVal(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Sorting {
    public static void main(String[] args) {
        Random random = new Random();
        int n, m;
        
        SArr sa;

        //INSERT SORT
        n = random.nextInt(10, 21);
        m = random.nextInt(10, 51);
        sa = new SArr(n);
        sa.randVal(m);
        System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
        sa.printVal();
        System.out.println("Insertion Sort : ");
        sa.insertSort();
        sa.printVal();
        System.out.println("-------------------");

        //SELECT SORT
        n = random.nextInt(10, 21);
        m = random.nextInt(10, 51);
        sa = new SArr(n);
        sa.randVal(m);
        System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
        sa.printVal();
        System.out.println("Selection Sort : ");
        sa.selectionSort();
        sa.printVal();
        System.out.println("-------------------");

        //BUBBLE SORT
        n = random.nextInt(10, 21);
        m = random.nextInt(10, 51);
        sa = new SArr(n);
        sa.randVal(m);
        System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
        sa.printVal();
        System.out.println("Bubble Sort : ");
        sa.bubbleSort();
        sa.printVal();
        System.out.println("-------------------");
        
        //SHELL SORT
        n = random.nextInt(10, 21);
        m = random.nextInt(10, 51);
        sa = new SArr(n);
        sa.randVal(m);
        System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
        sa.printVal();
        System.out.println("Shell Sort : ");
        sa.shellSort();
        sa.printVal();
        System.out.println("-------------------");
    }
}