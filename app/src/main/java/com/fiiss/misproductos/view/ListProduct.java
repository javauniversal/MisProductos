package com.fiiss.misproductos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.fiiss.misproductos.R;
import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.interfaces.InterfaceActivity;
import com.fiiss.misproductos.presenter.PresenterActivity;

import java.util.List;

public class ListProduct extends AppCompatActivity implements InterfaceActivity.View, View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private Spinner spMaterial;
    private Spinner spSaid;
    private Spinner spType;

    private InterfaceActivity.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMaterial = findViewById(R.id.spMaterial);
        spSaid = findViewById(R.id.spSaid);
        spType = findViewById(R.id.spType);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        RadioButton rbUS = findViewById(R.id.rbUS);
        rbUS.setChecked(true);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        presenter = new PresenterActivity(this);
        presenter.setDataMaterial(this);
        presenter.setDataSaid(this);
        presenter.setDataType(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            presenter.validateFields();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void responseMaterialView(List<Material> materialList) {
        ArrayAdapter<Material> adapterMatrial = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, materialList);
        adapterMatrial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMaterial.setAdapter(adapterMatrial);
        spMaterial.setOnItemSelectedListener(this);
    }

    @Override
    public void responseSaidView(List<Said> saidList) {
        ArrayAdapter<Said> adapterSaid = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, saidList);
        adapterSaid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSaid.setAdapter(adapterSaid);
        spSaid.setOnItemSelectedListener(this);
    }

    @Override
    public void responseTypeView(List<Type> typeList) {
        ArrayAdapter<Type> adapterType = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, typeList);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(adapterType);
        spType.setOnItemSelectedListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbCOP) {
            Toast.makeText(this, "Ha pulsado el botón 1", Toast.LENGTH_LONG).show();
        } else if (checkedId == R.id.rbUS) {
            Toast.makeText(this, "Ha pulsado el botón 2", Toast.LENGTH_LONG).show();
        }
    }
}
