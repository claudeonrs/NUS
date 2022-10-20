library(tidyverse)

data <- read.csv("../data/data2210")
x <- data %>%
  filter(V1 == "A0239079R") %>%
  select(starts_with("X")) %>%
  apply(1, function(x) x)

# estimate alpha given vector using MOM
estimate_alpha <- function(x) {
  mean(x)^2/sd(x)^2
}
# estimate lambda given vector using MOM
estimate_lambda <- function(x) {
  mean(x)/sd(x)^2
}

alpha_est <- estimate_alpha(x)
lambda_est <- estimate_lambda(x)

x_star <- rgamma(1000*1000, shape=alpha_est, rate=lambda_est)
x_mat <- matrix(x_star, nrow=1000)

# estimations for parameters of each row
alpha_star <- apply(x_mat, 1, estimate_alpha)
lambda_star <- apply(x_mat, 1, estimate_lambda)

se_alpha <- sd(alpha_star)
se_lambda <- sd(lambda_star)

E_alpha_star <- mean(alpha_star)
bias_alpha <- E_alpha_star - alpha_est

E_lambda_star <- mean(lambda_star)
bias_lambda <- E_lambda_star - lambda_est

alpha_final <- alpha_est - bias_alpha
lambda_final <- lambda_est - bias_lambda