package com.huawei.hms.ads.template;

import android.widget.ImageView;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IImageLoader {
    void load(ImageView imageView, String str, String str2, int i10);

    void loadDrawable(IDrawableSetter iDrawableSetter, String str);
}
