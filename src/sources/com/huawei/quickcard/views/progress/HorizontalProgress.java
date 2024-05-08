package com.huawei.quickcard.views.progress;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.ui.Component;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HorizontalProgress extends Component<HorizontalProgressView> {
    public HorizontalProgress() {
        addProcessor(Attributes.Style.PERCENT, new PercentAttribute());
        addProcessor(Attributes.Style.STROKE_WIDTH, new StrokeWidthStyle());
        addProcessor(Attributes.Style.LAYER_COLOR, new LayerColorStyle());
        addProcessor("color", new ColorStyle());
        ProgressDir progressDir = new ProgressDir();
        addProcessor(Attributes.Style.DIR, progressDir);
        addProcessor("flexDirection", progressDir);
        addProcessor(Attributes.Style.SMOOTH, new HorizontalSmoothProcessor());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.PROGRESS_HORIZONTAL;
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public String[] getNames() {
        return new String[]{Attributes.Component.PROGRESS_HORIZONTAL, "progress"};
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public HorizontalProgressView createViewImpl(Context context) {
        return new HorizontalProgressView(context);
    }
}
