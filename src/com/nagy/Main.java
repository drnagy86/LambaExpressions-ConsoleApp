package com.nagy;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    private static String[] strList = {"humor", "monkey", "mo", "hello", "famous", "clamor", "limo", "diamond", "tomorrow", "mom", "alamo", "heat"};
    private static String searchFor = "mo";
    private static String[] menuOptions;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menuTitle = "Search for words in a list containing a search string";
        String prompt = "Select an option:";

        setMenuOptions();

        int choice = 0;

        System.out.println("\nTestable data set always loaded containing list from class.\n" +
                "\"mo\" is the search string.");
        while (true){
            choice = UIUtility.showMenuOptions(menuTitle,prompt,menuOptions, scanner);

            if (choice == 0) continue;
            if (choice == menuOptions.length +1) break;

            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice)-1]);


            switch (choice){
                case 1:
                    strList = null;
                    strList = new String[]{"humor", "monkey", "mo", "hello", "famous", "clamor", "limo", "diamond", "tomorrow", "mom", "alamo", "heat"};
                    searchFor = "mo";
                    System.out.println("Searching for: " + searchFor + " in default string list.");
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 2:
                    //New Search String
                    List<String> newStrList = new ArrayList<>();
                    while(true){
                        System.out.println("Add a string to the list: ");
                        String nextString = scanner.nextLine();
                        newStrList.add(nextString);
                        System.out.println("Would you like to add another?(Y/n)");
                        String cont = scanner.nextLine();
                        if(cont.toLowerCase().equals("y") || cont.toLowerCase().equals("yes")){

                            continue;

                        } else {
                            strList = new String[newStrList.size()];
                            for (int i = 0; i < newStrList.size(); i++) {
                                strList[i] = newStrList.get(i);
                            }
                            break;
                        }

                    }
                    System.out.println("New string list: ");
                    printSearchString();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 3:
                    System.out.println("Type in a new search string: ");
                    searchFor =scanner.nextLine();
                    System.out.println("Searching for " +    searchFor);
                    setMenuOptions();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 4:
                    printSearchString();
                    printResultsOfAnalyzer(MyString.contains());
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 5:
                    printSearchString();
                    printResultsOfAnalyzer(MyString.startsWith());
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 6:
                    printSearchString();
                    printResultsOfAnalyzer(MyString.equals());
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 7:
                    printSearchString();
                    printResultsOfAnalyzer(MyString.endsWith());
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 8:
                    printSearchString();
                    printResultsOfAnalyzer(MyString.containsSearchAndLessThanFive());
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 9:
                    printResultsOfAnalyzer(MyString.containsSearchAndMoreThanFive());
                    UIUtility.pressEnterToContinue(scanner);
                    break;

            }

        }

    }

    private static void printResultsOfAnalyzer(StringOperation operation){

        StringBuilder results = new StringBuilder();

        for (int i=0;i <= strList.length-1; i++){
            if(operation.analyze(strList[i], searchFor)) results.append(strList[i] + ", ");
        }
        if (results.length() == 0){
            System.out.println("No results found.");
        }else {
            System.out.println(results.substring(0, results.length() - 2));
        }
    }

    private static void printSearchString(){
        System.out.println("Searching for: " + searchFor);
    }

    private static void setMenuOptions(){
        menuOptions = new String[] {
                "Setup Default Test",
                "Create New Test List",
                "Change Search String",
                "Containing \"" + searchFor +"\"",
                "Starting with \"" + searchFor +"\"",
                "Equals \"" + searchFor +"\"",
                "Ending with \"" + searchFor +"\"",
                "Containing words with 5 or less letters and \"" + searchFor +"\"",
                "Containing words with more than 5 letters and \"" + searchFor + "\"",
        };

    }


}
