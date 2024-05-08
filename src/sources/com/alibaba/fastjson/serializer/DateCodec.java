package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer {
    public static final DateCodec instance = new DateCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r4v24, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Date(TypeUtils.longValue((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    ?? r42 = (T) jSONScanner.getCalendar();
                    return type == Calendar.class ? r42 : (T) r42.getTime();
                }
                jSONScanner.close();
                if (str.length() == defaultJSONParser.getDateFomartPattern().length() || (str.length() == 22 && defaultJSONParser.getDateFomartPattern().equals("yyyyMMddHHmmssSSSZ"))) {
                    try {
                        return (T) defaultJSONParser.getDateFormat().parse(str);
                    } catch (ParseException unused) {
                    }
                }
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                    return null;
                }
                int lastIndexOf = str.lastIndexOf(124);
                if (lastIndexOf > 20) {
                    TimeZone timeZone = TimeZone.getTimeZone(str.substring(lastIndexOf + 1));
                    if (!TimeZones.GMT_ID.equals(timeZone.getID())) {
                        JSONScanner jSONScanner2 = new JSONScanner(str.substring(0, lastIndexOf));
                        try {
                            if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                                ?? r43 = (T) jSONScanner2.getCalendar();
                                r43.setTimeZone(timeZone);
                                return type == Calendar.class ? r43 : (T) r43.getTime();
                            }
                        } finally {
                        }
                    }
                }
                return (T) new Date(Long.parseLong(str));
            } finally {
            }
        }
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        Date castToDate;
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class) {
            if ((((java.sql.Date) obj).getTime() + jSONSerializer.timeZone.getOffset(r7)) % 86400000 == 0 && !SerializerFeature.isEnabled(serializeWriter.features, i10, SerializerFeature.WriteClassName)) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Time.class && ((Time) obj).getTime() < 86400000) {
            serializeWriter.writeString(obj.toString());
            return;
        }
        if (obj instanceof Date) {
            castToDate = (Date) obj;
        } else {
            castToDate = TypeUtils.castToDate(obj);
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(castToDate));
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && cls != type) {
            if (cls == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                serializeWriter.write(41);
                return;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(cls.getName());
                serializeWriter.writeFieldValue(',', "val", ((Date) obj).getTime());
                serializeWriter.write(125);
                return;
            }
        }
        long time = castToDate.getTime();
        if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            int i11 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            serializeWriter.write(i11);
            Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
            calendar.setTimeInMillis(time);
            int i12 = calendar.get(1);
            int i13 = calendar.get(2) + 1;
            int i14 = calendar.get(5);
            int i15 = calendar.get(11);
            int i16 = calendar.get(12);
            int i17 = calendar.get(13);
            int i18 = calendar.get(14);
            if (i18 != 0) {
                charArray = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i18, 23, charArray);
                IOUtils.getChars(i17, 19, charArray);
                IOUtils.getChars(i16, 16, charArray);
                IOUtils.getChars(i15, 13, charArray);
                IOUtils.getChars(i14, 10, charArray);
                IOUtils.getChars(i13, 7, charArray);
                IOUtils.getChars(i12, 4, charArray);
            } else if (i17 == 0 && i16 == 0 && i15 == 0) {
                charArray = "0000-00-00".toCharArray();
                IOUtils.getChars(i14, 10, charArray);
                IOUtils.getChars(i13, 7, charArray);
                IOUtils.getChars(i12, 4, charArray);
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i17, 19, charArray);
                IOUtils.getChars(i16, 16, charArray);
                IOUtils.getChars(i15, 13, charArray);
                IOUtils.getChars(i14, 10, charArray);
                IOUtils.getChars(i13, 7, charArray);
                IOUtils.getChars(i12, 4, charArray);
            }
            serializeWriter.write(charArray);
            float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
            int i19 = (int) offset;
            if (i19 == ShadowDrawableWrapper.COS_45) {
                serializeWriter.write(90);
            } else {
                if (i19 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i19);
                } else if (i19 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i19);
                } else if (i19 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(i19);
                } else if (i19 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i19);
                }
                serializeWriter.write(58);
                serializeWriter.append((CharSequence) String.format("%02d", Integer.valueOf((int) ((offset - i19) * 60.0f))));
            }
            serializeWriter.write(i11);
            return;
        }
        serializeWriter.writeLong(time);
    }
}
