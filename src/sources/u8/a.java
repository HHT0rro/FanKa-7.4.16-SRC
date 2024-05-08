package u8;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.R$string;
import y8.d;
import y8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: u8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class RunnableC0828a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f54005b;

        public RunnableC0828a(Context context) {
            this.f54005b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b(this.f54005b)) {
                return;
            }
            String string = this.f54005b.getString(R$string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = "System Default Channel";
            }
            d.a(this.f54005b, a.this.b(this.f54005b, "Heytap PUSH", string, 3));
        }
    }

    public void a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        f.a(new RunnableC0828a(context));
    }

    public final boolean b(Context context, String str, String str2, int i10) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i10));
        return true;
    }
}
