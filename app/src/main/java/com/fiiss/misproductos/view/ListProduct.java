package com.fiiss.misproductos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fiiss.misproductos.R;

public class ListProduct extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spMaterial;
    private Spinner spSaid;
    private Spinner spType;
    private RadioGroup radioGroup;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMaterial = findViewById(R.id.spMaterial);
        spSaid = findViewById(R.id.spSaid);
        spType = findViewById(R.id.spType);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
