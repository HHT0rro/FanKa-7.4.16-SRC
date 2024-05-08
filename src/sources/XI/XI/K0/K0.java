package XI.XI.K0;

import XI.XI.XI.XI;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class K0 implements kM {
    public XI.XI.XI.XI K0;

    /* renamed from: XI, reason: collision with root package name */
    public Context f646XI;
    public xo kM;
    public ServiceConnection xo = new XI();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class XI implements ServiceConnection {
        public XI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            K0.this.K0 = XI.AbstractBinderC0004XI.XI(iBinder);
            K0.this.kM.connectSuccess(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            K0.this.K0 = null;
        }
    }

    public K0(Context context) {
        this.f646XI = context;
    }

    public boolean XI() {
        boolean isSupported;
        XI.XI.XI.XI xi = this.K0;
        if (xi != null) {
            try {
                isSupported = xi.isSupported();
            } catch (RemoteException e2) {
                e2.getMessage();
                e2.printStackTrace();
            }
            Objects.toString(this.K0);
            return isSupported;
        }
        isSupported = false;
        Objects.toString(this.K0);
        return isSupported;
    }
}
