public int[][] kClosest(int[][] points, int k) {
        // Your code here
        int[][]res=new int[k][2];
        
        PriorityQueue<Pair1> queue= new PriorityQueue<>((a,b)->{
            return b.dis-a.dis;
        });
        for(int i=0;i<points.length;i++){
            int val1=points[i][0];
            int val2=points[i][1];
            int dis=val1*val1+val2*val2;
           
           queue.add(new Pair1(dis,val1,val2));
           
          if(queue.size()>k){
              queue.remove();
          }
          

        }
        
        for(int i=0;i<k;i++){
            Pair1 p=queue.remove();
            res[i][0]=p.x;
            res[i][1]=p.y;
        }
        return res;
    }
    
    class Pair1{
        int dis;
        int x;
        int y;
        
        public Pair1(int dis,int x ,int y){
            this.dis=dis;
            this.x=x;
            this.y=y;
        }
       
    }