# The Monty Hall Paradox experiment

The aim of this little project is to experimentally verify the monty Hall paradox.

### Presentation
The monty Hall Paradox can be presented by this situation : 

You are a TV show candidate. In front of you, 3 doors. Behind one of them, a car. Behind the 2 others, a goat. 

First round, you make a choice and pick a door, without opening it.

The presenter, who knows well behind what door is the car, choose one of the 2 remaining doors, and open it, knowing that a goat is behind it.

You have know a new choice : keep the initial door, or change and take the one the presenter didn't open. 

What would you choose?

This is a statistic problem where the answered seemed very counter-intuitive, pushing me to do this experiment to verify it.

Actually, at the begining you have 1/3 chance that your choosen door is the car door, and the 2 others are equally at 1/3 chance. But then, when the presenter did his choice, your door is always to 1/3 chance, but the fact that you have 2/3 chance to get the car on the rest of the doors doesn't change. And when the presenter chose one of the 2 other doors, let the closed one getting the 2/3 chances.

So, you can run the program who do this process exactly 1000000 time, and we actually get this result.

What is very interesting in this situation is that the information make the proba : a random folk who would just come after the presenter choice would see 2 closed doors, and for him, the choice is 50/50...
