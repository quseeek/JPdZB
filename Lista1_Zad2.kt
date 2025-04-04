package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 * Wykorzystałem chatGPT do:
 *      podpowiedzenia, że można wykonać do zadanie za pomocą .groupingBy
 *      wytłumaczenia jak działa .groupingBy
 */

fun wspolne(a: List<Int>, b: List<Int>): List<Int> {
    /**
     * Funkcja zwracająca część wspólną dwóch multizbiorów.
     *
     * @param a pierwszy multizbiór
     * @param b drugi multizbiór
     * @return lista zawierająca część wspólną dwóch multizbiorów
     */
    val wspolne = mutableListOf<Int>()

    val sortedA = a.sorted()
    val sortedB = b.sorted()

    val mapA = sortedA.groupingBy { it }.eachCount()
    val mapB = sortedB.groupingBy { it }.eachCount()

    for (i in mapA.keys){
        if (i in mapB.keys){
            val actualA = mapA[i]
            val actualB = mapB[i]
            if (actualA == actualB){
                for (j in 1..actualA!!){
                    wspolne.add(i)
                }
            } else {
                val min = minOf(actualA!!, actualB!!)

                for (j in 1..min){
                    wspolne.add(i)
                }
            }
        }
    }
    return wspolne
}

fun main(){

    //test funkcji
    val a = listOf(1, 2, 4, 2, 5, 6, 7)
    val b = listOf(0, 2, 2, 5, 4, 8, 9)
    val wspolne = wspolne(a, b)

    println("Czesc wspolna multizbiorow: $wspolne")
}