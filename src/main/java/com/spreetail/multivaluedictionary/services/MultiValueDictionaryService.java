package com.spreetail.multivaluedictionary.services;

import com.spreetail.multivaluedictionary.Dictionary;
import com.spreetail.multivaluedictionary.constants.Messages;
import com.spreetail.multivaluedictionary.utils.PrintUtility;

import java.util.Set;

/* MultiValueDictionaryService is wrapper service Class that provides all the methods (commands) supported by the Multi Value Dictionary Application.*/
public class MultiValueDictionaryService {

    private final Dictionary<String, String> dictionary = new Dictionary<>();

    /* addMemberToKey() method either adds a member to the existing key or creates a new entry
    * of key : member pair in the dictionary
    * @param key represents a unique id in the dictionary for a quick look up of the value
    * @param member to be associated with a key. A key can have many members associated with it
    * @return no return value. Output is logged to the console.*/
    public void addMemberToKey(String key, String value) {
        if (dictionary.addItemToDictionary(key, value)) {
            PrintUtility.print(Messages.ADDED);
            return;
        }
        PrintUtility.print(Messages.MEMBER_ALREADY_EXISTS);
    }


    /* getAllKeys() method retrieves all the keys stored in the dictionary
     * @param no input
     * @return no return value. All the keys are logged to the console. */
    public void getAllKeys() {
        if (dictionary.getDictionarySize() == 0) {
            PrintUtility.print(Messages.DICTIONARY_EMPTY);
        }
        int count = 1;
        for (String key : dictionary.getKeySet()) {
            PrintUtility.print(count + ") " + key);
            count++;
        }
    }


    /* getMembersOfKey() method retrieves all the members associated with the key
     * @param key whose members are to be retrieved
     * @return no return value. All the members are logged to the console. */
    public void getMembersOfKey(String key) {
        if (!dictionary.itemExist(key)) {
            PrintUtility.print(Messages.KEY_DOES_NOT_EXIST);
        }
        Set<String> values = dictionary.getItemFromDictionary(key);
        int count = 1;
        for (String value : values) {
            PrintUtility.print(count + ") " + value);
            count++;
        }
    }


    /* removeMemberOfKey() method removes the member that is associated with the key.
     * After removal if the key has no more members then
     * the key is also removed from the dictionary
     * @param key whose member is to be removed
     * @param member to be removed
     * @return no return value. Success/Failure output is logged to the console */
    public void removeMemberOfKey(String key, String [] value) {
        if (!dictionary.itemExist(key)) {
            PrintUtility.print(Messages.KEY_DOES_NOT_EXIST);
            return;
        }
        if (!dictionary.itemExist(key, value)) {
            PrintUtility.print(Messages.MEMBER_DOES_NOT_EXIST);
            return;
        }
        if (dictionary.removeFromDictionary(key, value)) {
            PrintUtility.print(Messages.REMOVED);
            if (dictionary.getItemFromDictionary(key).isEmpty()) {
                dictionary.removeFromDictionary(key);
            }
        }
    }


    /* removeAllMembersOfKey() method removes the key from the dictionary.
     * @param key which to be removed
     * @return no return value. Success/Failure output is logged to the console */
    public void removeAllMembersOfKey(String key) {
        if (!dictionary.itemExist(key)) {
            PrintUtility.print(Messages.KEY_DOES_NOT_EXIST);
            return;
        }
        if (dictionary.removeFromDictionary(key)) {
            PrintUtility.print(Messages.REMOVED);
        }
    }


    /* clear() method removes all the entries from the dictionary.
     * @param no input
     * @return no return value. Success output is logged to the console */
    public void clear() {
        dictionary.clearDictionary();
        PrintUtility.print(Messages.CLEARED);
    }


    /* keyExists() method checks if the key is present in the dictionary.
     * @param key to be checked in the dictionary
     * @return no return value. True/False output is logged to the console */
    public void keyExists(String key) {
        PrintUtility.print(Boolean.toString(dictionary.itemExist(key)));
    }


    /* memberExists() method checks if the member is associated with the key.
     * @param key to retrieve the value from the dictionary
     * @param value to be checked against the key
     * @return no return value. True/False output is logged to the console */
    public void memberExists(String key, String [] value) {
        PrintUtility.print(Boolean.toString(dictionary.itemExist(key, value)));
    }


    /* getAllMembers() method retrieves all the members from the dictionary.
     * @param no input
     * @return no return value. All the members are logged to the console */
    public void getAllMembers() {
        if (dictionary.getValueSet().isEmpty()) {
            PrintUtility.print(Messages.DICTIONARY_EMPTY);
        }
        int count = 1;
        for (String key : dictionary.getKeySet()) {
            Set<String> values = dictionary.getItemFromDictionary(key);
            for (String value : values) {
                PrintUtility.print(count + ") " + value);
                count++;
            }
        }
    }


    /* getAllItems() method retrieves all the key:member pair from the dictionary.
     * @param no input
     * @return no return value. All the pairs are logged to the console */
    public void getAllItems() {
        if (dictionary.getDictionarySize() == 0) {
            PrintUtility.print(Messages.DICTIONARY_EMPTY);
            return;
        }
        int count = 1;
        for (String key : dictionary.getKeySet()) {
            Set<String> values = dictionary.getItemFromDictionary(key);
            for (String value : values) {
                PrintUtility.print(count + ") " + key + ": " + value);
                count++;
            }
        }
    }

    public void getIntersect(String key1, String key2){
        if (!dictionary.itemExist(key1) || !dictionary.itemExist(key2)) {
            PrintUtility.print(Messages.KEY_DOES_NOT_EXIST);
            return;
        }

        Set<String> set1 = dictionary.getItemFromDictionary(key1);
        Set<String> set2 = dictionary.getItemFromDictionary(key2);

        set1.retainAll(set2);
        int count = 1;
        for(String value: set1) {
            PrintUtility.print(count + ") " + value);
            count++;
        }

    }
}
