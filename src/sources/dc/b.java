package dc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.inno.innosdk.pb.InnoMain;
import com.weibo.ssosdk.oaid.interfaces.HWIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f48668a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f48669b = new LinkedBlockingQueue<>(1);

    /* renamed from: c, reason: collision with root package name */
    public ServiceConnection f48670c = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                try {
                    String iDs = new HWIDInterface.HWID(iBinder).getIDs();
                    if (!TextUtils.isEmpty(iDs)) {
                        bc.a.b(b.this.f48668a, "HUAWEI", InnoMain.INNO_KEY_OAID, iDs);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                b.this.f48668a.unbindService(b.this.f48670c);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public b(Context context) {
        this.f48668a = context;
    }

    public void b() {
        try {
            this.f48668a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        this.f48668a.bindService(intent, this.f48670c, 1);
    }
}
