

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFinder{
	File file;
	ArrayList<String> words;

	public static void main(String[] args) {
		WordFinder w = new WordFinder( "sowpods.txt");
		List<String> searchWords = w.search(new String[] { "on", "e","e" });
		System.out.println(searchWords);
	}

	WordFinder(String filename) {
		this.file = new File(getClass().getResource(filename).getPath());
		this.words = this.makeList();
	}

	public List<String> search(String... elements) {

		ArrayList<String> possibleWords = new ArrayList<String>();
		for (String s : this.words) {
			if (s.indexOf(elements[0]) != -1) {
				possibleWords.add(s);
			}
		}
		ArrayList<String> copy = new ArrayList<String>();
		copy.addAll(possibleWords);

		if (elements.length < 2)
			return possibleWords;

		for (String e : elements) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).equals("") == false) {
					String currentWord = copy.get(i);
					if (currentWord.indexOf(e) != -1) {
						currentWord = currentWord.substring(0, currentWord.indexOf(e))
								+ currentWord.substring(currentWord.indexOf(e) + e.length(), currentWord.length());
						copy.set(i, currentWord);
					} else
						copy.set(i, "");
				}

			}
		}
		ArrayList<String> newWords = new ArrayList<String>();
		for ( int i = 0; i <possibleWords.size(); i++) {
				if (!copy.get(i).isEmpty()) {
					newWords.add(possibleWords.get(i));
				}
		}

		return newWords;
	}

	public ArrayList<String> makeList() {
		ArrayList<String> words = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(this.file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
			fr.close(); // closes the stream and release the resources
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
}