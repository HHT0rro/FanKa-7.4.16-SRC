package h5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.huawei.openalliance.ad.constant.bb;
import java.util.List;

/* compiled from: MotionPhotoDescription.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f49510a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f49511b;

    /* compiled from: MotionPhotoDescription.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f49512a;

        /* renamed from: b, reason: collision with root package name */
        public final String f49513b;

        /* renamed from: c, reason: collision with root package name */
        public final long f49514c;

        /* renamed from: d, reason: collision with root package name */
        public final long f49515d;

        public a(String str, String str2, long j10, long j11) {
            this.f49512a = str;
            this.f49513b = str2;
            this.f49514c = j10;
            this.f49515d = j11;
        }
    }

    public b(long j10, List<a> list) {
        this.f49510a = j10;
        this.f49511b = list;
    }

    @Nullable
    public MotionPhotoMetadata a(long j10) {
        long j11;
        if (this.f49511b.size() < 2) {
            return null;
        }
        long j12 = j10;
        long j13 = -1;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        boolean z10 = false;
        for (int size = this.f49511b.size() - 1; size >= 0; size--) {
            a aVar = this.f49511b.get(size);
            boolean equals = bb.Code.equals(aVar.f49512a) | z10;
            if (size == 0) {
                j11 = j12 - aVar.f49515d;
                j12 = 0;
            } else {
                long j17 = j12;
                j12 -= aVar.f49514c;
                j11 = j17;
            }
            if (!equals || j12 == j11) {
                z10 = equals;
            } else {
                j16 = j11 - j12;
                j15 = j12;
                z10 = false;
            }
            if (size == 0) {
                j13 = j12;
                j14 = j11;
            }
        }
        if (j15 == -1 || j16 == -1 || j13 == -1 || j14 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j13, j14, this.f49510a, j15, j16);
    }
}
