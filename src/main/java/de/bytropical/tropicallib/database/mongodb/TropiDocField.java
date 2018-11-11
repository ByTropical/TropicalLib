package de.bytropical.tropicallib.database.mongodb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Die Klasse wurde von HyWse geschrieben!
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TropiDocField {

    String key() default "";

}