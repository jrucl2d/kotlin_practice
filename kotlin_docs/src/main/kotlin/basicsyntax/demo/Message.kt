package basicsyntax.demo

fun main(args: Array<String>) {
    print(args.contentToString()) // Array 인 args 가 [ ]로 출력됨

    // println
    println()

    // print
    print("Hello ")
    println("world!")
    println(42)

    println(sum(1, 4))
    printSum(25, 26)

    // RO 지역 변수
    val a: Int = 1 // 즉시 할당
    val b = 2 // Int 타입은 유추됨
    val c: Int // 초기화를 하지 않는다면 타입을 명시해야 함
    c = 3 // 지연된 할당
    println("a : $a, b : $b, c : $c")

    var x1 = 5 // Int 타입으로 유추됨
    x1 += 1
    println("x : $x1")

    val PI = 3.14
    var x2 = 0
    fun incrementX() {
        x2 += 1
    }
    incrementX()
    println("PI : $PI, x2 : $x2")
}

//fun sum(a: Int, b: Int): Int {
//    return a + b
//}
fun sum(a: Int, b: Int) = a + b // 함수의 body 는 표현식이 될 수 있다. 리턴 타입은 유추함.

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}") // 문자열 내부에 값을 출력
}