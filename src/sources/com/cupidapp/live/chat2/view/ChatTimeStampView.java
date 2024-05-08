package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;

/* compiled from: ChatTimeStampView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTimeStampView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13452b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTimeStampView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13452b = new LinkedHashMap();
        a();
    }

    public final void a() {
        setGravity(17);
        setTextColor(-3750202);
        setTextSize(11.0f);
        int c4 = z0.h.c(this, 10.0f);
        setPadding(0, c4, 0, c4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(size, z0.h.c(this, 50.0f));
        }
    }

    public final void setTimeStamp(long j10) {
        setText(v.n(j10, getContext()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTimeStampView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13452b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTimeStampView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13452b = new LinkedHashMap();
        a();
    }
}
