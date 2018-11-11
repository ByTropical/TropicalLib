package de.bytropical.tropicallib.config;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class TropiConfig {

    @Getter private YamlConfiguration conf;
    private File config;


    public TropiConfig(String path, String name) {
        config = new File(path, name);
        conf = YamlConfiguration.loadConfiguration(config);
        conf.options().copyDefaults(true);
    }

    public void set(String key, Object value) {
        conf.addDefault(key, value);
    }

    public void create() throws IOException {
        conf.save(config);
    }

    public String getColoredString(String key) {
        return ChatColor.translateAlternateColorCodes('&', conf.getString(key));
    }

    public String getString(String key) {
        return conf.getString(key);
    }

    public int getInt(String key) {
        return conf.getInt(key);
    }

    public boolean getBoolean(String key) {
        return conf.getBoolean(key);
    }

    public long getLong(String key) {
        return conf.getLong(key);
    }

}

