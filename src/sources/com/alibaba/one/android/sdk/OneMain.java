package com.alibaba.one.android.sdk;

import android.app.Application;
import android.content.Context;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OneMain {
    public static Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface UpdateListener {
        void onUpdated(int i10, int i11, String str);
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
    }

    private static native void initNative(Context context);

    public static void initialize(Context context) {
        mContext = context;
        initNative(context);
    }

    public static Object play(int i10, int i11, int i12, Object obj) {
        try {
            if (mContext == null) {
                return null;
            }
            return playNative(i10, i11, i12, obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native Object playNative(int i10, int i11, int i12, Object obj);
}
