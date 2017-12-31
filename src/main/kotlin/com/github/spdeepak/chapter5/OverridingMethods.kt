package com.github.spdeepak.chapter5

open class Base {

	open fun functionOne() {
		println("Base class function One. Only this method can be overridden as it is declared as open")
	}

	fun functionTwo() {
		println("Base class function Two. This cannot be overridden as it is not declared as open. And having a method with the same name in the derived class would be illegal")
	}
}

class Derived() : Base() {
	override fun functionOne() {
		super.functionOne()
		println("Derived class function One")
	}

}

fun main(args: Array<String>) {
	val derived = Derived()
	derived.functionOne()
	derived.functionTwo()
}
