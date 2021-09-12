# String Calculator

## 1. Create a simple String calculator with a method: int Add(string numbers) 
* (https://github.com/GabrielAzevedo88/String-Calculator/commit/9909ff48dca7c80dd4f32c1803a8087e0b531678)
1. The numbers in the string are separated by a comma.
2. Empty strings should return 0. \n
3. The return type should be an integer.
4. Example input: “1,2,5” - expected result: “8”.
5. Write tests to prove your input validates.


## 2. Change the Add method to handle new lines in the input format 
* (https://github.com/GabrielAzevedo88/String-Calculator/commit/e53a2926ce043d90ac3c1ed783b74bf56cbf2f37)
1. Example: “1\n,2,3” - Result: “6”
2. Example 2: “1,\n2,4” - Result: “7”
 
## 3. Support a custom delimiter * 
(https://github.com/GabrielAzevedo88/String-Calculator/commit/1b9343b8f3e449c803b1921911984c63bf5e18bd)
1. The beginning of your string will now contain a small control code that lets you
set a custom delimiter.
2. Format: “//[delimiter]\n[delimiter separated numbers]”
3. Example: “//;\n1;3;4” - Result: 8
4. In the above you can see that following the double forward slash we set a
semicolon, followed by a new line. We then use that delimiter to split our
numbers.
5. Other examples
  * “//$\n1$2$3” - Result: 6
  * “//@\n2@3@8” - Result: 13

## 4. Calling add with a negative number should throw an exception: “Negatives not allowed”. 
* (https://github.com/GabrielAzevedo88/String-Calculator/commit/e783bd0cf064e372fb9f67110a5113819e79ed80)
1. The exception should list the number(s) that caused the exception

## Bonus 
* (https://github.com/GabrielAzevedo88/String-Calculator/commit/1311bf280565a7c4e3b53187f920160f4d541b5f)
1. Numbers larger than 1000 should be ignored.
    * Example “2,1001” - Result: 2
2. Delimiters can be arbitrary length
    * “//***\n1***2***3” - Result 6
3. Allow for multiple delimiters
    * “//$,@\n1$2@3” - Result 6
4. Combine 2 and 3 bonus questions. Allow multiple delimiters of arbitrary length
