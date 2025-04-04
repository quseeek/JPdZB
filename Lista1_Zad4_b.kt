package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun fibonacci2(n: Int, fibonacci: MutableList<Int>): List<Int>? {
    /**
     * Funkcja zwraca n pierwszych wyrazów ciągu Fibonacciego.
     * Ciąg zaczyna się od 1, 1, 2, 3, 5, 8, ...
     *
     * @param n liczba wyrazów ciągu Fibonacciego
     * @param fibonacci lista przechowująca kolejne elementy ciągu Fibonacciego
     * @return lista zawierająca n pierwszych wyrazów ciągu Fibonacciego lub null, jeśli dane wejściowe są niepoprawne
     */

    if (n <= 0) {
        return null
    } else if (n == 1) {
        return listOf(1)
    } else if (n == 2) {
        return listOf(1, 1)
    } else {

        if (fibonacci.size < n) {

            fibonacci.add(fibonacci[fibonacci.size - 1] + fibonacci[fibonacci.size - 2])

            fibonacci2(n, fibonacci)
        }
        return fibonacci
    }
}


fun main() {
    val fibonacci = mutableListOf(1, 1)

    //test funkcji z zerowym argumentem
    var x = 0
    var wynik = fibonacci2(x, fibonacci)
    if (wynik == null) {
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $wynik")
    }

    //test funkcji z ujemnym argumentem
    x = -120
    wynik = fibonacci2(x, fibonacci)
    if (wynik == null) {
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $wynik")
    }

    //test funkcji
    x = 40
    wynik = fibonacci2(x, fibonacci)
    if (wynik == null) {
        println("Argument musi byc liczba calkowita dodatnia!")
    } else {
        println("$x pierwszych wyrazow ciagu Fibonacciego: $wynik")
    }
}