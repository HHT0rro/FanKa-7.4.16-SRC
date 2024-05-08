package com.ss.android.socialbase.downloader.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadDns {
    List<InetAddress> lookup(String str) throws UnknownHostException;
}
