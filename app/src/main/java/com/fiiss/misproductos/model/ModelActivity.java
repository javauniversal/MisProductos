package com.fiiss.misproductos.model;

import com.fiiss.misproductos.R;
import com.fiiss.misproductos.entities.Material;
import com.fiiss.misproductos.entities.Said;
import com.fiiss.misproductos.entities.Type;
import com.fiiss.misproductos.interfaces.InterfaceActivity;
import com.fiiss.misproductos.view.ListProduct;

import java.util.ArrayList;
import java.util.List;

public class ModelActivity implements InterfaceActivity.Model {

    private InterfaceActivity.Presenter activityPresenter;

    public ModelActivity(InterfaceActivity.Presenter activityPresenter) {
        this.activityPresenter = activityPresenter;
    }

    @Override
    public void getMaterial(ListProduct listProduct) {
        List<Material> materials = new ArrayList<>();

        Material material = new Material();
        material.setId(1);
        material.setDescription(listProduct.getString(R.string.leather));
        materials.add(material);

        material = new Material();
        material.setId(2);
        material.setDescription(listProduct.getString(R.string.rope));
        materials.add(material);

        activityPresenter.getMaterialPresenter(materials);

    }

    @Override
    public void getSaid(ListProduct listProduct) {
        List<Said> saidList = new ArrayList<>();

        Said said = new Said();
        said.setId(1);
        said.setDescription(listProduct.getString(R.string.hammer));
        saidList.add(said);

        said = new Said();
        said.setId(2);
        said.setDescription(listProduct.getString(R.string.anchor));
        saidList.add(said);

        activityPresenter.getSaidPresenter(saidList);

    }

    @Override
    public void getType(ListProduct listProduct) {
        List<Type> typeList = new ArrayList<>();

        Type type = new Type();
        type.setId(1);
        type.setDescription(listProduct.getString(R.string.gold));
        typeList.add(type);

        type = new Type();
        type.setId(2);
        type.setDescription(listProduct.getString(R.string.gold_bath));
        typeList.add(type);

        type = new Type();
        type.setId(3);
        type.setDescription(listProduct.getString(R.string.pink_gold));
        typeList.add(type);

        type = new Type();
        type.setId(4);
        type.setDescription(listProduct.getString(R.string.silver));
        typeList.add(type);

        type = new Type();
        type.setId(5);
        type.setDescription(listProduct.getString(R.string.nickel));
        typeList.add(type);

        activityPresenter.getTypePresenter(typeList);
    }
}
