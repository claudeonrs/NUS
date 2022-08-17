# Slide 3: Installing R

# Slide 4: R Graphical User Interface (GUI)

# Slide 5: An IDE for R

# Slide 6: Installing RStudio

# Slide 7: RStudio Interface

# Slide 8: RStudio Panels

# Slide 9: RStudio Panels

# Slide 10: RStudio Projects
setwd("./src")

# Slide 11: The Working Directory
getwd()
#setwd() 
list.files("../data/")
list.files("/home/viknesh/NUS/coursesTaught/dsa2101/src")

# Slide 12: The `?' Operator
?mean
??mean

# Slide 13: The Help Pages

# Slide 14: Code Completion Feature

# Slide 15: R Packages
# installs stringr package, and its dependencies.
install.packages("stringr")
library(stringr)
help(package="stringr")

# Slide 17: Object Oriented

# Slide 18: Naming Objects in R
FALSE Inf NA NaN NULL TRUE
break else for function if in next repeat while
c q s t C D F I T

# Slide 19: Vectors
Z <- c(1,2,3)
Z
# Compare to Python syntax:
Z = [1,2,3]

# Slide 20: Creating Vectors
-2:2              # creates an evenly spaced sequence.
X <- -2:2         # assign name X to sequence
Y <- 2^X          # raise 2 to powers given by X
Y                 # print Y

# Slide 21: Accessing Elements Within a Vector
Y[2]          # Access element 2
Y[2:4]        # Access elements 2,3 and 4
Y[length(Y)]  # Access the last element

# Slide 22: Classes

# Slide 23: Vector Classes Examples
abc <- c("a", "b", "c")          # character
W <- c(1.2)                      # numeric, length 1
A <- c(TRUE, TRUE, FALSE, TRUE)  # logical

# Slide 24: Matrices
mymat <- matrix(1:9, nrow=3, ncol=3)
mymat       # try dim(mymat)
mymat[4]

# Slide 25: Accessing Elements in a Matrix
mymat[3,2]

# Slide 26: Accessing Rows and Columns of a Matrix
mymat[2, ]
mymat[c(1,3), ]

# Slide 27: Accessing Named Rows and Columns
rownames(mymat) <- c("a", "b", "c")
colnames(mymat) <- c("i", "ii", "iii")
mymat["b","iii"]
mymat["b",c("i","iii")]

# Slide 28: Data Frames

# Slide 29: Creating Data Frames

# Slide 30: Creating Data Frames
exp_cat <- c("manpower", "asset", "other")
amount <- c(519.4, 38, 141.4)
op_budget <- data.frame(amount, exp_cat)
op_budget

# Slide 31: Accessing Data Frames
op_budget[, "exp_cat"]
op_budget[c(3,2), ]

# Slide 32: Accessing Data Frames
op_budget$amount
op_budget$amount[1:2]

# Slide 33: Datasets in R
class(cars)
names(cars)
head(cars, n=3)      # to see the first few rows. 

# Slide 34: Lists

# Slide 35: Creating and Accessing Lists
ls1 <- list(A=seq(1, 5, by=2), B=seq(1, 5, length=4))
ls1
ls1[[2]]
ls1[["B"]] # ls1$B is also OK

# Slide 36: Saving and Reading Back Objects
saveRDS(ls1, file="ls1.rds")
ls2 <- readRDS("ls1.rds")
ls2

# Slide 37: Alternatives to RDS

# Slide 38: Removing Objects from the Workspace
x <- 1:5
rm(list = c("x"))    # removes object named x
rm(list = ls())      # removes ALL objects! Be careful!

# Slide 39: Investigating the Structure of an Object
hawkers <- readRDS("../data/hawker_ctr_raw.rds")
class(hawkers)
str(hawkers, max.level = 1)

# Slide 40: Hawkers Dataset
# Try this:
str(hawkers[[1]], max.level = 1) 

# Slide 41: Hawkers Dataset
str(hawkers[[1]][[2]], max.level=1)

# Slide 43: Expresssions and Assignments
pi + 1
a <- 6 + 2

# Slide 44: Arithmetic Expressions
x + y
x - y
x * y
x / y
x ^ y
?Arithmetic

# Slide 45: Vectorised Operations
x <- 5:10
y <- 10:15
x + y

# Slide 46: The Recycling Rule
x <- 5:10
x + 2

# Slide 47: The Recycling Rule

# Slide 48: The Recycling Rule
x <- 5:10      # a vector of length 6
y <- c(x,x)    # a vector of length 12 
2*x + y + 1    # a vector of length 12 

# Slide 49: Logical Expressions
x < y; x <= y ; x > y ; x >= y ; x == y ; x != y

# Slide 50: Examples of Logical Expressions
x <- 1:5
x < 3
x == 1
x != 17

# Slide 51: Logical Expressions
y <- x <= 3
z <- x >= 3
y & z 
!y

# Slide 52: Logical Expressions

# Slide 53: Selection with Logical Expressions
x
y
x[y]

# Slide 55: Conditional Executions

# Slide 56: Craps Flowchart

# Slide 57: Craps Flowchart

# Slide 58: Rolling a Die
sample(1:6, size=1)
sample(1:6, size=2, replace=TRUE)

# Slide 59: Code for Craps
die_values <- sample(1:6, size=2, replace=TRUE)
total_val <- sum(die_values)
  
if(total_val %in% c(7, 11)){
  outcome <- "win"
} else if (total_val %in% c(2, 3, 12)) {
  outcome <- "loss"
} else {
  point <- total_val
  total_val <- 0 
  repeat {
    die_values <- sample(1:6, size=2, replace=TRUE)
    total_val <- sum(die_values)
      
    if(total_val == 7){
      outcome <- "loss"
      break
    } else if (total_val == point) {
      outcome <- "win"
      break
    }
  }
}

# Slide 60: Code for Craps

# Slide 61: Repeated Executions

# Slide 62: 10000 Games of Craps
set.seed(2102)                    # for reproducibility
res1 <- rep("a", 10000)           # instantiate results vector

for(i in seq_along(res1)) {       # 'for' loop begins here
  # Craps code from previous slide here
  # ...
  # ...
  res1[i] <- outcome
}
table(res1)

# Slide 64: Function Arguments
args(plot.default)

# Slide 66: Function \texttt{seq()}
# Sequence using by:
seq(from=1, to=2, by=0.2)
# Sequence using length:
seq(from=1, to=2, length=4)

# Slide 67: Function \texttt{rep()}
x <- seq(1, 2, length=3)
rep(x, times=3)
rep(x, times=c(1,2,3))

# Slide 68: Function \texttt{paste()}
paste("A", 1:6, sep = "")
paste(c("A","B"), 1:3, sep = "")

# Slide 70: Writing Your Own Functions

# Slide 71: Craps Function
craps_game <- function() {
  die_values <- sample(1:6, size=2, replace=TRUE)
  total_val <- sum(die_values)

  if(total_val %in% c(7, 11)){
    return("win")
  } else if (total_val %in% c(2, 3, 12)) {
    return("loss")
  } else {
    point <- total_val
  }
  total_val <- 0
  repeat {
    die_values <- sample(1:6, size=2, replace=TRUE)
    total_val <- sum(die_values)

    if(total_val == 7){
      return("loss")
    } else if (total_val == point) {
      return("win")
    }
  }
}

# Slide 72: Clearer Code
set.seed(2102)

res1 <- rep("a", 10000)   

for(i in seq_along(res1)) {    
  res1[i] <- craps_game()
}

# Slide 73: Debugging

# Slide 74: Debugging From Start To Finish
debug(craps_game)
craps_game()
undebug(craps_game)

# Slide 76: Repeated Application of Functions

# Slide 77: The \texttt{apply()} Function
set.seed(2105)
X <- rnorm(200, mean=2, sd=2)
X <- matrix(X, nrow=100)
head(X, n=2)

# Slide 78: The \texttt{apply()} Function
col_means <- apply(X, 2, mean)
col_means
row_means <- apply(X, 1, mean)
head(round(row_means, digits = 2))

# Slide 79: The \texttt{apply()} Function
trimmed_col_means <- apply(X, 2, mean, trim=0.1)
trimmed_col_means

# Slide 80: Anonymous Functions
apply(X, 2, function(x) sum(x > 0)/nrow(X))

# Slide 81: Not A Matrix

# Slide 82: \texttt{sapply()} With Hawker Centre Data.
hawk_116 <- hawkers[[1]][-1]
str(hawk_116, max.level = 1)

# Slide 83: Retrieving Street Names
hawk_116[[2]]$ADDRESSSTREETNAME
street_names <- sapply(hawk_116, function(x) x$ADDRESSSTREETNAME)
head(street_names)

# Slide 84: Replacing a \texttt{for} Loop
set.seed(2102)
game_results <- sapply(1:10000, function(x) craps_game())
table(game_results)

# Slide 85: The \texttt{lapply} Function
set.seed(2106)
x <- list(A = rnorm(10, mean=1), B= rnorm(10, mean=0))
lapply(x, function(y) y[y<0.5])

# Slide 86: When to use \rll{s/lapply}, \rll{for}, or Neither
X <- sample(100, size=50)
logX <- sapply(X, log)
X <- sample(100, size=50)
for(i in 1:50) {
  logX[i] <- log(X[i])
} 
logX <- log(X)

# Slide 88: Prerequisites
library(stringr)

# Slide 89: Aside: Two Common Errors
library(stringr)
install.packages("stringr")
str_detect("a", "apple")
library(stringr)

# Slide 90: String Creation
string1 <- "This is a string"
string2 <- "A 'string' within a string"
string3 <- c("one", "two", "three")

# Computes the length of each string:
str_length(string3)  

# Slide 91: Alternative to \texttt{paste()}
str_c("x", "y", "z")
str_c("x", "y", "z", sep=',')
str_c("x", c("a", "y"), "z", sep=',')

# Slide 92: Hawker IDs
hawk_ids <- str_c("hawker", "ctre", 1:116, sep="_")
head(hawk_ids)

# Slide 93: Subsetting Strings
x <- c("apple", "banana", "pear")
str_sub(x, 1, 3)
str_sub(x, 1, 20)   # Useful when length is unknown

# Slide 94: Regular Expressions

# Slide 95: Basic Matches
# If I supply the expression as 'an',
# where will it match?

x <- c("apple", "banana", "pear")
str_view(x, "an")

# Slide 96: Basic Matches
str_view(x, "^a")
str_view(x, "a$")
str_view(x, "[ae]$")
str_view(x, ".a.")

# Slide 97: Detecting Matches
str_detect(x, "an")
str_detect(x, ".a.")

# Slide 98: Hawker Centres in Ang Mo Kio
tf_vec <- str_detect(street_names, "Ang Mo Kio")
amk_id <- which(tf_vec)
amk_id
str_which(street_names, "Ang Mo Kio")

# Slide 99: More Complex Regular Expressions
tf_vec <- str_detect(street_names, "Jurong|Boon Lay")
street_names[which(tf_vec)]
tf_vec <- str_detect(street_names, "^(\\w)+ Road$")
street_names[which(tf_vec)]

# Slide 100: Character Classes
y <- paste("Ang Mo Kio", c(1:3,11))
str_detect(y, "Ave [13]$")
str_detect(y, "Ave [13]{2}$")    # match exactly twice
str_detect(y, "Ave [13]{1,2}$")  # match exactly once or twice
str_detect(y, "Ave [13]+$")      # match one or more times.
str_detect(y, "Ave [13]?$")      # match zero or one time.

# Slide 101: Character Classes
sent1 <- "She said, \"I'd like 10 eggs, please.\""

str_view_all(sent1, "[:punct:]")
str_view_all(sent1, "[[:digit:][:punct:]]")
str_view_all(sent1, "[:space:]")

# Slide 102: Groups
sent_type <- "I went to the the shop."
str_view_all(sent_type, "\\b(\\w+)\\b \\1")

str_replace(sent_type, "\\b(\\w+)\\b \\1", "\\1")
y <- paste("Ang Mo Kio", c("Ave", "St."), c(2, 64))
str_match(y, "(Ave|St.) ([0-9]+)$")

# Slide 103: Look-ahead and Look-behind Operators
str_extract(sent1, "[0-9]+(?= eggs)")
str_extract(sent1, "(?<=She said,).+")

# Slide 104: Overview of String Manipulations

# Slide 105: More Help on Regular Expressions in \rll{R}
vignette('stringr')               # introduction to the package
vignette('regular-expressions')   # covers regexes
?about_search_regex
?base::regex

# Slide 107: Introduction

# Slide 108: Creating Factors
x1 <- c("Dec", "Apr", "Jan", "Mar", "Apr")
x2 <- factor(x1)
x2

# Slide 109: Levels of a Factor
levels(x2)
x3 <- factor(x1, levels=c("Feb", "Jan", "Mar", "Apr", 
                          "May", "Jun", "Jul", "Aug", 
                          "Sep", "Oct", "Nov", "Dec"))
x3

# Slide 110: Re-Ordering Levels
x3 <- factor(x1, levels=c("Jan", "Feb", "Mar", "Apr", 
                          "May", "Jun", "Jul", "Aug", 
                          "Sep", "Oct", "Nov", "Dec"))

# Slide 112: Date Class

# Slide 113: Creating Date Objects
d1 <- as.Date("2014/02/22", "%Y/%m/%d")
class(d1)
d1

# Slide 114: Convenience Functions
weekdays(d1, abbreviate=FALSE)
months(d1, abbreviate=FALSE)

# Slide 115: Sequence of Dates
today <- Sys.Date()
s1 <- seq(today - 100, today, by="1 week")
s1[1:3]

# Slide 116: Dividing A Sequence of Dates into Groups
cut(s1, breaks="month", labels=FALSE)

# Slide 118: Creating a Scatterplot

# Slide 119: Cars Dataset
plot(cars)

# Slide 120: Cars Dataset

# Slide 121: Cars Dataset
plot(cars, xlab="Speed (mph)", 
     ylab="Braking Distance (ft)",
     main="Relationship Between Speed and Braking")

# Slide 122: Cars Dataset

# Slide 123: Altering Symbols
plot(cars, pch=2)

# Slide 124: Altering Symbols

# Slide 125: Altering Symbols

# Slide 126: Altering Symbols
plot(cars, col="blue")
colours()

# Slide 127: Altering Symbols
new_red <- rgb(1, 0, 0, alpha=0.4)
plot(cars, col=new_red, pch=19, cex=1.8, bty='n',
     xlab="Speed (mph)", ylab="Braking Distance (ft)",
     main="Relationship Between Speed and Braking")

# Slide 128: Altering Symbols

# Slide 129: Scatterplot Recap

# Slide 130: R Base Graphics Parameters

# Slide 132: Barcharts

# Slide 133: Barcharts
barplot(op_budget$amount,  border=NA,
        names.arg = str_to_title(op_budget$exp_cat))

# Slide 134: Summary

# Slide 136: Introduction

# Slide 137: R Markdown Help

# Slide 138: R Markdown Pre-requisites

# Slide 139: R Markdown Basics
---
title: "Diamond sizes"
date: 2016-08-25
output: html_document
---

# Slide 140: R Markdown Basics
```{r chunk_name}
Write R code here
```

# Slide 141: Chunk Names

# Slide 142: Chunk Options

# Slide 143: Chunk Caching

# Slide 144: Learn More

