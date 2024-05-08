package z5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;

/* compiled from: Descriptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f54914a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f54915b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f54916c;

    public e(String str, @Nullable String str2, @Nullable String str3) {
        this.f54914a = str;
        this.f54915b = str2;
        this.f54916c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return j0.c(this.f54914a, eVar.f54914a) && j0.c(this.f54915b, eVar.f54915b) && j0.c(this.f54916c, eVar.f54916c);
    }

    public int hashCode() {
        int hashCode = this.f54914a.hashCode() * 31;
        String str = this.f54915b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f54916c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
