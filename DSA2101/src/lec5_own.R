
library(tidyverse)

exp_cat <- str_to_title(c("manpower", "asset", "other"))
amount <- c(519.4, 38, 141.4)
op_budget <- data.frame(amount, exp_cat)
op_budget

ggplot(op_budget) +
  geom_col(aes(x=exp_cat, y=amount))