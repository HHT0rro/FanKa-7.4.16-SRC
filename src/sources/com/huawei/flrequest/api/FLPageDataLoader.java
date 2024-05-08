package com.huawei.flrequest.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.serverrequest.api.Executor;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLPageDataLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28697a = "FLPageDataLoader";

    public static OnSuccessListener<ServerResponse> a(final FLPageRequest fLPageRequest, final TaskCompletionSource<FLPageResponse> taskCompletionSource) {
        return new OnSuccessListener() { // from class: com.huawei.flrequest.api.h
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FLPageDataLoader.a(FLPageRequest.this, taskCompletionSource, (ServerResponse) obj);
            }
        };
    }

    public static Task<FLPageResponse> load(@NonNull Context context, @NonNull FLPageRequest fLPageRequest) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Executor.execute(context, fLPageRequest).addOnSuccessListener(a(fLPageRequest, (TaskCompletionSource<FLPageResponse>) taskCompletionSource)).addOnFailureListener(a(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FLPageRequest fLPageRequest, TaskCompletionSource taskCompletionSource, ServerResponse serverResponse) {
        try {
            FLPageResponse fLPageResponse = (FLPageResponse) com.huawei.flrequest.e.a(fLPageRequest.getClass(), serverResponse);
            if (fLPageResponse.isSuccess()) {
                taskCompletionSource.setResult(fLPageResponse);
            } else {
                taskCompletionSource.setException(new FLRequestException(0, fLPageResponse.getRtnCode(), "get page data from server failed, pageId：" + fLPageRequest.getPageId() + ", RtnCode:" + fLPageResponse.getRtnCode() + ", RtnDesc:" + fLPageResponse.getRtnDesc()));
            }
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
        } catch (Exception e10) {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get page data from server.", e10));
        }
    }

    public static OnFailureListener a(final TaskCompletionSource<FLPageResponse> taskCompletionSource) {
        return new OnFailureListener() { // from class: com.huawei.flrequest.api.g
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FLPageDataLoader.a(TaskCompletionSource.this, exc);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, Exception exc) {
        Log.w(f28697a, "failed to get page data from server." + exc.getMessage());
        if (exc instanceof HttpException) {
            taskCompletionSource.setException(new FLRequestException(com.huawei.flrequest.c.a((HttpException) exc), "failed to get page data from server.", exc));
        } else {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get page data from server.", exc));
        }
    }
}
