package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
     Cypher decrypter = new Cypher();

     Scanner cypherInput = new Scanner(System.in);

     System.out.println("Enter Cypher Text: ");
     String cypherText = cypherInput.nextLine();
     String condensedText = cypherText.replaceAll(" ", "");
     System.out.println(condensedText);

     decrypter.decryptText(cypherText);
    }

    static class Cypher{

        int a = 0;  int b = 1;  int c = 2;
        int d = 3;  int e = 4;  int f = 5;
        int g = 6;  int h = 7;  int i = 8;
        int j = 9;  int k = 10; int l = 11;
        int m = 12; int n = 13; int o = 14;
        int p = 15; int q = 16; int r = 17;
        int s = 18; int t = 19; int u = 20;
        int v = 21; int w = 22; int x = 23;
        int y = 24; int z = 25;

        public Cypher(){}

        //takes each character in cypher text into an array, converts it into a
        //numerical value, plugs said value i
        public void decryptText(String cypherText){
            char[] cypherArray = cypherText.toCharArray();

            for(int i = 0; i< cypherArray.length; i++){

//                System.out.print(cypherArray[i]);
            }

        }
    }

}
