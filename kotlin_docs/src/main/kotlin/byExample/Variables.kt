fun main() {
    var a: String = "initial" // 불변 X, 초기화
    println(a)

    val b: Int = 1 // 불변, 초기화
    val c = 3 // 불변, 초기화(타입 추론 -> Int)

    var e: Int // 초기화 X
    println(e) // 초기화 되어야 한다고 에러 남

    // 초기화 언제할지 자유롭게 정할 수 있지만 반드시 첫 읽기 전에 초기화해야 함
    fun someCondition(): Boolean {
        return true
    }
    val d: Int
    if (someCondition()) {
        d = 1
    } else {
        d = 2
    }

    println(d)
}