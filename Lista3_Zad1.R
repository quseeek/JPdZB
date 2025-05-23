#' @author Sebastian Kłusek 268412
#' 
#' Funkcja obliczająca pole powierzchni trójkąta za pomocą wzoru Herona.
#'
#' @param a długość boku a
#' @param b długość boku b
#' @param c długość boku c
#' @return pole powierzchni trójkąta lub null, jeśli dane wejściowe są niepoprawne
#' 
heron <- function(a, b, c) {
  
  if (a+b <= c || a+c <= b || b+c <= a || a <= 0 || b <= 0 || c <= 0){
    return(NULL)
  } else {
    s<- (a + b + c) / 2
    p <- sqrt(s*(s-a)*(s-b)*(s-c))
    return(p)
  }
}

#'Funkcja testująca funkcję heron
#'
test <- function(a, b, c) {
  p <- heron(a, b, c)
  if (is.null(p)){
    print("Trójkąt o podanych bokach nie istnieje!")
  } else {
    print("Pole powierzchni podanego trójąta wynosi: ")
    print(p)
  }
}

test(3,4,5)