# XML-JavaRarser
An XML file of cities consisting of 2,000,000 lines is given. The program allows you to process and output sorted information in accordance with the three tasks below.

After launching, the application waits for entering the path to the directory file or the "Exit" command to shut down. 

After entering the path to the directory file, the application generates summary statistics:
1) Displays duplicate entries with the number of repetitions.
2) Displays how many in each city: 1, 2, 3, 4 and 5 storey buildings.
3) Shows the file processing time.

After the statistics are output, the application again waits for entering the path to the directory file or the shutdown command. 

On average, the program processes the file in 5,352 seconds.

The strengths of the parser are:
1) Code quality and readability
2) The speed of the application

Program implementation:
The parser uses the Maven system to add several classes from jaxb-api, jakarta.xml.bind-api, jaxb-runtime. 
They are needed to convert information from an XML file into the structure of the Root and Item classes. 
HashMap was chosen to sort information from classes because it provides high speed of data insertion and deletion, at best in O(1).
<img width="751" alt="image" src="https://github.com/JUNIOR14501/XML-JavaRarser/assets/53307775/52705d9c-8a75-40e3-8cdf-921df51efb39">
