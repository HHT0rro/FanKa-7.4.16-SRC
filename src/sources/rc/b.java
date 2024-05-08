package rc;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LogUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f53376a;

    public static void a(String str, String str2) {
        if (f53376a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("] ");
            sb2.append(str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f53376a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("] ");
            sb2.append(str2);
        }
    }

    public static void c(String str, Map<String, Object> map) {
        if (f53376a) {
            new JSONObject(map);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("] ");
            sb2.append(new JSONObject(map).toString());
        }
    }

    public static void d(String str, String... strArr) {
        if (f53376a) {
            e(str, strArr);
        }
    }

    public static String e(String str, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }
}
