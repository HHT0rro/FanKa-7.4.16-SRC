package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement a(JsonReader jsonReader) throws JsonParseException {
        boolean z10;
        try {
            try {
                jsonReader.peek();
                z10 = false;
                try {
                    return TypeAdapters.V.read2(jsonReader);
                } catch (EOFException e2) {
                    e = e2;
                    if (z10) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            } catch (NumberFormatException e12) {
                throw new JsonSyntaxException(e12);
            }
        } catch (EOFException e13) {
            e = e13;
            z10 = true;
        }
    }

    public static void b(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.V.write(jsonWriter, jsonElement);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class AppendableWriter extends Writer {

        /* renamed from: b, reason: collision with root package name */
        public final Appendable f26897b;

        /* renamed from: c, reason: collision with root package name */
        public final CurrentWrite f26898c = new CurrentWrite();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class CurrentWrite implements CharSequence {

            /* renamed from: b, reason: collision with root package name */
            public char[] f26899b;

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f26899b[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f26899b.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f26899b, i10, i11 - i10);
            }
        }

        public AppendableWriter(Appendable appendable) {
            this.f26897b = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            CurrentWrite currentWrite = this.f26898c;
            currentWrite.f26899b = cArr;
            this.f26897b.append(currentWrite, i10, i11 + i10);
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f26897b.append((char) i10);
        }
    }
}
