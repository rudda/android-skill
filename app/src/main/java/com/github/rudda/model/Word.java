package com.github.rudda.model;

import android.util.Log;

import java.util.HashMap;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public int jumbledLetters(String pseudo, int length) {
        //length = this.word.length();
        int jumbled_count = 0;
        //let isNotjumbled_count = 0;

        if (this.word.charAt(0) == pseudo.charAt(0)) {
            jumbled_count+= 1;
            String w;
            w = this.word.substring(1);
            pseudo = pseudo.substring(1);
            Log.i("aqui", w.length() +" " + pseudo);
            for(int i= 0;  i < (w.length() -1); i++) {
                boolean _isJumbled = this.isJumbled(w.substring(i), pseudo.substring(i));
                Log.i("aqui", "isJumbled " + _isJumbled );
                if(_isJumbled) {
                    jumbled_count += 1;
                    Log.i("aqui", " jumbled_count " +jumbled_count);
                }
            }
        }
        return jumbled_count;
    }

    private boolean isJumbled(String str, String str2) {
        Log.i("aqui", "str1 "+str +" str2 "+ str2);
        if(str.charAt(0) == str2.charAt(0)){
            return false;
        } else if (str2.charAt(1) == str.charAt(0) && str2.charAt(0) == str.charAt(1)) {
            return true;
        }
        return false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private void register(int index,  char my_char, boolean match, HashMap<Integer, WordMatch > map) {
        map.put(index, new WordMatch(my_char, match));
    }

    public boolean isTypo (String str1, String str2) {
        HashMap<Integer, WordMatch > char_map = new HashMap<>();
        int str1_index= str1.length();
        int str2_index= str2.length();
        int j=0, j_index = 0;
        boolean match= false; int typo=0;

        for(int i=0; i< str1_index; i++) {
            j_index = j;

            if (j == str2_index) {
                match = false;
                register(i, str1.charAt(i), match, char_map) ;
            }
            for(;j<str2_index; j++){

                if(str1.charAt(i) == str2.charAt(j)) {
                    match = true;
                    register(i, str1.charAt(i), match, char_map) ;
                    j++;
                    break;
                } else {
                    match = false;
                    register(i, str1.charAt(i), match, char_map) ;
                }

            }

            j= !match ?  j_index : j;
            typo= (char_map.get(i).isStatus()) == false ? typo += 1: typo;
        }

        return typo <= 1;
    }

    class WordMatch {
        char value;
        boolean status;

        public WordMatch(char value, boolean status) {
            this.value = value;
            this.status = status;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
}
