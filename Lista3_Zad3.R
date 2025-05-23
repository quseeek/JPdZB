podzbiory <- function(zbior) {
  
  n <- length(zbior)
  wszystkie <- list()
  
  for (i in 0:(2^n - 1)) {
    maska <- as.logical(intToBits(i))[1:n]
    podzbior <- zbior[maska]
    wszystkie[[length(wszystkie) + 1]] <- podzbior
  }
  
  return(wszystkie)
}


wynik <- podzbiory(c("a", "b", "c", "d"))
print(wynik)