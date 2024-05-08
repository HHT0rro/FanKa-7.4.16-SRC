package com.huawei.flrequest.api;

import android.content.Context;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.impl.card.CardUrisRequest;
import com.huawei.flrequest.impl.card.CardUrisResponse;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.serverrequest.api.Executor;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLCardUrisLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28689a = "FLCardUrisLoader";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Option {
        public static final String ALL = "all";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, ServerResponse serverResponse) {
        try {
            CardUrisResponse cardUrisResponse = (CardUrisResponse) com.huawei.flrequest.e.a(CardUrisRequest.class, serverResponse);
            if (cardUrisResponse.isSuccess()) {
                taskCompletionSource.setResult(cardUrisResponse);
            } else {
                taskCompletionSource.setException(new FLRequestException(0, cardUrisResponse.getRtnCode(), "get cardUris from server failed, rtnCode:" + cardUrisResponse.getRtnCode() + ", rtnDesc:" + cardUrisResponse.getRtnDesc()));
            }
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
        } catch (Exception e10) {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get cardUris from server.", e10));
        }
    }

    public static OnSuccessListener<ServerResponse> b(final TaskCompletionSource<FLCardUrisResponse> taskCompletionSource) {
        return new OnSuccessListener() { // from class: com.huawei.flrequest.api.d
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FLCardUrisLoader.a(TaskCompletionSource.this, (ServerResponse) obj);
            }
        };
    }

    public static Task<FLCardUrisResponse> load(Context context, List<String> list, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        CardUrisRequest.a builder = CardUrisRequest.builder();
        builder.a(list);
        builder.a(str);
        try {
            Executor.execute(context, builder.a(context)).addOnSuccessListener(b(taskCompletionSource)).addOnFailureListener(a(taskCompletionSource));
            return taskCompletionSource.getTask();
        } catch (FLRequestException e2) {
            taskCompletionSource.setException(e2);
            return taskCompletionSource.getTask();
        }
    }

    public static OnFailureListener a(final TaskCompletionSource<FLCardUrisResponse> taskCompletionSource) {
        return new OnFailureListener() { // from class: com.huawei.flrequest.api.c
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FLCardUrisLoader.a(TaskCompletionSource.this, exc);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, Exception exc) {
        Log.w(f28689a, "failed to get cardUris from server." + exc.getMessage());
        if (exc instanceof HttpException) {
            taskCompletionSource.setException(new FLRequestException(com.huawei.flrequest.c.a((HttpException) exc), "failed to get cardUris from server.", exc));
        } else {
            taskCompletionSource.setException(new FLRequestException(-1, "failed to get cardUris from server.", exc));
        }
    }
}
