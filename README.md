# trainingJavaCSV

This was a training excercise during my early learning stage in Java.

The project consisted in the management of csv files with diferent kind of fields.

Hypothetical users have been registered into 2 CSV files. All data was generated from the website "generatedata.com".
This website gives the result as a csv file (userDataraw.csv).

Then, the program can divide it into 2 files:

The first csv file (datosA.csv) contains 4 fields:
- Email adress
- Password
- Username
- Phone number
The second csv file (datosB.csv) contains 3 fields:
- Postal code
- ID
- Phone number (again, acting like a foreign key)

Fields and lines are not in order. Some data is "corrupted":
There are different types of data corruption:
- Some items may contain an "&" in substitution to other characters. This just happens in phone numbers, postal codes and ID (because their length is fixed). 
In these cases, in order not to lose the data, the "server" may have duplicated the original data in another position of the tuple (resulting in an extra field).
- Other items may contain an "&" or a "-" symbol in adition to the word (in any place).
- Some tuples may be duplicated in any of the 2 initial files.

Objectives are stored (in spanish, I'm sorry) in the Word document in the "csvs" folder.
