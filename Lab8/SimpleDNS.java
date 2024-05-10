import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DNSRecord
{
  String hostname;
  String ipAddress;

    DNSRecord (String hostname, String ipAddress)
  {
    this.hostname = hostname;
    this.ipAddress = ipAddress;
  }
}

public class SimpleDNS{
  private static final int TABLE_SIZE = 17;
  private static final int A = 33;
  private List < DNSRecord >[] hashTable = new ArrayList[TABLE_SIZE];

  public SimpleDNS ()
  {
    for (int i = 0; i < TABLE_SIZE; i++)
      {
	hashTable[i] = new ArrayList <> ();
      }
  }

  private int hashFunction (String hostname)
  {
    int hash = 0;
    for (int i = 0; i < hostname.length (); i++)
      {
	hash += hostname.charAt (i) * Math.pow (A, i);
      }
    return hash % TABLE_SIZE;
  }

  public void insert (String hostname, String ipAddress)
  {
    int index = hashFunction (hostname);
  for (DNSRecord record:hashTable[index])
      {
	if (record.hostname.equals (hostname))
	  {
	    System.out.println ("Hostname already exists in the hash table.");
	    return;
	  }
      }
    hashTable[index].add (new DNSRecord (hostname, ipAddress));
    System.out.
      println ("DNS record inserted successfully into the Hash table.");
  }

  public void find (String hostname)
  {
    int index = hashFunction (hostname);
  for (DNSRecord record:hashTable[index])
      {
	if (record.hostname.equals (hostname))
	  {
	    System.out.println ("The hostname " + hostname +
				" is present in the hash table.");
	    System.out.println ("The ip address is " + record.ipAddress);
	    return;
	  }
      }
    System.out.println ("No such element found.");
  }

  public void display ()
  {
    for (int i = 0; i < TABLE_SIZE; i++)
      {
	System.out.println ("Index " + i + ":");
      for (DNSRecord record:hashTable[i])
	  {
	    System.out.println (record.hostname + " -> " + record.ipAddress);
	  }
      }
  }

  public static void main (String[]args)
  {
    SimpleDNS dns = new SimpleDNS ();
    Scanner scanner = new Scanner (System.in);
    int choice;

    do
      {
	System.out.println("Implementing Hash Table using separate chaining to simulate a DNS");
	System.out.println ("1) Insert hostname with IP");
	System.out.println ("2) Search hostname");
	System.out.println ("3) Display");
	System.out.println ("4) Exit");
	System.out.print ("Enter Your Choice: ");
	choice = scanner.nextInt ();
	scanner.nextLine ();	

	switch (choice)
	  {
	  case 1:
	    System.out.print ("Please enter the hostname: ");
	    String hostname = scanner.nextLine ();
	    System.out.print ("Please Enter IP: ");
	    String ipAddress = scanner.nextLine ();
	    dns.insert (hostname, ipAddress);
	    break;
	  case 2:
	    System.out.print ("Please enter the hostname to be searched: ");
	    String searchHostname = scanner.nextLine ();
	    dns.find (searchHostname);
	    break;
	  case 3:
	    dns.display ();
	    break;
	  case 4:
	    System.out.println ("Exiting...");
	    break;
	  default:
	    System.out.println ("Invalid choice. Please try again.");
	  }
      }
    while (choice != 4);

    scanner.close ();
  }
}
