package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 * Wykorzystałem chatGPT do wytłumaczenia działania shl
 */

fun podzbiory(zbior: List<Any>): List<List<Any>> {
    /**
     * Funkcja zwraca wszystkie podzbiory zbioru.
     *
     * @param zbior lista zawierająca elementy zbioru
     * @return lista zawierająca wszystkie podzbiory zbioru
     */
    val podzbiory = mutableListOf<List<Any>>()
    val x = zbior.size

    for (i in 0 until (1 shl x)) {
        val podzbior = mutableListOf<Any>()

        for (j in 0 until x) {
            if ((i and (1 shl j)) != 0) {
                podzbior.add(zbior[j])
            }
        }
        podzbiory.add(podzbior)
    }
    return podzbiory
}




fun main(){

    //test funkcji
    val podzbiory = podzbiory(listOf("a", "b", "c", "d"))

    println(podzbiory)



}