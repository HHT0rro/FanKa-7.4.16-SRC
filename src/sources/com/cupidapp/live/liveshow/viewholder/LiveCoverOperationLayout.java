package com.cupidapp.live.liveshow.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKRecommendLiveListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveCoverOperationLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f16055b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super Boolean, p> f16056c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16057d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCoverOperationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16057d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16057d;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        ScrollView live_data_scrollview = (ScrollView) a(R$id.live_data_scrollview);
        s.h(live_data_scrollview, "live_data_scrollview");
        if (live_data_scrollview.getVisibility() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(@Nullable String str, boolean z10, @NotNull Function1<? super Boolean, p> clickCallback) {
        s.i(clickCallback, "clickCallback");
        if (str == null || str.length() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f16056c = clickCallback;
        this.f16055b = z10;
        ScrollView live_data_scrollview = (ScrollView) a(R$id.live_data_scrollview);
        s.h(live_data_scrollview, "live_data_scrollview");
        live_data_scrollview.setVisibility(z10 ? 0 : 8);
        ((TextView) a(R$id.live_data_textview)).setText(str);
    }

    public final void f() {
        z.a(this, R$layout.layout_live_cover_operation, true);
        setVisibility(8);
        ImageView show_data_btn = (ImageView) a(R$id.show_data_btn);
        s.h(show_data_btn, "show_data_btn");
        y.d(show_data_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.viewholder.LiveCoverOperationLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                boolean z10;
                boolean z11;
                Function1 function1;
                boolean z12;
                ScrollView live_data_scrollview = (ScrollView) LiveCoverOperationLayout.this.a(R$id.live_data_scrollview);
                s.h(live_data_scrollview, "live_data_scrollview");
                z10 = LiveCoverOperationLayout.this.f16055b;
                live_data_scrollview.setVisibility(z10 ^ true ? 0 : 8);
                LiveCoverOperationLayout liveCoverOperationLayout = LiveCoverOperationLayout.this;
                z11 = liveCoverOperationLayout.f16055b;
                liveCoverOperationLayout.f16055b = !z11;
                function1 = LiveCoverOperationLayout.this.f16056c;
                if (function1 != null) {
                    z12 = LiveCoverOperationLayout.this.f16055b;
                    function1.invoke(Boolean.valueOf(z12));
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCoverOperationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16057d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCoverOperationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16057d = new LinkedHashMap();
        f();
    }
}
