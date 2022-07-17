import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class homework2 {
    public static void main(String[] args){
        // Prototype
        int[] reverse  ={16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[] random   ={1,9,8,10,11,12,13,14,15,16,2,3,6,7,4,5};
        int[] ordered  ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

     //   Remove commment tags to run funciton     

//        System.out.println (" ========================= 0-16");
//        System.out.println ("Testing Bubble sort: ");
//
//        System.out.println (" --- best case ---");
//        //bubbleSort(ordered);
//        bubbleSort(createFile("ordered"));
//        System.out.println ();
//
//        System.out.println (" --- average case ---");
//        //bubbleSort(random);
//       bubbleSort(createFile("random"));
//        System.out.println ();
//
//        System.out.println (" --- worst case ---");
//       // bubbleSort(reverse);
//       bubbleSort(createFile("reversed"));
//        System.out.println ();
//
//        System.out.println (" ========================= ");

//
//        System.out.println (" ========================= 0-16 and 0-2000");
//       System.out.println ("Testing selection sort: ");
//
//       System.out.println (" --- best case ---");
//       //selectionSort(ordered);
//        selectionSort(createFile("ordered"));
//       System.out.println ();
//
//      System.out.println (" --- average case ---");
//     //selectionSort(random);
//    selectionSort(createFile("random"));
//      System.out.println ();
//
//       System.out.println (" --- worst case ---");
//       //selectionSort(reverse);
//        selectionSort(createFile("reversed"));
//      System.out.println ();
//       System.out.println (" ========================= ");



//        System.out.println (" ========================= 0-16  and 0-2000");
//        System.out.println ("Testing insertion sort: ");
//
//        System.out.println (" --- best case ---");
//        //insertionSort(ordered);
//        insertionSort(createFile("ordered"));
//        System.out.println ();
//
//        System.out.println (" --- average case ---");
//        //insertionSort(random);
//        insertionSort(createFile("random"));
//        System.out.println ();
//
//        System.out.println (" --- worst case ---");
//        //insertionSort(reverse);
//        insertionSort(createFile("reversed"));
//        System.out.println ();
//
//        System.out.println (" ========================= ");

//====================================  ADVANCED SORTING METHOD 0-16 ###########################################################################################
//====================================  ADVANCED SORTING METHOD 0-16 ###########################################################################################

        System.out.println (" ========================= 0-16  and 0-2000 =========================");
        //System.out.println ("Testing Quick sort: ");
        int [] arrRandom = createFile("random");
        int [] arrReversed = createFile("reversed");
        int [] arrSorted = createFile("ordered");



//     ========  ADVANCED Quick  SORTING METHOD 1-16 #############################
//        System.out.println (" --- Best case ---");
//       QuickSort.quickSort(random, 0, random.length - 1);
//        QuickSort.printMe(random, "Quick Sort");

//     ========  ADVANCED Quick SORTING METHOD 1-2000 #############################
    // QuickSort.quickSort(arrRandom, 0, arrRandom.length - 1);
     //QuickSort.printMe(arrRandom, "Quick Sort");


//     ========  ADVANCED Quick SORTING METHOD 1-16 #############################
   //     System.out.println (" --- Average case ---");
//        QuickSort.quickSort(reverse, 0, reverse.length - 1);
//        QuickSort.printMe(reverse, "Quick Sort");
//     ========  ADVANCED Quick SORTING METHOD 1-2000 #############################
//        QuickSort.quickSort(arrReversed, 0, arrReversed.length - 1);
//        QuickSort.printMe(arrReversed, "Quick Sort");


//     ========  ADVANCED Quick SORTING METHOD 1-16 #############################
        //        System.out.println (" --- Worst case ---");
//       QuickSort.quickSort(ordered, 0, reverse.length - 1);
//        QuickSort.printMe(ordered, "Quick Sort");
//     =====  ADVANCED SORTING METHOD 1-2000 #####
//        QuickSort.quickSort(arrSorted, 0, arrSorted.length - 1);
//        QuickSort.printMe(arrSorted, "Quick Sort");
//



//////   ========  ADVANCED ShellSort SORTING METHOD 1-16 #############################
        //System.out.println ("Testing ShellSort : ");

        //System.out.println (" --- Best case ---");
        //ShellSort.shellSort(ordered);
////     ADVANCED ShellSort SORTING METHOD 1-2000 ##########
        //ShellSort.shellSort(arrSorted);



////     ========  ADVANCED ShellSort SORTING METHOD 1-16 #############################
            // System.out.println (" --- Average case ---");
        //ShellSort.shellSort(random);
/////     ========  ADVANCED ShellSort SORTING METHOD 1-2000 ##########
       // ShellSort.shellSort(arrRandom);


////     ========  ADVANCED ShellSort SORTING METHOD 1-16 #############################
                //System.out.println (" --- Worst case ---");
       //ShellSort.shellSort(reverse);
/////     =====  ADVANCED ShellSort METHOD 1-2000 #####
        //ShellSort.shellSort(arrReversed);


    }

    public static int[] selectionSort(int[]lists){
        int temp, min, exchanges = 0, n = lists.length, comparisons= 0;
        for(int i=0; i!=n-1; i++){
           min = i;
           for(int j =i+1; j!=n; j++){
               comparisons++;

               if(lists[j]< lists[min]) {
                   min = j;
               }}
                temp = lists[min];
               lists[min] = lists[i];
               lists[i] =temp;
               exchanges++;
               }
        System.out.println("Selection Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Selection Sort: Number of Comparisons: " +
                comparisons);
        printMe(lists,"Selection Sort");
        return lists;
}
    public static int[] bubbleSort(int[]lists){
        int n = lists.length, exchanges = 0, comparisons = 0;
        boolean cont =true;

        for (int i = 0; i < n-1; i++){
            if(cont){
                cont = false;
            for (int j = 0; j < n-1; j++){
                comparisons++;
                if (lists[j] > lists[j+1]){

                    int temp = lists[j];
                    lists[j] = lists[j+1];
                    lists[j+1] = temp;
                    cont =true;
                    exchanges++;
                }
            }
            }
            else{
                break;
            }
        }
        System.out.println("Bubble Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Bubble Sort: Number of Comparisons: " +
                comparisons);
        printMe(lists,"Bubble Sort");
        return lists;
    }

    public static int[] insertionSort(int[]list){
        int n = list.length, exchanges = 0, comparisons = 0;

        for(int i =1; i<n;i++){
         int ke = list[i];
         int j = i-1;
         while((j>-1) && (list[j]>ke)){
             list[j+1] =list[j];
             j--;
             comparisons++;
             exchanges++;
         }
            list[j+1] =ke;
        }
        System.out.println("Insertion Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Insertion Sort: Number of Comparisons: " +
                comparisons);
        printMe(list,"Insertion Sort");
        return list;
    }
///// Create Files
    public static int[] createFile(String filename){
        if(filename=="random"){
        Random rand = new Random();
        try {
            PrintWriter fileout = new PrintWriter(new PrintWriter(filename+".txt"));
            for (int i = 0; i < 2001; i++) {
                 int ran = rand.nextInt(2001);
                fileout.println(ran);
            }
            fileout.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }}

        int[] x = new int[2001];
        for (int i = 0; i < 2001; i++) {
            try {
                String line = Files.readAllLines(Paths.get(filename+".txt")).get(i);
                x[i] = Integer.parseInt(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
       return x;
    }
   //Print list
    static void printMe(int[] lists,  String sort){
      int n = lists.length;
        System.out.println ("Sorted file:");
        for (int i=0; i<n; ++i)
            System.out.print(lists[i]+" ");
        System.out.println ();
    }



public class QuickSort {
    public static int Comparisons = 0;
    public static int Exchanges = 0;

    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = (lo - 1);
        for (int j = lo; j <= hi - 1; j++) {
            if (arr[j] < pivot) {
                Comparisons++;
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);
        return (i + 1);
    }
    static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Exchanges++;
    }
    static void printMe(int[] lists, String sort) {
        int n = lists.length;
        System.out.println("QuickSort Comparisons: " + Comparisons);
        System.out.println("QuickSort Exchanges: " + Exchanges);
        System.out.println("Sorted file:");
        for (int i = 0; i < n; ++i)
            System.out.print(lists[i] + " ");
        System.out.println();
    }
}

public class ShellSort{
    static int Shell_exchanges = 0;
    static int Shell_comparisons = 0;

    public  static int[]  SegmentedInsertionSort(int[] A,int N, int H){
        int current;
        for(int i=H;i<N;i++){
            current =A[i];
            int j =i;
            while(j>H-1 && (A[j-H]>current)) {
                Shell_comparisons++;
                A[j] = A[j - H];
                j = j - H;
                Shell_exchanges++;
            }
            A[j]=current;
        }
        return A;
    }
    public static int[] shellSort(int[]A){
        int N =A.length;
        int H =N/2;
        Scanner incSeq = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        System.out.println("Default increment sequence is ''(list.length)/2'' Would You like to assign a different increment sequence ?  'Y' or 'N' ");
        String ans = choice.nextLine();

        if(ans.equals("Y") ){
            System.out.println("Assign a different increment sequence : ");
            int New_sequence =incSeq.nextInt();
            H =New_sequence;
        }
        else{
            N = A.length;
        }
        while(H>0){
            SegmentedInsertionSort(A,N,H);
            //comparisons++;
            H=H/2;
        }
        printMe(A,"shellSort");
        return A;
    }
    static void printMe(int[] lists, String sort) {
        int n = lists.length;
        System.out.println("Shell Sort: Number of Exchanges: " +Shell_exchanges);
        System.out.println("Shell Sort: Number of Comparisons: " + Shell_comparisons);
        System.out.println("Sorted file:");
        for (int i = 0; i < n; ++i)
            System.out.print(lists[i] + " ");
        System.out.println();
    }
}





}