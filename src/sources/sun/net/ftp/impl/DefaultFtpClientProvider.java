package sun.net.ftp.impl;

import sun.net.ftp.FtpClientProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultFtpClientProvider extends FtpClientProvider {
    @Override // sun.net.ftp.FtpClientProvider
    public sun.net.ftp.FtpClient createFtpClient() {
        return FtpClient.create();
    }
}
