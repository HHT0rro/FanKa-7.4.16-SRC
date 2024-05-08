package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final String Code = "ActivityUtils";
    private static final int V = 5;

    public static String Code(Context context) {
        Activity V2 = V(context);
        if (V2 != null) {
            gl.Code(Code, "ana_tag  getActivityLocalClassName LocalClassName = %s", V2.getLocalClassName());
            return V2.getLocalClassName();
        }
        gl.Z(Code, "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }

    public static String Code(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else {
            if (obj instanceof View) {
                return Code(((View) obj).getContext());
            }
            str = "ana_tag  getActivityName activityname is not view";
        }
        gl.Z(Code, str);
        return null;
    }

    private static Activity V(Context context) {
        if (context == null) {
            gl.Z(Code, "ana_tag getActivity context is null, return");
            return null;
        }
        int i10 = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i10++;
            if (i10 > 5) {
                gl.Z(Code, "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
