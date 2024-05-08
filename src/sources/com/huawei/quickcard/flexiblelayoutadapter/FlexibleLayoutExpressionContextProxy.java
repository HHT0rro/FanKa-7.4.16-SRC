package com.huawei.quickcard.flexiblelayoutadapter;

import androidx.annotation.NonNull;
import com.huawei.quickcard.QuickCardEngine;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.elexecutor.b;
import com.huawei.quickcard.quackjsadapter.QuickCardDataWrapper;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexibleLayoutExpressionContextProxy implements IExpressionContextProxy {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33695b = "FlexibleLayoutExpressionContextProxy";

    /* renamed from: a, reason: collision with root package name */
    private IExpressionContext f33696a;

    public FlexibleLayoutExpressionContextProxy(IExpressionContext iExpressionContext) {
        this.f33696a = iExpressionContext;
    }

    private Object a(Object obj) {
        if (obj instanceof Object[]) {
            obj = Arrays.asList((Object[]) obj);
        }
        return (obj == null || WrapDataUtils.getDataWrapper(obj) == null) ? obj : new QuickCardDataWrapper(obj, null, getId());
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object callFunction(String str, Object... objArr) {
        IExpressionContext iExpressionContext = this.f33696a;
        if (iExpressionContext == null) {
            return null;
        }
        try {
            return iExpressionContext.callFunction(str, objArr);
        } catch (Exception e2) {
            CardLogUtils.w(f33695b, "call js method failed::" + e2.getMessage());
            return null;
        }
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public void close() {
        if (this.f33696a != null) {
            this.f33696a = null;
        }
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public void create(@NonNull String str) {
        IExpressionContext iExpressionContext = this.f33696a;
        if (iExpressionContext != null) {
            iExpressionContext.create(str);
        }
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContextProxy, com.huawei.quickcard.elexecutor.IExpressionContext
    public /* synthetic */ Object evaluate(String str, Collection collection, Collection collection2) {
        return b.a(this, str, collection, collection2);
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object[] evaluate(@NonNull String[] strArr) {
        IExpressionContext iExpressionContext = this.f33696a;
        return iExpressionContext != null ? iExpressionContext.evaluate(strArr) : new Object[0];
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object get(String str) {
        IExpressionContext iExpressionContext = this.f33696a;
        if (iExpressionContext == null) {
            return null;
        }
        Object obj = iExpressionContext.get(str);
        return obj instanceof CardDataObject ? ((CardDataObject) obj).getOriginalObject() : obj;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public /* synthetic */ int getId() {
        return com.huawei.quickcard.elexecutor.a.c(this);
    }

    public IExpressionContext getSrcExpressionContext() {
        return this.f33696a;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public void set(String str, Object obj) {
        if (this.f33696a == null) {
            return;
        }
        if (obj instanceof QuickCardDataWrapper) {
            QuickCardDataWrapper quickCardDataWrapper = (QuickCardDataWrapper) obj;
            quickCardDataWrapper.setPath(str);
            quickCardDataWrapper.setContextId(getId());
            this.f33696a.set(str, obj);
            return;
        }
        if (obj != null && WrapDataUtils.getDataWrapper(obj) != null) {
            this.f33696a.set(str, new QuickCardDataWrapper(obj, str, getId()));
        } else {
            this.f33696a.set(str, obj);
        }
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContextProxy
    public void setSrcExpressionContext(IExpressionContext iExpressionContext) {
        this.f33696a = iExpressionContext;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContextProxy
    public Object[] evaluate(@NonNull String[] strArr, int i10) {
        Object[] evaluate;
        if (i10 >= QuickCardEngine.getMinToolkitLevel() && (evaluate = evaluate(strArr)) != null && evaluate.length == strArr.length) {
            Object[] objArr = new Object[evaluate.length];
            for (int i11 = 0; i11 < evaluate.length; i11++) {
                objArr[i11] = a(evaluate[i11]);
            }
            return objArr;
        }
        return a(strArr);
    }

    private Object[] a(@NonNull String[] strArr) {
        if (this.f33696a == null) {
            return new Object[0];
        }
        StringBuilder sb2 = new StringBuilder("(function() {var ret=new Array();");
        for (int i10 = 0; i10 < strArr.length; i10++) {
            sb2.append(" try{ret[");
            sb2.append(i10);
            sb2.append("]=");
            sb2.append(strArr[i10]);
            sb2.append("}catch(err){};");
        }
        sb2.append("return ret;}).apply(this)");
        JavaScriptObject javaScriptObject = (JavaScriptObject) this.f33696a.evaluate(sb2.toString());
        Object[] objArr = new Object[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            objArr[i11] = a(javaScriptObject.get(i11));
        }
        return objArr;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionContext
    public Object evaluate(@NonNull String str) {
        IExpressionContext iExpressionContext = this.f33696a;
        if (iExpressionContext == null) {
            return null;
        }
        return a(iExpressionContext.evaluate(str));
    }
}
