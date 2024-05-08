package mc;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;

/* compiled from: SwipeAnimationSetting.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c implements nc.a {

    /* renamed from: a, reason: collision with root package name */
    public final Direction f51984a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51985b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f51986c;

    /* compiled from: SwipeAnimationSetting.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Direction f51987a = Direction.Right;

        /* renamed from: b, reason: collision with root package name */
        public int f51988b = Duration.Normal.duration;

        /* renamed from: c, reason: collision with root package name */
        public Interpolator f51989c = new AccelerateInterpolator();

        public c a() {
            return new c(this.f51987a, this.f51988b, this.f51989c);
        }

        public b b(Direction direction) {
            this.f51987a = direction;
            return this;
        }

        public b c(int i10) {
            this.f51988b = i10;
            return this;
        }

        public b d(Interpolator interpolator) {
            this.f51989c = interpolator;
            return this;
        }
    }

    @Override // nc.a
    public Direction a() {
        return this.f51984a;
    }

    @Override // nc.a
    public Interpolator b() {
        return this.f51986c;
    }

    @Override // nc.a
    public int getDuration() {
        return this.f51985b;
    }

    public c(Direction direction, int i10, Interpolator interpolator) {
        this.f51984a = direction;
        this.f51985b = i10;
        this.f51986c = interpolator;
    }
}
