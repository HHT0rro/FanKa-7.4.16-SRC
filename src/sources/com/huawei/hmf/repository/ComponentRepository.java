package com.huawei.hmf.repository;

import android.os.Looper;
import com.huawei.hmf.orb.RemoteConnector;
import com.huawei.hmf.orb.RemoteRepository;
import com.huawei.hmf.orb.exception.ConnectRemoteException;
import com.huawei.hmf.repository.impl.ComponentRepositoryImpl;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import java.util.concurrent.ExecutionException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ComponentRepository {
    private static final ComponentRepositoryImpl IMPL = new ComponentRepositoryImpl();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface OnCompleted {
        void onResult(RemoteRepository remoteRepository, ConnectRemoteException connectRemoteException);
    }

    public static Repository getRepository() {
        return IMPL.getRepository();
    }

    public static synchronized RemoteRepository getRepository(RemoteConnector remoteConnector) throws ConnectRemoteException {
        RemoteRepository remoteRepository;
        synchronized (ComponentRepository.class) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    try {
                        remoteRepository = (RemoteRepository) Tasks.await(IMPL.getRepositoryTask(remoteConnector));
                    } catch (ExecutionException e2) {
                        if (e2.getCause() instanceof ConnectRemoteException) {
                            throw ((ConnectRemoteException) e2.getCause());
                        }
                        throw new ConnectRemoteException(ConnectRemoteException.Status.UnableBindService, "Unknown error");
                    }
                } catch (InterruptedException unused) {
                    throw new ConnectRemoteException(ConnectRemoteException.Status.UnableBindService);
                }
            } else {
                throw new IllegalStateException("Can not be called on the UI thread");
            }
        }
        return remoteRepository;
    }

    public static synchronized void getRepository(RemoteConnector remoteConnector, final OnCompleted onCompleted) {
        synchronized (ComponentRepository.class) {
            IMPL.getRepositoryTask(remoteConnector).addOnCompleteListener(new OnCompleteListener<RemoteRepository>() { // from class: com.huawei.hmf.repository.ComponentRepository.1
                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public void onComplete(Task<RemoteRepository> task) {
                    ConnectRemoteException connectRemoteException;
                    if (task.isSuccessful()) {
                        OnCompleted.this.onResult(task.getResult(), null);
                        return;
                    }
                    if (task.getException() instanceof ConnectRemoteException) {
                        connectRemoteException = (ConnectRemoteException) task.getException();
                    } else {
                        connectRemoteException = new ConnectRemoteException(ConnectRemoteException.Status.UnableBindService, "Unknown error");
                    }
                    OnCompleted.this.onResult(null, connectRemoteException);
                }
            });
        }
    }
}
