package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r extends RemoteCreator<zam> {

    /* renamed from: c, reason: collision with root package name */
    public static final r f23693c = new r();

    public r() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i10, int i11) throws RemoteCreator.RemoteCreatorException {
        return f23693c.d(context, i10, i11);
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zam a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zam) {
            return (zam) queryLocalInterface;
        }
        return new zal(iBinder);
    }

    public final View d(Context context, int i10, int i11) throws RemoteCreator.RemoteCreatorException {
        try {
            zau zauVar = new zau(i10, i11, null);
            return (View) ObjectWrapper.unwrap(b(context).zaa(ObjectWrapper.wrap(context), zauVar));
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("Could not get button with size ");
            sb2.append(i10);
            sb2.append(" and color ");
            sb2.append(i11);
            throw new RemoteCreator.RemoteCreatorException(sb2.toString(), e2);
        }
    }
}
