package com.junk.application;


import java.util.Random;

/**
 * A class for generating random character sequence.
 * <br>to generate a random string 
 * RandomChar rc = new RandomChar();
 * System.out.println(rc.generate(RandomChar.Type.DIGITS_LETTERS_UPPERLOWERCASE,20));
 * so ez right?
 * @author Elmerhd
 */
public class RandomKeyGenerator {
    /**
     * enum type of generation
     */
    public enum Type {DIGITS_ONLY,LETTERS_LOWERCASE,LETTERS_UPPERCASE
    ,LETTERS_UPPERLOWERCASE,DIGITS_LETTERS_LOWERCASE,DIGITS_LETTERS_UPPERCASE,DIGITS_LETTERS_UPPERLOWERCASE}
    
    /**
     * Generates a random string from a pattern. <br>
     * for example if want to generate a String like 4Nu40-J91vIw6-0720<br>
     * so basically the pattern is [iXcii-XiixXxi-iiii]<br>
     * escape char for :x,:X,:i
     * c stands for lowercase character,C stands for uppercase character <br>
     * and i stands for integer
     * @param pattern the pattern e.g [iCcii-CiicCci-iiii]
     * @return the generated random key based on pattern
     */
    public String generateByPattern(String pattern){
        String generated = "";
        if(!pattern.startsWith("[") || !pattern.endsWith("]")){
            generated = "Invalid format";
        }else{
            pattern = pattern.substring(1, pattern.length()-1);
            for (int i = 0; i < pattern.length(); i++) {
                switch (pattern.charAt(i)) {
                    case 'i':
                        if(checkifEscapped(pattern, i)){
                            generated = generated += pattern.charAt(i);
                        }else{
                            generated = generated += g_d();
                        }
                        break;
                    case 'X':
                        if(checkifEscapped(pattern, i)){
                            generated = generated += pattern.charAt(i);
                        }else{
                            generated = generated += g_l_uc();
                        }
                        break;
                    case 'x':
                        if(checkifEscapped(pattern, i)){
                            generated = generated += pattern.charAt(i);
                        }else{
                            generated = generated += g_l_lc();
                        }
                        break;
                    case ':':
                        break;
                    default:
                        generated = generated += pattern.charAt(i);
                        break;
                }
            }
        }
        return generated;
    }
    public boolean checkifEscapped(String str,int i){
        if(i == 0){
            return false;
        }else {
            return str.charAt(i-1)==':';
        }
    }
    /**
     * returns a generated random strings based on <br> size and type.
     * @param size
     * @param type
     * @return the generated random sequence
     */
    public String generate(Type type,int size){
        String generated = "";
        switch(type){
            case DIGITS_ONLY:
                for (int i = 0; i < size; i++) {
                    int d = g_d();
                    generated+=d;
                }
                break;
            case LETTERS_LOWERCASE:
                for (int i = 0; i < size; i++) {
                    char d = g_l_lc();
                    generated+=d;
                }
                break;
            case LETTERS_UPPERCASE:
                for (int i = 0; i < size; i++) {
                    char d = g_l_uc();
                    generated+=d;
                }
                break;
            case LETTERS_UPPERLOWERCASE:
                for (int i = 0; i < size; i++) {
                    char d = g_l_luc();
                    generated+=d;
                }
                break;
            case DIGITS_LETTERS_LOWERCASE:
                for (int i = 0; i < size; i++) {
                    String d = g_d_l_lc();
                    generated+=d;
                }
                break;
            case DIGITS_LETTERS_UPPERCASE:
                for (int i = 0; i < size; i++) {
                    String d = g_d_l_uc();
                    generated+=d;
                }
                break;
            case DIGITS_LETTERS_UPPERLOWERCASE:
                for (int i = 0; i < size; i++) {
                    String d = g_d_l_luc();
                    generated+=d;
                }
                break;
        }

        return generated;
    }
    /**
     * Gets a random number from 0 - 9.
     * @return the random int
     */
    private int g_d(){
        int [] number_0_9 = {0,1,2,3,4,5,6,7,8,9};
        int rnd = new Random().nextInt(number_0_9.length);
        return number_0_9[rnd];
    }
    /**
     * Gets a random lowercase char from a - z.
     * @return the random char
     */
    private char g_l_lc(){
        char[] alphabet_lowercase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int rnd = new Random().nextInt(alphabet_lowercase.length);
        return alphabet_lowercase[rnd];
    }
    /**
     * Gets a random uppercase char from A - Z.
     * @return the random char
     */
    private char g_l_uc(){
        char[] alphabet_uppercase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int rnd = new Random().nextInt(alphabet_uppercase.length);
        return alphabet_uppercase[rnd];
    }
    /**
     * Gets a random uppercase or lowercase char <br> the code will decide to pick a type<br> if the return value will uppercase or lowercase char .
     * @return the random char
     */
    private char g_l_luc(){
        int [] r2 = {1,2};
        int rnd = new Random().nextInt(r2.length);
        int res = r2[rnd];
        if(res == 1){
            return g_l_lc();
        }else{
            return g_l_uc();
        }
    }
    /**
     * Gets a random digit or uppercase char  <br> the code will decide to pick a type<br> if the return value will digit or uppercase char .
     * @return the random char
     */
    private String g_d_l_uc(){
        int [] r2 = {1,2};
        int rnd = new Random().nextInt(r2.length);
        int res = r2[rnd];
        if(res == 1){
            return ""+g_l_uc();
        }else{
            return ""+g_d();
        }
    }
    /**
     * Gets a random digit or lowercase char  <br> the code will decide to pick a type<br> if the return value will digit or lowercase char .
     * @return the random char
     */
    private String g_d_l_lc(){
        int [] r2 = {1,2};
        int rnd = new Random().nextInt(r2.length);
        int res = r2[rnd];
        if(res == 1){
            return ""+g_l_lc();
        }else{
            return ""+g_d();
        }
    }
    /**
     * Gets a random digit or  uppercase or lowercase  char <br> the code will decide to pick a type<br> if the return value will digit or uppercase or lowercase char .
     * @return the random char
     */
    private String g_d_l_luc(){
        int [] r2 = {1,2,3};
        int rnd = new Random().nextInt(r2.length);
        int res = r2[rnd];
        switch (res) {
            case 1:
                return ""+g_l_lc();
            case 2:
                return ""+g_l_uc();
            case 3:
                return ""+g_d();
            default:
                assert false;
                return "";
        }
    }
    /**
     * Invalid Format Exception
     */
    public class InvalidFormatException extends RuntimeException {
        
        public InvalidFormatException() {
            super();
        }
        /**
         * Invalid Format Exception
         * @param message the message
         */
        public InvalidFormatException(String message){
            super(message);
        }
    }
}