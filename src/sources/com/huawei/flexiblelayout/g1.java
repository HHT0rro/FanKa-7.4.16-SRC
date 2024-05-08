package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.card.IndicatorCard;
import com.huawei.flexiblelayout.f1;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.impl.interactive.ScriptFunction;
import com.huawei.jslite.JSContext;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.Arrays;

/* compiled from: TimerFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g1 implements ScriptFunction {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28135b = "TimerFunction";

    /* renamed from: c, reason: collision with root package name */
    public static final int f28136c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f28137d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f28138e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f28139f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f28140g = {"setTimeout", "clearTimeout", IndicatorCard.f27800l, "clearInterval"};

    /* renamed from: a, reason: collision with root package name */
    private final int f28141a;

    public g1(int i10) {
        this.f28141a = i10;
    }

    public static void a(JSContext jSContext) {
        int i10 = 0;
        while (true) {
            String[] strArr = f28140g;
            if (i10 >= strArr.length) {
                return;
            }
            jSContext.set(strArr[i10], jSContext.coerceJavaToJavaScript(ScriptFunction.class, new g1(i10)));
            i10++;
        }
    }

    @Override // com.huawei.flexiblelayout.script.impl.interactive.ScriptFunction
    public Object invoke(Object... objArr) {
        int i10 = this.f28141a;
        if (i10 == 0) {
            return a(false, objArr);
        }
        if (i10 == 1) {
            a(objArr);
            return null;
        }
        if (i10 == 2) {
            return a(true, objArr);
        }
        if (i10 != 3) {
            return null;
        }
        a(objArr);
        return null;
    }

    private Integer a(boolean z10, Object[] objArr) {
        Long l10 = null;
        if (objArr.length < 1) {
            Log.e(f28135b, "startTimer failed, missing args");
            return null;
        }
        f1.b a10 = a(objArr[0]);
        if (a10 == null) {
            Log.e(f28135b, "startTimer failed, args[0] must be function");
            return null;
        }
        if (objArr.length >= 2) {
            if (objArr[1] instanceof Number) {
                l10 = Long.valueOf(((Number) objArr[1]).longValue());
            } else {
                Log.e(f28135b, "startTimer failed, args[1] must be int/long");
                return null;
            }
        }
        return f1.a().a(z10, a10, l10 != null ? l10.longValue() : 0L, Arrays.copyOfRange(objArr, l10 != null ? 2 : 1, objArr.length));
    }

    private void a(Object[] objArr) {
        if (objArr.length < 1) {
            Log.e(f28135b, "stopTimer failed, missing args");
            return;
        }
        for (Object obj : objArr) {
            if (obj instanceof Number) {
                f1.a().a(((Number) obj).intValue());
            } else {
                Log.e(f28135b, "stopTimer failed, args must be int");
            }
        }
    }

    private f1.b a(Object obj) {
        if (obj instanceof f1.b) {
            return (f1.b) obj;
        }
        if (!(obj instanceof JavaScriptObject)) {
            return null;
        }
        JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
        Object coerceJavaScriptToJava = javaScriptObject.quackContext.coerceJavaScriptToJava(f1.b.class, javaScriptObject);
        if (coerceJavaScriptToJava instanceof f1.b) {
            return (f1.b) coerceJavaScriptToJava;
        }
        return null;
    }
}
