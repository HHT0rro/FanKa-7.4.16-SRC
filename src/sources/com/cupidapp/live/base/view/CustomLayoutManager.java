package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomLayoutManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CustomLayoutManager extends CanScrollLinearLayoutManager {

    /* renamed from: c, reason: collision with root package name */
    public final int f12448c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final ScrollTo f12449d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Float f12450e;

    /* compiled from: CustomLayoutManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12451a;

        static {
            int[] iArr = new int[ScrollTo.values().length];
            try {
                iArr[ScrollTo.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollTo.End.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScrollTo.Center.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12451a = iArr;
        }
    }

    public /* synthetic */ CustomLayoutManager(Context context, int i10, ScrollTo scrollTo, Float f10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i10, scrollTo, (i11 & 8) != 0 ? null : f10);
    }

    public final int e() {
        int i10 = a.f12451a[this.f12449d.ordinal()];
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public final Float f() {
        return this.f12450e;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@Nullable RecyclerView recyclerView, @Nullable RecyclerView.State state, int i10) {
        final Context context = recyclerView != null ? recyclerView.getContext() : null;
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.cupidapp.live.base.view.CustomLayoutManager$smoothScrollToPosition$centerScroll$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int i11, int i12, int i13, int i14, int i15) {
                if (i15 != -1) {
                    if (i15 == 0) {
                        return (i13 + ((i14 - i13) / 2)) - (i11 + ((i12 - i11) / 2));
                    }
                    if (i15 != 1) {
                        return super.calculateDtToFit(i11, i12, i13, i14, i15);
                    }
                }
                return super.calculateDtToFit(i11, i12, i13, i14, i15);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(@Nullable DisplayMetrics displayMetrics) {
                if (CustomLayoutManager.this.f() == null) {
                    return super.calculateSpeedPerPixel(displayMetrics);
                }
                return CustomLayoutManager.this.f().floatValue();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getHorizontalSnapPreference() {
                int i11;
                int e2;
                i11 = CustomLayoutManager.this.f12448c;
                if (i11 == 0) {
                    e2 = CustomLayoutManager.this.e();
                    return e2;
                }
                if (i11 != 1) {
                    return super.getHorizontalSnapPreference();
                }
                return super.getHorizontalSnapPreference();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                int i11;
                int e2;
                i11 = CustomLayoutManager.this.f12448c;
                if (i11 == 0) {
                    return super.getVerticalSnapPreference();
                }
                if (i11 != 1) {
                    return super.getVerticalSnapPreference();
                }
                e2 = CustomLayoutManager.this.e();
                return e2;
            }
        };
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomLayoutManager(@NotNull Context context, int i10, @NotNull ScrollTo type, @Nullable Float f10) {
        super(context, i10, false);
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(type, "type");
        this.f12448c = i10;
        this.f12449d = type;
        this.f12450e = f10;
    }
}
