package za;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f55042a = d.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f55043b = false;

    public static void b() {
        if (e()) {
            f.e(f55042a, "checkUpgradeBks, execute check task");
            new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, b.a());
        }
    }

    public static boolean e() {
        if (f55043b) {
            return false;
        }
        Context a10 = b.a();
        if (a10 == null) {
            f.f(f55042a, "checkUpgradeBks, context is null");
            return false;
        }
        f55043b = true;
        long a11 = h.a("lastCheckTime", 0L, a10);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a11 > 432000000) {
            h.d("lastCheckTime", currentTimeMillis, a10);
            return true;
        }
        f.e(f55042a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = a.m(contextArr[0]);
        } catch (Exception e2) {
            f.d(f55042a, "doInBackground: exception : " + e2.getMessage());
            inputStream = null;
        }
        f.b(f55042a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            e.b(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            f.e(f55042a, "onPostExecute: upate done");
        } else {
            f.d(f55042a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        f.e(f55042a, "onProgressUpdate");
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        f.b(f55042a, "onPreExecute");
    }
}
