package com.huawei.hmf.orb.tbis.type;

import com.huawei.hmf.orb.Releasable;
import com.huawei.hmf.orb.tbis.TextCodecFactory;
import com.huawei.hmf.orb.tbis.result.TBResult;
import com.huawei.hmf.taskstream.Consumer;
import com.huawei.hmf.taskstream.Disposable;
import com.huawei.hmf.taskstream.TaskStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskStreamRef implements Releasable {
    private Disposable mDisposable;
    private final TaskStream mTaskStream;

    public TaskStreamRef(TaskStream taskStream) {
        this.mTaskStream = taskStream;
    }

    @Override // com.huawei.hmf.orb.Releasable
    public void release() {
        Disposable disposable = this.mDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public Disposable subscribe(final TBResult.Callback callback) {
        Disposable subscribe = this.mTaskStream.subscribe(new Consumer() { // from class: com.huawei.hmf.orb.tbis.type.TaskStreamRef.1
            @Override // com.huawei.hmf.taskstream.Consumer
            public void accept(Object obj) {
                callback.onStreamingResult(TextCodecFactory.create().toString(obj));
            }
        }, new Consumer<Exception>() { // from class: com.huawei.hmf.orb.tbis.type.TaskStreamRef.2
            @Override // com.huawei.hmf.taskstream.Consumer
            public void accept(Exception exc) {
                callback.onException(TextCodecFactory.create().toString(exc.getMessage()));
            }
        });
        this.mDisposable = subscribe;
        return subscribe;
    }
}
