import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Ll{
    int arr[]=new int[10];
    Ll next=null;//pointer for next node 
    public Ll(int x,int y,byte count){
         arr[count*2]=x;
         arr[(count*2)+1]=y;
    }
  }

  class treenode{
    // static int root;
   byte count;
    int intensity;
    Ll start=null;
    Ll end=null;//last node of ll
    treenode left=null,right=null;
    public treenode(int intensity){
        count=0;
        this.intensity=intensity;
      }
    public void add(int x,int y){
        if(count>=5){
            count=0;
        Ll add=new Ll(x,y,count);// here add is node which gonna add into ll
        if(start==null){
            start=add;
            end=add;
        }
        else{
           end.next=add;//add ll of temp into current node in last 
           end=add;
        }
      }
      else{
        if(start==null||end==null){
            Ll add=new Ll(x,y,count);
            start=add;
            end=add;
        }
        end.arr[count*2]=x;
        end.arr[(count*2)+1]=y;//add x and y into last node's array
      }
      count++;
    }
    public static treenode search(treenode root,int intensity){
        // treenode temp=root;
            while(root.intensity!=intensity){
                 if(intensity<root.intensity){
                     root=root.left;
                     if(root==null){
                        return root;
                    }
                 }
                 if(intensity>root.intensity){
                    root=root.right;
                    if(root==null){
                        return root;
                    }
                }
                if(root.intensity==intensity){
                            return root;
                }
            }
            return root;
      }
    public static void add(treenode root,treenode add_node,int x,int y){
        treenode root1;
        while(add_node.intensity!=root.intensity){
            if(add_node.intensity<root.intensity){
                root1=root;
                root=root.left;
                if(root==null){
                    root=root1;
                    root.left=add_node;
                    return;
                }
            }
            if(add_node.intensity>root.intensity){
                root1=root;
                root=root.right;
                if(root==null){
                    root=root1;
                    root.right=add_node;
                    return;
                }
            }
        }
      }
      public static void traverse(treenode root,int i,BufferedImage originalImage,BufferedImage falseColorImage){
          Queue<treenode> q=new LinkedList<treenode>();
          q.add(root);
          while(!q.isEmpty()){
            treenode temp=q.poll();
            temp.intensity=temp.intensity+i;
            Ll temp_l=temp.start;
                            while(temp_l!=null){
                                for(int j=0;j<10;j=j+2){
                                    falseColorImage.setRGB(temp_l.arr[j],temp_l.arr[j+1],temp.intensity);
                                }
                                temp_l=temp_l.next;
                            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
          }
      }
      public static treenode search(treenode root,byte intensity,int flag,boolean l_g){//intensity for r/g/b and flag which indicate 
        //like 0 for red , 1 for green and 2 for blue
        treenode x=treenode.search(root,intensity);
        if(x!=null){
             return x;
        }
        else{
            // String b=Integer.toBinaryString(intensity);
            // System.out.println(x);
            // if(intensity<=16){
            //     if(intensity<=4){
            //       if(intensity==)
            //     }
            //     else{

            //     }
            // }
            // else{

            // }
        }

      }
    }

public class test_6{

    public static void main(String[] args) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File("./company1.png"));
            
            // Create a new image with the same dimensions
            BufferedImage falseColorImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            

            treenode root;
            treenode t1=new treenode(originalImage.getRGB(0, 0));
            Ll root_l=new Ll(0,0,(byte) 0);
            t1.start=root_l;
            t1.end=root_l;
            root=t1;
       
            for (int x = 0; x < originalImage.getWidth(); x++) {
                for (int y = 0; y < originalImage.getHeight(); y++) {
                    int rgb = originalImage.getRGB(x, y);
                    // if(x==100&&y==20){
                    //     System.out.println(rgb);
                    // }
                    treenode temp=treenode.search(root,rgb);
                    if(temp!=null){
                        temp.add(x,y);
                    }
                    else{
                        treenode t=new treenode(rgb);
                        treenode.add(root,t,x,y);
                    }
                }
            }
            long start=System.nanoTime();
            
            treenode.traverse(root,10,originalImage,falseColorImage);
            // // treenode t=treenode.search(root,-16711423);
            // Ll temp_l=t.start;
            // while(temp_l!=null){
            //     for(int j=0;j<10;j=j+2){
            //         falseColorImage.setRGB(temp_l.arr[j],temp_l.arr[j+1],-1);
            //         // System.out.println(temp_l.arr[j]+","+temp_l.arr[j+1]);
            //     }
            //     temp_l=temp_l.next;
            // }

            long end=System.nanoTime();

            System.out.println("tree "+(end-start)+" nano seconds");

            // Save the false color image
            ImageIO.write(falseColorImage, "png", new File("./spatial_out.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Runtime r=Runtime.getRuntime();
        long usedmemory=r.totalMemory()-r.freeMemory();
        System.out.println(usedmemory+" bytes");
    }

}