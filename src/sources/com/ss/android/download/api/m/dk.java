package com.ss.android.download.api.m;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.mj;
import com.ss.android.download.api.config.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements w {

    /* renamed from: m, reason: collision with root package name */
    private mj f38397m;

    @Override // com.ss.android.download.api.config.w
    public void m(@NonNull Activity activity, @NonNull String[] strArr, mj mjVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f38397m = mjVar;
            activity.requestPermissions(strArr, 1);
        } else if (mjVar != null) {
            mjVar.m();
        }
    }

    @Override // com.ss.android.download.api.config.w
    public boolean m(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.w
    public void m(@NonNull Activity activity, int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        mj mjVar;
        if (iArr.length <= 0 || (mjVar = this.f38397m) == null) {
            return;
        }
        if (iArr[0] == -1) {
            mjVar.m(strArr[0]);
        } else if (iArr[0] == 0) {
            mjVar.m();
        }
    }
}
