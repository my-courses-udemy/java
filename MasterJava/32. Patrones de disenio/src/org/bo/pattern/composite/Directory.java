package org.bo.pattern.composite;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class Directory extends Component {

    private List<Component> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public Directory addComponent(Component component) {
        children.add(component);
        return this;
    }

    public void deleteComponent(Component component) {
        children.remove(component);
    }

    @Override
    public String show(int level) {
        StringBuilder stringBuilder = new StringBuilder("\t".repeat(level));
        stringBuilder.append(name)
                .append("/")
                .append("\n");
        children.forEach(component -> {
            stringBuilder.append(component.show(level + 1));
            if (component instanceof File) {
                stringBuilder.append("\n");
            }
        });
        return stringBuilder.toString();
    }

    @Override
    public boolean search(String name) {
        if (this.name.equalsIgnoreCase(name)){
            return true;
        }
        /*for (Component child : children) {
            if (child.search(name)){
                return true;
            }
        }*/
        return children.stream().anyMatch(child -> child.search(name));
    }
}
