package com.android.internal.policy;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ForceShowNavBarSettingsObserver extends ContentObserver {
    private Context mContext;
    private Runnable mOnChangeRunnable;

    public ForceShowNavBarSettingsObserver(Handler handler, Context context) {
        super(handler);
        this.mContext = context;
    }

    public void setOnChangeRunnable(Runnable r10) {
        this.mOnChangeRunnable = r10;
    }

    public void register() {
        ContentResolver r10 = this.mContext.getContentResolver();
        r10.registerContentObserver(Settings.Secure.getUriFor("nav_bar_force_visible"), false, this, -1);
    }

    public void unregister() {
        this.mContext.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean selfChange, Collection<Uri> uris, int flags, int userId) {
        Runnable runnable;
        if (userId == ActivityManager.getCurrentUser() && (runnable = this.mOnChangeRunnable) != null) {
            runnable.run();
        }
    }

    public boolean isEnabled() {
        return Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "nav_bar_force_visible", 0, -2) == 1;
    }
}
