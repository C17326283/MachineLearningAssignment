# MachineLearningAssignment

By: Ryan Byrne, C17326283@mydit.ie from 01/04/19 to 14/04/09

This program uses test case file to predict the liklihood that a user has tonsillitis based on the the symptoms they enter.

There are 3 guis.

There are 6 classes, 3 of which are GUIs.

GuiHome:This is just the opening screen that gives you the choice of the other 2 guis.

GuiSymptoms:this screen lets the user enter their symptomns using jradiobuttons that is then tested for probability of having tonsillitis it also
 displays result and the accuracy of the system, it also has tooltips for describing the symptoms.

GuiFile: this screen lests the user display all the patients in the file as well as switch which file the testcases are read from.

Patient: This just reads in 4 values to create a patient object. it is used to make object fromt he file list.

FileProcessor: This class has 3 methods, openFile, readFile and closeFile. these are used directly to access the content of the test case files

FindProbability: This class is where all the maths is done, it  takes in 3 symptoms. then accesses the file to get a list of test cases and counts the important smptoms etc...
it then uses these values in bayes theorem to calculate the probability that a user might have tonsillitis.
This class also has another method to find the accuracy of the predicitions. it splits the list into 70% and 30% and uses the cases int he last 30%
to test against the cases in the first 30%.

How to use:
On the home page select the enter symptoms option then select whichever symptoms apply to you and submit to get your result.
Use the home button at the top of the page to return to the home page.
Click the file selector button. now use the show patients list to see all the test cases in the currently selected file.
Then use the change file button and navigate to your new file of test cases.
Your file path will now be changed. just click the show list of patients again to update it.

GitHub link: https://github.com/C17326283/MachineLearningAssignment
Youtube link: 


