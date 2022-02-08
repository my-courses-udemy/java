package org.bo.pattern.decorator.decorators;

import org.bo.pattern.decorator.Formatter;

public class ReplaceSpaceDecorator extends TextDecorator{
    public ReplaceSpaceDecorator(Formatter text) {
        super(text);
    }

    @Override
    public String giveFormat() {
        return text.giveFormat().replace(" ", "_");
    }
}
