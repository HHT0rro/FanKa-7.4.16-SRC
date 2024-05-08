package com.huawei.hmf.orb.bridge;

import android.os.RemoteException;
import com.huawei.hmf.orb.IndexedObject;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.RemoteTarget;
import com.huawei.hmf.orb.aidl.client.ResultCallback;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.client.impl.ResolveResult;
import com.huawei.hmf.orb.aidl.communicate.AIDLResponse;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.services.codec.TypeToken;
import com.huawei.hmf.services.codec.Variant;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskBridge implements Bridge {
    private final int TASK_EXCEPTION = 1;

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public IndexedObject<? extends RemoteTarget> handle(Object obj, final AIDLResponse aIDLResponse) {
        ((Task) obj).addOnCompleteListener(new OnCompleteListener<Object>() { // from class: com.huawei.hmf.orb.bridge.TaskBridge.2
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<Object> task) {
                InvokeService.Response response = new InvokeService.Response();
                if (task.isSuccessful()) {
                    response.ret = new Variant<>(task.getResult());
                } else {
                    response.ret = new Variant<>(new RemoteException(task.getException().getMessage()));
                    response.statusCode = 1;
                }
                aIDLResponse.call(response);
            }
        });
        return null;
    }

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public /* bridge */ /* synthetic */ Object send(RemoteInvoker remoteInvoker, ResolvePendingResult resolvePendingResult, TypeToken typeToken) {
        return send(remoteInvoker, (ResolvePendingResult<InvokeService.Response>) resolvePendingResult, typeToken);
    }

    @Override // com.huawei.hmf.orb.bridge.Bridge
    public Task send(RemoteInvoker remoteInvoker, ResolvePendingResult<InvokeService.Response> resolvePendingResult, final TypeToken typeToken) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        resolvePendingResult.setResultCallback(new ResultCallback<ResolveResult<InvokeService.Response>>() { // from class: com.huawei.hmf.orb.bridge.TaskBridge.1
            @Override // com.huawei.hmf.orb.aidl.client.ResultCallback
            public void onResult(ResolveResult<InvokeService.Response> resolveResult) {
                Type type;
                InvokeService.Response value = resolveResult.getValue();
                if (value == null) {
                    taskCompletionSource.setException(new RemoteException("Response is null, errorCode:" + ((Object) resolveResult.getStatus())));
                    return;
                }
                if (value.statusCode == 1) {
                    taskCompletionSource.setException((RemoteException) value.ret.cast(new TypeToken<RemoteException>() { // from class: com.huawei.hmf.orb.bridge.TaskBridge.1.1
                    }.getType()));
                    return;
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeToken.getType();
                if (parameterizedType != null && (type = parameterizedType.getActualTypeArguments()[0]) != null) {
                    taskCompletionSource.setResult(value.ret.cast(type));
                } else {
                    taskCompletionSource.setException(new IllegalArgumentException("Task type error"));
                }
            }
        });
        return taskCompletionSource.getTask();
    }
}
