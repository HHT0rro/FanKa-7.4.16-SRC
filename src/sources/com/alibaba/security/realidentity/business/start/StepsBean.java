package com.alibaba.security.realidentity.business.start;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StepsBean implements Serializable {
    private StepsExtras extras;
    private List<String> materialCategories;
    private String name;

    public StepsExtras getExtras() {
        return this.extras;
    }

    public List<String> getMaterialCategories() {
        return this.materialCategories;
    }

    public String getName() {
        return this.name;
    }

    public void setExtras(StepsExtras stepsExtras) {
        this.extras = stepsExtras;
    }

    public void setMaterialCategories(List<String> list) {
        this.materialCategories = list;
    }

    public void setName(String str) {
        this.name = str;
    }
}
