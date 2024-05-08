package com.huawei.hmf.taskstream;

import com.huawei.hmf.taskstream.impl.TaskStreamImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskStreamSource<TResult> implements Disposable {
    private Action mOnDisposeAction;
    private TaskStreamImpl<TResult> taskStream = new TaskStreamImpl<>();

    public TaskStreamSource() {
        onSubscribe(this);
    }

    @Override // com.huawei.hmf.taskstream.Disposable
    public void dispose() {
        this.taskStream.dispose();
        Action action = this.mOnDisposeAction;
        if (action != null) {
            action.run();
            this.mOnDisposeAction = null;
        }
    }

    public void doOnDispose(Action action) {
        this.mOnDisposeAction = action;
    }

    public TaskStream<TResult> getTaskStream() {
        return this.taskStream;
    }

    public void onComplete() {
        this.taskStream.onComplete();
    }

    public void onException(Exception exc) {
        this.taskStream.onException(exc);
    }

    public void onNext(TResult tresult) {
        this.taskStream.onNext(tresult);
    }

    public void onSubscribe(Disposable disposable) {
        this.taskStream.onSubscribe(disposable);
    }

    public TaskStreamSource(Disposable disposable) {
        if (disposable != null) {
            onSubscribe(disposable);
        }
    }
}
