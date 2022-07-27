import java.util.Scanner;

public class SLinkNode {
    Node L;

    void InitList()                    //初始化单链表L
    {
        L = new Node();    //创建头结点L
    }

    void DestroyList()        //销毁单链表L
    {
        Node pre = L, p = pre.next;
        while (p != null) {
            pre = null;
            pre = p;
            p = p.next;            //pre、p同步后移
        }
        pre = null;
    }

    int GetLength()            //求长度
    {
        int i = 0;
        Node p = L.next;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    int GetElem(int i, int e[])    //求第i个结点值
    {
        int j = 0;
        Node p = L;                    //p指向头结点，计数器j置为0
        if (i <= 0) return 0;                //参数i错误返回0
        while (p != null && j < i) {
            j++;
            p = p.next;
        }
        if (p == null)
            return 0;                    //未找到返回0
        else {
            e[0] = p.data;
            return 1;                    //找到后返回1
        }
    }

    int Locate(int e)    //求第一个值为e的结点位置
    {
        Node p = L.next;
        int j = 1;                        //p指向第一个数据结点，j置为其序号1
        while (p != null && p.data != e) {
            p = p.next;
            j++;
        }
        if (p == null) return (0);            //未找到返回0
        else return (j);                    //找到后返回其序号
    }

    int InsElem(int x, int i)    //插入结点值为x的结点
    {
        int j = 0;
        Node p = L, s;
        if (i <= 0) return 0;                //参数i错误返回0
        while (p != null && j < i - 1)        //查找第i-1个结点p
        {
            j++;
            p = p.next;
        }
        if (p == null)
            return 0;                    //未找到第i-1个结点时返回0
        else                            //找到第i-1个结点p
        {
            s = new Node();
            s.data = x;                    //创建存放元素x的新结点s
            s.next = p.next;            //将s结点插入到p结点之后
            p.next = s;
            return 1;                    //插入运算成功,返回1
        }
    }

    int DelElem(int i)    //删除结点
    {
        int j = 0;
        Node p = L, q;
        if (i <= 0) return 0;                //参数i错误返回0
        while (p != null && j < i - 1)        //查找第i-1个结点
        {
            j++;
            p = p.next;
        }
        if (p == null)
            return 0;                    //未找到第i-1个结点时返回0
        else                            //找到第i-1个结点p
        {
            q = p.next;                    //q指向被删结点
            if (q == null)
                return 0;                //没有第i个结点时返回0
            else {
                p.next = q.next;        //从单链表中删除q结点
                q = null;                //释放其空间
                return 1;
            }
        }
    }

    void DispList()            //输出单链表
    {
        Node p = L.next;
        while (p != null) {
            System.out.printf(""+p.data);
            p = p.next;
        }
        System.out.printf("\n");
    }

    void CreateListF(int a[], int n)    //头插法建表
    {
        Node s;
        int i;
        L = new Node();        //创建头结点
        L.next = null;                                    //头结点的next域置空
        for (i = 0; i < n; i++)                                //遍历a数组所有元素
        {
            s = new Node();
            s.data = a[i];                                //创建存放a[i]元素的新结点s
            s.next = L.next;                            //将s插在头结点之后
            L.next = s;
        }
    }

    void CreateListR(int a[], int n)    //尾插法建表
    {
        Node s, tc;
        int i;
        L = new Node();        //创建头结点
        tc = L;                                            //tc为L的尾结点指针
        for (i = 0; i < n; i++) {
            s = new Node();
            s.data = a[i];                                //创建存放a[i]元素的新结点s
            tc.next = s;                                    //将s结点插入tc结点之后
            tc = s;
        }
        tc.next = null;                                    //尾结点next域置为NULL
    }
    void DelElemAll_X(int x) {
        Node temp = L;
        /*单链表有空白头节点，故以temp.next为判断的节点*/
        while (temp.next != null){
            if(temp.next.data == x){    //判断temp.next.data的值是否等于指定元素
                temp.next = temp.next.next; //删除节点
            }else {
                temp = temp.next;       //判断下一个节点
            }
        }
    }
    public static void main(String args[]) {
        int i;int x;
        int[] e=new int[1];
        Scanner sca = new Scanner(System.in);
        Node L,L1,L2;
        SLinkNode snode=new SLinkNode();
        System.out.printf("测试1\n");
        snode.InitList();           //初始化单链表L
        snode.InsElem(1,1);             //插入元素1
        snode.InsElem(3,2);             //插入元素3
        snode.InsElem(1,3);             //插入元素1
        snode.InsElem(5,4);             //插入元素5
        snode.InsElem(4,5);             //插入元素4
        snode.InsElem(2,6);             //插入元素2
        System.out.printf("  L: ");snode.DispList();
        System.out.printf("  长度:"+snode.GetLength()+"\n");
        i=3;snode.GetElem(i,e);
        System.out.printf("  第"+i+"个元素:"+e[0]+"\n");
        e[0]=1;
        System.out.printf("  元素"+e[0]+"是第"+snode.Locate(e[0])+"个元素\n");
        i=4;System.out.printf("  删除第"+i+"个元素\n");
        snode.DelElem(i);
        System.out.printf("  L: ");snode.DispList();

        snode.DispList();
        System.out.printf("输入需要删除单链表所有值为x的元素：");
        x = sca.nextInt();
        snode.DelElemAll_X(x);
        snode.DispList();

        System.out.printf("测试2\n");
        int a[]={1,2,3,4,5};
        int n=a.length;
        System.out.printf("  由1～5采用头插法创建L1\n");
        snode.CreateListF(a,n);
        System.out.printf("  L1: ");snode.DispList();
        System.out.printf("测试3\n");
        System.out.printf("  由1～5采用尾插法创建L2\n");
        snode.CreateListR(a,n);
        System.out.printf("  L2: ");snode.DispList();
        System.out.printf("销毁L、L1和L2\n");

        snode.DestroyList();
        snode.DestroyList();
        snode.DestroyList();

    }
}