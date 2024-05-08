package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends Application {
        private final Context amb;

        public a(Context context) {
            this.amb = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.amb;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.amb.getApplicationInfo();
        }
    }

    public static Context ax(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        if (!applicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new a(context);
        }
        return context.getApplicationContext();
    }
}
