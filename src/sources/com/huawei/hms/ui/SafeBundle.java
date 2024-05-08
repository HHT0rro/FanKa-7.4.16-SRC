package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.LogUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafeBundle {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f31892a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f31892a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f31892a.get(str);
        } catch (Exception e2) {
            LogUtil.e("SafeBundle", "get exception: " + e2.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f31892a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f31892a.getString(str);
        } catch (Throwable th) {
            LogUtil.e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f31892a.isEmpty();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f31892a.size();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f31892a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f31892a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i10) {
        try {
            return this.f31892a.getInt(str, i10);
        } catch (Throwable th) {
            LogUtil.e("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i10;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f31892a.getString(str, str2);
        } catch (Exception e2) {
            LogUtil.e("SafeBundle", "getString exception: " + e2.getMessage(), true);
            return str2;
        }
    }
}
