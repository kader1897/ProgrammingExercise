package recursion;

public class Recursion {

    public static void stringPermutation(String s)
    {
        stringPermutation("", s);
    }

    public static void stringPermutation(String prefix, String s)
    {
        if(s.length() == 1)
            System.out.println(prefix + s);
        else
        {
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++)
            {
                stringPermutation(prefix + chars[i], s.substring(0,i) + s.substring(i+1));
            }
        }
    }

    public static void stringCombination(String s)
    {

    }

    public static void stringCombination()
    {
        
    }

    public static void main(String[] args)
    {
        stringPermutation("kader");
    }
}