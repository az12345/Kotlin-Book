package com.github.spdeepak.chapter3

fun main(args: Array<String>) {
	val collection: Collection<String> = listOf("Shoe", "Bag", "Phone")
	for (item in collection) println("$item")

	val ints: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	for (int: Int in ints.indices) {
		println("ints[$int] = ${ints[int]}")
	}
	for ((index, value) in ints.withIndex()) {
		println("Element at index $index is $value")
	}
}