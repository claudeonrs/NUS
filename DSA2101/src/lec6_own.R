library(tidyverse)
library(lubridate)

arrests <- readRDS("../data/arrests.rds")
lit2 <- readRDS("../data/lit2.rds")

iris %>% ggplot(aes(x=Species, y=Sepal.Length)) + 
  stat_summary(fun.data=mean_sdl)

## What is the most common value?
diamonds %>% 
  ggplot(aes(x=cut)) +
  geom_bar()

diamonds %>% 
  ggplot(aes(x=carat, y=price)) +
  geom_jitter(alpha=0.1) + 
  geom_smooth()

diamonds %>% 
  ggplot(aes(x=depth, y=price)) +
  geom_col()


diamonds %>%
  group_by(color, cut) %>%
  summarise(n=n()) %>%
  pivot_wider(names_from=color, values_from = n) -> hey
  
diamonds %>% ggtable("color", "cut", cells="col.prop", fill="std.res")
diamonds %>% ggtable("color", "cut", cells="col.prop", fill="std.res") + scale_fill_brewer(palette="Oranges")

diamonds %>%
  ggplot() +
  geom_bar(aes(x=color, fill=cut), position="fill")

## lit2
lit2 %>%
  ggplot() +
  geom_boxplot(aes(x=reg1, y=m_raw_pct))

## arrests
to_df <- function(x) {
  x$citizenship
  x$age
}



# iris

iris %>% 
  ggplot(aes(sample=Sepal.Length)) + 
  stat_qq() +
  geom_qq_line(col="red")

### SP1541

data <- read.csv("../data/all_currencies.csv")
data %>% 
  mutate(Year=str_sub(Date, 1,4)) %>%
  group_by(Year) %>%
  summarise(mean_vol=mean(Volume,na.rm=TRUE), mean_mc=mean(Market.Cap,na.rm=TRUE)) %>%
  pivot_longer(mean_vol:mean_mc, names_to = "variable", values_to = "value") %>%
  mutate(value=value/10^6) %>%
  ggplot() +
  geom_col(aes(x=Year, y=value, fill=variable)) + 
  scale_fill_discrete(name="Cryptocurrency traded", labels=c("Avg. Market Cap.", "Avg. Volume")) +
  labs(y="million USD") + 
  theme_linedraw() + 
  scale_fill_brewer(palette=2)

####
cor_mtcars <- select(mtcars, which(!sapply(mtcars, is.factor))) %>%
  cor(. , use="pair")
hc <- hclust(as.dist((1-cor_mtcars)/2))
plot(as.dendrogram(hc))