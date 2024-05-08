package ac;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f761a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static int f762b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f763c = 0;

    public static String a() {
        return i.i();
    }

    public static String b(int i10) {
        return h.a(i10);
    }

    public static String c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
    }

    public static String d(Context context, String str) {
        try {
            return n(p(context, str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(Context context, String str, String str2) {
        try {
            return i(p(context, str), str2.toLowerCase());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i10 = 0; i10 < digest.length; i10++) {
                int i11 = digest[i10];
                if (i11 < 0) {
                    i11 += 256;
                }
                if (i11 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i11));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String g(String str, String str2, String str3) {
        return r.c(str, str2, str3);
    }

    public static String h(byte[] bArr) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (i10 != 0) {
                str = str + com.huawei.openalliance.ad.constant.u.bD;
            }
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String i(byte[] bArr, String str) {
        try {
            return h(MessageDigest.getInstance(str).digest(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean j(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static int k(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            h.g("android Build.VERSION:" + Build.VERSION.SDK_INT);
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (activeNetworkInfo.getType() == 1) {
                if (j(connectivityManager)) {
                    h.g("Data and WIFI");
                    return 1;
                }
                h.g("Only WIFI");
                return 2;
            }
            if (activeNetworkInfo.getType() == 0) {
                h.g("Only Data");
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo)) {
                    return 0;
                }
                i.j(extraInfo);
                i.c(i.l(extraInfo));
                return 0;
            }
            return -1;
        }
        return -1;
    }

    public static String l(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i10 = 0; i10 < digest.length; i10++) {
                int i11 = digest[i10];
                if (i11 < 0) {
                    i11 += 256;
                }
                if (i11 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i11));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String m(String str, String str2, String str3) {
        return r.b(str, str2, str3);
    }

    public static String n(byte[] bArr) {
        try {
            SM3Digest sM3Digest = new SM3Digest();
            sM3Digest.update(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
            sM3Digest.doFinal(bArr2, 0);
            return h(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void o() {
        h.b();
    }

    public static byte[] p(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo.packageName.equals(str)) {
                return packageInfo.signatures[0].toByteArray();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int q() {
        f763c = 0;
        f762b = 1;
        return 1;
    }

    public static String r(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String s(String str) {
        SM3Digest sM3Digest = new SM3Digest();
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        sM3Digest.update(bytes, 0, bytes.length);
        byte[] bArr = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr, 0);
        return w.a(bArr);
    }

    public static int t() {
        return f762b;
    }

    public static int u() {
        return f763c;
    }

    public static void v(String str) {
        h.c(0, str);
    }

    public static int w() {
        int i10 = f763c;
        if (i10 < 0 || i10 > f762b) {
            return f762b;
        }
        int i11 = i10 + 1;
        f763c = i11;
        return i11;
    }

    public static String x() {
        int i10;
        String str = i.f752a;
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isVirtual() && nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && !nextElement2.isMulticastAddress() && !nextElement2.isAnyLocalAddress()) {
                            if (nextElement2 instanceof Inet4Address) {
                                hashSet.add(nextElement2.getHostAddress());
                            }
                            if (nextElement2 instanceof Inet6Address) {
                                String hostAddress = nextElement2.getHostAddress();
                                if (hostAddress.contains("%")) {
                                    hostAddress = hostAddress.substring(0, hostAddress.indexOf("%"));
                                }
                                hashSet2.add(hostAddress);
                            }
                        }
                    }
                }
            }
            if (hashSet.size() > 0) {
                Object[] array = hashSet.toArray();
                int min = Math.min(array.length, 5);
                for (int i11 = 0; i11 < min; i11++) {
                    sb2.append((String) array[i11]);
                    if (i11 < min - 1) {
                        sb2.append("-");
                    }
                }
                "&private_ip=".concat(String.valueOf(sb2));
                jSONObject.put("privateIp", sb2.toString());
            }
            if (hashSet2.size() > 0) {
                Object[] array2 = hashSet2.toArray();
                int min2 = Math.min(array2.length, 5);
                for (i10 = 0; i10 < min2; i10++) {
                    sb3.append((String) array2[i10]);
                    if (i10 < min2 - 1) {
                        sb3.append("-");
                    }
                }
                "&private_ip_v6=".concat(String.valueOf(sb3));
                jSONObject.put("privateIp_v6", sb3.toString());
            }
            if (sb2.length() != 0) {
                return jSONObject.toString();
            }
        } catch (Exception unused) {
        }
        return "{\"privateIp\":\"0.0.0.0\"}";
    }
}
