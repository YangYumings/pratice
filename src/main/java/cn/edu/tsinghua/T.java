package cn.edu.tsinghua;

public class T {
    public static void main(String[] args) {
        int res = print(0);
        System.out.println(res);
    }

    public static int print(int num) {
        try{
            num += 10;
            return num;
        }catch(Exception e){
            System.out.println("finally");
        }finally{
            num += 10;
            return num;
        }
    }
}
