import java.util.Arrays;
import java.util.Random; 

public class HeapSort2 {

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); 
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;       
        int left = 2 * i + 1;  
        int right = 2 * i + 2; 

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000); 
        }
        return arr;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort(); 

        // --- Uji dengan Data Kecil (10) ---
        System.out.println("--- Uji dengan Data Kecil (10) ---");
        int[] smallData = generateRandomArray(10); 
        
        // Anda bisa aktifkan ini jika ingin melihat data sebelum dan sesudah sort
        System.out.println("Data Sebelum Sort: " + Arrays.toString(smallData)); 

        long startTimeSmall = System.nanoTime(); 
        hs.sort(smallData); 
        long endTimeSmall = System.nanoTime();   
        
        // Anda bisa aktifkan ini jika ingin melihat data sebelum dan sesudah sort
        System.out.println("Data Setelah Sort: " + Arrays.toString(smallData)); 

        // Menampilkan durasi untuk satu kali pengujian data kecil
        long durationSmallNano = (endTimeSmall - startTimeSmall);
        System.out.println("Durasi Heap Sort (10 data): " + durationSmallNano + " nanoseconds");
        System.out.println("Durasi Heap Sort (10 data): " + String.format("%.4f", (double)durationSmallNano / 1_000_000.0) + " ms");
        System.out.println("-----------------------------------\n");


        // --- Uji dengan Data Besar (1000) ---
        System.out.println("--- Uji dengan Data Besar (1000) ---");
        int[] largeData = generateRandomArray(1000); 

        long startTimeLarge = System.nanoTime(); 
        hs.sort(largeData); 
        long endTimeLarge = System.nanoTime();   
        
        // Menampilkan durasi untuk satu kali pengujian data besar
        long durationLargeNano = (endTimeLarge - startTimeLarge);
        System.out.println("Durasi Heap Sort (1000 data): " + durationLargeNano + " nanoseconds");
        System.out.println("Durasi Heap Sort (1000 data): " + String.format("%.4f", (double)durationLargeNano / 1_000_000.0) + " ms");
        System.out.println("-----------------------------------");
    }
}