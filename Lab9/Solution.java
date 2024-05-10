import java.util.*;
public class Solution
{
  static void heapSort (String[]s)
  {
    buildHeap (s);
    for (int i = s.length - 1; i >= 0; i--)
      {
	String temp = s[0];
	  s[0] = s[i];
	  s[i] = temp;
	  heapify (s, i, 0);
	  display ("Iteration " + i, s);
  }}

  static void buildHeap (String[]s)
  {
    for (int i = (s.length / 2) - 1; i >= 0; i--)
      {
	heapify (s, s.length, i);
  }}

  static void heapify (String[]s, int size, int subtreeRoot)
  {
    int largest = subtreeRoot;
    int left = 2 * subtreeRoot + 1;
    int right = 2 * subtreeRoot + 2;
    if (left < size && isLarger (s[left], s[largest]))
      {
	largest = left;
      }
    if (right < size && isLarger (s[right], s[largest]))
      {
	largest = right;
      }
    if (largest != subtreeRoot)
      {
	String temp = s[subtreeRoot];
	s[subtreeRoot] = s[largest];
	s[largest] = temp;
	heapify (s, size, largest);
      }
  }
  static boolean isLarger (String s1, String s2)
  {
    return s1.compareTo (s2) > 0;
  }

  static void display (String header, String[]s)
  {
    int longestString = 0;
  for (String temp:s)
      {
	if (temp.length () > longestString)
	  {
	    longestString = temp.length ();
	  }
      }
    String headerFormat = "%15s:";
    String format = " %" + -longestString + "s ";
    System.out.printf (headerFormat + " [", header);
    if (s.length < 1)
      {
	System.out.println ("]");
	return;
      }
    for (int i = 0; i < s.length - 1; i++)
      {
	System.out.printf (format + "|", s[i]);
      } System.out.printf (format + "]" + "\n", s[s.length - 1]);
  }
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    System.out.
      print ("\nPlease enter the number of elements in the array:\n" +
	     " => ");
    try
    {
      int size = Integer.parseInt (sc.nextLine ());
      String[] sArr = new String[size];
      System.out.println ("\nPlease enter the Strings:");
      for (int i = 0; i < size; i++)
	{
	  System.out.print ("String " + (i + 1) + ": ");
	  sArr[i] = sc.nextLine ();
	}
      System.out.println ();
      display ("Original Array", sArr);
      buildHeap (sArr);
      display ("Max Heap", sArr);
      heapSort (sArr);
      display ("Sorted Array", sArr);
    }
    catch (Exception e)
    {
      System.out.println ("Invalid input");
    } sc.close ();
  }
}
