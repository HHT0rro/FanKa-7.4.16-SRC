package com.yuyakaido.android.cardstackview.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.internal.CardStackState;
import mc.b;
import mc.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackSmoothScroller extends RecyclerView.SmoothScroller {

    /* renamed from: a, reason: collision with root package name */
    public ScrollType f48554a;

    /* renamed from: b, reason: collision with root package name */
    public CardStackLayoutManager f48555b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum ScrollType {
        AutomaticSwipe,
        AutomaticRewind,
        ManualSwipe,
        ManualCancel
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48556a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f48557b;

        static {
            int[] iArr = new int[Direction.values().length];
            f48557b = iArr;
            try {
                iArr[Direction.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48557b[Direction.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48557b[Direction.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48557b[Direction.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ScrollType.values().length];
            f48556a = iArr2;
            try {
                iArr2[ScrollType.AutomaticSwipe.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48556a[ScrollType.AutomaticRewind.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f48556a[ScrollType.ManualSwipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f48556a[ScrollType.ManualCancel.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public CardStackSmoothScroller(ScrollType scrollType, CardStackLayoutManager cardStackLayoutManager) {
        this.f48554a = scrollType;
        this.f48555b = cardStackLayoutManager;
    }

    public final int a(nc.a aVar) {
        int i10;
        CardStackState e2 = this.f48555b.e();
        int i11 = a.f48557b[aVar.a().ordinal()];
        if (i11 == 1) {
            i10 = -e2.f48561b;
        } else {
            if (i11 != 2) {
                return i11 != 3 ? 0 : 0;
            }
            i10 = e2.f48561b;
        }
        return i10 * 2;
    }

    public final int b(nc.a aVar) {
        int i10;
        CardStackState e2 = this.f48555b.e();
        int i11 = a.f48557b[aVar.a().ordinal()];
        if (i11 == 1 || i11 == 2) {
            return e2.f48562c / 4;
        }
        if (i11 == 3) {
            i10 = -e2.f48562c;
        } else {
            if (i11 != 4) {
                return 0;
            }
            i10 = e2.f48562c;
        }
        return i10 * 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onSeekTargetStep(int i10, int i11, @NonNull RecyclerView.State state, @NonNull RecyclerView.SmoothScroller.Action action) {
        if (this.f48554a == ScrollType.AutomaticRewind) {
            b bVar = this.f48555b.d().f52208l;
            action.update(-a(bVar), -b(bVar), bVar.getDuration(), bVar.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
        mc.a c4 = this.f48555b.c();
        CardStackState e2 = this.f48555b.e();
        int i10 = a.f48556a[this.f48554a.ordinal()];
        if (i10 == 1) {
            e2.e(CardStackState.Status.AutomaticSwipeAnimating);
            c4.b(this.f48555b.g(), this.f48555b.f());
        } else {
            if (i10 == 2) {
                e2.e(CardStackState.Status.RewindAnimating);
                return;
            }
            if (i10 == 3) {
                e2.e(CardStackState.Status.ManualSwipeAnimating);
                c4.b(this.f48555b.g(), this.f48555b.f());
            } else {
                if (i10 != 4) {
                    return;
                }
                e2.e(CardStackState.Status.RewindAnimating);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        mc.a c4 = this.f48555b.c();
        int i10 = a.f48556a[this.f48554a.ordinal()];
        if (i10 == 2) {
            c4.k();
            c4.d(this.f48555b.g(), this.f48555b.f());
        } else {
            if (i10 != 4) {
                return;
            }
            c4.j();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(@NonNull View view, @NonNull RecyclerView.State state, @NonNull RecyclerView.SmoothScroller.Action action) {
        int translationX = (int) view.getTranslationX();
        int translationY = (int) view.getTranslationY();
        int i10 = a.f48556a[this.f48554a.ordinal()];
        if (i10 == 1) {
            c cVar = this.f48555b.d().f52207k;
            action.update(-a(cVar), -b(cVar), cVar.getDuration(), cVar.b());
            return;
        }
        if (i10 == 2) {
            b bVar = this.f48555b.d().f52208l;
            action.update(translationX, translationY, bVar.getDuration(), bVar.b());
        } else if (i10 == 3) {
            c cVar2 = this.f48555b.d().f52207k;
            action.update((-translationX) * 10, (-translationY) * 10, cVar2.getDuration(), cVar2.b());
        } else {
            if (i10 != 4) {
                return;
            }
            b bVar2 = this.f48555b.d().f52208l;
            action.update(translationX, translationY, bVar2.getDuration(), bVar2.b());
        }
    }
}
