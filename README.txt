Welcome to PokeJava, an Java Wrapper for Pokeapi!

Current version: 0.1

As of now, there is no formal documentation to explain the basics of this project. There are plans to add a documentation for this wrapper in the future.
For now this README will be used to track progress.

0.1 - Abstract ModelClass added that handles extracting the API and using JSON to parse code.
	Pokemon class has basic functionality and all necessary properties. Looking to delve deeper into the class once basic functionality works in all other major API
	objects. This includes adding types, Pokemon relationships, moves, etc.
	TODO: 
		
	
	TODO for 0.2: Add types, pokemon relationships classes, finish Pokemon class - Completed

0.2 - Changed JSON parser from quick-json to org.json. Added evolution hierarchy. Added Types & Finished Pokemon Class
	- Fixed issue with Type class recursively iterating through itself
	-
		
	
	TODO for 0.3: Add Abilities, Egg groups, Moves - Completed
	TODO:
		Add:
			- Abilities class - Done
			- Egg Groups class - Done
			- Pokemon:
				- Evolution relationships - Done
				- Male/Female ratio - Done
			- Moves class - Done
			- Types - Done
			- Pokedex
			- Description
			- Sprite
			- Game
		- Change the ArrayList returns from being null if empty to giving the user an exception/empty ArrayList
		- Implement Types and Abilities in Pokemon Class
		- Move Name, Created, Modified, etc. to ModelClass. Run super() instead in subclasses
			- Move accessor methods to ModelClass as well