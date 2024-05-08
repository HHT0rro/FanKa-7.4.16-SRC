package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer {
    public static final CalendarCodec instance = new CalendarCodec();
    private DatatypeFactory dateFactory;

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        if (this.dateFactory == null) {
            try {
                this.dateFactory = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e2) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e2);
            }
        }
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        String format = beanContext.getFormat();
        Calendar calendar = (Calendar) obj;
        if (format.equals("unixtime")) {
            serializeWriter.writeInt((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
        serializeWriter.writeString(simpleDateFormat.format(calendar.getTime()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i10) {
        T t2 = (T) DateCodec.instance.deserialze(defaultJSONParser, type, obj, str, i10);
        if (t2 instanceof Calendar) {
            return t2;
        }
        Date date = (Date) t2;
        if (date == null) {
            return null;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        ?? r72 = (T) Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
        r72.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) createXMLGregorianCalendar((GregorianCalendar) r72) : r72;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        Calendar calendar;
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof XMLGregorianCalendar) {
            calendar = ((XMLGregorianCalendar) obj).toGregorianCalendar();
        } else {
            calendar = (Calendar) obj;
        }
        if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            char c4 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
            serializeWriter.append(c4);
            int i11 = calendar.get(1);
            int i12 = calendar.get(2) + 1;
            int i13 = calendar.get(5);
            int i14 = calendar.get(11);
            int i15 = calendar.get(12);
            int i16 = calendar.get(13);
            int i17 = calendar.get(14);
            if (i17 != 0) {
                charArray = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i17, 23, charArray);
                IOUtils.getChars(i16, 19, charArray);
                IOUtils.getChars(i15, 16, charArray);
                IOUtils.getChars(i14, 13, charArray);
                IOUtils.getChars(i13, 10, charArray);
                IOUtils.getChars(i12, 7, charArray);
                IOUtils.getChars(i11, 4, charArray);
            } else if (i16 == 0 && i15 == 0 && i14 == 0) {
                charArray = "0000-00-00".toCharArray();
                IOUtils.getChars(i13, 10, charArray);
                IOUtils.getChars(i12, 7, charArray);
                IOUtils.getChars(i11, 4, charArray);
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i16, 19, charArray);
                IOUtils.getChars(i15, 16, charArray);
                IOUtils.getChars(i14, 13, charArray);
                IOUtils.getChars(i13, 10, charArray);
                IOUtils.getChars(i12, 7, charArray);
                IOUtils.getChars(i11, 4, charArray);
            }
            serializeWriter.write(charArray);
            float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
            int i18 = (int) offset;
            if (i18 == ShadowDrawableWrapper.COS_45) {
                serializeWriter.write(90);
            } else {
                if (i18 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i18);
                } else if (i18 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i18);
                } else if (i18 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(i18);
                } else if (i18 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i18);
                }
                serializeWriter.write(58);
                serializeWriter.append((CharSequence) String.format("%02d", Integer.valueOf((int) ((offset - i18) * 60.0f))));
            }
            serializeWriter.append(c4);
            return;
        }
        jSONSerializer.write(calendar.getTime());
    }
}
