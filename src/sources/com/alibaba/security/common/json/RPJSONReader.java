package com.alibaba.security.common.json;

import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.Feature;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPJSONReader implements Closeable {
    private RPJSONStreamContext context;
    private final DefaultJSONParser parser;
    private Reader reader;

    public RPJSONReader(Reader reader) {
        this(new JSONLexer(readAll(reader)));
        this.reader = reader;
    }

    private void endStructure() {
        int i10;
        RPJSONStreamContext rPJSONStreamContext = this.context.parent;
        this.context = rPJSONStreamContext;
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

    private void readAfter() {
        RPJSONStreamContext rPJSONStreamContext = this.context;
        int i10 = rPJSONStreamContext.state;
        int i11 = 1002;
        switch (i10) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i11 = 1003;
                break;
            case 1004:
                i11 = 1005;
                break;
            case 1005:
                i11 = -1;
                break;
            default:
                throw new RPJSONException("illegal state : " + i10);
        }
        if (i11 != -1) {
            rPJSONStreamContext.state = i11;
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb2 = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb2.toString();
                }
                sb2.append(cArr, 0, read);
            }
        } catch (Exception e2) {
            throw new RPJSONException("read string from reader error", e2);
        }
    }

    private void readBefore() {
        int i10 = this.context.state;
        switch (i10) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new RPJSONException("illegal state : " + i10);
        }
    }

    private void startStructure() {
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new RPJSONException("illegal state : " + this.context.state);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.lexer.close();
        Reader reader = this.reader;
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e2) {
                throw new RPJSONException("closed reader error", e2);
            }
        }
    }

    public void config(Feature feature, boolean z10) {
        this.parser.config(feature, z10);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context != null) {
            int i10 = this.parser.lexer.token();
            int i11 = this.context.state;
            switch (i11) {
                case 1001:
                case 1003:
                    return i10 != 13;
                case 1002:
                default:
                    throw new RPJSONException("illegal state : " + i11);
                case 1004:
                case 1005:
                    return i10 != 15;
            }
        }
        throw new RPJSONException("context is null");
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return RPTypeUtils.castToInt(parse);
    }

    public Long readLong() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return RPTypeUtils.castToLong(parse);
    }

    public <T> T readObject(RPTypeReference<T> rPTypeReference) {
        return (T) readObject(rPTypeReference.type);
    }

    public String readString() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return RPTypeUtils.castToString(parse);
    }

    public void startArray() {
        if (this.context == null) {
            this.context = new RPJSONStreamContext(null, 1004);
        } else {
            startStructure();
            this.context = new RPJSONStreamContext(this.context, 1004);
        }
        this.parser.accept(14);
    }

    public void startObject() {
        if (this.context == null) {
            this.context = new RPJSONStreamContext(null, 1001);
        } else {
            startStructure();
            this.context = new RPJSONStreamContext(this.context, 1001);
        }
        this.parser.accept(12);
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t2 = (T) this.parser.parseObject(type);
        readAfter();
        return t2;
    }

    public RPJSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public RPJSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((Class) cls);
        }
        readBefore();
        T t2 = (T) this.parser.parseObject((Class) cls);
        readAfter();
        return t2;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        Object parse = this.parser.parse();
        readAfter();
        return parse;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }
}
