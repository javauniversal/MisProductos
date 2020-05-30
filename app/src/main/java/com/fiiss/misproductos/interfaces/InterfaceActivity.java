package com.fiiss.misproductos.interfaces;

import android.app.Activity;
import android.widget.EditText;

import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.view.ListProduct;

import java.util.List;

public interface InterfaceActivity {

    interface View {
        void responseMaterialView(List<Material> materialList);
        void responseSaidView(List<Said> saidList);
        void responseTypeView(List<Type> typeList);
        void responseValidateFileView(Boolean validate);
        void responseTotal(String resut);
    }

    interface Model {
        void getMaterial(ListProduct listProduct);
        void getSaid(ListProduct listProduct);
        void getType(ListProduct listProduct);
    }

    interface Presenter {
        void setDataMaterial(ListProduct listProduct);
        void setDataSaid(ListProduct listProduct);
        void setDataType(ListProduct listProduct);

        void getMaterialPresenter(List<Material> materialList);
        void getSaidPresenter(List<Said> saidList);
        void getTypePresenter(List<Type> typeList);

        void validateFields(EditText editText);
        void hideKeyboard(Activity activity);

        void calculateProduct(int material, int Said, int type, boolean cop, boolean us, int quantity);
    }

}
