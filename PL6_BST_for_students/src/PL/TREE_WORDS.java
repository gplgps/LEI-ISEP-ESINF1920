
package PL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author DEI-ESINF
 */
public class TREE_WORDS extends BST<TextWord> {
    
    public void createTree() throws FileNotFoundException{
        Scanner readfile = new Scanner(new File("src/PL/xxx.xxx"));
        while(readfile.hasNextLine()){
            String[] pal = readfile.nextLine().split("(,)|(\\s)|(\\.)");
            for(String word : pal)
                if (word.length() > 0 )
                    insert(new TextWord(word, 1));
        }
        readfile.close();
    }

    /**
     * Inserts a new word in the tree, or increments the number of its occurrences.
       * @param element
     */
    @Override
    public void insert(TextWord element){
        if (element == null) return;
        if (this.isEmpty()) {
            root = new Node<>(element, null, null);
            return;
        }
        insert(element, root);
    }

    private Node<TextWord> insert(TextWord element, Node<TextWord> node){
        if (element.compareTo(node.getElement()) == 0){
            node.getElement().setWord(element.getWord(),node.getElement().getOcorrences() + 1);
            return node;
        }
        if (element.compareTo(node.getElement()) < 0){
            if (node.getLeft() == null){
                Node<TextWord> newNode = new Node<>(element, null, null);
                node.setLeft(newNode);
                return newNode;
            }

            return insert(element, node.getLeft());
        }
        if (element.compareTo(node.getElement()) > 0){
            if (node.getRight() == null){
                Node<TextWord> newNode = new Node<>(element, null, null);
                node.setRight(newNode);
                return newNode;
            }

            return insert(element, node.getRight());
        }
        return null;
    }

    /**
     * Returns a map with a list of words for each occurrence found.
     * @return a map with a list of words for each occurrence found.
     */
    public Map<Integer,List<String>> getWordsOccurrences(){
        Iterable<TextWord> textWordList = this.inOrder();
        Map<Integer, List<String>> occurrencesMap = new TreeMap<>();
        textWordList.forEach(textWord -> {
            if (!occurrencesMap.containsKey(textWord.getOcorrences())) occurrencesMap.put(textWord.getOcorrences(), new ArrayList<>());
            List<String> thisWordList = occurrencesMap.get(textWord.getOcorrences());
            thisWordList.add(textWord.getWord());
        });
        return occurrencesMap;
    }

}
