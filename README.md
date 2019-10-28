# Parking Application

## Summary
This project is to be turned in as assignment 3 and 4 for my software design class. The requirements are to maximize the profits for the owners of certain parking lots. For this application, it is designed to be a simple console appllication, using the concept of state machines to transition to and from UIs. The parking lot data is read in as .txt files for ease of access. This project is also heavily revolved around OOP concepts and incorporates inheritance, static variables and methods, and polymorphism.

## Running the Project

This project can be opened by IntelliJ or run in the console window. To change data sets, delete the `parking-database.txt` file inside of the `parking-data` directory, then copy over your dataset of choice from `parking-data-sets` and rename it to `parking-database.txt`.

## Input Text File Format

Each line has an element that is separated by a space. The input text files follows this format:

### Groups

Group, group name, and then group price as float.

```
Group,Group Alpha,10.00
```

### Parking Lots

Parking, parking lot name, group name, capacity as integer, enter gate, exit gate, and default price as float.

```
Parking,Parking Lot 1,Group Alpha,50,Gate A,Gate B,3.00
```

Note that if the app cannot find the group, then it will use the parking lot by default.

### Tickets

Ticket, license plate number, parking lot name, group name, parking space, enter gate, exit gate, amount due as float.

```
Ticket,JOK1545,Parking Lot 1,Group Alpha,4,Gate A,Gate B,10
```

Note that if a ticket does not have an exit gate, then it means that the car has not paid nor exited the parking lot.

## Data Sets for Testing

| Dataset 	| Description                                                          	|
|---------	|----------------------------------------------------------------------	|
| 1       	| Optimal text file that follows the formatting constraints.           	|
| 2       	| Empty file.                                                          	|
| 3       	| Same as data set one but has lots of errors and corrupted data.      	|
| 4       	| Same as data set one, but has lots of duplicates.                    	|
| 5       	| Same as data set 1 but has only groups, no parking lots nor tickets. 	|
