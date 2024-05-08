package cn.shuzilm.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class k implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            System.loadLibrary("du");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
