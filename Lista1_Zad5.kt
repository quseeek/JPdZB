package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun collatz(n: Int, wynik: MutableList<Int>): List<Int>? {

    /**
     * Generuje ciąg Collatza dla zadanej liczby n.
     * Ciąg kończy się, gdy osiągnięta zostanie liczba 1, później ciąg wpadłby w pętlę 4, 2, 1.
     *
     * @param n liczba początkowa ciągu
     * @param wynik lista przechowująca kolejne elementy ciągu
     * @return lista zawierająca cały ciąg Collatza lub null, jeśli dane wejściowe są niepoprawne
     */

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

    //test funkcji
    var x = 10001
    val wynik = mutableListOf<Int>()

    collatz(x, wynik)

    println("Ciag Collatza zaczynajac od c0 = $x przed wpadnieciem w cykl: $wynik")
    println("Maksymalna wartosc ciagu Collatza zaczynajac od c0 = $x to: ${wynik.max()}")

}