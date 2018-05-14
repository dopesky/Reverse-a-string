/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Kevin
 */
public class Main {

        String original, reversed;

        public Main(String original) {
                this.original = original;
        }

        public String reverseString() {
                reversed = "";
                for (int a = 0; a < original.length(); a++) {
                        char temps = original.charAt(a);
                        reversed = String.join("", String.valueOf(temps), reversed);
                }
                return reversed;
        }
}
