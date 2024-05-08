package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class cPR64 extends RYhXO {

    /* renamed from: b, reason: collision with root package name */
    public static final String f45754b = kC0XR.a(kC0XR.f45847i);

    @Override // com.tencent.turingface.sdk.mfa.RYhXO
    public final String a(IBinder iBinder) throws Exception {
        Context context;
        Signature[] signatureArr;
        synchronized (i3cNc.class) {
            context = i3cNc.f45809a;
        }
        String packageName = context.getPackageName();
        String str = null;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Throwable unused) {
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b4 : digest) {
                        sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                    }
                    str = sb2.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String a10 = kC0XR.a(kC0XR.f45849j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f45754b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a10);
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
