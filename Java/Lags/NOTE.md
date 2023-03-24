download
`commons-lang3-3.12.0.jar` `opencsv-5.7.1.jar` into lib
compile
```
javac -cp lib/opencsv-5.7.1.jar -d lib src/*
```
run
```
LAGS_ORDER_FILE=../../data/sample.csv java -cp lib:lib/opencsv-5.7.1.jar:lib/commons-lang3-3.12.0.jar Rent
```

