import java.util.Arrays;

public class Sorts {

   public static void insertionSort(int[] data){
	int value = 0;
	int index = 0;
	for(int i = 1; i < data.length; i++){
      	    value = data[i];
	    index = i;
	    while(index >= 1 && value <= data[index-1]){
		data[index] = data[index-1];
		index-=1;
	    }
	    data[index]= value;
	    printArray(data);
	}
    }


    public static void selectionSort(int[] data) {
	int start = 0;
	int index = 0;
	while (start < data.length-1) {
	    int smallest = data[start];
	    for (int i = start; i < data.length; i++) {
		if (data[i] < smallest) {
		    smallest = data[i];
		    index = i;
		}
	    }
	    data[index] = data[start];
	    data[start] = smallest;
	    start++;
	    printArray(data);
	}
    }

    public static void bubbleSort(int[]data) {
	int counter = data.length;
	int temp;
	while (counter != 0) {
	    for (int i = 1; i < counter; i++) {
		if (data[i-1] > data[i]) {
		    temp = data[i-1];
		    data[i-1] = data[i];
		    data[i] = temp;
		}
	    }
	    counter--; 
	    printArray(data);
	}
    }


    public static void  printArray(int[] data) {
	System.out.println(Arrays.toString(data));	
	/*	
	String out = "[";
	for (int i = 0; i < data.length; i++) {
	    if (i == data.length-1) {
		out += data[i];
	    }else {
		out += data[i] + ",";
	    }
	}
	out += "]";
	System.out.println(out);
	*/
    }


    public static void main(String[]args) {
	int[] test1 = {10,8,5,6,7,12};
	System.out.println("Insertion Sort Test");
	insertionSort(test1);
	printArray(test1);
	
	int[] test2 = {1,24,5,654,52};
	System.out.println("Selection Sort Test");	
	selectionSort(test2);
	printArray(test2); 

	int[] test3 = {12};
	System.out.println("Selection Sort Test 2");
	selectionSort(test3);
	printArray(test3);

	int[] test4 = {1,2,9,5,0,3};
	System.out.println("Bubble Sort Test");
	bubbleSort(test4);
	printArray(test4);
    }
    
}
