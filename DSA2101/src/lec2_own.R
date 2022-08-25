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
