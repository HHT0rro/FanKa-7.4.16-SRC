package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface b {
    void addHeader(String str, String str2);

    String bd(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> vc();

    Map<String, List<String>> vd();

    void ve();
}
