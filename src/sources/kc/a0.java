package kc;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hu;
import com.xiaomi.push.j7;
import com.xiaomi.push.m0;
import com.xiaomi.push.o6;
import com.xiaomi.push.p0;
import com.xiaomi.push.s7;
import com.xiaomi.push.w5;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f50775a = new Object();

    public static void a(Context context, hu huVar) {
        if (z.e(huVar.e())) {
            com.xiaomi.push.n.c(context).g(new b0(context, huVar));
        }
    }

    public static byte[] b(Context context) {
        String d10 = j7.b(context).d("mipush", "td_key", "");
        if (TextUtils.isEmpty(d10)) {
            d10 = p0.a(20);
            j7.b(context).e("mipush", "td_key", d10);
        }
        return c(d10);
    }

    public static byte[] c(String str) {
        byte[] copyOf = Arrays.copyOf(m0.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void e(Context context, hu huVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        ?? b4 = b(context);
        try {
            try {
                byte[] c4 = w5.c(b4, o6.c(huVar));
                if (c4 != null && c4.length >= 1) {
                    if (c4.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + huVar.d() + "  ts:" + System.currentTimeMillis();
                        fc.c.i(str2);
                        s7.b(null);
                        s7.b(null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.f.b(c4.length));
                        bufferedOutputStream3.write(c4);
                        bufferedOutputStream3.flush();
                        s7.b(null);
                        s7.b(bufferedOutputStream3);
                        return;
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file failed cause io exception item:" + huVar.d();
                        b4 = bufferedOutputStream2;
                        fc.c.j(str, e);
                        s7.b(null);
                        s7.b(b4);
                        return;
                    } catch (Exception e10) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e10;
                        str = "TinyData write to cache file  failed item:" + huVar.d();
                        b4 = bufferedOutputStream;
                        fc.c.j(str, e);
                        s7.b(null);
                        s7.b(b4);
                        return;
                    } catch (Throwable th) {
                        b4 = bufferedOutputStream3;
                        th = th;
                        s7.b(null);
                        s7.b(b4);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + huVar.d() + "  ts:" + System.currentTimeMillis();
                fc.c.i(str2);
                s7.b(null);
                s7.b(null);
            } catch (IOException e11) {
                e = e11;
                bufferedOutputStream2 = null;
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                b4 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
