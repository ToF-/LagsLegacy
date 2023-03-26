cp dist/Lags.jar ../../bin/.
./revenue.sh >testData/results.txt
diff testData/golden_master.txt testData/results.txt
