import java.util.*;
class Ll{
    int x,y;
    Ll next=null;//pointer for next node 
    public Ll(int x,int y){
        this.x=x;
        this.y=y;
    }
  }

  class treenode{
    // static int root;
    int intensity;
    Ll start=null;
    Ll end=null;//last node of ll
    treenode left=null,right=null;
    //    public ArrayList<Integer> l=new ArrayList<Integer>();
    int arr[];
    public treenode(int intensity,int i,int j){
        this.intensity=intensity;
        this.add(i,j);
      }
      public void add(int x,int y){//this method will define into treenode and
        // we directly use for store data(x,y)
        Ll add=new Ll(x,y);// here add is node which gonna add into ll
       if(start==null){
           start=add;
           end=add;
       }
       else{
           add.next=start;
           start=add;//add new elements into first
       }
    }
    public void add(treenode temp){
        if(start==null){
            start=temp.start;
            end=temp.end;
        }
        else{
           end.next=temp.start;//add ll of temp into current node in last 
           end=temp.end;
        }
    }
    public static treenode search(treenode root,int intensity){
        treenode temp=root;
            while(temp.intensity!=intensity){
                 if(intensity<temp.intensity){
                     temp=temp.left;
                     if(temp==null){
                        // System.out.println("this node is not in tree");
                        return temp;
                    }
                 }
                 if(intensity>temp.intensity){
                    temp=temp.right;
                    if(temp==null){
                        // System.out.println("this node is not in tree");
                        return temp;
                    }
                }
                if(temp.intensity==intensity){
                    // System.out.println("this node is in tree");
                            return temp;
                }
            }
            return temp;
      }
    public static void add(treenode root,treenode add_node){
        treenode root1;
        while(add_node.intensity!=root.intensity){
            if(add_node.intensity<root.intensity){
                root1=root;
                root=root.left;
                if(root==null){
                    root=root1;
                    root.left=add_node;
                    // System.out.println("node is inserted in tree");
                    return;
                }
            }
            if(add_node.intensity>root.intensity){
                root1=root;
                root=root.right;
                if(root==null){
                    root=root1;
                    root.right=add_node;
                    // System.out.println("node is inserted in tree");
                    return;
                }
            }
        }
        if(add_node.intensity==root.intensity){
            // root.l.addAll(add_node.l);
            root.add(add_node);
        }
      }
    }
public class test_3{
    public static void main(String args[]){
       int arr[][]={{17,2,3,4,5},
                     {65,75,83,97,10},
                     {11,12,13,14,15},
                     {16,34,8,17,20},
                     {21,22,23,8,25},
                     {17,2,3,4,5},
                     {17,2,3,4,5},
                     {65,75,83,97,10},
                     {11,12,13,14,15},
                     {16,34,8,17,20},
                     {21,22,23,8,25},
                     {17,2,3,4,5},
                     {17,2,3,4,5},
                     {65,75,83,97,10},
                     {11,12,13,14,15},
                     {16,34,8,17,20},
                     {21,22,23,8,25},
                     {17,2,3,4,5}
                    };
    
     treenode root;
     treenode t1=new treenode(arr[0][0],0,0);
     root=t1;

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
          treenode t=new treenode(arr[i][j],i,j);
          treenode.add(root,t);
        }
      }
    //   treenode s=treenode.search(root,3);
    //   System.out.println(s.start.x+","+s.start.y);
    //   System.out.println(s.start.next.x+","+s.start.next.y);

    // for(int i=0;i<arr.length;i++){
    //   for(int j=0;j<arr[i].length;j++){
    //     System.out.print(arr[i][j]+" ");
    //   }
    //   System.out.println("");
    // }
    // System.out.println(" ");
      long start=System.nanoTime();
      for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
           if(arr[i][j]==8){
            // System.out.print(i+",");
            // System.out.print(j+"\n");
             arr[i][j]=63;
           }
        }
      }
      long end=System.nanoTime();

      long start1=System.nanoTime();
      treenode dir=treenode.search(root,8);
      Ll temp=dir.start;
      while(temp!=null){
        arr[temp.x][temp.y]=63;
        temp=temp.next;
      }
      long end1=System.nanoTime();

    //   for(int i=0;i<arr.length;i++){
    //     for(int j=0;j<arr[i].length;j++){
    //       System.out.print(arr[i][j]+" ");
    //     }
    //     System.out.println("");
    //   }

      System.out.println("array "+(end-start)+" nano seconds");
     System.out.println("tree "+(end1-start1)+" nano seconds");
    }
}
