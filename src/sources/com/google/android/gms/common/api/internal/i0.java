package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
@WorkerThread
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface i0 {
    void b(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set);

    void c(ConnectionResult connectionResult);
}
