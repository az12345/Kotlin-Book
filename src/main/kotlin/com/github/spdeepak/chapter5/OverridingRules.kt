package com.github.spdeepak.chapter5

open class BaseA {
	open fun foo() {
		println("BaseA().foo()")
	}
}

interface InterfaceBase {
	fun foo() {
		println("Default foo implementation")
	}

	fun boo() {
		println("Default boo implementation")
	}
}

abstract class DerivedBase : BaseA(), InterfaceBase {
	override abstract fun foo()
	override abstract fun boo()
}

class B : BaseA(), InterfaceBase {
	override fun foo() {
		super<BaseA>.foo()
		super<InterfaceBase>.foo()
	}
}

fun main(args: Array<String>) {
	B().foo()
}