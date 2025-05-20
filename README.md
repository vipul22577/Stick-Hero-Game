JavaFX Application Structure : The code defines a JavaFX application named hello application. In JavaFX, applications are typically structured around the Application class, and the start  method is the entry point for the application.The application opens with a login screen allowing users to enter their credentials.Intro Audio: An introductory audio is played when the application starts.Inside the start method, a JavaFX  is created and initialised with the content loaded from an FXML file . The scene is then set on a JavaFX, which represents the main window of the application.Finally the application sets the title for the stage and makes the stage visible and displays the login screen.
Assuming that thers as an fxml named helloview in the same package as the hello application class ,the project structure might look like this.

There are different classes in this project : 

# deisgn pattern used
1)Singleton
it is implemented in GameAnimation class
2)Command Pattern. In the Command Pattern, behavior is encapsulated in objects, and these objects are decoupled from the sender and the receiver. Each method in your class represents a specific command, and the objects (commands) encapsulate these actions. This pattern allows for parameterizing objects with operations, queuing operations, and supporting undoable operations. it is implemented in enterGame Controller
1.Hello Application: 
3)4)Hellocontroller Factory design pattern : A Controller Factory would have a method that takes a controller type as an argument and returns the corresponding controller instance. The hellocontroller class could serve as a base class, and specific controller implementations could extend it. For instance, there might be controllers for different themes or game levels.

The `HelloApplication` class is the main entry point for the AP Final Project application. It sets up the initial stage, loads the login screen, and plays an intro audio.

Class Methods

start(Stage stage)`

The `start` method is the entry point for the JavaFX application. It initializes the stage, loads the login screen using FXML, and sets up the scene.

`main(String[] args)`

The `main` method is the entry point for launching the JavaFX application.

2.Hellocontroller: 


The `HelloController` class is a controller for the login screen in the AP Final Project. It handles button actions, such as entering the game and exiting the application.

Class Properties

- `welcomeText`: A label displaying a welcome message.
- `exitbutton`: A button for exiting the application.
- `pane`, `stackPane`, `anchorPane`: Various panes used in the UI.
- `stage`, `scene`, `root`: JavaFX stage, scene, and root elements for managing UI transitions.

 Class Methods

`exitTheGame()`

Handles the action of exiting the game. Displays a confirmation dialog and closes the application if confirmed.

enterTheGame()`

Handles the action of entering the game. Transitions to the theme selection view.

`onHelloButtonClick()`

Handles the action when the "Hello" button is clicked. Updates the welcome text.

 Usage

1. Attach this controller to your FXML file:

   ```fxml
   <fx:controller="com.example.apfinalproject.HelloController">




3.Enter Game Controller: 

 Overview

The `enterGameController` class is a controller for the game entry screen in the AP Final Project. It handles button actions to start different game modes and provides a method to set and display scores.

Class Properties

Player  Represents the player associated with the game.
`image1 image2 image3 selectedImage Images associated with the game.
scene `stage JavaFX scene and stage for handling UI.
scores.
-bhutiya jungle aqua`: Buttons for selecting different game themes.

 Class Methods

getBackToLoginScreen(ActionEvent event)`

Navigates back to the login screen.

`bhutiyaEnterTheGame(ActionEvent event) jungleEnter




4.Flyer: 

 Overview

The `Flyer` class represents a flyer entity in the context of the AP Final Project. It contains properties such as height, position, and an associated image.

Class Properties

- `height`: Represents the height of the flyer.
- `position`: Represents the position of the flyer.
- `img`: Represents the image associated with the flyer.

 Class Methods

getHeigth()`

Returns the height of the flyer.

setHeigth(int height)`

Sets the height of the flyer to the specified value.

`getPositon()`

Returns the position of the flyer.

`setPositon(int position)`

Sets the position of the flyer to the specified value.

Usage

Create an instance of the `Flyer` class:

   Flyer flyer = new Flyer();



5.Block: 

Overview

The `Block` class represents a block element in the context of the AP Final Project. It is associated with a graphical rectangle and includes methods for generating random width and initial position, moving backward, and finishing the block animation.

 Class Properties

- `rect`: Represents the graphical rectangle associated with the block.
- `pane`: Represents the JavaFX pane on which the block is placed.

Class Methods

Block(Pane pane)`

Constructor that initialises the block with a random width and position on the provided JavaFX pane.

`GenerateWidth()`

Generates a random width for the block.

`GenerateX()`

Generates a random initial position for the block.

GetX()`

Returns the current x-coordinate of the block.

`GetWidth()`

Returns the width of the block.




6.Bhutya: 

 Overview

The `Bhutiya` class is part of the AP Final Project and implements the `Theme` interface. It represents the Bhutiya theme, featuring an associated image.

 Class Properties

- `image`: Represents the image associated with the Bhutiya theme.

`applyTheme()`

This method is part of the `Theme` interface and is responsible for applying the Bhutiya theme. Specific theme-related logic can be implemented in this method.

Usage

 Create an instance of the `Bhutiya` class, providing an `Image`:

7.Assassin: 

 Overview

The `Assassin` class represents an assassin entity in the context of the AP Final Project. It contains properties such as position and speed, along with getter and setter methods to access and modify these properties.

 Class Properties

- `position`: Represents the current position of the assassin.
- `speed`: Represents the speed of the assassin.

 Class Methods

`getPosition()`

Returns the current position of the assassin.

 `setPosition(int position)`

Sets the position of the assassin to the specified value.

 `getSpeed()`

Returns the speed of the assassin.

setSpeed(int speed)`

Sets the speed of the assassin to the specified value.





8.Aqua:

Overview

This project is part of the AP Final Project and implements an Aqua theme using JavaFX. The Aqua theme is represented by the `Aqua` class, which implements the `Theme` interface.

Features

- Aqua-themed user interface elements.
- Integration with JavaFX for graphical representation.
- Customizable Aqua theme properties.

9.Game Animation: 

Overview

The `gameAnimation` class is part of the AP Final Project and represents the main game logic. It includes animations, scoring, and transitions between scenes.

 Class Properties

- `score`: Represents the current game score.
- `rewardscore`: Represents the score obtained from rewards.
- `choicebg`: Represents the chosen background theme for the game.
- `highestSCore`: Represents the highest score achieved.
- `lastScore`: Represents the score obtained in the last game.
- `stage`: Represents the JavaFX stage.
- `isAnimationInProgress`: AtomicBoolean to track whether an animation is in progress.

 Class Methods

`gameAnimation(int themechoice, int reload)`

Constructor that initializes the game with the chosen theme and reloads the game if specified.

`setsc(int reload)`

Sets the initial score based on the reload parameter and reads the highest, last, and reward scores from a file.

`start(Stage primaryStage)`

The main entry point for the game. Initializes the game scene, displays the score, and starts the game loop.

14.GameMAin: 


The `Gamemain` class represents the main game management logic in the AP Final Project. It includes functionality for managing players, tracking game statistics, starting new games, saving games, and loading games.

 Class Properties

- `currentPlayer`: Represents the current active player.
- `players`: An ArrayList to store the players participating in the game.
- `maxScore`: Represents the maximum score for the game.

 Class Methods

getCurrentPlayer()`, `setCurrentPlayer(Player currentPlayer)`

Getter and setter methods for accessing and modifying the current active player.

`getPlayers()`, `addPlayers(Player player)`

Getter method for accessing the list of players and a method to add a player to the list.

`checkPlayer(Player player)`

Checks if a given player is in the list of players.

 `showStats()`

Displays game statistics.

`newGame()`

saveGame()`

Saves the current game state.

setMaxScore(int maxScore)`, `getMaxScore()`

Setter and getter methods for the maximum score.

`loadGame()`
