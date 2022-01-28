# SudokuSolved 
This program will solve any valid sudoku puzzle. Currently, it is configured to solve the puzzle below, the "hardest" puzzle 
sudoku puzzle known created by Finnish mathematician, Arto Inkala. It scores an 11 star hardness rating (sudoku usually goes from
1 to 5 stars, 5 being hardest).

<img src="http://abcnews.go.com/images/US/ht_level_11_sudoku_jef_120629_wblog.jpg" width="350"/>

For this particular input, the program takes input of 21 numbers (this is the number of numbers in the sudoku at the start)
each with 3 digits. The 1st digit i corresponds to the ith row in the sudoku (0<i<9), the 2nd digit j corresponds to the 
jth column in the sudoku (0<j<9), and the 3rd digit k corresponds to the number that is placed at the ith row and jth column.
So to describe the position of the 8 in the top left corner of the above puzzle, you would use 008.

The program will output the solved puzzle to the console looking kinda like this:

\----------------------------<br>
| 8 1 2 | 7 5 3 | 6 4 9 |<br>
| 9 4 3 | 6 8 2 | 1 7 5 |<br>
| 6 7 5 | 4 9 1 | 2 8 3 |<br>
\----------------------------<br>
| 1 5 4 | 2 3 7 | 8 9 6 |<br>
| 3 6 9 | 8 4 5 | 7 2 1 |<br>
| 2 8 7 | 1 6 9 | 5 3 4 |<br>
\----------------------------<br>
| 5 2 1 | 9 7 4 | 3 6 8 |<br>
| 4 3 8 | 5 2 6 | 9 1 7 |<br>
| 7 9 6 | 3 1 8 | 4 5 2 |<br>
\----------------------------<br>

<h2>Compilation Steps</h2>

There are two ways to compile and run this program.
<ul>
  <li>First clone the repository (obviously)</li>
  <li>Next either load the project into your favorite IDE and configure/set the src folder and output path (if using intellij, not 
  sure about other IDEs) or remove the package statements at the top of the two files and compile and run using javac and java
  from the command line</li>
</ul>
