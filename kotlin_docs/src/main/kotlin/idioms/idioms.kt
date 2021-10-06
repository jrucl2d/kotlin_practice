package idioms

import basicsyntax.democlass.Rectangle
import java.io.File
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

// create DTO
// getters(var일 경우에는 setter도)
// equals, hashCode, toString, copy 자동 제공
data class Customer(val name: String, val email: String)

// Singleton 만드는 법
object Resource {
    val name = "Name"
}

fun main() {
    // 함수 파라미터 기본값 부여
    fun Foo(a: Int = 0, b: String = "haha"): String {
        return "$a / $b"
    }
    println(Foo())

    // list 필터링
    val list = listOf(-2, -1, 0, 1, 2, 3, 4)
    val positives = list.filter { x -> x > 0}
    println(positives)
    val positives1 = list.filter { it > 0 } // 무조건 'it' 여야 함
    println(positives1)

    // 컬렉션 안에 요소 존재하는지 여부 파악
    val emailsList = listOf("john@example.com", "haha@naver.com", "hihi@gmail.com")
    if ("john@example.com" in emailsList) {
        println("있음")
    }
    if ("hahahaha" !in emailsList) {
        println("없음")
    }

    // 문자열 보간법
    val name = "Mr.Man"
    println("Name $name")

    // instance 체크
    fun doSomething(x: Any): Unit {
        when (x) {
            is String -> println("하하") // is 에는 class 가 들어감
            is Long -> println("히히")
            else   -> println("없음")
        }
    }

    // readOnly list 만들기, map 만들기
    val rolist = listOf("a", "b", "c")
    val romap = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(romap["a"])
    val mmap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    println(mmap["a"])
    mmap["a"] = 4
    println(mmap["a"])

    // map 요소 돌기
    for ((key, value) in mmap) {
        println("$key -> $value")
    }

    // 범위로 iterate 하기
    for (i in 1..10) { // closed range(10을 포함)
        print("$i ")
    }
    println()
    for (i in 1 until 10) { // half-open range(10을 미포함)
        print("$i ")
    }
    println()
    for (i in 2..10 step 2) { // 2씩 띄어서 10까지
        print("$i ")
    }
    println()
    val x = 2
    if (x in 1..10) {
        println("yes it is!")
    }

    // Lazy property -> val 의 경우에만.
    // 변수 선언과 동시에 초기화를 선언하고는 있지만 호출 시점에 초기화가 이루어짐.
    val p: String by lazy {
        println("2번째") // p가 사용될 때 출력
        "3번째"
    }
    println("1번째") // p 사용 전에 먼저 출력
    println(p) // p 의 값 출력

    // 함수의 확장
    fun String.toCamelCase() {
        println("make it camel case")
    }
    "Some String".toCamelCase()

    // 추상 클래스 생성 및 상속
    abstract class MyAbstractClass {
        abstract fun doSomething()
        abstract fun sleep()
    }
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            println("doSomething")
        }
        override fun sleep() {
            println("sleep")
        }
    }

    // files 가 null 이 아니면 출력함.
    val files = File("Test").listFiles()
    // null 이면 null 출력
    println("files.size : ${files?.size}")
    // null 이면 주어진 값 출력
    println("files.size : ${files?.size ?: "empty"}")

    // 없으면 예외 throw
    val values = mapOf("amail" to 1, "kmail" to 2)
    try {
        values["email"] ?: throw IllegalStateException("Email 없음!")
    } catch (e: IllegalStateException) {
        println(e)
    }

    // 빈 컬렉션일 수도 있을 때 첫 요소 가져오기
    val emails = emptyList<String>()
    val mainEmail = emails.firstOrNull() ?: "nono"
    println(mainEmail)

    // 값이 null 일 경우 블록 실행
    val value = "not null"
    value?.let {
        println("이 블록은 not null 일 때 실행 됨")
    }

    // mapped 가 null 이거나 transformValue 의 결과가 null 이면 default value 리턴
    val emptyMap = emptyMap<String, String>()
    val mapped = emptyMap?.let {
        // transformValue(it)
        null
    } ?: "default value"
    println(mapped)

    // when statement 사용
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            else -> throw IllegalStateException("Nono")
        }
    }

    // try - catch 사용법
    fun test(haha: String) {
        val result = try {
            transform(haha)
        } catch (e: IllegalStateException) {
            throw IllegalStateException(e)
        }

        println(result)
    }

    // if 사용
    fun fooo(param: Int): String{
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        return result
    }

    // Unit 을 리턴하는 메소드의 builder 스타일 사용
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }
    val myArray = arrayOfMinusOnes(3)
    myArray.iterator().forEach { print("$it ") }
    println()

    // 메소드의 single-expression
    fun a() = 42
    fun aa(): Int {
        return 42
    }
    println("a() : ${a()}는 aa() : ${aa()}와 같다")
    // 이 방식과 when의 사용을 접목하면 간단하게 리턴 가능. 위의 when 부분 확인

    // 객체 인스턴스의 여러 메소드를 with 로 호출
    class Turtle {
        fun penDown() { println("penDown") }
        fun penUp() { println("penUp") }
        fun turn(degrees: Double) { println("turn $degrees") }
        fun forward(pixels: Double) { println("forward $pixels") }
    }
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    // 생성자에 없는 값을 설정할 때 유용하다.
    val myRectangle = Rectangle(1.0, 2.0).apply {
        length = 10.0
        height = 11.0
    }

    // try-with-resources 사용
//    val stream = Files.newInputStream(Paths.get("/some/a.txt"))
//    stream.buffered().reader().use { reader ->
//        println(reader.readText())
//    }

    // generic
//     public final class Gson {
//         ...
//         public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//         ...
//    inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

    // nullable 불리언
    val bb: Boolean? = null
    if (bb == true) {
        // ...
    } else {
        // bb 가 false 이거나 null 일 때
    }

    // 두 값 swap
    var a = 1
    var b = 2
    a = b.also { b = a }

    // 투두의 추가. 자동으로 인텔리제이 투두에 추가됨. 자동으로 NotImplementedError throw 함. 리턴이 없어 리턴값 신경 X
    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
}
