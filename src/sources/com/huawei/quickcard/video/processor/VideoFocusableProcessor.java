package com.huawei.quickcard.video.processor;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.processor.FocusableProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.video.view.VideoHostView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoFocusableProcessor extends FocusableProcessor<VideoHostView> {
    @Override // com.huawei.quickcard.framework.processor.FocusableProcessor, com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull VideoHostView videoHostView, String str, QuickCardValue quickCardValue) {
        super.setProperty((VideoFocusableProcessor) videoHostView, str, quickCardValue);
        if (quickCardValue == null) {
            return;
        }
        videoHostView.setVideoFocusable(quickCardValue.getBoolean());
    }
}
