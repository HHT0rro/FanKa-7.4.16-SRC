package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0217a a(Context context, String str, DynamiteModule.a.b bVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.C0217a c0217a = new DynamiteModule.a.C0217a();
        int b4 = bVar.b(context, str);
        c0217a.f23779a = b4;
        if (b4 != 0) {
            c0217a.f23780b = bVar.a(context, str, false);
        } else {
            c0217a.f23780b = bVar.a(context, str, true);
        }
        int i10 = c0217a.f23779a;
        if (i10 == 0 && c0217a.f23780b == 0) {
            c0217a.f23781c = 0;
        } else if (i10 >= c0217a.f23780b) {
            c0217a.f23781c = -1;
        } else {
            c0217a.f23781c = 1;
        }
        return c0217a;
    }
}
