package com.huawei.quickcard;

import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.views.text.span.Span;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Span {

    /* renamed from: u, reason: collision with root package name */
    private int f33258u = ResourceUtils.getColor("#0A59F7");

    /* renamed from: v, reason: collision with root package name */
    private boolean f33259v = false;

    public boolean a() {
        return this.f33259v;
    }

    @Override // com.huawei.quickcard.views.text.span.Span, com.huawei.quickcard.framework.IVirtualView
    public String getName() {
        return "a";
    }

    @Override // com.huawei.quickcard.views.text.span.Span, com.huawei.quickcard.views.text.view.IQuickText
    public Integer getTextColor() {
        return Integer.valueOf(this.f33258u);
    }

    @Override // com.huawei.quickcard.views.text.span.Span, com.huawei.quickcard.views.text.view.IQuickText
    public void setTextColor(int i10) {
        this.f33258u = i10;
    }

    public void a(boolean z10) {
        this.f33259v = z10;
    }
}
