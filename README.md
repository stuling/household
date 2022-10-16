### Requirements:
Write a standalone executable or script using the language of your preference (Java preferred).  Given the provided input data, print the expected output to the console or write to a text file.  Please also include Java unit tests that test your code.

### Input data:
"Dave","Smith","123 main st.","seattle","wa","43"  
"Alice","Smith","123 Main St.","Seattle","WA","45"  
"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"  
"Carol","Johnson","234 2nd Ave","Seattle","WA","67"  
"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"  
"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"  
"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"  
"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"  
"Ian","Smith","123 main st ","Seattle","Wa","18"  
"Jane","Smith","123 Main St.","Seattle","WA","13"  

### Expected output:
1. Each household and number of occupants, followed by:
2. Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is older than 18

### Assumptions:
1. I interpreted requirement (1) of the Expected output to mean display household by last name.

For example, the "Brown" household is displayed as 
> Household name: Brown, 2
 
2. Output is printed to the console from Main().
3. Input is read from *input.csv* in the root of the project. For convenience, Unit tests can read from that same input file or use *getOccupantListFromTestData()* defined in **OccupantListInput**.java.
4. The "age" input field is cast as Integer.parseInt in **OccupantListInput**.java to make "Adult" evaluation easier.

### Some Technical Details:
| Tool         | Details                                |
|--------------|----------------------------------------|
| IDE          | IntelliJ IDEA Community Edition 2022.1 |
| Language     | Java                                   |
| JDK          | jdk-11.0.14.101-hotspot                |
| Build System | IntelliJ build system                  |
| Unit Tests   | JUnit 5                                |

### Console Output From Main()
This is the output written to the console when the application is run from Main() using the supplied input file, *input.csv*

Household name: Brown, 2  
Household name: Johnson, 1  
Household name: Jones, 1  
Household name: Smith, 5  
Household name: Williams, 1  
Occupant: Carol Johnson - 234 2nd Ave Seattle, WA - Age: 67  
Occupant: Frank Jones - 234 2nd Ave Tacoma, FL - Age: 23  
Occupant: Alice Smith - 123 Main St Seattle, WA - Age: 45  
Occupant: Dave Smith - 123 main st seattle, wa - Age: 43  
Occupant: Eve Smith - 234 2nd Ave Tacoma, WA - Age: 25  
Occupant: Bob Williams - 234 2nd Ave Tacoma, WA - Age: 26

### Unit Test Output
An export of a JUnit run is checked in as **Test Results - test_in_household.html**
