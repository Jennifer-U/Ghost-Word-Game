# Ghost Word Game

Multi-player implementation of the classic word game GHOST in Java.

**Course:** Object-Oriented Programming (Java) - 2023

## Game Rules
- Players take turns adding letters to build a word fragment
- If a player completes a word (4+ letters) or creates an invalid sequence, they lose the round
- Players can challenge with `*` if they believe no valid word exists
- Losing a round adds a letter from "GHOST" to the player's score
- Players are eliminated after collecting all five letters (G-H-O-S-T)
- Last player remaining wins

## Implementation

**Player Class** (`Player.java`)
- Tracks player name and accumulated letters
- Methods: `loseRound()`, `isEliminated()`, `toString()`
- Private fields with proper encapsulation

**Ghost Class** (`Ghost.java`)
- Game loop handling rounds and player turns
- Word validation using dictionary file (`words.txt`)
- Player rotation and elimination logic
- Challenge mechanic implementation

## Features
- Support for 2+ players
- Automatic player elimination tracking
- Round-by-round progression with rotating first player
- Dictionary-based word validation (279,496 words)

## How to Run
```bash
javac GhostProject/*.java
java GhostProject.Ghost
```

Requires `words.txt` dictionary file in the `GhostProject` directory.

## Credits
Base game logic adapted from Professor Oren Steinberg's provided partial Ghost.java code. Extended with Player class and full game mechanics (elimination, multi-round play, victory conditions).
