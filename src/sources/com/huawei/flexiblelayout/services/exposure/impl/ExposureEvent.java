package com.huawei.flexiblelayout.services.exposure.impl;

import android.view.View;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureEvent implements FrameEvent {

    /* renamed from: a, reason: collision with root package name */
    public FLayout f28550a;

    /* renamed from: b, reason: collision with root package name */
    public FLCell<?> f28551b;

    /* renamed from: c, reason: collision with root package name */
    public View f28552c;

    /* renamed from: d, reason: collision with root package name */
    public FLCardData f28553d;

    /* renamed from: e, reason: collision with root package name */
    @ExposureEventType
    public int f28554e;

    /* renamed from: f, reason: collision with root package name */
    @ExposureParam.ExposureMode
    public String f28555f;

    public void assign(FLayout fLayout, FLCell<?> fLCell, @ExposureEventType int i10, @ExposureParam.ExposureMode String str) {
        this.f28550a = fLayout;
        this.f28551b = fLCell;
        this.f28552c = fLCell != null ? fLCell.getRootView() : null;
        this.f28553d = fLCell != null ? (FLCardData) fLCell.getData() : null;
        this.f28554e = i10;
        this.f28555f = str;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FrameEvent
    public int identifier() {
        return Objects.hash(this.f28550a, this.f28553d);
    }

    @Override // com.huawei.flexiblelayout.services.exposure.reusable.ReusableObject
    public void reset() {
        assign(null, null, 0, "default");
    }
}
