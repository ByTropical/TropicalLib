package de.bytropical.tropicallib.bukkit;

import net.md_5.bungee.api.ChatColor;

public class TropiProgressbar {

    public static String getProgressBar(int current, int max, int totalBars, String symbol, String completedColor, String notCompletedColor){

        float percent = (float) current / max;
        int progressBars = (int) ((totalBars * percent));
        int leftOver = (totalBars - progressBars);

        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.translateAlternateColorCodes('&', completedColor));
        for (int i = 0; i < progressBars; i++) {
            sb.append(symbol);
        }
        sb.append(ChatColor.translateAlternateColorCodes('&', notCompletedColor));
        for (int i = 0; i < leftOver; i++) {
            sb.append(symbol);
        }

        return sb.toString();
    }


}
