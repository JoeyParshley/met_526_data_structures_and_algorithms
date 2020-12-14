package cs526.hw5.problem7;

public class SortingComparison {
    private int[] arr;
    private int sortType;
    private InsertionSort insertionSort = new InsertionSort();
    private MergeSort mergeSort = new MergeSort();
    private QuickSort quickSort = new QuickSort();
    private HeapSort heapSort = new HeapSort();
    private long startTime;
    private long endTime;
    private long elapsedTime;
    public SortingComparison(int[] arr, int sortType) {
        this.arr = arr;
        this.sortType = sortType;
    }

    public void runComparison(int[]arr){
        switch (sortType) {
            case 1:
                startTime = System.currentTimeMillis();
                insertionSort.sort(arr);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime
                ;break;
            case 2:
                startTime = System.currentTimeMillis();
                mergeSort.sort(arr,0,arr.length - 1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                break;
            case 3:
                startTime = System.currentTimeMillis();
                quickSort.sort(arr,0,arr.length - 1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                break;
            case 4:
                startTime = System.currentTimeMillis();
                heapSort.sort(arr);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                break;
            default:
               System.out.println("Improper array");
        }

        System.out.printf("%8d ",elapsedTime);
    }

}
