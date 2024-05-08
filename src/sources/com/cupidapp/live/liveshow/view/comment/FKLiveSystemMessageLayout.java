package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.adapter.FKLiveSystemMessageViewModel;
import com.cupidapp.live.liveshow.view.label.LiveLabelListView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveSystemMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSystemMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15379b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKLiveSystemMessageViewModel f15380c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15381d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSystemMessageLayout(@NotNull Context context, boolean z10) {
        super(context);
        s.i(context, "context");
        this.f15381d = new LinkedHashMap();
        c(z10);
    }

    public static /* synthetic */ void d(FKLiveSystemMessageLayout fKLiveSystemMessageLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        fKLiveSystemMessageLayout.c(z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15381d;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(FKLiveSystemMessageViewModel fKLiveSystemMessageViewModel) {
        if (fKLiveSystemMessageViewModel == null) {
            return;
        }
        LiveLabelListView system_message_label_view = (LiveLabelListView) a(R$id.system_message_label_view);
        s.h(system_message_label_view, "system_message_label_view");
        LiveLabelListView.o(system_message_label_view, fKLiveSystemMessageViewModel.getLabelList(), i0.h(kotlin.f.a(fKLiveSystemMessageViewModel.getSystemMessage(), -2302756)), 11.0f, 0, this.f15379b, 8, null);
    }

    public final void c(boolean z10) {
        this.f15379b = z10;
        z.a(this, R$layout.layout_system_message, true);
    }

    @Nullable
    public final FKLiveSystemMessageViewModel getSystemMessageModel() {
        return this.f15380c;
    }

    public final void setSystemMessageModel(@Nullable FKLiveSystemMessageViewModel fKLiveSystemMessageViewModel) {
        this.f15380c = fKLiveSystemMessageViewModel;
        b(fKLiveSystemMessageViewModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSystemMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15381d = new LinkedHashMap();
        d(this, false, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSystemMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15381d = new LinkedHashMap();
        d(this, false, 1, null);
    }
}
