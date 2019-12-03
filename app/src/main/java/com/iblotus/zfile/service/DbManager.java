package com.iblotus.zfile.service;

import com.iblotus.zfile.db.DaoSession;
import com.iblotus.zfile.model.Db;
import com.iblotus.zfile.model.Field;

import java.util.ArrayList;
import java.util.List;


/**
 * 数据库管理类
 */
public class DbManager {

    private DaoSession daoSession;

    public DbManager(DaoSession daoSession){
        this.daoSession = daoSession;
    }

    public void createDb(final DbInfo dbInfo){
        daoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                Db db = new Db();
                db.setName(dbInfo.getName());
                daoSession.getDbDao().insert(db);

                List<Field> fieldList = new ArrayList<>();
                for(int i = 0; i < dbInfo.getFields().size(); i++){
                    int idx = i + 1;
                    FieldInfo fi = dbInfo.getFields().get(i);
                    Field field = new Field();
                    field.setDbId(db.getId());
                    field.setIdx(idx);
                    field.setName(fi.getName());
                    field.setType(fi.getType());
                    fieldList.add(field);
                }

                daoSession.getFieldDao().insertInTx(fieldList);
            }
        });
    }

    public List<DbInfo> getDbs(){
        List<Db> dbList = daoSession.getDbDao().loadAll();
        List<DbInfo> dbInfos = new ArrayList<>();
        for (Db db: dbList){
            DbInfo dbInfo = new DbInfo();
            dbInfo.setId(db.getId());
            dbInfo.setName(db.getName());
            dbInfos.add(dbInfo);
        }
        return dbInfos;
    }

    public List<FieldTypeInfo> getFieldTypes(){
        List<FieldTypeInfo> list = new ArrayList<>();
        list.add(new FieldTypeInfo("string", "字符串"));
        list.add(new FieldTypeInfo("number", "数字"));
        return list;
    }
}
