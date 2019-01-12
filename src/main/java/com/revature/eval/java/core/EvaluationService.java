package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		// Split the input string on whitespace and hyphens
		String[] splitArr = phrase.split(" |\\-");
		String acronymStr = "";
		String upperCase = "";

		for (int i = 0; i < splitArr.length; i++) {
			char temp = splitArr[i].charAt(0);

			acronymStr = acronymStr.concat(Character.toString(temp));

		}

		// get first letter of each element of the split array and add to a acronym
		// string
		// change acronym to all caps
		// return acronym
		upperCase = acronymStr.toUpperCase();
		return upperCase;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration

			if (sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
				return true;
			} else {
				return false;
			}

		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				return false;
			} else {
				return true;
			}

		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		int pointVal = 0;
		int total = 0;

		// Change string to uppercase
		String uppercase = string.toUpperCase();

		// Loop through the string
		for (int i = 0; i <= uppercase.length() - 1; i++) {
			// System.out.println(uppercase.charAt(i));
			switch (uppercase.charAt(i)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				pointVal = 1;
				break;

			case 'D':
			case 'G':
				pointVal = 2;
				break;

			case 'B':
			case 'C':
			case 'M':
			case 'P':
				pointVal = 3;
				break;

			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				pointVal = 4;
				break;

			case 'K':
				pointVal = 5;
				break;

			case 'J':
			case 'X':
				pointVal = 8;
				break;

			case 'Q':
			case 'Z':
				pointVal = 10;
				break;

			default:
				pointVal = 0;
				break;
			}

			total += pointVal;

		}

		return total;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		// Remove all non digits
		// Check for first digit being a 1
		// check that 10 digit phone number
		// check that first and fourth digit are greater then 1
		String numberStr = "";
		String tempNumb = "";

		System.out.println("base String " + string);
		// Iterate through the string
		for (int i = 0; i < string.length(); i++) {
			// set the value of the string at index to temp
			char temp = string.charAt(i);
			// check if tempvariable is a digit
			if (Character.isDigit(temp)) {

				// if it is a digit add to the numberStr
				numberStr += temp;
				System.out.println(numberStr);

			}

		}
		// check for first digit to be a 1
		if (numberStr.charAt(0) == '1') {
			// if it is a 1, then create substring of everything except the first digit
			tempNumb = numberStr.substring(1);
			numberStr = tempNumb;

		}

		// check if number is greater or smaller then 10 digits
		int numberLength = numberStr.length();
		System.out.println(numberLength);
		if (numberLength > 10 || numberLength < 10) {
			throw new IllegalArgumentException("Invalid Phone Number!");
		} else {
			// check if area code starts with correct digit and if number starts with
			// correct digit
			if (numberStr.charAt(0) > '1' && numberStr.charAt(3) > '1') {

			} else {
				throw new IllegalArgumentException("Invalid Phone Number");
			}
		}

		return numberStr;

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		string = string.replace("\n", "");

		// Create a map to store values
		Map<String, Integer> mapBank = new HashMap<>();

		// split the string at all repitetions of whitespaces or any character othere
		// then letter
		String[] splitArr = string.split("[^a-zA-Z0-9']");
		// Iterate through the splitArr
		for (int i = 0; i < splitArr.length; i++) {
			// if the word is not in the map add it
			if (mapBank.get(splitArr[i]) == null) {
				// add the value to the map
				mapBank.put(splitArr[i], 1);

			} else {
				// if already in map increase the value by 1
				mapBank.put(splitArr[i], mapBank.get(splitArr[i]) + 1);
			}
		}
		return mapBank;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int matchIndex = 0;

			int leftEnd = 0;
			int rightEnd = sortedList.size() - 1;

			while (leftEnd <= rightEnd) {

				int middleIndex = (int) Math.floor((leftEnd + rightEnd) / 2);

				// check if value of middle index is less then key value
				if (sortedList.get(middleIndex).compareTo(t) == -1) {
					// make left end middle plus 1
					leftEnd = middleIndex + 1;
					matchIndex = middleIndex;
				} else if (sortedList.get(middleIndex).compareTo(t) == 1) {
					// checking if value of middle index is greater then keyvalue
					// make the rightend equal to middle index - 1
					rightEnd = middleIndex - 1;
					matchIndex = middleIndex;
				} else if (sortedList.get(middleIndex).compareTo(t) == 0) {
					// check if the value of the middle index is equal to the keyvalue
					matchIndex = middleIndex;
					return matchIndex;
				}

			}
			matchIndex = -1;
			return matchIndex;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		System.out.println(string);
		String output = "";
		String[] splitArr = string.split(" ");
		String temp = "";
		String ending = "ay";

		// Do something to each item in splitArr
		for (int i = 0; i < splitArr.length; i++) {
			char firstVal = splitArr[i].charAt(0);
			String firstTwoVal = splitArr[i].substring(0, 2);
			String firstThreeVal = splitArr[i].substring(0, 3);

			// Turn each word in array to piglatin

			// if first letter is a vowel
			if (firstVal == 'a' || firstVal == 'e' || firstVal == 'i' || firstVal == 'o' || firstVal == 'u') {
				// move first letter to the end and add ay

				splitArr[i] = splitArr[i].concat(ending);

				// temp = String.join(" ", splitArr);

			} else if (firstTwoVal.equals("th")) {
				splitArr[i] = splitArr[i].substring(2).concat(firstTwoVal).concat(ending);

				// temp = String.join(" ", splitArr);
			} else if (firstThreeVal.equals("sch")) {
				splitArr[i] = splitArr[i].substring(3).concat(firstThreeVal).concat(ending);

				// temp = String.join(" ", splitArr);
			} else if (firstTwoVal.equals("qu")) {
				splitArr[i] = splitArr[i].substring(2).concat(firstTwoVal).concat(ending);

				// temp = String.join(" ", splitArr);

			} else {
				// start with consonant
				splitArr[i] = splitArr[i].substring(1).concat(Character.toString(firstVal).concat(ending));

			}

		}

		temp = String.join(" ", splitArr);
		// join back to output string
		output += temp;
		System.out.println(output);

		return output;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		boolean armStrong = false;

		
		int length = String.valueOf(input).length();
		

		int sum = 0;
		int current = 1;
		int remainder = 0;
		int temp = input;

		for (int i = 0; i < length; i++) {
			
			remainder = temp % 10;
			System.out.println("remainder: " + remainder);
			for (int j = 0; j < length; j++) {
				current = current * remainder;
				System.out.println(current);
			}
			System.out.println("update sum");
			sum += current;
			System.out.println("sum " + sum);
			current = 1;
			temp = temp / 10;
		}

		if (sum == input) {
			armStrong = true;
		} else {
			armStrong = false;
		}

		return armStrong;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		// Create a new arraylist of type long
		List<Long> primes = new ArrayList<Long>();
		long num = l;
		// start at 2 because 1 is not prime
		for (long i = 2l; i <= num; i++) {

			while (num % i == 0) {
				// if no remainder add to primes list
				primes.add(i);
				// divide the number by the prime
				num /= i;

			}

		}

		return primes;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {

			String output = "";

			// Create a key for comparing
			String alpha = "abcdefghijklmnopqrstuvwxyz";

			String leftOverAlpha = alpha.substring(key);

			String keyStr = alpha.substring(0, key);

			String cypherStr = leftOverAlpha.concat(keyStr);

			boolean isCap;

			String input = string;
			for (int i = 0; i < input.length(); i++) {
				// step through each word in array

				// each letter in each word
				// check if non letter
				if (input.charAt(i) == '\'' | Character.isWhitespace(input.charAt(i)) | input.charAt(i) == ','
						| input.charAt(i) == '!' | input.charAt(i) == '.') {

					output = output.concat(Character.toString(input.charAt(i)));

				} else if (Character.isDigit(input.charAt(i))) {
					output = output.concat(Character.toString(input.charAt(i)));

				} else {

					isCap = Character.isUpperCase(input.charAt(i));

					char lowercaseChar = Character.toLowerCase(input.charAt(i));

					int tempIndex = alpha.lastIndexOf(lowercaseChar);

					// get the value at tempIndex in cypher
					char tempChar = cypherStr.charAt(tempIndex);

					// check if was uppercase if so return to uppercase
					if (isCap) {
						tempChar = Character.toUpperCase(tempChar);
					}
					// add new char to output string
					output = output.concat(Character.toString(tempChar));

				}

			}

			return output;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int testNum;
		int primeCount = 0;

		if (i == 0) {
			throw new IllegalArgumentException("Number cannot be zero.");
		}
		for (testNum = 2; primeCount < i; ++testNum) {
			if (isPrime(testNum)) {
				++primeCount;
			}
		}

		return testNum - 1;
	}

	static boolean isPrime(int n) {

		for (int i = 2; i < n; ++i) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration

			String alpha = "abcdefghijklmnopqrstuvwxyz";
			String reverseAlpha = new StringBuffer(alpha).reverse().toString();

			String output = "";
			// make string to lowerCase and remove special characters
			String lowerCase = string.toLowerCase();
			lowerCase = lowerCase.replaceAll("[,\\s+\\.]", "");
			// loop through each character in string
			for (int i = 0; i < lowerCase.length(); i++) {
				// check for numerical value
				if (Character.isDigit(lowerCase.charAt(i))) {
					// if the current character is a number concat it to the outputstring
					output = output.concat(Character.toString(lowerCase.charAt(i)));

				} else {
					// find the index of the current char in the base alphabet
					int temp = alpha.indexOf(lowerCase.charAt(i));
					// concat the encrypted char into the output string using the index on the
					// reversed string
					output = output.concat(Character.toString(reverseAlpha.charAt(temp)));

				}

			}
			// insert a space into the string after 5 letters
			output = output.replaceAll("(.{" + 5 + "})", "$0 ").trim();
			// return the formatted output
			return output;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			// reversed alphastring
			String reverseAlpha = "zyxwvutsrqponmlkjihgfedcba";
			// create a new string by .reverse()
			String alpha = new StringBuffer(reverseAlpha).reverse().toString();
			// string to store output
			String output = "";
			// turn string to lowerCase
			String lowerCase = string.toLowerCase();
			// check for special characters and remove
			lowerCase = lowerCase.replaceAll("[,\\s+\\.]", "");

			// loop through each character in the string
			for (int i = 0; i < lowerCase.length(); i++) {
				// check to see if the current char is a digit

				if (Character.isDigit(lowerCase.charAt(i))) {
					// if the current char is a digit concat it to output
					output = output.concat(Character.toString(lowerCase.charAt(i)));
				} else {
					// find index of the current char in reversed string
					int tempIndex = reverseAlpha.indexOf(lowerCase.charAt(i));
					// concat the value of the index in the alpha string to output
					output = output.concat(Character.toString(alpha.charAt(tempIndex)));

				}
			}

			return output;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		boolean isValid = true;
		boolean validISBN = false;
		int tempSum = 0;

		// remove hyphens from string
		String cleanStr = string.replaceAll("-", "");

		// check that first 9 digits are digits 0-9
		for (int i = 0; i < cleanStr.length() - 1; i++) {

			if (!Character.isDigit(cleanStr.charAt(i))) {

				isValid = false;
			}
		}

		// Check if the 10th digit is 'X' or digit
		if (isValid) {

			if (cleanStr.charAt(9) == 'X' || Character.isDigit(cleanStr.charAt(9))) {

				int countDown = 10;
				for (int i = 0; i < cleanStr.length(); i++) {

					// test for last value of 'X'
					if (i == 9 && cleanStr.charAt(9) == 'X') {
						tempSum += 10;
						countDown--;
					} else {

						int temp = Character.getNumericValue(cleanStr.charAt(i));
						tempSum += temp * countDown;

						countDown--;

					}

				}

				// test for valid ISBN
				if (tempSum % 11 == 0) {
					validISBN = true;
				} else {
					validISBN = false;
				}

			} else {
				// Last digit isn't valid
				validISBN = false;
			}

		}
		return validISBN;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
//		

		// create a key for comparing
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String lowerCase = string.toLowerCase();
		List<Integer> keyList = new ArrayList<Integer>();
		List<Integer> inputList = new ArrayList<Integer>();
		boolean pangram = false;

		// check is input is empty
		if (string.isEmpty()) {
			pangram = false;
		} else {
			// loop through string
			// get ascii for each char and store in int array
			for (int i = 0; i < alpha.length(); i++) {
				// System.out.println(alpha.charAt(i));
				keyList.add((int) alpha.charAt(i));

			}

			// Create a ascii list for the input
			for (int i = 0; i < lowerCase.length(); i++) {
				inputList.add((int) lowerCase.charAt(i));

			}

			// check if inputList has every element of keyList

			// for each element in keylist check and see if it is in inputList
			if (inputList.containsAll(keyList)) {
				pangram = true;
			} else {
				pangram = false;
			}

		}

		return pangram;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// pair programming
		LocalDateTime newTime = LocalDateTime.of(1, Month.JANUARY, 1, 0, 0, 0);
		newTime = newTime.withMonth(given.get(ChronoField.MONTH_OF_YEAR));
		newTime = newTime.withDayOfMonth(given.get(ChronoField.DAY_OF_MONTH));
		newTime = newTime.withYear(given.get(ChronoField.YEAR));
		// TODO Write an implementation for this method declaration
		try {
			newTime = newTime.withHour(given.get(ChronoField.HOUR_OF_DAY));
			newTime = newTime.withMinute(given.get(ChronoField.MINUTE_OF_HOUR));
			newTime = newTime.withSecond(given.get(ChronoField.SECOND_OF_MINUTE));
		} catch (Exception x) {

		}

		newTime = newTime.plusSeconds(1_000_000_000);
		return newTime;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration

		int count = 1;
		ArrayList<Integer> multiplesList = new ArrayList<>();
		for (int x : set) {

			// output all multiples for each item in set untill product is > i
			Integer product = 0;
			count = 1;
			while (product < i) {
				product = x * count;

				if (!multiplesList.contains(product)) {
					multiplesList.add(product);

				}
				count++;

				if (product + x >= i) {

					break;
				}
			}
		}
		// add all values in multiplesList to get sum
		int sumOfMultiples = 0;
		for (Integer x : multiplesList) {
			System.out.println(x);
			sumOfMultiples += x;

		}

		return sumOfMultiples;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		boolean isValid = false;
		int sum = 0;

		String cleanStr = string.replaceAll(" ", "");

		// check for length 1 or less
		if (cleanStr.length() <= 1) {
			// set to invalid
			isValid = false;
		} else {
			// loop through string and make sure every character is a digit if not its
			// invalid
			for (int i = 0; i < cleanStr.length(); i++) {
				if (!Character.isDigit(cleanStr.charAt(i))) {

					isValid = false;
				}
			}
		}

		// number is ok to check
		// create and arrayList of Integers to perform calculations
		ArrayList<Integer> doubleList = new ArrayList<>();
		// loop through cleaned string and populate list
		for (int i = 0; i < cleanStr.length(); i++) {

			doubleList.add(Character.getNumericValue(cleanStr.charAt(i)));

		}

		for (int i = doubleList.size() - 2; i > 0; i -= 2) {
			// calc doubledval to check
			int doubledVal = doubleList.get(i) * 2;

			if (doubledVal > 9) {
				// if doubled value is larger then 9 substract then set
				doubledVal -= 9;

				doubleList.set(i, doubledVal);

			} else {
				// if doubled vaule is not larger then 9 just set
				doubleList.set(i, doubledVal);
			}
		}

		// add all numbers in the doubled list

		for (Integer x : doubleList) {
			sum += x;
		}

		// check if valid
		if (sum % 10 == 0) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {

		String cleanStr = string.replace("?", "");

		String[] splitArr = cleanStr.split(" ");
		int solution;
		ArrayList<String> expressionStrList = new ArrayList<>();
		for (int i = 0; i < splitArr.length; i++) {

			// find key strings

			// find any string the has a number

			if (splitArr[i].matches(".*\\d+.*")) {

				// store each string in a new string array
				expressionStrList.add(splitArr[i]);

			}
		}
		// find any string the is plus, minus, multipled, divided

		int a = Integer.parseInt(expressionStrList.get(0));
		int b = Integer.parseInt(expressionStrList.get(1));
		solution = (cleanStr.contains("plus")) ? (a + b)
				: (cleanStr.contains("minus")) ? (a - b)
						: (cleanStr.contains("multiplied")) ? (a * b) : (cleanStr.contains("divided")) ? (a / b) : 0;

		return solution;
	}

}
