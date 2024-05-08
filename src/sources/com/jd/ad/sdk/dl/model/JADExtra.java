package com.jd.ad.sdk.dl.model;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class JADExtra implements IJADExtra {
    private double price = ShadowDrawableWrapper.COS_45;

    @Override // com.jd.ad.sdk.dl.model.IJADExtra
    public int getPrice() {
        return (int) Math.round(this.price);
    }

    public void setPrice(double d10) {
        this.price = d10;
    }
}
