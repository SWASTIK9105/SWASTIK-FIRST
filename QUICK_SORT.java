import java.util.*;
public class QUICK_SORT{
public static void quickSort(int arr[], int low, int high) {

if (low<high) {

int pi = partition(arr, low, high);

quickSort(arr, low, pi-1);

quickSort(arr, pi+1, high);

}

}
public static int partition (int[] arr, int low, int high) {

int pivot = arr[high];

int i = low-1;

for(int j=low; j<high; j++) {

if (arr[j] < pivot) {

i++;

//swap

int temp = arr[i];

arr[i] = arr[j];

arr[j] = temp;

}}
i++;

int temp = arr[i];

arr[i] = arr[high];

arr[high] = temp;

return i;}
	public static void main(String args[]) {
		Scanner sw=new Scanner(System.in);
		System.out.print("ENTER NUMBER OF  ELEMENTS");
		
	 int n=sw.nextInt();
		System.out.println("ENTER "+n+" ELEMENTS INTO ARRAY ");
		int[] arr=new int [n];
		for(int l=0;l<n;l++) {
			arr[l]=sw.nextInt();}
		quickSort(arr,0,n-1);
		//print 
		for(int i=0;i<n;i++) {
			System.out.print("  "+arr[i]+" ");}
	sw.close();				
	}}
