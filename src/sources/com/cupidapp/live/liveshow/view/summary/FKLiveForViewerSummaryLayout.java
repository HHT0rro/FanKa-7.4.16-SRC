package com.cupidapp.live.liveshow.view.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveForViewerSummaryLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerSummaryLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15946b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerSummaryLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15946b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15946b;
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

    public final void b(@NotNull final Function0<p> callback) {
        s.i(callback, "callback");
        ImageView closeLiveShowImage = (ImageView) a(R$id.closeLiveShowImage);
        s.h(closeLiveShowImage, "closeLiveShowImage");
        y.d(closeLiveShowImage, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveForViewerSummaryLayout$configCloseLiveShowClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                callback.invoke();
            }
        });
    }

    public final void c(int i10) {
        setVisibility(0);
        ((TextView) a(R$id.liveStatePromptTextView)).setText(getContext().getString(i10));
    }

    public final void d() {
        z.a(this, R$layout.layout_live_for_viewer_summary, true);
        Context context = getContext();
        s.h(context, "context");
        ImageView closeLiveShowImage = (ImageView) a(R$id.closeLiveShowImage);
        s.h(closeLiveShowImage, "closeLiveShowImage");
        com.cupidapp.live.base.view.s.b(context, closeLiveShowImage);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerSummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15946b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerSummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15946b = new LinkedHashMap();
        d();
    }
}
