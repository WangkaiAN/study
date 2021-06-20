package day47;

public class Main {
    public static void main(String[] args) {
        System.out.println(isNumeric("12.6e+6"));
    }
    public static boolean isNumeric (String str) {
        // write code here
        if(str.length() == 1 && (str.charAt(0) > '9' || str.charAt(0) < '0')){
            return false;
        }
        char[] ch=str.toCharArray();
        if(ch.length==0 || ch==null){
            return false;
        }
        int dotNum=0;//.的数量
        int index=0;//索引位置
        int eNum=0;//记录e的数量
        int num=0;//记录数字的数量
        if(ch[0]=='+' || ch[0]=='-'){
            index++;
        }
        while(index<ch.length){
            if(ch[index]>='0' && ch[index]<='9'){
                index++;
                num=1;
            }
            else if(ch[index]=='.'){// e后面不能有.,e的个数不能大于1.
                if(dotNum>0 || eNum>0){
                    return false;
                }
                dotNum++;
                index++;
            }
            else if(ch[index]=='e' || ch[index]=='E'){// 重复e或者e前面没有数字
                if(eNum>0 || num==0){
                    return false;
                }
                eNum++;
                index++;
                if(index<ch.length &&(ch[index]=='+'|| ch[index]=='-')){
                    index++;
                }
                if(index==ch.length){//若e作为最后一个字符，就不符合，需要返回false
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}
