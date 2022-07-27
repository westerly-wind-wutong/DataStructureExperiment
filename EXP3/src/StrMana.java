class StrMana {

    void Assign(SqString s, char str[])    //串赋值
    {
        int i = 0;
        s.length = str.length;
        while (i < s.length)    //遍历str的所有字符
        {
            s.data[i] = str[i];
            i++;
        }

    }

    void DestroyStr(SqString s)    //销毁串
    {
    }

    void StrCopy(SqString s, SqString t) //串复制
    {
        int i;
        for (i = 0; i < t.length; i++)
            s.data[i] = t.data[i];
        s.length = t.length;
    }

    int StrLength(SqString s)            //求串长
    {
        return (s.length);
    }

    int StrEqual(SqString s, SqString t)  //判断串相等
    {
        int i = 0;
        if (s.length != t.length)            //串长不同时返回0
            return (0);
        else {
            for (i = 0; i < s.length; i++)
                if (s.data[i] != t.data[i])    //有一个对应字符不同时返回0
                    return 0;
            return 1;
        }
    }

    SqString Concat(SqString s, SqString t) //串连接
    {
        SqString r = new SqString();
        int i, j;
        for (i = 0; i < s.length; i++)           //将s复制到r
            r.data[i] = s.data[i];
        for (j = 0; j < t.length; j++)           //将t复制到r
            r.data[s.length + j] = t.data[j];
        r.length = i + j;
        return r;                           //返回r
    }

    SqString SubStr(SqString s, int i, int j) //求子串
    {
        SqString t = new SqString();
        int k;
        if (i < 1 || i > s.length || j < 1 || j > s.length + 1 || i == j)
            t.length = 0;            //参数错误时返回空串
        else {
            for (k = i - 1; k < j + i; k++)
                t.data[k - i + 1] = s.data[k];
            t.length = j - i;
        }
        return t;
    }

    int Index(SqString s, SqString t)    //串匹配
    {
        int i = 0, j = 0;                    //i和j分别扫描主串s和子串t
        while (i < s.length && j < t.length) {
            if (s.data[i] == t.data[j])    //对应字符相同时,继续比较下一对字符
            {
                i++;
                j++;
            } else                //否则,主子串指针回溯重新开始下一次匹配
            {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= t.length) return i - t.length + 1;    //返回第一个字符的位置
        else return 0;                            //返回0
    }

    int InsStr(SqString s, int i, SqString t)    //子串插入
    {   //将该函数中的代码补齐
        //DispStr(Concat(Concat(SubStr(s,1,2),t),SubStr(s,2,s.length+1)));
        SqString r = new SqString();
        int m;
        for (m = 0; m < i - 1; m++)
            r.data[m] = s.data[m];
        r.length = i - 1;
        for (int n = 0; n < t.length; n++)
            r.data[m + n] = t.data[n];
        r.length += t.length;
        for (int p = 0; p < s.length - i + 1; p++)
            r.data[r.length + p] = s.data[i - 1 + p];
        r.length = s.length + t.length;
        DispStr(r);
        return 0;
    }

    int DelStr(SqString s, int i, int j)            //子串删除
    {
        int k, q;
        if (i < 1 || i > s.length || j < 1 || i + j > s.length + 1)
            return 0;                        //位置参数值错误
        else {
            for (k = j, q = i; k < s.length; k++, q++) {
                //将s的第i+j位置之后的字符前移j位
                s.data[q - 1] = s.data[k];
            }
            s.length = s.length - (j - i + 1);            //修改s的长度
            return 1;                        //成功删除返回1
        }
    }

    SqString RepStrAll(SqString s, SqString s1, SqString s2)    //子串替换
    {
//        if(Index(s,s1)!=0) {
//            return Concat(Concat(SubStr(s, 1, Index(s, s1)), s2), SubStr(s, Index(s, s1) + s1.length, s.length + 1));
//        }

        int i = 0, j = 0, k = 0;                    //i和j分别扫描主串s和子串s1
        while (i < s.length && j < s1.length) {
            if (s.data[i] == s1.data[j]) {    //对应字符相同时,继续比较下一对字符
                i++;j++;
            } else {                //否则,主子串指针回溯重新开始下一次匹配
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= s1.length) k = i - s1.length + 1;  //返回第一个字符的位置
        if (k != 0) {
            int m, n, p;
            SqString r = new SqString();
            for (m = 0; m < k - 1; m++)
                r.data[m] = s.data[m];
            r.length = m;
            for (n = 0; n < s2.length; n++)
                r.data[r.length + n] = s2.data[n];
            r.length += s2.length;
            for (p = 0; p<s.length - k + 1;p++)
                r.data[r.length+p]=s.data[k+s1.length-1+p];
            r.length=s.length-s1.length+s2.length;
            return  r;
        }

        else return null;
    }



    void DispStr(SqString s)        //输出串
    {
        int i;
        for (i = 0; i < s.length; i++)
            System.out.printf("%c", s.data[i]);
        System.out.printf("\n");
    }

    public static void main(String[] args)            //主函数
    {
        SqString s1, s2, s3, s4, s5, s6, s7;
        StrMana stm = new StrMana();
        s1 = new SqString();
        s2 = new SqString();
        s3 = new SqString();
        s4 = new SqString();
        s5 = new SqString();
        s6 = new SqString();
        s7 = new SqString();
        stm.Assign(s1, "abcd".toCharArray());
        System.out.printf("s1:");
        stm.DispStr(s1);
        System.out.printf("s1的长度:%d\n", stm.StrLength(s1));
        System.out.printf("s1=>s2\n");
        stm.StrCopy(s2, s1);
        System.out.printf("s2:");
        stm.DispStr(s2);
        System.out.printf("s1和s2%s\n", (stm.StrEqual(s1, s2) == 1 ? "相同" : "不相同"));
        stm.Assign(s3, "12345678".toCharArray());
        System.out.printf("s3:");
        stm.DispStr(s3);
        System.out.println("**********s2插入s3的第2个位置**********");
        stm.InsStr(s3, 2, s2);
        System.out.println("********************");
        System.out.printf("s1和s3连接=>s4\n");
        s4 = stm.Concat(s1, s3);
        System.out.printf("s4:");
        stm.DispStr(s4);
        System.out.printf("s3[2..5]=>s5\n");
        s5 = stm.SubStr(s3, 2, 4);
        System.out.printf("s5:");
        stm.DispStr(s5);
        stm.Assign(s6, "567".toCharArray());
        System.out.printf("s6:");
        stm.DispStr(s6);
        System.out.printf("s6在s3中位置:%d\n", stm.Index(s3, s6));
        System.out.printf("从s3中删除s3[3..6]字符\n");
        stm.DelStr(s3, 3, 6);
        System.out.printf("s3:");
        stm.DispStr(s3);
        System.out.printf("从s4中将s6替换成s1=>s7\n");
        s7 = stm.RepStrAll(s4, s6, s1);
        System.out.printf("s7:");
        stm.DispStr(s7);
        stm.DestroyStr(s1);
        stm.DestroyStr(s2);
        stm.DestroyStr(s3);
        stm.DestroyStr(s4);
        stm.DestroyStr(s5);
        stm.DestroyStr(s6);
        stm.DestroyStr(s7);
    }
}