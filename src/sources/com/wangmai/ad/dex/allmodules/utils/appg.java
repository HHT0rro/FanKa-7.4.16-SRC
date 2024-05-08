package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.wangmai.common.utils.Utils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: CoveredUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appg {
    public static Boolean appa(Context context, View view) {
        try {
            Rect rect = new Rect(0, 0, Utils.getWindowWidth(context), Utils.getWindowHeight(context));
            view.getLocationInWindow(new int[2]);
            if (view.getLocalVisibleRect(rect)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("CoveredUtils", "checkIsVisible:" + th.toString());
            return true;
        }
    }
}
