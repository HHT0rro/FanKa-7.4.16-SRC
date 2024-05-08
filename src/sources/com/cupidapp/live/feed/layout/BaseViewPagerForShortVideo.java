package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseViewPagerForShortVideo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseViewPagerForShortVideo extends ViewPager {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14428h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static boolean f14429i = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14430b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14431c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function2<? super Integer, ? super Integer, Boolean> f14432d;

    /* renamed from: e, reason: collision with root package name */
    public int f14433e;

    /* renamed from: f, reason: collision with root package name */
    public int f14434f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14435g;

    /* compiled from: BaseViewPagerForShortVideo.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z10) {
            BaseViewPagerForShortVideo.f14429i = z10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerForShortVideo(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14435g = new LinkedHashMap();
        this.f14430b = true;
    }

    @Nullable
    public final Function2<Integer, Integer, Boolean> getCanScrollCheck() {
        return this.f14432d;
    }

    public final boolean getShouldIntercept() {
        return this.f14431c;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = com.cupidapp.live.feed.layout.BaseViewPagerForShortVideo.f14429i
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, java.lang.Boolean> r0 = r7.f14432d
            r2 = 1
            if (r0 == 0) goto L32
            r3 = 0
            if (r8 == 0) goto L18
            float r4 = r8.getX()
            int r4 = (int) r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L19
        L18:
            r4 = r3
        L19:
            if (r8 == 0) goto L24
            float r3 = r8.getY()
            int r3 = (int) r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L24:
            java.lang.Object r0 = r0.mo1743invoke(r4, r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            if (r0 == 0) goto L36
            return r1
        L36:
            boolean r0 = r7.f14431c     // Catch: java.lang.IllegalArgumentException -> L46
            if (r0 != 0) goto L3f
            boolean r8 = super.onInterceptTouchEvent(r8)     // Catch: java.lang.IllegalArgumentException -> L46
            return r8
        L3f:
            boolean r0 = super.onInterceptTouchEvent(r8)     // Catch: java.lang.IllegalArgumentException -> L46
            r7.f14430b = r0     // Catch: java.lang.IllegalArgumentException -> L46
            goto L4a
        L46:
            r0 = move-exception
            r0.printStackTrace()
        L4a:
            if (r8 == 0) goto L8a
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r8 = r8.getAction()
            if (r8 == 0) goto L82
            r3 = 2
            if (r8 == r3) goto L60
            goto L86
        L60:
            int r8 = r7.f14433e
            int r8 = r0 - r8
            int r4 = r7.f14434f
            int r4 = r1 - r4
            if (r8 <= 0) goto L86
            int r5 = java.lang.Math.abs(r8)
            int r6 = java.lang.Math.abs(r4)
            if (r5 <= r6) goto L86
            int r8 = java.lang.Math.abs(r8)
            int r4 = java.lang.Math.abs(r4)
            int r8 = r8 - r4
            if (r8 <= r3) goto L86
            r7.f14430b = r2
            goto L86
        L82:
            r7.f14433e = r0
            r7.f14434f = r1
        L86:
            r7.f14433e = r0
            r7.f14434f = r1
        L8a:
            boolean r8 = r7.f14430b
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.BaseViewPagerForShortVideo.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = com.cupidapp.live.feed.layout.BaseViewPagerForShortVideo.f14429i
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, java.lang.Boolean> r0 = r4.f14432d
            if (r0 == 0) goto L31
            r2 = 0
            if (r5 == 0) goto L17
            float r3 = r5.getX()
            int r3 = (int) r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L18
        L17:
            r3 = r2
        L18:
            if (r5 == 0) goto L23
            float r2 = r5.getY()
            int r2 = (int) r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L23:
            java.lang.Object r0 = r0.mo1743invoke(r3, r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L31
            r0 = 1
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L35
            return r1
        L35:
            boolean r0 = r4.f14431c
            if (r0 != 0) goto L3e
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L3e:
            super.onTouchEvent(r5)
            boolean r5 = r4.f14430b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.BaseViewPagerForShortVideo.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setCanScrollCheck(@Nullable Function2<? super Integer, ? super Integer, Boolean> function2) {
        this.f14432d = function2;
    }

    public final void setShouldIntercept(boolean z10) {
        this.f14431c = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerForShortVideo(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14435g = new LinkedHashMap();
        this.f14430b = true;
    }
}
