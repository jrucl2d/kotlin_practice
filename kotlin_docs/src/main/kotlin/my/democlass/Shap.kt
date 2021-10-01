package my.democlass

// 클래스는 기본적으로 final(상속 불가). 상속 가능하게 하려면 open을 붙여야 함
open class Shape

// 상속을 위해서는 :를 사용
class Rectangle(var height: Double, var length: Double): Shape() {
    var perimeter = (height + length) * 2
}

fun main() {
    // 파라미터에 대한 기본 생성자가 자동으로 만들어진다.
    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")

    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

//    fun maxOf(a: Int, b: Int): Int {
//        if (a > b) {
//            return a
//        } else {
//            return b
//        }
//    }
    // if 표현식
    fun maxOf(a: Int, b: Int) = if (a > b) a else b
    println(maxOf(123, 432))

    // for looop
    println("--for loop--")
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    println("--while loop--")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println("--when expression--")
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown" // switch 문의 default 같이 필수
        }
    println("${describe(1)} / ${describe("Hello")} / ${describe(1L)}")
    println("${describe(3)} / ${describe(3.14)}")

    println("--range--")
    val x = 10
    val y = 9
    // in -> 어떤 숫자가 어떤 범위 내에 있는지 확인
    if (x in 1..y+1) {
        println("fits in range")
    }
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    println("--collections--")
    for (item in items) {
        println(item)
    }

    // orange 에서 true 면 orange 만 출력. apple 에서 true 면 apple 만 출력.
    // 둘 다 아니면 아무것도 출력 안 됨.
    when {
        "orange" !in items -> println("orange is not in items")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}

/*

/*
 블록 주석 내부에 또다른 블록 주석 들어갈 수 있음
 */

 */