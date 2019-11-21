package com.sebookstore.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class JSUser implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String jsName;
    @Column
    private String jsPwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsName() {
        return jsName;
    }

    public void setJsName(String jsName) {
        this.jsName = jsName;
    }

    public String getJsPwd() {
        return jsPwd;
    }

    public void setJsPwd(String jsPwd) {
        this.jsPwd = jsPwd;
    }
}
