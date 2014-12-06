Assessment2
===========

GEOG5561M Assessment 2 Project


Imagine someone lets off a biological weapon in the middle of a town on top of a building. The bacteria it releases is deadly on contact, and you, as a member of a secret government anti-terrorist unit want to trace where it goes so you can deal with the contamination. You need to build a model of the spread so you can estimate the location of the bacteria.

You have a map of the area in a file. It contains the point at which the bomb has been let off. You also know the probabilities of the bacteria being blown in any given direction, and the rate at which is will fall from the sky.

Imagine your map has north at the top, and east to the right. From a given location, there is a 5% chance that in any given minute, given the current wind, that a particle will blow west, a 10% chance of blowing north or south, and a 75% chance of blowing east. One model iteration is one second, and each model iteration the longest potential movement is one pixel on screen, which is 1 metre's length.

The building is 75m high. If the particle is above the height of the building there is a 20% chance each second it will rise by a metre in turbulance, a 10% chance it will stay at the same level, and an 70% chance it will fall. Below the height of the building the air is still, and the particles will drop by a metre a second.

Build a program to do the following...

    Pull in the data file and finds out the bombing point.

    Calculates where 5000 bacteria will end up.

    Draws a density map of where all the bacteria end up as an image and displays it on the screen.

    Saves the density map to a file as text.

The basic algorithm is, for each particle, to move the particle up and along in a loop that picks randomly the way it will go. When it hits the ground, you make a note of where it hit by incrementing a 2D array by one, and start with the next particle.

Additional marks are awarded for the following.

Allowing the user to set the number of particles and windspeed-based probabilities. Allowing a mouse click to determine the initial position on the map.

Files for this project.

1 (300 by 300) raster file representing the bombing point. The file is laid out at one line per image line, from the top left to bottom right of the raster file.

    300 x 300 pixel raster file containing the location of the bomb: wind.raster (GIF version for comparison - this should not be used in the project). Each line in the file is a line in the raster image, starting at the top left corner. The point is marked by the number 255, with the background marked by the number zero.

Note that any buildings are considered not to effect the flow of this deadly agent, hence they don't appear on the raster. 