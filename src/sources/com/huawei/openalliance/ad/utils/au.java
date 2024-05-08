package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.bq;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class au {
    private static final String Code = "StrUtil";
    private static final int I = 100;
    private static final String V = "^[0-9\\*\\+\\-\\.]*$";

    public static boolean B(String str) {
        return str != null && (str.startsWith(bq.HTTP.toString()) || str.startsWith(bq.HTTPS.toString()));
    }

    public static String C(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? L(str) : a(str);
    }

    public static int Code(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            gl.I(Code, "parseIntOrDefault exception: " + e2.getClass().getSimpleName());
            return i10;
        }
    }

    public static long Code(String str, long j10) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            gl.I(Code, "parseIntOrDefault exception: " + e2.getClass().getSimpleName());
            return j10;
        }
    }

    private static String Code(long j10) {
        float f10 = (((float) j10) * 1.0f) / 1048576.0f;
        if (f10 < 0.1f) {
            f10 = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f10));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            java.lang.String r0 = "getChinaString "
            java.lang.String r1 = "StrUtil"
            android.content.res.Resources r2 = r5.getResources()
            r3 = 0
            com.huawei.hms.ads.el r4 = com.huawei.hms.ads.ea.Code(r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            boolean r4 = r4.Code()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            if (r4 == 0) goto L5d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            r4.<init>()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            r4.append(r7)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r7 = "_zh"
            r4.append(r7)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r4 = "string"
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            int r5 = r2.getIdentifier(r7, r4, r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            if (r8 == 0) goto L35
            java.lang.String r5 = r2.getString(r5, r8)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            goto L39
        L35:
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
        L39:
            r3 = r5
            goto L5d
        L3b:
            r5 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L48
        L42:
            r5 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L48:
            r7.append(r0)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.huawei.hms.ads.gl.Z(r1, r5)
        L5d:
            if (r3 != 0) goto L6d
            if (r8 == 0) goto L69
            int r5 = r8.length
            if (r5 <= 0) goto L69
            java.lang.String r3 = r2.getString(r6, r8)
            goto L6d
        L69:
            java.lang.String r3 = r2.getString(r6)
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.au.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j10) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j10));
    }

    public static String Code(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return V(bundle).toString();
    }

    public static String Code(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static String Code(String str, Context context) {
        BufferedReader bufferedReader;
        Object th;
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        StringBuilder sb2 = new StringBuilder();
        try {
            inputStream = assets.open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append("\n");
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            gl.I(Code, "getStringFromAsset " + th.getClass().getSimpleName());
                            return sb2.toString();
                        } finally {
                            at.Code(bufferedReader);
                            at.Code((Closeable) inputStream);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStream = null;
        }
        return sb2.toString();
    }

    public static String Code(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            boolean z10 = true;
            for (String str2 : list) {
                if (!z10) {
                    sb2.append(str);
                }
                sb2.append(str2);
                z10 = false;
            }
        }
        return sb2.toString();
    }

    public static boolean Code(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean Code(Set<String> set, String str) {
        if (!aa.Code(set) && !TextUtils.isEmpty(str)) {
            return set.contains(str);
        }
        gl.Code(Code, "ModelList or ModelName is empty");
        return true;
    }

    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(V, str) && str.length() < 100;
    }

    public static Integer F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e2) {
            gl.Z(Code, "toInteger NumberFormatException:" + e2.getClass().getSimpleName());
            return null;
        }
    }

    public static Long I(String str) {
        if (Code(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e2) {
            gl.Z(Code, "toLong NumberFormatException:" + e2.getClass().getSimpleName());
            return null;
        }
    }

    private static Object I(Object obj) {
        if (obj instanceof Bundle) {
            return V((Bundle) obj);
        }
        try {
            return JSONObject.wrap(obj);
        } catch (Throwable th) {
            gl.I(Code, "wrap Exception:" + th.getClass().getSimpleName());
            return JSONObject.NULL;
        }
    }

    private static String L(String str) {
        StringBuilder sb2 = new StringBuilder();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append("://");
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = parse.getHost();
        } else {
            sb2.append("******");
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                sb2.append((CharSequence) lastPathSegment, 0, 3);
            } else if (length > 1) {
                sb2.append((CharSequence) lastPathSegment, 0, length - 1);
            }
        }
        sb2.append("******");
        return sb2.toString();
    }

    public static String S(String str) {
        if (Code(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            gl.Z(Code, "unsupport encoding");
            return null;
        }
    }

    public static String V(Object obj) {
        return obj == null ? "null" : "not null";
    }

    public static String V(String str) {
        String str2;
        if (Code(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "unsupport encoding";
            gl.Z(Code, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "decode error";
            gl.Z(Code, str2);
            return null;
        }
    }

    public static JSONObject V(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        Set<String> keySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            try {
                jSONObject.put(str, I(bundle.get(str)));
            } catch (Throwable th) {
                gl.I(Code, "converBundleToJson Exception:" + th.getClass().getSimpleName());
            }
        }
        return jSONObject;
    }

    public static String Z(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "\\\"");
    }

    private static String a(String str) {
        int i10;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0 && (i10 = lastIndexOf + 1) < str.length()) {
            str = str.substring(i10);
        }
        int length = str.length();
        if (length > 3) {
            return str.substring(0, 3) + "******";
        }
        if (length <= 1) {
            return "******";
        }
        return str.substring(0, length - 1) + "******";
    }
}
