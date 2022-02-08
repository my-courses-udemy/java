package org.bo.pattern.decorator.decorators;

import org.bo.pattern.decorator.Formatter;

public abstract class TextDecorator implements Formatter {

    protected Formatter text;

    public TextDecorator(Formatter text) {
        this.text = text;
    }
}
