package a5;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.g;

/* compiled from: DeviceInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f701d = new b(0, 0, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final g<b> f702e = a.f700a;

    /* renamed from: a, reason: collision with root package name */
    public final int f703a;

    /* renamed from: b, reason: collision with root package name */
    public final int f704b;

    /* renamed from: c, reason: collision with root package name */
    public final int f705c;

    public b(int i10, int i11, int i12) {
        this.f703a = i10;
        this.f704b = i11;
        this.f705c = i12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f703a == bVar.f703a && this.f704b == bVar.f704b && this.f705c == bVar.f705c;
    }

    public int hashCode() {
        return ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f703a) * 31) + this.f704b) * 31) + this.f705c;
    }
}
