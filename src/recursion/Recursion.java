package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recursion {

    private static void stringPermutation(String s)
    {
        stringPermutation("", s);
    }

    private static void stringPermutation(String prefix, String s)
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

    private static void stringCombination(String s)
    {
        ArrayList<Character> chars = new ArrayList<>();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            if(!map.containsKey(c))
            {
                chars.add(c);
                map.put(c,true);
            }
        }
        for(int i = 1; i <= chars.size(); i++)
            stringCombination(chars, "", 0, i);
    }

    private static void stringCombination(List<Character> chars, String prefix, int beginIndex, int length)
    {
        if(length == 0) {
            System.out.println(prefix);
            return;
        }
        for(int j = beginIndex; j + length <= chars.size(); j++) {
            stringCombination(chars, prefix + chars.get(j), j + 1, length - 1);
        }
    }

    public static void main(String[] args)
    {
        stringPermutation("kader");
        stringCombination("wxyz");
    }
}