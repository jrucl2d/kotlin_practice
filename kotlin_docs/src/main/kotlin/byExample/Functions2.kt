package byExample

fun main() {
    // times -> *
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    // get -> ..
    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much"
    println(str[0..14])

    // varargs ,로 구분된 매개변수들을 많이 넘길 수 있음
    fun printAll(vararg messages: String) {
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "aa")

    // named parameter 덕분에 자바와는 달리 varargs를 앞에 둘 수 있음
    fun printAllWithPrefix(vararg messages: String, prefix: String) {
        for (m in messages) println(prefix + m)
    }

    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "aa",
        prefix = "Greeting: "
    )

    // varargs 는 런타임에 Array 로 넘어가기 때문에 *를 사용해서 String 의 varargs 로 넘겨줌
    fun log(vararg entries: String) {
        printAll(*entries)
    }

    log("a", "b", "c", "d")
}
