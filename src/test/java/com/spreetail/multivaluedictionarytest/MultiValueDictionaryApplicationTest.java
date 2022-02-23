package com.spreetail.multivaluedictionarytest;
import com.spreetail.multivaluedictionary.Dictionary;
import com.spreetail.multivaluedictionary.MultiValueDictionaryApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MultiValueDictionaryApplicationTest {

    static Dictionary<String, String> dictionary;

    /* Initialises the Dictionary map before the unit tests are executed */
    @BeforeAll
    static void init() {
        dictionary = new Dictionary<>();
    }

    /* testInvalidInputs() unit test checks if the input to the application is valid / invalid */
    @Test
    public void testInvalidInputs() {
        Assertions.assertTrue(MultiValueDictionaryApplication.isInputInValid(new String[]{"ADD"}));
        Assertions.assertTrue(MultiValueDictionaryApplication.isInputInValid(new String[]{ "ADD", "XYZ"}));
        Assertions.assertFalse(MultiValueDictionaryApplication.isInputInValid(new String[]{"ADD", "XYZ", "ABC"}));
        Assertions.assertTrue(MultiValueDictionaryApplication.isInputInValid(new String[]{ "MEMBERS"}));
        Assertions.assertFalse(MultiValueDictionaryApplication.isInputInValid(new String[]{ "MEMBERS", "UZX"}));
        Assertions.assertTrue(MultiValueDictionaryApplication.isInputInValid(new String[]{ "CLEAR", "ABC"}));
        Assertions.assertFalse(MultiValueDictionaryApplication.isInputInValid(new String[]{ "CLEAR"}));
    }

    /* testAdd() unit test checks the ADD functionality of the application */
    @Test
    public void testAdd() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 1", "value 1"));
        Assertions.assertFalse(dictionary.addItemToDictionary("key 1", "value 1"));
        Assertions.assertTrue(dictionary.addItemToDictionary("key 1", "value 2"));
        Assertions.assertTrue(dictionary.addItemToDictionary("key 2", "value 1"));
    }

    /* testKeyExists() unit test checks the KEYEXISTS functionality of the application */
    @Test
    public void testKeyExists() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 3", "value 1"));
        Assertions.assertTrue(dictionary.itemExist("key 3"));
        Assertions.assertFalse(dictionary.itemExist("ABC"));
    }

    /* testKeys() unit test checks the KEYS and CLEAR functionality of the application */
    @Test
    public void testKeys() {
        Assertions.assertEquals(dictionary.getDictionarySize(),3);
        dictionary.clearDictionary();
        Assertions.assertEquals(dictionary.getDictionarySize(),0);
    }

    /* testMembers() unit test checks the MEMBERS functionality of the application */
    @Test
    public void testMembers() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 4", "value 1"));
        Assertions.assertEquals(dictionary.getItemFromDictionary("key 4").size(),1);
        Assertions.assertEquals(dictionary.getItemFromDictionary("key 1").size(),0);
    }

    /* testRemove() unit test checks the REMOVE functionality of the application */
    @Test
    public void testRemove() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 5", "value 1"));
        Assertions.assertTrue(dictionary.addItemToDictionary("key 5", "value 2"));
        Assertions.assertTrue(dictionary.removeFromDictionary("key 5", "value 1"));
        Assertions.assertFalse(dictionary.removeFromDictionary("key 5", "value 3"));
        Assertions.assertTrue(dictionary.removeFromDictionary("key 5", "value 2"));
        Assertions.assertTrue(dictionary.getItemFromDictionary("key 5").isEmpty());
        Assertions.assertTrue(dictionary.removeFromDictionary("key 5"));
        Assertions.assertFalse(dictionary.itemExist("key 5"));
    }

    /* testRemoveAll() unit test checks the REMOVEALL functionality of the application */
    @Test
    public void testRemoveAll() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 4", "value 2"));
        Assertions.assertEquals(dictionary.getItemFromDictionary("key 4").size(),2);
        Assertions.assertTrue(dictionary.removeFromDictionary("key 4"));
        Assertions.assertFalse(dictionary.itemExist("key 4"));
    }

    /* testMemberExists() unit test checks the MEMBEREXISTS functionality of the application */
    @Test
    public void testMemberExists() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 6", "value 1"));
        Assertions.assertFalse(dictionary.itemExist("key 6","value 2"));
        Assertions.assertFalse(dictionary.itemExist("key 7","value 2"));
        Assertions.assertTrue(dictionary.itemExist("key 6","value 1"));
    }

    /* testAllMembers() unit test checks the ALLMEMBERS and ITEMS functionality of the application */
    @Test
    public void testAllMembers() {
        Assertions.assertTrue(dictionary.addItemToDictionary("key 6", "value 2"));
        Assertions.assertTrue(dictionary.addItemToDictionary("key 7", "value 3"));
        Assertions.assertEquals(dictionary.getValueSet().size(),3);
    }

}
