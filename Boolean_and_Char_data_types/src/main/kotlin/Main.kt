
//functions
//fun sum(a:Int,b:Int): Int = a+b*41

//Default Parameter Values and Named Arguments
fun printMessage(name1: String){
    println(name1)
}

fun printMessageWithPrefix(name2: String, prefix: String = "Mr.") {
    println("[$prefix] $name2")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y








//main is the program entry point
fun main() {
    //
    var age :Int=23
    println("Samson Kinyanjui")
    println("Age:$age")

    printMessage("Samson")
    printMessageWithPrefix("Kinyanjui", "Mr.")
    printMessageWithPrefix("Kinyanjui")
    printMessageWithPrefix(prefix = "Mr", name2 = "Kinyanjui")
    println(sum(4, 25))
    println(multiply(100, 55))



}