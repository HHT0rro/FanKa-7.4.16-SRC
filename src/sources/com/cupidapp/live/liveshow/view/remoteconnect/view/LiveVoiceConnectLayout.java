package com.cupidapp.live.liveshow.view.remoteconnect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
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

/* compiled from: LiveVoiceConnectLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveVoiceConnectLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f15887d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15888e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVoiceConnectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15888e = new LinkedHashMap();
        h();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15888e;
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

    public final void g(@NotNull LiveShowModel connectLive, boolean z10) {
        s.i(connectLive, "connectLive");
        setVisibility(0);
        ImageLoaderView voice_connect_avatar_imageview = (ImageLoaderView) e(R$id.voice_connect_avatar_imageview);
        s.h(voice_connect_avatar_imageview, "voice_connect_avatar_imageview");
        ImageLoaderView.g(voice_connect_avatar_imageview, connectLive.getUser().getAvatarImage(), null, null, 6, null);
        ((TextView) e(R$id.voice_connect_name_textview)).setText(connectLive.getUser().getName());
        ImageView close_voice_connect_imageview = (ImageView) e(R$id.close_voice_connect_imageview);
        s.h(close_voice_connect_imageview, "close_voice_connect_imageview");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean z11 = true;
        if (!(liveShowModel != null && liveShowModel.getMine()) && !z10) {
            z11 = false;
        }
        close_voice_connect_imageview.setVisibility(z11 ? 0 : 8);
    }

    public final void h() {
        z.a(this, R$layout.layout_live_voice_connect, true);
        setVisibility(8);
        ImageView close_voice_connect_imageview = (ImageView) e(R$id.close_voice_connect_imageview);
        s.h(close_voice_connect_imageview, "close_voice_connect_imageview");
        y.d(close_voice_connect_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveVoiceConnectLayout$initView$1
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
                aVar = LiveVoiceConnectLayout.this.f15887d;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveVoiceConnectLayout$initView$2
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
                aVar = LiveVoiceConnectLayout.this.f15887d;
                if (aVar != null) {
                    aVar.c();
                }
            }
        });
    }

    public final void i() {
        int i10 = R$id.voice_connect_animation_imageview;
        if (((FKSVGAImageView) e(i10)).k()) {
            return;
        }
        ((FKSVGAImageView) e(i10)).s();
    }

    public final void j() {
        int i10 = R$id.voice_connect_animation_imageview;
        if (((FKSVGAImageView) e(i10)).k()) {
            ((FKSVGAImageView) e(i10)).K();
        }
    }

    public final void setConnectListener(@NotNull a connectListener) {
        s.i(connectListener, "connectListener");
        this.f15887d = connectListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVoiceConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15888e = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVoiceConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15888e = new LinkedHashMap();
        h();
    }
}
