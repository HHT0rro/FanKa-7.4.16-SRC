package com.huawei.flexiblelayout.services.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ImageLoader {
    Task<Drawable> load(@NonNull Context context, @NonNull ImageOptions imageOptions);

    void load(@NonNull View view, @NonNull ImageOptions imageOptions);

    void load(@NonNull ImageView imageView, @NonNull ImageOptions imageOptions);
}
