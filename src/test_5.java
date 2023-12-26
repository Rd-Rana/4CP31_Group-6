import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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

    public static treenode search(treenode root,int intensity){
        treenode temp=root;
            while(temp.intensity!=intensity){
                 if(intensity<temp.intensity){
                     temp=temp.left;
                     if(temp==null){
                        return temp;
                    }
                 }
                 if(intensity>temp.intensity){
                    temp=temp.right;
                    if(temp==null){
                        return temp;
                    }
                }
                if(temp.intensity==intensity){
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
                                falseColorImage.setRGB(temp_l.x, temp_l.y,temp.intensity);
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
    }

public class test_5{

    public static void main(String[] args) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File("./company1.png"));
            
            // Create a new image with the same dimensions
            BufferedImage falseColorImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            

            treenode root;
            treenode t1=new treenode(originalImage.getRGB(0, 0),0,0);
            root=t1;
       
            // Apply false color mapping
            for (int x = 0; x < originalImage.getWidth(); x++) {
                for (int y = 0; y < originalImage.getHeight(); y++) {
                    int rgb = originalImage.getRGB(x, y);
                    treenode temp=treenode.search(root,rgb);
                    if(temp!=null){
                        temp.add(x,y);
                    }
                    else{
                        treenode t=new treenode(rgb,x,y);
                        treenode.add(root,t);
                    }
                }
            }
            long start=System.nanoTime();
            treenode.traverse(root,10,originalImage,falseColorImage);
            // treenode t=treenode.search(root,-16711423);
            // Ll temp_l=t.start;
            // while(temp_l!=null){
            //         falseColorImage.setRGB(temp_l.x,temp_l.y,-1);
            //         // System.out.println(temp_l.x+","+temp_l.y);
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