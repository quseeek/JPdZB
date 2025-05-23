fibonacci <- function(n) {
  
  if (n <= 0){
    return (NULL)
  } else if (n == 1) {
    return (list(1))
  } else if (n == 2) {
    return (list(1, 1))
  } else {
    
    fibonacci <- list(1, 1)
    
    for (i in 2:n) {
      fibonacci <- c(fibonacci, (fibonacci[[i]] + fibonacci[[i - 1]]))
      
    }
    return(fibonacci)
  }
}

n <- 0
wynik <- fibonacci(n)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}

n <- (-10)
wynik <- fibonacci(n)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}

n <- 10
wynik <- fibonacci(n)
if (is.null(wynik)){
  print("Argument musi byc liczba calkowita dodatnia!")
} else {
  cat(n, "pierwszych wyrazów ciągu Fibonacciego:", unlist(wynik))
}


