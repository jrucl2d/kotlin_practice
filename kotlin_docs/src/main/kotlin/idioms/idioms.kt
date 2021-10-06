package idioms

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


}
