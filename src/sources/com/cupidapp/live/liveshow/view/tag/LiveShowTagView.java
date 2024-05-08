package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: LiveShowTagView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowTagView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f15978d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f15979e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public LiveShowTagModel f15980b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15981c;

    /* compiled from: LiveShowTagView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return LiveShowTagView.f15979e;
        }
    }

    static {
        a aVar = new a(null);
        f15978d = aVar;
        f15979e = (h.l(aVar) - h.c(aVar, 24.0f)) / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15981c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15981c;
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(@org.jetbrains.annotations.NotNull com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r14, int r15) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.tag.LiveShowTagView.c(com.cupidapp.live.liveshow.view.tag.LiveShowTagModel, int):void");
    }

    public final void d() {
        z.a(this, R$layout.live_show_tag_view, true);
    }

    public final void e() {
        ((TextView) a(R$id.tag_content_textview)).setSelected(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15981c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15981c = new LinkedHashMap();
        d();
    }
}
