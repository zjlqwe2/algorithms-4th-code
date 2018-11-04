package UnionFind;

public class QuickUnionUF {
    private int[] id;
    private int count;
    QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
        count = N;
    }
    private int find(int p){
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if(qId == pId) return;
        id[pId] = qId;
        count--;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
}
