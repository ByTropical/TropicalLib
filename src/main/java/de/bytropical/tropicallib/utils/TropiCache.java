package de.bytropical.tropicallib.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Getter;

public class TropiCache<Key, Graph> {

    @Getter
    LoadingCache<Key, Graph> cache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .build(new CacheLoader<Key, Graph>() {
                @Override
                public Graph load(Key key) throws Exception {
                    return null;
                }
            });

}
