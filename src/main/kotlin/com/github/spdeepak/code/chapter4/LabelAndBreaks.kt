package com.github.spdeepak.code.chapter4

fun main(args: Array<String>) {
	var ints = 50..55

	loop_label@ for (i in 1..100) {
		println("Value of i is $i")
		if (ints.contains(i)) {
			println("Breaking loop_label for number $i")
			break@loop_label
		}
	}

	//The same can be done using a return with labels as shown below. But only for inline functions.
	//Break can be used for loops as shown above but not for inline functions as shown below
	println("\nReturn of label in anonymous function")
	ints.forEach label_loop@ { num ->
		if (num == 52) return@label_loop
		println("Value is $num")
	}

	//The above returning of a label can be done without a label for a foreach loop as shown below
	println("\nReturn of for each in anonymous function")
	ints.forEach { num ->
		if (num == 52) return@forEach
		println("Value is $num")
	}

	//Lambda expression can also be replaced by an anonymous function as shown below

	ints.forEach(fun(value: Int) {
		if (value == 52) return@forEach
		println("Value in anonymous function is $value")
	})

	ints.forEach(fun(value: Int) {
		if (value == 52) return
		println("Value in anonymous function is $value")
	})

	println(foo((0..10).toList()))

}

fun foo(ints: List<Int>): List<String> {
	val result = ints.map f@ {
		if (it == 0) return@f "zero" // return at named label
		if (it == -1) return emptyList() // return at foo
		"number $it" // expression returned from lambda
	}
	return result
}