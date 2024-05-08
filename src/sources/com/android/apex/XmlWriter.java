package com.android.apex;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class XmlWriter implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private PrintWriter out;
    private StringBuilder outBuffer = new StringBuilder();
    private int indent = 0;
    private boolean startLine = true;

    public XmlWriter(PrintWriter printWriter) {
        this.out = printWriter;
    }

    private void printIndent() {
        for (int i10 = 0; i10 < this.indent; i10++) {
            this.outBuffer.append("    ");
        }
        this.startLine = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void print(String code) {
        String[] lines = code.split("\n", -1);
        for (int i10 = 0; i10 < lines.length; i10++) {
            if (this.startLine && !lines[i10].isEmpty()) {
                printIndent();
            }
            this.outBuffer.append(lines[i10]);
            if (i10 + 1 < lines.length) {
                this.outBuffer.append("\n");
                this.startLine = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increaseIndent() {
        this.indent++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decreaseIndent() {
        this.indent--;
    }

    void printXml() {
        this.out.print(this.outBuffer.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PrintWriter printWriter = this.out;
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public static void write(XmlWriter _out, ApexInfoList apexInfoList) throws IOException {
        _out.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        if (apexInfoList != null) {
            apexInfoList.write(_out, "apex-info-list");
        }
        _out.printXml();
    }
}
