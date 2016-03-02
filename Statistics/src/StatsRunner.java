//runs statistics program

import java.io.*;

public class StatsRunner
{
	
	public static void main(String [] args) throws IOException
	{
		Roster physics = new Roster();
		physics.readSpecs();
		physics.sortStudents('i');
		/*physics.displayRoster(); //removed for sort variant
		physics.sortStudents('s');
		physics.displayScores();
		*/
		physics.search();
	}
	
	//part 1
/*
 * Enter the name of the .txt file with the formatted student details: 
scores1.txt
Reading file...
Reading completed.

ID Num	Score	Major

11	0	Engineering
22	500	Art
27	90	Incorrect Course Code
32	-10	Art
33	110	Business
39	400	Incorrect Course Code
43	95	Computer Science
50	-8	Mathematics
55	99	Education
63	50	Engineering
65	88	Mathematics
73	89	Education
75	80	Computer Science
87	-5	Business
93	100	Engineering

Highest Score: 500
Lowest Score: 0
Average Score: 46.06
Median Score: 100
Letter Grade Percentages: 
A: 33.3%
B: 33.3%
C: 11.1%
D: 0.0%
F: 22.2%

6 invalid score values were entered.  These scores were not used in calculating the above results. 

 * Enter the name of the .txt file with the formatted student details: 
scores2.txt
Reading file...
Reading completed.

ID Num	Score	Major

11	70	Engineering
17	85	Engineering
22	500	Art
27	90	Incorrect Course Code
32	-10	Art
33	90	Business
39	400	Incorrect Course Code
43	95	Computer Science
44	300	Engineering
50	8	Mathematics
53	87	Business
55	99	Education
63	50	Engineering
65	88	Mathematics
73	89	Education
75	80	Computer Science
83	95	Mathematics
85	60	Mathematics
87	70	Business
93	90	Engineering

Highest Score: 500
Lowest Score: 8
Average Score: 62.3
Median Score: 55.89
Letter Grade Percentages: 
A: 18.7%
B: 43.7%
C: 6.2%
D: 12.5%
F: 18.7%

4 invalid score values were entered.  These scores were not used in calculating the above results. 

 */
	
	//part 2
/*
 * Enter the name of the .txt file with the formatted student details: 
scores1.txt
Reading file...
Reading completed.

Enter an ID number to see the student's information: 
73
ID Num	Score	Major
73	89	Education

Enter 'Y' if you'd like to search for another student, or 'N' if not. 
Y
Enter an ID number to see the student's information: 
8
That student does not exist.
Enter 'Y' if you'd like to search for another student, or 'N' if not. 
y
Enter an ID number to see the student's information: 
87
ID Num	Score	Major
87	-5	Business

Enter 'Y' if you'd like to search for another student, or 'N' if not. 
y
Enter an ID number to see the student's information: 
39
ID Num	Score	Major
39	400	Incorrect Course Code

Enter 'Y' if you'd like to search for another student, or 'N' if not. 
n

 */

}
