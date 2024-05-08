package java.net;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: URLConnection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnknownContentHandler extends ContentHandler {
    static final ContentHandler INSTANCE = new UnknownContentHandler();

    UnknownContentHandler() {
    }

    @Override // java.net.ContentHandler
    public Object getContent(URLConnection uc2) throws IOException {
        return uc2.getInputStream();
    }
}
