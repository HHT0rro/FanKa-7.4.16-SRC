package z5;

import androidx.annotation.Nullable;

/* compiled from: BaseUrl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f54885a;

    /* renamed from: b, reason: collision with root package name */
    public final String f54886b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54887c;

    /* renamed from: d, reason: collision with root package name */
    public final int f54888d;

    public b(String str) {
        this(str, str, 1, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f54887c == bVar.f54887c && this.f54888d == bVar.f54888d && com.google.common.base.l.a(this.f54885a, bVar.f54885a) && com.google.common.base.l.a(this.f54886b, bVar.f54886b);
    }

    public int hashCode() {
        return com.google.common.base.l.b(this.f54885a, this.f54886b, Integer.valueOf(this.f54887c), Integer.valueOf(this.f54888d));
    }

    public b(String str, String str2, int i10, int i11) {
        this.f54885a = str;
        this.f54886b = str2;
        this.f54887c = i10;
        this.f54888d = i11;
    }
}
