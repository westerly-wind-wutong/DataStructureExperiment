import java.util.Arrays;
import java.util.Scanner;

class VType {
    int adjvex;                    //顶点编号
    char[] data;            //顶点的信息

    VType() {
        this.adjvex = 0;
        data = new char[10];
    }
}
class MatGraph {    //图的邻接矩阵类型
    public static final int MAXVEX = 10;

    int n, e;                    //n为实际顶点数,e为实际边数
    VType vexs[];//顶点集合
    int edges[][];    //边的集合

    MatGraph() {
        n = 0;
        e = 0;
        vexs = new VType[MAXVEX];
        for (int i = 0; i < MAXVEX; i++) {
            vexs[i] = new VType();
        }
        edges = new int[MAXVEX][MAXVEX];
    }
}

class Graph {
    public static final int MAXVEX = 10;
    public static final int INF = 32767;
    MatGraph g;
    Scanner sca = new Scanner(System.in);

    Graph() {
        g = new MatGraph();
    }

    void CreateGraph(int A[][], int n, int e)
//由邻接矩阵数组A、顶点数n和边数e建立图G的邻接矩阵存储结构
    {
        int i, j;
        char[] str;
        str = new char[10];

        g.n = n;
        g.e = e;

        System.out.printf("\n  输入顶点的信息（整型）：");
        for (i = 0; i < n; i++) {
            System.out.printf("\n第%d个顶点： ", (i + 1));
            str = sca.nextLine().toCharArray();
            g.vexs[i].adjvex = i + 1;
            g.vexs[i].data = str.clone();
        }
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                g.edges[i][j] = A[i][j];
    }

    void DestroyGraph()        //销毁图
    {
    }

    void DispGraph()            //显示图G的结构
    {
        int i, j;
        for (i = 0; i < g.n; i++) {
            for (j = 0; j < g.n; j++)
                if (g.edges[i][j] < INF)
                    System.out.printf("%4d", g.edges[i][j]);
                else
                    System.out.printf("%4s", "∞");
            System.out.printf("\n");
        }
    }

    int Degree(int i)    //求无向图G中第i个顶点的度
    {
        int j, d = 0, v = i - 1;
        if (v < 0 || v >= g.n)
            return -1;                //顶点编号错误返回-1
        for (j = 0; j < g.n; j++)
            if (g.edges[v][j] > 0 && g.edges[v][j] < INF)
                d++;                //统计第v行既不为0也不为∞的边数即度
        return d;
    }

    int SearchVexs(char[] v) { //查询顶点v是否在图g中存在，如果存在，返回该顶点在顶点数组中的下标，如果不存在返回-1
        int i;
        for (i = 0; i < g.n; i++) {
            if (Arrays.equals(g.vexs[i].data, v) == true)
                break;
        }
        if (i == g.n)
            return -1;
        else
            return i;
    }

    void InserdEdge(char[] v1, char[] v2, int w) { //若顶点v1,v2存在，则在这对顶点之间插入一条权值为w的无向边
        //将该函数中的代码补齐
        int e1 = SearchVexs(v1);
        int e2 = SearchVexs(v2);
        if (e1 >= 0 && e2 >= 0 && e1!=e2){
            g.edges[e1][e2] = w;
            g.edges[e2][e1] = w;
            g.e++;
        }
    }

    void DeletedEdge(char[] v1, char[] v2) { //若顶点v1,v2存在并且存在一条无向边，则删除这对顶点之间的无向边
        //将该函数中的代码补齐
        int e1 = SearchVexs(v1);
        int e2 = SearchVexs(v2);
        if(e1 >= 0 && e2 >= 0 && e1!=e2 && g.edges[e1][e2]!=INF && g.edges[e2][e1] != INF){
            g.edges[e1][e2] = INF;
            g.edges[e2][e1] = INF;
            g.e--;
        }
    }

    void InserdVexs(char[] v) {  //在无向图g中插入一个新顶点v
        //将该函数中的代码补齐
        if(g.vexs.length > g.n && SearchVexs(v) == -1){
            g.vexs[g.n].data = v;
            for (int i = 0;i <= g.n;i++){
                g.edges[g.n][i] = INF;
                g.edges[i][g.n] = INF;
                g.e--;
            }
            g.n++;
        }
    }
    void DeletedVexs(char[] v) {  //在无向图g中删除顶点v
        //将该函数中的代码补齐
        int e1 = SearchVexs(v);
        if(e1>=0){
            for (int i = 0;i<g.n-e1-1;i++){
                g.vexs[e1+i].data = g.vexs[e1+i+1].data;
                for (int j = 0;j<g.n;j++){
                g.edges[e1+i][j] = g.edges[e1+i+1][j];
                g.edges[j][e1+i] = g.edges[j][e1+i+1];
                g.edges[e1+i][e1+i]=INF;
                g.e--;
                }
            }
            g.n--;
        }
    }

    public static void main(String args[])     //主函数
    {
        Graph g = new Graph();
        int A[][] = new int[][]{
                {INF, 2, 5, 3, INF, INF, INF},
                {2, INF, 2, INF, INF, 8, INF},
                {5, 2, INF, 1, 3, 5, INF},
                {3, INF, 1, INF, 5, INF, INF},
                {INF, INF, 3, 5, INF, 3, 9},
                {INF, 8, 5, INF, 3, INF, 5},
                {INF, INF, INF, INF, 9, 5, INF}};
        int n = 7, e = 12;
        g.CreateGraph(A, n, e);    //建立图的邻接矩阵
        System.out.printf("图G的存储结构:\n");
        g.DispGraph();
        char[] v1 = "c".toCharArray();
        char[] v2 = "f".toCharArray();
        System.out.printf("在顶点v1(c),v2(f)之间插入一条权值为4的无向边:\n");
        g.InserdEdge(v1,v2,4);
        g.DispGraph();
        v1 = "a".toCharArray();
        v2 = "b".toCharArray();
        System.out.printf("删除顶点v1(a),v2(b)之间的无向边：\n");
        g.DeletedEdge(v1,v2);
        g.DispGraph();
        v1 = "v".toCharArray();
        System.out.printf("在无向图g中插入一个新顶点v:\n");
        g.InserdVexs(v1);
        g.DispGraph();
        String str = "c";
        v1 = str.toCharArray();
        System.out.printf("在无向图g中删除顶点v("+str+"):\n");
        g.DeletedVexs(v1);
        g.DispGraph();
        System.out.printf("图G中所有顶点的度:\n");
        System.out.printf("  顶点\t度\n");
        for (int i = 0; i < g.g.n; i++)
            System.out.printf("  "+Arrays.toString(g.g.vexs[i].data)+"  \t%d\n",  g.Degree(i + 1));
        System.out.printf("销毁图\n");
        System.out.printf("销毁图\n");
        System.out.printf("销毁图\n");
        g.DestroyGraph();

    }

}
