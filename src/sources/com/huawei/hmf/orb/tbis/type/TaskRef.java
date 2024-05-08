package com.huawei.hmf.orb.tbis.type;

import com.huawei.hmf.orb.tbis.TextCodecFactory;
import com.huawei.hmf.orb.tbis.result.TBResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskRef {
    private final Task mTask;

    public TaskRef(Task task) {
        this.mTask = task;
    }

    public void addListener(final TBResult.Callback callback) {
        this.mTask.addOnSuccessListener(new OnSuccessListener() { // from class: com.huawei.hmf.orb.tbis.type.TaskRef.2
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                callback.onResult(TextCodecFactory.create().toString(obj));
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.hmf.orb.tbis.type.TaskRef.1
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                callback.onException(TextCodecFactory.create().toString(exc.getMessage()));
            }
        });
    }
}
