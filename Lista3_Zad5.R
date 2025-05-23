#' @author Sebastian Kłusek 268412
#' 
#' Generuje ciąg Collatza dla zadanej liczby n.
#' Ciąg kończy się, gdy osiągnięta zostanie liczba 1, później ciąg wpadłby w pętlę 4, 2, 1.
#'
#' @param n liczba początkowa ciągu
#' @param wynik lista przechowująca kolejne elementy ciągu
#' @return lista zawierająca cały ciąg Collatza lub null, jeśli dane wejściowe są niepoprawne
#' 
collatz <- function(n, wynik) {
  
  wynik <- c(wynik, n)
  
  if (wynik[length(wynik)] == 1) {
    return (wynik)
  } else if (n %% 2 == 0) {
    return (collatz((n / 2), wynik))
  } else {
    return (collatz((3*n+1), wynik))
  }
}


x <- 10001
wynik <- list()

wynik2 <- collatz(x, wynik)
max <- max(unlist(wynik2))

cat("Ciag Collatza zaczynajac od c0 =",x, "przed wpadnieciem w cykl:", unlist(wynik2))

cat("Maksymalna wartosc ciagu Collatza zaczynajac od c0 =",x,"to:", max)