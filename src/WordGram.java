
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Cynthia France
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = "";
		myHash = 0;

		int s = start;
		for (int i = 0; i < size; i++) {
			myWords[i] = source[s];
			s++;
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns the number of words in the WordGram (aka its order)
	 * @return order of the WordGram
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Returns true if parameter is a WordGram with the same order of strings as this
	 * @param o Object (WordGram) to compare to this.
	 * @return true if two WordGram objects contain same strings in same order
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

		WordGram compare = (WordGram) o;
		return (this.toString().equals(compare.toString()));
	}

	/**
	 * Returns hashCode of the WordGram, determined by the hashCode of its .toString()
	 * @return hashCode of this.toString()
	 */
	@Override
	public int hashCode(){
		if (myHash == 0) {
			String s = this.toString();
			myHash = s.hashCode();
		}
		return myHash;
	}
	

	/**
	 * returns new WordGram object whose first k-1 strings are the same as this's
	 * last k-1 strings, where k is the order of the WordGram. The last string of the new
	 * WordGram is a new String
	 * @param last is last String of returned WordGram
	 * @return new WordGram object whose values are shifted "up" a step and new word added on the end.
	 */
	public WordGram shiftAdd(String last) {
		String[] newWords = new String[myWords.length];
		for (int i = 0; i < newWords.length - 1; i++) {
			newWords[i] = myWords[i+1];
		}
		newWords[myWords.length - 1] = last;
		WordGram wg = new WordGram(newWords, 0, myWords.length);

		return wg;
	}

	/**
	 * Returns one string of all the strings in the WordGram, separated by a space
	 * @return
	 */
	@Override
	public String toString(){
		if (myToString.equals("")) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
