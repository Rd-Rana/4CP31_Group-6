import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Ll{
    int x;
    Ll next=null;//pointer for next node 
    public Ll(int x){
        this.x=x;
    }
    public static void add(Ll l,Ll start){//this method will define into treenode and
      // we directly use for store data(x,y)
      // Ll add=new Ll(x,y);// here add is node which gonna add into ll
     if(start.next==null){
         start.next=l;
     }
     else{
        while(start!=null){
          start=start.next;
        }
        start=l;
     }
   }
  }
public class test_1{
    public static void main(String args[]){
      Ll start=new Ll(1);//root
    //  for(int i=2;i<11;i++){
      Ll temp=new Ll(2);//root
      Ll temp_1=new Ll(3);//root
       Ll.add(temp,start);
       Ll.add(temp_1,start);
    //  }
      int arr[]=new int[10];
      for(int i=0;i<10;i++){
        arr[i]=i;
      }
      
      long start2=System.nanoTime();
      for(int i=0;i<10;i++){
        System.out.println(arr[i]);
      }
      long end2=System.nanoTime();

      long start1=System.nanoTime();
      Ll temp_l=start;
      while(temp_l!=null){
        System.out.println(temp_l.x);
          temp_l=temp_l.next;
      }
      System.out.println(start.next.next);
      long end1=System.nanoTime();


      System.out.println("array "+(end2-start2)+" nano seconds");
      System.out.println("list "+(end1-start1)+" nano seconds");
    }
}
