package z5;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;

/* compiled from: ProgramInformation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f54927a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f54928b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f54929c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f54930d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f54931e;

    public h(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f54927a = str;
        this.f54928b = str2;
        this.f54929c = str3;
        this.f54930d = str4;
        this.f54931e = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return j0.c(this.f54927a, hVar.f54927a) && j0.c(this.f54928b, hVar.f54928b) && j0.c(this.f54929c, hVar.f54929c) && j0.c(this.f54930d, hVar.f54930d) && j0.c(this.f54931e, hVar.f54931e);
    }

    public int hashCode() {
        String str = this.f54927a;
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f54928b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f54929c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f54930d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f54931e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
