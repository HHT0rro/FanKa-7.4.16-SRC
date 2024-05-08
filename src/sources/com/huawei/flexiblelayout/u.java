package com.huawei.flexiblelayout;

import android.text.TextUtils;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CalcFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class u implements s {

    /* renamed from: a, reason: collision with root package name */
    public static final String f28633a = "calc";

    /* renamed from: b, reason: collision with root package name */
    private static List<String> f28634b;

    /* compiled from: CalcFunction.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements ProcessorResult {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f28635a;

        public a(AtomicReference atomicReference) {
            this.f28635a = atomicReference;
        }

        @Override // com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            this.f28635a.set(obj);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f28634b = arrayList;
        arrayList.add("env(");
        f28634b.add("grid-width(");
    }

    private static Integer b(String str) {
        x0 x0Var = (x0) t0.a(x0.f28668b, str);
        AtomicReference atomicReference = new AtomicReference();
        x0Var.process(null, new a(atomicReference));
        Object obj = atomicReference.get();
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return null;
    }

    private String c(String str) {
        for (String str2 : f28634b) {
            while (true) {
                int indexOf = str.indexOf(str2);
                if (indexOf >= 0) {
                    String substring = str.substring(indexOf, str.indexOf(41, str2.length() + indexOf) + 1);
                    str = str.replace(substring, String.valueOf(t.a(substring).intValue()));
                }
            }
        }
        return "{{" + str + "}}";
    }

    @Override // com.huawei.flexiblelayout.s
    public Integer a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(c(str));
    }
}
