package com.anurag.executor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionFileProcessor implements Callable<Boolean> {


    private File file;

    private Map<Exception, AtomicInteger> requestExceptionCount;

    public ExceptionFileProcessor(File file,
                                  Map<Exception, AtomicInteger> requestExceptionCount) {
        this.file = file;
        this.requestExceptionCount = requestExceptionCount;
    }


    public Boolean call() throws FileNotFoundException {

        // process current file

        // process each line in the file

        // create the excpetion object

        // check if the object is already there in the global map

        // if there increment the count, if not then put with count 1



        Scanner sc = new Scanner(file);
        //skip header
        sc.nextLine();
        while (sc.hasNext()) {
            String[] currError = sc.nextLine().split(" ");

            Exception exception = new Exception()
                    .setRequestId(currError[0])
                    .setTimeStamp(Long.parseLong(currError[1]))
                    .setType(currError[2]);

            requestExceptionCount.putIfAbsent(exception, new AtomicInteger(0));
            requestExceptionCount.get(exception).getAndIncrement();
        }

        return true;
    }




}
