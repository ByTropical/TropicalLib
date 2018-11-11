package de.bytropical.tropicallib.utils;

import lombok.Getter;

public class TropiSyntaxBuilder {

    @Getter StringBuilder syntax;
    @Getter String prefix;

    public TropiSyntaxBuilder(String pref) {
        syntax = new StringBuilder();
        this.prefix = pref;
    }

    public TropiSyntaxBuilder addLine(String line) {
        syntax.append(prefix).append(line).append("\n");
        return this;
    }

    public TropiSyntaxBuilder lastLine(String line) {
        syntax.append(prefix).append(line);
        return this;
    }

    public String getSyntax() {
        return syntax.toString();
    }

}
