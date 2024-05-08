package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ConsultViewerLiveEndLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerLiveEndLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13872d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13873e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultViewerLiveEndLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13873e = new LinkedHashMap();
        m();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13873e;
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

    public final void i(@NotNull final Function0<p> closeCallback) {
        s.i(closeCallback, "closeCallback");
        ImageView consult_viewer_live_end_close_img = (ImageView) e(R$id.consult_viewer_live_end_close_img);
        s.h(consult_viewer_live_end_close_img, "consult_viewer_live_end_close_img");
        y.d(consult_viewer_live_end_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout$bindClickEvent$1
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
                closeCallback.invoke();
            }
        });
    }

    public final void j(boolean z10) {
        if (z10) {
            int i10 = R$id.consult_viewer_live_end_go_follow_btn;
            ((TextView) e(i10)).setText(R$string.has_followed);
            ((TextView) e(i10)).setTextColor(-5658199);
            ((TextView) e(i10)).setBackgroundResource(R$drawable.rect_cor_100_sd_dddddd);
            return;
        }
        int i11 = R$id.consult_viewer_live_end_go_follow_btn;
        ((TextView) e(i11)).setText(R$string.go_to_follow);
        ((TextView) e(i11)).setTextColor(-1);
        ((TextView) e(i11)).setBackgroundResource(R$drawable.rect_cor_100_sd_ff4040);
    }

    public final void k() {
        com.cupidapp.live.base.fragment.b.f11807a.b();
        setVisibility(0);
        ((TextView) e(R$id.consult_viewer_cannot_watch_live_text)).setVisibility(0);
        ((ConstraintLayout) e(R$id.consult_viewer_live_end_parent_layout)).setVisibility(8);
    }

    public final void l(@NotNull final ConsultLiveModel model) {
        s.i(model, "model");
        com.cupidapp.live.base.fragment.b.f11807a.b();
        setVisibility(0);
        ((ConstraintLayout) e(R$id.consult_viewer_live_end_parent_layout)).setVisibility(0);
        ((TextView) e(R$id.consult_viewer_cannot_watch_live_text)).setVisibility(8);
        if (model.getCategoryIcon() == null) {
            ((ImageLoaderView) e(R$id.consult_viewer_live_end_category_img)).setVisibility(8);
        } else {
            int i10 = R$id.consult_viewer_live_end_category_img;
            ((ImageLoaderView) e(i10)).setVisibility(0);
            int scaleWidthByHeight = model.getCategoryIcon().getScaleWidthByHeight(h.c(this, 16.0f));
            ImageLoaderView consult_viewer_live_end_category_img = (ImageLoaderView) e(i10);
            s.h(consult_viewer_live_end_category_img, "consult_viewer_live_end_category_img");
            y.o(consult_viewer_live_end_category_img, Integer.valueOf(scaleWidthByHeight), null, 2, null);
            ImageLoaderView consult_viewer_live_end_category_img2 = (ImageLoaderView) e(i10);
            s.h(consult_viewer_live_end_category_img2, "consult_viewer_live_end_category_img");
            ImageLoaderView.g(consult_viewer_live_end_category_img2, model.getCategoryIcon(), null, null, 6, null);
        }
        ((TextView) e(R$id.consult_viewer_live_end_title_img)).setText(model.getTitle());
        ImageLoaderView consult_viewer_live_end_cover_img = (ImageLoaderView) e(R$id.consult_viewer_live_end_cover_img);
        s.h(consult_viewer_live_end_cover_img, "consult_viewer_live_end_cover_img");
        ImageLoaderView.g(consult_viewer_live_end_cover_img, model.getCover(), null, null, 6, null);
        ImageLoaderView consult_viewer_live_end_anchor_avatar_img = (ImageLoaderView) e(R$id.consult_viewer_live_end_anchor_avatar_img);
        s.h(consult_viewer_live_end_anchor_avatar_img, "consult_viewer_live_end_anchor_avatar_img");
        ImageLoaderView.g(consult_viewer_live_end_anchor_avatar_img, model.getUser().getAvatarImage(), null, null, 6, null);
        ((TextView) e(R$id.consult_viewer_live_end_anchor_name_img)).setText(model.getUser().getName());
        ImageLoaderView consult_viewer_live_end_anchor_level_img = (ImageLoaderView) e(R$id.consult_viewer_live_end_anchor_level_img);
        s.h(consult_viewer_live_end_anchor_level_img, "consult_viewer_live_end_anchor_level_img");
        ImageLoaderView.g(consult_viewer_live_end_anchor_level_img, model.getLevelIcon(), null, null, 6, null);
        j(model.getUser().getAloha());
        TextView consult_viewer_live_end_go_follow_btn = (TextView) e(R$id.consult_viewer_live_end_go_follow_btn);
        s.h(consult_viewer_live_end_go_follow_btn, "consult_viewer_live_end_go_follow_btn");
        y.d(consult_viewer_live_end_go_follow_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout$configViewerLiveEndData$1
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
                boolean z10;
                if (ConsultLiveModel.this.getUser().getAloha()) {
                    return;
                }
                z10 = this.f13872d;
                if (z10) {
                    return;
                }
                this.f13872d = true;
                Observable o10 = a.C0836a.o(NetworkClient.f11868a.N(), ConsultLiveModel.this.getUser().userId(), null, null, ViewProfilePrefer.VoiceRoom.getValue(), 0, null, null, ConsultLiveModel.this.getId(), 118, null);
                final ConsultViewerLiveEndLayout consultViewerLiveEndLayout = this;
                final ConsultLiveModel consultLiveModel = ConsultLiveModel.this;
                Disposable disposed = o10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout$configViewerLiveEndData$1$invoke$$inlined$handle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        m2541invoke(swipeCardUserLikeResult);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2541invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        ConsultLiveModel.this.getUser().setAloha(true);
                        consultViewerLiveEndLayout.j(ConsultLiveModel.this.getUser().getAloha());
                        consultViewerLiveEndLayout.f13872d = false;
                        GroupSocialLog.f18708a.B(true, SensorScene.CONSULT_LIVE.getValue(), ConsultLiveModel.this.getUser().userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : null, (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout$configViewerLiveEndData$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        s.i(it, "it");
                        ConsultViewerLiveEndLayout.this.f13872d = false;
                        return Boolean.FALSE;
                    }
                }, consultViewerLiveEndLayout)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (consultViewerLiveEndLayout != null) {
                        consultViewerLiveEndLayout.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
    }

    public final void m() {
        z.a(this, R$layout.layout_consult_viewer_live_end, true);
        Context context = getContext();
        s.h(context, "context");
        ImageView consult_viewer_live_end_close_img = (ImageView) e(R$id.consult_viewer_live_end_close_img);
        s.h(consult_viewer_live_end_close_img, "consult_viewer_live_end_close_img");
        com.cupidapp.live.base.view.s.b(context, consult_viewer_live_end_close_img);
        ConstraintLayout consult_viewer_live_end_root_layout = (ConstraintLayout) e(R$id.consult_viewer_live_end_root_layout);
        s.h(consult_viewer_live_end_root_layout, "consult_viewer_live_end_root_layout");
        y.d(consult_viewer_live_end_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultViewerLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13873e = new LinkedHashMap();
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultViewerLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13873e = new LinkedHashMap();
        m();
    }
}
