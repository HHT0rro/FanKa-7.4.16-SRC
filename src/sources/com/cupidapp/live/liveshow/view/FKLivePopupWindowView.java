package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.LivePopupWindowModel;
import com.cupidapp.live.base.router.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLivePopupWindowView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePopupWindowView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f15258b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15259c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePopupWindowView(@NotNull Context context, @NotNull LivePopupWindowModel livePopupWindow) {
        super(context);
        s.i(context, "context");
        s.i(livePopupWindow, "livePopupWindow");
        this.f15259c = new LinkedHashMap();
        b(livePopupWindow);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15259c;
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

    public final void b(final LivePopupWindowModel livePopupWindowModel) {
        z.a(this, R$layout.layout_live_popup_window_view, true);
        int i10 = R$id.livePopupWindowImageView;
        ((ImageLoaderView) a(i10)).getLayoutParams().height = livePopupWindowModel.getImage().getScaleHeightByWidth(z0.h.l(this));
        ImageLoaderView livePopupWindowImageView = (ImageLoaderView) a(i10);
        s.h(livePopupWindowImageView, "livePopupWindowImageView");
        ImageLoaderView.g(livePopupWindowImageView, livePopupWindowModel.getImage(), null, null, 6, null);
        ImageLoaderView livePopupWindowImageView2 = (ImageLoaderView) a(i10);
        s.h(livePopupWindowImageView2, "livePopupWindowImageView");
        y.d(livePopupWindowImageView2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLivePopupWindowView$initView$1
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, FKLivePopupWindowView.this.getContext(), livePopupWindowModel.getUrl(), null, 4, null);
                Function0<p> closeLivePopupWindowView = FKLivePopupWindowView.this.getCloseLivePopupWindowView();
                if (closeLivePopupWindowView != null) {
                    closeLivePopupWindowView.invoke();
                }
            }
        });
        RelativeLayout livePopupWindowContainerLayout = (RelativeLayout) a(R$id.livePopupWindowContainerLayout);
        s.h(livePopupWindowContainerLayout, "livePopupWindowContainerLayout");
        y.d(livePopupWindowContainerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLivePopupWindowView$initView$2
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
                Function0<p> closeLivePopupWindowView = FKLivePopupWindowView.this.getCloseLivePopupWindowView();
                if (closeLivePopupWindowView != null) {
                    closeLivePopupWindowView.invoke();
                }
            }
        });
        ImageView closeAlertImgView = (ImageView) a(R$id.closeAlertImgView);
        s.h(closeAlertImgView, "closeAlertImgView");
        y.d(closeAlertImgView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLivePopupWindowView$initView$3
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
                Function0<p> closeLivePopupWindowView = FKLivePopupWindowView.this.getCloseLivePopupWindowView();
                if (closeLivePopupWindowView != null) {
                    closeLivePopupWindowView.invoke();
                }
            }
        });
    }

    @Nullable
    public final Function0<p> getCloseLivePopupWindowView() {
        return this.f15258b;
    }

    public final void setCloseLivePopupWindowView(@Nullable Function0<p> function0) {
        this.f15258b = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePopupWindowView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15259c = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePopupWindowView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15259c = new LinkedHashMap();
    }
}
