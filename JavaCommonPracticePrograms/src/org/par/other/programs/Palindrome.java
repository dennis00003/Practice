package org.par.other.programs;

/**
 * @author Harinder Singh Bedi
 * 
 * Java palindrome program: 
 * Java program to check if a string is a palindrome or not. 
 * Remember a string is a palindrome if it remains unchanged when reversed,
 * for example "dad" is a palindrome as reverse of "dad" is "dad"
 * whereas "program" is not a palindrome. Some other palindrome strings 
 * are "mom", "madam", "abcba". 
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String word="nitin";

		System.out.println(istPalindrom(word.toCharArray()));
		System.out.println(isPalindrome(word));
	}

	public static boolean istPalindrom(char[] word){
		int i1 = 0;
		int i2 = word.length - 1;
		while (i2 > i1) {
			if (word[i1] != word[i2]) {
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}
	
	public static boolean isPalindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}
}
