# Monte Carlo Simulation????

# Q1
generate_unif_bdates <- function(n) {
  bdates <- sample(1:365,n, replace=TRUE)
  if (length(unique(bdates)) != length(bdates)) {
    return(1)
  } else {
    return(0)
  }
}

# Q2
simulate_clashes <- function(m,n) {
  number_of_clashes <- 0
  for (i in 1:m) {
    number_of_clashes <- (number_of_clashes + generate_unif_bdates(n))
  }
  return(number_of_clashes/m)
}

# Q3: number of people changing
simulate_people <- function(m, low, high) {
  ret <- numeric(high-low+1)
  for (i in low:high) {
    ret[i-low+1] <- simulate_clashes(m, i)
  }
  return(ret)
}

# Q4: graph
prob <-simulate_people(100,10,50)
plot(y=prob, x=10:50, 
     ylab="Prob.",
     xlab="No. of individuals in a group", 
     type="b")

# Q5: confidence intervals

