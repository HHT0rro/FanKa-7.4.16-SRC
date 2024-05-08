package com.android.internal.os;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class AndroidPrintStream extends LoggingPrintStream {
    private final int priority;
    private final String tag;

    public AndroidPrintStream(int priority, String tag) {
        if (tag == null) {
            throw new NullPointerException("tag");
        }
        this.priority = priority;
        this.tag = tag;
    }

    @Override // com.android.internal.os.LoggingPrintStream
    protected void log(String line) {
        Log.println(this.priority, this.tag, line);
    }
}
