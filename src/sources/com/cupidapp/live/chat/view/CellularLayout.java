package com.cupidapp.live.chat.view;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import ce.n;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ImageSizeConstants;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: CellularLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CellularLayout extends ConstraintLayout {

    @NotNull
    public static final b D = new b(null);

    @Nullable
    public a A;

    @Nullable
    public User B;

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: b, reason: collision with root package name */
    public final int f13187b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13188c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13189d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13190e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13191f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<CellularModel> f13192g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<CellularModel> f13193h;

    /* renamed from: i, reason: collision with root package name */
    public final int f13194i;

    /* renamed from: j, reason: collision with root package name */
    public final int f13195j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13196k;

    /* renamed from: l, reason: collision with root package name */
    public final int f13197l;

    /* renamed from: m, reason: collision with root package name */
    public final int f13198m;

    /* renamed from: n, reason: collision with root package name */
    public final int f13199n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13200o;

    /* renamed from: p, reason: collision with root package name */
    public final int f13201p;

    /* renamed from: q, reason: collision with root package name */
    public final int f13202q;

    /* renamed from: r, reason: collision with root package name */
    public int f13203r;

    /* renamed from: s, reason: collision with root package name */
    public int f13204s;

    /* renamed from: t, reason: collision with root package name */
    public int f13205t;

    /* renamed from: u, reason: collision with root package name */
    public int f13206u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Map<Integer, Float> f13207v;

    /* renamed from: w, reason: collision with root package name */
    public final int f13208w;

    /* renamed from: x, reason: collision with root package name */
    @IdRes
    public int f13209x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13210y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public ValueAnimator f13211z;

    /* compiled from: CellularLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum AreaType {
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM,
        LEFT_TOP
    }

    /* compiled from: CellularLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(@NotNull User user);

        void b(@NotNull User user);

        void c();

        void d(@NotNull ImageLoaderView imageLoaderView);
    }

    /* compiled from: CellularLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CellularLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13212a;

        static {
            int[] iArr = new int[AreaType.values().length];
            try {
                iArr[AreaType.RIGHT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AreaType.RIGHT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AreaType.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AreaType.LEFT_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f13212a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.C = new LinkedHashMap();
        this.f13187b = 1;
        int i10 = 2;
        this.f13188c = 2;
        int i11 = 3;
        this.f13189d = 3;
        this.f13190e = 4;
        this.f13191f = 5;
        int i12 = 0;
        int i13 = 0;
        AreaType areaType = null;
        int i14 = 0;
        int i15 = 0;
        User user = null;
        int i16 = 5;
        int i17 = 4;
        int i18 = 252;
        DefaultConstructorMarker defaultConstructorMarker = null;
        AreaType areaType2 = AreaType.RIGHT_TOP;
        int i19 = 248;
        AreaType areaType3 = AreaType.RIGHT_BOTTOM;
        AreaType areaType4 = AreaType.LEFT_BOTTOM;
        AreaType areaType5 = AreaType.LEFT_TOP;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        User user2 = null;
        int i24 = 248;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        this.f13192g = kotlin.collections.s.o(new CellularModel(1, 0.0f, null, 0, 0, i12, i13, null, 252, null), new CellularModel(i10, 30.0f, areaType, i12, i13, i14, i15, user, 252, null), new CellularModel(i10, 90.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 150.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 210.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 270.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 330.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i11, 0.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 30.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 60.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 90.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 120.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 150.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 180.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 210.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 240.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 270.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 300.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 330.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 15.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 45.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 75.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 105.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 135.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 165.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 195.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 225.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 255.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 285.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 315.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 345.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i16, 0.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 30.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 60.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 90.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 120.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 150.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 180.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 210.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 240.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 270.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 300.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 330.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2));
        this.f13193h = new ArrayList();
        this.f13194i = h.c(this, 120.0f);
        this.f13195j = h.c(this, 80.0f);
        this.f13196k = h.c(this, 60.0f);
        this.f13197l = h.c(this, 0.0f);
        this.f13198m = h.c(this, 0.0f);
        this.f13199n = h.c(this, 120.0f);
        this.f13200o = h.c(this, 210.0f);
        this.f13201p = h.c(this, 290.0f);
        this.f13202q = h.c(this, 370.0f);
        this.f13207v = new LinkedHashMap();
        this.f13208w = h.c(this, 55.0f);
        l();
    }

    public static final void m(CellularLayout this$0) {
        s.i(this$0, "this$0");
        this$0.f13203r = this$0.getWidth() / 2;
        this$0.f13204s = this$0.getHeight() / 2;
    }

    public static final void r(CellularLayout this$0, Ref$IntRef lastXValue, Ref$IntRef lastYValue, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(lastXValue, "$lastXValue");
        s.i(lastYValue, "$lastYValue");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        int i10 = (int) pointF.x;
        int i11 = (int) pointF.y;
        this$0.g(i10 - lastXValue.element, i11 - lastYValue.element);
        lastXValue.element = i10;
        lastYValue.element = i11;
    }

    public final void f(@NotNull List<User> userList) {
        a aVar;
        s.i(userList, "userList");
        if (!this.f13193h.isEmpty()) {
            int i10 = 0;
            for (CellularModel cellularModel : this.f13193h) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                CellularModel cellularModel2 = cellularModel;
                User user = (User) CollectionsKt___CollectionsKt.W(userList, i10);
                if (user != null) {
                    User user2 = cellularModel2.getUser();
                    if (s.d(user2 != null ? user2.userId() : null, user.userId())) {
                        cellularModel2.setUser(user);
                    }
                }
                User user3 = this.B;
                if (s.d(user3 != null ? user3.userId() : null, user != null ? user.userId() : null)) {
                    this.B = user;
                }
                i10 = i11;
            }
            User user4 = this.B;
            if (user4 == null || (aVar = this.A) == null) {
                return;
            }
            aVar.a(user4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x000d A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.CellularLayout.g(int, int):void");
    }

    public final void h(@NotNull List<User> userList) {
        int i10;
        int i11;
        ConstraintLayout.LayoutParams layoutParams;
        s.i(userList, "userList");
        this.B = (User) CollectionsKt___CollectionsKt.V(userList);
        int min = Math.min(this.f13192g.size(), userList.size());
        this.f13193h.clear();
        int i12 = 0;
        this.f13193h.addAll(CollectionsKt___CollectionsKt.q0(this.f13192g, n.i(0, min)));
        removeAllViews();
        int i13 = 0;
        int i14 = 0;
        for (CellularModel cellularModel : this.f13193h) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                kotlin.collections.s.s();
            }
            final CellularModel cellularModel2 = cellularModel;
            int generateViewId = View.generateViewId();
            Context context = getContext();
            s.h(context, "context");
            final ImageLoaderView imageLoaderView = new ImageLoaderView(context);
            imageLoaderView.setId(generateViewId);
            cellularModel2.setImageId(generateViewId);
            if (i14 == 0) {
                int i16 = this.f13194i;
                layoutParams = new ConstraintLayout.LayoutParams(i16, i16);
                layoutParams.startToStart = i12;
                layoutParams.endToEnd = i12;
                layoutParams.topToTop = i12;
                layoutParams.bottomToBottom = i12;
            } else {
                int laps = cellularModel2.getLaps();
                if (laps == this.f13188c) {
                    i10 = this.f13195j;
                } else {
                    boolean z10 = true;
                    if (!(laps == this.f13189d || laps == this.f13190e) && laps != this.f13191f) {
                        z10 = false;
                    }
                    i10 = z10 ? this.f13196k : this.f13196k;
                }
                int laps2 = cellularModel2.getLaps();
                if (laps2 == this.f13188c) {
                    i11 = this.f13199n;
                } else if (laps2 == this.f13189d) {
                    i11 = this.f13200o;
                } else if (laps2 == this.f13190e) {
                    i11 = this.f13201p;
                } else {
                    i11 = laps2 == this.f13191f ? this.f13202q : this.f13202q;
                }
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(i10, i10);
                layoutParams2.circleConstraint = i13;
                layoutParams2.circleAngle = cellularModel2.getAngle();
                layoutParams2.circleRadius = i11;
                generateViewId = i13;
                layoutParams = layoutParams2;
            }
            if (cellularModel2.getLaps() > 3) {
                imageLoaderView.setVisibility(4);
            }
            addView(imageLoaderView, layoutParams);
            final User user = (User) CollectionsKt___CollectionsKt.W(userList, i14);
            if (user != null) {
                cellularModel2.setUser(user);
                RoundCornerModel roundCornerModel = new RoundCornerModel(true, 0, h.c(this, 1.0f), -2302756, false, false, false, false, 242, null);
                ImageModel avatarImage = user.getAvatarImage();
                ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, avatarImage != null ? avatarImage.getUrl(ImageSizeConstants.SQUARE_ORIGIN_SIZE.getWidth()) : null, null, null, null, null, null, 0, 0, null, null, roundCornerModel, null, false, 0, 0, false, null, null, 522237, null), null, 2, null);
                y.d(imageLoaderView, new Function1<View, p>() { // from class: com.cupidapp.live.chat.view.CellularLayout$configCellularData$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view) {
                        invoke2(view);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
                    
                        r2 = r2.A;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r2) {
                        /*
                            r1 = this;
                            com.cupidapp.live.chat.view.CellularLayout$CellularModel r2 = com.cupidapp.live.chat.view.CellularLayout.CellularModel.this
                            int r2 = r2.getImageId()
                            com.cupidapp.live.chat.view.CellularLayout r0 = r2
                            int r0 = com.cupidapp.live.chat.view.CellularLayout.c(r0)
                            if (r2 != r0) goto L1b
                            com.cupidapp.live.chat.view.CellularLayout r2 = r2
                            com.cupidapp.live.chat.view.CellularLayout$a r2 = com.cupidapp.live.chat.view.CellularLayout.d(r2)
                            if (r2 == 0) goto L1b
                            com.cupidapp.live.profile.model.User r0 = r3
                            r2.b(r0)
                        L1b:
                            com.cupidapp.live.chat.view.CellularLayout r2 = r2
                            com.cupidapp.live.base.imageloader.ImageLoaderView r0 = r4
                            com.cupidapp.live.chat.view.CellularLayout.e(r2, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.CellularLayout$configCellularData$1$1.invoke2(android.view.View):void");
                    }
                });
            }
            i14 = i15;
            i13 = generateViewId;
            i12 = 0;
        }
        this.f13209x = i13;
    }

    public final void i() {
        if (this.f13210y) {
            return;
        }
        for (CellularModel cellularModel : this.f13193h) {
            if (cellularModel.getLaps() > 3) {
                ((ImageLoaderView) findViewById(cellularModel.getImageId())).setVisibility(0);
            }
        }
        this.f13210y = true;
    }

    public final void j() {
        Map.Entry<Integer, Float> next;
        User user;
        a aVar;
        a aVar2;
        Iterator<Map.Entry<Integer, Float>> iterator2 = this.f13207v.entrySet().iterator2();
        CellularModel cellularModel = null;
        if (iterator2.hasNext()) {
            next = iterator2.next();
            if (iterator2.hasNext()) {
                float floatValue = next.getValue().floatValue();
                do {
                    Map.Entry<Integer, Float> next2 = iterator2.next();
                    float floatValue2 = next2.getValue().floatValue();
                    if (Float.compare(floatValue, floatValue2) > 0) {
                        next = next2;
                        floatValue = floatValue2;
                    }
                } while (iterator2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry<Integer, Float> entry = next;
        if (entry != null) {
            int intValue = entry.getKey().intValue();
            if (entry.getValue().floatValue() >= this.f13208w) {
                if (this.f13209x != 0 && (aVar2 = this.A) != null) {
                    aVar2.c();
                }
                this.f13209x = 0;
                return;
            }
            if (this.f13209x != intValue) {
                o();
                if (this.f13209x != 0 && (aVar = this.A) != null) {
                    aVar.c();
                }
                this.f13209x = intValue;
                Iterator<CellularModel> iterator22 = this.f13193h.iterator2();
                while (true) {
                    if (!iterator22.hasNext()) {
                        break;
                    }
                    CellularModel next3 = iterator22.next();
                    if (next3.getImageId() == intValue) {
                        cellularModel = next3;
                        break;
                    }
                }
                CellularModel cellularModel2 = cellularModel;
                if (cellularModel2 == null || (user = cellularModel2.getUser()) == null) {
                    return;
                }
                a aVar3 = this.A;
                if (aVar3 != null) {
                    aVar3.a(user);
                }
                this.B = user;
            }
        }
    }

    public final double k(float f10) {
        return Math.cos((f10 * 3.141592653589793d) / 180);
    }

    public final void l() {
        post(new Runnable() { // from class: com.cupidapp.live.chat.view.b
            @Override // java.lang.Runnable
            public final void run() {
                CellularLayout.m(CellularLayout.this);
            }
        });
    }

    public final void n() {
        Map.Entry<Integer, Float> entry;
        Iterator<Map.Entry<Integer, Float>> iterator2 = this.f13207v.entrySet().iterator2();
        if (iterator2.hasNext()) {
            Map.Entry<Integer, Float> next = iterator2.next();
            if (iterator2.hasNext()) {
                float floatValue = next.getValue().floatValue();
                do {
                    Map.Entry<Integer, Float> next2 = iterator2.next();
                    float floatValue2 = next2.getValue().floatValue();
                    if (Float.compare(floatValue, floatValue2) > 0) {
                        next = next2;
                        floatValue = floatValue2;
                    }
                } while (iterator2.hasNext());
            }
            entry = next;
        } else {
            entry = null;
        }
        Map.Entry<Integer, Float> entry2 = entry;
        if (entry2 != null) {
            View findViewById = findViewById(entry2.getKey().intValue());
            s.h(findViewById, "findViewById(entry.key)");
            q((ImageLoaderView) findViewById);
        }
    }

    public final void o() {
        Object systemService = getContext().getSystemService("vibrator");
        Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.cancel();
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
            } else {
                vibrator.vibrate(40L);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13205t = x10;
            this.f13206u = y10;
        } else if (action == 2) {
            int abs = Math.abs(x10 - this.f13205t);
            int abs2 = Math.abs(y10 - this.f13206u);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (abs > scaledTouchSlop || abs2 > scaledTouchSlop) {
                this.f13205t = x10;
                this.f13206u = y10;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        if (r5 != 3) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != 0) goto L4
            return r0
        L4:
            float r1 = r5.getX()
            int r1 = (int) r1
            float r2 = r5.getY()
            int r2 = (int) r2
            int r5 = r5.getAction()
            if (r5 == 0) goto L31
            if (r5 == r0) goto L2d
            r3 = 2
            if (r5 == r3) goto L1d
            r1 = 3
            if (r5 == r1) goto L2d
            goto L35
        L1d:
            int r5 = r4.f13205t
            int r5 = r1 - r5
            int r3 = r4.f13206u
            int r3 = r2 - r3
            r4.g(r5, r3)
            r4.f13205t = r1
            r4.f13206u = r2
            goto L35
        L2d:
            r4.n()
            goto L35
        L31:
            r4.f13205t = r1
            r4.f13206u = r2
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.CellularLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final double p(float f10) {
        return Math.sin((f10 * 3.141592653589793d) / 180);
    }

    public final void q(ImageLoaderView imageLoaderView) {
        float left = imageLoaderView.getLeft() + ((imageLoaderView.getRight() - imageLoaderView.getLeft()) / 2.0f);
        float top = imageLoaderView.getTop() + ((imageLoaderView.getBottom() - imageLoaderView.getTop()) / 2.0f);
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = (int) left;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = (int) top;
        ValueAnimator ofObject = ValueAnimator.ofObject(new PointFEvaluator(), new PointF(left, top), new PointF(this.f13203r, this.f13204s));
        ofObject.setDuration(200L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.chat.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CellularLayout.r(CellularLayout.this, ref$IntRef, ref$IntRef2, valueAnimator);
            }
        });
        this.f13211z = ofObject;
        ofObject.start();
    }

    public final void setCellularListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.A = listener;
    }

    /* compiled from: CellularLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CellularModel {
        private final float angle;

        @Nullable
        private final AreaType areaType;
        private int extraOffsetValue;
        private int extraOffsetX;
        private int extraOffsetY;
        private int imageId;
        private final int laps;

        @Nullable
        private User user;

        public CellularModel(@IntRange(from = 1, to = 5) int i10, @FloatRange(from = 0.0d, to = 360.0d) float f10, @Nullable AreaType areaType, int i11, int i12, int i13, @IdRes int i14, @Nullable User user) {
            this.laps = i10;
            this.angle = f10;
            this.areaType = areaType;
            this.extraOffsetValue = i11;
            this.extraOffsetX = i12;
            this.extraOffsetY = i13;
            this.imageId = i14;
            this.user = user;
        }

        public final int component1() {
            return this.laps;
        }

        public final float component2() {
            return this.angle;
        }

        @Nullable
        public final AreaType component3() {
            return this.areaType;
        }

        public final int component4() {
            return this.extraOffsetValue;
        }

        public final int component5() {
            return this.extraOffsetX;
        }

        public final int component6() {
            return this.extraOffsetY;
        }

        public final int component7() {
            return this.imageId;
        }

        @Nullable
        public final User component8() {
            return this.user;
        }

        @NotNull
        public final CellularModel copy(@IntRange(from = 1, to = 5) int i10, @FloatRange(from = 0.0d, to = 360.0d) float f10, @Nullable AreaType areaType, int i11, int i12, int i13, @IdRes int i14, @Nullable User user) {
            return new CellularModel(i10, f10, areaType, i11, i12, i13, i14, user);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CellularModel)) {
                return false;
            }
            CellularModel cellularModel = (CellularModel) obj;
            return this.laps == cellularModel.laps && Float.compare(this.angle, cellularModel.angle) == 0 && this.areaType == cellularModel.areaType && this.extraOffsetValue == cellularModel.extraOffsetValue && this.extraOffsetX == cellularModel.extraOffsetX && this.extraOffsetY == cellularModel.extraOffsetY && this.imageId == cellularModel.imageId && s.d(this.user, cellularModel.user);
        }

        public final float getAngle() {
            return this.angle;
        }

        @Nullable
        public final AreaType getAreaType() {
            return this.areaType;
        }

        public final int getExtraOffsetValue() {
            return this.extraOffsetValue;
        }

        public final int getExtraOffsetX() {
            return this.extraOffsetX;
        }

        public final int getExtraOffsetY() {
            return this.extraOffsetY;
        }

        public final int getImageId() {
            return this.imageId;
        }

        public final int getLaps() {
            return this.laps;
        }

        @Nullable
        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            int floatToIntBits = ((this.laps * 31) + Float.floatToIntBits(this.angle)) * 31;
            AreaType areaType = this.areaType;
            int hashCode = (((((((((floatToIntBits + (areaType == null ? 0 : areaType.hashCode())) * 31) + this.extraOffsetValue) * 31) + this.extraOffsetX) * 31) + this.extraOffsetY) * 31) + this.imageId) * 31;
            User user = this.user;
            return hashCode + (user != null ? user.hashCode() : 0);
        }

        public final void setExtraOffsetValue(int i10) {
            this.extraOffsetValue = i10;
        }

        public final void setExtraOffsetX(int i10) {
            this.extraOffsetX = i10;
        }

        public final void setExtraOffsetY(int i10) {
            this.extraOffsetY = i10;
        }

        public final void setImageId(int i10) {
            this.imageId = i10;
        }

        public final void setUser(@Nullable User user) {
            this.user = user;
        }

        @NotNull
        public String toString() {
            int i10 = this.laps;
            float f10 = this.angle;
            AreaType areaType = this.areaType;
            return "CellularModel(laps=" + i10 + ", angle=" + f10 + ", areaType=" + ((Object) areaType) + ", extraOffsetValue=" + this.extraOffsetValue + ", extraOffsetX=" + this.extraOffsetX + ", extraOffsetY=" + this.extraOffsetY + ", imageId=" + this.imageId + ", user=" + ((Object) this.user) + ")";
        }

        public /* synthetic */ CellularModel(int i10, float f10, AreaType areaType, int i11, int i12, int i13, int i14, User user, int i15, DefaultConstructorMarker defaultConstructorMarker) {
            this(i10, f10, (i15 & 4) != 0 ? null : areaType, (i15 & 8) != 0 ? 0 : i11, (i15 & 16) != 0 ? 0 : i12, (i15 & 32) != 0 ? 0 : i13, (i15 & 64) != 0 ? 0 : i14, (i15 & 128) != 0 ? null : user);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.C = new LinkedHashMap();
        this.f13187b = 1;
        int i10 = 2;
        this.f13188c = 2;
        int i11 = 3;
        this.f13189d = 3;
        this.f13190e = 4;
        this.f13191f = 5;
        int i12 = 0;
        int i13 = 0;
        AreaType areaType = null;
        int i14 = 0;
        int i15 = 0;
        User user = null;
        int i16 = 5;
        int i17 = 4;
        int i18 = 252;
        DefaultConstructorMarker defaultConstructorMarker = null;
        AreaType areaType2 = AreaType.RIGHT_TOP;
        int i19 = 248;
        AreaType areaType3 = AreaType.RIGHT_BOTTOM;
        AreaType areaType4 = AreaType.LEFT_BOTTOM;
        AreaType areaType5 = AreaType.LEFT_TOP;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        User user2 = null;
        int i24 = 248;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        this.f13192g = kotlin.collections.s.o(new CellularModel(1, 0.0f, null, 0, 0, i12, i13, null, 252, null), new CellularModel(i10, 30.0f, areaType, i12, i13, i14, i15, user, 252, null), new CellularModel(i10, 90.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 150.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 210.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 270.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i10, 330.0f, areaType, i12, i13, i14, i15, user, i18, defaultConstructorMarker), new CellularModel(i11, 0.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 30.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 60.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 90.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 120.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 150.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 180.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 210.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 240.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 270.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 300.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i11, 330.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 15.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 45.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 75.0f, areaType2, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 105.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 135.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 165.0f, areaType3, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 195.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 225.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 255.0f, areaType4, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 285.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 315.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i17, 345.0f, areaType5, i12, i13, i14, i15, user, i19, defaultConstructorMarker), new CellularModel(i16, 0.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 30.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 60.0f, areaType2, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 90.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 120.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 150.0f, areaType3, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 180.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 210.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 240.0f, areaType4, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 270.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 300.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2), new CellularModel(i16, 330.0f, areaType5, i20, i21, i22, i23, user2, i24, defaultConstructorMarker2));
        this.f13193h = new ArrayList();
        this.f13194i = h.c(this, 120.0f);
        this.f13195j = h.c(this, 80.0f);
        this.f13196k = h.c(this, 60.0f);
        this.f13197l = h.c(this, 0.0f);
        this.f13198m = h.c(this, 0.0f);
        this.f13199n = h.c(this, 120.0f);
        this.f13200o = h.c(this, 210.0f);
        this.f13201p = h.c(this, 290.0f);
        this.f13202q = h.c(this, 370.0f);
        this.f13207v = new LinkedHashMap();
        this.f13208w = h.c(this, 55.0f);
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.C = new LinkedHashMap();
        this.f13187b = 1;
        int i11 = 2;
        this.f13188c = 2;
        int i12 = 3;
        this.f13189d = 3;
        this.f13190e = 4;
        this.f13191f = 5;
        int i13 = 0;
        int i14 = 0;
        AreaType areaType = null;
        int i15 = 0;
        int i16 = 0;
        User user = null;
        int i17 = 5;
        int i18 = 4;
        int i19 = 252;
        DefaultConstructorMarker defaultConstructorMarker = null;
        AreaType areaType2 = AreaType.RIGHT_TOP;
        int i20 = 248;
        AreaType areaType3 = AreaType.RIGHT_BOTTOM;
        AreaType areaType4 = AreaType.LEFT_BOTTOM;
        AreaType areaType5 = AreaType.LEFT_TOP;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        User user2 = null;
        int i25 = 248;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        this.f13192g = kotlin.collections.s.o(new CellularModel(1, 0.0f, null, 0, 0, i13, i14, null, 252, null), new CellularModel(i11, 30.0f, areaType, i13, i14, i15, i16, user, 252, null), new CellularModel(i11, 90.0f, areaType, i13, i14, i15, i16, user, i19, defaultConstructorMarker), new CellularModel(i11, 150.0f, areaType, i13, i14, i15, i16, user, i19, defaultConstructorMarker), new CellularModel(i11, 210.0f, areaType, i13, i14, i15, i16, user, i19, defaultConstructorMarker), new CellularModel(i11, 270.0f, areaType, i13, i14, i15, i16, user, i19, defaultConstructorMarker), new CellularModel(i11, 330.0f, areaType, i13, i14, i15, i16, user, i19, defaultConstructorMarker), new CellularModel(i12, 0.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 30.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 60.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 90.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 120.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 150.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 180.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 210.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 240.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 270.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 300.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i12, 330.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 15.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 45.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 75.0f, areaType2, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 105.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 135.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 165.0f, areaType3, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 195.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 225.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 255.0f, areaType4, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 285.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 315.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i18, 345.0f, areaType5, i13, i14, i15, i16, user, i20, defaultConstructorMarker), new CellularModel(i17, 0.0f, areaType2, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 30.0f, areaType2, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 60.0f, areaType2, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 90.0f, areaType3, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 120.0f, areaType3, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 150.0f, areaType3, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 180.0f, areaType4, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 210.0f, areaType4, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 240.0f, areaType4, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 270.0f, areaType5, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 300.0f, areaType5, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2), new CellularModel(i17, 330.0f, areaType5, i21, i22, i23, i24, user2, i25, defaultConstructorMarker2));
        this.f13193h = new ArrayList();
        this.f13194i = h.c(this, 120.0f);
        this.f13195j = h.c(this, 80.0f);
        this.f13196k = h.c(this, 60.0f);
        this.f13197l = h.c(this, 0.0f);
        this.f13198m = h.c(this, 0.0f);
        this.f13199n = h.c(this, 120.0f);
        this.f13200o = h.c(this, 210.0f);
        this.f13201p = h.c(this, 290.0f);
        this.f13202q = h.c(this, 370.0f);
        this.f13207v = new LinkedHashMap();
        this.f13208w = h.c(this, 55.0f);
        l();
    }
}
