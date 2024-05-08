package com.alibaba.security.common.http.ok;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Callback {
    void onFailure(RPCall rPCall, IOException iOException);

    void onResponse(RPCall rPCall, Response response) throws IOException;
}
