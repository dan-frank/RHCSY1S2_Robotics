# CS1822 Robotics Group 32

## Members

- Daniel [dan-frank](https://github.com/dan-frank)
- Lewes [lblockrhul](https://github.com/lblockrhul)
- Rumen [ragnar764](https://github.com/ragnar764)
- Megan [meganhardman](https://github.com/meganhardman)

## What is each file?

- **BehaviourEndController** - This behaviours handles the ending/finishing/shutting down process of the robot based off of is escape button was pressed, the battery is low, or the cube has been solved 

- **BehaviourMoveActionBack** - This behaviour handles moving the 'back' face of the Rubik's Cube

- **BehaviourMoveActionDown** - This behaviour handles moving the 'down' face of the Rubik's Cube

- **BehaviourMoveActionFront** - This behaviour handles moving the 'front' face of the Rubik's Cube

- **BehaviourMoveActionLeft** - This behaviour handles moving the 'left' face of the Rubik's Cube

- **BehaviourMoveActionRight** - This behaviour handles moving the 'right' face of the Rubik's Cube

- **BehaviourMoveActionUp** - This behaviour handles moving the 'up' face of the Rubik's Cube

- **BehaviourMoveController** - This behaviour handles which move action to trigger depending on the list of moves provided to solve the cube

- **BehaviourRunningController** - This behaviour will start and pause the robot depending on if the cube is in the cage

- **BehaviourScanActionBack** - This behaviour will move the colour sensor to the 'back' position of the cube

- **BehaviourScanActionCenter** - This behaviour will move the colour sensor to the 'center' position of the cube

- **BehaviourScanActionCorner** - This behaviour will move the colour sensor to the 'corner' position of the cube

- **BehaviourScanActionEdge** - This behaviour will move the colour sensor to the 'edge' position of the cube

- **BehaviourScanController** - This behaviour handles which move scan action to trigger depending specific order to scan the cube

- **BehaviourSolveController** - This behaviour handles solving the cube and is triggered when the cube has been scanned successfully

- **FriendCube** - This object handles variables and states that need to be passed between specific behaviours, typically higher level behaviours

- **FriendMove** - This object handles variables and states that need to be passed between specific behaviours, typically cube manipulating behaviours 

- **FriendScan** - This object handles variables and states that need to be passed between specific behaviours, typically colour focused behaviours

- **Main** - This initialises all the behaviours, motors and sensors and starts the robot

- **MotorColour** - This is motor that controls the position of the colour sensor

- **MotorFlip** - This motor controls the flipping mechanism that flips the cube

- **MotorRotate** - This motor controls the rotating mechanism that rotates the cube

- **StateCube** - This enum declares the state of the cube

- **StateCubeExists** - This enum declares the state of the cube's existance

- **StateFlip** - This enum declares the state for the flip action

- **StateMoveAction** - This enum declares the state for the move action 

- **StateMoveColourAction** - This enum declares the state for the colour motor action

- **StateRotate** - This enum declares the state for the flip motor action

- **StateScan** - This enum declares the state for for triggering the colour sensor 

- **solve/\*** - This folder and all code inside contains the algorithm to solve the rubiks cube

## Rube's Rubiks Plan

- [x] Initialise Rube!
- [x] Motors
	- [x] Flip cube
		- [x] Flip cube
		- [x] Pin Cube
		- [x] Return to default
	- [x] Rotate cube
		- [x] Rotate cube 90deg clockwise
	- [x] Scan colour
		- [x] Move sensor to
			- [x] Center
			- [x] Edge
			- [x] Corner
		- [x] Return to default
- [x] Store colours
- [x] Link [cs0x7f's rubiks algorith](https://github.com/cs0x7f/min2phase)
- [x] Read if cube is put in
- [x] Program cube moves
- [x] Show Rube's face while solving Cube
- [x] Make everything a behaviour

### Behaviours

- MotorColour
- MotorFlip
- MotorRotate
- Scan
- Solve
- Move

#### Friends

- Cube (Scan, Solve, Move)
	- Variable
		- Scrambled Cube
		- Solved Moves
	- States
		- unread (Scan)
		- read (Solve)
		- solved (Move)
		- complete (Special move)
- Colour (Scan, MotorColour)
	- States 
		- Move motor colour
			- Sub-states
				- Centre
				- Edge
				- Corner
				- Back
		- Read sensor colour
			- Sub-states
				- Read
				- Don't Read
- MoveCube (Scan, Move, MotorRotate, MotorFlip)
	- States
		- Move motor rotate
			- Sub-states
				- Clockwise
				- Anti-clockwise
				- U-turn
		- Move motor flip
			- Sub-states
				- Pin
				- Retract
				- Flip

### Colours Array

#### The Cube

```
/**
 *
 *             |************|
 *             |*U1**U2**U3*|
 *             |************|
 *             |*U4**U5**U6*|
 *             |************|
 *             |*U7**U8**U9*|
 *             |************|
 * ************|************|************|************|
 * *L1**L2**L3*|*F1**F2**F3*|*R1**R2**R3*|*B1**B2**B3*|
 * ************|************|************|************|
 * *L4**L5**L6*|*F4**F5**F6*|*R4**R5**R6*|*B4**B5**B6*|
 * ************|************|************|************|
 * *L7**L8**L9*|*F7**F8**F9*|*R7**R8**R9*|*B7**B8**B9*|
 * ************|************|************|************|
 *             |************|
 *             |*D1**D2**D3*|
 *             |************|
 *             |*D4**D5**D6*|
 *             |************|
 *             |*D7**D8**D9*|
 *             |************|
 * 
 */
 ```

#### The cube will be read by the algorithm in the following string:

`"U1 U2 ... U9 R1 ... R9 F1 ... F9 D1 ... D9 L1 ... L9 B1 ... B9"`

#### Our cube will be need to placed in the cage to match the following key:

**U**: Upper/Top = White (0.85)

**L** : Left = Green (0.22)

**F**: Front = Red (0.51)

**R**: Right = Blue (0.13)

**B**: Back = Orange (0.67)

**D**: Down/Bottom = Yellow (0.72)

#### We store the cube into the following array:

```
[
	[U1, U2, U3, U4, U5, U6, U7, U8, U9],
	[R1, R2, R3, R4, R5, R6, R7, R8, R9],
	[D1, D2, D3, D4, D5, D6, D7, D8, D9],
	[L1, L2, L3, L4, L5, L6, L7, L8, L9],
	[B1, B2, B3, B4, B5, B6, B7, B8, B9],
	[F1, F2, F3, F4, F5, F6, F7, F8, F9],
]
```

#### Motor actions to read cube:

Measure

-> Flip -> Measure

-> Flip -> Measure

-> Flip -> Measure

-> Rotate -> Flip -> Measure

-> Flip -> Flip -> Measure

#### Convert array to string in following order

`[0], [1], [5], [2], [3], [4]`

### Ports

#### Motors


Read Cube (*MotorPort A*)

Flip Cube (*MotorPort B*)

Rotate Cube (*MotorPort C*)


#### Sensors

Ultrasonic Sensor (*SensorPort 1*)

Colour Sensor (*SensorPort 2*)

### Test Cubes

`"UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB"`

Moves to solve: ""

`"FUUFUUFUURRRRRRRRRDFFDFFDFFBDDBDDBDDLLLLLLLLLBBUBBUBBU"`

Moves to solve: "L  "

`"DFDUUDRULURLDRBDLRFRFDFLLBBBDRLDBRFFLLUBLFBFUBUFRBUDRU"`

Moves to solve: "U  L2 R2 U2 B2 D' R2 D  B  D2 L' R  U  F' D  F  D' R  F2 "

## Checkpoints

- [x] Checkpoint 1
- [x] Checkpoint 2
- [x] Checkpoint 3
- [x] Checkpoint 4
- [x] Checkpoint 5
