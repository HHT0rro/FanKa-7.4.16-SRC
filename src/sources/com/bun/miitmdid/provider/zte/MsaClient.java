package com.bun.miitmdid.provider.zte;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import com.bun.lib.MsaIdInterface;
import com.netease.nis.sdkwrapper.Utils;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MsaClient {
    public static String TAG = "MSA Client library";
    public ServiceConnection mConnection;
    public Context mContext;
    public MsaIdInterface mDeviceidInterface;

    public MsaClient(Context context, final MsaServiceConnection msaServiceConnection) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.mContext = context;
        this.mConnection = new ServiceConnection() { // from class: com.bun.miitmdid.provider.zte.MsaClient.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MsaClient.access$002(MsaClient.this, MsaIdInterface.Stub.asInterface(iBinder));
                new MsaAsyncTask(MsaClient.access$000(MsaClient.this), msaServiceConnection).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                MsaClient.access$100();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                MsaClient.access$002(MsaClient.this, null);
                MsaClient.access$100();
                MsaClient.access$002(MsaClient.this, null);
            }
        };
    }

    public static void StartMsaKlService(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 113;
        objArr[4] = 1598952044335L;
        Utils.rL(objArr);
    }

    public static /* synthetic */ MsaIdInterface access$000(MsaClient msaClient) {
        Object[] objArr = new Object[4];
        objArr[1] = msaClient;
        objArr[2] = 114;
        objArr[3] = 1598952044336L;
        return (MsaIdInterface) Utils.rL(objArr);
    }

    public static /* synthetic */ MsaIdInterface access$002(MsaClient msaClient, MsaIdInterface msaIdInterface) {
        Object[] objArr = new Object[5];
        objArr[1] = msaClient;
        objArr[2] = msaIdInterface;
        objArr[3] = 115;
        objArr[4] = 1598952044337L;
        return (MsaIdInterface) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$100() {
        Object[] objArr = new Object[3];
        objArr[1] = 116;
        objArr[2] = 1598952044338L;
        return (String) Utils.rL(objArr);
    }

    public void BindService(String str) {
        Utils.rL(new Object[]{this, str, 117, 1598952044339L});
    }

    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 118, 1598952044340L});
    }

    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 119, 1598952044341L});
    }

    public String getUDID() {
        return (String) Utils.rL(new Object[]{this, 120, 1598952044342L});
    }

    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 121, 1598952044343L});
    }

    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 122, 1598952044344L})).booleanValue();
    }

    public void shutdown() {
        Utils.rL(new Object[]{this, 123, 1598952044345L});
    }
}
