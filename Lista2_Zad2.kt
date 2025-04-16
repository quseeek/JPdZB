package com.example.jzykiprogramowaniadozastosowabiomedycznych.Lista_1

/**
 * @author Sebastian Kłusek 268412
 */

class DNASequence(val identifier: String, var data: String) {

    val VALID_CHARS = setOf('A', 'T', 'C', 'G')


    val length = data.length

    override fun toString(): String {
        return ">$identifier\n$data"
    }

    fun mutate(position: Int, value: Char): String {
        require(value in VALID_CHARS) { "Nieprawidlowa zasada DNA: $value" }
        data = data.substring(0, position) + value + data.substring(position + 1)
        return data
    }

    fun findMotif(motif: String): Int {
        return data.indexOf(motif)
    }

    fun complement(): String {
        var result = ""
        for (i in data.indices) {
            val char = data[i]
            when (char) {
                'A' -> result += 'T'
                'T' -> result += 'A'
                'G' -> result += 'C'
                'C' -> result += 'G'
                else -> result += char
            }
        }
        return result
    }

    fun transcribe(): RNASequence {
        val rnaData = data.replace('T', 'U')
        return RNASequence(identifier, rnaData)
    }
}

class RNASequence(val identifier: String, var data: String) {

    val VALID_CHARS = setOf('A', 'U', 'C', 'G')

    val length = data.length

    override fun toString(): String {
        return ">$identifier\n$data"
    }

    fun mutate(position: Int, value: Char): String {
        require(value in VALID_CHARS) { "Nieprawidlowa zasada RNA: $value" }
        data = data.substring(0, position) + value + data.substring(position + 1)
        return data
    }

    fun findMotif(motif: String): Int {
        return data.indexOf(motif)
    }

    fun transcribe(): ProteinSequence {
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

        var proteinData = ""
        var i = 0
        while (i < data.length - 2) {
            val kodon = data.substring(i, i + 3)
            if (kodon == "AUG" || proteinData != "") {
                if (tabela[kodon] == "Stop") {
                    break
                }
                proteinData += tabela[kodon] ?: ""
            }
            i += 3
        }
        return ProteinSequence(identifier, proteinData)
    }

}

class ProteinSequence(val identifier: String, var data: String) {

    val VALID_CHARS = setOf(
        "Ala",
        "Cys",
        "Asp",
        "Glu",
        "Phe",
        "Gly",
        "His",
        "Ile",
        "Lys",
        "Leu",
        "Met",
        "Asn",
        "Pro",
        "Gln",
        "Arg",
        "Ser",
        "Thr",
        "Val",
        "Trp",
        "Tyr"
    )

    val length = data.length / 3

    override fun toString(): String {
        return ">$identifier\n$data"
    }

    fun mutate(position: Int, value: String): String {
        require(value in VALID_CHARS) { "Nieprawidlowy skrot aminokwasu bialkowego: $value" }
        data = data.substring(0, position * 3) + value + data.substring(position * 3 + 3)
        return data
    }

    fun findMotif(motif: String): Int {
        return data.indexOf(motif)
    }

}


fun main() {
    val dna = DNASequence("seq1", "ATGCGTACG")

    // testy DNASequence
    // toString()
    val fasta = ">seq1\nATGCGTACG"
    check(dna.toString() == fasta) { "toString powinno zwracac $fasta" }

    // length
    check(dna.length == 9) { "Długosc sekwencji DNA powinna wynosic 9" }

    // mutate()
    dna.mutate(3, 'A')
    check(dna.data == "ATGAGTACG") { "Po mutacji DNA na pozycji 3 powinno byc ATGAGTACG" }

    // findMotif()
    val motifPosDNA = dna.findMotif("GTAC")
    check(motifPosDNA == 4) { "Motyw GTAC w DNA powinien zaczynac sie na pozycji 4" }

    // complement()
    val complement = dna.complement()
    check(complement == "TACTCATGC") { "Nic komplementarna powinna byc TACTCATGC" }

    // transcribe()
    val rna = dna.transcribe()
    check(rna.data == "AUGAGUACG") { "Sekwencja RNA powinna byc AUGAGUACG" }
    check(rna.identifier == "seq1") { "Identyfikator RNA powinien byc taki sam jak DNA" }


    // testy RNASequence
    // toString()
    val fasta2 = ">seq1\nAUGAGUACG"
    check(rna.toString() == fasta2) { "toString RNA powinno zwracac $fasta2" }

    // length
    check(rna.length == 9) { "Dlugosc sekwencji RNA powinna wynosic 9" }

    // mutate()
    rna.mutate(4, 'C')
    check(rna.data == "AUGACUACG") { "Po mutacji RNA na pozycji 4 powinno byc AUGACUACG" }

    // findMotif()
    val motifPosRNA = rna.findMotif("CUA")
    check(motifPosRNA == 4) { "Motyw CUA w RNA powinien zaczynac się na pozycji 4" }

    // transcribe()
    val protein = rna.transcribe()
    check(protein.data == "MetThrThr") { "Sekwencja bialka powinna byc MetThrThr" }
    check(protein.identifier == "seq1") { "Identyfikator bialka powinien byc taki sam jak RNA" }


    // testy ProteinSequence
    // toString()
    val fasta3 = ">seq1\nMetThrThr"
    check(protein.toString() == fasta3) { "toString bialka powinno zwracac $fasta3" }

    // length
    check(protein.length == 3) { "Dlugosc sekwencji aminokwasow bialkowych powinna wynosic 3" }

    // mutate()
    protein.mutate(1, "Val")
    check(protein.data == "MetValThr") { "Po mutacji bialka powinno byc MetValThr" }

    // findMotif()
    val motifPosProtein = protein.findMotif("Val")
    check(motifPosProtein == 3) { "Motyw Val w bialku powinien zaczynac sie na pozycji 3" }

    println("Wszystkie testy DNASequence przeszly pomyslnie.")
}
