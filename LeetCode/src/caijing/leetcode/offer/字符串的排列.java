package caijing.leetcode.offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Caij on 2016/3/30.
 */
public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        TreeSet treeSet = new TreeSet();
        Permutation(str.toCharArray(), 0, treeSet);
        result.addAll(treeSet);
        return result;
    }

    public void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }

        if(begin == chars.length-1) {
            result.add(String.valueOf(chars)) ;
        }else {
            for(int i=begin ; i<=chars.length-1 ; i++) {
                swap(chars, begin, i) ;

                Permutation(chars, begin+1, result);

                swap(chars, begin, i) ;
            }
        }
    }

    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
