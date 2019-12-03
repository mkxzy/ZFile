package com.iblotus.zfile.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;


@Entity(indexes = {
        @Index(value = "dbId,name", unique = true)
})
public class Field {

    @Id(autoincrement = true)
    private Long id;

    private Long dbId;

    private Integer idx;

    private String name;

    private String type;

    @Generated(hash = 1116873328)
    public Field(Long id, Long dbId, Integer idx, String name, String type) {
        this.id = id;
        this.dbId = dbId;
        this.idx = idx;
        this.name = name;
        this.type = type;
    }

    @Generated(hash = 522955764)
    public Field() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDbId() {
        return this.dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public Integer getIdx() {
        return this.idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
