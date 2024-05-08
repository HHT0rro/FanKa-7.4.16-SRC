package com.huawei.hmf.orb;

import com.huawei.hmf.orb.aidl.AIDLTransport;
import com.huawei.hmf.orb.exception.ConnectRemoteException;
import com.huawei.hmf.repository.impl.RepositoryImpl;
import com.huawei.hmf.services.ApiSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteRepository extends RepositoryImpl implements ConnectionCallbacks {
    public static final RemoteRepositoryFactory FACTORY = new RemoteRepositoryFactory() { // from class: com.huawei.hmf.orb.RemoteRepository.1
        @Override // com.huawei.hmf.orb.RemoteRepositoryFactory
        public RemoteRepository create(RemoteConnector remoteConnector) throws ConnectRemoteException {
            RemoteRepository remoteRepository = RemoteRepositoryCache.getRemoteRepository(remoteConnector.getID());
            return remoteRepository != null ? remoteRepository : new RemoteRepository(remoteConnector);
        }
    };
    private AtomicBoolean mAlive;
    private final RemoteConnector mRemoteConnector;

    public RemoteRepository(RemoteConnector remoteConnector) throws ConnectRemoteException {
        super(false);
        this.mAlive = new AtomicBoolean(false);
        this.mRemoteConnector = remoteConnector;
        RemoteRepositoryCache.addRemoteRepository(remoteConnector.getID(), this);
        if (!remoteConnector.isConnected()) {
            remoteConnector.connect(this);
        } else {
            register();
        }
    }

    public void close() {
        this.mRemoteConnector.close();
    }

    public RemoteConnector getRemoteConnector() {
        return this.mRemoteConnector;
    }

    public boolean isAlive() {
        return this.mAlive.get();
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onConnected() {
        RemoteRepositoryCache.addRemoteRepository(this.mRemoteConnector.getID(), this);
        register();
        this.mAlive.set(true);
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onConnectionFailed(ConnectRemoteException connectRemoteException) {
        onDisconnected();
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onDisconnected() {
        RemoteRepositoryCache.removeRemoteRepository(this.mRemoteConnector.getID());
        unregister();
        this.mAlive.set(false);
    }

    public void register() {
        for (Map.Entry<String, ApiSet> entry : this.mRemoteConnector.getApiSet().entrySet()) {
            String key = entry.getKey();
            new RemoteModuleProviderWrapper(new AIDLTransport(key, this.mRemoteConnector)).bootstrap(this, key, entry.getValue());
        }
    }

    public void unregister() {
        clearRegister();
    }
}
