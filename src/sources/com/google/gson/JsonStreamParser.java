package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z10;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z10 = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (MalformedJsonException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } catch (IOException e10) {
                    throw new JsonIOException(e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.a(this.parser);
            } catch (JsonParseException e2) {
                if (e2.getCause() instanceof EOFException) {
                    throw new NoSuchElementException();
                }
                throw e2;
            } catch (OutOfMemoryError e10) {
                throw new JsonParseException("Failed parsing JSON source to Json", e10);
            } catch (StackOverflowError e11) {
                throw new JsonParseException("Failed parsing JSON source to Json", e11);
            }
        }
        throw new NoSuchElementException();
    }
}
