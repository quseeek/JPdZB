package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

fun dnaNaRNA(dna: List<Char>): List<Char> {
    val rna = dna.map {
        when (it) {
            'A' -> 'U'
            'T' -> 'A'
            'G' -> 'C'
            'C' -> 'G'
            else -> return listOf('B') // Błąd, jeśli niepoprawny nukleotyd
        }
    }
    return rna.reversed() // Odwrócenie kolejności, by uzyskać nić w kierunku 5' do 3'
}

fun mRNADoBialek(mRNA: List<Char>): List<String> {
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

    val proteins = mutableListOf<String>()
    for (i in mRNA.indices step 3) {
        if (i + 2 < mRNA.size) {
            val kodon = "${mRNA[i]}${mRNA[i + 1]}${mRNA[i + 2]}"
            kodonTabela[kodon]?.let { proteins.add(it) }
            if (kodonTabela[kodon] == "STOP") break
        }
    }
    return proteins
}


fun main() {
    val dnaSequence = listOf('A', 'G', 'A', 'C', 'T')
    val rnaSequence = dnaNaRNA(dnaSequence)
    println("RNA: $rnaSequence")

    val proteins = mRNADoBialek(rnaSequence)
    println("Białka: $proteins")
}


