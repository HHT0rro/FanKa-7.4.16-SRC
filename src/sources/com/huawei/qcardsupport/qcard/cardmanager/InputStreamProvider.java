package com.huawei.qcardsupport.qcard.cardmanager;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface InputStreamProvider {
    @NonNull
    InputStream open() throws IOException;
}
