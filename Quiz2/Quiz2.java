
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Quiz2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line = reader.readLine();
        String[] input = line.split(" ");
        int M = Integer.parseInt(input[0]); // Capacity of the spacecraft
        int n = Integer.parseInt(input[1]); // Number of resources
        int[] resources = new int[n];
        int maxMass = 0;

        line = reader.readLine();
        String[] resourceMasses = line.split(" ");
        for (int i = 0; i < n; i++) {
            resources[i] = Integer.parseInt(resourceMasses[i]);
        }
        reader.close();

        boolean[][] L = new boolean[M + 1][n + 1];


        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <=n ; j++) {
                L[i][j]=optimalLoading(i,j,resources);
                if (L[i][j]){maxMass=i;}
            }
        }
        System.out.println(maxMass);
        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L[i].length; j++) {
                System.out.print(L[i][j] ? 1 :0);
            }
            System.out.println();
        }


    }
private static boolean optimalLoading(int M, int i,int[] resources){
        if ( i == 0 && M ==0) return true;
        else if (i ==0 && M>0)return false;
        else if (i>0 && resources[i-1]>M) {
           return optimalLoading(M, i - 1, resources);
        }
        else {
            return optimalLoading(M,i-1,resources)||optimalLoading(M-resources[i-1],i-1,resources);
        }
}

}
