package com.github.spdeepak.code.chapter5

class EmptyClass

//Constructors

class ClassWithPrimaryConstructor constructor(firstName: String) {

}
//The above class can also be instantiated as show below
//if the class doesn't have any annotations or access modifiers

class ClassWithPrimaryConstructorAndVariablesinit(firstName: String) {
	val firstProperty = "This is the first Property of the class".also(::println)

	init {
		println("This method is self understandable that this is an initializer method. ($firstProperty)")
	}

	val secondProperty = "This is the second Property of the class".also(::println)

	init {
		println("This method is self understandable that this is an initializer method. (${secondProperty.length})")
	}
}


//Secondary Constructors
class ClassWithSecondaryConstructor {

	constructor() {
		println("This is a empty primary constructor")
	}

	//if the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor,
	//either directly or indirectly through another secondary constructor(s).
	//Delegation to another constructor of the same class is done using the this keyword:
	constructor(name: String) : this() {
		println("ClassWithSecondaryConstructor's secondary constructor with name: $name")
	}
}

class ClassWithPCInDeclaration(name: String) {

	constructor(name: String, age: Int) : this(name) {
		println("Name of the person is $name of age $age")
	}

	init {
		println("This is the init block and it will run before the constructor is run")
	}
}

fun main(args: Array<String>) {
	//Below lines show how to create objects. Yes you don't need the new keyword in Kotlin
	val class1: ClassWithPrimaryConstructorAndVariablesinit = ClassWithPrimaryConstructorAndVariablesinit("Deepak")
	ClassWithSecondaryConstructor()
	ClassWithSecondaryConstructor("Deepak")
	ClassWithPCInDeclaration("Deepak")
	ClassWithPCInDeclaration("Deepak", 26)
}
