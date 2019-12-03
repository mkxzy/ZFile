package com.iblotus.zfile.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.iblotus.zfile.model.User;
import com.iblotus.zfile.model.Db;
import com.iblotus.zfile.model.Field;
import com.iblotus.zfile.model.Record;

import com.iblotus.zfile.db.UserDao;
import com.iblotus.zfile.db.DbDao;
import com.iblotus.zfile.db.FieldDao;
import com.iblotus.zfile.db.RecordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig dbDaoConfig;
    private final DaoConfig fieldDaoConfig;
    private final DaoConfig recordDaoConfig;

    private final UserDao userDao;
    private final DbDao dbDao;
    private final FieldDao fieldDao;
    private final RecordDao recordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dbDaoConfig = daoConfigMap.get(DbDao.class).clone();
        dbDaoConfig.initIdentityScope(type);

        fieldDaoConfig = daoConfigMap.get(FieldDao.class).clone();
        fieldDaoConfig.initIdentityScope(type);

        recordDaoConfig = daoConfigMap.get(RecordDao.class).clone();
        recordDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        dbDao = new DbDao(dbDaoConfig, this);
        fieldDao = new FieldDao(fieldDaoConfig, this);
        recordDao = new RecordDao(recordDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Db.class, dbDao);
        registerDao(Field.class, fieldDao);
        registerDao(Record.class, recordDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        dbDaoConfig.clearIdentityScope();
        fieldDaoConfig.clearIdentityScope();
        recordDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DbDao getDbDao() {
        return dbDao;
    }

    public FieldDao getFieldDao() {
        return fieldDao;
    }

    public RecordDao getRecordDao() {
        return recordDao;
    }

}
