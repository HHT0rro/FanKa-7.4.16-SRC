package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ClobSeriliazer implements ObjectSerializer {
    public static final ClobSeriliazer instance = new ClobSeriliazer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        try {
            if (obj == null) {
                jSONSerializer.writeNull();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb2 = new StringBuilder();
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = characterStream.read(cArr, 0, 2048);
                    if (read < 0) {
                        String sb3 = sb2.toString();
                        characterStream.close();
                        jSONSerializer.write(sb3);
                        return;
                    }
                    sb2.append(cArr, 0, read);
                }
            } catch (Exception e2) {
                throw new JSONException("read string from reader error", e2);
            }
        } catch (SQLException e10) {
            throw new IOException("write clob error", e10);
        }
    }
}
