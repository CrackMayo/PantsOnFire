/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantsonfire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author CrackMayo
 */
public class pants {

    static ArrayList<Integer> g[];
    static boolean seen[];

    /**
     * @param args the command line arguments
     */
    private static void dfs(int u) {
        seen[u] = true;
        int len = g[u].size();
        for (int i = 0; i < len; i++) {
            int v = g[u].get(i);
            if (!seen[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Map<String, Integer> nyt;
        nyt = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        scan.nextLine();
        int cont = 0;
        seen = new boolean[193];
        g = new ArrayList[193];

        for (int i = 0; i < 193; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            String[] value = scan.nextLine().split(" are worse than ");
            if (!nyt.containsKey(value[0])) {
                nyt.put(value[0], cont);
                cont++;
            }
            if (!nyt.containsKey(value[1])) {
                nyt.put(value[1], cont);
                cont++;
            }

            int u = nyt.get(value[0]);
            int v = nyt.get(value[1]);
            g[u].add(v);
        }
        boolean ok;
        for (int i = 0; i < m; i++) {
            ok = true;
            String[] trump = scan.nextLine().split(" are worse than ");
            if (!nyt.containsKey(trump[0]) || !nyt.containsKey(trump[1])) {
                System.out.println("Pants on Fire");
            } else {

                dfs(nyt.get(trump[0]));
                if (seen[nyt.get(trump[1])]) {
                    System.out.println("Fact");
                    ok = false;
                }

                if (ok) {
                    seen = new boolean[193];
                    dfs(nyt.get(trump[1]));
                    if (seen[nyt.get(trump[0])]) {
                        System.out.println("Alternative Fact");
                    } else {
                        System.out.println("Pants on Fire");
                    }

                }

            }
            seen = new boolean[193];

        }

    }

}
