package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f21134b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<Requirements> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Requirements[] newArray(int i10) {
            return new Requirements[i10];
        }
    }

    public Requirements(int i10) {
        this.f21134b = (i10 & 2) != 0 ? i10 | 1 : i10;
    }

    public static boolean h(ConnectivityManager connectivityManager) {
        if (j0.f22990a < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException unused) {
            return true;
        }
    }

    public final int a(Context context) {
        if (!i()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && h(connectivityManager)) {
            return (l() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0;
        }
        return this.f21134b & 3;
    }

    public int b(Context context) {
        int a10 = a(context);
        if (d() && !e(context)) {
            a10 |= 8;
        }
        if (g() && !f(context)) {
            a10 |= 4;
        }
        return (!k() || j(context)) ? a10 : a10 | 16;
    }

    public int c() {
        return this.f21134b;
    }

    public boolean d() {
        return (this.f21134b & 8) != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.f21134b == ((Requirements) obj).f21134b;
    }

    public final boolean f(Context context) {
        PowerManager powerManager = (PowerManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("power"));
        int i10 = j0.f22990a;
        if (i10 >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (i10 >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
        } else if (!powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return (this.f21134b & 4) != 0;
    }

    public int hashCode() {
        return this.f21134b;
    }

    public boolean i() {
        return (this.f21134b & 1) != 0;
    }

    public final boolean j(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public boolean k() {
        return (this.f21134b & 16) != 0;
    }

    public boolean l() {
        return (this.f21134b & 2) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21134b);
    }
}
