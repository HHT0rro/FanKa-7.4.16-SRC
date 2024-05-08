package o8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.internal.mlkit_vision_face.u9;
import com.google.android.gms.internal.mlkit_vision_face.v9;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f52374a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52375b;

    /* renamed from: c, reason: collision with root package name */
    public final int f52376c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52377d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f52378e;

    /* renamed from: f, reason: collision with root package name */
    public final float f52379f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final Executor f52380g;

    /* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f52381a = 1;

        /* renamed from: b, reason: collision with root package name */
        public int f52382b = 1;

        /* renamed from: c, reason: collision with root package name */
        public int f52383c = 1;

        /* renamed from: d, reason: collision with root package name */
        public int f52384d = 1;

        /* renamed from: e, reason: collision with root package name */
        public boolean f52385e = false;

        /* renamed from: f, reason: collision with root package name */
        public float f52386f = 0.1f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public Executor f52387g;

        @NonNull
        public d a() {
            return new d(this.f52381a, this.f52382b, this.f52383c, this.f52384d, this.f52385e, this.f52386f, this.f52387g, null);
        }

        @NonNull
        public a b(int i10) {
            this.f52383c = i10;
            return this;
        }

        @NonNull
        public a c(int i10) {
            this.f52381a = i10;
            return this;
        }

        @NonNull
        public a d(float f10) {
            this.f52386f = f10;
            return this;
        }

        @NonNull
        public a e(int i10) {
            this.f52384d = i10;
            return this;
        }
    }

    public /* synthetic */ d(int i10, int i11, int i12, int i13, boolean z10, float f10, Executor executor, f fVar) {
        this.f52374a = i10;
        this.f52375b = i11;
        this.f52376c = i12;
        this.f52377d = i13;
        this.f52378e = z10;
        this.f52379f = f10;
        this.f52380g = executor;
    }

    public final int a() {
        return this.f52374a;
    }

    public final int b() {
        return this.f52375b;
    }

    public final int c() {
        return this.f52376c;
    }

    public final int d() {
        return this.f52377d;
    }

    public final boolean e() {
        return this.f52378e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.floatToIntBits(this.f52379f) == Float.floatToIntBits(dVar.f52379f) && this.f52374a == dVar.f52374a && this.f52375b == dVar.f52375b && this.f52377d == dVar.f52377d && this.f52378e == dVar.f52378e && this.f52376c == dVar.f52376c;
    }

    public final float f() {
        return this.f52379f;
    }

    @RecentlyNullable
    public final Executor g() {
        return this.f52380g;
    }

    public int hashCode() {
        return g.b(Integer.valueOf(Float.floatToIntBits(this.f52379f)), Integer.valueOf(this.f52374a), Integer.valueOf(this.f52375b), Integer.valueOf(this.f52377d), Boolean.valueOf(this.f52378e), Integer.valueOf(this.f52376c));
    }

    @RecentlyNonNull
    public String toString() {
        u9 a10 = v9.a("FaceDetectorOptions");
        a10.d("landmarkMode", this.f52374a);
        a10.d("contourMode", this.f52375b);
        a10.d("classificationMode", this.f52376c);
        a10.d("performanceMode", this.f52377d);
        a10.b("trackingEnabled", this.f52378e);
        a10.c("minFaceSize", this.f52379f);
        return a10.toString();
    }
}
