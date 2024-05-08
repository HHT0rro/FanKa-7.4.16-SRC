package com.tencent.liteav.audio.route;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.media.AudioManager;
import android.os.Process;
import com.android.internal.os.PowerProfile;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f42729a;

    /* renamed from: b, reason: collision with root package name */
    public b f42730b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f42731c = false;

    /* renamed from: d, reason: collision with root package name */
    private final a f42732d;

    /* renamed from: e, reason: collision with root package name */
    private final c f42733e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        public void onBluetoothConnectionChanged(boolean z10) {
        }

        public void onBluetoothSCOConnected(boolean z10) {
        }

        public void onUsbConnectionChanged(boolean z10) {
        }

        public void onWiredHeadsetConnectionChanged(boolean z10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements BluetoothProfile.ServiceListener {

        /* renamed from: a, reason: collision with root package name */
        public final BluetoothAdapter f42734a;

        /* renamed from: b, reason: collision with root package name */
        public BluetoothProfile f42735b = null;

        /* renamed from: c, reason: collision with root package name */
        public final Object f42736c = new Object();

        /* renamed from: d, reason: collision with root package name */
        private final Context f42737d;

        /* renamed from: e, reason: collision with root package name */
        private AudioManager f42738e;

        public b(Context context) {
            this.f42737d = context;
            BluetoothAdapter c4 = c();
            this.f42734a = c4;
            if (c4 != null) {
                try {
                    c4.getProfileProxy(context, this, 1);
                } catch (Throwable th) {
                    Log.w("AudioSystemBroadcastReceiver", "getProfileProxy " + th.getMessage(), new Object[0]);
                }
            } else {
                Log.i("AudioSystemBroadcastReceiver", "bluetooth adapter is null", new Object[0]);
            }
            this.f42738e = (AudioManager) this.f42737d.getSystemService(PowerProfile.POWER_AUDIO);
        }

        private static BluetoothAdapter c() {
            try {
                return BluetoothAdapter.getDefaultAdapter();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "getDefaultAdapter exception " + th.getMessage(), new Object[0]);
                return null;
            }
        }

        private List<BluetoothDevice> d() {
            BluetoothProfile bluetoothProfile = this.f42735b;
            if (bluetoothProfile == null) {
                return null;
            }
            try {
                return bluetoothProfile.getConnectedDevices();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "getConnectedDevices exception " + th.getMessage(), new Object[0]);
                return null;
            }
        }

        private boolean e() {
            try {
                return this.f42734a.isEnabled();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "isEnabled exception " + th.getMessage(), new Object[0]);
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        
            if (r3.size() > 0) goto L32;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a() {
            /*
                r9 = this;
                android.bluetooth.BluetoothAdapter r0 = r9.f42734a
                r1 = 0
                if (r0 == 0) goto Lae
                boolean r0 = r9.e()
                if (r0 != 0) goto Ld
                goto Lae
            Ld:
                java.lang.Object r0 = r9.f42736c
                monitor-enter(r0)
                android.bluetooth.BluetoothProfile r2 = r9.f42735b     // Catch: java.lang.Throwable -> Lab
                if (r2 != 0) goto L40
                java.lang.String r2 = "AudioSystemBroadcastReceiver"
                java.lang.String r3 = "mBluetoothHeadsetProfile is null ,wait for 1000ms"
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.InterruptedException -> L25 java.lang.Throwable -> Lab
                com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch: java.lang.InterruptedException -> L25 java.lang.Throwable -> Lab
                java.lang.Object r2 = r9.f42736c     // Catch: java.lang.InterruptedException -> L25 java.lang.Throwable -> Lab
                r3 = 1000(0x3e8, double:4.94E-321)
                r2.wait(r3)     // Catch: java.lang.InterruptedException -> L25 java.lang.Throwable -> Lab
                goto L29
            L25:
                r2 = move-exception
                r2.printStackTrace()     // Catch: java.lang.Throwable -> Lab
            L29:
                android.bluetooth.BluetoothProfile r2 = r9.f42735b     // Catch: java.lang.Throwable -> Lab
                if (r2 != 0) goto L37
                java.lang.String r2 = "AudioSystemBroadcastReceiver"
                java.lang.String r3 = "mBluetoothHeadsetProfile is still null"
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lab
                com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch: java.lang.Throwable -> Lab
                goto L40
            L37:
                java.lang.String r2 = "AudioSystemBroadcastReceiver"
                java.lang.String r3 = "mBluetoothHeadsetProfile service is connected now"
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lab
                com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch: java.lang.Throwable -> Lab
            L40:
                r2 = 1
                int r3 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                r4 = 30
                if (r3 <= r4) goto L78
                android.media.AudioManager r3 = r9.f42738e     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                r4 = 2
                android.media.AudioDeviceInfo[] r3 = r3.getDevices(r4)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                int r4 = r3.length     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                r5 = 0
            L52:
                if (r5 >= r4) goto La9
                r6 = r3[r5]     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                int r7 = r6.getType()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                r8 = 8
                if (r7 == r8) goto L69
                int r6 = r6.getType()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                r7 = 7
                if (r6 != r7) goto L66
                goto L69
            L66:
                int r5 = r5 + 1
                goto L52
            L69:
                java.lang.String r3 = "AudioSystemBroadcastReceiver"
                java.lang.String r4 = "find bluetooth device"
                java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> Lab
                com.tencent.liteav.base.Log.i(r3, r4, r5)     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> Lab
            L72:
                r1 = 1
                goto La9
            L74:
                r3 = move-exception
                r2 = r3
                r3 = 1
                goto L8f
            L78:
                android.content.Context r3 = r9.f42737d     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                boolean r3 = com.tencent.liteav.audio.route.t.a(r3)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                if (r3 == 0) goto La9
                java.util.List r3 = r9.d()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                if (r3 == 0) goto La9
                int r3 = r3.size()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> Lab
                if (r3 <= 0) goto La9
                goto L72
            L8d:
                r2 = move-exception
                r3 = 0
            L8f:
                java.lang.String r4 = "AudioSystemBroadcastReceiver"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
                java.lang.String r6 = "get connected bluetooth devices failed."
                r5.<init>(r6)     // Catch: java.lang.Throwable -> Lab
                java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> Lab
                r5.append(r2)     // Catch: java.lang.Throwable -> Lab
                java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> Lab
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lab
                com.tencent.liteav.base.Log.e(r4, r2, r1)     // Catch: java.lang.Throwable -> Lab
                r1 = r3
            La9:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lab
                return r1
            Lab:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lab
                throw r1
            Lae:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.t.b.a():boolean");
        }

        public final void b() {
            try {
                this.f42734a.closeProfileProxy(1, this.f42735b);
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "closeProfileProxy exception " + th.getMessage(), new Object[0]);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
            BluetoothProfile bluetoothProfile2;
            if (i10 != 1) {
                return;
            }
            synchronized (this.f42736c) {
                if (this.f42734a != null && (bluetoothProfile2 = this.f42735b) != null) {
                    Log.i("AudioSystemBroadcastReceiver", "BluetoothHeadset proxy changed from %s to %s", bluetoothProfile2, bluetoothProfile);
                    b();
                    this.f42735b = null;
                }
                this.f42735b = bluetoothProfile;
                this.f42736c.notifyAll();
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int i10) {
            if (i10 != 1) {
                return;
            }
            synchronized (this.f42736c) {
                if (this.f42734a != null && this.f42735b != null) {
                    b();
                    this.f42735b = null;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void onSystemVolumeChanged();
    }

    public t(Context context, a aVar, c cVar) {
        this.f42729a = context;
        this.f42732d = aVar;
        this.f42733e = cVar;
    }

    private static String a(int i10) {
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

    public static boolean a(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        for (int i10 = 0; i10 < usbDevice.getInterfaceCount(); i10++) {
            try {
                if (usbDevice.getInterface(i10).getInterfaceClass() == 1) {
                    return true;
                }
            } catch (Throwable th) {
                Log.i("AudioSystemBroadcastReceiver", "Get interface exception " + th.getMessage(), new Object[0]);
            }
        }
        return false;
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
            Log.i("AudioSystemBroadcastReceiver", "receive Action: %s", action);
            switch (action.hashCode()) {
                case -2114103349:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1940635523:
                    if (action.equals(u.f32364ca)) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1608292967:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c4 = 5;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c4 = 6;
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
                case 3:
                    if (!this.f42731c) {
                        Log.i("AudioSystemBroadcastReceiver", "Do not enable usb device", new Object[0]);
                        return;
                    }
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(com.alipay.sdk.packet.e.f4642n);
                    if (usbDevice != null) {
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                            Log.i("AudioSystemBroadcastReceiver", "Usb device attached " + usbDevice.getProductName() + " manufacture " + usbDevice.getManufacturerName(), new Object[0]);
                        }
                        if (!a(usbDevice)) {
                            Log.i("AudioSystemBroadcastReceiver", "the attached usb device doesn't seem to support audio, ignore it", new Object[0]);
                            return;
                        }
                        if (intent.getAction() == "android.hardware.usb.action.USB_DEVICE_ATTACHED") {
                            this.f42732d.onUsbConnectionChanged(true);
                            return;
                        } else {
                            if (intent.getAction() == "android.hardware.usb.action.USB_DEVICE_DETACHED") {
                                this.f42732d.onUsbConnectionChanged(false);
                                return;
                            }
                            Log.i("AudioSystemBroadcastReceiver", "Unknown action, ignore it " + intent.getAction(), new Object[0]);
                            return;
                        }
                    }
                    return;
                case 1:
                    c cVar = this.f42733e;
                    if (cVar != null) {
                        cVar.onSystemVolumeChanged();
                        return;
                    }
                    return;
                case 2:
                    int a10 = a(intent, "state", -1);
                    if (a10 == -1) {
                        Log.e("AudioSystemBroadcastReceiver", "unknown headset state, ignore...", new Object[0]);
                        return;
                    } else {
                        this.f42732d.onWiredHeadsetConnectionChanged(a10 != 0);
                        return;
                    }
                case 4:
                    int a11 = a(intent, "android.bluetooth.adapter.extra.STATE", 0);
                    Log.i("AudioSystemBroadcastReceiver", "receive ACTION_STATE_CHANGED, EXTRA_STATE: %s, EXTRA_PREVIOUS_STATE: %s", a(a11), a(a(intent, "android.bluetooth.adapter.extra.PREVIOUS_STATE", 0)));
                    if (a11 == 10) {
                        this.f42732d.onBluetoothConnectionChanged(false);
                        return;
                    }
                    return;
                case 5:
                    int a12 = a(intent, "android.bluetooth.profile.extra.STATE", 10);
                    if (a12 == 12) {
                        Log.i("AudioSystemBroadcastReceiver", "receive bluetooth audio state changed to STATE_AUDIO_CONNECTED", new Object[0]);
                        this.f42732d.onBluetoothSCOConnected(true);
                        return;
                    } else {
                        if (a12 == 10) {
                            Log.i("AudioSystemBroadcastReceiver", "receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED", new Object[0]);
                            this.f42732d.onBluetoothSCOConnected(false);
                            return;
                        }
                        return;
                    }
                case 6:
                    int a13 = a(intent, "android.bluetooth.profile.extra.STATE", -1);
                    Object[] objArr = new Object[1];
                    objArr[0] = a13 != 0 ? a13 != 1 ? a13 != 2 ? a13 != 3 ? "unknown" : "STATE_DISCONNECTING" : "STATE_CONNECTED" : "STATE_CONNECTING" : "STATE_DISCONNECTED";
                    Log.i("AudioSystemBroadcastReceiver", "receive bluetooth headset connection state changed: %s", objArr);
                    if (a13 == 0) {
                        this.f42732d.onBluetoothConnectionChanged(false);
                        return;
                    } else {
                        if (a13 != 2) {
                            return;
                        }
                        this.f42732d.onBluetoothConnectionChanged(true);
                        return;
                    }
                default:
                    Log.w("AudioSystemBroadcastReceiver", "ignore unknown Action: %s", action);
                    return;
            }
        }
        Log.e("AudioSystemBroadcastReceiver", "onReceive intent or context is null!", new Object[0]);
    }

    private static int a(Intent intent, String str, int i10) {
        try {
            return intent.getIntExtra(str, i10);
        } catch (Exception e2) {
            LiteavLog.e("AudioSystemBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e2)));
            return i10;
        }
    }

    public static boolean a(Context context) {
        return context == null || LiteavSystemInfo.getSystemOSVersionInt() < 31 || context.checkPermission("android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) == 0;
    }
}
