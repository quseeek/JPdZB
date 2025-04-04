package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun collatz(n: Int, wynik: MutableList<Int>): List<Int>? {
    wynik.add(n)

    if (wynik[wynik.size - 1] == 1) {
        return wynik

    } else if (n % 2 == 0) {
        return collatz(n / 2, wynik)

    } else {
        return collatz(3 * n + 1, wynik)

    }
}


fun main() {

    var x = 10001
    val wynik = mutableListOf<Int>()

    collatz(x, wynik)

    println("Ciag Collatza zaczynajac od c0 = $x przed wpadnieciem w cykl: $wynik")
    println("Maksymalna wartosc ciagu Collatza zaczynajac od c0 = $x to: ${wynik.max()}")

}