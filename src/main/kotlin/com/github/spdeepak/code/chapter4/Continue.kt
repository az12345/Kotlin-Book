package com.github.spdeepak.code.chapter4

fun main(args: Array<String>) {
	var ints = 50..55

	for (i in 1..100) {
		if (ints.contains(i)) {
			println("Continuing")
			continue
		} else {
			println("Value of i is $i")
		}
	}
}