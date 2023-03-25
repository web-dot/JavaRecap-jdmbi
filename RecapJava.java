import java.util.List;
import java.util.ArrayList;   
import java.io.*;
import java.lang.*;

class ListOfNumbers{
   private List<Integer> list;
   private static final int SIZE = 10;
   public ListOfNumbers(){
      list = new ArrayList<Integer>(SIZE);
      for(int i=0; i<SIZE; i++){
         list.add(new Integer(i));
      }
   }
  
   public void writeList() throws IOException {
      //The FileWriter constructor throws IOException, which must be caught.
         PrintWriter out = null;
         try
            {
               System.out.println("Entering try block");
               out = new PrintWriter(new FileWriter("OutFile.txt"));
               for(int i=0; i<SIZE; i++){
                  out.println("Value at: " + i + " = " + list.get(i));
                  }
            }
            catch(IndexOutOfBoundsException e){
                  System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            }   
            catch(IOException e){
               System.err.println("Caught IOException: " + e.getMessage());
            }
            finally{
               if(out != null){
                  System.out.println("Closing Printwriter");
                  out.close();
                  
               }
               else{
                  System.out.println("Printwriter not open");
               }
            }  
         }
      }

public class RecapJava{
   /*
      source : docs.oracle.com/javase/tutorial
   */

   /*
      1.Exception:
         -> Exception is a short term for `Exceptional event`
         -> All exceptions are `checked exceptions` except for those indicated by `Error` and `Runtime Exception` and their subclasses
         -> `Checked exceptions` are subjected to catch-or-specify requirement
         -> `Runtime exceptions` are NOT subjected to catch-or-specify requirements.
         -> `finally` block is always executed. Putting clean-up code in the finall block is a good practice, even when no exceptions are anticipated.
         Note: the finally block may not execute if the JVM exits while `try` or `catch` block is executed.     
         
         -> If the `listOfNumbers.writeList()` method does not catch the checked exceptions, that can occur within it,
            the `writeList()` method must specify that it can throw these exceptions.
         -> To specify `writeList()` method can throw two exceptions, add a `throws` clause to the method declaration.
         -> `throws` clause comprises of the `throws` keyword followed by comma separated list of all the exceptions thrown by the method.
   **/   
   
   /**
      2.Creating Exception classes:
   */
   
   /**
         ACCESS SPECIFIERS
     =====================    
                  Class       Package        Subclass       World
         
     public         Y            Y              Y              Y
     protected      Y            Y              Y              N
     no modifier    Y            Y              N              N
     private        Y            N              N              N
   */
   
   
   /**
      3. Abstract class and Interface;
         -> Abstract classes are similar to interfaces. We cannot instantiate them, and they may contain a mix of
            methods declared with or without implementation.
         -> However, with Abstract classes, we can declare fields that are not static and final, and define public,
            protected and private concrete methods.
         -> Can extend only one class whether or not it is abstract.
            
         -> With `Interfaces`:
                 -> All fields are automatically public, static and final
                 -> All methods we declare or define(default methods) are public.
                 -> Can implement any number of Interfaces
                 
                 
       Big Question : Which should you use, abstract classes or interfaces?
       
       * Consider using abstract classes if any of these statements apply to your situation:
            1. You want to share code among several closely related classes.
            2. You expect that classes that extend your abstract class have many common methods ar fields, or require
               access modifiers other than public(such as protected and private)
            3. You want to declare non-static or non-final fields. This enables you to define methods that can access and
               modify the state of the object to which they belong. 
       
       * Consider using interfaces, if any of these statements apply to your situation:
            1. You expect that unrelated classes would implement your interface. For example, the interfaces `Comparable`
               and `Cloaneable` are implemented by many unrelated classes.
            2. You want to specify behaviour of a particular data type, but not concerned about who implemements its behaviour.
            3. You want to take advantage of multiple inheritance of type.
       
       
       
       
       
       
       
   */
   
   
   public static void main(String[] args){
      ListOfNumbers listOfNumbers = new ListOfNumbers(); 
      listOfNumbers.writeList();        
   }
}