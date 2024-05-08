package im.zego.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NetworkStateChangeReceiver34345 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public long f49890a;

    /* renamed from: b, reason: collision with root package name */
    public Context f49891b;

    /* renamed from: c, reason: collision with root package name */
    public int f49892c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f49893d = 0;

    public static native void onNetTypeChanged(long j10, int i10, String str);

    public final int a(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        if (type != 0) {
            if (type != 1) {
                return type != 9 ? 32 : 1;
            }
            return 2;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 3;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
            case 18:
                return 5;
            case 19:
            default:
                return 32;
            case 20:
                return 6;
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        int a10;
        Context context2 = this.f49891b;
        if (context2 == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        String str = "";
        if (activeNetworkInfo == null) {
            a10 = 0;
        } else {
            str = activeNetworkInfo.toString();
            a10 = a(activeNetworkInfo);
        }
        onNetTypeChanged(this.f49890a, a10, str);
    }
}
