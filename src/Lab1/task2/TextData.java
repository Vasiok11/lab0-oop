package Lab1.task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text, int numberOfVowels, int numberOfConsonants, int numberOfLetters, int numberOfSentences, String longestWord) {
        this.fileName = fileName;
        this.text = text;
        this.numberOfVowels = numberOfVowels;
        this.numberOfConsonants = numberOfConsonants;
        this.numberOfLetters = numberOfLetters;
        this.numberOfSentences = numberOfSentences;
        this.longestWord = longestWord;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumberOfVowels(int numberOfVowels) {
        this.numberOfVowels = numberOfVowels;
    }

    public void setNumberOfConsonants(int numberOfConsonants) {
        this.numberOfConsonants = numberOfConsonants;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public void setNumberOfSentences(int numberOfSentences) {
        this.numberOfSentences = numberOfSentences;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }
}
