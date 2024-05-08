package p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f52724a = new String[3];

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f52725b;

    public static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void b(Context context) {
        int[] iArr = {-1721342362, 1903654775, 1903654776};
        String c4 = c(context);
        if (TextUtils.isEmpty(c4)) {
            f52724a = new String[]{"", "", ""};
        }
        File file = new File(c4);
        String[] c10 = d.c(file, iArr);
        if (c10 == null) {
            c10 = f52724a;
        }
        f52724a = c10;
        if (c10.length >= 2 && TextUtils.isEmpty(c10[0]) && TextUtils.isEmpty(f52724a[1])) {
            String a10 = q0.a.a(file);
            String[] strArr = f52724a;
            if (a10 == null) {
                a10 = "";
            }
            strArr[0] = a10;
        }
        String[] strArr2 = f52724a;
        if (strArr2.length < 3 || TextUtils.isEmpty(strArr2[2])) {
            return;
        }
        int length = f52724a[2].length();
        if (length <= 4) {
            f52724a[2] = "";
        } else {
            String[] strArr3 = f52724a;
            strArr3[2] = strArr3[2].substring(2, length - 2);
        }
    }

    public static String c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        if (!f52725b) {
            b(context);
            f52725b = true;
        }
        Map<String, String> a10 = a(e(context));
        String str = (a10 == null || a10.size() <= 0) ? "" : a10.get("hume_channel_id");
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String e(Context context) {
        if (!f52725b) {
            b(context);
            f52725b = true;
        }
        return !TextUtils.isEmpty(f52724a[0]) ? f52724a[0] : !TextUtils.isEmpty(f52724a[1]) ? f52724a[1] : "";
    }
}
