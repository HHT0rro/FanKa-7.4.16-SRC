package com.huawei.quickcard.cardmanager.appgallery;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface PresetCardStreamProvider {
    @NonNull
    InputStream open(int i10) throws IOException;

    int size();
}
