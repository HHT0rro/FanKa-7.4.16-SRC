package com.cupidapp.live.liveshow.view.tag;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: LiveShowOverallScrollingTagLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowOverallScrollingTagLayout extends BaseLiveShowScrollingTagLayout {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public LiveShowTagLayout f15968g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15969h;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowTagLayout f15970b;

        public a(LiveShowTagLayout liveShowTagLayout) {
            this.f15970b = liveShowTagLayout;
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
            LiveShowTagLayout inView = this.f15970b;
            s.h(inView, "inView");
            this.f15970b.setVisibility(0);
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowTagLayout f15971b;

        public b(LiveShowTagLayout liveShowTagLayout) {
            this.f15971b = liveShowTagLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            LiveShowTagLayout outView = this.f15971b;
            s.h(outView, "outView");
            this.f15971b.setVisibility(8);
            this.f15971b.g();
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
    public LiveShowOverallScrollingTagLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15969h = new LinkedHashMap();
        l();
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    public void e(@NotNull List<LiveShowTagModel> tagList, int i10) {
        s.i(tagList, "tagList");
        super.e(tagList, i10);
        LiveShowTagLayout liveShowTagLayout = (LiveShowTagLayout) k(R$id.first_tag_layout);
        liveShowTagLayout.c(tagList.get(0));
        this.f15968g = liveShowTagLayout;
        if (tagList.size() > 1) {
            h(TagScrollingType.OverallScrolling.getType());
        }
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    @NotNull
    public ObjectAnimator f(int i10, int i11) {
        LiveShowTagLayout liveShowTagLayout = (LiveShowTagLayout) k(i10 % 2 == 0 ? R$id.second_tag_layout : R$id.first_tag_layout);
        setCurrentPosition((getCurrentPosition() + 1) % getMTagList().size());
        liveShowTagLayout.c(getMTagList().get(getCurrentPosition()));
        this.f15968g = liveShowTagLayout;
        ObjectAnimator initIntAnimator$lambda$6 = ObjectAnimator.ofFloat(liveShowTagLayout, (Property<LiveShowTagLayout, Float>) View.TRANSLATION_Y, h.c(this, 20.0f), 0.0f);
        initIntAnimator$lambda$6.setDuration(200L);
        s.h(initIntAnimator$lambda$6, "initIntAnimator$lambda$6");
        initIntAnimator$lambda$6.addListener(new a(liveShowTagLayout));
        s.h(initIntAnimator$lambda$6, "ofFloat(inView, View.TRA…e\n            }\n        }");
        return initIntAnimator$lambda$6;
    }

    @Override // com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout
    @NotNull
    public ObjectAnimator g(int i10) {
        LiveShowTagLayout liveShowTagLayout = (LiveShowTagLayout) k(i10 % 2 == 0 ? R$id.first_tag_layout : R$id.second_tag_layout);
        ObjectAnimator initOutAnimator$lambda$3 = ObjectAnimator.ofFloat(liveShowTagLayout, (Property<LiveShowTagLayout, Float>) View.TRANSLATION_Y, 0.0f, -h.c(this, 20.0f));
        initOutAnimator$lambda$3.setDuration(200L);
        s.h(initOutAnimator$lambda$3, "initOutAnimator$lambda$3");
        initOutAnimator$lambda$3.addListener(new b(liveShowTagLayout));
        s.h(initOutAnimator$lambda$3, "ofFloat(outView, View.TR…)\n            }\n        }");
        return initOutAnimator$lambda$3;
    }

    @Nullable
    public View k(int i10) {
        Map<Integer, View> map = this.f15969h;
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

    public final void l() {
        z.a(this, R$layout.layout_live_show_overall_scrolling_tag, true);
    }

    public void m(@NotNull List<LiveShowTagModel> tagList, int i10) {
        LiveShowTagModel liveShowTagModel;
        LiveShowTagLayout liveShowTagLayout;
        LiveShowTagModel liveShowTagModel2;
        s.i(tagList, "tagList");
        LiveShowTagModel liveShowTagModel3 = getMTagList().get(getCurrentPosition());
        if (tagList.size() > 1) {
            Iterator<LiveShowTagModel> iterator2 = tagList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    liveShowTagModel2 = null;
                    break;
                } else {
                    liveShowTagModel2 = iterator2.next();
                    if (s.d(liveShowTagModel2.getId(), liveShowTagModel3.getId())) {
                        break;
                    }
                }
            }
            liveShowTagModel = liveShowTagModel2;
        } else {
            liveShowTagModel = (LiveShowTagModel) CollectionsKt___CollectionsKt.V(tagList);
        }
        if (liveShowTagModel != null && (liveShowTagLayout = this.f15968g) != null) {
            liveShowTagLayout.c(liveShowTagModel);
        }
        if (tagList.size() > 1) {
            h(TagScrollingType.OverallScrolling.getType());
        } else {
            setCurrentPosition(0);
            j();
        }
        getMTagList().clear();
        getMTagList().addAll(tagList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowOverallScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15969h = new LinkedHashMap();
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowOverallScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15969h = new LinkedHashMap();
        l();
    }
}
