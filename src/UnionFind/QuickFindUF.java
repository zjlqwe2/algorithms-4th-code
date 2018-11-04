package UnionFind;

public class QuickFindUF {
    private int[] id;
    private int count;
    private int N;
    QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
        count = N;
        this.N = N;
    }
    private int find(int p){
        return id[p];
    }
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if(qId == pId) return;
        for(int i = 0; i < N; i++){
            if(id[i] != qId) id[i] = pId;
        }
        count--;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
}
