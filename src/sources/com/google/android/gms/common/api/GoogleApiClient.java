package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.zack;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class GoogleApiClient {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<GoogleApiClient> f23375a = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a extends f {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b extends k {
    }

    @RecentlyNonNull
    public Looper a() {
        throw new UnsupportedOperationException();
    }

    public void b(zack zackVar) {
        throw new UnsupportedOperationException();
    }

    public void c(zack zackVar) {
        throw new UnsupportedOperationException();
    }
}
