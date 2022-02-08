package org.bo.pattern.decorator;

public class Text implements Formatter{
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String giveFormat() {
        return getText();
    }
}
