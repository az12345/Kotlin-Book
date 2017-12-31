package com.github.spdeepak.code.chapter3

fun main(args: Array<String>) {
	var max = 1
	println("value of max: $max")
	if (1 < 2) max = 2
	println("value of max: $max")

	val min = if (1 < 2) {
		1
	} else {
		2
	}
	println("Value of min: $min")

	val a = 100
	val b = 101
	if (a > b) {
		println("a > b")
	} else {
		println("a < b")
	}
}