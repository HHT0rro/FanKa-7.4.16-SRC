package com.huawei.jmessage;

import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: IntentFilterUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32018a = "IntentFilterUtils";

    @NonNull
    public static String a(@NonNull IntentFilter intentFilter) {
        return a(a((Parcelable) intentFilter));
    }

    @NonNull
    private static String a(@NonNull byte[] bArr) {
        try {
            return g.a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            Log.e(f32018a, "NoSuchAlgorithmException when getting SHA-256.", e2);
            return "";
        }
    }

    @NonNull
    private static byte[] a(@NonNull Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
