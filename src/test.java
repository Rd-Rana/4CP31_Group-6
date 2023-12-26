import java.util.*;
class treenode{
    // static int root;
    int intensity;
    treenode left=null,right=null;
      public LinkedList<Integer> l=new LinkedList<Integer>();
    public treenode(int intensity,int i,int j){
        this.intensity=intensity;
        l.add(i);
        l.add(j);
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
            root.l.addAll(add_node.l);
        }
      }
    }
public class test {
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
                     {17,2,3,4,5},
                     {17,2,3,4,5},
                     {65,75,83,97,10},
                     {11,12,13,14,15},
                     {16,34,8,17,20},
                     {21,22,23,8,25},
                     {17,2,3,4,5}
                    };
    //  long start=System.nanoTime();
    //   for(int i=0;i<arr.length;i++){
    //       for(int j=0;j<arr[i].length;j++){
    //           if(arr[i][j]==8){
    //               System.out.println(arr[i][j]);
    //           }
    //       }
    //   }
    //   long end=System.nanoTime();
    //   System.out.println(end-start+" nano seconds");
    
     treenode root;
     treenode t1=new treenode(arr[0][0],0,0);
     root=t1;
    //  treenode t2=new treenode(20);
    //  treenode t3=new treenode(30);
    //  treenode t4=new treenode(10);
    //  treenode t5=new treenode(5);
    //  treenode.add(root,t2);
    //  treenode.add(root,t4);
    //  treenode.add(root,t3);
    //  treenode.add(root,t5);
    //  treenode s_node=treenode.search(root,30);
    //  System.out.println(s_node.left);

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
          treenode t=new treenode(arr[i][j],i,j);
          treenode.add(root,t);
        }
      }
    //   treenode s=treenode.search(root,3);
    //   System.out.println(s.l);
    // for(int i=0;i<arr.length;i++){
    //   for(int j=0;j<arr[i].length;j++){
    //     System.out.print(arr[i][j]+" ");
    //   }
    //   System.out.println("");
    // }
      long start=System.nanoTime();
      for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
           if(arr[i][j]==17){
            System.out.print(i+",");
            System.out.print(j+"\n");
            //  arr[i][j]=63;
           }
        }
      }
      long end=System.nanoTime();

      long start1=System.nanoTime();
      System.out.println(treenode.search(root,17).l);
      // ListIterator li=treenode.search(root,17).l.listIterator();
      // while(li.hasNext()){
      //    arr[(int)li.next()][(int)li.next()]=63;
      // }
      long end1=System.nanoTime();

      // for(int i=0;i<arr.length;i++){
      //   for(int j=0;j<arr[i].length;j++){
      //     System.out.print(arr[i][j]+" ");
      //   }
      //   System.out.println("");
      // }

      System.out.println("array "+(end-start)+" nano seconds");
      System.out.println("tree "+(end1-start1)+" nano seconds");
    }
}
