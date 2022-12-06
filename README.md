# PBDAA
Processing Big Data's project Github

Input data can be found at /home/acx202/Parking_Violations_Issued_-_Fiscal_Year_2023.csv

The input data is the raw data that was downloaded from the website stated in data ingestion. After is data cleaning
For Data Cleaning:
Step 1: yarn classpath and copy the class path
Step 2: javac -classpath 'yarn class path from above' -d . CleanMapper.java
Step 3: javac -classpath 'yarn class path from above' -d . CleanReducer.java
Step 4: javac -classpath 'yarn class path from above':. -d . Clean.java
Step 5: jar -cvf Clean.jar *.class
Step 6: Hadoop jar Clean.jar Clean /home/acx202/Parking_Violations_Issued_-_Fiscal_Year_2023.csv output8
Step 7: To find results you can enter "hdfs dfs -cat output8/part-r-00000"
Step 8: Data Cleaning is done as all of the columns that we want and do not want have been filtered and cleaned

For Analysis
Step 1: yarn classpath and copy the class path
Step 2: javac -classpath 'yarn class path from above' -d . makeMapper.java
Step 3: javac -classpath 'yarn class path from above' -d . makeReducer.java
Step 4: javac -classpath 'yarn class path from above':. -d . make.java
Step 5: jar -cvf make.jar *.class
Step 6: Hadoop jar make.jar make output8/part-r-00000 output15
Step 7: To find results you can enter "hdfs dfs -cat output15/part-r-00000"
This would give you the aggregation of the makes of the cars

For timing of ticket and seeing if it came before or after the cameras kicked in 24/7
Step 1: yarn classpath and copy the class path
Step 2: javac -classpath 'yarn class path from above' -d . timeMapper.java
Step 3: javac -classpath 'yarn class path from above' -d . timeReducer.java
Step 4: javac -classpath 'yarn class path from above':. -d . time.java
Step 5: jar -cvf time.jar *.class
Step 6: Hadoop jar time.jar time output8/part-r-00000 output40
Step 7: To find results you can enter "hdfs dfs -cat output40/part-r-00000"
This would give you the aggregation of when the ticket was given, was it before or after the old hours and was it in July or August
