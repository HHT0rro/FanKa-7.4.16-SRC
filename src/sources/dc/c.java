package dc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import com.weibo.ssosdk.oaid.interfaces.OppoIDInterface;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f48672a;

    /* renamed from: c, reason: collision with root package name */
    public String f48674c;

    /* renamed from: d, reason: collision with root package name */
    public OppoIDInterface f48675d;

    /* renamed from: b, reason: collision with root package name */
    public String f48673b = "OUID";

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f48676e = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.f48675d = OppoIDInterface.up.genInterface(iBinder);
                c cVar = c.this;
                if (cVar.f48675d != null) {
                    bc.a.b(c.this.f48672a, "OPPO", "ouid", cVar.d("OUID"));
                    bc.a.b(c.this.f48672a, "OPPO", "duid", c.this.d("DUID"));
                    bc.a.b(c.this.f48672a, "OPPO", "auid", c.this.d("AUID"));
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.f48675d = null;
        }
    }

    public c(Context context) {
        this.f48672a = context;
    }

    public String c() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("android.intent.action.OPEN_ID");
        this.f48672a.bindService(intent, this.f48676e, 1);
        return "";
    }

    public final String d(String str) {
        Signature[] signatureArr;
        String packageName = this.f48672a.getPackageName();
        if (this.f48674c == null) {
            String str2 = null;
            try {
                signatureArr = this.f48672a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b4 : digest) {
                            sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb2.toString();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f48674c = str2;
        }
        return ((OppoIDInterface.up.down) this.f48675d).getSerID(packageName, this.f48674c, str);
    }
}
