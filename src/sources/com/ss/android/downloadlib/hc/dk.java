package com.ss.android.downloadlib.hc;

import android.os.AsyncTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {

    /* renamed from: m, reason: collision with root package name */
    public static final m f38767m = new C0579dk();

    /* renamed from: com.ss.android.downloadlib.hc.dk$dk, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0579dk extends m {
        private C0579dk() {
            super();
        }

        @Override // com.ss.android.downloadlib.hc.dk.m
        public <T> void m(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        private m() {
        }

        public <T> void m(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void m(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f38767m.m(asyncTask, tArr);
    }
}
