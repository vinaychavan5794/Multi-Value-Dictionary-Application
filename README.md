# Multi-Value-Dictionary-Application

#### Introduction

With Multi-Value-Dictionary-Application the user can perform different commands on the dictionary. The dictionary stores String data in the form of key : value pair.  

The following commands are supported by the application:

#### Comand Name: Description
1. KEYS: Retrieve all keys from the dictionary. Syntax: KEYS
2. MEMBERS: Retrieve all values associated with the given key. Syntax: MEMBERS <key>
3. REMOVE: Remove value associated with Key. Also, removes the key if the last value of the key is removed. Syntax: REMOVE <key> <value>
4. REMOVEALL: Remove key along with all its values. Syntax: REMOVEALL <key>
5. ALLMEMBERS: Retrieve all the entries from the dictionary. Syntax: ALLMEMBERS
6. ADD: Insert new key with value or append value to an existing key. Syntax: ADD <key> <value>. Duplicates keys are not permitted
7. ITEMS: Retrieve all keys along with their values. Syntax: ITEMS
8. CLEAR: Remove all the entries from the dictionary. Syntax: CLEAR
9. KEYEXISTS: Check if key exists. Syntax: KEYEXISTS <key>
10. MEMBEREXISTS: Check if the value exists for a given key. Syntax: MEMBEREXISTS <key> <value>
11. EXIT: Exit from the application. Syntax: EXIT
12. HELP: Enlists all available commands along with their syntax. Syntax: HELP

#### System Requirements

Gradle version: 4.8.+
Java Version : Java 8+


#### Instructions to run the application

**Using IntellJ IDEA with gradle:**
1. Open IntelliJ IDEA, From the main menu, choose Git | Clone. 
2. In the Get from Version Control dialog, choose GitHub on the left.
3. Specify the URL of the repository: https://github.com/vinaychavan5794/Multi-Value-Dictionary-Application.git to clone
4. In the Directory field, enter the path to the folder where your local Git repository will be created.
5. Click Clone. If you want to create a project based on these sources, click Yes in the confirmation dialog.
6.  Execute the Class \MultiValue Dictionary Application\src\main\java\com\spreetail\multivaluedictionary\MultiValueDictionaryApplication.java

**Importing gradle project into IntelliJ**

https://www.jetbrains.com/help/idea/gradle.html#gradle_jvm

**Using Command Line Interface (CLI):**

In the project root directory execute below command inside the terminal:
**.\gradlew clean build**

This will build a jar in \build\libs folder. Once the jar is build, you can copy it to any foler
and execute the following command inside the terminal from the folder having the jar:

**java -jar Name_Of_Jar.jar**

Alternatively, you can go inside the appJar folder in the root directory of the project and execute below command:

**java -jar MultiValueDictionaryApplication.jar**
  
  
