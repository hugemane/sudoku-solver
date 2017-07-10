[![Build Status](https://travis-ci.org/hugemane/sudoku-solver.svg?branch=master)](https://travis-ci.org/hugemane/sudoku-solver)

# sudoku-solver
Project to solve a Sudoku puzzle and to test the boundaries of how a program can solve it.

Basic idea is to set initial values on a Sudoku puzzle and let the program execute and solve in real time.

Attempting to have a set of "Machine Intelligences" do their part to solve their individual problems.
By combining all the individual parts - the whole should be solved.

"Machine Intelligences" could employ an algorithm or not to solve the puzzle. 
Each of these "Machine Intelligences" run in parallel.

The design is for a effective pluggable solution (Machine Intelligence) architecture to be implemented, 
such that anyone can plug in a new solution. Over time an existing solution can be improved and new ones added.

# Goal
Should be able to solve any puzzle, even down to just having 1 number.

