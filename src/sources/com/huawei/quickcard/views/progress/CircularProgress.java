package com.huawei.quickcard.views.progress;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.ui.Component;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CircularProgress extends Component<CircularProgressView> {
    public CircularProgress() {
        addProcessor("color", new CircularColorProcessor());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.PROGRESS_CIRCULAR;
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public CircularProgressView createViewImpl(Context context) {
        return new CircularProgressView(context);
    }
}
