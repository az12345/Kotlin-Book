package com.github.spdeepak.code.chapter5

open class SuperClassImplementation {
	open fun foo() {
		println("SuperClassImplementation().foo()")
	}
}

class DerivedClass : SuperClassImplementation() {
	override fun foo() {
		super.foo()
		println("DerivedClass().foo()")
	}
}

class SuperClassOfInner : SuperClassImplementation() {

	override fun foo() {
		super.foo()
		println("SuperClassOfInner().foo()")
	}

	inner class InnerClassOfSuperClassOfInner {
		fun innerClassFunction() {
			super@SuperClassOfInner.foo()
			foo()
		}
	}
}

fun main(args: Array<String>) {
	println("Calling DerivedClass().foo()")
	DerivedClass().foo()
	println("-------")
	println("Calling SuperClassOfInner().InnerClassOfSuperClassOfInner().innerClassFunction()")
	SuperClassOfInner().InnerClassOfSuperClassOfInner().innerClassFunction()
}