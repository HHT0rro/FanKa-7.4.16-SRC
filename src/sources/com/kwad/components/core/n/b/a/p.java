package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.bv;
import java.io.File;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class p implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return bv.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return bv.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        bv.zipFile(file);
    }
}
