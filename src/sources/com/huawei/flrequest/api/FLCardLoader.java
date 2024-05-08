package com.huawei.flrequest.api;

import android.content.Context;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.impl.card.LoadCardRequest;
import com.huawei.flrequest.impl.card.LoadCardResponse;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.serverrequest.api.Executor;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import java.util.List;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class FLCardLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28688a = "FLCardLoader";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, ServerResponse serverResponse) {
        try {
            LoadCardResponse loadCardResponse = (LoadCardResponse) com.huawei.flrequest.e.a(LoadCardRequest.class, serverResponse);
            if (loadCardResponse.isSuccess()) {
                taskCompletionSource.setResult(loadCardResponse);
            } else {
                taskCompletionSource.setException(new FLRequestException(0, loadCardResponse.getRtnCode(), "get cards from server failed, rtnCode:" + loadCardResponse.getRtnCode() + ", rtnDesc:" + loadCardResponse.getRtnDesc()));
            }
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
        } catch (Exception e10) {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get card from server.", e10));
        }
    }

    public static OnSuccessListener<ServerResponse> b(final TaskCompletionSource<FLCardResponse> taskCompletionSource) {
        return new OnSuccessListener() { // from class: com.huawei.flrequest.api.b
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FLCardLoader.a(TaskCompletionSource.this, (ServerResponse) obj);
            }
        };
    }

    public static Task<FLCardResponse> load(Context context, List<String> list, List<String> list2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LoadCardRequest.a builder = LoadCardRequest.builder();
        builder.b(list);
        builder.a(list2);
        try {
            Executor.execute(context, builder.a(context)).addOnSuccessListener(b(taskCompletionSource)).addOnFailureListener(a(taskCompletionSource));
            return taskCompletionSource.getTask();
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
            return taskCompletionSource.getTask();
        }
    }

    public static OnFailureListener a(final TaskCompletionSource<FLCardResponse> taskCompletionSource) {
        return new OnFailureListener() { // from class: com.huawei.flrequest.api.a
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FLCardLoader.a(TaskCompletionSource.this, exc);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, Exception exc) {
        Log.w(f28688a, "failed to get card from server." + exc.getMessage());
        if (exc instanceof HttpException) {
            taskCompletionSource.setException(new FLRequestException(com.huawei.flrequest.c.a((HttpException) exc), "failed to get card from server.", exc));
        } else {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get card from server.", exc));
        }
    }
}
