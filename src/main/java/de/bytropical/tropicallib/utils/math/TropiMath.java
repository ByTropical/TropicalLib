package de.bytropical.tropicallib.utils.math;

public class TropiMath {

    public static boolean isEnoughPercent(double amout ,double mind, double percent) {
        double requiredPlayers = (amout / (double) 100 * percent);
        return requiredPlayers < mind;
    }

}
