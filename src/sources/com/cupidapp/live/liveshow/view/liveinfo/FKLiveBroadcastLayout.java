package com.cupidapp.live.liveshow.view.liveinfo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.grpc.LiveBroadcastModel;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import java.util.ArrayList;
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

/* compiled from: FKLiveBroadcastLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBroadcastLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<LiveBroadcastModel> f15706b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ValueAnimator f15707c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15708d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15709e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15710f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15711g;

    /* compiled from: FKLiveBroadcastLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveBroadcastLayout.this.f15706b.remove(0);
            FKLiveBroadcastLayout.this.setVisibility(8);
            FKLiveBroadcastLayout.this.j();
            if (!FKLiveBroadcastLayout.this.f15706b.isEmpty()) {
                FKLiveBroadcastLayout.this.h();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBroadcastLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15711g = new LinkedHashMap();
        this.f15706b = new ArrayList();
        this.f15708d = h.c(this, 37.0f);
        this.f15709e = h.c(this, 75.0f);
        this.f15710f = h.c(this, 10.0f);
        g();
    }

    public static final void i(FKLiveBroadcastLayout this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        ((HorizontalScrollView) this$0.b(R$id.horizontalScrollContainer)).scrollTo(num != null ? num.intValue() : 0, 0);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15711g;
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

    public final void e(@NotNull LiveBroadcastModel broadcastModel) {
        s.i(broadcastModel, "broadcastModel");
        this.f15706b.add(broadcastModel);
        h();
    }

    public final void f(LiveBroadcastModel liveBroadcastModel) {
        if (liveBroadcastModel == null) {
            return;
        }
        setVisibility(0);
        ((TextView) b(R$id.liveBroadcastTextView)).setText(liveBroadcastModel.getMessage());
        String s2 = LaunchDownloader.f11925a.s(liveBroadcastModel.getDecoration());
        if (s2 == null || s2.length() == 0) {
            return;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(s2);
        int height = (this.f15709e * decodeFile.getHeight()) / this.f15708d;
        int height2 = (this.f15710f * decodeFile.getHeight()) / this.f15708d;
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, height, decodeFile.getHeight());
        Bitmap createBitmap2 = Bitmap.createBitmap(decodeFile, height, 0, 1, decodeFile.getHeight());
        Bitmap createBitmap3 = Bitmap.createBitmap(decodeFile, decodeFile.getWidth() - height2, 0, height2, decodeFile.getHeight());
        int i10 = R$id.broadcastStartBackgroundImage;
        ((ImageView) b(i10)).setImageBitmap(createBitmap);
        ((ImageView) b(R$id.broadcastCenterBackgroundImage)).setImageBitmap(createBitmap2);
        int i11 = R$id.broadcastEndBackgroundImage;
        ((ImageView) b(i11)).setImageBitmap(createBitmap3);
        ((ImageView) b(i10)).getLayoutParams().width = this.f15709e;
        ((ImageView) b(i11)).getLayoutParams().width = this.f15710f;
    }

    public final void g() {
        z.a(this, R$layout.layout_live_broadcast, true);
        b(R$id.startBlankView).getLayoutParams().width = h.l(this);
        b(R$id.endBlankView).getLayoutParams().width = h.l(this);
        setVisibility(8);
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f15707c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        f((LiveBroadcastModel) CollectionsKt___CollectionsKt.V(this.f15706b));
        j();
        int i10 = R$id.broadContentContainerLayout;
        ((RelativeLayout) b(i10)).measure(View.MeasureSpec.makeMeasureSpec(h.l(this), 0), View.MeasureSpec.makeMeasureSpec(h.k(this), Integer.MIN_VALUE));
        int l10 = h.l(this) + ((RelativeLayout) b(i10)).getMeasuredWidth();
        ((HorizontalScrollView) b(R$id.horizontalScrollContainer)).scrollTo(0, 0);
        ValueAnimator ofInt = ValueAnimator.ofInt(l10);
        ofInt.setDuration((long) (l10 / 0.3d));
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.liveinfo.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FKLiveBroadcastLayout.i(FKLiveBroadcastLayout.this, valueAnimator2);
            }
        });
        ofInt.addListener(new a());
        this.f15707c = ofInt;
        ofInt.start();
    }

    public final void j() {
        ValueAnimator valueAnimator = this.f15707c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f15707c = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBroadcastLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15711g = new LinkedHashMap();
        this.f15706b = new ArrayList();
        this.f15708d = h.c(this, 37.0f);
        this.f15709e = h.c(this, 75.0f);
        this.f15710f = h.c(this, 10.0f);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBroadcastLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15711g = new LinkedHashMap();
        this.f15706b = new ArrayList();
        this.f15708d = h.c(this, 37.0f);
        this.f15709e = h.c(this, 75.0f);
        this.f15710f = h.c(this, 10.0f);
        g();
    }
}
