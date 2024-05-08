package com.android.internal.logging.testing;

import android.metrics.LogMaker;
import com.android.internal.logging.MetricsLogger;
import java.util.LinkedList;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FakeMetricsLogger extends MetricsLogger {
    private Queue<LogMaker> logs = new LinkedList();

    @Override // com.android.internal.logging.MetricsLogger
    protected void saveLog(LogMaker log) {
        this.logs.offer(log);
    }

    public Queue<LogMaker> getLogs() {
        return this.logs;
    }

    public void reset() {
        this.logs.clear();
    }
}
