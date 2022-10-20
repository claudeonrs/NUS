library(tidyverse)
# library(nycflights13)
# str(flights)

flights %>% filter(!is.na(dep_delay)) %>% 
  group_by(origin) %>%
  summarise(rr=range(dep_delay, na.rm=TRUE))


# Commodity

commodity <- read.csv("../custom-datasets/commodity/commodity_futures.csv")
cats <- read.csv("../custom-datasets/commodity/list_of_categories.csv")

commodity$Date <- as.Date(commodity$Date)

plot(y=(commodity$GASOLINE)/max(commodity$GASOLINE, na.rm=TRUE), x=commodity$Date, type="l")
lines(y=(commodity$NATURAL.GAS)/max(commodity$NATURAL.GAS, na.rm=TRUE), x=commodity$Date, type="l", col="red")


### TIDYDATA
epl <- readRDS ("../data/epl_topic_03.rds") %>%
  as_tibble()
epl_names <- colnames(epl)
epl %>% mutate(across(FGT:NGW, as.character)) %>%
  pivot_longer(FGT:NGW, names_to=c("goal", "info_type"), values_to="info", names_sep = -1) %>%
  pivot_wider(id_cols=Date:goal, names_from=info_type, values_from=info)

## RELATIONAL 
library(nycflights13)
## airports, flights, weather, planes, airlines