package x4;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;

/* compiled from: AudioAttributes.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final d f54384f = new b().a();

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g<d> f54385g = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    public final int f54386a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54387b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54388c;

    /* renamed from: d, reason: collision with root package name */
    public final int f54389d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public AudioAttributes f54390e;

    /* compiled from: AudioAttributes.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f54391a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f54392b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f54393c = 1;

        /* renamed from: d, reason: collision with root package name */
        public int f54394d = 1;

        public d a() {
            return new d(this.f54391a, this.f54392b, this.f54393c, this.f54394d);
        }

        public b b(int i10) {
            this.f54391a = i10;
            return this;
        }
    }

    @RequiresApi(21)
    public AudioAttributes a() {
        if (this.f54390e == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f54386a).setFlags(this.f54387b).setUsage(this.f54388c);
            if (j0.f22990a >= 29) {
                usage.setAllowedCapturePolicy(this.f54389d);
            }
            this.f54390e = usage.build();
        }
        return this.f54390e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f54386a == dVar.f54386a && this.f54387b == dVar.f54387b && this.f54388c == dVar.f54388c && this.f54389d == dVar.f54389d;
    }

    public int hashCode() {
        return ((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f54386a) * 31) + this.f54387b) * 31) + this.f54388c) * 31) + this.f54389d;
    }

    public d(int i10, int i11, int i12, int i13) {
        this.f54386a = i10;
        this.f54387b = i11;
        this.f54388c = i12;
        this.f54389d = i13;
    }
}
