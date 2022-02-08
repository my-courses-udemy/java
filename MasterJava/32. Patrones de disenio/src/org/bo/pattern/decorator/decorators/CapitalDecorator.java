package org.bo.pattern.decorator.decorators;

import org.bo.pattern.decorator.Formatter;

public class CapitalDecorator  extends TextDecorator{
    public CapitalDecorator(Formatter text) {
        super(text);
    }

    @Override
    public String giveFormat() {
        return text.giveFormat().toUpperCase();
    }
}
