package com.huawei.appgallery.agd.common.support.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.appgallery.agd.common.CommonLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BaseSharedPreference {
    public SharedPreferences sp;

    public BaseSharedPreference(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.sp = context.getSharedPreferences("agd_shared_preference", 0);
        } catch (Exception e2) {
            CommonLog.LOG.w("BaseSharedPref", "SharedPreferencesWrapper exception = " + e2.getMessage());
            this.sp = new DummySp();
        }
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = this.sp.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e2) {
            CommonLog.LOG.e("BaseSharedPref", "clear error!!: " + e2.getMessage());
        }
    }

    public boolean contains(String str) {
        return this.sp.contains(str);
    }

    public int getInt(String str, int i10) {
        try {
            return this.sp.getInt(str, i10);
        } catch (ClassCastException unused) {
            this.sp.edit().remove(str).commit();
            return i10;
        }
    }

    public long getLong(String str, long j10) {
        try {
            return this.sp.getLong(str, j10);
        } catch (ClassCastException unused) {
            this.sp.edit().remove(str).commit();
            return j10;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.sp.getString(str, str2);
        } catch (Exception unused) {
            this.sp.edit().remove(str).commit();
            return str2;
        }
    }

    public void putInt(String str, int i10) {
        try {
            SharedPreferences.Editor edit = this.sp.edit();
            edit.putInt(str, i10);
            edit.commit();
        } catch (Exception unused) {
            CommonLog.LOG.e("BaseSharedPref", "putString error!!key:" + str);
        }
    }

    public void putLong(String str, long j10) {
        try {
            SharedPreferences.Editor edit = this.sp.edit();
            edit.putLong(str, j10);
            edit.commit();
        } catch (Exception unused) {
            CommonLog.LOG.e("BaseSharedPref", "putLong error!!key:" + str);
        }
    }

    public void putString(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.sp.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception unused) {
            CommonLog.LOG.e("BaseSharedPref", "putString error!!key:" + str);
        }
    }

    public void remove(String str) {
        try {
            SharedPreferences.Editor edit = this.sp.edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception unused) {
            CommonLog.LOG.e("baseSharedPre", "remove error.");
        }
    }
}
