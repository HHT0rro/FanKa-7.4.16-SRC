package com.huawei.qcardsupport;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.jslite.type.jstojava.CaptureVariablesCoercion;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.framework.QuickCardField;
import com.huawei.quickcard.framework.bean.I18nBean;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* compiled from: QContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g implements IExpressionContext {

    /* renamed from: e, reason: collision with root package name */
    private static final String f33129e = "QContext";

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<String> f33130f = new a();

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public IScriptContext f33131a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final f f33132b;

    /* renamed from: c, reason: collision with root package name */
    private int f33133c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33134d;

    /* compiled from: QContext.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends HashSet<String> {
        public a() {
            add(QuickCardField.DATA);
            add(QuickCardField.GLOBAL_DATA_MOUNT);
            add("$group");
            add("$context");
            add("$card");
            add(QuickCardField.ACTION_EVENT_KEY);
            add(QuickCardField.ACTION_PREFIX);
            add(QuickCardField.CONFIGURATION);
            add(QuickCardField.HOST_PARAMS);
            add("message");
            add(I18nBean.Field.I18N_OBJECT);
        }
    }

    public g(@NonNull IScriptContext iScriptContext, @NonNull f fVar) {
        this.f33131a = iScriptContext;
        this.f33132b = fVar;
    }

    public boolean a() {
        return this.f33131a.isClosed();
    }

    public void b() {
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object callFunction(String str, Object... objArr) {
        if (!this.f33134d) {
            Log.e(f33129e, "you need call create first");
            return null;
        }
        if (this.f33131a.isClosed() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f33131a.callFunction(str, objArr);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public /* synthetic */ void close() {
        com.huawei.quickcard.elexecutor.a.a(this);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public void create(@NonNull String str) {
        if (this.f33134d) {
            return;
        }
        this.f33134d = true;
        a(str);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public /* synthetic */ Object evaluate(String str, Collection collection, Collection collection2) {
        return com.huawei.quickcard.elexecutor.a.b(this, str, collection, collection2);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object[] evaluate(String[] strArr) {
        if (strArr == null || strArr.length == 0 || this.f33131a.isClosed()) {
            return new Object[0];
        }
        StringBuilder sb2 = new StringBuilder("[");
        for (int i10 = 0; i10 < strArr.length; i10++) {
            sb2.append('(');
            String str = strArr[i10];
            if (str != null && !str.trim().isEmpty()) {
                sb2.append(str);
            } else {
                sb2.append("undefined");
            }
            sb2.append(')');
            if (i10 != strArr.length - 1) {
                sb2.append(',');
            }
        }
        sb2.append(']');
        Object evaluate = evaluate(sb2.toString());
        if (!(evaluate instanceof JavaScriptObject)) {
            return new Object[0];
        }
        JavaScriptObject javaScriptObject = (JavaScriptObject) evaluate;
        Object[] objArr = new Object[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            objArr[i11] = javaScriptObject.get(i11);
        }
        return objArr;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object get(String str) {
        if (!this.f33134d) {
            Log.e(f33129e, "you need call create first");
            return null;
        }
        if (this.f33131a.isClosed() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f33131a.get(str);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public /* synthetic */ int getId() {
        return com.huawei.quickcard.elexecutor.a.c(this);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public void set(String str, Object obj) {
        if (!this.f33134d) {
            Log.e(f33129e, "you need call create first");
        } else {
            if (this.f33131a.isClosed() || TextUtils.isEmpty(str) || !f33130f.contains(str)) {
                return;
            }
            this.f33131a.set(str, obj);
        }
    }

    public void a(int i10) {
        this.f33133c = i10;
    }

    public void a(@NonNull String str) {
        this.f33131a.setCoerceJavaScriptToJava(new CaptureVariablesCoercion());
        a(this.f33132b);
        evaluate(str);
    }

    public void a(f fVar) {
        if (this.f33134d) {
            for (Map.Entry<String, Pair<Object, Integer>> entry : fVar.a().entrySet()) {
                Pair<Object, Integer> value = entry.getValue();
                if ((this.f33133c & ((Integer) value.second).intValue()) > 0) {
                    set(entry.getKey(), value.first);
                } else {
                    set(entry.getKey(), null);
                }
            }
        }
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object evaluate(@NonNull String str) {
        if (!this.f33134d) {
            Log.e(f33129e, "you need call create first");
            return null;
        }
        if (this.f33131a.isClosed() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f33131a.evaluate(str);
    }
}
