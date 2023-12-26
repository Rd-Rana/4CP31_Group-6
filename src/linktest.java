import java.util.*;
//treenode contain start node for it's ll and add method
class Ll{
    int x,y;
    Ll next=null;//pointer for next node 
    public Ll(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class linktest{
    Ll start=null;//this is root/start node of particular node's ll
    //we can access using treenode.start
    public void add(int x,int y){//this method will define into treenode and
        // we directly use for store data(x,y)
        Ll add=new Ll(1,2);// here add is node which gonna add into ll
       if(start==null){
           start=add;
       }
       else{
           add.next=start;
           start=add;//add new elements into first
       }
    }
    public static void main(String args[]){
    //   LinkedList<Integer> l=new LinkedList<Integer>();
    //   l.add(1);
    //   l.add(2);
    //   ListIterator li=l.listIterator();
    //   long start=System.nanoTime();
    //   while(li.hasNext()){
    //      System.out.println(li.next());
    //   }
    //   long end=System.nanoTime();
    //   System.out.println((end-start)+" nano seconds");

   
    // System.out.println(l_custom.x);
    }
}
