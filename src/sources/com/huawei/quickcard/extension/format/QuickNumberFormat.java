package com.huawei.quickcard.extension.format;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.text.NumberFormat;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickNumberFormat implements IQuickNumberFormat {

    /* renamed from: a, reason: collision with root package name */
    private final NumberFormat f33646a;

    public QuickNumberFormat(@NonNull NumberFormat numberFormat) {
        this.f33646a = numberFormat;
    }

    @Override // com.huawei.quickcard.extension.format.IQuickNumberFormat
    public String format(long j10) {
        return this.f33646a.format(j10);
    }

    @Override // com.huawei.quickcard.extension.format.IQuickNumberFormat
    public String format(double d10) {
        return this.f33646a.format(d10);
    }
}
