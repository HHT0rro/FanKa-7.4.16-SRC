package o4;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Objects;

/* compiled from: AutoValue_CreationContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52270a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f52271b;

    /* renamed from: c, reason: collision with root package name */
    public final u4.a f52272c;

    /* renamed from: d, reason: collision with root package name */
    public final String f52273d;

    public b(Context context, u4.a aVar, u4.a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f52270a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.f52271b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.f52272c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f52273d = str;
    }

    @Override // o4.f
    public Context b() {
        return this.f52270a;
    }

    @Override // o4.f
    @NonNull
    public String c() {
        return this.f52273d;
    }

    @Override // o4.f
    public u4.a d() {
        return this.f52272c;
    }

    @Override // o4.f
    public u4.a e() {
        return this.f52271b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f52270a.equals(fVar.b()) && this.f52271b.equals(fVar.e()) && this.f52272c.equals(fVar.d()) && this.f52273d.equals(fVar.c());
    }

    public int hashCode() {
        return ((((((this.f52270a.hashCode() ^ 1000003) * 1000003) ^ this.f52271b.hashCode()) * 1000003) ^ this.f52272c.hashCode()) * 1000003) ^ this.f52273d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + ((Object) this.f52270a) + ", wallClock=" + ((Object) this.f52271b) + ", monotonicClock=" + ((Object) this.f52272c) + ", backendName=" + this.f52273d + com.alipay.sdk.util.i.f4738d;
    }
}
