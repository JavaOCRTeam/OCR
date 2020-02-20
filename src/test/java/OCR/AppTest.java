package OCR;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCanReadFirstBlock() {
        List<List<String>> listOfList = App.readFile("Textfile/digitalText.txt");
        for (String s : listOfList.get(0)) {
            System.out.println(s);
        }
    }

    public void testCanReadFirstNumber() {
        List<List<String>> listOfList = App.readFile("Textfile/digitalText.txt");
        List<List<String>> parsedList = App.parseListList(listOfList);
        System.err.println(parsedList.get(0).get(0));
    }

    public void testCanReadFirstParsedNumber() {
        List<List<String>> listOfList = App.readFile("Textfile/digitalText.txt");
        System.err.println(App.numberStringListsToIntLists(App.parseListList(listOfList)).get(0).get(0));
    }
}
