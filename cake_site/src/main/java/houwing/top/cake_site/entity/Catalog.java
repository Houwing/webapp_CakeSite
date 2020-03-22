package houwing.top.cake_site.entity;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private  int id;
    private String name;
    private  int parent;
    private  String description;
    private List<Catalog> children =new ArrayList<Catalog>();

    public List<Catalog> getChildren() {
        return children;
    }

    public void setChildren(List<Catalog> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
