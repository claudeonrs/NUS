salaries <- read.csv("../custom-datasets/ds_salaries.csv")
colnames(salaries)

# clean data
# factors: "experience_level", "employment_type", "company_size" 
salaries$experience_level <- factor(salaries$experience_level)
salaries$employment_type <- factor(salaries$employment_type)
salaries$company_size <- factor(salaries$company_size)

# find unique factors
unique(salaries$employment_type)

hist(salaries$salary_in_usd/1000, 
     breaks=seq(min(salaries$salary_in_usd)/1000,
                max(salaries$salary_in_usd)/1000,
                length.out=40), 
     freq=FALSE, xlab="Salary in kUSD", 
     main="Data Science Salaries")


## EPL DATA
football <- read.csv("../data/EPL_1415_1516.csv", 
                     na.strings="-")

football_lines <- readLines("../data/EPL_1415_1516.csv")
football_lines <- str_split(football_lines, ",")


## READ JSON
library(jsonlite)
jsontxt <- readLines("../data/read_json_02.txt")
fromJSON(jsontxt)


studentBio <- list(studentName = "Harry Potter", studentAge = 19, studentContact="London")
class(studentBio) <- "StudentInfo"

# how to assign method
contact <- function(object) {
  UseMethod("contact")
}
contact.StudentInfo <- function(object) {
  cat("Your contact is", object$studentContact, "\n")
}

#### CONNECT TO MONGO DB SHIT
library(mongolite)
library(jsonlite)
# eXXXXX:pwd
credentials <- paste0(readLines("mongo_user_pwd.txt", warn=FALSE), collapse=":")
connection_string <- paste0("mongodb://",credentials, "@rshiny.nus.edu.sg:2717/test")
con2 <- mongo(verbose=TRUE, collection="restaurants", url=connection_string)
con2$count()
con2$index()
# rshiny.nus.edu.sg/dlp/dlp2c-wk1


### Download from link
imda_url <- "https://data.gov.sg/dataset/02c1f624-489f-40ad-8fdd-5e66e46b2722/download"
return_val <- download.file(imda_url, "../data/imda_data.zip")
con <- unz("../data/imda_data.zip", "wage-02-size2-annual.csv")
wages_data <- read.csv(con, header=TRUE)


## API stuff
library(httr)
set_config(verbose())
url <- "https://api.data.gov.sg/v1/transport/taxi-availability"
curr_time <- strftime(Sys.time(),"%Y-%m-%dT%H:%M:%S")
taxi_avail <- GET(url, query=list(date_time=curr_time))

taxi_data <- content(taxi_avail)


coords <- taxi_data$features[[1]]$geometry$coordinates
matrix <- sapply(coords, function(x) {c(x[[1]], x[[2]])})
plot(matrix[1,], matrix[2,], pch="+")


## WEB FUKIN SCRAPIN

library(rvest)
library(xml2)
rbloggers_page <- read_html("https://www.r-bloggers.com/2018/11")
nodes <- html_nodes(rbloggers_page, ".loop-title a")
nodes







