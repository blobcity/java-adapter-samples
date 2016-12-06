package com.blobcity.demo.interpreter;


import com.blobcity.db.config.Credentials;
import com.blobcity.db.Db;
import com.blobcity.db.enums.CollectionType;
import com.blobcity.db.search.Query;
import com.blobcity.db.search.SearchParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanketsarang on 04/12/16.
 */
public class LogInterpreterDemo {

    public static void main(String[] args) {
        Credentials.init("localhost:10111","root","root","demo");

        System.out.println("Reading log entries");
        List<String> logEntriesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/demo-data/apache-log-sample.log")))) {
            String line;
            while((line = reader.readLine()) != null) {
                logEntriesList.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("======================");
        System.out.println("Inserting entries to DB");

        Db.insertText("Logs", logEntriesList, "LogInterpreter");

        System.out.println("Inserted all log records with interpretation");

        System.out.println("======================");
        System.out.println("Searching the Logs table");

        long count = (Long) Db.execute(Query.count().from(Logs.class).where(SearchParam.create("ip").eq("127.0.0.1")));
        System.out.println("Number of requests from 127.0.0.1 are: " + count);

        List<Logs> list = Db.search(Query.select().from(Logs.class).where(SearchParam.create("resp_code").eq("200")));
        System.out.println("Found  " + list.size() + " logs entries with response code 200. Printing below:");
        list.forEach(log -> System.out.println(log.getIp() + " " + log.getTime() + " " + log.getMethod() + " " + log.getSize()));
    }
}
