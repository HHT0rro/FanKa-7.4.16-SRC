package z5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.h0;

/* compiled from: RangedUri.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f54932a;

    /* renamed from: b, reason: collision with root package name */
    public final long f54933b;

    /* renamed from: c, reason: collision with root package name */
    public final String f54934c;

    /* renamed from: d, reason: collision with root package name */
    public int f54935d;

    public i(@Nullable String str, long j10, long j11) {
        this.f54934c = str == null ? "" : str;
        this.f54932a = j10;
        this.f54933b = j11;
    }

    @Nullable
    public i a(@Nullable i iVar, String str) {
        String c4 = c(str);
        if (iVar != null && c4.equals(iVar.c(str))) {
            long j10 = this.f54933b;
            if (j10 != -1) {
                long j11 = this.f54932a;
                if (j11 + j10 == iVar.f54932a) {
                    long j12 = iVar.f54933b;
                    return new i(c4, j11, j12 != -1 ? j10 + j12 : -1L);
                }
            }
            long j13 = iVar.f54933b;
            if (j13 != -1) {
                long j14 = iVar.f54932a;
                if (j14 + j13 == this.f54932a) {
                    return new i(c4, j14, j10 != -1 ? j13 + j10 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return h0.e(str, this.f54934c);
    }

    public String c(String str) {
        return h0.d(str, this.f54934c);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f54932a == iVar.f54932a && this.f54933b == iVar.f54933b && this.f54934c.equals(iVar.f54934c);
    }

    public int hashCode() {
        if (this.f54935d == 0) {
            this.f54935d = ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + ((int) this.f54932a)) * 31) + ((int) this.f54933b)) * 31) + this.f54934c.hashCode();
        }
        return this.f54935d;
    }

    public String toString() {
        String str = this.f54934c;
        long j10 = this.f54932a;
        long j11 = this.f54933b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 81);
        sb2.append("RangedUri(referenceUri=");
        sb2.append(str);
        sb2.append(", start=");
        sb2.append(j10);
        sb2.append(", length=");
        sb2.append(j11);
        sb2.append(")");
        return sb2.toString();
    }
}
