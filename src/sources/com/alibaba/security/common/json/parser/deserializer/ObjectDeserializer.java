package com.alibaba.security.common.json.parser.deserializer;

import com.alibaba.security.common.json.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj);
}
