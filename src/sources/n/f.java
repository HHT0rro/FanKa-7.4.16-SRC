package n;

/* compiled from: MeanCalculator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public float f52015a;

    /* renamed from: b, reason: collision with root package name */
    public int f52016b;

    public void a(float f10) {
        float f11 = this.f52015a + f10;
        this.f52015a = f11;
        int i10 = this.f52016b + 1;
        this.f52016b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f52015a = f11 / 2.0f;
            this.f52016b = i10 / 2;
        }
    }
}
