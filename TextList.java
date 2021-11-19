
/**
 * The Class is represnting a list of words, list of WordNode objects .
 * @author Asaf Yosef
 * @version 10/06/2021
 */
public class TextList
{
    private WordNode head;
    /**
     * Initializes a new list of String .
     * Complexity of memory - O(1)
     * Complexity of running time - O(1)
     */
    public TextList()
    {
        head=null;
    }

    /**
     * Initializes a new list of String .
     * The function's purpose is to make a new list of nodes made of string of words .
     * @param list Is the words we get and decompose to list of nodes .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public TextList(String list)
    {
        if(list=="")
        {
            head=null;
        }
        else
        {
            int whereIsSpace=list.indexOf(' ',0);//cracking the string by using ' ' char
            head=new WordNode(list.substring(0,whereIsSpace));
            list=list.substring(whereIsSpace+1);
            CrackString(list);//cracking the string by using ' ' char
            bubbleSort();//sorting the list by abc
        }
    }

    /**
     * The function's purpose is to take a string and make it to a list .
     * @param list is the string we get from the user to crack to multiple string of words .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private void CrackString(String list)
    {
        WordNode tmp=head;
        int whereIsSpace=list.indexOf(' ',0);
        String word="";
        while(whereIsSpace!=-1)
        {
            //System.out.println(list); debugging
            word=list.substring(0,whereIsSpace);//cracking the string by using ' ' char
            list=list.substring(whereIsSpace+1,list.length());
            //System.out.println(list); debugging
            whereIsSpace=list.indexOf(' ',0);
            //System.out.println(whereIsSpace); debugging
            tmp.SetNext(new WordNode(word));//cracking the String and putting the words as a nodes
            tmp=tmp.GetNext();
        }
        word=list.substring(0);
        tmp.SetNext(new WordNode(word));
    }

    /**
     * The function's purpose is to sort the list by the abc.
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    private void bubbleSort()
    {
        WordNode tmp= head;
        while(tmp.GetNext()!=null)
        {
            if(IsInRightOrder(tmp.GetWord(),tmp.GetNext().GetWord())) // checking if in the right order
            {
                tmp=tmp.GetNext();
            }
            else
            {
                swap(tmp,tmp.GetNext());//if not in tight order - change
                tmp=head;
            }
        }
    }

    /**
     * The function's purpose is to swap between 2 nodes in a list .
     * @param first Is the first node .
     * @param second Is the second node .
     * Complexity of memory - O(1)
     * Complexity of running time - O(1)
     */
    private void swap(WordNode first,WordNode second)
    {
        WordNode tmp=new WordNode(first.GetWord());
        tmp.SetNext(second);//using tmp to save the values
        first.SetWord(second.GetWord());
        second.SetWord(tmp.GetWord());
    }

    /**
     * The function's purpose is indicate about the oder of 2 strings - Is it good or need to be replaced .
     * @param first Is the first word .
     * @param second Is the seconds word .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private boolean IsInRightOrder(String first,String second)
    {
        if(first.length()>second.length())// checking which word is shorted - avoiding null exception in running
        {
            for(int i=0;i<second.length();i++)
            {
                if(first.charAt(i)==second.charAt(i))//if the letters are same - do nothing
                {
                    //continue to promote i
                }
                else
                {
                    if(first.charAt(i)<second.charAt(i)) //if the letters are not the same - check who first
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                }
            }
        }
        else
        {
            for(int i=0;i<first.length();i++)
            {

                if(first.charAt(i)==second.charAt(i))
                {
                    //continue to promote i
                }
                else
                {
                    if(first.charAt(i)<second.charAt(i))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                }

            }
        }
        return true;

    }

    /**
     * The function gets a new word to add to the list and sorting the list again .
     * @param word Is the new word to add to the list .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public void addToData (String word)
    {
        if(word=="")
        {
            //do nothing
        }
        else//if word is not nothing - add it
        {
            Push(word);
            bubbleSort();//sort the list on the end
        }
    }

    /**
     * The function's operator is a new string to add to the list .
     * @param newNode represents a new string that will be added to the end of the list .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    public void Push(String newNode)
    {
        WordNode tmp=new WordNode(newNode);
        if(head==null)
        {
            head=tmp;
        }
        else
        {
            GetLastNode().SetNext(tmp);//add the node to the end
        }
    }

    /**
     * Function's purpose is to add another node to the list .
     * @param newNode Is the new node we want to add .
     * @param list is the list we want to add the node to .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    public void Push(String newNode,WordNode list)
    {
        WordNode tmpHead=list;
        WordNode tmp=new WordNode(newNode);
        tmp.SetNext(null);
        if(tmpHead==null)
        {
            tmpHead=tmp;
        }
        else
        {
            while(tmpHead.GetNext()!=null)
            {
                tmpHead=tmpHead.GetNext();
            }
            tmpHead.SetNext(tmp);
        }
    }

    /**
     * The function's purpose is to return the last node on the list .
     * @return The last node on the list
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private WordNode GetLastNode()
    {

        if(head==null)
        {
            return head;
        }
        WordNode tmp=head;
        while(tmp.GetNext()!=null)//running to the end of the list
        {
            tmp=tmp.GetNext();
        }
        return tmp;
    }
    /**
     * The function's purpose is to return the last node on a specific list .
     * @return The last node on the list .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private WordNode GetLastNode(WordNode list)
    {

        if(list==null)
        {
            return list;
        }
        WordNode tmp=list;
        while(tmp.GetNext()!=null)//running to the end of the list
        {
            tmp=tmp.GetNext();
        }
        return tmp;
    }

    /**
     * The function's purpose is to return the number of nodes on the list .
     * @return Number of nodes .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private int NumOfNodes()
    {
        int counter=0;
        WordNode tmp=head;
        while(tmp.GetNext()!=null)//running to the end of the list
        {
            tmp=tmp.GetNext();
            counter++;//counting how many words in the list
        }
        counter++;
        return counter;
    }

    /**
     * The function counts and returns the number of words in the text.
     * @return The number of words in the text .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    public int howManyWords ()
    {
        return(NumOfNodes());
    }
    /**
     * The function counts and returns the number of words that are different in the text.
     * @return The number of words that are different in the text .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    public int howManyDifferentWords ()
    {
        WordNode tmp = head;
        String word=head.GetWord();
        WordNode wordsList=new WordNode(word);
        wordsList.SetNext(null);
        int counterDifferent = 1;
        tmp=tmp.GetNext();
        while (tmp.GetNext() != null)
        {
            if (isItInList(wordsList,tmp.GetWord()))//if the word already in the wordslist so don't add it
            {
                tmp=tmp.GetNext();
            }
            else //if the word is not in the wordslist so add it
            {
                Push(tmp.GetWord(),wordsList);
                counterDifferent++;
                tmp=tmp.GetNext();
            }
        }

        if(isItInList(wordsList,tmp.GetWord()))
        {
            //do nothing - we are on the end of the list
        }
        else
        {
            counterDifferent++;
        }
        return counterDifferent;
    }
    /**
     * The function returns list of different words in the text.
     * @return A list of different words .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public WordNode differentWords ()
    {
        WordNode tmp = head;
        String word=head.GetWord();
        WordNode wordsList=new WordNode(word);
        wordsList.SetNext(null);
        int counterDifferent = 1;//we've added already one node - count it
        if(tmp.GetNext()!=null)
        {
            tmp=tmp.GetNext();
        }
        while (tmp.GetNext() != null)
        {
            if (isItInList(wordsList,tmp.GetWord()))
            {
                tmp=tmp.GetNext();
            }
            else
            {
                Push(tmp.GetWord(),wordsList);//if the word is not in the wordslist so add it
                counterDifferent++;
                tmp=tmp.GetNext();
            }
        }

        if(isItInList(wordsList,tmp.GetWord()))
        {
            //do nothing - we are on the end of the list
        }
        else
        {
            Push(tmp.GetWord(),wordsList);
            counterDifferent++;
        }
        return wordsList;
    }

    /**
     * The function gets a list and a word and returns if the word is in the list .
     * @param head Is the head of the list .
     * @param word Is the word we're searching for .
     * @return True/False according to the searching results .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private boolean isItInList(WordNode head,String word)
    {
        if (head==null)
        {
            return false;
        }
        WordNode tmp= head;
        while(tmp.GetNext()!=null)
        {
            if(tmp.GetWord()==word)
            {
                return true;//if word is in the list - return true
            }
            else
            {
                tmp=tmp.GetNext();//if word is not in the list - continue until the end
            }
        }
        if(tmp.GetWord().equals(word))//if word is in on the end of list - return true
        {
            return true;
        }
        else
        {
            return false;
        }


    }

    /**The function Gets a list and a word and returns how many times the words is in the list .
     * @param list Is the list were going to check .
     * @param  word Is the words that we're going to search in the list .
     * @return How many times "word" is in "list" .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    private int howManyTimesWordInList(WordNode list,String word)
    {
        int counter=0;
        WordNode tmp= list;
        while(tmp.GetNext()!=null)
        {
            if (tmp.GetWord().equals(word))
            {
                counter++;//counting how many times word is in the specific list
                tmp=tmp.GetNext();
            }
            else
            {
                tmp=tmp.GetNext();
            }
        }
        if (tmp.GetWord()==word)
        {
            counter++;
        }
        else
        {
            //do nothing - we ar eon the last node in the list .
        }
        return counter;


    }

    /**
     * The function checks about who is the most frequent word in the list. If there are 2 most frequent words - the function will return the one which is first in order.
     * @return The most frequent word that also first in order.
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public String mostFrequentWord ()
    {
        String wordMostFrequent="";
        if(head==null||head.GetWord()=="")
        {
            return"";
        }
        else
        {
            int mostFrequentWordCounter=0,mostFrequentWordApperence=0;
            WordNode tmpHead=head;
            wordMostFrequent= tmpHead.GetWord();
            while(tmpHead.GetNext()!=null)
            {
                mostFrequentWordCounter=howManyTimesWordInList(tmpHead, tmpHead.GetWord());
                if(mostFrequentWordCounter>mostFrequentWordApperence)//if there is a new frequent word - put it as the most frequent
                {
                    mostFrequentWordApperence = mostFrequentWordCounter;
                    wordMostFrequent= tmpHead.GetWord();
                }
                if(mostFrequentWordCounter==mostFrequentWordApperence)//if there is an equal frequent word - check who is before in the ABC and put it as the most frequent
                {
                    if (IsInRightOrder(wordMostFrequent, tmpHead.GetWord()))
                    {
                        //the words is in the right order - do nothing
                    }
                    else
                    {
                        wordMostFrequent= tmpHead.GetWord();
                    }
                }
                tmpHead=tmpHead.GetNext();
            }
        }
            return wordMostFrequent;
    }
    /**
     * The function gets a char and returns how many words starts with this letter .
     * @param letter Is the letter for the words check .
     * @return The number of words that start with this specific letter.
     * Complexity of memory - O(n)
     * Complexity of running time - O(n)
     */
    public int howManyStarting (char letter)
    {
        int counter =0;
        WordNode tmpHead=head;
        while(tmpHead.GetNext()!=null)
        {
            if(tmpHead.GetWord().charAt(0)==letter)
            {
                counter++;//count how many words starts with this char
            }
            tmpHead=tmpHead.GetNext();
        }
        if(tmpHead.GetWord().charAt(0)==letter)
        {
            counter++;//count how many words starts with this char - last node
        }
        return counter;
    }

    /**
     * The function returns most frequent starting letter . If there are 2 most frequent letters - the function will return the one which is first in order.
     * @return The most frequent starting letter .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public char mostFrequentStartingLetter ()
    {
        WordNode tmp=head;
        return mostFrequentStartingLetter(tmp,tmp.GetWord().charAt(0),howManyStarting(tmp.GetWord().charAt(0)));//returning which letter is the most frequent
    }
    /**
     * The function returns most frequent starting letter . If there are 2 most frequent letters - the function will return the one which is first in order.
     * @param head Is the head of the list we want to check.
     * @param letter Is the character we get from the user(the first letter of the first word) for checking in the recursion .
     * @param howMany Is the number that the letter is in the list (as starting letter) .
     * @return The most frequent starting letter .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public char mostFrequentStartingLetter (WordNode head,char letter,int howMany)
    {

        int tmpHowMany = howManyStarting(head.GetWord().charAt(0));
        if (tmpHowMany > howMany)
        {
            letter = head.GetWord().charAt(0);
            howMany = tmpHowMany;
            tmpHowMany=0;
        }
        if (tmpHowMany == howMany)
        {
            if (IsInRightOrder(head.GetWord(), head.GetNext().GetWord())) {
                //do nothing - everything is ok .
            } else
            {
                head = head.GetNext();
                letter = head.GetWord().charAt(0);
            }

        }
        tmpHowMany=howMany;
        if (head.GetNext() != null)
        {
            return mostFrequentStartingLetter(head.GetNext(), letter, howMany);
        }
        else//if you're on the end and finished counting - return the newLetter - the most updated value
        {
            char newLetter=letter;
            return  newLetter;
        }

    }

    /**
     * The function returns a String of the words and the number of times that each word appears .
     * @return String of the words and the number of times that each word appears .
     * Complexity of memory - O(n)
     * Complexity of running time - O(n^2)
     */
    public String toString() {
        if (head == null) {
            return "";
        } else {
            WordNode tmp = differentWords();
            String ret = "";
            while (tmp.GetNext() != null) {
                ret += tmp.GetWord() + '\t' + howManyTimesWordInList(head, tmp.GetWord()) + '\n';//add the value to a big String for printing
                tmp = tmp.GetNext();
            }
            ret += tmp.GetWord() + '\t' + howManyTimesWordInList(head, tmp.GetWord()) + '\n';//last node - add the value to a big String for printing
            return ret;
        }
    }
}
