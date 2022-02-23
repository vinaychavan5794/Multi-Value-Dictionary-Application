package com.spreetail.multivaluedictionary.constants;

/*  Messages Class provides standard messages for different events */
public final class Messages {
    public static final String COMMAND_NOT_SUPPORTED = "Entered Command is not supported";
    public static final String CLEARED = "Cleared";
    public static final String ENTER_COMMAND = "Please enter a command";
    public static final String CLOSING_APPLICATION = "Closing Multi-Value Dictionary Application";
    public static final String AVAILABLE_COMMANDS = "Below are the available commands that the Multi-Value Dictionary Application supports.";
    public static final String ADDED = "Added";
    public static final String MEMBER_ALREADY_EXISTS = "ERROR, member already exists for the key";
    public static final String DICTIONARY_EMPTY = "Empty set";
    public static final String KEY_DOES_NOT_EXIST = "ERROR, key does not exist";
    public static final String MEMBER_DOES_NOT_EXIST = "ERROR, member does not exist.";
    public static final String REMOVED = "Removed";
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String PROVIDE_VALID_COMMAND = "Please provide valid input";
    public static final String PROVIDE_VALID_COMMAND_FORMAT = "Please provide valid command in the form of: ";
    public static final String KEY_VALUE_PAIR = " <key> <value>";
    public static final String KEY = " <key>";
    public static final String WELCOME = "-----------------------Welcome to Multi-Value Dictionary Application--------------";
    public static final String HELP = "\t1. KEYS: \"Retrieve all keys from the dictionary. Syntax: KEYS\",\n" +
            "\t2. MEMBERS: \"Retrieve all values associated with the given key. Syntax: MEMBERS <key>\",\n" +
            "\t3. REMOVE: \"Remove value associated with Key. Also, removes the key if the last value of the key is removed. Syntax: REMOVE <key> <value>\",\n" +
            "\t4. REMOVEALL: \"Remove key along with all its values. Syntax: REMOVEALL <key>\",\n" +
            "\t5. ALLMEMBERS: \"Retrieve all the entries from the dictionary. Syntax: ALLMEMBERS\",\n" +
            "\t6. ADD: \"Insert new key with value or append value to an existing key. Syntax: ADD <key> <value>. Duplicates keys are not permitted\",\n" +
            "\t7. ITEMS: \"Retrieve all keys along with their values. Syntax: ITEMS\",\n" +
            "\t8. CLEAR: \"Remove all the entries from the dictionary. Syntax: CLEAR\",\n" +
            "\t9. KEYEXISTS: \"Check if key exists. Syntax: KEYEXISTS <key>\",\n" +
            "\t10. MEMBEREXISTS: \"Check if the value exists for a given key. Syntax: MEMBEREXISTS <key> <value>\",\n" +
            "\t11. EXIT: \"Exit from the application. Syntax: EXIT\"),\n" +
            "\t12. HELP: \" Enlists all available commands along with their syntax. Syntax: HELP\"";
}
