package q6;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: VideoSize.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name */
    public static final y f53146e = new y(0, 0);

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g<y> f53147f = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f53148a;

    /* renamed from: b, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f53149b;

    /* renamed from: c, reason: collision with root package name */
    @IntRange(from = 0, to = 359)
    public final int f53150c;

    /* renamed from: d, reason: collision with root package name */
    @FloatRange(from = ShadowDrawableWrapper.COS_45, fromInclusive = false)
    public final float f53151d;

    public y(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11) {
        this(i10, i11, 0, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f53148a == yVar.f53148a && this.f53149b == yVar.f53149b && this.f53150c == yVar.f53150c && this.f53151d == yVar.f53151d;
    }

    public int hashCode() {
        return ((((((217 + this.f53148a) * 31) + this.f53149b) * 31) + this.f53150c) * 31) + Float.floatToRawIntBits(this.f53151d);
    }

    public y(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0, to = 359) int i12, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        this.f53148a = i10;
        this.f53149b = i11;
        this.f53150c = i12;
        this.f53151d = f10;
    }
}
