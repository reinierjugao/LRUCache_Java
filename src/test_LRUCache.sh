#!/bin/bash

if [ ! -f ../lib/junit-4.12.jar ]
then
  echo "ERROR: Could not find lib/junit-4.12.jar."
  echo "Please check file or download JUnit jar file."
  exit
fi

if [ ! -f ../lib/hamcrest-core-1.3.jar ]
then
  echo "ERROR: Could not find lib/hamcrest-core-1.3.jar."
  exit
fi

javac -cp .:../lib/junit-4.12.jar -d . tests/LRUCacheTest.java
java -cp .:../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore LRUCacheTest
