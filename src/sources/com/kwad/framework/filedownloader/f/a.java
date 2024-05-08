package com.kwad.framework.filedownloader.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private static void a(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean bd(int i10) {
        a("request pause the task[%d] in the download service", Integer.valueOf(i10));
        return false;
    }

    public static byte be(int i10) {
        a("request get the status for the task[%d] in the download service", Integer.valueOf(i10));
        return (byte) 0;
    }

    public static boolean bf(int i10) {
        a("request clear the task[%d] data in the database", Integer.valueOf(i10));
        return false;
    }

    public static boolean h(String str, String str2, boolean z10) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z10));
        return false;
    }
}
