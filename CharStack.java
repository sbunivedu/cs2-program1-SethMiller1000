public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack(){
    //PRE: None
    //POS: Stack with name of object exists
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;

  }// end of CharStack constructor

  public void push(char element){
    //PRE: stack is not full
    //POS: char input is added and is at top of stack
    //TAS: Add a new item to the stack
    top++;
    s[top] = element;

  }// end of push

  public char pop(){
    //PRE: stack is not empty
    //POS: top index has been decreased by 1 and character removed is returned
    //TAS: Remove and return the item on the top of the stack
    char temp = s[top--];
    return temp;

  }// end of pop

  public boolean isEmpty(){
    //PRE: stack must be instantiated and declared and top must have a value
    //POS: None
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    return top == -1;

  }// end of isEmpty

  public char peek(){
    //PRE: Stack must contain at least 1 character and top must be >= 0
    //POS: Stack contents should remain the same
    //TAS: Return the character element currently on top of
    //     the stack
    return s[top];

  }// end of peek

  public boolean isFull(){
    //PRE: Stack must be instantiated and declared and top must have a value
    //POS: None
    //TAS: Return whether or not the stack is full
    return top == MAX_CAP - 1;

  }// end of isFull

  public String toString(){
    //PRE: Stack must have at least one character, so top must be >= 0
    //POS: Contents of stack must be in string from top to bottom
    //TAS: Returns the contents of the stack from top to bottom in a string
    String stack = "";

    if ( top > -1 )
    {
      for ( int i = top; i <= -1 ; i-- )
      {
        stack = stack + "" + s[i];

      }// end of for ( int i = 0; i < top + 1; i++ )

    }// end of if ( top > -1 )

    return stack;

  }// end of toString

}// end of CharStack
