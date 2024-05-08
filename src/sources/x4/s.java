package x4;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;

/* compiled from: AuxEffectInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f54436a;

    /* renamed from: b, reason: collision with root package name */
    public final float f54437b;

    public s(int i10, float f10) {
        this.f54436a = i10;
        this.f54437b = f10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.f54436a == sVar.f54436a && Float.compare(sVar.f54437b, this.f54437b) == 0;
    }

    public int hashCode() {
        return ((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f54436a) * 31) + Float.floatToIntBits(this.f54437b);
    }
}
