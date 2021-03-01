import java.lang.NumberFormatException

fun main(args: Array<String>) {
    println("Your result is " +
            Calculator.GetResult(
                GetOperator("Enter operator"),
                GetNumber("Enter first number"),
                GetNumber("Enter second number")
            ))
}

fun GetNumber(message: String): Double{
    print("$message: ")
    while(true){
        try{
            return readLine()!!.toDouble()
        }catch (e: NumberFormatException){
            print("Wrong input! Try again: ")
        }catch (e: KotlinNullPointerException){
            print("Input was null. Try again: ")
        }
    }
}

fun GetOperator(message: String): Char{
    print("$message(+, -, *, /): ")
    while(true){
        return when(readLine()){
            "+" -> '+'
            "-" -> '-'
            "*" -> '*'
            "/" -> '/'
            else -> {
                print("Wrong input! Try again: ")
                continue
            }
        }
    }

}

class Calculator{
    companion object{
        fun GetResult(operator: Char, a: Double, b: Double): Double{
            return when(operator){
                '+' -> Add(a, b)
                '-' -> Substract(a, b)
                '*' -> Multiply(a, b)
                '/' -> Divide(a, b)
                else -> 0.0
                }
        }

        private fun Add(a: Double, b: Double): Double{
            return a + b
        }

        private fun Substract(a: Double, b: Double): Double{
            return a - b
        }

        private fun Multiply(a: Double, b: Double): Double{
            return a * b
        }

        private fun Divide(a: Double, b: Double): Double{
            return a / b
        }
    }
}