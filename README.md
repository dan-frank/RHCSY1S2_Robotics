# CS1822 Robotics Group 32

## Members

- Daniel [dan-frank](https://github.com/dan-frank)
- Lewes [lblockrhul](https://github.com/lblockrhul)
- Rumen [ragnar764](https://github.com/ragnar764)
- Megan [meganhardman](https://github.com/meganhardman)

## Rube's Rubiks Plan

- [x] Initialise Rube!
- [ ] Motors
	- [x] Flip cube
		- [x] Flip cube
		- [x] Pin Cube
		- [x] Return to default
	- [x] Rotate cube
		- [x] Rotate cube 90deg clockwise
	- [ ] Scan colour
		- [ ] Lift sensor
			- [ ] (2, 2)
			- [ ] (2, 3)
			- [ ] (1, 3)
			- [ ] (1, 2)
			- [ ] (1, 1)
			- [ ] (2, 1)
			- [ ] (3, 1)
			- [ ] (3, 2)
			- [ ] (3, 3)
		- [ ] Return to default
- [ ] Store colours in
- [x] Link [cs0x7f's rubiks algorith](https://github.com/cs0x7f/min2phase)
- [ ] Read if cube is put in
- [x] Program cube moves
- [ ] Show Rube's face while solving Cube


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

**U**: Upper/Top = White

**L** : Left = Green

**F**: Front = Red

**R**: Right = Blue

**B**: Back = Orange

**D**: Down/Bottom = Yellow

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
