package kc;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.f6;
import com.xiaomi.push.g3;
import com.xiaomi.push.s7;
import com.xiaomi.push.t1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f50780a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: b, reason: collision with root package name */
    public static long f50781b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static ThreadPoolExecutor f50782c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb3 = sb2.toString();
                    s7.b(bufferedReader);
                    return sb3;
                }
                sb2.append("\n");
                sb2.append(readLine);
            }
        } catch (Exception unused2) {
            s7.b(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            s7.b(bufferedReader);
            throw th;
        }
    }

    public static void b() {
        g3 c4;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f50782c.getActiveCount() <= 0 || currentTimeMillis - f50781b >= 1800000) && f6.f().k() && (c4 = x.h().c()) != null && c4.y() > 0) {
            f50781b = currentTimeMillis;
            c(c4.o(), true);
        }
    }

    public static void c(List<String> list, boolean z10) {
        f50782c.execute(new d(list, z10));
    }

    public static void e() {
        String a10 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a10)) {
            fc.c.i("dump tcp for uid = " + Process.myUid());
            fc.c.i(a10);
        }
        String a11 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a11)) {
            return;
        }
        fc.c.i("dump tcp6 for uid = " + Process.myUid());
        fc.c.i(a11);
    }

    public static boolean f(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            fc.c.i("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(t1.d(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            fc.c.i("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            fc.c.n("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
