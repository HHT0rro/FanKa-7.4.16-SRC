package sun.nio.ch;

import sun.misc.Cleaner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DirectBuffer {
    long address();

    Object attachment();

    Cleaner cleaner();
}
