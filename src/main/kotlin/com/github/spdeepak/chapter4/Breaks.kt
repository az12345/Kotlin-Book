package com.github.spdeepak.chapter4

fun main(args: Array<String>) {
	var ints = 50..55

	for (i in 1..100) {
		println("Value of i is $i")
		if (ints.contains(i)) {
			break
		}
	}
}