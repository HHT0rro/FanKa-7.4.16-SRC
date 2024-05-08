package com.alibaba.security.common.json;

import com.alibaba.security.common.json.serializer.JSONSerializer;
import com.alibaba.security.common.json.serializer.SerializeWriter;
import com.alibaba.security.common.json.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPJSONWriter implements Closeable, Flushable {
    private RPJSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public RPJSONWriter(Writer writer) {
        SerializeWriter serializeWriter = new SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    private void afterWriter() {
        int i10;
        RPJSONStreamContext rPJSONStreamContext = this.context;
        if (rPJSONStreamContext == null) {
            return;
        }
        switch (rPJSONStreamContext.state) {
            case 1001:
            case 1003:
                i10 = 1002;
                break;
            case 1002:
                i10 = 1003;
                break;
            case 1004:
                i10 = 1005;
                break;
            default:
                i10 = -1;
                break;
        }
        if (i10 != -1) {
            rPJSONStreamContext.state = i10;
        }
    }

    private void beforeWrite() {
        RPJSONStreamContext rPJSONStreamContext = this.context;
        if (rPJSONStreamContext == null) {
            return;
        }
        int i10 = rPJSONStreamContext.state;
        if (i10 == 1002) {
            this.writer.write(58);
        } else if (i10 == 1003) {
            this.writer.write(44);
        } else {
            if (i10 != 1005) {
                return;
            }
            this.writer.write(44);
        }
    }

    private void beginStructure() {
        int i10 = this.context.state;
        switch (i10) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.writer.write(58);
                return;
            case 1003:
            default:
                throw new RPJSONException("illegal state : " + i10);
            case 1005:
                this.writer.write(44);
                return;
        }
    }

    private void endStructure() {
        RPJSONStreamContext rPJSONStreamContext = this.context.parent;
        this.context = rPJSONStreamContext;
        if (rPJSONStreamContext == null) {
            return;
        }
        int i10 = rPJSONStreamContext.state;
        int i11 = i10 != 1001 ? i10 != 1002 ? i10 != 1004 ? -1 : 1005 : 1003 : 1002;
        if (i11 != -1) {
            rPJSONStreamContext.state = i11;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        this.writer.config(serializerFeature, z10);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new RPJSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new RPJSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }
}
