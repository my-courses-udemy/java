package org.bo.pattern.decorator.decorators;

import org.bo.pattern.decorator.Formatter;

public class ReverseDecorator extends TextDecorator{
    public ReverseDecorator(Formatter text) {
        super(text);
    }

    @Override
    public String giveFormat() {
        StringBuilder stringBuilder = new StringBuilder(text.giveFormat());
        return stringBuilder.reverse().toString();
    }
}
