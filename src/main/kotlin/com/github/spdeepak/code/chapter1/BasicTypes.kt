package com.github.spdeepak.code.chapter1

fun main(args: Array<String>) {


	//NUmbers: Integer

	val oneMillion = 1_000_000 //immutable if val keyword is used to create variables
	println("One Million: $oneMillion")

	var oneBillion = 1_000_000_000 //mutable if var keyword is used to create variables
	println("One Billion: $oneBillion")

	oneBillion = "1000000000".toInt()
	println("One Billion: $oneBillion")

	//Assign Data type to variables while creating them

	val oneHundred: Int = 100
	println("Explicitly stating the data type of variable oneHundred ($oneHundred)")

	//Numbers: Long

	val oneHundredLong = 100L
	println("One Hundred Long: $oneHundredLong. Type: ${oneHundredLong.javaClass}")


	//Numbers: Long

	val oneHundredFloat = 100f
	println("One Hundred Long: $oneHundredFloat. Type: ${oneHundredFloat.javaClass}")


	//Numbers: Long

	val oneHundredDouble = 100.00
	println("One Hundred Long: $oneHundredDouble. Type: ${oneHundredDouble.javaClass}")


	//String

	val firstName = "Deepak"
	println("First name of the author is $firstName")
	println("Length of the First name of the author is ${firstName.length}")
	println("First Letter of the first name of the author is: ${firstName.get(0)}")
	println("First Letter of the first name of the author is: ${firstName[0]}")
	println("Last Letter of the first name of the author is: ${firstName.get(firstName.length - 1)}")
	println("First name of the author without the first 2 letters: ${firstName.drop(2)}")
	println("First name of the author without the last 2 letters: ${firstName.dropLast(2)}")
	println("First 2 characters from the first name of the author are: ${firstName.take(2)}")

	val myArray = arrayOf('A', 'B', 'C', 'D')
	println("Size of array is: ${myArray.size}")
	println("Element at first index: ${myArray.get(0)}")
	println("Element at first index: ${myArray[0]}")
	println("First Element: ${myArray.first()}")
	println("Last Element: ${myArray.last()}")
	println("Index of A: ${myArray.indexOf('A')}")

	val partArray = myArray.copyOfRange(0, 2)
	println("Part Array")
	println("Size of array is: ${partArray.size}")
	println("Element at first index: ${partArray.get(0)}")
	println("Element at first index: ${partArray[0]}")
	println("First Element: ${partArray.first()}")
	println("Last Element: ${partArray.last()}")

	//Create an Array of size 5 which calculates the square of the given index
	var squareArray = Array(5, { x -> x * x })
	println("Square of 4 is ${squareArray[4]}")

	val newArray: Array<Int> = arrayOf(1, 2, 3, 4)
	println("New Array")
	println("Size of array is: ${newArray.size}")
	println("Element at first index: ${newArray.get(0)}")
	println("Element at first index: ${newArray[0]}")
	println("First Element: ${newArray.first()}")
	println("Last Element: ${newArray.last()}")


	//Boolean values
	var isItTrue: Boolean = true
	isItTrue = false

	//Char
	val a = 'a'
	val A = 'A'

	//Multiline strings
	val multilineStrings = """This is a multiline string
		This is the second line
    """.trimIndent()

	println("$multilineStrings")

	//To represent a literal $ sign in a string
	val p = "$9.69"
	println("$p")
	val price = """${'$'}9.99"""
	println("Price: $price")
	println("Printing $ sign as a prefix to a text in kotlin can be done like this $9.99")

	//create ranges from one number to another
	val oneToTenInt = 1..10 //Int Range
	println("${oneToTenInt.javaClass}")

	val oneToTenLong = 1L..10L
	println("${oneToTenLong.javaClass}")

}