package de.bytropical.tropicallib.database.mongodb;


import org.bson.Document;

import java.lang.reflect.Field;

/**
 * Die Klasse wurde von HyWse geschrieben!
 */

public abstract class TropiAutoDocument<T> {

    public Document getDocument() {
        Document document = new Document();

        for (Field field : getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(TropiDocField.class)) continue;
            field.setAccessible(true);

            TropiDocField opt = field.getAnnotation(TropiDocField.class);
            String key = opt.key().length() == 0 ? field.getName() : opt.key();

            try {
                document.append(key, field.get(this));
            } catch (IllegalAccessException e) {
                System.out.println("Can't create doc @ " + getClass().getSimpleName() + ": " + e.getMessage());
            }
        }

        return document;
    }
    public static <T> T fromDocument(Document document, Class<T> clazz) {
        T res;

        try {
            res = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        int fields = 0;
        for (Field field : res.getClass().getDeclaredFields()) {
            fields++;
            if (!field.isAnnotationPresent(TropiDocField.class)) continue;
            field.setAccessible(true);

            TropiDocField opt = field.getAnnotation(TropiDocField.class);
            String key = opt.key().length() == 0 ? field.getName() : opt.key();

            if (!document.containsKey(key)) {
                System.out.println("Could not find " + key + " in document! Using default");
            } else {
                try {
//                    System.out.println("Settings " + field.getName() + " => " + document.get(key).toString());
                    field.set(res, document.get(key));
                } catch (IllegalAccessException e) {
                    System.out.println("Can't fill " + key + ": " + e.getMessage());
                }
            }
        }
//        System.out.println("Found " + fields + " fields!");
        return res;
    }

}
