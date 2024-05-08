package com.huawei.flrequest.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.impl.bean.ResponseBean;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.serverrequest.api.Executor;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLListDataLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28690a = "FLListDataLoader";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FLListRequest fLListRequest, TaskCompletionSource taskCompletionSource, ServerResponse serverResponse) {
        try {
            a((FLListResponse) com.huawei.flrequest.e.a(fLListRequest.getClass(), serverResponse), taskCompletionSource);
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static Task<FLListResponse> load(@NonNull Context context, @NonNull final FLListRequest fLListRequest) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Executor.execute(context, fLListRequest).addOnSuccessListener(new OnSuccessListener() { // from class: com.huawei.flrequest.api.f
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FLListDataLoader.a(FLListRequest.this, taskCompletionSource, (ServerResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.flrequest.api.e
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FLListDataLoader.a(TaskCompletionSource.this, fLListRequest, exc);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, FLListRequest fLListRequest, Exception exc) {
        if (exc instanceof FLRequestException) {
            taskCompletionSource.setException(exc);
            return;
        }
        String str = "load error, pageNum: " + fLListRequest.getPageNum() + ", dataId = " + fLListRequest.getDataId();
        taskCompletionSource.setException(new FLRequestException(exc instanceof HttpException ? ((HttpException) exc).code : -1, str));
        Log.w(f28690a, str);
    }

    private static void a(ResponseBean responseBean, TaskCompletionSource<FLListResponse> taskCompletionSource) {
        if (!(responseBean instanceof FLListResponse)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FLListDataLoader handleResponse, response type error: ");
            sb2.append(responseBean == null ? "null" : responseBean.getClass().getSimpleName());
            String sb3 = sb2.toString();
            taskCompletionSource.setException(new FLRequestException(5, sb3));
            Log.w(f28690a, sb3);
            return;
        }
        if (!responseBean.isSuccess()) {
            taskCompletionSource.setException(new FLRequestException(0, responseBean.getRtnCode(), "FLListDataLoader, handleResponse, response failed"));
            Log.w(f28690a, "FLListDataLoader, handleResponse, response failed");
        } else {
            taskCompletionSource.setResult((FLListResponse) responseBean);
        }
    }
}
