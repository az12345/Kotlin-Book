package com.github.spdeepak.code.chapter5

class CompanionObjects {

	companion object Factory {
		fun create(): CompanionObjects {
			println("Inside create method")
			return CompanionObjects()
		}
	}

}

fun main(args: Array<String>) {
	CompanionObjects.create()
}