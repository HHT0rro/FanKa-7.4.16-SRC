package com.cupidapp.live.feed.layout;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: MapFloatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapFloatLayout$showMapFloatViewAnim$2 extends Lambda implements Function0<ValueAnimator> {
    public static final MapFloatLayout$showMapFloatViewAnim$2 INSTANCE = new MapFloatLayout$showMapFloatViewAnim$2();

    public MapFloatLayout$showMapFloatViewAnim$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValueAnimator invoke() {
        return ValueAnimator.ofFloat(1.0f, 0.0f);
    }
}
