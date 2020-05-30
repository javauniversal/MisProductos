package com.fiiss.misproductos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.fiiss.misproductos.R;
import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.interfaces.InterfaceActivity;
import com.fiiss.misproductos.presenter.PresenterActivity;

import java.util.List;

public class ListProduct extends AppCompatActivity implements InterfaceActivity.View, View.OnClickListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private Spinner spMaterial;
    private Spinner spSaid;
    private Spinner spType;
    private EditText quantity;
    private RadioButton rbUS;
    private RadioButton rbCOP;
    private TextView textResult;

    private InterfaceActivity.Presenter presenter;

    private int slpMaterial = 0;
    private int slpSaid = 0;
    private int slpType = 0;

    private List<Material> materialList;
    private List<Said> saidList;
    private List<Type> typeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = findViewById(R.id.quantity);
        spMaterial = findViewById(R.id.spMaterial);
        spSaid = findViewById(R.id.spSaid);
        spType = findViewById(R.id.spType);
        textResult = findViewById(R.id.textResult);

        spMaterial.setOnItemSelectedListener(this);
        spSaid.setOnItemSelectedListener(this);
        spType.setOnItemSelectedListener(this);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        rbUS = findViewById(R.id.rbUS);
        rbUS.setChecked(true);

        rbCOP = findViewById(R.id.rbCOP);


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
            presenter.validateFields(quantity);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spMaterial:
                slpMaterial = materialList.get(position).getId();
                break;

            case R.id.spSaid:
                slpSaid = saidList.get(position).getId();
                break;

            case R.id.spType:
                slpType = typeList.get(position).getId();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void responseMaterialView(List<Material> materialList) {
        this.materialList = materialList;
        ArrayAdapter<Material> adapterMatrial = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, materialList);
        adapterMatrial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMaterial.setAdapter(adapterMatrial);
        spMaterial.setOnItemSelectedListener(this);
    }

    @Override
    public void responseSaidView(List<Said> saidList) {
        this.saidList = saidList;
        ArrayAdapter<Said> adapterSaid = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, saidList);
        adapterSaid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSaid.setAdapter(adapterSaid);
        spSaid.setOnItemSelectedListener(this);
    }

    @Override
    public void responseTypeView(List<Type> typeList) {
        this.typeList = typeList;
        ArrayAdapter<Type> adapterType = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, typeList);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(adapterType);
        spType.setOnItemSelectedListener(this);
    }

    @Override
    public void responseValidateFileView(Boolean validate) {
        if (validate) {
            presenter.hideKeyboard(this);
            presenter.calculateProduct(slpMaterial, slpSaid, slpType, rbCOP.isChecked(), rbUS.isChecked(), Integer.parseInt(quantity.getText().toString()));
        } else {
            quantity.setFocusable(true);
            quantity.setFocusableInTouchMode(true);
            quantity.requestFocus();
            quantity.setError(getString(R.string.file_required));
        }

    }

    @Override
    public void responseTotal(String resut) {
        textResult.setText(resut);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbCOP) {
            // Toast.makeText(this, "Ha pulsado el botón 1", Toast.LENGTH_LONG).show();
        } else if (checkedId == R.id.rbUS) {
            // Toast.makeText(this, "Ha pulsado el botón 2", Toast.LENGTH_LONG).show();
        }
    }
}
