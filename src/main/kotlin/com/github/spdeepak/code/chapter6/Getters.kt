package com.github.spdeepak.code.chapter6

open class Foo {
	var captain: String = ""
		get() {
			return "Hello, ".plus(field)
		}
		set(value) {
			println("Set is Invoked")
			field = modifyString(value).plus("!!")
			println("field is $field")
		}
	var lowerCaseString: String = ""
	fun modifyString(string: String): String {
		lowerCaseString = string.toLowerCase()
		return string.toUpperCase()
	}

	val y = 21
	open val x: Int
		get() {
			return 10 * y
		}
}

class Bar1 : Foo() {
	//When overridden as var and use a get() then the variable has to be initialised
	override val x: Int
		get() {
			return super.x * (super.x * 10)
		}
	val isNotEmpty get() = this.y == 21
}

fun main(args: Array<String>) {
	val foo: Foo = Foo()
	foo.captain = "Deepak"
	println(foo.captain)
	println(foo.lowerCaseString)
	val bar1: Bar1 = Bar1()
	println("Value of x: ${foo.x}")
	println("value of y: ${bar1.y}")
	println("${bar1.isNotEmpty}")
}
