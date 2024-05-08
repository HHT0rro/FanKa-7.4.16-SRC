package o4;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.auto.value.AutoValue;
import o4.a;

/* compiled from: BackendRequest.java */
@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e {

    /* compiled from: BackendRequest.java */
    @AutoValue.Builder
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a {
        public abstract e a();

        public abstract a b(Iterable<EventInternal> iterable);

        public abstract a c(@Nullable byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<EventInternal> b();

    @Nullable
    public abstract byte[] c();
}
