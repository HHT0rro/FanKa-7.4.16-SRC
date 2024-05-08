package com.mobile.auth.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f36769a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    public static String a() {
        String hostAddress;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    String name = nextElement.getName();
                    if (name == null || (!name.contains("wlan") && !name.equals("eth0"))) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && (hostAddress = nextElement2.getHostAddress()) != null && f36769a.matcher(hostAddress).matches()) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(",");
                                }
                                stringBuffer.append(hostAddress);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
                return null;
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
                return null;
            }
        }
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pipl", a());
            hashMap.put("timeStamp", Long.toString(System.currentTimeMillis()));
            hashMap.put("rl", "00000");
            hashMap.put("bussinessType", str3);
            hashMap.put("sdkversion", "SDK-JJ-v3.7.4");
            hashMap.put(ConfigBean.Field.NETWORK_TYPE, f.f(context));
            hashMap.put("onlineType", f.g(context));
            hashMap.put("aip", context.getPackageName());
            return a(str, str2, hashMap, str4);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static String a(String str, String str2, Map<String, String> map, String str3) {
        try {
            String a10 = com.mobile.auth.b.d.a(str3, com.mobile.auth.b.d.a());
            String a11 = com.mobile.auth.b.a.a(a(map, "&"), str3);
            HashMap hashMap = new HashMap();
            hashMap.put("appId", str);
            hashMap.put(aq.D, "30020");
            hashMap.put("format", "json");
            hashMap.put("paramKey", a10);
            hashMap.put("paramStr", a11);
            hashMap.put("version", "3.0");
            hashMap.put(CardUriUtils.PARAM_SIGN, b(hashMap, str2));
            return a(hashMap, "&");
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static String a(Map<String, String> map, String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                if (TextUtils.isEmpty(str)) {
                    str = "&";
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                    sb2.append(str);
                }
                sb2 = sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static String b(Map<String, String> map, String str) {
        try {
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.mobile.auth.d.g.1
                public int a(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    try {
                        return entry.getKey().compareTo(entry2.getKey());
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                            return -1;
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                            return -1;
                        }
                    }
                }

                @Override // java.util.Comparator
                public /* synthetic */ int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    try {
                        return a(entry, entry2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                            return -1;
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                            return -1;
                        }
                    }
                }
            });
            String str2 = "";
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                str2 = str2 + ((String) ((Map.Entry) iterator2.next()).getValue());
            }
            return com.mobile.auth.b.c.b(com.mobile.auth.b.c.a(str2, str));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
