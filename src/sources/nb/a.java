package nb;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

/* compiled from: ImageLoadingListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {
    void a(String str, View view, FailReason failReason);

    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingStarted(String str, View view);
}
