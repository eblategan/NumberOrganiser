# NumberOrganiser
## Overview
**NumberOrganiser** project provides an implementation of the `NumberRangeSummarizer` interface.
## Implementation Guide
The `NumberOrganiser` class implements the `NumberRangeSummarizer`, but allows specific implementations for collection and summarizing.
This is done by providing two additional interfaces: `Collector` and `Summarizer`.
### Collectors
Two implementations of `Collector` are provided:
#### IterativeCollector
This is a basic collector using normal iterative code with for loops, etc.
A TreeSet is used to enforce order and to ensure no duplicate elements.
#### StreamCollector
The stream collector utilizes the more advanced Java Streams to simplify creating a collection from the input.
On the stream, filter and deduplication steps are used to supply a clean output.
The TreeSet mentioned above is likely more performant. 
### Summarizers 

#### IterativeSummarizer
A for loop iterates over the array of integers. 
If a sequential pair is detected, a secondary while loop is entered to scan until the end of the sequence, and it produces the summarized pair in the output.

## Caveats

Ranges for negative numbers can possibly look peculiar:
Example: for array input [-6, -5, -4] will produce "-6--4"

Empty inputs are not mentioned but can be handled
Example: for string input "1,4,6,,,8,9" will produce [1, 4, 6, 8, 9]

For single sequential numbers a good question will be whether the input for "1, 2, 5" is to be computed as "1-2, 5" or "1, 2, 5"
For the purpose of this project, it is decided to use the former. 

## Build Instructions
`./gradlew build`

## Testing
JUnit 5 framework is used to test code.
The default methods on interfaces are used to test the multiple implementations for the collectors.
The summarizer interface only has a single implementation, thus only needs one test class.
The `NumberOrganiser` is a combination of implementations, so it only needs to confirm that the implementations are correctly instantiated.

#### Test Command
`./gradlew test`