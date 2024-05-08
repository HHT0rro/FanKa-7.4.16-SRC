package com.cupidapp.live.liveshow.beauty.databeauty;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class UserData {
    public static final String NAME = "user";
    public static final String RESOURCE_READY = "resource";
    public static final String VERSION = "versionCode";
    private static volatile UserData sInstance;
    private SharedPreferences mSp;

    private UserData(Context context) {
        this.mSp = context.getSharedPreferences(NAME, 0);
    }

    public static UserData getInstance(Context context) {
        if (sInstance == null) {
            synchronized (UserData.class) {
                if (sInstance == null) {
                    sInstance = new UserData(context);
                }
            }
        }
        return sInstance;
    }

    public int getVersion() {
        return this.mSp.getInt("versionCode", 0);
    }

    public boolean isResourceReady() {
        return this.mSp.getBoolean(RESOURCE_READY, false);
    }

    public void setResourceReady(boolean z10) {
        this.mSp.edit().putBoolean(RESOURCE_READY, z10).apply();
    }

    public void setVersion(int i10) {
        this.mSp.edit().putInt("versionCode", i10).apply();
    }
}
