Basic Swing Example
=======================================================================

## Why? 

Was helping a friend with a project and explaining concepts to them. To make sure
I wasn't giving them bad answers or suggestions I implemented something similar 
to their project while I talked to them. 

## What? 

It's a crappy GUI application that orders burgers, fries, and drinks. It's no 
where near as complicated as some of the stuff I wrote back in college for classes 
but it's not meant to be. It's got some simple examples of JSpinners and JButton 
and JCheckBox mixed in with some ActionListeners to drive the GUI. The part of the 
system that does business logic is seperated into its own class that the GUI calls.

## Ok, Where do I start?

Read the classes in the following:

1. MenuItem
2. Burger
3. Drink
4. Fries
5. OrderingSystem
6. TestOrderingSystem
7. OrderingGUI
8. TestOrderingSystemGUI

If you want to compile and run:

	javac *.java
	java TestOrderingSystem
	java TestOrderingSystemGUI

