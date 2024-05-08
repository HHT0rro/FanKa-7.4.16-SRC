package com.huawei.flexiblelayout.css.action;

import android.util.ArrayMap;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.annotation.CSSActionClass;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: CSSActionHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f27966b = "CSSActionHelper";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends CSSAction>> f27967a;

    /* compiled from: CSSActionHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f27968a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.f27968a;
    }

    public CSSAction a(String str) {
        Class<? extends CSSAction> cls = this.f27967a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            Log.w(f27966b, "getCSSAction IllegalAccessException, e: " + e2.getMessage());
            return null;
        } catch (InstantiationException e10) {
            Log.w(f27966b, "getCSSAction InstantiationException, e: " + e10.getMessage());
            return null;
        }
    }

    private a() {
        this.f27967a = new ArrayMap();
        a();
    }

    public boolean b(String str) {
        return this.f27967a.containsKey(str);
    }

    private void a() {
        for (Field field : CSSPropertyName.class.getFields()) {
            if (field.isAnnotationPresent(CSSActionClass.class)) {
                try {
                    this.f27967a.put((String) field.get(null), ((CSSActionClass) field.getAnnotation(CSSActionClass.class)).value());
                } catch (IllegalAccessException e2) {
                    Log.w(f27966b, "fillCSSActionMap IllegalAccessException, e: " + e2.getMessage());
                }
            }
        }
    }
}
