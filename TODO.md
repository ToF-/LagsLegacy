## The LAGS program

```
Id,    Start, Duration, Price
AF515, 0,     5,        100
CO5,   3,     7,        140
AF515, 5,     9,        70
BA01,  6,     9,        80
```

```
🟠 AF515                  = 100
🔴 AF515 + CO5
🟠 AF515 + AF515          = 170
🔴 AF515 + AF515 + BA01
🟢 AF515 + BA01           = 180
🟠 CO5                    = 140
🔴 CO5 + AF515
🔴 CO5 + BA01
🟠 AF515                  = 70
🟠 BA01                   = 80
```

## BUG

With `orders.csv` as the orders file, the revenue should be 15801153.
With the current version, the revenue output is 158010148.

Fix the program so that the correct value is output.

## PROGRAM IS SLOW

With `orders.csv` as the orders file, computing the revenue takes more than 1s.

Fix the program so that the value is output faster.

## ADD ORDER ID IN OUTPUT

Currently the program only outputs the total revenue.
Change the program so that the selected orders are output as well as the revenue. 

With `sample.csv` as the orders file, the output should be
```
Id         Revenue
AF515      100
C05         80
TOTAL      180
```



