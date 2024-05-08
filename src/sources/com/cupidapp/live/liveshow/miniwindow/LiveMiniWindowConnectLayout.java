package com.cupidapp.live.liveshow.miniwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: LiveMiniWindowConnectLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveMiniWindowConnectLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15096b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMiniWindowConnectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15096b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15096b;
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

    public final void b(@NotNull LiveShowModel connectLive, boolean z10) {
        s.i(connectLive, "connectLive");
        if (LiveConnectType.Companion.a(connectLive.getLiveConnectType())) {
            ((TextureView) a(R$id.connect_texture)).setVisibility(8);
            ((Layer) a(R$id.connect_user_layer)).setVisibility(0);
            ImageLoaderView connect_user_avatar = (ImageLoaderView) a(R$id.connect_user_avatar);
            s.h(connect_user_avatar, "connect_user_avatar");
            ImageLoaderView.g(connect_user_avatar, connectLive.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) a(R$id.connect_user_name)).setText(connectLive.getUser().getName());
        } else {
            ((TextureView) a(R$id.connect_texture)).setVisibility(0);
            ((Layer) a(R$id.connect_user_layer)).setVisibility(8);
        }
        if (z10) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            String streamId = connectLive.getStreamId();
            TextureView connect_texture = (TextureView) a(R$id.connect_texture);
            s.h(connect_texture, "connect_texture");
            fKLiveUtil.M(streamId, connect_texture);
            return;
        }
        FKLiveUtil.D(FKLiveUtil.f14913a, connectLive.getStreamId(), (TextureView) a(R$id.connect_texture), null, null, 12, null);
    }

    public final void c(boolean z10) {
        LiveShowModel pkLiveShow;
        String streamId;
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult == null || (pkLiveShow = fkLiveShowResult.getPkLiveShow()) == null || (streamId = pkLiveShow.getStreamId()) == null) {
            return;
        }
        int i10 = R$id.connect_texture;
        ((TextureView) a(i10)).setVisibility(0);
        ((Layer) a(R$id.connect_user_layer)).setVisibility(8);
        if (z10) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            TextureView connect_texture = (TextureView) a(i10);
            s.h(connect_texture, "connect_texture");
            fKLiveUtil.M(streamId, connect_texture);
            return;
        }
        FKLiveUtil.D(FKLiveUtil.f14913a, streamId, (TextureView) a(i10), null, null, 12, null);
    }

    public final void d() {
        z.a(this, R$layout.layout_live_mini_window_connect, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMiniWindowConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15096b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMiniWindowConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15096b = new LinkedHashMap();
        d();
    }
}
