package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

import kotlin.math.sqrt

fun heron(a: Double, b: Double, c: Double): Double?{
    /**
     * Funkcja obliczająca pole powierzchni trójkąta za pomocą wzoru Herona.
     *
     * @param a długość boku a
     * @param b długość boku b
     * @param c długość boku c
     * @return pole powierzchni trójkąta lub null, jeśli dane wejściowe są niepoprawne
     */
    if(a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0){
        return null
    } else {
        val s = (a + b + c) / 2
        return sqrt(s*(s-a)*(s-b)*(s-c))
    }
}



fun main() {
    //test funkcji
    var p = heron(5.0, 4.0, 4.0)

    if(p == null){
        println("Trójkąt o zadanych bokach nie istnieje!")
    } else {
        println("Pole powierzchni podanego trójkąta wynosi: $p.")
    }

    //test z zbyt długim bokiem a
    p = heron(20.0, 4.0, 4.0)

    if(p == null){
        println("Trójkąt o zadanych bokach nie istnieje!")
    } else {
        println("Pole powierzchni podanego trójkąta wynosi: $p.")
    }

    //test z ujemnym bokiem b
    p = heron(4.0, -1.0, 4.0)

    if(p == null){
        println("Trójkąt o zadanych bokach nie istnieje!")
    } else {
        println("Pole powierzchni podanego trójkąta wynosi: $p.")
    }



}