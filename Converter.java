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

    System.out.print( "Please input your infix expression: " );
    String input = scan.nextLine();
    System.out.println();
    System.out.print( "Postfix conversion: " );

    for( int i = 0; i < input.length(); i++ )
    {
      if ( input.charAt(i) == '(' )
      {
        opstack.push( '(' );

      }// end of else if ( input.charAt(i) == '(' )

      else if ( input.charAt(i) == ')' )
      {

        while ( ( !( opstack.isEmpty() ) ) && ( opstack.peek() != '(' ) )
        {
          System.out.print( opstack.pop() );

        }// end of while ( next != '(' )

        opstack.pop();

      }// end of else if ( input.charAt(i) == ')' )

      else if ( isOperand( input.charAt(i) ) )
      {
        System.out.print( input.charAt(i) );

      }// end of if ( isOperand( input.charAt(i) ) )

      else
      {
        while ( ( !(opstack.isEmpty() ) ) && ( opstack.peek() != '(' ) && ( precedenceOrder( opstack.peek() ) >= precedenceOrder( input.charAt(i) ) ) )
        {
          System.out.print( opstack.pop() );

        }// end of while ( ( precedenceOrder( opstack.peek() ) >= precedenceOrder( input.charAt(i) ) ) && ( !(opstack.isEmpty() ) ) )

        opstack.push( input.charAt(i) );

      }// end of else if ( isOperator( input.charAt(i) ) )

    }// end of for( int i = 0; i > input.length(); i++ )

    while ( !( opstack.isEmpty() ) )
    {
      System.out.print( opstack.pop() );

    }// end of while ( !( opstack.isEmpty() ) )

    System.out.println();

  }// end of main

}// end of Converter