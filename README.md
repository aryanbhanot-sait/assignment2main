# XML Parser Application
----------------------

This application parses XML documents to determine if they are syntactically correct based on XML rules.


## Installation
-----------
1. Download the Parser.jar file
2. Ensure Java is installed on your system
   - To verify, open a terminal and type: java -version
   - If Java is not installed, download and install it

## Usage
-----
1. Open a command prompt/terminal
2. Navigate to the directory containing Parser.jar
3. Run the application using the following command:
   
   java -jar Parser.jar [path_to_xml_file]
   
   Example: java -jar Parser.jar sample1.xml

## Output
------
The application will analyze the XML file and report any syntax issues found:

- If the XML is well-formed, the application will end with no output
- If errors are found, the application will list each error with details about the line number and the nature of the error

## XML Validation Rules
-------------------
The parser checks for the following XML syntax rules:

1. Opening tags must have the format <tag>
2. Closing tags must have the format </tag>
3. Self-closing tags must have the format <tag/>
4. Every closing tag must have a matching opening tag
5. Tags must be properly nested (no intercrossing tags)
6. Tags are case-sensitive
7. XML documents must have one and only one root tag

Aryan Bhanot

Melbourne Marsden

Amrit Reddy

Jasmeet Singh

July 30th 2025
