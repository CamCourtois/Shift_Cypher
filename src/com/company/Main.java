package com.company;
import java.util.*;
import java.util.HashMap;


public class Main {
//accepts a paragraph input w/ strictly letters
//successful in almost all cases where input is at minimum one paragraph

    public static void main(String[] args)
    {
     Cypher decrypter = new Cypher();

     Scanner cypherInput = new Scanner(System.in);
        while(true) {
            System.out.print("Enter Cypher Text: ");
            String cypherText = cypherInput.nextLine();
            String condensedText = cypherText.replaceAll(" ", "").toLowerCase();
            System.out.println(condensedText);

            decrypter.frequencyAnalysis(condensedText);
        }
    }

    static class Cypher{


        //frequencies of english letters
        double E = 0.112; double A = 0.085;  double R = 0.075;

        public Cypher(){}


        public void frequencyAnalysis(String cypherText){
            //assigns a numerical value to each letter from 0-25
            TreeMap<String, Double> letterSequence = new TreeMap<>();
            letterSequence.put("a", 0.0);   letterSequence.put("b", 1.0);   letterSequence.put("c", 2.0);
            letterSequence.put("d", 3.0);   letterSequence.put("e", 4.0);   letterSequence.put("f", 5.0);
            letterSequence.put("g", 6.0);   letterSequence.put("h", 7.0);   letterSequence.put("i", 8.0);
            letterSequence.put("j", 9.0);   letterSequence.put("k", 10.0);  letterSequence.put("l", 11.0);
            letterSequence.put("m", 12.0);  letterSequence.put("n", 13.0);  letterSequence.put("o", 14.0);
            letterSequence.put("p", 15.0);  letterSequence.put("q", 16.0);  letterSequence.put("r", 17.0);
            letterSequence.put("s", 18.0);  letterSequence.put("t", 19.0);  letterSequence.put("u", 20.0);
            letterSequence.put("v", 21.0);  letterSequence.put("w", 22.0);  letterSequence.put("x", 23.0);
            letterSequence.put("y", 24.0);  letterSequence.put("z", 25.0);

            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            TreeMap<String, Double> letterFrequencies = new TreeMap<>();
            Double increment = 1.0;

            //initializes each letter to a frequency of 0
            for(int i = 0; i <= alphabet.length()-1; i++){
                letterFrequencies.put(String.valueOf(alphabet.charAt(i)), 0.0);
//                System.out.println(letterFrequencies.get(String.valueOf(alphabet.charAt(i))));
            }

            //takes cypherText and updates letter frequencies
            for(int i = 0; i <= cypherText.length()-1; i++){
                letterFrequencies.put(String.valueOf(cypherText.charAt(i)), letterFrequencies.get((String.valueOf(cypherText.charAt(i)))) + increment);

            }
            System.out.println("-------------------------------------");

            System.out.println("Cypher text length: "+cypherText.length());
//            for(String i : letterFrequencies.keySet()){
//                System.out.println("key: "+ i + " value: "+ letterFrequencies.get(i));
//            }

            for(String i : letterFrequencies.keySet()){
//                System.out.println("cypher length: "+cypherText.length());
//                System.out.println("current letter: "+letterFrequencies.get(i));
                double frequency = letterFrequencies.get(i)/cypherText.length();
//                System.out.println("key: "+ i + " has a frequency of "+frequency);
                if(frequency <= E + 0.06 && frequency > A + 0.03){
//                    System.out.println("A");
                    cypherDecoder(letterSequence,cypherText,i);
                }
                else if(frequency <= A + .005 && frequency > R + .005){
//                    System.out.println("B");
                    cypherDecoder(letterSequence,cypherText,i);
                }
            }
        }

        public void cypherDecoder(TreeMap<String, Double> letterSequence, String cypherText, String i){
            double originalLetter = letterSequence.get("e");
//                    System.out.println(originalLetter);
            double shiftedLetter = letterSequence.get(i);
//                    System.out.println(i);
            double key = Math.abs(shiftedLetter - originalLetter);

            for(int j=0; j <= cypherText.length()-1; j++){
                double cypherLetter = letterSequence.get((String.valueOf(cypherText.charAt(j))));
                double decodedLetter = ((26 - key) + cypherLetter)%26;
//                        System.out.println(decodedLetter);
                Set<String> keys = letterSequence.keySet();
                Double letterValue = decodedLetter;

                for(String k: keys){
                    if(letterSequence.get(k).equals(letterValue)){
                        System.out.print(k);
                    }
                }
            }
            System.out.println();
        }

    }

}
