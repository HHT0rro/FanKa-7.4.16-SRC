package com.kwad.sdk.crash.utils;

import java.io.Serializable;
import java.io.Writer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = 4424285024471074820L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        if (cArr != null) {
            this.builder.append(cArr, i10, i11);
        }
    }

    public StringBuilderWriter(int i10) {
        this.builder = new StringBuilder(i10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) {
        this.builder.append(c4);
        return this;
    }

    public StringBuilderWriter(StringBuilder sb2) {
        this.builder = sb2 == null ? new StringBuilder() : sb2;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i10, int i11) {
        this.builder.append(charSequence, i10, i11);
        return this;
    }
}
