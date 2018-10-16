/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author Bashoo
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final int INF = 10000;

        int Matrix[][] = {{INF, 4, 3, INF, INF, INF},
                          {4, INF, 2, 13, 10, INF},
                          {3, 2, INF, 12, INF, INF},
                          {INF, 13, 12, INF, 5, 1},
                          {INF, 10, INF, 5, INF, 3},
                          {INF, INF, INF, 1, 3, INF}};

        // the row of matrix
        int[] distance = new int[6];
        int[] visited = new int[6];
        int[] preD = new int[6];
        int min;
        int nextnode = 0;

        distance = Matrix[0];
        distance[0] = 0;
        visited[0] = 1;

        for (int i = 0; i < Matrix.length; i++) {
            min = INF;
            for (int j = 0; j < Matrix.length; j++) {
                if (min > distance[j] && visited[j] != 1) {
                    min = distance[j];
                    nextnode = j;
                }

            }
            visited[nextnode] = 1;

            for (int k = 0; k < Matrix.length; k++) {
                if (visited[k] != 1) {
                    if (min + Matrix[nextnode][k] < distance[k]) {
                        distance[k] = min + Matrix[nextnode][k];
                        preD[k] = nextnode;
                    }
                }
            }
        }
        for (int i = 0; i < Matrix.length; i++) {
            int j;
            System.out.print("THE path is :" + i);
            j = i;

            do {
                j = preD[j];
                System.out.print(" <- " + j);
            } while (j != 0);
            System.out.println();
        }
    }
}
