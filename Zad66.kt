package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun komplement(nicKodujaca: String): String {
    /**
     * Funkcja, która dla sekwencji nici kodującej DNA znajduje i zwraca sekwencję nici matrycowej.
     * Zasady komplementarności:
     * A ↔ T, C ↔ G
     */
    val mapaKomplementarna = mapOf('A' to 'T', 'T' to 'A', 'C' to 'G', 'G' to 'C')
    return nicKodujaca.map { mapaKomplementarna[it] ?: it }.joinToString("")
}

fun transkrybuj(nicMatrycowa: String): String {
    /**
     * Funkcja, która dla sekwencji nici matrycowej DNA znajduje i zwraca sekwencję RNA.
     * Zasady transkrypcji:
     * A → U, T → A, C → G, G → C
     */
    val mapaTranskrypcji = mapOf('A' to 'U', 'T' to 'A', 'C' to 'G', 'G' to 'C')
    return nicMatrycowa.map { mapaTranskrypcji[it] ?: it }.joinToString("")
}

fun transluj(mRNA: String): List<String> {
    /**
     * Funkcja, która dla sekwencji mRNA znajduje i zwraca sekwencję białka.
     * Kodony są odczytywane w trójkach.
     */

    val kodonTabela = mapOf(
        "UUU" to "Phe", "UUC" to "Phe", "UUA" to "Leu", "UUG" to "Leu",
        "CUU" to "Leu", "CUC" to "Leu", "CUA" to "Leu", "CUG" to "Leu",
        "AUU" to "Ile", "AUC" to "Ile", "AUA" to "Ile", "AUG" to "Met",
        "GUU" to "Val", "GUC" to "Val", "GUA" to "Val", "GUG" to "Val",
        "UCU" to "Ser", "UCC" to "Ser", "UCA" to "Ser", "UCG" to "Ser",
        "CCU" to "Pro", "CCC" to "Pro", "CCA" to "Pro", "CCG" to "Pro",
        "ACU" to "Thr", "ACC" to "Thr", "ACA" to "Thr", "ACG" to "Thr",
        "GCU" to "Ala", "GCC" to "Ala", "GCA" to "Ala", "GCG" to "Ala",
        "UAU" to "Tyr", "UAC" to "Tyr", "UAA" to "STOP", "UAG" to "STOP",
        "CAU" to "His", "CAC" to "His", "CAA" to "Gln", "CAG" to "Gln",
        "AAU" to "Asn", "AAC" to "Asn", "AAA" to "Lys", "AAG" to "Lys",
        "GAU" to "Asp", "GAC" to "Asp", "GAA" to "Glu", "GAG" to "Glu",
        "UGU" to "Cys", "UGC" to "Cys", "UGA" to "STOP", "UGG" to "Trp",
        "CGU" to "Arg", "CGC" to "Arg", "CGA" to "Arg", "CGG" to "Arg",
        "AGU" to "Ser", "AGC" to "Ser", "AGA" to "Arg", "AGG" to "Arg",
        "GGU" to "Gly", "GGC" to "Gly", "GGA" to "Gly", "GGG" to "Gly"
    )

    val bialka = mutableListOf<String>()
    var start = mRNA.indexOf("AUG")
    if (start == -1) return emptyList()

    while (start + 2 < mRNA.length) {
        val kodon = mRNA.substring(start, start + 3)
        val aminokwas = kodonTabela[kodon] ?: break
        if (aminokwas == "STOP") break
        bialka.add(aminokwas)
        start += 3
    }
    return bialka
}

// Przykładowe wywołania:
fun main() {
    val dnaKodujaca = "ATGCGTACG"
    val dnaMatrycowa = komplement(dnaKodujaca)
    val rna = transkrybuj(dnaMatrycowa)
    val bialka = transluj(rna)

    println("Nici matrycowa: $dnaMatrycowa")
    println("Sekwencja RNA: $rna")
    println("Sekwencja bialek: ${bialka.joinToString(", ")}")
}



