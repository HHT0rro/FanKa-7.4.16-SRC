package com.huawei.flexiblelayout.script.impl;

import com.huawei.flexiblelayout.log.Log;
import com.huawei.jslite.JSContext;
import com.koushikdutta.quack.JavaScriptObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Console {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28452a = "Console";

    /* renamed from: b, reason: collision with root package name */
    private static final Console f28453b = new Console();

    /* renamed from: c, reason: collision with root package name */
    public static final String f28454c = "console";

    private Console() {
    }

    public static Console a() {
        return f28453b;
    }

    public void debug(Object... objArr) {
        Log.println(3, f28452a, a(objArr));
    }

    public void error(Object... objArr) {
        Log.println(6, f28452a, a(objArr));
    }

    public void info(Object... objArr) {
        Log.println(4, f28452a, a(objArr));
    }

    public void log(Object... objArr) {
        Log.println(2, f28452a, a(objArr));
    }

    public void warn(Object... objArr) {
        Log.println(5, f28452a, a(objArr));
    }

    public void a(JSContext jSContext) {
        jSContext.set(f28454c, this);
    }

    public static String a(Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        if (objArr != null && objArr.length > 0) {
            sb2.append(a(objArr[0]));
            for (int i10 = 1; i10 < objArr.length; i10++) {
                sb2.append(" ");
                sb2.append(a(objArr[i10]));
            }
        }
        return sb2.toString();
    }

    public static String a(Object obj) {
        if (obj instanceof JavaScriptObject) {
            return ((JavaScriptObject) obj).stringify();
        }
        return String.valueOf(obj);
    }
}
