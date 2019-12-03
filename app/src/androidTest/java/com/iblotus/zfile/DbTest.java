package com.iblotus.zfile;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.iblotus.zfile.db.DaoMaster;
import com.iblotus.zfile.db.DaoSession;
import com.iblotus.zfile.service.DbInfo;
import com.iblotus.zfile.service.DbManager;
import com.iblotus.zfile.service.FieldInfo;
import com.iblotus.zfile.service.RecordManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@RunWith(AndroidJUnit4.class)
public class DbTest {

    @Test
    public void testDbManager(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(appContext, "zfile-test", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        DbManager dbManager = new DbManager(daoSession);
        DbInfo dbInfo = new DbInfo();
        dbInfo.setName("abc");
        List<FieldInfo> fieldInfoList = new ArrayList<>();
        dbInfo.setFields(fieldInfoList);
        FieldInfo f1 = new FieldInfo();
        f1.setName("a");
        f1.setType("string");
        fieldInfoList.add(f1);

        FieldInfo f2 = new FieldInfo();
        f2.setName("b");
        f2.setType("string");
        fieldInfoList.add(f2);
        dbManager.createDb(dbInfo);

        RecordManager recordManager = new RecordManager(daoSession);
        List<String> r1 = new ArrayList<String>(){{
            add("x");
            add("y");
        }};
        recordManager.addRecord("abc", r1);
    }
}
