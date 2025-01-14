package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TitleTextView extends TextView {
    public TitleTextView(Context context) {
        super(context);
        tanxc_do();
    }

    private void tanxc_do() {
        setPadding(24, 24, 24, 24);
        setMaxLines(2);
        setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    public TitleTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        tanxc_do();
    }
}
