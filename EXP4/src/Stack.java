import java.util.Scanner;
class Stack<ElemType>{
    public static final int MaxSize = 100;
    public int top;                    //栈顶指针
    public ElemType[] data;   //保存栈中元素
    @SuppressWarnings("unchecked")
    Stack(){
        data = (ElemType[]) new Object[MaxSize];
    }
    void InitStack()      //初始化顺序栈st
    {
        top=-1;
    }
    void DestroyStack()    //销毁顺序栈st
    {  }

    int Push(ElemType x)   //进栈元素x
    {  //将该函数中的代码补齐
    if(top+1 < MaxSize){
        top++;
        data[top] = x;
    }
    else
        System.out.println("栈满(full)");
    return 0;
    }

    int Pop(ElemType x[])  //出栈元素x
    {  //将该函数中的代码补齐
        if(top == -1){
            System.out.println("栈空(null)");
        return 0;
        }
        else {
            x[0]=data[top--];
            return 1;
        }
    }

    int GetTop(ElemType x[])   //取栈顶元素x
    {  if (top==-1)               //栈空
        return 0;
    else
    {  x[0]=(ElemType)data[top];
        return 1;
    }
    }

    boolean StackEmpty()      //判断栈是否为空
    {  if (top==-1) return true;
    else return false;
    }


    public static void main(String args[]){            //主函数
        Stack<Character> st=new Stack<Character>();
        Character[] e=new Character[1];
        System.out.printf("初始化栈st\n");
        st.InitStack();
        System.out.printf("栈%s\n",(st.StackEmpty()==true?"空":"不空"));
        System.out.printf("a进栈\n");st.Push('a');
        System.out.printf("b进栈\n");st.Push('b');
        System.out.printf("c进栈\n");st.Push('c');
        System.out.printf("d进栈\n");st.Push('d');
        System.out.printf("栈%s\n",(st.StackEmpty()==true?"空":"不空"));
        st.GetTop(e);
        System.out.printf("栈顶元素:%c\n",e);
        System.out.printf("出栈次序:");
        while (!(st.StackEmpty()))      //栈不空循环
        {    st.Pop(e);          //出栈元素e并输出
            System.out.printf("%c ",e);
        }
        System.out.printf("栈%s\n",(st.StackEmpty()==true?"空":"不空"));

        System.out.println("请输入一算术表达式：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        st.Push('#');
        int i ;
        for(i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch != '#') {
                if(ch == '('){
                    st.Push(ch);
                }
                if(ch == ')'){
                    st.Pop(e);
                    System.out.printf("%c",e);
                }
            }
        }
        if
        System.out.printf("\n销毁栈st\n");
        st.DestroyStack();
    }
}