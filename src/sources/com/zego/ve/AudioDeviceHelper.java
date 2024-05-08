package com.zego.ve;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.alipay.sdk.packet.e;
import com.android.internal.os.PowerProfile;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AudioDeviceHelper {
    public static final int AUDIO_ROUTE_AIR_PLAY = 5;
    public static final int AUDIO_ROUTE_BLUETOOTH = 2;
    public static final int AUDIO_ROUTE_BLUETOOTH_A2DP = 6;
    public static final int AUDIO_ROUTE_CHECK_SCO = -100;
    public static final int AUDIO_ROUTE_HEADSET = 1;
    public static final int AUDIO_ROUTE_INVALID = -1;
    public static final int AUDIO_ROUTE_RECEIVER = 3;
    public static final int AUDIO_ROUTE_SPEAKER = 0;
    public static final int AUDIO_ROUTE_USB_AUDIO = 4;
    public static final int AUDIO_ROUTE_USB_HEADSET = 7;

    public static boolean DetectUsbDeviceState(Context context) {
        boolean z10 = false;
        try {
            Iterator<Map.Entry<String, UsbDevice>> iterator2 = ((UsbManager) context.getSystemService("usb")).getDeviceList().entrySet().iterator2();
            boolean z11 = false;
            while (iterator2.hasNext()) {
                try {
                    UsbDevice value = iterator2.next().getValue();
                    if (value != null) {
                        for (int i10 = 0; !z11 && i10 < value.getConfigurationCount(); i10++) {
                            UsbConfiguration configuration = value.getConfiguration(i10);
                            if (configuration != null) {
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= configuration.getInterfaceCount()) {
                                        break;
                                    }
                                    UsbInterface usbInterface = configuration.getInterface(i11);
                                    if (usbInterface != null && 1 == usbInterface.getInterfaceClass()) {
                                        z11 = true;
                                        break;
                                    }
                                    i11++;
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    z10 = z11;
                    th.printStackTrace();
                    return z10;
                }
            }
            return z11;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean HasUsbAudioDevice(Intent intent) {
        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(e.f4642n);
        if (usbDevice == null) {
            return false;
        }
        int configurationCount = usbDevice.getConfigurationCount();
        boolean z10 = false;
        for (int i10 = 0; !z10 && i10 < configurationCount; i10++) {
            UsbConfiguration configuration = usbDevice.getConfiguration(i10);
            if (configuration != null) {
                int interfaceCount = configuration.getInterfaceCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= interfaceCount) {
                        break;
                    }
                    UsbInterface usbInterface = configuration.getInterface(i11);
                    if (usbInterface != null && usbInterface.getInterfaceClass() == 1) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
        }
        return z10;
    }

    public static String RoutType2String(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 6 ? i10 != 7 ? "DEV_UNKNOWN" : "USB_HEADSET" : "BLUETOOTH_A2DP" : "USB_AUDIO" : "RECEIVER" : "BLUETOOTH_SCO" : "WIRED_HEADSET" : "SPEAKER";
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        if (r3 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
    
        r6 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a9, code lost:
    
        if (r3 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bc, code lost:
    
        if (r3 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c4, code lost:
    
        if (r3 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d3, code lost:
    
        if (r3 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011d, code lost:
    
        if (2 == r1.getProfileConnectionState(2)) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getCurrentRoute(android.content.Context r22, int r23) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioDeviceHelper.getCurrentRoute(android.content.Context, int):int");
    }

    public static String getDeviceTypeStr(int i10) {
        switch (i10) {
            case 1:
                return "BUILTIN_EARPIECE";
            case 2:
                return "BUILTIN_SPEAKER";
            case 3:
                return "WIRED_HEADSET";
            case 4:
                return "WIRED_HEADPHONES";
            case 5:
                return "LINE_ANALOG";
            case 6:
                return "LINE_DIGITAL";
            case 7:
                return "BLUETOOTH_SCO";
            case 8:
                return "BLUETOOTH_A2DP";
            case 9:
                return "HDMI";
            case 10:
                return "HDMI_ARC";
            case 11:
                return "USB_DEVICE";
            case 12:
                return "USB_ACCESSORY";
            case 13:
                return "DOCK";
            case 14:
                return "FM";
            case 15:
                return "BUILTIN_MIC";
            case 16:
                return "FM_TUNER";
            case 17:
                return "TV_TUNER";
            case 18:
                return "TELEPHONY";
            case 19:
                return "AUX_LINE";
            case 20:
                return "IP";
            case 21:
                return "BUS";
            case 22:
                return "USB_HEADSET";
            case 23:
                return "HEARING_AID";
            case 24:
                return "SPEAKER_SAFE";
            case 25:
                return "REMOTE_SUBMIX";
            case 26:
                return "BLE_HEADSET";
            default:
                return "UNKNOWN(" + i10 + ")";
        }
    }

    public static int getRouteType(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 != 2) {
            if (i10 == 3 || i10 == 4) {
                return 1;
            }
            if (i10 != 7) {
                if (i10 == 8) {
                    return 6;
                }
                if (i10 == 11 || i10 == 12) {
                    return 4;
                }
                if (i10 == 22) {
                    return 7;
                }
                switch (i10) {
                    case 25:
                        return -1;
                }
            }
            return 2;
        }
        return 0;
    }

    public static boolean scoConnect(Context context) {
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO)).getDevices(2)) {
            if (2 == getRouteType(audioDeviceInfo.getType())) {
                return true;
            }
        }
        return false;
    }
}
