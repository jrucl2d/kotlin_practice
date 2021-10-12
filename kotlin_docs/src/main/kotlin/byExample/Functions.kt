package byExample

fun printMessage(message: String): Unit {
    println(message)
}

// 두 번째 파라미터는 optional 하고 default 메시지가 제공됨.
// 생략된 리턴 값은 Unit 임.
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

// 정수로 추정되는 값을 리턴한다.
fun multiply(x: Int, y: Int) = x * y

fun main() {
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    // named arguments 를 사용하면 순서가 변경될 수 있음.
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))

    // infix 함수 정의, 사용
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    // 표준 라이브러리의 to infix 함수를 사용해 Pair 을 만드는 법
    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

class Person(val name: String) {
    val likedPerson = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPerson.add(other) }
}