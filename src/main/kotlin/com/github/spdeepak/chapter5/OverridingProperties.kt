package com.github.spdeepak.chapter5


open class Foo {

	val y = 21
	open val x: Int
		get() {
			return 10 * y
		}

	open fun overrided() {
		println("Foo class")
	}

}

class Bar(override var x: Int) : Foo() {
	override fun overrided() {
		//super.overrided()
		println("Bar class")
	}

	inner class Bax {
		fun ps() {
			super@Bar.overrided()
			overrided()
		}
	}
}

fun main(args: Array<String>) {
	val foo: Foo = Foo()
	val bar: Bar = Bar(20)
	println("foo.x is ${foo.x}")
	println("bar.x is ${bar.x}")

	Bar(10).Bax().ps()
}