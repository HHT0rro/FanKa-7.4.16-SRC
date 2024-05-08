package com.nirvana.tools.logger.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMMonitorRecord extends ACMRecord {
    public static final int MONITOR_URGENCY_DELAYED = 2;
    public static final int MONITOR_URGENCY_REAL_TIME = 1;
    private int urgency;

    public ACMMonitorRecord() {
    }

    public ACMMonitorRecord(int i10) {
        if (i10 != 1 && i10 != 2) {
            i10 = 2;
        }
        this.urgency = i10;
    }

    public int getUrgency() {
        return this.urgency;
    }

    public void setUrgency(int i10) {
        this.urgency = i10;
    }
}
