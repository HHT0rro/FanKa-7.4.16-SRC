package com.huawei.flexiblelayout.data;

import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IndicatorCardData extends FLCardData {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    @JsonPacked(Attributes.Style.INTERVAL)
    private Integer f28090a;

    public IndicatorCardData(String str) {
        super(str);
    }

    @Nullable
    public Integer a() {
        return this.f28090a;
    }

    public void a(@Nullable Integer num) {
        this.f28090a = num;
    }
}
