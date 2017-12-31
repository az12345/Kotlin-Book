# Easy Kotlin Tutorial for Java Programmers

## Chapter 1

#### Variable declaration

There are 2 types of variable declarations. `var` and `val`.
variables declared using `val` is immutable i.e, it cannot be changed and `var` is the opposite of `val`.

#### Basic Types



## Chapter 5

### Classes and Inheritance

Lets see how to create an empty class in Kotlin

```kotlin
class EmptyClass
```

Yes, we read it right that one line above creates an empty class. Here `class` is the keyword. One more important information, if we create a class as shown above it creates a class which is a `final`. All classes in kotlin are final unless and until we specify otherwise. We will see how to specify a class otherwise in sometime.

#### Constructors

A class in kotlin can have one Primary constructor and one or more Secondary constructors. <br/>

How do we create a class with a Primary constructor in it?<br/>

```kotlin
class ClassWithAPrimaryConstructor (firstVariable: String)
```

Now, What if there are annotations to be used on a constructor? Then we can just use the `constructor` keyword as shown below

```kotlin
class ClassWithAPrimaryConstructor constructor (firstVariable: String)
```

Kotlin has initializer blocks to initialise code which can be created by using the keyword `init`. And they are executed in the order of appearance.

```kotlin
class DemoForInit(name: String) {
    val firstVariable = "This is the first variable"
    init{
        println("This is an initializer block and this is initialized by $name. ($firstVariable)")
    }
}
```

If we have multiple `init` blocks then it will be executed in the order of appearance. You should try that.<br/>

Can the arguments passed in constuctor be used inside the class for other operations? Yes. How? See below.

```kotlin
class DemoForUsageOfConstructorArguments(name: String) {
    val nameInUpperCase = name.toUpperCase()
}
```

We can also declare mutable and immutable(read-only) arguments in the constructor as shown below. 

```kotlin
class DemoForUsageOfConstructorArguments(val firstName: String, var lastName: String) {
    //..
}
```

There are cases where we need to create a singleton class. In that case we can use access modifiers for the constructors when needed.

```kotlin
class DemoForUsageOfPublicConstructor public @Inject constructor(val firstName: String, var lastName: String) {
    //..
}
```

##### Secondary Constructors

Secondary constructors can be created as shown below.

```kotlin
class DemoForUsageOfSecondaryConstructor {
    var name: String
    //..
    constructor(name: String){
        this.name = name
    }
    fun printName() {
    	println("Name is: $name")
    }
    //..
}
fun main(args: Array<String>) {
	DemoForUsageOfSecondaryConstructor("Deepak").printName()
}
```

What if the class already has Primary constructor? Then we will have to delegate the primary constructor from the secondary constructor using the `this` keyword. It is shown below. 

```kotlin
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
	//..
}
fun main(args: Array<String>) {
	DemoForUsageOfSecondaryConstructor("Deepak", "SP", 26).printName()
}
```

If we create a non-abstract class with out a constructor then a public no argument default constructor will be created. If you want the default constructor to be private then you will have to specify it.

```kotlin
class ClassWithPrivateConstructor private constructor(){

}
```

NOTE: If we specify a constructor with default values in it when creating a class then JVM will create a parameterless constructor which will use the default values.

#### Create Objects of a class

Well if you guessed it as using the `new` keyword then you are **wrong**. You just read it before already. Well, you might have missed it. it can be created as shown below

```kotlin
val classInstance = EmptyClass()
val person = ClassWithAPrimaryConstructor("Deepak")
```

#### Inheritance

In Java the super class for all classes is `Object` and in Koltin it is `Any`. And `Any` is not `Object`. `Any` just has members such as `equals()`, `hasCode()`, `toString()`<br/>

So, to mark a class as inheritable we will have to mark it with `open` annotation as shown below.

```kotlin
open class Base(i: Int)
class Derived(i: Int): Base(i)
```

If the `Base` class has a primary constructor then the `Derived` class **must** also initialize it using the parameters of the primary constructor. What if the `Base` class does not have a explicitly declared primary constructor, then each secondary constructor has to initialize the base type using the `super` keyword in the same way we used `this` keyword to delegate the primary constructor from a secondary constructor.

```kotlin
open class Base {
	constructor(i: Int) {
    		println("The Base value of i: $i")
    	}
    
    constructor(i: Int, l: Long) {
    	println("The Base value of i: $i")
    	println("The Base value of l: $l")
    }
}

class Derived : Base {
 	constructor(i: Int) : super(i) {
 	    println("The Base value of i: $i")
 	}
 	constructor(i: Int, l: Long) : super(i, l){
         println("The Base value of i: $i")
         println("The Base value of l: $l")
     }
 }

fun main(args: Array<String>) {
	Derived(10)
	Derived(10, 10L)
}
```

#### Inner class

Creating inner classes in kotlin is the same as we do in Java. But with `inner` as prefix.

```kotlin
class Foo{
    fun dummyFunction(){
        //**
    }
    
    inner class InnerFoo{
        fun innerDummyFunction(){
            //**
        }
    }
}
```

Inner class will be dealt in detail in an upcoming chapter. Here it has just been introduced to show the overriding of methods in Inner classes which is what we are going to discuss next.

#### Overriding Methods

Kotlin is a bit different compared to Java. We will have to declare a method which can be overridden as `open` as we declared the class which can be inherited.

```kotlin
open class Base{
    open fun canOverride() { }
    fun cannotOverride() { }
}

class Derived: Base{
    override fun canOverride() { }
}
```

Note the `override` keyword prefixed for the overridden method. So, 2 things to remember when overriding a method `open` keyword for the method which can be overridden in the `Base` class and `override` keyword for the method which is overridden in the `Derived` class, or else the compiler would complain.

Well, what if there is another class which inherits the `Derived` class and you want to restrict that class from overriding the `canOverride` method; in that case use prefix `final` keyword before the `override` keyword in the `Derived` class as shown below.

```kotlin
class Derived: Base{
    final override fun canOverride() { }
}
```

#### Overriding Class Variables/Parameters

This is done in the same way as we did method overriding. Have the `open` keytword for the property which you want to allow to be overridden and use the `override` keyword when you want to override the property in the inherited class.

```kotlin
open class Base{
    open val x: Int = 10
}
class Derived: Base{
    override val x: Int = 20
}
```

But there is one rule to be remembered here. We can override a `val` as `var` but not the other way round. And this is because `val` declares a getter method (like we create manually in Java) and when overridden a `val` as `var` a setter method is declared in the `Derived` class. We can also override a property in the constructor of the `Derived` class as well.

```kotlin
class Foo(override val x: Int): Base

class Boo: Base{
    override var x: Int = 20
}
```

#### Calling the `Base` class (`Super` class) implementaiton from the `Derived`class

It is done in the same way as in Java i.e., by using `super`.

```kotlin
open class Base {
    open fun canOverride() { println("Base.canOverride()") }
    open val x: Int = 10
}

class Derived : Base() {
    override fun canOverride() { 
        super.canOverride()
        //**
    }
    
    override val x: Int = super.x + 1
}
```

So, now how do we override a `Base` class method in the `innner` class of a `Derived` class

```kotlin
class Derived : Base() {
    override fun canOverride() { 
        super.canOverride()
        println("Derived.canOverride()")
        //**
    }
    inner class InnerDerived{
        fun dummy(){
            super@Derived.canOverride() //Calls the canOverride() of Base class
            canOverride() //calls the canOverride() of Derived class
        }
    }   
}
```

#### Interfaces

Creating interfaces in Kotlin is the same as in Java. And it's members are `open` by default.

```kotlin
interface ExampleInterface {
	val x: Int              
	var y: Int              
	fun f()                 
}
```

#### Overriding Rules

if a `Derived` class inherits many implementations, be it interface(s) and/or class(es). It has to override the functions(or members as called in kotlin) and provide it's own implementations and also use the implementations of the inherited ones if needed. (**As we know Java interfaces can have their own default implementations.**)

```kotlin
open class Base{
    open fun foo(){
        println("Base().foo()")
    }
}
interface Dummy{
    fun foo(){ println("Default foo implementation") }
}
class Derived:Base,Dummy{
    //The compiler requires implementation of foo()
    override fun foo(){
        super<Base>.foo()
        super<Dummy>.foo()
    }
}
```

#### Abstract Classes

Abstract classes in kotlin work the same way as in Java. For example.

```kotlin
open class Base{
    open fun foo(){}
}

abstract class Derived: Base(){
    override abstract fun foo()
}
```

We don't need to mark `abstract` functions as `open`. if a method is marked `abstract` it is considered as `open` without any saying.
