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
  
   public void writeList(){
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
   **/   
   
   public static void main(String[] args){
      ListOfNumbers listOfNumbers = new ListOfNumbers(); 
      listOfNumbers.writeList();        
   }
}