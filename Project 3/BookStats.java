import java.util.List;

public class BookStats {


    public static WordCountTree readBook(String fileName, WordCountTree ignoreWords) {
        WordIterator words = new WordIterator(fileName);
        WordCountTree wordTree =  new WordCountTree();
        while (words.hasNext()) {
            String word = words.next();
            if (!ignoreWords.contains(word))
            {
                wordTree.count(word);
            }
        }
        System.out.println(System.currentTimeMillis());
        return wordTree;

    }
    public static void render(WordCountTree wc, int max_words){

        List<WordCount> words = wc.wordsInOrder();
        WordlGenerator wordCloud = new WordlGenerator(500, 500);
        for (int i = 0; i < max_words; i++){
            wordCloud.addWord(words.get(i));
        }
        wordCloud.save("test.png");

    }

    public static void summarize(WordCountTree wc){
        System.out.println("Total Word Count: " +wc.getTotalWordCount());
        System.out.println("Total Unique Word Count: " +wc.getUniqueWordCount());
        List<WordCount> list = wc.wordsInOrder();
        for(int i = 0; i < 25; i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String args[]){
        WordIterator words = new WordIterator("/Users/kimneychoong/Downloads/StopWords.txt");
        WordCountTree ignoreWords = new WordCountTree();

        while (words.hasNext()) {
            String word = words.next();
            WordCount ignore = new WordCount(word,word.hashCode());
            WordCount hi = new WordCount(word);
            ignoreWords.put(ignore);
        }

        WordCountTree wordCountTree = readBook("/Users/kimneychoong/Downloads/59367-0.txt", ignoreWords);
        summarize(wordCountTree);
        render(wordCountTree,77);

    }
}
