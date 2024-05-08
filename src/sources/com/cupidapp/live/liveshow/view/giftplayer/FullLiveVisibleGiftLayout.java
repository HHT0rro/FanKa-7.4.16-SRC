package com.cupidapp.live.liveshow.view.giftplayer;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.c;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.model.FullLiveVisibleGiftModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipUtils;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FullLiveVisibleGiftLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FullLiveVisibleGiftLayout extends FrameLayout implements DefaultLifecycleObserver {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f15635h = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public int f15636b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<FullLiveVisibleGiftModel> f15637c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15638d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<SkyGiftLayout> f15639e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public CountDownTimer f15640f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15641g;

    /* compiled from: FullLiveVisibleGiftLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FullLiveVisibleGiftLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends CountDownTimer {
        public b() {
            super(ZipUtils.UPPER_UNIXTIME_BOUND, 400L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            FullLiveVisibleGiftLayout.this.f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullLiveVisibleGiftLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15641g = new LinkedHashMap();
        this.f15637c = new ArrayList();
        this.f15639e = new ArrayList();
    }

    public final void d(@Nullable FullLiveVisibleGiftModel fullLiveVisibleGiftModel) {
        if (fullLiveVisibleGiftModel == null) {
            return;
        }
        j();
        this.f15637c.add(fullLiveVisibleGiftModel);
    }

    public final void e() {
        int i10 = this.f15636b - 1;
        this.f15636b = i10;
        if (i10 == 0) {
            this.f15638d = false;
            setBackgroundResource(0);
            h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.giftplayer.FullLiveVisibleGiftLayout.f():void");
    }

    public final void g(@Nullable LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    public final void h() {
        k();
        Iterator<SkyGiftLayout> iterator2 = this.f15639e.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().h();
        }
        this.f15639e.clear();
        removeAllViews();
    }

    public final void i() {
        List<SkyGiftLayout> list = this.f15639e;
        ArrayList arrayList = new ArrayList();
        for (SkyGiftLayout skyGiftLayout : list) {
            if (skyGiftLayout.getShowBgAnimation()) {
                arrayList.add(skyGiftLayout);
            }
        }
        if (arrayList.isEmpty()) {
            View childAt = getChildAt(0);
            FKSVGAImageView fKSVGAImageView = childAt instanceof FKSVGAImageView ? (FKSVGAImageView) childAt : null;
            if (fKSVGAImageView != null) {
                removeView(fKSVGAImageView);
            }
        }
    }

    public final void j() {
        if (this.f15640f != null) {
            return;
        }
        k();
        this.f15640f = new b().start();
    }

    public final void k() {
        CountDownTimer countDownTimer = this.f15640f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f15640f = null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        c.b(this, owner);
        h();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        c.f(this, lifecycleOwner);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullLiveVisibleGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15641g = new LinkedHashMap();
        this.f15637c = new ArrayList();
        this.f15639e = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullLiveVisibleGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15641g = new LinkedHashMap();
        this.f15637c = new ArrayList();
        this.f15639e = new ArrayList();
    }
}
