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
    CharStack opstack = new CharStack();
    String result = "";

    System.out.print( "Please input your infix expression: " );
    String input = scan.nextLine();
    System.out.println();
    System.out.print( "Postfix conversion: " );

    for( int i = 0; i < input.length(); i++ )
    {
      if ( isOperand( input.charAt(i) ) )
      {
        result += input.charAt(i);

      }// end of if ( isOperand( input.charAt(i) ) )

      else if ( isOperator( input.charAt(i) ) )
      {
        if ( !( opstack.isEmpty() ) )
        {
          int precedence = precedenceOrder( input.charAt(i) );
          char nextOp = opstack.peek();
          while ( ( precedenceOrder( nextOp ) >= precedence ) && ( !(opstack.isEmpty() ) ) )
          {
            result += opstack.pop();

          }// end of if ( precedenceOrder( nextOp ) >= precedence )

        }// end of if ( !( opstack.isEmpty() ) )

        opstack.push( input.charAt(i) );

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
          result += next;
          opstack.pop();

          if ( !(opstack.isEmpty() ) )
          {
            next = opstack.peek();

          }// end of if ( !(opstack.isEmpty() ) )

        }// end of while ( !(next == '(' ) )

        opstack.pop();

      }// end of else if ( input.charAt(i) == ')' )

    }// end of for( int i = 0; i > input.length(); i++ )

    while ( !( opstack.isEmpty() ) )
    {
      result += opstack.pop();

    }// end of while ( !( opstack.isEmpty() ) )

    System.out.println( result );

  }// end of main

}// end of Converter