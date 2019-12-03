package com.iblotus.zfile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iblotus.zfile.db.UserDao;
import com.iblotus.zfile.model.User;
import com.iblotus.zfile.service.DbInfo;
import com.iblotus.zfile.service.DbManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void initView() {
        tableLayout = findViewById(R.id.tableLayoutProduct);

        Button createDB = findViewById(R.id.btn_create_db);
        createDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewDbActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "新建成功", Toast.LENGTH_LONG).show();
//                MyApp myApp = (MyApp) getApplication();
//                UserDao userDao = myApp.getDaoSession().getUserDao();
//                User user = new User();
//                user.setName("mike");
//                userDao.save(user);
//                Toast.makeText(getApplicationContext(), user.getName() + "新建成功", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadData() {

        createColumns();

//        List<Product> products = new ArrayList<Product>();
//        products.add(new Product("p01", "Name 1", 4, "Description for Product 1", R.drawable.qiqiu));
//        products.add(new Product("p02", "Name 2", 8, "Description for Product 2", R.drawable.qiqiu));
//        products.add(new Product("p03", "Name 3", 9, "Description for Product 3", R.drawable.qiqiu));
//        products.add(new Product("p04", "Name 4", 11, "Description for Product 4", R.drawable.qiqiu));
//        products.add(new Product("p05", "Name 5", 5, "Description for Product 5", R.drawable.qiqiu));
//        products.add(new Product("p06", "Name 6", 21, "Description for Product 6", R.drawable.qiqiu));
//        products.add(new Product("p07", "Name 7", 15, "Description for Product 7", R.drawable.qiqiu));
//        products.add(new Product("p08", "Name 8", 8, "Description for Product 8", R.drawable.qiqiu));
//        products.add(new Product("p09", "Name 9", 32, "Description for Product 9", R.drawable.qiqiu));
//        fillData(products);

        fillData();
    }

    private void createColumns() {
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        TextView textViewId = new TextView(this);
        textViewId.setText("数据库名");
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding(5, 5, 5, 0);
//        textViewId.setLayoutParams();
        tableRow.addView(textViewId);

        // Name Column
        TextView textViewName = new TextView(this);
        textViewName.setText("记录数");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

//        // Price Column
//        TextView textViewPrice = new TextView(this);
//        textViewPrice.setText("Price");
//        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPrice.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPrice);
//
//        // Photo Column
//        TextView textViewPhoto = new TextView(this);
//        textViewPhoto.setText("Photo");
//        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPhoto.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

//        // Add Divider
//        tableRow = new TableRow(this);
//        tableRow.setLayoutParams(new TableRow.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//
//        // Id Column
//        textViewId = new TextView(this);
//        textViewId.setText("-----------");
//        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewId.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewId);
//
//        // Name Column
//        textViewName = new TextView(this);
//        textViewName.setText("-----------");
//        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewName.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewName);
//
//        // Price Column
//        textViewPrice = new TextView(this);
//        textViewPrice.setText("-----------");
//        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPrice.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPrice);
//
//        // Photo Column
//        textViewPhoto = new TextView(this);
//        textViewPhoto.setText("-------------------------");
//        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPhoto.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPhoto);
//
//        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));

    }

//    private void fillData(List<Product> products) {
//        for (Product product : products) {
//            TableRow tableRow = new TableRow(this);
//            tableRow.setLayoutParams(new TableRow.LayoutParams(
//                    TableRow.LayoutParams.MATCH_PARENT,
//                    TableRow.LayoutParams.WRAP_CONTENT));
//
//            tableRow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    TableRow currentRow = (TableRow) view;
//                    TextView textViewId = (TextView) currentRow.getChildAt(0);
//                    String id = textViewId.getText().toString();
//                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
//                }
//            });
//
//            // Id Column
//            TextView textViewId = new TextView(this);
//            textViewId.setText(product.getId());
//            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            textViewId.setPadding(5, 5, 5, 0);
//            tableRow.addView(textViewId);
//
//            // Name Column
//            TextView textViewName = new TextView(this);
//            textViewName.setText(product.getName());
//            textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            textViewName.setPadding(5, 5, 5, 0);
//            tableRow.addView(textViewName);
//
//            // Price Column
//            TextView textViewPrice = new TextView(this);
//            textViewPrice.setText(getText(R.string.usd) + String.valueOf(product.getPrice()));
//            textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            textViewPrice.setPadding(5, 5, 5, 0);
//            tableRow.addView(textViewPrice);
//
//            // Photo Column
//            ImageView imageViewPhoto = new ImageView(this);
//            imageViewPhoto.setImageResource(product.getPhoto());
//            tableRow.addView(imageViewPhoto);
//
//            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
//                    TableRow.LayoutParams.MATCH_PARENT,
//                    TableRow.LayoutParams.WRAP_CONTENT));
//        }
//    }

    private void fillData(){
        MyApp myApp = (MyApp) getApplication();
        DbManager dbManager = myApp.getDbManager();
        List<DbInfo> dbInfos = dbManager.getDbs();
        for (DbInfo u: dbInfos){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            TextView textViewId = new TextView(this);
            textViewId.setText(u.getName().toString());
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewId.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewId);

            TextView textViewName = new TextView(this);
            textViewName.setText("0");
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewId.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewName);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}
