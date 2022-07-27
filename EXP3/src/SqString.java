class SqString {
    public static final int MaxSiz = 100;
    public char data[];            //存放串字符
    public int length;                    //存放串的实际长度//
    SqString(){
        data=new char[MaxSiz];
        length=0;
    }
}