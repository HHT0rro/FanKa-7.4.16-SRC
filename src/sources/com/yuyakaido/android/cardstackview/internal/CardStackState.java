package com.yuyakaido.android.cardstackview.internal;

import com.yuyakaido.android.cardstackview.Direction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackState {

    /* renamed from: a, reason: collision with root package name */
    public Status f48560a = Status.Idle;

    /* renamed from: b, reason: collision with root package name */
    public int f48561b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f48562c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f48563d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f48564e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f48565f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f48566g = -1;

    /* renamed from: h, reason: collision with root package name */
    public float f48567h = 0.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Status {
        Idle,
        Dragging,
        RewindAnimating,
        AutomaticSwipeAnimating,
        AutomaticSwipeAnimated,
        ManualSwipeAnimating,
        ManualSwipeAnimated;

        public boolean isBusy() {
            return this != Idle;
        }

        public boolean isDragging() {
            return this == Dragging;
        }

        public boolean isSwipeAnimating() {
            return this == ManualSwipeAnimating || this == AutomaticSwipeAnimating;
        }

        public Status toAnimatedStatus() {
            int i10 = a.f48568a[ordinal()];
            if (i10 == 1) {
                return ManualSwipeAnimated;
            }
            if (i10 != 2) {
                return Idle;
            }
            return AutomaticSwipeAnimated;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48568a;

        static {
            int[] iArr = new int[Status.values().length];
            f48568a = iArr;
            try {
                iArr[Status.ManualSwipeAnimating.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48568a[Status.AutomaticSwipeAnimating.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public boolean a(int i10, int i11) {
        return i10 != this.f48565f && i10 >= 0 && i11 >= i10 && !this.f48560a.isBusy();
    }

    public Direction b() {
        if (Math.abs(this.f48564e) < Math.abs(this.f48563d)) {
            if (this.f48563d < 0.0f) {
                return Direction.Left;
            }
            return Direction.Right;
        }
        if (this.f48564e < 0.0f) {
            return Direction.Top;
        }
        return Direction.Bottom;
    }

    public float c() {
        float f10;
        int i10;
        int abs = Math.abs(this.f48563d);
        int abs2 = Math.abs(this.f48564e);
        if (abs < abs2) {
            f10 = abs2;
            i10 = this.f48562c;
        } else {
            f10 = abs;
            i10 = this.f48561b;
        }
        return Math.min(f10 / (i10 / 2.0f), 1.0f);
    }

    public boolean d() {
        if (!this.f48560a.isSwipeAnimating() || this.f48565f >= this.f48566g) {
            return false;
        }
        return this.f48561b < Math.abs(this.f48563d) || this.f48562c < Math.abs(this.f48564e);
    }

    public void e(Status status) {
        this.f48560a = status;
    }
}
