package com.huawei.flexiblelayout.script.impl.interactive;

import com.huawei.flexiblelayout.log.Log;
import com.huawei.hmf.orb.tbis.TbisModuleLoader;
import com.huawei.jslite.JSContext;

/* compiled from: RequireModule.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements ScriptFunction {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28487a = "RequireModule";

    /* renamed from: b, reason: collision with root package name */
    private static final a f28488b = new a();

    private a() {
    }

    public static a a() {
        return f28488b;
    }

    @Override // com.huawei.flexiblelayout.script.impl.interactive.ScriptFunction
    public Object invoke(Object... objArr) {
        String valueOf = (objArr == null || objArr.length < 1) ? "" : String.valueOf(objArr[0]);
        try {
            return TbisModuleLoader.load(valueOf);
        } catch (LinkageError e2) {
            Log.e(f28487a, "Load '" + valueOf + "' module failed, May be missing the HMF Core library. " + e2.getMessage());
            return null;
        }
    }

    public void a(JSContext jSContext) {
        jSContext.set("requireModule", jSContext.coerceJavaToJavaScript(ScriptFunction.class, this));
    }
}
