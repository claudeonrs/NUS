
library(tidyverse)

exp_cat <- str_to_title(c("manpower", "asset", "other"))
amount <- c(519.4, 38, 141.4)
op_budget <- data.frame(amount, exp_cat)
op_budget

ggplot(op_budget) +
  geom_col(aes(x=exp_cat, y=amount))

ggplot(mpg) + 
  geom_bin2d(aes(x=displ, y=hwy), binwidth=c(0.5,5)) + 
  #scale_fill_gradient(type = "viridis")
  scale_fill_gradientn(colours = terrain.colors(10))

library(corrplot)
corrplot(cor(mtcars), 
         method="color",
         type = "upper", 
         order = "hclust", 
         tl.col = "black", tl.srt = 45)
)