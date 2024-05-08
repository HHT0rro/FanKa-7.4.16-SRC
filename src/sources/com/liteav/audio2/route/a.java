package com.liteav.audio2.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.liteav.base.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0555a f36666a;

    /* renamed from: com.liteav.audio2.route.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0555a {
        void a(boolean z10);

        void b(boolean z10);

        void c(boolean z10);

        void onSystemVolumeChanged();
    }

    public static int a(Intent intent, String str, int i10) {
        try {
            return intent.getIntExtra(str, i10);
        } catch (Exception e2) {
            Log.e("AudioEventBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e2)), new Object[0]);
            return i10;
        }
    }

    public static String b(int i10) {
        switch (i10) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return "unknown";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c4;
        if (intent != null && context != null) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            Log.i("AudioEventBroadcastReceiver", "Receive Action:".concat(action), new Object[0]);
            switch (action.hashCode()) {
                case -1940635523:
                    if (action.equals(u.f32364ca)) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    InterfaceC0555a interfaceC0555a = this.f36666a;
                    if (interfaceC0555a != null) {
                        interfaceC0555a.onSystemVolumeChanged();
                        return;
                    }
                    return;
                case 1:
                    int a10 = a(intent, "state", -1);
                    if (a10 == -1) {
                        Log.e("AudioEventBroadcastReceiver", "Unknown headset state, ignore...", new Object[0]);
                        return;
                    } else {
                        this.f36666a.a(a10 != 0);
                        return;
                    }
                case 2:
                    int a11 = a(intent, "android.bluetooth.adapter.extra.STATE", 0);
                    Log.i("AudioEventBroadcastReceiver", "Receive ACTION_STATE_CHANGED, EXTRA_STATE:" + b(a11) + " EXTRA_PREVIOUS_STATE: " + b(a(intent, "android.bluetooth.adapter.extra.PREVIOUS_STATE", 0)), new Object[0]);
                    if (a11 == 10) {
                        this.f36666a.c(false);
                        return;
                    }
                    return;
                case 3:
                    int a12 = a(intent, "android.bluetooth.profile.extra.STATE", 10);
                    if (a12 == 12) {
                        Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_CONNECTED", new Object[0]);
                        this.f36666a.b(true);
                        return;
                    } else {
                        if (a12 == 10) {
                            Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED", new Object[0]);
                            this.f36666a.b(false);
                            return;
                        }
                        return;
                    }
                case 4:
                    int a13 = a(intent, "android.bluetooth.profile.extra.STATE", -1);
                    Object[] objArr = new Object[1];
                    objArr[0] = a13 != 0 ? a13 != 1 ? a13 != 2 ? a13 != 3 ? "unknown" : "STATE_DISCONNECTING" : "STATE_CONNECTED" : "STATE_CONNECTING" : "STATE_DISCONNECTED";
                    Log.i("AudioEventBroadcastReceiver", "Receive bluetooth headset connection state changed: %s", objArr);
                    if (a13 == 0) {
                        this.f36666a.c(false);
                        return;
                    } else {
                        if (a13 != 2) {
                            return;
                        }
                        this.f36666a.c(true);
                        return;
                    }
                default:
                    Log.w("AudioEventBroadcastReceiver", "Ignore unknown Action:".concat(action), new Object[0]);
                    return;
            }
        }
        Log.e("AudioEventBroadcastReceiver", "Receive intent or context is null", new Object[0]);
    }
}
