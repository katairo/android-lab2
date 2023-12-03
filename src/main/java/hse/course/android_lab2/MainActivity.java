package hse.course.android_lab2;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hse.course.android_lab2.adapter.Adapter;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.main_activity_layout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        super.onCreate(savedInstanceState);
    }

    public void save(View view) {
        EditText productEditText = findViewById(R.id.editText);
        String productName = productEditText.getText().toString();
        productEditText.setText("");
        adapter.addNewProduct(productName);
    }

    public void clear(View view) {
        adapter.clear();
    }
}
