package com.fiiss.misproductos.presenter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.interfaces.InterfaceActivity;
import com.fiiss.misproductos.model.ModelActivity;
import com.fiiss.misproductos.view.ListProduct;

import java.text.DecimalFormat;
import java.util.List;

public class PresenterActivity implements InterfaceActivity.Presenter {

    private InterfaceActivity.View activityView;
    private InterfaceActivity.Model activityModel;
    private DecimalFormat format;

    public PresenterActivity(InterfaceActivity.View activityView) {
        this.activityView = activityView;
        activityModel = new ModelActivity(this);
        format = new DecimalFormat("#,###.##");
    }

    @Override
    public void setDataMaterial(ListProduct listProduct) {
        activityModel.getMaterial(listProduct);
    }

    @Override
    public void setDataSaid(ListProduct listProduct) {
        activityModel.getSaid(listProduct);
    }

    @Override
    public void setDataType(ListProduct listProduct) {
        activityModel.getType(listProduct);
    }

    @Override
    public void getMaterialPresenter(List<Material> materialList) {
        activityView.responseMaterialView(materialList);
    }

    @Override
    public void getSaidPresenter(List<Said> saidList) {
        activityView.responseSaidView(saidList);
    }

    @Override
    public void getTypePresenter(List<Type> typeList) {
        activityView.responseTypeView(typeList);
    }

    @Override
    public void validateFields(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            activityView.responseValidateFileView(false);
        } else {
            activityView.responseValidateFileView(true);
        }
    }

    @Override
    public void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void calculateProduct(int material, int Said, int type, boolean cop, boolean us, int quantity) {
        if (material == 1 && Said == 1 && (type == 1 || type == 3)) {
            activityView.responseTotal(valueEnd(cop, us, 100, quantity));
        } else if (material == 1 && Said == 1 && type == 4) {
            activityView.responseTotal(valueEnd(cop, us, 80, quantity));
        } else if (material == 1 && Said == 1 && type == 5) {
            activityView.responseTotal(valueEnd(cop, us, 70, quantity));
        } else if (material == 1 && Said == 2 && (type == 1 || type == 3)) {
            activityView.responseTotal(valueEnd(cop, us, 120, quantity));
        } else if (material == 1 && Said == 2 && type == 4) {
            activityView.responseTotal(valueEnd(cop, us, 100, quantity));
        } else if (material == 1 && Said == 2 && type == 5) {
            activityView.responseTotal(valueEnd(cop, us, 90, quantity));
        } else if (material == 2 && Said == 1 && (type == 1 || type == 3)) {
            activityView.responseTotal(valueEnd(cop, us, 90, quantity));
        } else if (material == 2 && Said == 1 && type == 4) {
            activityView.responseTotal(valueEnd(cop, us, 70, quantity));
        } else if (material == 2 && Said == 1 && type == 5) {
            activityView.responseTotal(valueEnd(cop, us, 50, quantity));
        } else if (material == 2 && Said == 2 && (type == 1 || type == 3)) {
            activityView.responseTotal(valueEnd(cop, us, 110, quantity));
        } else if (material == 2 && Said == 2 && type == 4) {
            activityView.responseTotal(valueEnd(cop, us, 90, quantity));
        } else if (material == 2 && Said == 2 && type == 5) {
            activityView.responseTotal(valueEnd(cop, us, 80, quantity));
        }
    }

    @SuppressLint("DefaultLocale")
    private String valueEnd(boolean cop, boolean us, double valor, int quantity) {
        if (cop) {
            return String.format("COP $%1s", format.format((valor*quantity)*3200));
        } else if (us) {
            return String.format("US $%1s", format.format(valor*quantity));
        }

        return "";
    }

}
