#Easy Kotlin Tutorial for Java Programmers

##Chapter 5
###Classes and Inheritance

Lets see how to create an empty class in Kotlin
<br/><br/>
<code>
**class** _EmptyClass_
</code>
<br/><br/>
Yes, you read it right that one line above creates an empty class. Here **`class`** is the header. One more important information, if you create a class as shown above it creates a class which is a **`final`**. All classes in kotlin are final unless and until you specify otherwise. We will see how to specify a class otherwise in sometime.

###Constructors
A class in kotlin can have one Primary constructor and one or more Secondary constructors. <br/>
How do we create a class with a Primary constructor in it?<br/>
<br/>
<code>
**class** _ClassWithAPrimaryConstructor_ (_firstVariable_: **String**)
</code>
<br/><br/>
Now, What if there are annotations to be used on a constructor? Then you can just use the <code>constructor</code> keyword as shown below
<br/>
<code>
**class** _ClassWithAPrimaryConstructor_ **constructor** (_firstVariable_: **String**)
</code>
<br/><br/>

Kotlin has initializer blocks to initialise code which can be created by using the keyword **`init`**. And they are executed in the order of appearance.
<br/>
<code>
class DemoForInit(name: String) {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;val firstVariable = "This is the first variable"<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;init{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;println("This method is self understandable that this is an initializer method. ($firstVariable)")<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
}
</code>
