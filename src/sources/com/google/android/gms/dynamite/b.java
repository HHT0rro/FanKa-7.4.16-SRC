package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements DynamiteModule.a.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
    public final int a(Context context, String str, boolean z10) throws DynamiteModule.LoadingException {
        return DynamiteModule.d(context, str, z10);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
    public final int b(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
