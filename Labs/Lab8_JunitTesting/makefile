default:	cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/DoubleDequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java

	javac cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/DoubleDequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java

runInt:	cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/DequeApp.class cpsc2150/MyDeque/ListDeque.class

	java cpsc2150.MyDeque.DequeApp

runDouble:	cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/DoubleDequeApp.class cpsc2150/MyDeque/ListDeque.class

	java cpsc2150.MyDeque.DoubleDequeApp

clean:

	rm -f cpsc2150/MyDeque/*.class


test:	cpsc2150/MyDeque/TestArrayDeque.java cpsc2150/MyDeque/TestListDeque.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/ListDeque.java

	javac -cp .:/usr/share/java/junit4.jar cpsc2150/MyDeque/TestArrayDeque.java cpsc2150/MyDeque/TestListDeque.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/ListDeque.java

testArr:	cpsc2150/MyDeque/TestArrayDeque.class cpsc2150/MyDeque/TestListDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/AbsDeque.class cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/ListDeque.class

	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestArrayDeque

testList:	cpsc2150/MyDeque/TestArrayDeque.class cpsc2150/MyDeque/TestListDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/AbsDeque.class cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/ListDeque.class

	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestListDeque
