package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

import kotlin.math.pow

/**
 * @author Sebastian Kłusek 268412
 */

class Wielomian {

    private val wspolczynniki: MutableList<Double>

    constructor(wspolczynniki: MutableList<Double>) {

        this.wspolczynniki = wspolczynniki
    }

    /**
     * Funkcja stopien zwraca stopień wielomianu
     * @return stopień wielomianu
     */
    fun stopien(): Int {

        val stopien = wspolczynniki.size - 1
        return stopien

    }

    /**
     * Funkcja tekst zwraca reprezentację tekstową wielomianu
     * @return reprezentację tekstową wielomianu
     */
    fun tekst(): String {

        var licznik = wspolczynniki.size
        var wynik = ""

        for (i in wspolczynniki.indices) {
            wynik +=("${wspolczynniki[i]}x^${licznik-1}")
            if (i + 1 != wspolczynniki.size) {
             wynik += (" + ")
            }
            licznik -= 1
        }
        return wynik
    }

    /**
     * Funkcja invoke zwraca wartość wielomianu w punkcie x
     * @param x punkt, w którym ma zostać obliczona wartość wielomianu
     * @return wartość wielomianu w punkcie x
     */
    operator fun invoke(x: Double): Double {
        var wynik = 0.0
        var licznik = wspolczynniki.size
        for (i in wspolczynniki.indices) {
            wynik += (wspolczynniki[i] * x.pow((licznik - 1).toDouble()))
            licznik -= 1
        }
        return wynik
    }

    /**
     * Funkcja plus dodaje dwa wielomiany
     * @param wielomian drugi wielomian do dodania
     * @return wynik dodawania wielomianów
     */
    operator fun plus(wielomian: Wielomian): Wielomian {
        var wynik = mutableListOf<Double>()
        val stopien1 = stopien()
        val stopien2 = wielomian.stopien()

        val minStopien = minOf(stopien1, stopien2)
        for (i in 0..minStopien) {
            wynik.add(wspolczynniki[wspolczynniki.size - i - 1] + wielomian.wspolczynniki[wielomian.wspolczynniki.size - i - 1])
        }
        if (stopien1 > stopien2) {
            for (i in minStopien + 1..stopien1) {
                wynik.add(wspolczynniki[wspolczynniki.size - i - 1])
            }
        } else {
            for (i in minStopien + 1..stopien2) {
                wynik.add(wielomian.wspolczynniki[wielomian.wspolczynniki.size - i - 1])
            }
        }
        wynik = wynik.reversed() as MutableList<Double>
        return Wielomian(wynik)
    }

    /**
     * Funkcja minus odejmuje dwa wielomiany
     * @param wielomian drugi wielomian do odejmowania
     * @return wynik odejmowania wielomianów
     */
    operator fun minus(wielomian: Wielomian): Wielomian {
        var wynik = mutableListOf<Double>()
        val stopien1 = stopien()
        val stopien2 = wielomian.stopien()

        val minStopien = minOf(stopien1, stopien2)
        for (i in 0..minStopien) {
            wynik.add(wspolczynniki[wspolczynniki.size - i - 1] - wielomian.wspolczynniki[wielomian.wspolczynniki.size - i - 1])
        }
        if (stopien1 > stopien2) {
            for (i in minStopien + 1..stopien1) {
                wynik.add(-wspolczynniki[wspolczynniki.size - i - 1])
            }
        } else {
            for (i in minStopien + 1..stopien2) {
                wynik.add(-wielomian.wspolczynniki[wielomian.wspolczynniki.size - i - 1])
            }
        }
        wynik = wynik.reversed() as MutableList<Double>
        return Wielomian(wynik)
    }

    /**
     * Funkcja times mnoży dwa wielomiany
     * @param wielomian drugi wielomian do mnożenia
     * @return wynik mnożenia wielomianów
     */
    operator fun times(wielomian: Wielomian): Wielomian {
        var wynik = mutableListOf<Double>()
        val stopien1 = stopien()
        val stopien2 = wielomian.stopien()

        val minStopien = minOf(stopien1, stopien2)
        for (i in 0..minStopien) {
            wynik.add(wspolczynniki[wspolczynniki.size - i - 1] * wielomian.wspolczynniki[wielomian.wspolczynniki.size - i - 1])
        }
        wynik = wynik.reversed() as MutableList<Double>
        return Wielomian(wynik)
    }
}



fun main(){
    val wielomian1 = Wielomian(mutableListOf(1.0, 2.0, 3.0))
    val wielomian2 = Wielomian(mutableListOf(1.0, 2.0, 3.0))
    val wielomian3 = Wielomian(mutableListOf(4.0))
    val wielomian4 = Wielomian(mutableListOf(1.0, 0.0, 0.0, 0.0))

    val stopien = wielomian1.stopien()
    check(stopien == 2){"Wynik powinien byc rowny 2"}

    val tekst = wielomian1.tekst()
    check(tekst == "1.0x^2 + 2.0x^1 + 3.0x^0"){"Wynik powinien byc rowny 1.0x^2 + 2.0x^1 + 3.0x^0"}

    val wartosc = wielomian1(2.0)
    check(wartosc == 11.0){"Wynik powinien byc rowny 11.0"}

    val wynikDodawanie = wielomian1 + wielomian2
    check(wynikDodawanie.tekst() == "2.0x^2 + 4.0x^1 + 6.0x^0"){"Wynik powinien byc rowny 2.0x^2 + 4.0x^1 + 6.0x^0"}

    val wynikOdejmowanie = wielomian1 - wielomian2
    check(wynikOdejmowanie.tekst() == "0.0x^2 + 0.0x^1 + 0.0x^0"){"Wynik powinien byc rowny 0.0x^2 + 0.0x^1 + 0.0x^0"}

    val wynikMnozenie = wielomian1 * wielomian2
    check(wynikMnozenie.tekst() == "1.0x^2 + 4.0x^1 + 9.0x^0"){"Wynik powinien byc rowny 1.0x^2 + 4.0x^1 + 9.0x^0"}

    val wynikMnozenie2 = wielomian1 * wielomian3
    check(wynikMnozenie2.tekst() == "12.0x^0"){"Wynik powinien byc rowny 12.0x^0"}

    val wynikMnozenie3 = wielomian1 * wielomian4
    check(wynikMnozenie3.tekst() == "0.0x^2 + 0.0x^1 + 0.0x^0"){"Wynik powinien byc rowny 0.0x^2 + 0.0x^1 + 0.0x^0"}

    println("Wszystkie testy przeszly pomyslnie")

}