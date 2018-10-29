package eg.edu.alexu.csd.datastructure.hangman.cs18;

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;*/
import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author arabtech
 *
 */
public class Hangman implements IHangman {
	/**
	 * . exception
	 *
	 */
	/**
	 * . field for global variables
	 *
	 */
	/**
	 * . size for my words array
	 *
	 */
	int size;
	/**
	 * . an array to store the words in the dictionary
	 *
	 */
	String[] myWords = new String[size];
	/**
	 * . the word we're searching for
	 *
	 */
	String secretWord;
	/**
	 * . loop counters
	 *
	 */
	int i = 0, counter = 0;
	/**
	 * . the hidden word
	 *
	 */
	char[] mydashed;
	/**
	 * . maximum number of wrong guesses
	 *
	 */
	int numOfGuesses;
	/**
	 * . a flag to handle an unspported operation exception
	 *
	 */
	int f;

	/*
	 * public void readDictionary() { BufferedReader br = null;
	 *  try { br = new
	 * BufferedReader(new FileReader("dictionary.txt"));
	 *  while ((myWords[i] =
	 * br.readLine()) != null) { i++; } }
	 *  catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	@Override
	public void setDictionary(final String[] words) {
		// TODO Auto-generated method stub
		myWords = words;
		for (String s : myWords) {
			if (s != null) {
				counter++;
			} else {
				break;
			}
		}
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (counter == 0) {
			return null;
		} else {
			secretWord = myWords[new Random().nextInt(counter)];
			mydashed = secretWord.toCharArray();
			for (i = 0; i < mydashed.length; i++) {
				mydashed[i] = '-';
			}
			return secretWord;
		}
	}

	@Override
	public String guess(final Character c) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		if (c == null) {
			String retword = String.valueOf(mydashed);
			return retword;
		}
		if (f == 0) {
			throw new UnsupportedOperationException();
		}
		if (secretWord.length() == 0) {
			throw new UnsupportedOperationException();
		}
		char[] dashed = secretWord.toCharArray();
		if (dashed[0] == ' ') {
			throw new UnsupportedOperationException();
		}
		for (i = 0; i < dashed.length; i++) {
			if (Character.toLowerCase(c)
				== Character.toLowerCase(dashed[i])) {
				flag = 1;
				if (Character.toLowerCase(dashed[i])
					== dashed[i]) {
					mydashed[i]
					= Character.toLowerCase(dashed[i]);
				} else {
					mydashed[i]
					= Character.toUpperCase(dashed[i]);
				}
			}
		}
		if (numOfGuesses == 0) {
			return null;
		} else if (flag == 0) {
			numOfGuesses--;
			if (numOfGuesses == 0) {
				return null;
			} else {
				String retword = String.valueOf(mydashed);
				return retword;
			}
		} else {
			String retword = String.valueOf(mydashed);
			return retword;
		}
	}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		// TODO Auto-generated method stub
		f = 1;
		if (max == null) {
			numOfGuesses = 1;
		} else {
			numOfGuesses = max;
		}
	}
}