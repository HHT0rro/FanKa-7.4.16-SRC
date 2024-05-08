package android.view.contentcapture;

import android.os.ParcelFileDescriptor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface DataShareWriteAdapter {
    void onRejected();

    void onWrite(ParcelFileDescriptor parcelFileDescriptor);

    default void onError(int errorCode) {
    }
}
