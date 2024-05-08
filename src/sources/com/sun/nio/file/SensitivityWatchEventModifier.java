package com.sun.nio.file;

import java.nio.file.WatchEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum SensitivityWatchEventModifier implements WatchEvent.Modifier {
    HIGH(2),
    MEDIUM(10),
    LOW(30);

    private final int sensitivity;

    public int sensitivityValueInSeconds() {
        return this.sensitivity;
    }

    SensitivityWatchEventModifier(int sensitivity) {
        this.sensitivity = sensitivity;
    }
}
