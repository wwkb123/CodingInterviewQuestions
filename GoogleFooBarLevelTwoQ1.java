
public class GoogleFooBarLevelTwoQ1{
	
	
	public static void main(String[] args) {
		System.out.println(answer(19,36));   //return 1
	}
	
	public static class Block{
		int x;
		int y;
		int steps;
		public Block(int x,int y, int steps){
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
	}
	
    public static int answer(int src, int dest) { 
        int[] X_move = {-1,1,-2,2,-2,2,-1,1};
        int[] Y_move = {2,2,1,1,-1,-1,-2,-2};
        Queue<Block> q = new LinkedList<Block>();
        
        boolean[][] visited = new boolean[8][8];
        
        for (int i = 0; i < 8; i++){
        	for (int j = 0; j < 8; j++){
        		visited[i][j] = false;
        	}
        }
        
        visited[src%8][src/8] = true;  //knight first position
        
        q.add(new Block(src%8,src/8,0)); //push to Queue
        Block block = q.peek();
        while(!q.isEmpty()){
        	block = q.remove();
        	if (block.x+block.y*8 == dest) break;  //found the smallest steps
        	for(int i = 0;i<8;i++){
        	
	        	int x = block.x+X_move[i];
	        	int y = block.y-Y_move[i];
		        if(x>=0 && y >=0 && x <8 && y<8 && !visited[x][y]){
		        	  visited[x][y] = true;
		        	  q.add(new Block(x,y,block.steps+1));
	         	}
	        }
        }
        return block.steps;
    } 
}

	