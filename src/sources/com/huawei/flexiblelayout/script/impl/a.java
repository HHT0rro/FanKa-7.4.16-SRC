package com.huawei.flexiblelayout.script.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.flexiblelayout.script.ScriptConfigService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ScriptConfigServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements ScriptConfigService {

    /* renamed from: b, reason: collision with root package name */
    private static final a f28457b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f28458a = new HashMap();

    private a() {
    }

    public static a a() {
        return f28457b;
    }

    @Override // com.huawei.flexiblelayout.script.ScriptConfigService
    public void export(@NonNull String str, @NonNull Object obj) {
        this.f28458a.put(str, obj);
    }

    public void a(@NonNull IScriptContext iScriptContext) {
        for (Map.Entry<String, Object> entry : this.f28458a.entrySet()) {
            iScriptContext.set(entry.getKey(), entry.getValue());
        }
    }
}
