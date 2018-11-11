package de.bytropical.tropicallib.database.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class TropiMongoManager {

    private MongoClient client;
    private MongoDatabase database;
    private Map<String, MongoCollection<Document>> collections;

    public TropiMongoManager(String cnstr) {
        collections = new HashMap<>();
        ConnectionString con = new ConnectionString(cnstr);

        client = MongoClients.create(con);
        System.out.println("[Ok] Connected to client..");
    }

    public TropiMongoManager setDatabase(String db) {
        database = client.getDatabase(db);
        System.out.println("[Ok] Connected to database " + db + "...");
        return this;
    }

    public TropiMongoManager addCollection(String cll) {
        collections.put(cll, database.getCollection(cll));
        System.out.println("[Ok] Addet Collection " + cll + "....");
        return this;
    }

    public MongoCollection<Document> getDocument(String name) {
        return collections.get(name);
    }

}
