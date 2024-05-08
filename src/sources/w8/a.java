package w8;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends c {
    @Override // w8.d
    public BaseMode a(Context context, int i10, Intent intent) {
        if (4105 == i10) {
            return c(intent);
        }
        return null;
    }

    public BaseMode c(Intent intent) {
        try {
            v8.a aVar = new v8.a();
            aVar.b(Integer.parseInt(y8.a.d(intent.getStringExtra("command"))));
            aVar.d(Integer.parseInt(y8.a.d(intent.getStringExtra("code"))));
            aVar.g(y8.a.d(intent.getStringExtra("content")));
            aVar.c(y8.a.d(intent.getStringExtra("appKey")));
            aVar.e(y8.a.d(intent.getStringExtra("appSecret")));
            aVar.i(y8.a.d(intent.getStringExtra("appPackage")));
            y8.c.a("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e2) {
            y8.c.a("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
