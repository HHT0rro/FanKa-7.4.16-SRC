package n8;

import android.graphics.Bitmap;
import android.media.Image;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.internal.e f52168a = new com.google.android.gms.common.internal.e("MLKitImageUtils", "");

    /* renamed from: b, reason: collision with root package name */
    public static d f52169b = new d();

    @RecentlyNonNull
    public static d b() {
        return f52169b;
    }

    @RecentlyNonNull
    public IObjectWrapper a(@RecentlyNonNull m8.a aVar) throws MlKitException {
        int d10 = aVar.d();
        if (d10 != -1) {
            if (d10 != 17) {
                if (d10 == 35) {
                    return ObjectWrapper.wrap(aVar.f());
                }
                if (d10 != 842094169) {
                    int d11 = aVar.d();
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Unsupported image format: ");
                    sb2.append(d11);
                    throw new MlKitException(sb2.toString(), 3);
                }
            }
            return ObjectWrapper.wrap((ByteBuffer) com.google.android.gms.common.internal.h.h(aVar.c()));
        }
        return ObjectWrapper.wrap((Bitmap) com.google.android.gms.common.internal.h.h(aVar.b()));
    }

    public int c(@RecentlyNonNull m8.a aVar) {
        return aVar.d();
    }

    public int d(@RecentlyNonNull m8.a aVar) {
        if (aVar.d() == -1) {
            return ((Bitmap) com.google.android.gms.common.internal.h.h(aVar.b())).getAllocationByteCount();
        }
        if (aVar.d() != 17 && aVar.d() != 842094169) {
            if (aVar.d() != 35) {
                return 0;
            }
            return (((Image.Plane[]) com.google.android.gms.common.internal.h.h(aVar.g()))[0].getBuffer().limit() * 3) / 2;
        }
        return ((ByteBuffer) com.google.android.gms.common.internal.h.h(aVar.c())).limit();
    }
}
