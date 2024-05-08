package com.cupidapp.live.liveshow.view.horn;

import android.content.Context;
import android.net.Uri;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.FKLiveHornLinkModel;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.LiveHornStyle;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: FKLiveHornLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveHornLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15676b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveHornLayout(@NotNull Context context, @NotNull FKLiveHornModel liveHornLinkResult) {
        super(context);
        s.i(context, "context");
        s.i(liveHornLinkResult, "liveHornLinkResult");
        this.f15676b = new LinkedHashMap();
        i(liveHornLinkResult);
    }

    public static final void h(FKLiveHornLayout this$0) {
        s.i(this$0, "this$0");
        int i10 = R$id.liveHornTextView;
        ((TextView) this$0.b(i10)).setSelected(true);
        ((TextView) this$0.b(i10)).setFocusable(true);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15676b;
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

    public final FKLiveHornLinkModel f(FKLiveHornModel fKLiveHornModel) {
        if (getContext() instanceof MainActivity) {
            return fKLiveHornModel.getLiveOuter();
        }
        return fKLiveHornModel.getLiveInner();
    }

    public final void g(final FKLiveHornModel fKLiveHornModel) {
        CharacterStyle underlineSpan;
        int i10 = R$id.liveHornTextView;
        ((TextView) b(i10)).setTextSize(1, 12.0f);
        ((TextView) b(i10)).setMarqueeRepeatLimit(fKLiveHornModel.getLoopCount());
        ((TextView) b(i10)).postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.horn.b
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveHornLayout.h(FKLiveHornLayout.this);
            }
        }, 1000L);
        FKLiveHornLinkModel f10 = f(fKLiveHornModel);
        if ((f10 != null ? f10.getLinkDict() : null) != null && (!f10.getLinkDict().isEmpty())) {
            String content = fKLiveHornModel.getContent();
            for (final Map.Entry<String, String> entry : f10.getLinkDict().entrySet()) {
                int i11 = R$id.liveHornTextView;
                TextView liveHornTextView = (TextView) b(i11);
                s.h(liveHornTextView, "liveHornTextView");
                y.d(liveHornTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.horn.FKLiveHornLayout$initLiveHornRuleTextView$2$1
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
                        FKLiveHornLayout.this.j(entry.getValue());
                        FKLiveHornLayout.this.k(fKLiveHornModel);
                    }
                });
                if (s.d(fKLiveHornModel.getStyle(), LiveHornStyle.Lucky.getValue())) {
                    underlineSpan = new ForegroundColorSpan(-5306);
                } else {
                    underlineSpan = new UnderlineSpan();
                }
                ((TextView) b(i11)).setText(t.n(content, underlineSpan, new String[]{entry.getKey()}, false, 4, null));
            }
            return;
        }
        ((TextView) b(i10)).setText(fKLiveHornModel.getContent());
    }

    public final void i(final FKLiveHornModel fKLiveHornModel) {
        int type = fKLiveHornModel.getType();
        FKHornType fKHornType = FKHornType.BigHornType;
        if (type == fKHornType.getHornType()) {
            z.a(this, R$layout.layout_live_big_horn, true);
        } else {
            z.a(this, R$layout.layout_live_small_horn, true);
        }
        String style = fKLiveHornModel.getStyle();
        if (s.d(style, LiveHornStyle.Common.getValue())) {
            if (fKLiveHornModel.getType() == fKHornType.getHornType()) {
                ConstraintLayout live_horn_container_layout = (ConstraintLayout) b(R$id.live_horn_container_layout);
                s.h(live_horn_container_layout, "live_horn_container_layout");
                y.n(live_horn_container_layout, Integer.valueOf(h.c(this, 330.0f)), Integer.valueOf(h.c(this, 33.0f)));
            } else {
                ConstraintLayout live_horn_container_layout2 = (ConstraintLayout) b(R$id.live_horn_container_layout);
                s.h(live_horn_container_layout2, "live_horn_container_layout");
                y.n(live_horn_container_layout2, Integer.valueOf(h.c(this, 260.0f)), Integer.valueOf(h.c(this, 24.0f)));
            }
        } else if (s.d(style, LiveHornStyle.Lucky.getValue())) {
            ConstraintLayout live_horn_container_layout3 = (ConstraintLayout) b(R$id.live_horn_container_layout);
            s.h(live_horn_container_layout3, "live_horn_container_layout");
            y.n(live_horn_container_layout3, Integer.valueOf(h.c(this, 336.0f)), Integer.valueOf(h.c(this, 64.0f)));
        }
        g(fKLiveHornModel);
        int i10 = R$id.liveHornBackGround;
        ImageLoaderView liveHornBackGround = (ImageLoaderView) b(i10);
        s.h(liveHornBackGround, "liveHornBackGround");
        ImageLoaderView.f(liveHornBackGround, new com.cupidapp.live.base.imageloader.b(false, fKLiveHornModel.getBackgroundUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        ImageLoaderView liveHornBackGround2 = (ImageLoaderView) b(i10);
        s.h(liveHornBackGround2, "liveHornBackGround");
        y.d(liveHornBackGround2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.horn.FKLiveHornLayout$initView$1
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
                FKLiveHornLinkModel f10;
                String jump;
                f10 = FKLiveHornLayout.this.f(fKLiveHornModel);
                if (f10 == null || (jump = f10.getJump()) == null) {
                    return;
                }
                FKLiveHornLayout.this.j(jump);
                FKLiveHornLayout.this.k(fKLiveHornModel);
            }
        });
    }

    public final void j(String str) {
        Uri parse = Uri.parse(str);
        if (s.d(parse.getHost(), "live")) {
            if (getContext() instanceof FKLiveForStreamerBeautyActivity) {
                return;
            }
            if (getContext() instanceof FKLiveForViewerActivity) {
                String path = parse.getPath();
                String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (s.d(A, liveShowModel != null ? liveShowModel.getItemId() : null)) {
                    return;
                }
            }
        }
        j.a.b(j.f12156c, getContext(), str, null, 4, null);
    }

    public final void k(FKLiveHornModel fKLiveHornModel) {
        if (fKLiveHornModel.getType() == FKHornType.BigHornType.getHornType()) {
            SensorsLogLiveShow.f12212a.j(String.valueOf(fKLiveHornModel.getHornCode()), fKLiveHornModel.getScene());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveHornLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15676b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveHornLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15676b = new LinkedHashMap();
    }
}
