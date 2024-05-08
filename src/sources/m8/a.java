package m8;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.mlkit_vision_common.b7;
import com.google.android.gms.internal.mlkit_vision_common.d7;
import com.google.mlkit.common.sdkinternal.h;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public volatile Bitmap f51939a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile ByteBuffer f51940b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51941c;

    /* renamed from: d, reason: collision with root package name */
    public final int f51942d;

    /* renamed from: e, reason: collision with root package name */
    public final int f51943e;

    /* renamed from: f, reason: collision with root package name */
    public final int f51944f = -1;

    public a(@NonNull Bitmap bitmap, int i10) {
        this.f51939a = (Bitmap) com.google.android.gms.common.internal.h.h(bitmap);
        this.f51941c = bitmap.getWidth();
        this.f51942d = bitmap.getHeight();
        this.f51943e = i10;
    }

    @NonNull
    public static a a(@RecentlyNonNull Bitmap bitmap, int i10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a aVar = new a(bitmap, i10);
        j(-1, 1, elapsedRealtime, bitmap.getHeight(), bitmap.getWidth(), bitmap.getAllocationByteCount(), i10);
        return aVar;
    }

    public static void j(int i10, int i11, long j10, int i12, int i13, int i14, int i15) {
        d7.a(b7.a("vision-common"), i10, i11, j10, i12, i13, i14, i15);
    }

    @RecentlyNullable
    public Bitmap b() {
        return this.f51939a;
    }

    @RecentlyNullable
    public ByteBuffer c() {
        return this.f51940b;
    }

    public int d() {
        return this.f51944f;
    }

    public int e() {
        return this.f51942d;
    }

    @RecentlyNullable
    @RequiresApi(19)
    public Image f() {
        return null;
    }

    @RecentlyNullable
    @RequiresApi(19)
    public Image.Plane[] g() {
        return null;
    }

    public int h() {
        return this.f51943e;
    }

    public int i() {
        return this.f51941c;
    }
}
