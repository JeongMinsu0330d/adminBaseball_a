package com.example.adminbaseball.common;

import java.util.List;

public class Section {
    private String section_type;
    private List<Value> values;

    public Section(String section_type, List<Value> values) {
        this.section_type = section_type;
        this.values = values;
    }

    public String getSection_type() {
        return section_type;
    }

    public void setSection_type(String section_type) {
        this.section_type = section_type;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}


