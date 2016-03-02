import java.io.IOException;

// runs PartyList


public class PartyRunner
{
	
	public static void main(String [] args) throws IOException
	{
		Registry forFriday = new Registry();
		forFriday.readGuestList();
		forFriday.sortGuests(forFriday.list);
		forFriday.interact();
	}
/* Enter the name of the file to be read: 
GuestList.txt
Reading file...
Reading completed.
Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
L

Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT no
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Queue, Suzy IBM no
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Ima Geek
Geek, Ima DGT no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Pointoa List
Guest not found. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Closda Windoes
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
N

3 guests have confirmed attendance.
6 guests are unable to attend.
5 guests have not yet responded.

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Electromagnetic Field
Field, Electromagnetic APL maybe

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Olivia Apple
Guest not found. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Asdfgh Keys
Guest not found. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
John Pappoudoupolivsky
Guest not found. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Sally Field
Field, Sally APL maybe

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
April Field
Field, April APL maybe

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
G

Enter the full name of the guest: 
Ima Guest
Guest not found. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
X


Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
Y


Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
Z


Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
L

Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT no
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Queue, Suzy IBM no
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd, or 'Q' to exit: 
Q

 */
/** Part 2
 * Enter the name of the file to be read: 
GuestList.txt
Reading file...
Reading completed.
Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
L
Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT no
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Queue, Suzy IBM no
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
G
Enter the full name of the guest: 
Blaise Pascal
Pascal, Blaise APL no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Suzy Queue
Guest already exists
Queue, Suzy IBM no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Asdfgh Keys
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Mike Rochip
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
?

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Ima Geek
Enter the new response for this guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Amy Rochip
Enter the company of this new guest: 
IBM
Enter the response of this new guest: either 'yes', 'no', or '?' 
?

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Didja Windoes
Enter the company of this new guest: 
APL
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Data Field
Enter the company of this new guest: 
APL
Enter the response of this new guest: either 'yes', 'no', or '?' 
no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Seymouor Math
Guest does not exist

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Elena Zaitsoff
Guest does not exist

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Howard Yadoing
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Asdfgh Keys
Enter the new response for this guest: either 'yes', 'no', or '?' 
no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Mike Rochip
Enter the new response for this guest: either 'yes', 'no', or '?' 
?
Guest had already answered with this response. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
R
Enter the full name of the guest: 
Alice Ardvaark
Guest does not exist

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Alice Ardvaark
Enter the company of this new guest: 
IBM
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
G
Enter the full name of the guest: 
Amy Rochip
Rochip, Amy IBM maybe

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
G
Enter the full name of the guest: 
Beth Yerrmoniesworth
Guest does not exist. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
L
Ardvaark, Alice IBM yes
Field, April APL maybe
Field, Data APL no
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT yes
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Asdfgh DGT no
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Queue, Suzy IBM no
Rochip, Amy IBM maybe
Rochip, Mike DGT maybe
Windoes, Closda APL yes
Windoes, Didja APL yes
Yadoing, Howard DGT no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Data Field
Guest already exists
Field, Data APL no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Genevieve Stapos
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Abe Ardvaark
Enter the company of this new guest: 
IBM
Enter the response of this new guest: either 'yes', 'no', or '?' 
?

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Doyour Math
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
?

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Iluv Math
Enter the company of this new guest: 
DGT
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
C
Enter the full name of the guest: 
Cal Kulate
Geek, Ima DGT yes
Guest, Sally DGT no
Keys, Asdfgh DGT no
Kulate, Cal DGT no
Math, Doyour DGT maybe
Math, Iluv DGT yes
Rochip, Mike DGT maybe
Stapos, Genevieve DGT yes
Yadoing, Howard DGT no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
C
Enter the full name of the guest: 
Linc List
Field, April APL maybe
Field, Data APL no
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Guest, Zoe APL yes
List, Linc APL yes
Pascal, Blaise APL no
Windoes, Closda APL yes
Windoes, Didja APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
C
Enter the full name of the guest: 
Alice Ardvaark
Ardvaark, Abe IBM maybe
Ardvaark, Alice IBM yes
Keys, Qwerty IBM no
Nerd, Ura IBM maybe
Queue, Suzy IBM no
Rochip, Amy IBM maybe

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
A
Enter the full name of the guest: 
Sally Pascal
Enter the company of this new guest: 
Z8S
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
G
Enter the full name of the guest: 
Sally Pascal
Pascal, Sally Z8S yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
C
Enter the full name of the guest: 
Sally Pascal
Pascal, Sally Z8S yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
G
Enter the full name of the guest: 
Blaise Field
Guest does not exist. 

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
C
Enter the full name of the guest: 
Jane Doe
Guest does not exist

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
Z

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
P

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
X

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
N
9 guests have confirmed attendance.
8 guests are unable to attend.
9 guests have not yet responded.

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
L
Ardvaark, Abe IBM maybe
Ardvaark, Alice IBM yes
Field, April APL maybe
Field, Data APL no
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT yes
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Asdfgh DGT no
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Math, Doyour DGT maybe
Math, Iluv DGT yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Pascal, Sally Z8S yes
Queue, Suzy IBM no
Rochip, Amy IBM maybe
Rochip, Mike DGT maybe
Stapos, Genevieve DGT yes
Windoes, Closda APL yes
Windoes, Didja APL yes
Yadoing, Howard DGT no

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest, or 'Q' to exit: 
Q


 */
/* Extra
 * Enter the name of the file to be read: 
GuestList.txt
Reading file...
Reading completed.
Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
M
Enter the full name of the first guest: 
Ima Geek
Enter the full name of the second guest: 
Cal Kulate
Guests already know each other

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
M
Enter the full name of the first guest: 
Ima Geek
Enter the full name of the second guest: 
Ura Nerd

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
M
Enter the full name of the first guest: 
Sally Field
Enter the full name of the second guest: 
Linc List
Guests already know each other

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
A
Enter the full name of the new guest: 
Joe Schmo
Enter the company of this new guest: 
APL
Enter the response of this new guest: either 'yes', 'no', or '?' 
yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
K
Enter the full name of the guest: 
Sally Field
Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Zoe APL maybe
Guest, Zoe APL yes
List, Linc APL yes
Pascal, Blaise APL no
Schmo, Joe APL yes
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
K
Enter the full name of the guest: 
Elena Zaitsoff
Guest does not exist

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
M
Enter the full name of the first guest: 
Joe Schmo
Enter the full name of the second guest: 
Suzy Queue

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
K
Enter the full name of the guest: 
Suzy Queue
Keys, Qwerty IBM no
Nerd, Ura IBM maybe
Schmo, Joe APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
K
Enter the full name of the guest: 
Joe Schmo
Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Guest, Zoe APL yes
List, Linc APL yes
Pascal, Blaise APL no
Queue, Suzy IBM no
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
L
Field, April APL maybe
Field, Electromagnetic APL maybe
Field, Sally APL maybe
Field, Zoe APL maybe
Geek, Ima DGT no
Guest, Sally DGT no
Guest, Zoe APL yes
Keys, Qwerty IBM no
Kulate, Cal DGT no
List, Linc APL yes
Nerd, Ura IBM maybe
Pascal, Blaise APL no
Queue, Suzy IBM no
Schmo, Joe APL yes
Windoes, Closda APL yes

Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,
'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,
'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: 
Q

 */
}