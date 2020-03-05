File: README.MD
Assignment: PA1
Author: John A. Herrmann
Class: EN.605.621.82.SP20 Foundations of Algorithms
Date: 3/2/2020
-----------------------------------------------------------
           Programming Assignment 1
            Table of Contents
            (1) Folder Structure 
            (2) Development Environment 
            (3) Executing the Code & Sample Outputs
-----------------------------------------------------------
            Section 1: Folder Structure

About: The following section details the structure of the 
        project folder

HerrmannAssignment1.zip Folder Structure

./README.MD                              <----- You are here
./documentation
   |_____HerrmannAssignment1Report.docx  <----- Report is here
   |_____UML
               |___umlDiagrams.pdf
./source
   |_____/bin                                    //Ignore
   |_____/src                                    //Ignore
   |_____/doc                                    //Ignore
   |_____/assignment1
             |_______/bin
             |_______/doc
             |_______/src
                        |_____/closestPairs   <----- Part 1 Source
                        |_____/turingMachine/ <----- Part 2 Source

./inputs    <--------------------------------------- Example Inputs
    |____/FindClosestPairs
    |____/RunExampleDTM
    |____/RunAdditionDTM
    |____/RunSubtractionDTM
    |____/RunMultiplicationDTM
    
./outputs   <--------------------------------------- Example Outputs
    |____/FindClosestPairs
    |____/RunExampleDTM
    |____/RunAdditionDTM
    |____/RunSubtractionDTM
    |____/RunMultiplicationDTM

-----------------------------------------------------------
            Section 2: Development Environment

Eclipse IDE: Version: 2019-12 (4.14.0)
             Build id: 20191212-1212

Java Compiler: 13.0.2
Jave Version: Java SE 13.0.2
Version Control: Git

_____________________________________________________________
            Section 3: Executing the Code

       ----Section 3a: Importing Code into Eclipse----

Disclaimer: Using Eclipse has been a painful experience
            so far. For some reason, the code compiles and runs
            in Eclipse... however, I can't get my code to run 
            in Terminal. 

            As a result, to test this code, you will need to
            do so in Eclipse. 

    Step 1: Download Eclipse 2019-12
    Step 2: Download Java Compiler 13.0.2
    Step 3: Ensure Eclipse is using 2019-12
    Step 4: Open Eclipse
    Step 5: Set Working Environment
    Step 6: Using your mouse, click on File -> Import
    Step 7: Using your mouse, click General -> Projects From Folder or Archive
    Step 8: Click "Next"
    Step 9: In the "Import Projects From Folder or Archive" Window, click "Import Source"
    Step 10: Navigate to /source/assignment1
    Step 11: Click Finish

        ----Section 3b: Running FindClosestPairs ----

    Precondition 1: Steps 3A 1-11 completed successfuly
    Precondition 2: User is currently using Eclipse 

    Step 1: [In Eclipse Project Explorer] Navigate to src/closestPairs

    For each INPUT in inputs listed in /inputs/FindClosestPairs : 
        Step 2A: [In Eclipse Project Explorer] Left click on FindClosestPairs
        Step 2B: [In pop-up window] Click 'Run As'-> 'Run Configurations'
        Step 2C: [In dialog window] Click 'Java Application'
        Step 2D: [In dialog window] Click 'Launce New Configuration'
        Step 2E: [In dialog window] Choose Main Class: closestPairs.FindClosestPairs
        Step 2F: [In dialog window] Click "Arguments" tab
        Step 2G: Copy-and-paste INPUT from /inputs/FindClosestPairs/input.txt into
                ... 'Program Arguments'
        Step 2H: Click "Run" radio button at the botton-right corner of dialog box
        Step 2I: Observe the program execution in console window
        Step 2J: Compare the console output with the corresponding output in:
                 /outputs/FindClosestPairs/output.txt

    ----Section 3c: Running RunExampleDTM ----
        Follow the steps in 3b with the notable exception: 
        (1) INPUT should come from /inputs/RunExampleDTM/input.txt
        (2) Main Class: turingMachine.RunExampleDTM
        (3) Corresponding outputs can be found in /outputs/RunExampleDTM/output.txt

    ----Section 3d: Running RunAdditionDTM ----
        Follow the steps in 3b with the notable exception: 
        (1) INPUT should come from /inputs/RunAdditionDTM/input.txt
        (2) Main Class: turingMachine.RunAdditionDTM
        (3) Corresponding outputs can be found in /outputs/RunAdditionDTM/output.txt

    ----Section 3e: Running RunSubtractionDTM ----
        Follow the steps in 3b with the notable exception: 
        (1) INPUT should come from /inputs/RunSubtractionDTM/input.txt
        (2) Main Class: turingMachine.RunSubtractionDTM
        (3) Corresponding outputs can be found in /outputs/RunSubtractionDTM/output.txt
    
    ----Section 3f: Running RunMultiplicationDTM ----
        Follow the steps in 3b with the notable exception: 
        (1) INPUT should come from /inputs/RunMultiplicationDTM/input.txt
        (2) Main Class: turingMachine.RunMultiplicationDTM
        (3) Corresponding outputs can be found in /outputs/RunMultiplication/output.txt