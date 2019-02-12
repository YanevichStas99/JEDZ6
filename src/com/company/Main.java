package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
        String[] emails = {"test.email+alex@test.com", "test.e.mail+bob.cathy@test.com", "testemail+david@lee.test.com"};
        System.out.println(numUniqueEmails(emails));
        System.out.println("Task 2");
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));

    }


    private static int uniqueMorseRepresentations(String[] words) {
        char[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String[] morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] morseWords=new String[words.length];
        HashSet<String> hashSet=new HashSet<>();
        for (int i = 0; i <words.length ; i++) {
            String s=words[i];
            for (int j = 0; j <s.length() ; j++) {
                for (int k = 0; k <alphabet.length ; k++) {
                    if(s.charAt(j)==alphabet[k]){
                        morseWords[i]=morseWords[i]+morse[k];
                    }
                }
            }
            hashSet.add(morseWords[i]);
        }
        return hashSet.size();
    }

    private static int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet=new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder str = new StringBuilder(emails[i]);
            String s=emails[i];
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='.'){
                    count++;
                }
            }
            while (count!=0){
                str.deleteCharAt(str.indexOf("."));
                count--;
            }
            if(s.contains("+")){
                str.delete(str.indexOf("+"),str.indexOf("@"));
            }
            s=str.toString();
            hashSet.add(s);
        }
        return hashSet.size();
    }


}
