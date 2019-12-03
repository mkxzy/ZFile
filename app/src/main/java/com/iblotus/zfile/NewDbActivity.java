package com.iblotus.zfile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.iblotus.zfile.service.DbManager;
import com.iblotus.zfile.service.FieldTypeInfo;

import java.util.List;

public class NewDbActivity extends AppCompatActivity {

    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_db);
        MyApp myApp = (MyApp) getApplication();
        dbManager = myApp.getDbManager();
        this.initView();
    }

    private void initView(){

        TableLayout tableLayout = findViewById(R.id.tb_fields);

        for(int i = 0; i < 10; i++){
            int seq = i + 1;
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            TextView txtSeq = new TextView(this);
            txtSeq.setText(String.format("%d.", seq));
            txtSeq.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            txtSeq.setPadding(5, 5, 5, 0);
//        textViewId.setLayoutParams();
            tableRow.addView(txtSeq);

            EditText txtFieldName = new EditText(this);
            txtFieldName.setTypeface(Typeface.DEFAULT);
            txtFieldName.setLayoutParams(new TableRow.LayoutParams(
                    600,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tableRow.addView(txtFieldName);

            Spinner txtFieldType = new Spinner(this);
//            String[] items = new String[]{"字符串", "数字", "布尔值"};
            List<FieldTypeInfo> types = dbManager.getFieldTypes();
            ArrayAdapter<FieldTypeInfo> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, types);
            txtFieldType.setAdapter(adapter);
            tableRow.addView(txtFieldType);

            tableLayout.addView(tableRow);
        }
    }
}
