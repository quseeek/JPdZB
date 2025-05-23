heron <- function(a, b, c) {
  
  if (a+b <= c || a+c <= b || b+c <= a || a <= 0 || b <= 0 || c <= 0){
    return(NULL)
  } else {
    s<- (a + b + c) / 2
    p <- sqrt(s*(s-a)*(s-b)*(s-c))
    return(p)
  }
}

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