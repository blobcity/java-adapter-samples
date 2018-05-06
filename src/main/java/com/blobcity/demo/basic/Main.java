package com.blobcity.demo.basic;

import com.blobcity.db.Db;
import com.blobcity.db.config.Credentials;
import com.blobcity.db.search.Query;
import com.blobcity.db.search.SearchParam;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * Should be called only once per application. Sample connects to database on localhost. Use IP and port of
         * remote server to connect to cloud and remote database installations. In this case the default username
         * and password are set. Set these appropriately to the user who wish to use for performing the database
         * operations. The last parameter is the datastore. All operations on the database will be performed on the
         * specified datastore.
         */
        Credentials.init("localhost:10111", "root", "root", "samples");

        /**
         * Inserting a record using the POJO
         */
        Person person = new Person("Person 1", 45);
        person.insert();

        /**
         * Inserting a JsonObject
         */
        JsonObject insertJson = new JsonObject();
        insertJson.addProperty("name", "Person 1");
        insertJson.addProperty("age", 45);
        Db.insertJson("Persons", insertJson);

        /**
         * Insert a list of JsonObject's
         */
        List<JsonObject> insertList = new ArrayList<>();
        insertJson = new JsonObject();
        insertJson.addProperty("name", "Person 1");
        insertJson.addProperty("age", 45);
        insertList.add(insertJson);

        insertJson = new JsonObject();
        insertJson.addProperty("name", "Person 2");
        insertJson.addProperty("age", 30);
        insertList.add(insertJson);
        Db.insertJson("Persons", insertList);

        /**
         * select * query
         */
        List<Person> personList = Db.search(Query.select().from(Person.class));

        /**
         * select with a where clause. Returns all persons where age > 25
         */
        personList = Db.search(Query.select().from(Person.class).where(SearchParam.create("age").gt(25)));
    }
}
