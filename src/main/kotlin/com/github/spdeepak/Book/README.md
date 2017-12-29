# Easy Kotlin Tutorial for Java Programmers
Others can also read there are very few references to Java. It is written by keeping in mind that the reader knows Basic Java.



## Chapter 5
### Classes and Inheritance
Lets see how to create an empty class in Kotlin
```kotlin
class EmptyClass
```
Yes, we read it right that one line above creates an empty class. Here `class` is the keyword. One more important information, if we create a class as shown above it creates a class which is a `final`. All classes in kotlin are final unless and until we specify otherwise. We will see how to specify a class otherwise in sometime.
### Constructors
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
#### Secondary Constructors
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

### Create Objects of a class

Well if you guessed it as using the `new` keyword then you are **wrong**. You just read it before already. Well, you might have missed it. it can be created as shown below
```kotlin
val classInstance = EmptyClass()
val person = ClassWithAPrimaryConstructor("Deepak")
```