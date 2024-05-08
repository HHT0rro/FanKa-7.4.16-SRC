package com.huawei.qcardsupport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.quickcard.elexecutor.ICSSRender;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IQuickCardProvider;
import java.util.Map;
import java.util.Objects;

/* compiled from: QContextProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h implements IQuickCardProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final int f33135e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f33136f = 2;

    /* renamed from: a, reason: collision with root package name */
    private final f f33137a = new f();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private IScriptContext f33138b;

    /* renamed from: c, reason: collision with root package name */
    private g f33139c;

    /* renamed from: d, reason: collision with root package name */
    private int f33140d;

    public void a(@NonNull IScriptContext iScriptContext) {
        this.f33138b = iScriptContext;
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public /* synthetic */ String getCardId() {
        return com.huawei.quickcard.elexecutor.c.a(this);
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public ICSSRender getCssRender() {
        return null;
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public IExpressionContext getExpressionContext(String str) {
        return getExpressionContext(str, 0);
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public /* synthetic */ void release() {
        com.huawei.quickcard.elexecutor.c.b(this);
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public /* synthetic */ void setOptions(Map map) {
        com.huawei.quickcard.elexecutor.c.c(this, map);
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public /* synthetic */ void setTemplate(String str) {
        com.huawei.quickcard.elexecutor.c.d(this, str);
    }

    public void a(String str, Object obj, int i10) {
        this.f33137a.a(str, obj, i10);
    }

    @Override // com.huawei.quickcard.elexecutor.IQuickCardProvider
    public IExpressionContext getExpressionContext(String str, int i10) {
        Objects.requireNonNull(this.f33138b, "mScriptContext must not be null, call 'setScriptContext' first.");
        if (this.f33139c == null) {
            if (i10 >= 1002) {
                this.f33139c = new i(this.f33138b, this.f33137a);
            } else {
                this.f33139c = new g(this.f33138b, this.f33137a);
            }
            this.f33139c.a(this.f33140d);
        }
        if (this.f33139c.a()) {
            return null;
        }
        this.f33139c.a(this.f33137a);
        return this.f33139c;
    }

    public void a(int i10) {
        this.f33140d = i10;
        g gVar = this.f33139c;
        if (gVar != null) {
            gVar.a(i10);
        }
    }

    public void a() {
        a(0);
        g gVar = this.f33139c;
        if (gVar != null) {
            gVar.a(this.f33137a);
            this.f33139c.b();
        }
    }
}
