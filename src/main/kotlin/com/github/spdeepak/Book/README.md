# Easy Kotlin Tutorial for Java Programmers

## Chapter 5

### Classes and Inheritance

Lets see how to create an empty class in Kotlin
```kotlin
class EmptyClass
```
Yes, you read it right that one line above creates an empty class. Here `class` is the keyword. One more important information, if you create a class as shown above it creates a class which is a `final`. All classes in kotlin are final unless and until you specify otherwise. We will see how to specify a class otherwise in sometime.
### Constructors
A class in kotlin can have one Primary constructor and one or more Secondary constructors. <br/>
How do we create a class with a Primary constructor in it?<br/>
```kotlin
class ClassWithAPrimaryConstructor (firstVariable: String)
```
Now, What if there are annotations to be used on a constructor? Then you can just use the ```kotlinconstructor``` keyword as shown below
```kotlin
class ClassWithAPrimaryConstructor constructor (firstVariable: String)
```
Kotlin has initializer blocks to initialise code which can be created by using the keyword `init`. And they are executed in the order of appearance.

```kotlin
class DemoForInit(name: String) {<br/>
    val firstVariable = "This is the first variable"
    init{
        println("This method is self understandable that this is an initializer method. ($firstVariable)")<br/>
    }
}
```
