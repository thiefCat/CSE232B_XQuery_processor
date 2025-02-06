#!/bin/bash

# Check for input and output file arguments
if [ $# -ne 2 ]; then
    echo "Usage: ./run.sh <input_file.txt> <output_path>"
    exit 1
fi

INPUT_FILE=$1
OUTPUT_PATH=$2

echo "Compiling the project..."
mvn clean compile

# Step 2: Find the compiled Main.class file
MAIN_CLASS=$(find target/classes -name "Main.class")

# Step 3: Verify if Main.class exists
if [ -z "$MAIN_CLASS" ]; then
    echo "Error: Main.class not found! Compilation might have failed."
    exit 1
fi

# Step 4: Convert file path to package notation (remove 'target/classes/' and replace '/' with '.')
MAIN_CLASS=${MAIN_CLASS#target/classes/}   # Remove 'target/classes/'
MAIN_CLASS=${MAIN_CLASS%.class}            # Remove '.class'
MAIN_CLASS=${MAIN_CLASS//\//.}             # Replace '/' with '.'

echo "Running $MAIN_CLASS with input file: $INPUT_FILE and output path: $OUTPUT_PATH"

# Step 5: Get the classpath including dependencies
CLASSPATH=$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q):target/classes

# Step 6: Run the program with the full classpath
java -cp "$CLASSPATH" "$MAIN_CLASS" "$INPUT_FILE" "$OUTPUT_PATH"


