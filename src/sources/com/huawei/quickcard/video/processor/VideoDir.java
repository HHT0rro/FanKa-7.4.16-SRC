package com.huawei.quickcard.video.processor;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.DirProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.video.view.VideoHostView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoDir extends DirProcessor<VideoHostView> {
    @Override // com.huawei.quickcard.framework.processor.DirProcessor, com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull VideoHostView videoHostView, String str, QuickCardValue quickCardValue) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue) && quickCardValue.getString() != null) {
            String string = quickCardValue.getString();
            string.hashCode();
            if (string.equals(Attributes.LayoutDirection.LTR)) {
                videoHostView.setVideoDir(0);
                return;
            } else if (!string.equals(Attributes.LayoutDirection.RTL)) {
                videoHostView.setVideoDir(3);
                return;
            } else {
                videoHostView.setVideoDir(1);
                return;
            }
        }
        videoHostView.setVideoDir(videoHostView.getResources().getConfiguration().getLayoutDirection());
    }
}
