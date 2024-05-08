package com.alibaba.security.realidentity.build;

import android.taobao.windvane.jsbridge.WVResult;

/* compiled from: TransformUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bd {
    public static WVResult a(bf bfVar) {
        WVResult wVResult = new WVResult();
        try {
            wVResult.getClass().getField("success").set(wVResult, Integer.valueOf(bfVar.f3165a));
            wVResult.setData(bfVar.f3166k);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
        return wVResult;
    }
}
