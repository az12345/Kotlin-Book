package com.github.spdeepak.code.chapter4

fun main(args: Array<String>) {
	var ints = 50..55

	for (i: Int in 1..100) {
		if (ints.contains(i)) {
			return
		}
		println("Value of i is $i")
	}
}