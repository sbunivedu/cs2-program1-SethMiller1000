import java.util.Stack;
import java.util.Scanner;

public class Converter
{

  public static boolean isOperand ( char c )
  {
    if(
      ( c >= 'a' && c <= 'z' ) ||
      ( c >= 'A' && c <= 'Z' ) ||
      ( c >= '0' && c <= '9' ) )
      {
        return true;

      }// end of if

      else
      {
        return false;

      }// end of else

  }// end of isOperand

  public static boolean isOperator ( char c )
  {
    return ( ( c == '+' ) || ( c == '-' ) || ( c == '*' ) || ( c == '/' ) );

  }// end of is Operator

  public static int precedenceOrder ( char c )
  {
    if ( c == '*' || c == '/' )
    {
      return 2;

    }// end of if ( c == '*' || c == '/' )

    else
    {
      return 1;

    }// end of else

  }// end of precedenceOrder

  public static void main( String [] args )
  {
    Scanner scan = new Scanner( System.in );
    Stack opstack = new Stack<Character>();

    System.out.print( "Please input your infix expression: " );
    String input = scan.nextLine();
    System.out.println();
    System.out.print( "Postfix conversion: " );

    for( int i = 0; i > input.length(); i++ )
    {
      if ( isOperand( input.charAt(i) ) )
      {
        System.out.print( input.charAt(i) );

      }// end of if ( isOperand( input.charAt(i) ) )

      else if ( isOperator( input.charAt(i) ) )
      {
        int precedence = precedenceOrder( input.charAt(i) );

        while ( !( opstack.isEmpty() ) )
        {
          char nextOp = opstack.peek();
          if ( precedenceOrder( nextOp ) >= precedence )
          {
            System.out.print( nextOp );
            opstack.pop();

          }// end of if ( precedenceOrder( nextOp ) >= precedence )

        }// end of while ( !( opstack.isEmpty() ) )

        opstack.push(); // last line of else if

      }// end of else if ( isOperator( input.charAt(i) ) )

      else if ( input.charAt(i) == '(' )
      {
        opstack.push( input.charAt(i) );

      }// end of else if ( input.charAt(i) == '(' )

      else if ( input.charAt(i) == ')' )
      {
        char next = opstack.peek();
        while ( !(next == '(' ) )
        {
          System.out.print( next );
          opstack.pop();
          next = opstack.peek();

        }// end of while ( !(next == '(' ) )

        opstack.pop();

      }// end of else if ( input.charAt(i) == ')' )

    }// end of for( int i = 0; i > input.length(); i++ )

    while ( !( opstack.isEmpty() ) )
    {
      System.out.print( opstack.peek() );
      opstack.pop();

    }// end of while ( !( opstack.isEmpty() ) )

  }// end of main

}// end of Converter