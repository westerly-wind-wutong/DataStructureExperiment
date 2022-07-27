class BtMana {
    public static final int MaxSiz = 100;
    BTNode<Character> bt;

    BtMana() {
        bt = new BTNode<Character>();
    }


    void CreateBTree(char[] str)    //由括号表示串创建二叉链
    {
        BTNode<Character> St[], p = null;
        St = new BTNode[MaxSiz];
        int top = -1, k = 0, j = 0;
        char ch;
        bt = null;            //建立的二叉树初始时为空

        while (j < str.length)    //str未扫描完时循环
        {
            ch = str[j];
            switch (ch) {
                case '(':
                    top++;
                    St[top] = p;
                    k = 1;
                    break;    //为左孩子结点
                case ')':
                    top--;
                    break;
                case ',':
                    k = 2;
                    break;                    //为右孩子结点
                default:
                    p = new BTNode<Character>();
                    p.data = ch;
                    p.lchild = p.rchild = null;
                    if (bt == null)                    //*p为二叉树的根结点
                        bt = p;
                    else                            //已建立二叉树根结点
                    {
                        switch (k) {
                            case 1:
                                St[top].lchild = p;
                                break;
                            case 2:
                                St[top].rchild = p;
                                break;
                        }
                    }
            }
            j++;
        }
    }

    void DestroyBTree(BTNode bt)        //销毁二叉链
    {
        if (bt != null) {
            DestroyBTree(bt.lchild);
            DestroyBTree(bt.rchild);
            bt = null;
        }
    }

    void DispBTree(BTNode bt)            //输出二叉链的括号表示串
    {
        if (bt != null) {
            System.out.printf("%c", bt.data);
            if (bt.lchild != null || bt.rchild != null) {
                System.out.printf("(");            //有子树时输入'('
                DispBTree(bt.lchild);    //递归处理左子树
                if (bt.rchild != null)    //有右子树时输入'.'
                    System.out.printf(",");
                DispBTree(bt.rchild);    //递归处理右子树
                System.out.printf(")");            //子树输出完毕，再输入一个')'
            }
        }
    }

    void PreOrder(BTNode bt)        //先序遍历算法
    {    //将该函数中的代码补齐
        if(bt != null){
            System.out.print(bt.data.toString()+" ");
            PreOrder(bt.lchild);
            PreOrder(bt.rchild);
        }
    }

    void InOrder(BTNode bt)        //中序遍历算法
    {    //将该函数中的代码补齐
        if(bt != null){
            InOrder(bt.lchild);
            System.out.print(bt.data.toString()+" ");
            InOrder(bt.rchild);
        }
    }

    void PostOrder(BTNode bt)        //后序遍历算法
    {    //将该函数中的代码补齐
        if(bt !=null){
            PostOrder(bt.lchild);
            PostOrder(bt.rchild);
            System.out.print(bt.data.toString()+" ");
        }
    }

    int HeightBTree(BTNode bt)      //二叉树的度
    {
        int lh,rh;
        if(bt == null){
            return 0;
        }else {
            lh = HeightBTree(bt.lchild);
            rh = HeightBTree(bt.rchild);
            if(lh > rh){
                return lh+1;
            }else
            return rh+1;
        }
    }

    void DisplayBTree(BTNode bt,int i,int j)  // 二叉树第i层中的结点
    {
        if(bt != null){
            if(i == j+1){
                System.out.print(bt.data.toString()+" ");
            }
            DisplayBTree(bt.lchild,i,j+1);
            DisplayBTree(bt.rchild,i,j+1);
        }
    }

    void DisplayBTree1(BTNode bt,int i)
    {
        if(bt!=null){
            if(i==1){
                System.out.print(bt.data+" ");
            }else {
                DisplayBTree1(bt.lchild,i-1);
                DisplayBTree1(bt.rchild,i-1);
            }
        }
    }

    public static void main(String args[])                 //主函数
    {
        BtMana bm = new BtMana();

        bm.CreateBTree("A(B(D,E(G,H)),C(,F(I)))".toCharArray());        //构造二叉链
        System.out.printf("二叉树bt:");
        bm.DispBTree(bm.bt);
        System.out.printf("\n");
        System.out.printf("先序遍历序列:");
        bm.PreOrder(bm.bt);
        System.out.printf("\n");
        System.out.printf("中序遍历序列:");
        bm.InOrder(bm.bt);
        System.out.printf("\n");
        System.out.printf("后序遍历序列:");
        bm.PostOrder(bm.bt);
        System.out.printf("\n");
        System.out.printf("二叉树的度:");
        System.out.printf(bm.HeightBTree(bm.bt)+"\n");
        System.out.printf("二叉树第3层中的节点：");
        bm.DisplayBTree(bm.bt,3,0);
        System.out.printf("\n");
        System.out.printf("方法二：");
        bm.DisplayBTree1(bm.bt, 3);
        bm.DestroyBTree(bm.bt);
    }
}
