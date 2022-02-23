package com.spreetail.multivaluedictionary;

import com.spreetail.multivaluedictionary.constants.Commands;
import com.spreetail.multivaluedictionary.constants.Messages;
import com.spreetail.multivaluedictionary.services.MultiValueDictionaryService;
import com.spreetail.multivaluedictionary.utils.PrintUtility;
import java.util.Scanner;

/* MultiValueDictionaryApplication Class provides a console menu through which users can submit their commands .*/

public class MultiValueDictionaryApplication {

    static String newLine = System.getProperty(Messages.LINE_SEPARATOR);

    /* getUserInputAndExecuteCommands() method gets the user input from the console and executes the submitted command after
    * validating the input. The result of the command is displayed on the console.
    * HELP command gives all the details about each command supported.
    * In order to close / exit the application,the user needs to submit the EXIT command.
    * @param no input
    * @return no return value. Output of the command is logged to the console. */
    public static void getUserInputAndExecuteCommands() {
        MultiValueDictionaryService multiValueDictionaryService = new MultiValueDictionaryService();
        Scanner scanner = new Scanner(System.in);
        boolean close = false;
        while (!close) {
            String[] input = scanner.nextLine().split(" ");
            try {
                if(input.length == 0) {
                    PrintUtility.print(Messages.PROVIDE_VALID_COMMAND);
                    continue;
                }

                if(isInputInValid(input)) continue;
                Commands command = Commands.valueOf(input[0].toUpperCase());

                switch (command) {
                    case KEYEXISTS:
                        multiValueDictionaryService.keyExists(input[1]);
                        break;
                    case MEMBEREXISTS:
                        multiValueDictionaryService.memberExists(input[1], new String[]{ input[2] });
                        break;
                    case REMOVEALL:
                        multiValueDictionaryService.removeAllMembersOfKey(input[1]);
                        break;
                    case ADD:
                        multiValueDictionaryService.addMemberToKey(input[1], input[2]);
                        break;
                    case KEYS:
                        multiValueDictionaryService.getAllKeys();
                        break;
                    case MEMBERS:
                        multiValueDictionaryService.getMembersOfKey(input[1]);
                        break;
                    case REMOVE:
                        multiValueDictionaryService.removeMemberOfKey(input[1], new String[]{ input[2] });
                        break;
                    case CLEAR:
                        multiValueDictionaryService.clear();
                        break;
                    case ALLMEMBERS:
                        multiValueDictionaryService.getAllMembers();
                        break;
                    case ITEMS:
                        multiValueDictionaryService.getAllItems();
                        break;
                    case HELP:
                        PrintUtility.print(Messages.HELP);
                        break;
                    case EXIT:
                        PrintUtility.print(Messages.CLOSING_APPLICATION);
                        scanner.close();
                        close = true;
                        break;
                    default:
                        PrintUtility.print(Messages.COMMAND_NOT_SUPPORTED);
                        enterCommand();
                        break;
                }
                if(!close){
                    enterCommand();
                }


            } catch (IllegalArgumentException e) {
                PrintUtility.print(
                        Messages.AVAILABLE_COMMANDS);
                PrintUtility.print(Messages.HELP);
                enterCommand();

            }
        }
    }

    /* isInputInValid() method checks if the input submitted by the user is valid / invalid
    * @param input is a String array which could be of the form ["ADD", "Key", "Value"]
    * Here the first item represents the command to be performed followed by a key and a member
    * @return true in case of an invalid input and false otherwise
    * */
    public static boolean isInputInValid(String [] input) {
        if ((input[0].equals(Commands.MEMBERS.toString()) ||
                input[0].equals(Commands.REMOVEALL.toString())
                || input[0].equals(Commands.KEYEXISTS.toString()))
                && input.length == 1) {
            PrintUtility.print(Messages.PROVIDE_VALID_COMMAND_FORMAT +input[0]+ Messages.KEY);
            PrintUtility.print(newLine);
            return true;
        }

        if ((input[0].equals(Commands.ADD.toString()) ||
                input[0].equals(Commands.MEMBEREXISTS.toString()) ||
                input[0].equals(Commands.REMOVE.toString()) )
                && (input.length == 1 || input.length == 2)) {
            PrintUtility.print(Messages.PROVIDE_VALID_COMMAND_FORMAT + input[0] + Messages.KEY_VALUE_PAIR );
            PrintUtility.print(newLine);
            return true;
        }

        if ((input[0].equals(Commands.KEYS.toString()) ||
                input[0].equals(Commands.CLEAR.toString()) ||
                input[0].equals(Commands.ALLMEMBERS.toString()) ||
                input[0].equals(Commands.ITEMS.toString()) ||
                input[0].equals(Commands.HELP.toString()) ||
                input[0].equals(Commands.EXIT.toString()))
                && input.length > 1) {
            PrintUtility.print(Messages.PROVIDE_VALID_COMMAND_FORMAT + input[0] );
            PrintUtility.print(newLine);
            return true;
        }

        return false;
    }

    /* enterCommand() method prints a request to the user to enter the next command
    * @param no input
    * @return no return value. Output is logged to the console */
    public static void enterCommand() {
        PrintUtility.print(Messages.ENTER_COMMAND);
        PrintUtility.print(newLine);
    }

    /* Entry point to the application */
    public static void main(String[] args) {
        String welcomeMessage = newLine + Messages.WELCOME + newLine +
                Messages.AVAILABLE_COMMANDS + newLine +
                Messages.HELP + newLine;
        PrintUtility.print(welcomeMessage);
        enterCommand();
        getUserInputAndExecuteCommands();
    }

}
