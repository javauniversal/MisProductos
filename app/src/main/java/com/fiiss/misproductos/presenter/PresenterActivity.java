package com.fiiss.misproductos.presenter;


import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.interfaces.InterfaceActivity;
import com.fiiss.misproductos.model.ModelActivity;
import com.fiiss.misproductos.view.ListProduct;

import java.util.List;

public class PresenterActivity implements InterfaceActivity.Presenter {

    private InterfaceActivity.View activityView;
    private InterfaceActivity.Model activityModel;

    public PresenterActivity(InterfaceActivity.View activityView) {
        this.activityView = activityView;
        activityModel = new ModelActivity(this);
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
    public void validateFields() {

    }
}
