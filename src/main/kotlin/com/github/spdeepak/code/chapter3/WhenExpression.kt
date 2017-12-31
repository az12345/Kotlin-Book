package com.github.spdeepak.code.chapter3

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
	//When is similar to case in Java/C

	val x = 1
	when (x) {
		1 -> println("X is 1")
		2 -> println("X is 2")
		else -> { //You can create code blocks with braces as well
			println(" X is neither 1 or 2")
		}
	}

	when (x) {
		0, 1 -> println("X==0 or X==1")
		else -> println("X is $x")
	}

	val s = "1"
	when (x) {
		parseInt(s) -> println("s encodes x")
		else -> println("s does not encode x")
	}

	val validNumbers: Array<Int> = arrayOf(1, 2, 3)
	val y = 12
	when (y) {
		in 1..10 -> println("x is in the range")
		in validNumbers -> println("x is valid")
		!in 10..20 -> println("x is outside the range")
		else -> println("None of the above")
	}
}