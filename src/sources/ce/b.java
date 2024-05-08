package ce;

import java.util.NoSuchElementException;
import kotlin.collections.q;
import kotlin.jvm.internal.s;

/* compiled from: ProgressionIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends q {

    /* renamed from: b, reason: collision with root package name */
    public final int f1598b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1599c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1600d;

    /* renamed from: e, reason: collision with root package name */
    public int f1601e;

    public b(char c4, char c10, int i10) {
        this.f1598b = i10;
        this.f1599c = c10;
        boolean z10 = true;
        if (i10 <= 0 ? s.k(c4, c10) < 0 : s.k(c4, c10) > 0) {
            z10 = false;
        }
        this.f1600d = z10;
        this.f1601e = z10 ? c4 : c10;
    }

    @Override // kotlin.collections.q
    public char a() {
        int i10 = this.f1601e;
        if (i10 == this.f1599c) {
            if (this.f1600d) {
                this.f1600d = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f1601e = this.f1598b + i10;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1600d;
    }
}
