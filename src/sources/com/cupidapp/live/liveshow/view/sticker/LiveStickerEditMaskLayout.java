package com.cupidapp.live.liveshow.view.sticker;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.drag.FKBaseDragLayout;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveStickerViewInfoModel;
import com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveStickerEditMaskLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerEditMaskLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f15914d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public LiveStickerViewInfoModel f15915e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15916f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15917g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerEditMaskLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15917g = new LinkedHashMap();
        this.f15916f = true;
        x();
    }

    public static final void B(final LiveStickerEditMaskLayout this$0, String str, LiveStickerViewInfoModel liveStickerViewInfoModel, final String str2) {
        s.i(this$0, "this$0");
        Pair<Double, Double> stickerScaleValue = this$0.getStickerScaleValue();
        Disposable disposed = NetworkClient.f11868a.r().v(str, liveStickerViewInfoModel.getId(), str2, stickerScaleValue.getFirst().doubleValue(), stickerScaleValue.getSecond().doubleValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout$updateStickerInfo$lambda$4$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ((LiveStickerLayout) LiveStickerEditMaskLayout.this.i(R$id.live_text_sticker_layout)).n(str2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this$0)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            this$0.H(disposed);
        }
        s.h(disposed, "disposed");
    }

    private final Pair<Double, Double> getStickerScaleValue() {
        View i10 = i(R$id.sticker_edit_mask_center_view);
        int width = i10.getWidth();
        int height = i10.getHeight();
        LiveStickerLayout liveStickerLayout = (LiveStickerLayout) i(R$id.live_text_sticker_layout);
        int width2 = liveStickerLayout.getWidth();
        int height2 = liveStickerLayout.getHeight();
        return new Pair<>(Double.valueOf(liveStickerLayout.getX() / (width - width2)), Double.valueOf((liveStickerLayout.getY() - i10.getY()) / (height - height2)));
    }

    public static final void s(LiveStickerEditMaskLayout this$0) {
        s.i(this$0, "this$0");
        if (this$0.f15916f) {
            this$0.setVisibility(0);
        }
    }

    public static final void t(LiveStickerEditMaskLayout this$0) {
        s.i(this$0, "this$0");
        View i10 = this$0.i(R$id.sticker_edit_mask_top_view);
        Rect rect = new Rect(i10.getLeft(), i10.getTop(), i10.getRight(), i10.getBottom());
        ConstraintLayout constraintLayout = (ConstraintLayout) this$0.i(R$id.sticker_edit_mask_parent_layout);
        Rect rect2 = new Rect(constraintLayout.getLeft(), constraintLayout.getTop(), constraintLayout.getRight(), constraintLayout.getBottom());
        LiveStickerLayout live_text_sticker_layout = (LiveStickerLayout) this$0.i(R$id.live_text_sticker_layout);
        s.h(live_text_sticker_layout, "live_text_sticker_layout");
        this$0.v(rect, rect2, live_text_sticker_layout);
    }

    public static final void z(LiveStickerEditMaskLayout this$0, double d10, double d11) {
        s.i(this$0, "this$0");
        View i10 = this$0.i(R$id.sticker_edit_mask_center_view);
        int width = i10.getWidth();
        int height = i10.getHeight();
        LiveStickerLayout liveStickerLayout = (LiveStickerLayout) this$0.i(R$id.live_text_sticker_layout);
        float height2 = ((float) ((height - liveStickerLayout.getHeight()) * d11)) + i10.getY();
        liveStickerLayout.setX((float) ((width - liveStickerLayout.getWidth()) * d10));
        liveStickerLayout.setY(height2);
    }

    public final void A() {
        final LiveStickerViewInfoModel liveStickerViewInfoModel = this.f15915e;
        final String str = this.f15914d;
        int i10 = R$id.live_text_sticker_layout;
        final String textStickerContent = ((LiveStickerLayout) i(i10)).getTextStickerContent();
        if (str == null || str.length() == 0) {
            return;
        }
        if ((liveStickerViewInfoModel != null ? liveStickerViewInfoModel.getId() : null) != null) {
            String id2 = liveStickerViewInfoModel.getId();
            if (id2 == null || id2.length() == 0) {
                return;
            }
            if (textStickerContent == null || textStickerContent.length() == 0) {
                return;
            }
            ((LiveStickerLayout) i(i10)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.sticker.d
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStickerEditMaskLayout.B(LiveStickerEditMaskLayout.this, str, liveStickerViewInfoModel, textStickerContent);
                }
            });
        }
    }

    @Nullable
    public View i(int i10) {
        Map<Integer, View> map = this.f15917g;
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

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull LiveSelectedStickerEvent event) {
        s.i(event, "event");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.e(liveShowModel.getItemId(), liveShowModel.getUser().userId(), event.getModel().getId());
        }
        event.getModel().setDefaultTipContent(event.getModel().getContent());
        event.getModel().setContent(null);
        r(false, event.getModel());
    }

    public final boolean p(LiveStickerViewInfoModel liveStickerViewInfoModel) {
        if (liveStickerViewInfoModel != null) {
            String id2 = liveStickerViewInfoModel.getId();
            if (!(id2 == null || id2.length() == 0)) {
                String imageUrl = liveStickerViewInfoModel.getImageUrl();
                if (!(imageUrl == null || imageUrl.length() == 0) && liveStickerViewInfoModel.getType() != null && liveStickerViewInfoModel.getWidth() != null && liveStickerViewInfoModel.getHeight() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void q(boolean z10) {
        int i10 = z10 ? 0 : 4;
        i(R$id.sticker_edit_mask_top_view).setVisibility(i10);
        ((TextView) i(R$id.sticker_edit_mask_del_text)).setVisibility(i10);
        i(R$id.sticker_edit_mask_center_view).setVisibility(i10);
        i(R$id.sticker_edit_mask_bottom_view).setVisibility(i10);
    }

    public final void r(boolean z10, @Nullable LiveStickerViewInfoModel liveStickerViewInfoModel) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        this.f15914d = liveShowModel != null ? liveShowModel.getItemId() : null;
        this.f15915e = liveStickerViewInfoModel;
        if (liveStickerViewInfoModel != null && !p(liveStickerViewInfoModel)) {
            setVisibility(4);
            q(false);
            ((LiveStickerLayout) i(R$id.live_text_sticker_layout)).l(liveStickerViewInfoModel);
            Double xval = liveStickerViewInfoModel.getXval();
            double doubleValue = xval != null ? xval.doubleValue() : 0.5d;
            Double yval = liveStickerViewInfoModel.getYval();
            y(doubleValue, yval != null ? yval.doubleValue() : 0.3d);
            postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.sticker.b
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStickerEditMaskLayout.s(LiveStickerEditMaskLayout.this);
                }
            }, 100L);
            if (z10) {
                return;
            }
            i(R$id.sticker_edit_mask_top_view).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.sticker.a
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStickerEditMaskLayout.t(LiveStickerEditMaskLayout.this);
                }
            });
            return;
        }
        setVisibility(8);
    }

    public final void setCanDisplaySticker(boolean z10) {
        this.f15916f = z10;
        setVisibility((!z10 || this.f15915e == null) ? 8 : 0);
    }

    public final void u() {
        String str = this.f15914d;
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().n0(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout$deleteSticker$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                LiveStickerEditMaskLayout.this.f15915e = null;
                LiveStickerEditMaskLayout.this.setVisibility(8);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void v(Rect rect, Rect rect2, FKBaseDragLayout fKBaseDragLayout) {
        final TextView textView = (TextView) i(R$id.sticker_edit_mask_del_text);
        fKBaseDragLayout.setListener(rect, rect2, false, new r1.a() { // from class: com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout$handleStickerDragAndClickEvent$1
            @Override // r1.a
            public void a() {
                LiveStickerEditMaskLayout.this.q(true);
            }

            @Override // r1.a
            public void b() {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 1.0f, 1.3f)).with(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 1.0f, 1.3f));
                animatorSet.setDuration(200L);
                animatorSet.start();
            }

            @Override // r1.a
            public void c(boolean z10) {
                LiveStickerViewInfoModel liveStickerViewInfoModel;
                if (z10) {
                    LiveStickerEditMaskLayout.this.A();
                    LiveStickerEditMaskLayout.this.q(false);
                    return;
                }
                LiveStickerLayout liveStickerLayout = (LiveStickerLayout) LiveStickerEditMaskLayout.this.i(R$id.live_text_sticker_layout);
                liveStickerViewInfoModel = LiveStickerEditMaskLayout.this.f15915e;
                Integer type = liveStickerViewInfoModel != null ? liveStickerViewInfoModel.getType() : null;
                final LiveStickerEditMaskLayout liveStickerEditMaskLayout = LiveStickerEditMaskLayout.this;
                liveStickerLayout.r(type, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout$handleStickerDragAndClickEvent$1$fingerUp$1
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
                        LiveStickerEditMaskLayout.this.A();
                    }
                });
            }

            @Override // r1.a
            public void d() {
                ((LiveStickerLayout) LiveStickerEditMaskLayout.this.i(R$id.live_text_sticker_layout)).k();
                LiveStickerEditMaskLayout.this.u();
            }

            @Override // r1.a
            public void e() {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 1.3f, 1.0f));
                animatorSet.setDuration(200L);
                animatorSet.start();
            }
        });
    }

    public final void w() {
        ((LiveStickerLayout) i(R$id.live_text_sticker_layout)).f(false);
    }

    public final void x() {
        z.a(this, R$layout.layout_live_sticker_edit_mask, true);
        setVisibility(8);
        View sticker_edit_mask_bottom_view = i(R$id.sticker_edit_mask_bottom_view);
        s.h(sticker_edit_mask_bottom_view, "sticker_edit_mask_bottom_view");
        y.o(sticker_edit_mask_bottom_view, null, Integer.valueOf(FKLiveCommentLayout.f15357f.a() + h.c(this, 60.0f)), 1, null);
    }

    public final void y(final double d10, final double d11) {
        ((LiveStickerLayout) i(R$id.live_text_sticker_layout)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.sticker.c
            @Override // java.lang.Runnable
            public final void run() {
                LiveStickerEditMaskLayout.z(LiveStickerEditMaskLayout.this, d10, d11);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerEditMaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15917g = new LinkedHashMap();
        this.f15916f = true;
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerEditMaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15917g = new LinkedHashMap();
        this.f15916f = true;
        x();
    }
}
