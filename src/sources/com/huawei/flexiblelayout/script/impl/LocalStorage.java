package com.huawei.flexiblelayout.script.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.flexiblelayout.log.Log;
import com.koushikdutta.quack.JavaScriptObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LocalStorage {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28455b = "LocalStorage";

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f28456a;

    public LocalStorage(Context context) {
        this.f28456a = context.getSharedPreferences("com.huawei.flexiblelayout.LocalStorage", 0);
    }

    public void clear() {
        this.f28456a.edit().clear().apply();
    }

    public String getItem(String str) {
        return !TextUtils.isEmpty(str) ? this.f28456a.getString(str, "") : "";
    }

    public void removeItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28456a.edit().remove(str).apply();
    }

    public void setItem(String str, Object obj) {
        String valueOf;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            this.f28456a.edit().remove(str).apply();
            return;
        }
        if (obj instanceof JavaScriptObject) {
            JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
            if (javaScriptObject.isFunction()) {
                Log.w(f28455b, "The storage function is not supported.");
                return;
            }
            valueOf = javaScriptObject.stringify();
        } else {
            valueOf = String.valueOf(obj);
        }
        this.f28456a.edit().putString(str, valueOf).apply();
    }
}
