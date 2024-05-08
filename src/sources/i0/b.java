package i0;

/* compiled from: NumericWheelAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b implements r0.a {

    /* renamed from: a, reason: collision with root package name */
    public int f49674a;

    /* renamed from: b, reason: collision with root package name */
    public int f49675b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f49676c = false;

    public b(int i10, int i11) {
        this.f49674a = i10;
        this.f49675b = i11;
    }

    @Override // r0.a
    public int a() {
        if (this.f49676c) {
            return (this.f49675b - this.f49674a) + 2;
        }
        return (this.f49675b - this.f49674a) + 1;
    }

    public void b(boolean z10) {
        this.f49676c = z10;
    }

    @Override // r0.a
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= a()) {
            return 0;
        }
        return (this.f49676c && i10 == a() + (-1)) ? "暂不填写" : Integer.valueOf(this.f49674a + i10);
    }
}
