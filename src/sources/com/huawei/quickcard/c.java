package com.huawei.quickcard;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.blur.OnBlurListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    public static void a(@NonNull final View view, @NonNull i iVar) {
        new h(view).a(iVar, new OnBlurListener() { // from class: com.huawei.quickcard.h2
            @Override // com.huawei.quickcard.framework.blur.OnBlurListener
            public final void onBlur(Bitmap bitmap) {
                c.a(View.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, Bitmap bitmap) {
        view.setBackground(new BitmapDrawable(view.getResources(), bitmap));
    }
}
