import java.util.Scanner;

class SqQueue<ElemType>{
    public static final int MaxSize=4;
    int front,rear;             //队头和队尾指针
    ElemType data[];      //保存队中元素
    @SuppressWarnings("unchecked")

    SqQueue(){
        data=(ElemType[])new Object[MaxSize];
    }
    void InitQueue()      //初始化循环队列sq
    {
        rear=front=0;        //指针初始化
    }

    void DestroyQueue()    //销毁循环队列sq
    {  }

    int EnQueue(ElemType x)    //进队列元素x
    {  //将该函数中的代码补齐
        if(front==(rear+1)%MaxSize){
            System.out.println("队满,进队失败！");
            return 0;
        }else {
            rear=((rear+1)%MaxSize);
            data[rear] = x;
            return  1;
        }
    }

    int DeQueue(ElemType x[])     //出队元素x
    {  //将该函数中的代码补齐
        if(QueueEmpty()){
            System.out.println("队空！出队失败！");
            return 0;
        }else {
            front=(front+1)%MaxSize;
            x[0] = data[front];
            return 1;
        }
    }

    void DisplayQueue()       //输出队列中的所有元素
    {  //将该函数中的代码补齐
//        int i=(front+1)%MaxSize ;
//        while (i!=rear+1){
//            System.out.println(data[i]);
//            i=(i+1)%MaxSize;
//        }
        for (int i=(front+1)%MaxSize;i!=rear+1;i=(i+1)%MaxSize){
            System.out.println(data[i]);
        }
    }

    int GetHead(ElemType x[])     //取队头元素x
    {  if (QueueEmpty())            //队空下溢出
        return 0;
    else{
        x[0]=data[(front+1) % MaxSize];
        return 1;
    }
    }

    boolean QueueEmpty()         //判断循环队列sq是否为空
    {  if (rear==front) return true;
    else return false;
    }
    public static void main(String args[])                           //主函数
    {  SqQueue<Character> sq=new SqQueue<Character>();
        Character[] e=new Character[1];
        System.out.println("初始化队列");
        sq.InitQueue();
        System.out.printf("队%s\n",(sq.QueueEmpty()==true?"空":"不空"));
        System.out.printf("a进队\n");sq.EnQueue('a');
        System.out.printf("b进队\n");sq.EnQueue('b');
        System.out.printf("c进队\n");sq.EnQueue('c');
        System.out.printf("a出队\n");sq.DeQueue(e);
        System.out.printf("b出队\n");sq.DeQueue(e);
//        System.out.printf("c出队\n");sq.DeQueue(e);
        System.out.printf("d进队\n");sq.EnQueue('d');
        System.out.printf("e进队\n");sq.EnQueue('e');
        System.out.printf("当前队列中的所有元素如下：\n");
        sq.DisplayQueue() ;
        System.out.printf("队%s\n",(sq.QueueEmpty()==true?"空":"不空"));
        sq.GetHead(e);
        System.out.printf("队头元素:"+e[0]+"\n");
        System.out.printf("出队次序:");
        while (!(sq.QueueEmpty()))    //队不空循环
        {  sq.DeQueue(e);       //出队元素e
            System.out.printf(""+e[0]);       //输出元素e
        }
        System.out.printf("\n销毁队列\n");
        sq.DestroyQueue();
    }
}
