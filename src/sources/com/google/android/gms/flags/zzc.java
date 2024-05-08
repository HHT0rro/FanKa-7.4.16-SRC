package com.google.android.gms.flags;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zzc extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z10, int i10) throws RemoteException;

    int getIntFlagValue(String str, int i10, int i11) throws RemoteException;

    long getLongFlagValue(String str, long j10, int i10) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i10) throws RemoteException;

    void init(IObjectWrapper iObjectWrapper) throws RemoteException;
}
