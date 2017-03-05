[![Build Status](https://travis-ci.org/hugemane/sudoku-solver.svg?branch=master)](https://travis-ci.org/hugemane/sudoku-solver)

# sudoku-solver
Project to solve a Sudoku puzzle and to test the boundaries of how a program can solve it.

Basic idea is to set initial values on a Sudoku puzzle and let the program execute and solve in real time.
This will simply employ a set of algorithms to solve the puzzle. These algorithms will run in parallel.

The design is for a effective pluggable algorithm architecture to be implemented, such that anyone can plug in a new algorithm.
Over time an existing algorithm can be improved and new ones added.

# Goal
Should be able to solve any puzzle, even down to just having 1 number.

