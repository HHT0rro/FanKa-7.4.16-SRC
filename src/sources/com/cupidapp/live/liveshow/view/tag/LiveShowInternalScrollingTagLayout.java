package com.cupidapp.live.liveshow.view.tag;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.liveshow.view.tag.LiveShowTagView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveShowInternalScrollingTagLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowInternalScrollingTagLayout extends BaseLiveShowScrollingTagLayout {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public LiveShowTagView f15963g;

    /* renamed from: h, reason: collision with root package name */
    public int f15964h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15965i;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowTagView f15966b;

        public a(LiveShowTagView liveShowTagView) {
            this.f15966b = liveShowTagView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            LiveShowTagView inView = this.f15966b;
            s.h(inView, "inView");
            this.f15966b.setVisibility(0);
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowTagView f15967b;

        public b(LiveShowTagView liveShowTagView) {
            this.f15967b = liveShowTagView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            LiveShowTagView outView = this.f15967b;
            s.h(outView, "outView");
            this.f15967b.setVisibility(4);
            this.f15967b.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowInternalScrollingTagLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15965i = new LinkedHashMap();
        p();
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    public void e(@NotNull List<LiveShowTagModel> tagList, int i10) {
        s.i(tagList, "tagList");
        super.e(tagList, i10);
        LiveShowTagModel liveShowTagModel = tagList.get(0);
        l(liveShowTagModel);
        m(liveShowTagModel, i10);
        q(tagList, i10);
        LiveShowTagView liveShowTagView = (LiveShowTagView) k(R$id.first_live_show_tag_view);
        liveShowTagView.c(liveShowTagModel, i10);
        this.f15963g = liveShowTagView;
        n(liveShowTagModel);
        o(liveShowTagModel);
        if (tagList.size() > 1) {
            h(i10);
        }
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    @NotNull
    public ObjectAnimator f(int i10, int i11) {
        LiveShowTagView liveShowTagView = (LiveShowTagView) k(i10 % 2 == 0 ? R$id.second_live_show_tag_view : R$id.first_live_show_tag_view);
        setCurrentPosition((getCurrentPosition() + 1) % getMTagList().size());
        LiveShowTagModel liveShowTagModel = getMTagList().get(getCurrentPosition());
        liveShowTagView.c(liveShowTagModel, i11);
        this.f15963g = liveShowTagView;
        n(liveShowTagModel);
        o(liveShowTagModel);
        ObjectAnimator initIntAnimator$lambda$9 = ObjectAnimator.ofFloat(liveShowTagView, (Property<LiveShowTagView, Float>) View.TRANSLATION_Y, h.c(this, 20.0f), 0.0f);
        initIntAnimator$lambda$9.setDuration(200L);
        s.h(initIntAnimator$lambda$9, "initIntAnimator$lambda$9");
        initIntAnimator$lambda$9.addListener(new a(liveShowTagView));
        s.h(initIntAnimator$lambda$9, "ofFloat(inView, View.TRA…e\n            }\n        }");
        return initIntAnimator$lambda$9;
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    @NotNull
    public ObjectAnimator g(int i10) {
        LiveShowTagView liveShowTagView = (LiveShowTagView) k(i10 % 2 == 0 ? R$id.first_live_show_tag_view : R$id.second_live_show_tag_view);
        ObjectAnimator initOutAnimator$lambda$6 = ObjectAnimator.ofFloat(liveShowTagView, (Property<LiveShowTagView, Float>) View.TRANSLATION_Y, 0.0f, -h.c(this, 20.0f));
        initOutAnimator$lambda$6.setDuration(200L);
        s.h(initOutAnimator$lambda$6, "initOutAnimator$lambda$6");
        initOutAnimator$lambda$6.addListener(new b(liveShowTagView));
        s.h(initOutAnimator$lambda$6, "ofFloat(outView, View.TR…)\n            }\n        }");
        return initOutAnimator$lambda$6;
    }

    @Nullable
    public View k(int i10) {
        Map<Integer, View> map = this.f15965i;
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

    public final void l(LiveShowTagModel liveShowTagModel) {
        List z02 = StringsKt__StringsKt.z0(liveShowTagModel.getBgColor(), new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(t.t(z02, 10));
        Iterator<E> iterator2 = z02.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(com.cupidapp.live.base.utils.h.a(com.cupidapp.live.base.utils.h.b((String) iterator2.next()), liveShowTagModel.getBgColorAlpha())));
        }
        String borderColor = liveShowTagModel.getBorderColor();
        Integer valueOf = borderColor != null ? Integer.valueOf(com.cupidapp.live.base.utils.h.b(borderColor)) : null;
        int style = liveShowTagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            int i10 = R$id.parallelogram_layout;
            ParallelogramLayout parallelogram_layout = (ParallelogramLayout) k(i10);
            s.h(parallelogram_layout, "parallelogram_layout");
            parallelogram_layout.setVisibility(0);
            View parallelogram_bg_view = k(R$id.parallelogram_bg_view);
            s.h(parallelogram_bg_view, "parallelogram_bg_view");
            y.i(parallelogram_bg_view, (r18 & 1) != 0 ? 0.0f : 0.0f, arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            if (valueOf != null) {
                ParallelogramLayout configBgColor$lambda$4 = (ParallelogramLayout) k(i10);
                s.h(configBgColor$lambda$4, "configBgColor$lambda$4");
                configBgColor$lambda$4.setStroke(h.c(configBgColor$lambda$4, 1.5f));
                configBgColor$lambda$4.setStrokeColor(valueOf.intValue());
            }
            ((ConstraintLayout) k(R$id.live_show_container_layout)).setBackground(null);
            return;
        }
        if (style == TagShape.RoundRectangle.getShape()) {
            ParallelogramLayout parallelogram_layout2 = (ParallelogramLayout) k(R$id.parallelogram_layout);
            s.h(parallelogram_layout2, "parallelogram_layout");
            parallelogram_layout2.setVisibility(8);
            ConstraintLayout live_show_container_layout = (ConstraintLayout) k(R$id.live_show_container_layout);
            s.h(live_show_container_layout, "live_show_container_layout");
            y.i(live_show_container_layout, (r18 & 1) != 0 ? 0.0f : h.c(this, 10.0f), arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(h.c(this, 1.5f)), (r18 & 16) != 0 ? null : valueOf, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        }
    }

    public final void m(LiveShowTagModel liveShowTagModel, int i10) {
        if (i10 == TagScrollingType.PartialScrolling.getType() && liveShowTagModel.getLeftIcon() != null) {
            int i11 = R$id.tag_imageview;
            ImageLoaderView tag_imageview = (ImageLoaderView) k(i11);
            s.h(tag_imageview, "tag_imageview");
            tag_imageview.setVisibility(0);
            int scaleWidthByHeight = liveShowTagModel.getLeftIcon().getScaleWidthByHeight(h.c(this, 16.0f));
            ImageLoaderView tag_imageview2 = (ImageLoaderView) k(i11);
            s.h(tag_imageview2, "tag_imageview");
            y.o(tag_imageview2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
            ImageLoaderView tag_imageview3 = (ImageLoaderView) k(i11);
            s.h(tag_imageview3, "tag_imageview");
            ImageLoaderView.g(tag_imageview3, liveShowTagModel.getLeftIcon(), null, null, 6, null);
            return;
        }
        ImageLoaderView tag_imageview4 = (ImageLoaderView) k(R$id.tag_imageview);
        s.h(tag_imageview4, "tag_imageview");
        tag_imageview4.setVisibility(8);
    }

    public final void n(LiveShowTagModel liveShowTagModel) {
        Integer num;
        String percentColor = liveShowTagModel.getPercentColor();
        if (percentColor != null) {
            int b4 = com.cupidapp.live.base.utils.h.b(percentColor);
            Float percentColorAlpha = liveShowTagModel.getPercentColorAlpha();
            num = Integer.valueOf(com.cupidapp.live.base.utils.h.a(b4, percentColorAlpha != null ? percentColorAlpha.floatValue() : 1.0f));
        } else {
            num = null;
        }
        if (num == null) {
            View parallelogram_progress_view = k(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view, "parallelogram_progress_view");
            parallelogram_progress_view.setVisibility(8);
            RoundedFrameLayout round_progress_layout = (RoundedFrameLayout) k(R$id.round_progress_layout);
            s.h(round_progress_layout, "round_progress_layout");
            round_progress_layout.setVisibility(8);
            return;
        }
        int style = liveShowTagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            int i10 = R$id.parallelogram_progress_view;
            View parallelogram_progress_view2 = k(i10);
            s.h(parallelogram_progress_view2, "parallelogram_progress_view");
            parallelogram_progress_view2.setVisibility(0);
            k(i10).setBackgroundColor(num.intValue());
            return;
        }
        if (style == TagShape.RoundRectangle.getShape()) {
            RoundedFrameLayout round_progress_layout2 = (RoundedFrameLayout) k(R$id.round_progress_layout);
            s.h(round_progress_layout2, "round_progress_layout");
            round_progress_layout2.setVisibility(0);
            k(R$id.round_progress_view).setBackgroundColor(num.intValue());
        }
    }

    public final void o(@NotNull LiveShowTagModel tagModel) {
        s.i(tagModel, "tagModel");
        Float percent = tagModel.getPercent();
        if (percent == null) {
            View parallelogram_progress_view = k(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view, "parallelogram_progress_view");
            parallelogram_progress_view.setVisibility(8);
            RoundedFrameLayout round_progress_layout = (RoundedFrameLayout) k(R$id.round_progress_layout);
            s.h(round_progress_layout, "round_progress_layout");
            round_progress_layout.setVisibility(8);
            return;
        }
        float floatValue = this.f15964h * percent.floatValue();
        int style = tagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            View parallelogram_progress_view2 = k(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view2, "parallelogram_progress_view");
            y.o(parallelogram_progress_view2, Integer.valueOf((int) floatValue), null, 2, null);
        } else if (style == TagShape.RoundRectangle.getShape()) {
            View round_progress_view = k(R$id.round_progress_view);
            s.h(round_progress_view, "round_progress_view");
            y.o(round_progress_view, Integer.valueOf((int) floatValue), null, 2, null);
            String borderColor = tagModel.getBorderColor();
            int c4 = borderColor == null || borderColor.length() == 0 ? 0 : h.c(this, 1.5f);
            RoundedFrameLayout round_progress_layout2 = (RoundedFrameLayout) k(R$id.round_progress_layout);
            s.h(round_progress_layout2, "round_progress_layout");
            y.l(round_progress_layout2, Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4));
        }
    }

    public final void p() {
        z.a(this, R$layout.layout_live_show_internal_scrolling_tag, true);
        ((RoundedFrameLayout) k(R$id.round_progress_layout)).setCornerRadius(h.c(this, 10.0f));
    }

    public final void q(List<LiveShowTagModel> list, int i10) {
        Iterator<LiveShowTagModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ((LiveShowTagView) k(R$id.second_live_show_tag_view)).c(iterator2.next(), i10);
            int i11 = R$id.live_show_container_layout;
            ((ConstraintLayout) k(i11)).measure(View.MeasureSpec.makeMeasureSpec(h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(h.k(this), Integer.MIN_VALUE));
            if (((ConstraintLayout) k(i11)).getMeasuredWidth() > this.f15964h) {
                this.f15964h = ((ConstraintLayout) k(i11)).getMeasuredWidth();
            }
        }
        int i12 = this.f15964h;
        LiveShowTagView.a aVar = LiveShowTagView.f15978d;
        if (i12 > aVar.a()) {
            this.f15964h = aVar.a();
        }
        ConstraintLayout live_show_container_layout = (ConstraintLayout) k(R$id.live_show_container_layout);
        s.h(live_show_container_layout, "live_show_container_layout");
        y.o(live_show_container_layout, Integer.valueOf(this.f15964h), null, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0042, code lost:
    
        if (kotlin.jvm.internal.s.d(r0.getBorderColor(), r2.getBorderColor()) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r(@org.jetbrains.annotations.NotNull java.util.List<com.cupidapp.live.liveshow.view.tag.LiveShowTagModel> r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "tagList"
            kotlin.jvm.internal.s.i(r8, r0)
            java.util.List r0 = r7.getMTagList()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r0 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r0
            java.lang.Object r2 = r8.get(r1)
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r2 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r2
            java.lang.String r3 = r0.getBgColor()
            java.lang.String r4 = r2.getBgColor()
            boolean r3 = kotlin.jvm.internal.s.d(r3, r4)
            r4 = 1
            if (r3 == 0) goto L44
            float r3 = r0.getBgColorAlpha()
            float r5 = r2.getBgColorAlpha()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L33
            r3 = 1
            goto L34
        L33:
            r3 = 0
        L34:
            if (r3 == 0) goto L44
            java.lang.String r3 = r0.getBorderColor()
            java.lang.String r5 = r2.getBorderColor()
            boolean r3 = kotlin.jvm.internal.s.d(r3, r5)
            if (r3 != 0) goto L47
        L44:
            r7.l(r2)
        L47:
            com.cupidapp.live.base.network.model.ImageModel r0 = r0.getLeftIcon()
            com.cupidapp.live.base.network.model.ImageModel r3 = r2.getLeftIcon()
            boolean r0 = kotlin.jvm.internal.s.d(r0, r3)
            if (r0 != 0) goto L58
            r7.m(r2, r9)
        L58:
            r7.q(r8, r9)
            java.util.List r0 = r7.getMTagList()
            int r2 = r7.getCurrentPosition()
            java.lang.Object r0 = r0.get(r2)
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r0 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r0
            int r2 = r8.size()
            if (r2 <= r4) goto L93
            java.util.Iterator r2 = r8.iterator2()
        L73:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L8f
            java.lang.Object r3 = r2.next()
            r5 = r3
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r5 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r5
            java.lang.String r5 = r5.getId()
            java.lang.String r6 = r0.getId()
            boolean r5 = kotlin.jvm.internal.s.d(r5, r6)
            if (r5 == 0) goto L73
            goto L90
        L8f:
            r3 = 0
        L90:
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r3 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r3
            goto L9a
        L93:
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.V(r8)
            r3 = r2
            com.cupidapp.live.liveshow.view.tag.LiveShowTagModel r3 = (com.cupidapp.live.liveshow.view.tag.LiveShowTagModel) r3
        L9a:
            if (r3 == 0) goto Lc5
            com.cupidapp.live.liveshow.view.tag.LiveShowTagView r2 = r7.f15963g
            if (r2 == 0) goto La3
            r2.c(r3, r9)
        La3:
            java.lang.String r2 = r0.getPercentColor()
            java.lang.String r5 = r3.getPercentColor()
            boolean r2 = kotlin.jvm.internal.s.d(r2, r5)
            if (r2 == 0) goto Lbf
            java.lang.Float r0 = r0.getPercentColorAlpha()
            java.lang.Float r2 = r3.getPercentColorAlpha()
            boolean r0 = kotlin.jvm.internal.s.c(r0, r2)
            if (r0 != 0) goto Lc2
        Lbf:
            r7.n(r3)
        Lc2:
            r7.o(r3)
        Lc5:
            int r0 = r8.size()
            if (r0 <= r4) goto Lcf
            r7.h(r9)
            goto Ld5
        Lcf:
            r7.setCurrentPosition(r1)
            r7.j()
        Ld5:
            java.util.List r9 = r7.getMTagList()
            r9.clear()
            java.util.List r9 = r7.getMTagList()
            r9.addAll(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.tag.LiveShowInternalScrollingTagLayout.r(java.util.List, int):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowInternalScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15965i = new LinkedHashMap();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowInternalScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15965i = new LinkedHashMap();
        p();
    }
}
