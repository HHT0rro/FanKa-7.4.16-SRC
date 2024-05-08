package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NestingRecyclerView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NestingRecyclerView extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    public int f12546b;

    /* renamed from: c, reason: collision with root package name */
    public float f12547c;

    /* renamed from: d, reason: collision with root package name */
    public float f12548d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12549e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestingRecyclerView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12549e = new LinkedHashMap();
        this.f12546b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f12547c = motionEvent.getX();
            this.f12548d = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            float abs = Math.abs(x10 - this.f12547c);
            float abs2 = Math.abs(y10 - this.f12548d);
            if (abs > this.f12546b && abs > abs2) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestingRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12549e = new LinkedHashMap();
        this.f12546b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
