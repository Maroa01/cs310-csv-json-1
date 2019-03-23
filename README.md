# cs310-csv-json-1
This program gave me some experience with two of the standard plain-text data formats that are commonly used for data interchange: CSV, and JSON.  In this assignment, you will create converters to translate a specific kind of data (course grade data) to and from the CSV and JSON formats.  This assignment will also give you experience with using the Git client and the JUnit testing framework within an IDE.

I used NetBeans 8 as my IDE of choice.



CSV stands for "Comma-Separated Values", and it is used to represent tabular data (like you would find in a spreadsheet); you can find out more on Wikipedia.  

##Output
The particular CSV file that we will work with is similar to the following:

    "ID","Total","Assignment 1","Assignment 2","Exam 1"
    "111278","611","146","128","337"
    "111352","867","227","228","412"
    "111373","461","96","90","275"
    "111305","835","220","217","398"
    "111399","898","226","229","443"
    "111160","454","77","125","252"
    "111276","579","130","111","338"
    "111241","973","236","237","500"

This file represents the grades of eight students (with the given IDs) in a course where there were two assignments and an exam.  Notice that the grades listed are represented as strings in the CSV file.  Even though this particular input data contains eight rows (plus the header row), your code should be written to support an open-ended number of rows.

JSON

JSON stands for "JavaScript Object Notation", and it is used as a general-purpose format for many kinds of data, particularly in Web-based applications; find out more on Wikipedia.  The particular JSON file that we will work with is similar to the following (whitespace added for clarity):

    {
        "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
        "rowHeaders":["111278","111352","111373","111305","111399","111160","111276","111241"],
        "data":[[611,146,128,337],
                [867,227,228,412],
                [461,96,90,275],
                [835,220,217,398],
                [898,226,229,443],
                [454,77,125,252],
                [579,130,111,338],
                [973,236,237,500]
        ]
    }

This file represents the exact same data as the CSV file above; it is just organized differently.  The "rowHeaders" and "colHeaders" values are lists of strings, and the "data" value is a list of integer lists.  Pay close attention to the data types: the grades in the "data" portion of the JSON file are represented as integers instead of strings, while the "rowHeaders" are represented as strings instead of integers.

Once completing the Project

The two input files are provided in the "resources" folder of the project, and a battery of JUnit unit tests, ConverterTest.java, is provided in "Test Packages". To run the unit tests, right-click ConverterTest.java and choose "Run File" from the context menu.  A new output window should appear which displays the results of all four unit tests.  If your converter methods are functioning correctly, the resulting strings should exactly match the original data from the input files.

This program involves working with two of the standard Java data structures: ordered collections and associative collections, in the form of lists and maps. 
