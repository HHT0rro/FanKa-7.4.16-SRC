package com.huawei.flexiblelayout.card.props;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DirectionProps {

    /* renamed from: a, reason: collision with root package name */
    private final int f27879a;

    /* renamed from: b, reason: collision with root package name */
    private final int f27880b;

    public DirectionProps(int i10, int i11) {
        this.f27879a = i10;
        this.f27880b = i11;
    }

    public int getLandscape() {
        return this.f27880b;
    }

    public int getPortrait() {
        return this.f27879a;
    }

    @NonNull
    public String toString() {
        return this.f27879a + "," + this.f27880b;
    }
}
