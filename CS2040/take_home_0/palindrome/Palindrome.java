/*
 * author		: Larry Law
 * matric no.	: 
 */

import java.util.*;

public class Palindrome {
    // reverse first word using stack
    // 
	public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String i = sc.next();
        String j = sc.next();
        String result = j.equals(Palindrome.reverseString(i)) ? "YES" : "NO";
        System.out.println(result);
	}
}
