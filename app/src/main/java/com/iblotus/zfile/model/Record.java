package com.iblotus.zfile.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Record {

    @Id(autoincrement = true)
    private Long id;

    private Long dbId;

    @Property
    @Convert(converter = ValuesConverter.class, columnType = String.class)
    private List<String> values;

    @Generated(hash = 995749888)
    public Record(Long id, Long dbId, List<String> values) {
        this.id = id;
        this.dbId = dbId;
        this.values = values;
    }

    @Generated(hash = 477726293)
    public Record() {
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

    public List<String> getValues() {
        return this.values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static class ValuesConverter implements PropertyConverter<List<String>, String> {
        @Override
        public List<String> convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            Type type = new TypeToken<List<String>>() {}.getType();
            return new Gson().fromJson(databaseValue, type);
        }

        @Override
        public String convertToDatabaseValue(List<String> entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            Type type = new TypeToken<List<String>>() {}.getType();
            String r = new Gson().toJson(entityProperty, type);
            return r;
        }
    }
}
