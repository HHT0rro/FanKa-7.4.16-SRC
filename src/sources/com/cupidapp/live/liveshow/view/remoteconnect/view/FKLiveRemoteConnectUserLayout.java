package com.cupidapp.live.liveshow.view.remoteconnect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveRemoteConnectUserLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveRemoteConnectUserLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f15866d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15867e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15868f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveRemoteConnectUserLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15868f = new LinkedHashMap();
        this.f15867e = c.b(FKLiveRemoteConnectUserLayout$countDownTimer$2.INSTANCE);
        j();
    }

    private final i getCountDownTimer() {
        return (i) this.f15867e.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15868f;
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

    @NotNull
    public final View getTextureView() {
        TextureView connectTexture = (TextureView) e(R$id.connectTexture);
        s.h(connectTexture, "connectTexture");
        return connectTexture;
    }

    public final void h(@NotNull LiveShowModel connectLive, boolean z10, boolean z11) {
        s.i(connectLive, "connectLive");
        setVisibility(0);
        boolean z12 = true;
        if (z10) {
            int i10 = R$id.timerContainerLayout;
            RelativeLayout timerContainerLayout = (RelativeLayout) e(i10);
            s.h(timerContainerLayout, "timerContainerLayout");
            timerContainerLayout.setVisibility(0);
            ImageLoaderView connectUserAvatarImage = (ImageLoaderView) e(R$id.connectUserAvatarImage);
            s.h(connectUserAvatarImage, "connectUserAvatarImage");
            ImageLoaderView.g(connectUserAvatarImage, connectLive.getUser().getAvatarImage(), null, null, 6, null);
            ((RelativeLayout) e(i10)).setAlpha(1.0f);
            ((ImageView) e(R$id.closeConnectImage)).setEnabled(false);
            getCountDownTimer().g();
            getCountDownTimer().c(5, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.FKLiveRemoteConnectUserLayout$configConnectLayout$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveRemoteConnectUserLayout.this.i();
                    ((ImageView) FKLiveRemoteConnectUserLayout.this.e(R$id.closeConnectImage)).setEnabled(true);
                }
            }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.FKLiveRemoteConnectUserLayout$configConnectLayout$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i11) {
                    ((TextView) FKLiveRemoteConnectUserLayout.this.e(R$id.timerCountDownText)).setText(String.valueOf(i11));
                }
            });
        } else {
            RelativeLayout timerContainerLayout2 = (RelativeLayout) e(R$id.timerContainerLayout);
            s.h(timerContainerLayout2, "timerContainerLayout");
            timerContainerLayout2.setVisibility(8);
        }
        ImageView closeConnectImage = (ImageView) e(R$id.closeConnectImage);
        s.h(closeConnectImage, "closeConnectImage");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (!(liveShowModel != null && liveShowModel.getMine()) && !z11) {
            z12 = false;
        }
        closeConnectImage.setVisibility(z12 ? 0 : 8);
        ((TextView) e(R$id.connectUserName)).setText(connectLive.getUser().getName());
    }

    public final void i() {
        ((RelativeLayout) e(R$id.timerContainerLayout)).animate().alpha(0.0f).setDuration(300L).start();
    }

    public final void j() {
        z.a(this, R$layout.layout_live_remote_connect_user, true);
        setVisibility(8);
        int i10 = R$id.connectTextureContainerLayout;
        ((RoundedFrameLayout) e(i10)).setCornerRadius(h.c(this, 4.0f));
        ImageView closeConnectImage = (ImageView) e(R$id.closeConnectImage);
        s.h(closeConnectImage, "closeConnectImage");
        y.d(closeConnectImage, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.FKLiveRemoteConnectUserLayout$initView$1
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
                a aVar;
                aVar = FKLiveRemoteConnectUserLayout.this.f15866d;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        RoundedFrameLayout connectTextureContainerLayout = (RoundedFrameLayout) e(i10);
        s.h(connectTextureContainerLayout, "connectTextureContainerLayout");
        y.d(connectTextureContainerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.FKLiveRemoteConnectUserLayout$initView$2
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
                a aVar;
                aVar = FKLiveRemoteConnectUserLayout.this.f15866d;
                if (aVar != null) {
                    aVar.c();
                }
            }
        });
    }

    public final void setConnectListener(@NotNull a connectListener) {
        s.i(connectListener, "connectListener");
        this.f15866d = connectListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveRemoteConnectUserLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15868f = new LinkedHashMap();
        this.f15867e = c.b(FKLiveRemoteConnectUserLayout$countDownTimer$2.INSTANCE);
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveRemoteConnectUserLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15868f = new LinkedHashMap();
        this.f15867e = c.b(FKLiveRemoteConnectUserLayout$countDownTimer$2.INSTANCE);
        j();
    }
}
