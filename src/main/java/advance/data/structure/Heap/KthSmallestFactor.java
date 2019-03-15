package advance.data.structure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Question: https://stackoverflow.com/questions/7215315/find-the-kth-least-number-for-expression-2x3y5z
 */
public class KthSmallestFactor {

    public static void main(String[] args){

        for(int i=1;i<=10;i++){
            System.out.println(kthSmallest(i));
        }
    }

    private static int kthSmallest(int k){
        PriorityQueue<Triplet> p = new PriorityQueue<Triplet>(10, new Comparator<Triplet>() {
            public int compare(Triplet t1, Triplet t2) {
                int score1 = (int) (Math.pow(2, t1.a) * Math.pow(3, t1.b) * Math.pow(5, t1.c)) ; 
                int score2 = (int) (Math.pow(2, t2.a) * Math.pow(3, t2.b) * Math.pow(5, t2.c));
                return score1 -score2;
            }
        });

        p.add(new Triplet(1, 1, 1));
        int count =1;
        while(count <k){
            Triplet top = p.poll();
            count++;
            int a = top.a;
            int b = top.b;
            int c = top.c;
            Triplet t = new Triplet(a+1, b, c);
            if(!p.contains(t)){
                p.add(t);
            }
            t = new Triplet(a, b+1, c);
            if(!p.contains(t)){
                p.add(t);
            }
            t = new Triplet(a, b, c+1);
            if(!p.contains(t)){
                p.add(t);
            }
        }
        Triplet kth = p.poll();
        System.out.println("a: "+kth.a+"b: "+kth.b+"c: "+kth.c);
        return (int) (Math.pow(2, kth.a) * Math.pow(3, kth.b) * Math.pow(5, kth.c));
    }
}
class Triplet{
    int a ;
    int b;
    int c;

    public Triplet(int a , int b, int c){
        this.a = a;
        this.b=b;
        this.c = c;
    }

    public boolean equals(Object other){
        Triplet t = (Triplet)other;
        return this.a== t.a && this.b==t.b && this.c == t.c; 
    }
}
