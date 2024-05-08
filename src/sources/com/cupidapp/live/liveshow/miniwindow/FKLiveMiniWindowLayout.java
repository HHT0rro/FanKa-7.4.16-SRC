package com.cupidapp.live.liveshow.miniwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.event.CloseMiniWindowEvent;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveMiniWindowLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniWindowLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function3<? super Integer, ? super Integer, ? super Boolean, p> f15087b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<p> f15088c;

    /* renamed from: d, reason: collision with root package name */
    public int f15089d;

    /* renamed from: e, reason: collision with root package name */
    public int f15090e;

    /* renamed from: f, reason: collision with root package name */
    public int f15091f;

    /* renamed from: g, reason: collision with root package name */
    public int f15092g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15093h;

    /* compiled from: FKLiveMiniWindowLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15094a;

        static {
            int[] iArr = new int[FKLiveType.values().length];
            try {
                iArr[FKLiveType.CHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKLiveType.PK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKLiveType.MULTI_PK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FKLiveType.COMMON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f15094a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniWindowLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15093h = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15093h;
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

    public final void b() {
        List<String> c4 = FKLiveUtil.f14913a.c();
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        ((TextView) a(R$id.miniLiveShowClosedText)).setVisibility(8);
        ((ImageView) a(R$id.mute_mini_window_img)).setVisibility(0);
        d();
    }

    public final void c() {
        z.a(this, R$layout.layout_liveshow_mini_window, true);
        ((RoundedFrameLayout) a(R$id.mini_window_layout)).setCornerRadius(h.c(this, 4.0f));
        int i10 = R$id.mute_mini_window_img;
        ((ImageView) a(i10)).setSelected(true);
        View mini_window_blank_view = a(R$id.mini_window_blank_view);
        s.h(mini_window_blank_view, "mini_window_blank_view");
        y.d(mini_window_blank_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        ImageView mute_mini_window_img = (ImageView) a(i10);
        s.h(mute_mini_window_img, "mute_mini_window_img");
        y.d(mute_mini_window_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowLayout$initView$2
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
                FKLiveMiniWindowLayout fKLiveMiniWindowLayout = FKLiveMiniWindowLayout.this;
                int i11 = R$id.mute_mini_window_img;
                ((ImageView) fKLiveMiniWindowLayout.a(i11)).setSelected(!((ImageView) FKLiveMiniWindowLayout.this.a(i11)).isSelected());
                FKLiveUtil.f14913a.s(((ImageView) FKLiveMiniWindowLayout.this.a(i11)).isSelected());
                FKLiveMiniWindow.f15074m.a().Q(((ImageView) FKLiveMiniWindowLayout.this.a(i11)).isSelected());
            }
        });
        ImageView close_mini_window_img = (ImageView) a(R$id.close_mini_window_img);
        s.h(close_mini_window_img, "close_mini_window_img");
        y.d(close_mini_window_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowLayout$initView$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodClickClose, false, true, 2, null);
            }
        });
    }

    public final void d() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        String streamId = liveShowModel != null ? liveShowModel.getStreamId() : null;
        LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
        FKLiveType liveType = fkLiveShowResult != null ? fkLiveShowResult.getLiveType() : null;
        if (liveType == FKLiveType.COMMON) {
            View mini_window_bg_view = a(R$id.mini_window_bg_view);
            s.h(mini_window_bg_view, "mini_window_bg_view");
            y.n(mini_window_bg_view, Integer.valueOf(h.c(this, 112.0f)), Integer.valueOf(h.c(this, 160.0f)));
        } else {
            View mini_window_bg_view2 = a(R$id.mini_window_bg_view);
            s.h(mini_window_bg_view2, "mini_window_bg_view");
            y.n(mini_window_bg_view2, Integer.valueOf(h.c(this, 160.0f)), Integer.valueOf(h.c(this, 120.0f)));
        }
        int i10 = liveType == null ? -1 : a.f15094a[liveType.ordinal()];
        if (i10 == 1) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            TextureView left_texture = (TextureView) a(R$id.left_texture);
            s.h(left_texture, "left_texture");
            fKLiveUtil.M(streamId, left_texture);
            LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
            if (remoteConnectLiveShow != null) {
                int i11 = R$id.right_connect_layout;
                ((LiveMiniWindowConnectLayout) a(i11)).setVisibility(0);
                ((LiveMiniWindowConnectLayout) a(i11)).b(remoteConnectLiveShow, true);
                return;
            }
            ((LiveMiniWindowConnectLayout) a(R$id.right_connect_layout)).setVisibility(8);
            return;
        }
        if (i10 == 2) {
            FKLiveUtil fKLiveUtil2 = FKLiveUtil.f14913a;
            TextureView left_texture2 = (TextureView) a(R$id.left_texture);
            s.h(left_texture2, "left_texture");
            fKLiveUtil2.M(streamId, left_texture2);
            int i12 = R$id.right_connect_layout;
            ((LiveMiniWindowConnectLayout) a(i12)).setVisibility(0);
            ((LiveMiniWindowConnectLayout) a(i12)).c(true);
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            FKLiveUtil fKLiveUtil3 = FKLiveUtil.f14913a;
            TextureView left_texture3 = (TextureView) a(R$id.left_texture);
            s.h(left_texture3, "left_texture");
            fKLiveUtil3.M(streamId, left_texture3);
            return;
        }
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        String mixStreamId = liveShowModel2 != null ? liveShowModel2.getMixStreamId() : null;
        FKLiveUtil fKLiveUtil4 = FKLiveUtil.f14913a;
        TextureView left_texture4 = (TextureView) a(R$id.left_texture);
        s.h(left_texture4, "left_texture");
        fKLiveUtil4.M(mixStreamId, left_texture4);
    }

    public final void e() {
        ((TextView) a(R$id.miniLiveShowClosedText)).setVisibility(0);
        ((ImageView) a(R$id.mute_mini_window_img)).setVisibility(8);
    }

    public final void f(@NotNull FKLiveType liveType) {
        LiveShowModel pkLiveShow;
        String streamId;
        s.i(liveType, "liveType");
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        boolean z10 = true;
        if (liveShowModel != null && (streamId = liveShowModel.getStreamId()) != null) {
            FKLiveUtil.f14913a.G(kotlin.collections.s.o(streamId));
        }
        View mini_window_bg_view = a(R$id.mini_window_bg_view);
        s.h(mini_window_bg_view, "mini_window_bg_view");
        y.n(mini_window_bg_view, Integer.valueOf(h.c(this, 160.0f)), Integer.valueOf(h.c(this, 120.0f)));
        int i10 = a.f15094a[liveType.ordinal()];
        if (i10 == 1) {
            LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
            if (remoteConnectLiveShow != null) {
                int i11 = R$id.right_connect_layout;
                ((LiveMiniWindowConnectLayout) a(i11)).setVisibility(0);
                ((LiveMiniWindowConnectLayout) a(i11)).b(remoteConnectLiveShow, false);
                return;
            }
            return;
        }
        if (i10 == 2) {
            LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
            if (fkLiveShowResult != null && (pkLiveShow = fkLiveShowResult.getPkLiveShow()) != null) {
                r4 = pkLiveShow.getStreamId();
            }
            if (r4 != null && r4.length() != 0) {
                z10 = false;
            }
            if (z10) {
                return;
            }
            int i12 = R$id.right_connect_layout;
            ((LiveMiniWindowConnectLayout) a(i12)).setVisibility(0);
            ((LiveMiniWindowConnectLayout) a(i12)).c(false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel2 != null) {
            FKLiveUtil.J(FKLiveUtil.f14913a, liveShowModel2.getStreamId(), false, 2, null);
        }
        LiveShowModel liveShowModel3 = fKLiveConstantsData.getLiveShowModel();
        String mixStreamId = liveShowModel3 != null ? liveShowModel3.getMixStreamId() : null;
        if (mixStreamId != null && mixStreamId.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        FKLiveUtil.D(FKLiveUtil.f14913a, mixStreamId, (TextureView) a(R$id.left_texture), null, null, 12, null);
    }

    public final void g(@NotNull FKLiveType liveType) {
        LiveShowModel pkLiveShow;
        s.i(liveType, "liveType");
        View mini_window_bg_view = a(R$id.mini_window_bg_view);
        s.h(mini_window_bg_view, "mini_window_bg_view");
        y.n(mini_window_bg_view, Integer.valueOf(h.c(this, 112.0f)), Integer.valueOf(h.c(this, 160.0f)));
        int i10 = a.f15094a[liveType.ordinal()];
        if (i10 == 1) {
            LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
            FKLiveUtil.J(FKLiveUtil.f14913a, remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null, false, 2, null);
            ((LiveMiniWindowConnectLayout) a(R$id.right_connect_layout)).setVisibility(8);
            return;
        }
        if (i10 == 2) {
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            FKLiveUtil.J(FKLiveUtil.f14913a, (fkLiveShowResult == null || (pkLiveShow = fkLiveShowResult.getPkLiveShow()) == null) ? null : pkLiveShow.getStreamId(), false, 2, null);
            ((LiveMiniWindowConnectLayout) a(R$id.right_connect_layout)).setVisibility(8);
        } else {
            if (i10 != 3) {
                return;
            }
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
            String mixStreamId = liveShowModel != null ? liveShowModel.getMixStreamId() : null;
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            FKLiveUtil.J(fKLiveUtil, mixStreamId, false, 2, null);
            LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
            if (liveShowModel2 != null) {
                liveShowModel2.setMultiPkInfo(null);
                liveShowModel2.setMixStreamId(null);
                FKLiveUtil.D(fKLiveUtil, liveShowModel2.getStreamId(), (TextureView) a(R$id.left_texture), null, null, 12, null);
            }
        }
    }

    @Nullable
    public final Function0<p> getClickEvent() {
        return this.f15088c;
    }

    public final boolean getSoundState() {
        return ((ImageView) a(R$id.mute_mini_window_img)).isSelected();
    }

    @Nullable
    public final Function3<Integer, Integer, Boolean, p> getTouchEvent() {
        return this.f15087b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.c().l(new CloseMiniWindowEvent());
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f15089d = (int) motionEvent.getRawX();
            this.f15090e = (int) motionEvent.getRawY();
            this.f15091f = (int) motionEvent.getRawX();
            this.f15092g = (int) motionEvent.getRawY();
        } else {
            if (valueOf != null && valueOf.intValue() == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                Function3<? super Integer, ? super Integer, ? super Boolean, p> function3 = this.f15087b;
                if (function3 != null) {
                    function3.invoke(Integer.valueOf((int) (rawX - this.f15089d)), Integer.valueOf((int) (rawY - this.f15090e)), Boolean.FALSE);
                }
                this.f15089d = (int) rawX;
                this.f15090e = (int) rawY;
                return true;
            }
            if (valueOf != null && valueOf.intValue() == 1) {
                int c4 = h.c(this, 2.0f);
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                float f10 = c4;
                if (Math.abs(rawX2 - this.f15091f) < f10 && Math.abs(rawY2 - this.f15092g) < f10) {
                    Function0<p> function0 = this.f15088c;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    WindowManager.LayoutParams I = FKLiveMiniWindow.f15074m.a().I();
                    Integer valueOf2 = I != null ? Integer.valueOf(I.f816x) : null;
                    if (valueOf2 != null && Math.abs(valueOf2.intValue()) > (h.l(this) - getWidth()) / 2) {
                        Function3<? super Integer, ? super Integer, ? super Boolean, p> function32 = this.f15087b;
                        if (function32 == null) {
                            return true;
                        }
                        function32.invoke(Integer.valueOf(h.l(this) - getWidth()), null, Boolean.TRUE);
                        return true;
                    }
                    Function3<? super Integer, ? super Integer, ? super Boolean, p> function33 = this.f15087b;
                    if (function33 == null) {
                        return true;
                    }
                    function33.invoke(0, null, Boolean.TRUE);
                    return true;
                }
            }
        }
        return false;
    }

    public final void setClickEvent(@Nullable Function0<p> function0) {
        this.f15088c = function0;
    }

    public final void setSoundState(boolean z10) {
        ((ImageView) a(R$id.mute_mini_window_img)).setSelected(z10);
        FKLiveUtil.f14913a.s(z10);
    }

    public final void setTouchEvent(@Nullable Function3<? super Integer, ? super Integer, ? super Boolean, p> function3) {
        this.f15087b = function3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniWindowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15093h = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniWindowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15093h = new LinkedHashMap();
        c();
    }
}
