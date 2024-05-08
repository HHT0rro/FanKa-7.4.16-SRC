package n6;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;

/* compiled from: TrackSelectionArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f52141a;

    /* renamed from: b, reason: collision with root package name */
    public final g[] f52142b;

    /* renamed from: c, reason: collision with root package name */
    public int f52143c;

    public h(g... gVarArr) {
        this.f52142b = gVarArr;
        this.f52141a = gVarArr.length;
    }

    @Nullable
    public g a(int i10) {
        return this.f52142b[i10];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f52142b, ((h) obj).f52142b);
    }

    public int hashCode() {
        if (this.f52143c == 0) {
            this.f52143c = MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + Arrays.hashCode(this.f52142b);
        }
        return this.f52143c;
    }
}
