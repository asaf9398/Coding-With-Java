
/**
 * The Class is representing a node(one word) in a list of words .
 * @author Asaf Yosef
 * @version 10/06/2021
 */
public class WordNode
{
    private String _word;
    private WordNode _next;

    /**
     * Initializes a new node of String .
     * The function creates a new list with %val% value - This is a constructor .
     * @param val Is the string value for creating a new list .
     */
    public WordNode(String val)
    {
        _word=val;//creating new node with value
        _next=null;
    }
    /**
     * Initializes a new node of String .
     * The function creates a new list with %val% value - This is a constructor .
     * @param val Is the string value for creating a new list .
     * @param nextNode Is another node to create a list with at least 2 node from the beginning .
     */
    public WordNode(String val,WordNode nextNode)
    {
        _word=val;//creating new node with value
        _next=nextNode;//creating new node with value
    }

    /**
     * The function returns the value of the next node .
     * @return Next node/null .
     */
    public WordNode GetNext()
    {
        return _next;//returning the value of the next node
    }

    /**
     * The function returns the value of word that in the node .
     * @return The value of the node - the String .
     */
    public String GetWord()
    {
        return _word;//returning the value of word
    }

    /**
     * The function sets a new node after the specific node that the function is being activate .
     * @param node Will be the next node .
     */
    public void SetNext(WordNode node)
    {
        _next=node;//setting new node with value
    }

    /**
     * The function sets a new value of String to the word in the specific node .
     * @param newWord Is the new word value .
     */
    public void SetWord(String newWord)
    {
        _word=newWord;//setting new node word
    }

}
