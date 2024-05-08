package com.huawei.hmf.orb.bridge;

import android.os.RemoteException;
import com.huawei.hmf.orb.IndexedObject;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.aidl.NamingRemoteProxy;
import com.huawei.hmf.orb.aidl.NamingRemoteTarget;
import com.huawei.hmf.orb.aidl.client.ResultCallback;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.client.impl.ResolveResult;
import com.huawei.hmf.orb.aidl.communicate.AIDLResponse;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.services.codec.TypeToken;
import com.huawei.hmf.services.codec.Variant;
import com.huawei.hmf.taskstream.Disposable;
import com.huawei.hmf.taskstream.Observer;
import com.huawei.hmf.taskstream.TaskStream;
import com.huawei.hmf.taskstream.TaskStreamSource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskStreamBridge implements Bridge {
    private static final int TASK_COMPLETED = 3;
    private static final int TASK_EXCEPTION = 1;
    private static final int TASK_SUBSCRIBE = 2;

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public IndexedObject<NamingRemoteTarget> handle(Object obj, final AIDLResponse aIDLResponse) {
        final IndexedObject<NamingRemoteTarget> indexedObject = new IndexedObject<>(new NamingRemoteTarget(null));
        ((TaskStream) obj).subscribe(new Observer<Object>() { // from class: com.huawei.hmf.orb.bridge.TaskStreamBridge.2
            @Override // com.huawei.hmf.taskstream.Observer
            public void onComplete() {
                InvokeService.Response response = new InvokeService.Response();
                response.ret = new Variant<>(null);
                response.statusCode = 3;
                aIDLResponse.call(response);
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onFailure(Exception exc) {
                InvokeService.Response response = new InvokeService.Response();
                response.ret = new Variant<>(new RemoteException(exc.getMessage()));
                response.statusCode = 1;
                aIDLResponse.call(response);
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onNext(Object obj2) {
                InvokeService.Response response = new InvokeService.Response();
                response.ret = new Variant<>(obj2);
                aIDLResponse.call(response);
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onSubscribe(Disposable disposable) {
                ((NamingRemoteTarget) indexedObject.get()).setService(new ReleasableDisposable(disposable));
                InvokeService.Response response = new InvokeService.Response();
                response.ret = new Variant<>(Long.valueOf(indexedObject.id()));
                response.statusCode = 2;
                aIDLResponse.call(response);
            }
        });
        return indexedObject;
    }

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public /* bridge */ /* synthetic */ Object send(RemoteInvoker remoteInvoker, ResolvePendingResult resolvePendingResult, TypeToken typeToken) {
        return send(remoteInvoker, (ResolvePendingResult<InvokeService.Response>) resolvePendingResult, typeToken);
    }

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public TaskStream send(final RemoteInvoker remoteInvoker, ResolvePendingResult<InvokeService.Response> resolvePendingResult, final TypeToken typeToken) {
        final TaskStreamSource taskStreamSource = new TaskStreamSource(null);
        resolvePendingResult.setResultCallback(new ResultCallback<ResolveResult<InvokeService.Response>>() { // from class: com.huawei.hmf.orb.bridge.TaskStreamBridge.1
            @Override // com.huawei.hmf.orb.aidl.client.ResultCallback
            public void onResult(ResolveResult<InvokeService.Response> resolveResult) {
                Type type;
                InvokeService.Response value = resolveResult.getValue();
                if (value == null) {
                    taskStreamSource.onException(new RemoteException("Response is null, errorCode:" + ((Object) resolveResult.getStatus())));
                    return;
                }
                int i10 = value.statusCode;
                if (i10 == 2) {
                    taskStreamSource.onSubscribe((Disposable) NamingRemoteProxy.create(remoteInvoker, taskStreamSource, (Long) value.ret.cast(Long.class)));
                    return;
                }
                if (i10 == 1) {
                    taskStreamSource.onException((RemoteException) value.ret.cast(RemoteException.class));
                    return;
                }
                if (i10 == 3) {
                    taskStreamSource.onComplete();
                    return;
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeToken.getType();
                if (parameterizedType != null && (type = parameterizedType.getActualTypeArguments()[0]) != null) {
                    taskStreamSource.onNext(value.ret.cast(type));
                } else {
                    taskStreamSource.onException(new IllegalArgumentException("TaskStream type error"));
                }
            }
        });
        return taskStreamSource.getTaskStream();
    }
}
