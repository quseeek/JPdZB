package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun komplement(dna: String): String {
    /**
     * Funkcja, która dla sekwencji nici kodującej DNA znajduje i zwraca sekwencję nici matrycowej.
     * Zasady komplementarności:
     * A <-> T, C <-> G
     *
     * @param dna sekwencja nici kodującej DNA
     * @return wynik sekwencja nici matrycowej
     */
    var wynik = ""
    for (i in dna) {
        if (i == 'A') {
            wynik += "T"
        } else if (i == 'T') {
            wynik += "A"
        } else if (i == 'C') {
            wynik += "G"
        } else if (i == 'G') {
            wynik += "C"
        } else {
            return "Niepoprawna sekwencja DNA"
        }
    }
    return wynik
}

fun transkrybuj(dna: String): String {
    /**
     * Funkcja, która dla sekwencji nici matrycowej DNA znajduje i zwraca sekwencję RNA.
     * Zasady transkrypcji:
     * A -> U, T -> A, C -> G, G -> C
     *
     * @param dna sekwencja nici matrycowej DNA
     * @return wynik sekwencja RNA
     */
    var wynik = ""
    for (i in dna) {
        if (i == 'A') {
            wynik += "U"
        } else if (i == 'T') {
            wynik += "A"
        } else if (i == 'C') {
            wynik += "G"
        } else if (i == 'G') {
            wynik += "C"
        } else {
            return "Niepoprawna sekwencja DNA"
        }
    }
    return wynik
}

fun transluj(mrna: String): String {
    /**
     * Funkcja, która dla sekwencji mRNA znajduje i zwraca sekwencję białka.
     * Kodony są odczytywane w trójkach.
     *
     * @param mrna sekwencja mRNA
     * @return wynik sekwencja białka
     */
    val tabela = mapOf(
        "UUU" to "Phe", "UUC" to "Phe", "UUA" to "Leu", "UUG" to "Leu",
        "CUU" to "Leu", "CUC" to "Leu", "CUA" to "Leu", "CUG" to "Leu",
        "AUU" to "Ile", "AUC" to "Ile", "AUA" to "Ile", "AUG" to "Met",
        "GUU" to "Val", "GUC" to "Val", "GUA" to "Val", "GUG" to "Val",

        "UCU" to "Ser", "UCC" to "Ser", "UCA" to "Ser", "UCG" to "Ser",
        "CCU" to "Pro", "CCC" to "Pro", "CCA" to "Pro", "CCG" to "Pro",
        "ACU" to "Thr", "ACC" to "Thr", "ACA" to "Thr", "ACG" to "Thr",
        "GCU" to "Ala", "GCC" to "Ala", "GCA" to "Ala", "GCG" to "Ala",

        "UAU" to "Tyr", "UAC" to "Tyr", "UAA" to "Stop", "UAG" to "Stop",
        "CAU" to "His", "CAC" to "His", "CAA" to "Gln", "CAG" to "Gln",
        "AAU" to "Asn", "AAC" to "Asn", "AAA" to "Lys", "AAG" to "Lys",
        "GAU" to "Asp", "GAC" to "Asp", "GAA" to "Glu", "GAG" to "Glu",

        "UGU" to "Cys", "UGC" to "Cys", "UGA" to "Stop", "UGG" to "Trp",
        "CGU" to "Arg", "CGC" to "Arg", "CGA" to "Arg", "CGG" to "Arg",
        "AGU" to "Ser", "AGC" to "Ser", "AGA" to "Arg", "AGG" to "Arg",
        "GGU" to "Gly", "GGC" to "Gly", "GGA" to "Gly", "GGG" to "Gly"
    )

    var wynik = ""
    var i = 0
    while (i < mrna.length - 2) {
        val kodon = mrna.substring(i, i + 3)
        if (kodon == "AUG" || wynik != "") {
            if (tabela[kodon] == "Stop") {
                break
            }
            wynik += tabela[kodon] ?: ""
        }
        i += 3
    }
    return wynik
}

fun main() {
    // Test funkcji komplement
    val nicKodujaca = "CAGATGCGATCGTAGCGA" //CAG, ATG -> START, CGA, TCG, TAG -> STOP, CGA
    val nicMatrycowa = komplement(nicKodujaca)
    println("Nici kodujaca: $nicKodujaca")
    println("Komplementarna nic matrycowa: $nicMatrycowa")

    // Test funkcji transkrypcji
    val rna = transkrybuj(nicMatrycowa)
    println("RNA po transkrypcji: $rna")

    // Test funkcji translacji
    val bialko = transluj(rna)
    println("Sekwencja bialka: $bialko")

    // Dodatkowy test funkcji komplement z błędnym DNA
    val blad = komplement("ATXB")
    println("Test z bledna sekwencja: $blad")
}




