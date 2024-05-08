package com.cupidapp.live.liveshow.view.tag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ce.n;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.model.CardInfoModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: UserLiveShowRankLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserLiveShowRankLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public CardInfoModel f15992b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15993c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f15994d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15995e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15996f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final AnimatorSet f15997g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15998h;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
            UserLiveShowRankLayout.this.j();
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
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            if (UserLiveShowRankLayout.this.f15993c) {
                ConstraintLayout constraintLayout = (ConstraintLayout) UserLiveShowRankLayout.this.a(R$id.front_card);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(4);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) UserLiveShowRankLayout.this.a(R$id.back_card);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
            } else {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) UserLiveShowRankLayout.this.a(R$id.front_card);
                if (constraintLayout3 != null) {
                    constraintLayout3.setVisibility(0);
                }
                ConstraintLayout constraintLayout4 = (ConstraintLayout) UserLiveShowRankLayout.this.a(R$id.back_card);
                if (constraintLayout4 != null) {
                    constraintLayout4.setVisibility(4);
                }
            }
            UserLiveShowRankLayout.this.f15993c = !r4.f15993c;
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

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            UserLiveShowRankLayout.this.j();
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
    public UserLiveShowRankLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15998h = new LinkedHashMap();
        this.f15993c = true;
        this.f15995e = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, 0.0f, -90.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15996f = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateShowAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, -270.0f, -360.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15997g = new AnimatorSet();
        i();
    }

    private final ObjectAnimator getRotateAnim() {
        return (ObjectAnimator) this.f15995e.getValue();
    }

    private final ObjectAnimator getRotateShowAnim() {
        return (ObjectAnimator) this.f15996f.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15998h;
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
    public final AnimatorSet getAnimatorSet() {
        return this.f15997g;
    }

    public final void h(@NotNull CardInfoModel model, @Nullable String str, int i10) {
        s.i(model, "model");
        this.f15992b = model;
        this.f15994d = str;
        int b4 = h.b(model.getBackgroundColor());
        ImageLoaderView live_show_card_bg = (ImageLoaderView) a(R$id.live_show_card_bg);
        s.h(live_show_card_bg, "live_show_card_bg");
        y.i(live_show_card_bg, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 8.0f), r.e(Integer.valueOf(h.a(b4, 0.6f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ImageLoaderView live_show_rank_front_img = (ImageLoaderView) a(R$id.live_show_rank_front_img);
        s.h(live_show_rank_front_img, "live_show_rank_front_img");
        ImageLoaderView.g(live_show_rank_front_img, model.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.live_show_rank_front_title)).setText(model.getFrontTitle());
        int i11 = R$id.live_show_rank_front_con;
        ((TextView) a(i11)).setText(model.getFrontContent());
        TextView live_show_rank_front_con = (TextView) a(i11);
        s.h(live_show_rank_front_con, "live_show_rank_front_con");
        u.a(live_show_rank_front_con);
        ((TextView) a(R$id.live_show_rank_back_title)).setText(model.getBackTitle());
        int i12 = R$id.live_show_rank_back_con;
        ((TextView) a(i12)).setText(model.getBackContent());
        TextView live_show_rank_back_con = (TextView) a(i12);
        s.h(live_show_rank_back_con, "live_show_rank_back_con");
        u.a(live_show_rank_back_con);
        int i13 = R$id.live_show_rank_back_progress;
        View live_show_rank_back_progress = a(i13);
        s.h(live_show_rank_back_progress, "live_show_rank_back_progress");
        y.o(live_show_rank_back_progress, Integer.valueOf((int) ((n.d(model.getBackPercent() != null ? r1.intValue() : 0, 100) / 100.0d) * (i10 - z0.h.c(this, 4.0f)))), null, 2, null);
        View live_show_rank_back_progress2 = a(i13);
        s.h(live_show_rank_back_progress2, "live_show_rank_back_progress");
        y.i(live_show_rank_back_progress2, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 6.0f), r.e(Integer.valueOf(h.a(b4, 0.9f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    public final void i() {
        z.a(this, R$layout.layout_live_show_rank, true);
        RelativeLayout rank_root = (RelativeLayout) a(R$id.rank_root);
        s.h(rank_root, "rank_root");
        y.d(rank_root, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$initView$1
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
                String str;
                CardInfoModel cardInfoModel;
                CardInfoModel cardInfoModel2;
                CardInfoModel cardInfoModel3;
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                str = UserLiveShowRankLayout.this.f15994d;
                cardInfoModel = UserLiveShowRankLayout.this.f15992b;
                groupOthersLog.A(str, cardInfoModel != null ? cardInfoModel.getFrontTitle() : null);
                cardInfoModel2 = UserLiveShowRankLayout.this.f15992b;
                String backTitle = cardInfoModel2 != null ? cardInfoModel2.getBackTitle() : null;
                if (backTitle == null || backTitle.length() == 0) {
                    j.a aVar = j.f12156c;
                    Context context = UserLiveShowRankLayout.this.getContext();
                    cardInfoModel3 = UserLiveShowRankLayout.this.f15992b;
                    j.a.b(aVar, context, cardInfoModel3 != null ? cardInfoModel3.getFrontJumpUrl() : null, null, 4, null);
                    return;
                }
                UserLiveShowRankLayout.this.k();
            }
        });
    }

    public final void j() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R$id.rank_root);
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setEnabled(true);
    }

    public final void k() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R$id.rank_root);
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        this.f15997g.removeAllListeners();
        this.f15997g.cancel();
        getRotateAnim().removeAllListeners();
        getRotateAnim().addListener(new b());
        this.f15997g.playSequentially(getRotateAnim(), getRotateShowAnim());
        this.f15997g.start();
        this.f15997g.addListener(new a());
        this.f15997g.addListener(new c());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLiveShowRankLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15998h = new LinkedHashMap();
        this.f15993c = true;
        this.f15995e = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, 0.0f, -90.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15996f = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateShowAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, -270.0f, -360.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15997g = new AnimatorSet();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLiveShowRankLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15998h = new LinkedHashMap();
        this.f15993c = true;
        this.f15995e = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, 0.0f, -90.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15996f = kotlin.c.b(new Function0<ObjectAnimator>() { // from class: com.cupidapp.live.liveshow.view.tag.UserLiveShowRankLayout$rotateShowAnim$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((RelativeLayout) UserLiveShowRankLayout.this.a(R$id.rank_root), PropertyValuesHolder.ofFloat(View.ROTATION_X, -270.0f, -360.0f));
                ofPropertyValuesHolder.setDuration(200L);
                s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(r… duration = 200\n        }");
                return ofPropertyValuesHolder;
            }
        });
        this.f15997g = new AnimatorSet();
        i();
    }
}
