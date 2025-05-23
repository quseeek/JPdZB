#' @author Sebastian Kłusek 268412
#' 
#' Funkcja zwraca n pierwszych wyrazów ciągu Fibonacciego.
#' Ciąg zaczyna się od 1, 1, 2, 3, 5, 8, ...
#'
#' @param n liczba wyrazów ciągu Fibonacciego
#' @param fibonacci lista przechowująca kolejne elementy ciągu Fibonacciego
#' @return lista zawierająca n pierwszych wyrazów ciągu Fibonacciego lub null, jeśli dane wejściowe są niepoprawne
#' 
fibonacci <- function(n, fibonacci_wejscie) {
  
  if (n <= 0){
    return (NULL)
  } else if (n == 1) {
    return (list(1))
  } else if (n == 2) {
    return (list(1, 1))
  } else {
    
      if (length(fibonacci_wejscie) < n){
        fibonacci_wejscie <- c(fibonacci_wejscie, (fibonacci_wejscie[[length(fibonacci_wejscie)]] + fibonacci_wejscie[[length(fibonacci_wejscie) - 1]]))
    
        return(fibonacci(n, fibonacci_wejscie))
      }
    }
  return(fibonacci_wejscie)
}

fibonacci_list <- list(1, 1)
n <- 0
wynik <- fibonacci(n, fibonacci_list)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}

n <- (-10)
wynik <- fibonacci(n, fibonacci_list)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}

n <- 10
wynik <- fibonacci(n, fibonacci_list)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}