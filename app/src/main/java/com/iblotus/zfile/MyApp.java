package com.iblotus.zfile;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.iblotus.zfile.db.DaoMaster;
import com.iblotus.zfile.db.DaoSession;
import com.iblotus.zfile.service.DbManager;

public class MyApp extends Application {

    private DaoSession daoSession;

    private static final String DB = "zfile-test";

    @Override
    public void onCreate(){
        super.onCreate();
        initGreenDAO();
    }

    private void initGreenDAO() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB, null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        this.daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DbManager getDbManager(){
        return new DbManager(this.daoSession);
    }
}
