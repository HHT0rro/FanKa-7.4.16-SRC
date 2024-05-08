package cn.shuzilm.core;

import android.content.Context;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1771a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Listener f1772b;

    public l(Context context, Listener listener) {
        this.f1771a = context;
        this.f1772b = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        dl.ia(this.f1771a);
        if (this.f1772b != null) {
            String c4 = DUHelper.c(this.f1771a, 301, (String) null);
            if (c4 == null) {
                this.f1772b.handler("");
            } else {
                try {
                    c4 = c4.replace('+', '-').replace(IOUtils.DIR_SEPARATOR_UNIX, '_').replace("=", "");
                } catch (Exception unused) {
                }
                this.f1772b.handler(c4);
            }
        }
    }
}
