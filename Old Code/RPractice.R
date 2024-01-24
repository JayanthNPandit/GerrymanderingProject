x <- 45
y <- 34
z <- x*y

d <- c(1,4,5,6,8)
d

e <- 56:89
e

data(women)

head(women)

size(women)
length(women)
nrow(women)
dim(women)
str(women)
mean(women$height)
mean(women$weight)
attach(women)
median(weight)
sd(weight)
max(weight)
min(weight)
fivenum(weight)
fivenum()
summary(weight)
detach(women)
mean(women$height)
median(height)
install.packages("psych")
require(psych)
library(psych)
?psych
describe(women)
date(iris)
date(weight)
data(iris)
str(iris)
head(iris)
tail(iris)
describeBy(iris, iris$Species)
