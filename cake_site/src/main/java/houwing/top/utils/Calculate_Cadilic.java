package houwing.top.utils;

public class Calculate_Cadilic {
    Integer first_year=null;
    Integer second_year=null;
    Integer third_year=null;
    Integer fourth_year=null;
    Integer fifth_year=null;

    private static Integer calculte_exe(Integer first_year,Integer second_year,
                                 Integer third_year,Integer fourth_year, Integer fifth_year){
        Integer sum=0;
        if(first_year!=null)
            sum=sum+(first_year*12);
        if(second_year!=null)
            sum=sum+(second_year*12);
        if(third_year!=null)
            sum=sum+(third_year*12);
        if(fourth_year!=null)
            sum=sum+(fourth_year*12);
        if(fifth_year!=null)
            sum=sum+(fifth_year*12);
        return sum;
    }

    public static void main(String args[]){
        System.out.println("CT5-36 price: "+calculte_exe(3999,4699,4699,null,null));
        System.out.println("CT5-48 price: "+calculte_exe(2999,4399,4399,4399,null));
        System.out.println("CT5-60 price: "+calculte_exe(2999,3699,3699,3699,3699));
        System.out.println("CT5-1-36 price: "+calculte_exe(3999,4999,4999,null,null));
        System.out.println("CT5-1-36 price: "+calculte_exe(2999,4699,4699,4699,null));
        System.out.println("CT5-1-36 price: "+calculte_exe(2999,3999,3999,3999,3999));
    }

}
