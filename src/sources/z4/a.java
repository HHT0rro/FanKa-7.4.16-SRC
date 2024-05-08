package z4;

/* compiled from: Buffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public int f54839b;

    public final void g(int i10) {
        this.f54839b = i10 | this.f54839b;
    }

    public void h() {
        this.f54839b = 0;
    }

    public final void i(int i10) {
        this.f54839b = (~i10) & this.f54839b;
    }

    public final boolean j(int i10) {
        return (this.f54839b & i10) == i10;
    }

    public final boolean k() {
        return j(268435456);
    }

    public final boolean l() {
        return j(Integer.MIN_VALUE);
    }

    public final boolean m() {
        return j(4);
    }

    public final boolean n() {
        return j(1);
    }

    public final void o(int i10) {
        this.f54839b = i10;
    }
}
