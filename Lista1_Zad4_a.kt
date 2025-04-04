package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun fibonacci(n: Int): List<Int>?{
    /**
     * Funkcja zwraca n pierwszych wyrazów ciągu Fibonacciego.
     * Ciąg zaczyna się od 1, 1, 2, 3, 5, 8, ...
     *
     * @param n liczba wyrazów ciągu Fibonacciego
     * @return lista zawierająca n pierwszych wyrazów ciągu Fibonacciego lub null, jeśli dane wejściowe są niepoprawne
     */
    if (n <= 0){
        return null
    } else if (n == 1){
        return listOf(1)
    } else if (n == 2){
        return listOf(1, 1)
    } else {

        val fibonacci = mutableListOf(1, 1)

        for (i in 2 until n) {
            fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2])

        }
        return fibonacci
    }
}


fun main(){

    //test funkcji z zerowym argumentem
    var x = 0
    var fibonnacci = fibonacci(x)

    if(fibonnacci == null){
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $fibonnacci")
    }

    //test funkcji z ujemnym argumentem
    x = -1000
    fibonnacci = fibonacci(x)

    if(fibonnacci == null){
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $fibonnacci")
    }

    //test funkcji
    x = 40
    fibonnacci = fibonacci(x)

    if(fibonnacci == null){
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $fibonnacci")
    }



}


