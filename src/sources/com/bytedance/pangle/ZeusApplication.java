package com.bytedance.pangle;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ZeusApplication extends PluginContext {
    public Application mHostApplication;

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        attachBaseContext(application);
        onCreate();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
    }
}
