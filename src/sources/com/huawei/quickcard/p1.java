package com.huawei.quickcard;

import android.view.View;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.ui.RenderCommand;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p1<T extends View> implements RenderCommand {

    /* renamed from: a, reason: collision with root package name */
    private final PropertyProcessor<T> f34168a;

    /* renamed from: b, reason: collision with root package name */
    private final T f34169b;

    /* renamed from: c, reason: collision with root package name */
    private final String f34170c;

    /* renamed from: d, reason: collision with root package name */
    private final QuickCardValue f34171d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34172e;

    public p1(PropertyProcessor<T> propertyProcessor, T t2, String str, QuickCardValue quickCardValue) {
        this.f34168a = propertyProcessor;
        this.f34169b = t2;
        this.f34170c = str;
        this.f34171d = quickCardValue;
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public String attrName() {
        return this.f34170c;
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public void doRender() {
        this.f34168a.setProperty(this.f34169b, this.f34170c, this.f34171d);
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public boolean immediately() {
        return this.f34168a.isImmediate();
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public boolean isPseudoClass() {
        return this.f34172e;
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public boolean needRefresh() {
        return this.f34168a.needRefresh();
    }

    @Override // com.huawei.quickcard.framework.ui.RenderCommand
    public void setPseudoClass(boolean z10) {
        this.f34172e = z10;
    }
}
