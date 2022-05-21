import java.util.LinkedList;
import java.util.Queue;

public class bfs_matrix {
    static class BFS{
        int adjacencyM[][];
        char vertices[];
        int visited[];
      
        BFS(int adjacencyM[][], char[] vertices){
          this.adjacencyM = adjacencyM;
          this.vertices = vertices;
          this.visited = new int[vertices.length];
        }
      
        public void solve(int root){
          
          Queue<Integer> queue = new LinkedList<>();
          queue.add(root);
          visited[root] = 1;
          
          while(!queue.isEmpty()){
            
            int current_vertex = queue.poll();
            System.out.print(vertices[current_vertex]+" ");
      
            
            int v;
            while((v =unvisitedNeighbor(current_vertex)) != -1){
              queue.add(v);
              visited[v] = 1;
            }
          }
        }
      
        
        private int unvisitedNeighbor(int index){
          for(int i=0; i<adjacencyM.length; i++){
            if(adjacencyM[index][i] == 1 && visited[i] == 0){
              return i;
            }
          }
          return -1;
        }
      }
      public static void main(String[] args) {
        
        char vertices[] = {'A', 'B', 'C', 'D', 'E'};
        
        int adjacencyM[][] = {{0, 1, 1, 0, 0},
                              {1, 0, 0, 1, 0},
                              {1, 0, 0, 0, 1},
                              {0, 1, 0 ,0, 0},
                              {0, 1, 1, 0, 0}};
    
        BFS bfs = new BFS(adjacencyM,vertices);
        bfs.solve(0);
        
      }
      
    
}
