package f1;

import android.os.Build;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeviceInfoUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f49107a = new a();

    @NotNull
    public final String a() {
        return Build.VERSION.SDK_INT >= 23 ? b() : "";
    }

    public final String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            s.h(networkInterfaces, "getNetworkInterfaces()");
            ArrayList<NetworkInterface> list = Collections.list(networkInterfaces);
            s.h(list, "list(this)");
            for (NetworkInterface networkInterface : list) {
                if (p.r(networkInterface.getName(), "wlan0", true)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b4 : hardwareAddress) {
                        y yVar = y.f51038a;
                        String format = String.format("%02x:", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
                        s.h(format, "format(format, *args)");
                        sb2.append(format);
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    String sb3 = sb2.toString();
                    s.h(sb3, "sb.toString()");
                    return sb3;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }
}
