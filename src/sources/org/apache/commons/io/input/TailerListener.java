package org.apache.commons.io.input;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
