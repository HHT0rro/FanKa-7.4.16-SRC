package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class PendingResultsCreator {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DiscardedPendingResult<R extends Result> extends EmptyPendingResult {
        public DiscardedPendingResult() {
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public boolean isCanceled() {
            return true;
        }

        public DiscardedPendingResult(R r10) {
            setResult(r10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstantPendingResult<R extends Result> extends EmptyPendingResult {
        public InstantPendingResult(R r10) {
            setResult(r10);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void cancel() {
            throw new IllegalStateException("cancel() is not available.");
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback resultCallback) {
            resultCallback.onResult(getResult());
        }
    }

    public static PendingResult<Status> discardedPendingResult() {
        return new DiscardedPendingResult();
    }

    public static PendingResult<Status> instantPendingResult(Status status) {
        return new InstantPendingResult(status);
    }

    public static <R extends Result> PendingResult<R> discardedPendingResult(R r10) {
        return new DiscardedPendingResult(r10);
    }

    public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R r10) {
        return new OptionalPendingResultImpl(new InstantPendingResult(r10));
    }
}
