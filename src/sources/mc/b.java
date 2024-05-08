package mc;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;

/* compiled from: RewindAnimationSetting.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b implements nc.a {

    /* renamed from: a, reason: collision with root package name */
    public final Direction f51978a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51979b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f51980c;

    /* compiled from: RewindAnimationSetting.java */
    /* renamed from: mc.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0791b {

        /* renamed from: a, reason: collision with root package name */
        public Direction f51981a = Direction.Bottom;

        /* renamed from: b, reason: collision with root package name */
        public int f51982b = Duration.Normal.duration;

        /* renamed from: c, reason: collision with root package name */
        public Interpolator f51983c = new DecelerateInterpolator();

        public b a() {
            return new b(this.f51981a, this.f51982b, this.f51983c);
        }

        public C0791b b(Direction direction) {
            this.f51981a = direction;
            return this;
        }

        public C0791b c(int i10) {
            this.f51982b = i10;
            return this;
        }

        public C0791b d(Interpolator interpolator) {
            this.f51983c = interpolator;
            return this;
        }
    }

    @Override // nc.a
    public Direction a() {
        return this.f51978a;
    }

    @Override // nc.a
    public Interpolator b() {
        return this.f51980c;
    }

    @Override // nc.a
    public int getDuration() {
        return this.f51979b;
    }

    public b(Direction direction, int i10, Interpolator interpolator) {
        this.f51978a = direction;
        this.f51979b = i10;
        this.f51980c = interpolator;
    }
}
