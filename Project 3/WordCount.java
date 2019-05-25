public class WordCount implements Comparable<WordCount> {
    private String word;
    private int count;

    public WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }
    public WordCount(String word){
        this.word = word;
        this.count = 0;
    }
    public String getWord(){
        return word;
    }
    public int getCount(){
        return count;
    }
    public int addCount(){
        return count++;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(word+'(');
        builder.append(count);
        builder.append(')');
        return builder.toString();
    }
    public int compareTo(WordCount other){
        return this.count - other.count;
    }

}
