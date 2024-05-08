package com.alimm.tanx.core.ad.bean;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewBean extends BaseBean {

    /* renamed from: id, reason: collision with root package name */
    public int f4180id;
    public String msg;
    public View view;

    public ViewBean(int i10, View view, String str) {
        this.f4180id = i10;
        this.view = view;
        this.msg = str;
    }

    public int getId() {
        return this.f4180id;
    }

    public String getMsg() {
        return this.msg;
    }

    public View getView() {
        return this.view;
    }

    public void setId(int i10) {
        this.f4180id = i10;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setView(View view) {
        this.view = view;
    }
}
