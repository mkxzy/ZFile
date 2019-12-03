package com.iblotus.zfile.service;

import com.iblotus.zfile.db.DaoSession;
import com.iblotus.zfile.db.DbDao;
import com.iblotus.zfile.model.Db;
import com.iblotus.zfile.model.Record;

import java.util.List;

public class RecordManager {

    private DaoSession daoSession;

    public RecordManager(DaoSession daoSession){
        this.daoSession = daoSession;
    }

    public void addRecord(String db, List<String> values){
        Db dbEntity = daoSession.getDbDao().queryBuilder()
                .where(DbDao.Properties.Name.eq(db))
                .uniqueOrThrow();
        Record record = new Record();
        record.setDbId(dbEntity.getId());
        record.setValues(values);
        daoSession.getRecordDao().save(record);
    }
}
