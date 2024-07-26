package com.company;

import java.util.*;
// join felan baraye ye ras tarahi shode vali ghabele afzayshe
//shomare ras ha bayad az 0 shoroo she ta n-1
// voroodi dadane yal ha bayad az koochick be bozorg bashe faghat
public class Main {



    //  static int minDistance(int[][] grph , Dijkstra dijkstra , ArrayList<Integer> a ,)
    public static void main(String[] args) throws ClassCastException {

        ArrayList<Integer> ras_yal = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] convert = str.split(" ", -1);
        for (String z : convert) {
            ras_yal.add(Integer.parseInt(z));
        }
        // baraye dijkstra
        int[][] grph = new int[ras_yal.get(0)][ras_yal.get(0)] ;
        Arrays.stream(grph).forEach(a -> Arrays.fill(a, -1));
        Graph graph = new Graph(ras_yal.get(0));
        String str0 = sc.nextLine();
        String[] convert0 = str0.split(" ", -1);
        ArrayList<Integer> ras = new ArrayList<>();
        for (String zz : convert0) {
            ras.add(Integer.parseInt(zz));
        }
        for(int j=0 ; j<ras_yal.get(1) ; j++){
            ArrayList<Integer> yal = new ArrayList<>();
            String str00 = sc.nextLine();
            String[] convert00 = str00.split(" ", -1);
            for (String zzz : convert00) {
                yal.add(Integer.parseInt(zzz));
            }
            grph[yal.get(0)][yal.get(1)]=yal.get(2);
            grph[yal.get(1)][yal.get(0)]=yal.get(2);
            graph.addEgde(yal.get(0) , yal.get(1) , yal.get(2));
        }

          int[][] temp_graph ={{0,0}} ;
        int tagheer =0 ;
        while(true){
            System.out.println("\n" + "menu :  Dijkstra , test(DFS) , exit , join , left , fairdistance");
            String s2 = sc.nextLine();
            if(s2.equals("test")){
                String s3 = sc.nextLine();
                graph.DFS(Integer.parseInt(s3));
            }
            if(s2.equals("exit"))
                break ;
            if(s2.equals("fairdistance")){
                Dijkstra dijkstra = new Dijkstra(ras_yal.get(0));
                ArrayList<Integer> fairdistance = new ArrayList<>();

                for(int i=0 ; i<ras_yal.get(0);i++){
                    int result =0 ;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.addAll(ras);
                    temp.remove(temp.get(i));
                    Integer[] array = temp.toArray(new Integer[0]);
                    int n = array.length;
                    Combination combination = new Combination(array);
            /*for(Integer e : combination.tarkibha){
                System.out.print(e);
            }*/
                    for(int j=0 ; j<combination.tarkibha.toArray().length;j+=2){
                        if(tagheer==0)
                        result+=Math.abs((dijkstra.dijkstra(grph,ras.get(i),combination.tarkibha.get(j)))-(dijkstra.dijkstra(grph,ras.get(i),combination.tarkibha.get(j+1)))) ;
                        if(tagheer==1)
                            result+=Math.abs((dijkstra.dijkstra(temp_graph,ras.get(i),combination.tarkibha.get(j)))-(dijkstra.dijkstra(temp_graph,ras.get(i),combination.tarkibha.get(j+1)))) ;
                        // System.out.println(result);
                    }
                    fairdistance.add((2*result)/((ras_yal.get(0)-1)*(ras_yal.get(0)-2)));
                }
                System.out.print("list fair distance ha : ");
                for(Integer e : fairdistance){System.out.print(e+" ");}
                System.out.print("\n"+"fair node : ");
                System.out.println(fairdistance.indexOf(Collections.min(fairdistance)));
            }
            if(s2.equals("join")){

                graph.setVertices();
                ras.add(graph.vertices-1);
                int n = ras_yal.get(0);
                int m = ras_yal.get(1);
                ras_yal.set(0,n+1);
                String s3 = sc.nextLine();
                ras_yal.set(1,m+Integer.parseInt(s3));
                int[][] grph2 = new int[ras_yal.get(0)][ras_yal.get(0)] ;
                Arrays.stream(grph2).forEach(a -> Arrays.fill(a, -1));
                for(int i=0; i<ras_yal.get(0)-1; i++){
                    for(int j=0; j<ras_yal.get(0)-1; j++){
                        grph2[i][j] = grph[i][j];}}

                //Arrays.stream(grph2).forEach(a -> Arrays.copyOf(grph, ras_yal.get(0)));
                for(int j=0 ; j<Integer.parseInt(s3) ; j++){
                    ArrayList<Integer> yal2 = new ArrayList<>();
                    String str000 = sc.nextLine();
                    String[] convert000 = str000.split(" ", -1);
                    for (String zzzz : convert000) {
                        yal2.add(Integer.parseInt(zzzz));
                    }
                    grph2[yal2.get(0)][yal2.get(1)]=yal2.get(2);
                    grph2[yal2.get(1)][yal2.get(0)]=yal2.get(2);
                    graph.addEgde(yal2.get(0) , yal2.get(1) , yal2.get(2));
                }
                // test grph2
               /* for(int i = 0; i<ras_yal.get(0); i++)
                {
                    for(int j = 0; j<ras_yal.get(0); j++)
                    {
                        System.out.print(grph2[i][j]);
                    }
                    System.out.println();
                }*/
                temp_graph = new int[ras_yal.get(0)][ras_yal.get(0)];
                for(int i=0; i<ras_yal.get(0); i++){
                    for(int j=0; j<ras_yal.get(0); j++){
                        temp_graph[i][j] = grph2[i][j];}}
                // test temp_graph
                 /*  for(int i = 0; i<ras_yal.get(0); i++)
                {
                    for(int j = 0; j<ras_yal.get(0); j++)
                    {
                        System.out.print(temp_graph[i][j]);
                    }
                    System.out.println();
                }*/

                tagheer=1;
                // test dijkstra
                // Dijkstra dijkstra = new Dijkstra(ras_yal.get(0));
                //System.out.println(dijkstra.dijkstra(grph2,0,1));
            }
            if(s2.equals("Dijkstra")){
                Dijkstra dijkstra = new Dijkstra(ras_yal.get(0));
                String s3 = sc.nextLine();
                ArrayList<Integer> x = new ArrayList<>();
                String[] convert4 = s3.split(" ", -1);
                for (String z5 : convert4) {
                    x.add(Integer.parseInt(z5));
                }
                // Dijkstra dijkstra = new Dijkstra(ras_yal.get(0));
                if(tagheer==0)
                System.out.println(dijkstra.dijkstra(grph,x.get(0),x.get(1)));
                if(tagheer==1)
                    System.out.println(dijkstra.dijkstra(temp_graph,x.get(0),x.get(1)));
                // if(tagheer==1)
                //     System.out.println(dijkstra.dijkstra(grph2,x.get(0),x.get(1)));
            }
            if(s2.equals("left")){
                String s3 = sc.nextLine();
                if(tagheer==0){
                    for(int i =0 ; i<ras_yal.get(0);i++){
                        grph[i][Integer.parseInt(s3)] = -1 ;
                        grph[Integer.parseInt(s3)][i] = -1 ;
                    }
                }
                if(tagheer==1){
                    for(int i =0 ; i<ras_yal.get(0);i++){
                        temp_graph[i][Integer.parseInt(s3)] = -1 ;
                        temp_graph[Integer.parseInt(s3)][i] = -1 ;
                    }
                }
                graph.removeEdge(Integer.parseInt(s3));
                ras.remove(Integer.parseInt(s3));
                int n = ras_yal.get(0);
               ras_yal.set(0,n-1);

            }

        }

    }
}
