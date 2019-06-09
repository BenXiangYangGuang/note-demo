package com.wewe.arrowOffer;


import java.lang.String;
import java.util.ArrayList;
public class Solution {
    //回文字符串，正反读都一样
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<>();
        partitionHapler(lists,list,s);
        return lists;
    }

    public void partitionHapler(ArrayList<ArrayList<String>> lists,ArrayList<String> list,String s){
        if(null == s || s.length() == 0){
            lists.add(new ArrayList<String>(list));
        }
        for(int i = 0; i <=s.length(); i++){
            String subStr = s.substring(0,i);
            if(isPalindrome(subStr)){
                list.add(subStr);
                partitionHapler(lists,list,s.substring(i,s.length()));
                list.remove(list.size() - 1);
            }

        }
    }
    public boolean isPalindrome(String s){
        if(s.length() == 0 || s == null){
            return false;
        }
        int middle = s.length() / 2;
        for(int i = 0; i < middle; i++){
            if(s.charAt(i) !=s.charAt(s.length()-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.partition("abbab");
    }
}