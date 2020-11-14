package com.anurag.executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {

   static ExecutorService executorService;

   static Map<Exception, AtomicInteger> exceptionCountMap= new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException, IOException {

        executorService=Executors.newFixedThreadPool(5);


        // getAll the files inside logs folder

        File file=new File("logs");

        file.listFiles();

        List<ExceptionFileProcessor> exceptionFileProcessorList=new ArrayList();

        for(File curr:file.listFiles()){

            exceptionFileProcessorList.add(new ExceptionFileProcessor(curr,exceptionCountMap));
        }


        executorService.invokeAll(exceptionFileProcessorList);

        String formatExceptions = formatExceptions(exceptionCountMap);

        writeContentToFile("output.txt", formatExceptions);

    }

    private static String formatExceptions(Map<Exception, AtomicInteger> exceptionCountMap) {



        String formattedString = "";
        for (Map.Entry<Exception, AtomicInteger> currEntry : exceptionCountMap.entrySet()) {
            Exception currException = currEntry.getKey();

            formattedString +=
                    currException.getLowerTimeBound() + "-" + currException.getUpperTimeBound() + "   "
                            + currException.getType() + "  " + currEntry.getValue();
            formattedString += "\n";

        }
        System.out.println(formattedString);
        return formattedString;

    }

    private static void writeContentToFile(String fileName, String content) throws IOException {

        BufferedWriter output = null;
        try {
            File file = new File(fileName);
            output = new BufferedWriter(new FileWriter(file));
            output.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }

    }



}
