import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class WordCountTree {
    private class WordBSTNode {
        private WordCount instanceA;
        private WordBSTNode left;
        private WordBSTNode right;

        private WordBSTNode(WordCount instanceA) {
            this.instanceA = instanceA;
            this.left = null;
            this.right = null;
        }
    }

    private WordBSTNode root;
    private int totalCount = 0;
    private int pointer = 0;
    private List<WordCount> listA = new ArrayList();

    public WordCountTree() {

        root = null;
    }

    private WordBSTNode search(String word, WordBSTNode root) {
        WordBSTNode focusNode = root;
        if(focusNode == null){
            return null;
        }

        else if(word.equals(focusNode.instanceA.getWord())) {
            return focusNode;
        }
        else {
            WordBSTNode left = search(word, focusNode.left);
            if (left != null) {
                return left;
            }
            return search(word,focusNode.right);
        }
    }

    public void put(WordCount instanceA) {
        if (root == null) {
            root = new WordBSTNode(instanceA);
        } else {
            WordBSTNode other = root;
            while (true) {
                if (instanceA.compareTo(other.instanceA) > 0) {
                    if (other.right != null) {
                        other = other.right;
                    } else {
                        other.right = new WordBSTNode(instanceA);
                        return;
                    }
                } else if (instanceA.compareTo(other.instanceA) <= 0) {
                    if (other.left != null) {
                        other = other.left;
                    } else {
                        other.left = new WordBSTNode(instanceA);
                        return;
                    }
                }
            }
        }

    }

    public void count(String word) {
        WordBSTNode focusWord = search(word, root);
        if (focusWord == null) {
            WordCount newWord = new WordCount(word, 1);
            put(newWord);
            pointer += 1;
        } else {
            focusWord.instanceA.addCount();
        }
        totalCount += 1;
    }


    public int getUniqueWordCount() {
        return pointer;
    }

    public int getTotalWordCount() {
        return totalCount;
    }

    public boolean contains(String word) {
        if (search(word, root) == null) {
            return false;
        } else {
            return true;
        }
    }

    public int getCount(String word) {
        if (search(word, root) != null) {
            return search(word, root).instanceA.getCount();
        } else {
            return 0;
        }
    }

    public List<WordCount> wordsInOrder() {
        listA.clear();
        preOrderTraverse(root);
        sort(listA);
        Collections.reverse(listA);
        return listA;
    }
    void sort(List<WordCount> sortedList){
        int n = sortedList.size();
        for(int i =1; i<n; ++i){
            WordCount sortedCount = sortedList.get(i);
            int j = i - 1;

            while(j >= 0 && sortedList.get(j).getCount() > sortedCount.getCount()){
                sortedList.set(j+1, sortedList.get(j));
                j = j-1;
            }
            sortedList.set(j+1, sortedCount);
        }

    }

    private void preOrderTraverse(WordBSTNode node) {
        if (node != null) {
            listA.add(0, node.instanceA);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }
}
