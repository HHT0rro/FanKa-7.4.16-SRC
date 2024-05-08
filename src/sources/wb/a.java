package wb;

import android.view.animation.Interpolator;

/* compiled from: AlphaModifier.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public int f54318a;

    /* renamed from: b, reason: collision with root package name */
    public int f54319b;

    /* renamed from: c, reason: collision with root package name */
    public long f54320c;

    /* renamed from: d, reason: collision with root package name */
    public long f54321d;

    /* renamed from: e, reason: collision with root package name */
    public float f54322e;

    /* renamed from: f, reason: collision with root package name */
    public float f54323f;

    /* renamed from: g, reason: collision with root package name */
    public Interpolator f54324g;

    public a(int i10, int i11, long j10, long j11, Interpolator interpolator) {
        this.f54318a = i10;
        this.f54319b = i11;
        this.f54320c = j10;
        this.f54321d = j11;
        this.f54322e = (float) (j11 - j10);
        this.f54323f = i11 - i10;
        this.f54324g = interpolator;
    }

    @Override // wb.b
    public void a(com.plattysoft.leonids.b bVar, long j10) {
        long j11 = this.f54320c;
        if (j10 < j11) {
            bVar.f38047e = this.f54318a;
        } else if (j10 > this.f54321d) {
            bVar.f38047e = this.f54319b;
        } else {
            bVar.f38047e = (int) (this.f54318a + (this.f54323f * this.f54324g.getInterpolation((((float) (j10 - j11)) * 1.0f) / this.f54322e)));
        }
    }
}
