package cn.hncu.domain;

import java.io.Serializable;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public class Category implements Serializable {

    private Integer id;
    private String  name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
