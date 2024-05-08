package com.inno.innosdk.bean;

import android.content.Context;
import com.inno.innosdk.a.c;
import com.inno.innosdk.utils.AppInfomation;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FcDeviceInfo extends BaseDevice {
    public String exp;
    public String mep;
    public String scb;
    public String ss;
    public String vo;

    public FcDeviceInfo(String str) {
        this(c.k(), str, c.f35475c);
    }

    public String getValue() {
        return getValue(this);
    }

    public void loadFcData(Context context) {
        this.ss = AppInfomation.o(context);
        this.scb = String.valueOf(AppInfomation.h(context));
        this.vo = AppInfomation.t(context);
    }

    public FcDeviceInfo(Context context, String str) {
        this(context, str, c.f35475c);
    }

    public FcDeviceInfo(Context context, String str, Map<String, Object> map) {
        super(context);
        this.vo = "";
        this.act = str;
        setCp(map);
        loadFcData(context);
    }
}
