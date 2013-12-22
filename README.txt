Welcome to PokeJava, an Java Wrapper for Pokeapi!

Current version: 0.6

As of now, there is no formal documentation to explain the basics of this project. There are plans to add a documentation for this wrapper in the future.
For now this README will be used to track progress.

0.1 - Abstract ModelClass added that handles extracting the API and using JSON to parse code.
	Pokemon class has basic functionality and all necessary properties. Looking to delve deeper into the class once basic functionality works in all other major API
	objects. This includes adding types, Pokemon relationships, moves, etc.
		
	
	TODO for 0.2: Add types, pokemon relationships classes, finish Pokemon class - Completed

0.2 - Changed JSON parser from quick-json to org.json. Added evolution hierarchy. Added Types & Finished Pokemon Class
	- Fixed issue with Type class recursively iterating through itself
		
	
	TODO for 0.3: Add Abilities, Egg groups, Moves - Completed

0.3 - Added Move, EggGroup, and Ability. Working on moving the standard properties to the ModelClass and having them defined there.

	TODO for 0.4: Add Abilities, Egg Groups, Moves, and Types to Pokemon class as properties. Add toString() & printInfo() - Completed
	TODO:
		- Add toString() and printInfo() to each class - Completed
		
0.4 - Added Abilities, Egg Groups, Moves, and Types to Pokemon Class as properties. Added toString() and printInfo()

	TOOD for 0.5: Add Pokedex, Description, Sprite, Game
	TODO:
		Add:
			- Pokedex - Completed
			- Description - Completed
			- Sprite - Completed
			- Game - Completed

			
0.5 - Added Pokedex, Description, Sprite, Game
	TODO for 0.6 - Documentation and commenting
	TODO:

		- Implement Types and Abilities in Pokemon Class - Completed
		- Move Name, Created, Modified, etc. to ModelClass. - Completed
			- Move accessor methods to ModelClass as well - Completed
			
0.6 - All classes complete
	TODO for 1.0 - Proper documentation and commenting. Fixing all previous problems. Faster JSON Parsing*. Tester Class
	TODO:
			- Change the ArrayList returns from being null if empty to giving the user an exception/empty ArrayList - Completed, need to test
			- Documentation
			- Commenting
			- Tester
			- *Faster JSON - Only if feasible. - Completed
			- Change created, modified to datetime
		
	Add to docs:
			- information about hasEvolution()
			- EvolutionLevel
			 - LearnType - not useful outside scope of Pokemon Object