package com.kwad.sdk.n;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends Application implements a {
    private final Application aTj;
    private final g aTk;

    public f(Application application, g gVar) {
        this.aTj = application;
        this.aTk = gVar;
        try {
            s.b(this, "mBase", gVar);
        } catch (Throwable unused) {
            attachBaseContext(gVar);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i10) {
        return this.aTj.bindService(intent, serviceConnection, i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this.aTk.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.aTk.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aTk.getClassLoader();
    }

    @Override // com.kwad.sdk.n.a
    @NonNull
    public final Context getDelegatedContext() {
        return this.aTj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aTk.getResources();
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aTj.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void sendBroadcast(Intent intent) {
        this.aTj.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        this.aTj.setTheme(i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr) {
        this.aTj.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        this.aTj.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    @RequiresApi(api = 26)
    public final ComponentName startForegroundService(Intent intent) {
        return this.aTj.startForegroundService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final ComponentName startService(Intent intent) {
        return this.aTj.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean stopService(Intent intent) {
        return this.aTj.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unbindService(ServiceConnection serviceConnection) {
        this.aTj.unbindService(serviceConnection);
    }

    @Override // android.app.Application
    public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aTj.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr, @Nullable Bundle bundle) {
        this.aTj.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, @Nullable Bundle bundle) {
        this.aTj.startActivity(intent, bundle);
    }
}
