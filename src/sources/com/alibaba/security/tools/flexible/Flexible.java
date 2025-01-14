package com.alibaba.security.tools.flexible;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Flexible {
    private static final String TAG = "Flexible";

    public static void setContentView(Activity activity, int i10) {
        new FlexibleContext(activity, activity).addView(LayoutInflater.from(activity).inflate(i10, (ViewGroup) null), null);
    }

    public static void setContentView(Activity activity, View view) {
        new FlexibleContext(activity, activity).addView(view, null);
    }
}
