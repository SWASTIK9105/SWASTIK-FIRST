import java.util.*;
public class Reccursion_TowerofHanoi {
public static void towerOfHanoi(int a,String A,String B,String C) {
	if(a==1) {
		System.out.println("TRANSFER DISK "+ a+"FROM "+A+" TO "+B);
		return;}
	towerOfHanoi(a-1,A,C,B);
	System.out.println("TRANSFER DISK "+ a+"FROM "+A+" TO "+B);
	towerOfHanoi(a-1,B,A,C);}
public static void main(String args[]) {
Scanner s=new Scanner(System.in);
System.out.println("ENTER NUMBER OF DISKS ");
int S=s.nextInt();
towerOfHanoi(S,"pole 1","pole 2","pole 3");
s.close();
}
}
