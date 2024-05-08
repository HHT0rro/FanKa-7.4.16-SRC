package com.nirvana.tools.core;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseDelegate {
    private static final String TAG = "com.nirvana.tools.core.BaseDelegate";
    public static volatile Boolean sComponentClassExist;

    public BaseDelegate() {
        if (sComponentClassExist == null) {
            Context context = ComponentSdkCore.sApplicationContext;
            if (context == null) {
                sComponentClassExist = Boolean.FALSE;
                return;
            }
            try {
                context.getClassLoader().loadClass(getSubClassName());
                sComponentClassExist = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                StringBuilder sb2 = new StringBuilder("Load class ");
                sb2.append(getSubClassName());
                sb2.append(" failed!");
                sComponentClassExist = Boolean.FALSE;
            }
        }
    }

    public abstract String getSubClassName();
}
