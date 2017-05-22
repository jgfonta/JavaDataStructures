package ch05.hw;

public class BagCollectionDriver 
{
  public static void main(String[] args)
  {
    boolean result;
    UnsortedArrayBagCollection<String> test, test2;
    
    test = new UnsortedArrayBagCollection<String>();
    test2 = new UnsortedArrayBagCollection<String>();

    
    System.out.println("Expect 'true':\t" + test.isEmpty());   
    System.out.println("Expect 'false':\t" + test.isFull());

    result = test.add("alpha");
    System.out.println("Expect 'true':\t" + result);
    System.out.println("Expect 'alpha':\t" + test.get("alpha"));    
    result = test.contains("alpha");
    System.out.println("Expect 'true':\t" + result);
    result = test.contains("beta");
    System.out.println("Expect 'false':\t" + result);
    result = test.add("beta");
    result = test.add("gamma");
    result = test.add("delta");
    result = test.add("epsilon");
    System.out.println("Expect 'false':\t" + test.isEmpty());   
    System.out.println("Expect 'false':\t" + test.isFull());
    result = test.add("pi");
    System.out.println("Expect 'true':\t" + result);
    result = test.contains("beta");
    System.out.println("Expect 'true':\t" + result);
    result = test.contains("epsilon");
    System.out.println("Expect 'true':\t" + result);
    result = test.contains("pi");
    System.out.println(test);
    System.out.println("Expect 'true':\t" + result);
    result = test.remove("magma");
    System.out.println("Expect 'false':\t" + result);
    result = test.remove("delta");
    System.out.println("Expect 'true':\t" + result);
    System.out.println("Expect 'false':\t" + test.isEmpty());   
    System.out.println("Expect 'false':\t" + test.isFull());
    result = test.contains("delta");
    System.out.println("Expect 'false':\t" + result);
    System.out.println("Expect '5':\t" + test.size());
    System.out.println(test);
    
    
    
    //Test adding a new head
    result = test2.add("fong");
    
    //Test adding a new tail
    result = test2.add("william");
    
    //Test adding a new head
    result = test2.add("charles");
    
    //Test adding in the middle
    result = test2.add("jeff");
    
    //Test adding in the middle
    result = test2.add("edward");
    System.out.println(test2);
    
    String grabBag;
    String familyNames[] = {"jeff", "fong", "edward", "william", "charles"};
    while(!test2.isEmpty())
    {
    	grabBag = test2.grab();
    	System.out.println("Random grab: " + grabBag);
    	for (int i=0; i<5;i++)
    	{
    		System.out.println("Count of " + familyNames[i] + " " + test2.count(familyNames[i]));
    	}
    }
    System.out.println("Before Clear: " + test);
    test.clear();
    System.out.println("After Clear: " + test);
    
  }
  
}
