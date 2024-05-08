package com.huawei.hmf.repository.impl;

import com.huawei.hmf.orb.ConnectionCallbacks;
import com.huawei.hmf.orb.RemoteConnector;
import com.huawei.hmf.orb.RemoteRepository;
import com.huawei.hmf.orb.RemoteRepositoryFactory;
import com.huawei.hmf.orb.exception.ConnectRemoteException;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ComponentRepositoryImpl {
    private volatile Repository defaultRepository;
    private final Object lock = new Object();

    private static RemoteRepository createRemoteRepository(RemoteConnector remoteConnector) throws ConnectRemoteException {
        RemoteRepositoryFactory repositoryFactory = remoteConnector.getRepositoryFactory();
        if (repositoryFactory != null) {
            return repositoryFactory.create(remoteConnector);
        }
        throw new ConnectRemoteException(ConnectRemoteException.Status.UnknownConnector);
    }

    public Repository getRepository() {
        if (this.defaultRepository == null) {
            synchronized (this.lock) {
                if (this.defaultRepository == null) {
                    this.defaultRepository = new RepositoryImpl(true);
                }
            }
        }
        return this.defaultRepository;
    }

    public synchronized Task<RemoteRepository> getRepositoryTask(final RemoteConnector remoteConnector) {
        final TaskCompletionSource taskCompletionSource;
        taskCompletionSource = new TaskCompletionSource();
        try {
            final RemoteRepository createRemoteRepository = createRemoteRepository(remoteConnector);
            if (createRemoteRepository.isAlive()) {
                taskCompletionSource.setResult(createRemoteRepository);
            } else {
                remoteConnector.addConnectionCallbacks(new ConnectionCallbacks() { // from class: com.huawei.hmf.repository.impl.ComponentRepositoryImpl.1
                    @Override // com.huawei.hmf.orb.ConnectionCallbacks
                    public void onConnected() {
                        remoteConnector.removeConnectionCallbacks(this);
                        if (createRemoteRepository.isAlive()) {
                            taskCompletionSource.setResult(createRemoteRepository);
                        } else {
                            taskCompletionSource.setException(new ConnectRemoteException(ConnectRemoteException.Status.UnableBindService));
                        }
                    }

                    @Override // com.huawei.hmf.orb.ConnectionCallbacks
                    public void onConnectionFailed(ConnectRemoteException connectRemoteException) {
                        remoteConnector.removeConnectionCallbacks(this);
                        taskCompletionSource.setException(connectRemoteException);
                    }

                    @Override // com.huawei.hmf.orb.ConnectionCallbacks
                    public void onDisconnected() {
                        remoteConnector.removeConnectionCallbacks(this);
                    }
                });
            }
        } catch (ConnectRemoteException e2) {
            taskCompletionSource.setException(e2);
        }
        return taskCompletionSource.getTask();
    }
}
