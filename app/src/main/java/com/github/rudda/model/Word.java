package com.github.rudda.model;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public int jumbledLetters(String pseudo, int length) {
        int jumbled_count = 0;
        //let isNotjumbled_count = 0;

        if (this.word.charAt(0) == pseudo.charAt(0)) {
            jumbled_count ++;
            this.word = this.word.substring(1);
            pseudo = pseudo.substring(1);

            for(int i= 0;  i < length ; i++) {
                boolean isJumbled = this.isJumbled(word.substring(i), pseudo.substring(i));
                if(isJumbled) {
                    jumbled_count ++;
                }
            }
        }
        return jumbled_count;
    }

    private boolean isJumbled(String str, String str2) {
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
}
