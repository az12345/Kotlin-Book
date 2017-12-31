package com.github.spdeepak.code.chapter5

//Super class must have the keyword open at the start  Because by default all classes are considered as final
open class SuperClass {

	constructor(name: String) {
		println("Name given to the base class is $name")
	}
}

class ChildClass : SuperClass {
	constructor(parent: String, name: String) : super(parent)
}

class DemoForUsageOfSecondaryConstructor(firstName: String, lastName: String) {
	var fullName: String? = null
	var age: Int? = null

	//..
	constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
		this.fullName = firstName.plus(" $lastName")
		this.age = age
	}

	fun printName() {
		println("$fullName's age is $age")
	}

}

open class Base1 {
	constructor(i: Int) {
		println("The Base Value of i: $i")
	}

	constructor(i: Int, l: Long) {
		println("The Base Value of i: $i")
		println("The Base Value of l: $l")
	}
}

class Derived1 : Base1 {
	constructor(i: Int) : super(i) {
		println("The Derived Value of i: $i")
	}

	constructor(i: Int, l: Long) : super(i, l) {
		println("The Derived Value of i: $i")
		println("The Derived Value of l: $l")
	}
}

fun main(args: Array<String>) {
	DemoForUsageOfSecondaryConstructor("Deepak", "SP", 26).printName()
	Derived1(10)
	Derived1(10, 10L)
}