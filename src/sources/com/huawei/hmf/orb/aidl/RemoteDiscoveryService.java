package com.huawei.hmf.orb.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hmf.orb.aidl.communicate.MessageCenter;
import com.huawei.hmf.orb.aidl.impl.IBindConnector;
import com.huawei.hmf.orb.aidl.impl.RemoteServiceBroker;
import com.huawei.hmf.orb.aidl.request.ConnectService;
import com.huawei.hmf.orb.aidl.request.DisconnectService;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.services.internal.ApplicationContext;
import com.huawei.hmf.services.ui.internal.ActivityLifecycleInterceptor;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RemoteDiscoveryService extends Service implements IBindConnector {
    private RemoteServiceBroker broker = new RemoteServiceBroker(this);

    static {
        MessageCenter.getInstance().register(ConnectService.name, ConnectService.class);
        MessageCenter.getInstance().register(InvokeService.name, InvokeService.class);
        MessageCenter.getInstance().register(DisconnectService.name, DisconnectService.class);
    }

    public abstract Set<String> exportRemoteModule();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.broker;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ApplicationContext.setContext(getApplication());
        ActivityLifecycleInterceptor.register(getApplication());
        ExportedRemoteModule.getInstance().addAll(exportRemoteModule());
    }

    @Override // com.huawei.hmf.orb.aidl.impl.IBindConnector
    public int onNewBind(String str, Intent intent) {
        return 0;
    }
}
