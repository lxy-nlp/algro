public class test {
    public static void main(String[] args){
        int res=solve(456);
        System.out.print(res);
    }
    //贪心算法简单例子
    public static int solve(int money) {
        int N=5;
        int num=0;
        if(money<0) num=-1;
        int[] count={5,2,2,3,5};
        int[] value={1,5,10,50,100};
        for(int i=N-1;i>=0;i--) {
            int c=Math.min(money/value[i],count[i]);
            money=money-c*value[i];
            num+=c;
        }
        return num;
    }
}
