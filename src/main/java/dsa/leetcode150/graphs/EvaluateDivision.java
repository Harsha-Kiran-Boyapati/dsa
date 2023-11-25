package dsa.leetcode150.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/evaluate-division/
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //mapping b/w variables and indices
        int counter=0;
        double[][] edges = new double[20][20];
        for(double[] row: edges) Arrays.fill(row, -1.0);

        HashMap<String, Integer> map = new HashMap<>();
        boolean[][] hasEdge = new boolean[20][20];
        for(int i=0; i<values.length; i++){
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            if(!map.containsKey(num)) map.put(num, counter++);
            if(!map.containsKey(den)) map.put(den, counter++);
            int numIndex = map.get(num);
            int denIndex = map.get(den);
            edges[numIndex][denIndex] = values[i];
            edges[denIndex][numIndex] = 1/values[i];
            hasEdge[numIndex][denIndex] = true;
            hasEdge[denIndex][numIndex] = true;
        }
        int nodeCount = counter;
        //pouplate all edges

        //after all edges are pouplated
        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String num = queries.get(i).get(0);
            String den = queries.get(i).get(1);
            ans[i] = edges[map.get(num)][map.get(den)];
        }
        return ans;
    }
}
