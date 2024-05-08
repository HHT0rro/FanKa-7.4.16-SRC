package androidx.constraintlayout.solver.widgets;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f861x;

    /* renamed from: y, reason: collision with root package name */
    public int f862y;

    public boolean contains(int i10, int i11) {
        int i12;
        int i13 = this.f861x;
        return i10 >= i13 && i10 < i13 + this.width && i11 >= (i12 = this.f862y) && i11 < i12 + this.height;
    }

    public int getCenterX() {
        return (this.f861x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f862y + this.height) / 2;
    }

    public void grow(int i10, int i11) {
        this.f861x -= i10;
        this.f862y -= i11;
        this.width += i10 * 2;
        this.height += i11 * 2;
    }

    public boolean intersects(Rectangle rectangle) {
        int i10;
        int i11;
        int i12 = this.f861x;
        int i13 = rectangle.f861x;
        return i12 >= i13 && i12 < i13 + rectangle.width && (i10 = this.f862y) >= (i11 = rectangle.f862y) && i10 < i11 + rectangle.height;
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        this.f861x = i10;
        this.f862y = i11;
        this.width = i12;
        this.height = i13;
    }
}
