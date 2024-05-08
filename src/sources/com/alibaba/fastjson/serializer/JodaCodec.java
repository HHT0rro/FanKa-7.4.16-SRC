package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.a;
import org.joda.time.format.b;
import org.joda.time.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JodaCodec implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final JodaCodec instance = new JodaCodec();
    private static final b defaultFormatter = a.b("yyyy-MM-dd HH:mm:ss");
    private static final b defaultFormatter_23 = a.b("yyyy-MM-dd HH:mm:ss.SSS");
    private static final b formatter_dt19_tw = a.b("yyyy/MM/dd HH:mm:ss");
    private static final b formatter_dt19_cn = a.b("yyyy年M月d日 HH:mm:ss");
    private static final b formatter_dt19_cn_1 = a.b("yyyy年M月d日 H时m分s秒");
    private static final b formatter_dt19_kr = a.b("yyyy년M월d일 HH:mm:ss");
    private static final b formatter_dt19_us = a.b("MM/dd/yyyy HH:mm:ss");
    private static final b formatter_dt19_eur = a.b("dd/MM/yyyy HH:mm:ss");
    private static final b formatter_dt19_de = a.b("dd.MM.yyyy HH:mm:ss");
    private static final b formatter_dt19_in = a.b("dd-MM-yyyy HH:mm:ss");
    private static final b formatter_d8 = a.b("yyyyMMdd");
    private static final b formatter_d10_tw = a.b("yyyy/MM/dd");
    private static final b formatter_d10_cn = a.b("yyyy年M月d日");
    private static final b formatter_d10_kr = a.b("yyyy년M월d일");
    private static final b formatter_d10_us = a.b("MM/dd/yyyy");
    private static final b formatter_d10_eur = a.b("dd/MM/yyyy");
    private static final b formatter_d10_de = a.b("dd.MM.yyyy");
    private static final b formatter_d10_in = a.b("dd-MM-yyyy");
    private static final b ISO_FIXED_FORMAT = a.b("yyyy-MM-dd HH:mm:ss").x(DateTimeZone.getDefault());
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final b formatter_iso8601 = a.b(formatter_iso8601_pattern);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    public LocalDateTime parseDateTime(String str, b bVar) {
        if (bVar == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            bVar = formatter_iso8601;
                        } else if (charAt3 == ' ') {
                            bVar = defaultFormatter;
                        }
                    } else if (charAt == '/' && charAt2 == '/') {
                        bVar = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i10 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                bVar = formatter_dt19_eur;
                            } else if (i10 > 12) {
                                bVar = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    bVar = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    bVar = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            bVar = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            bVar = formatter_dt19_in;
                        }
                    }
                }
            } else if (str.length() == 23) {
                char charAt11 = str.charAt(4);
                char charAt12 = str.charAt(7);
                char charAt13 = str.charAt(10);
                char charAt14 = str.charAt(13);
                char charAt15 = str.charAt(16);
                char charAt16 = str.charAt(19);
                if (charAt14 == ':' && charAt15 == ':' && charAt11 == '-' && charAt12 == '-' && charAt13 == ' ' && charAt16 == '.') {
                    bVar = defaultFormatter_23;
                }
            }
            if (str.length() >= 17) {
                char charAt17 = str.charAt(4);
                if (charAt17 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        bVar = formatter_dt19_cn_1;
                    } else {
                        bVar = formatter_dt19_cn;
                    }
                } else if (charAt17 == 45380) {
                    bVar = formatter_dt19_kr;
                }
            }
        }
        if (bVar == null) {
            return LocalDateTime.parse(str);
        }
        return LocalDateTime.parse(str, bVar);
    }

    public LocalDate parseLocalDate(String str, String str2, b bVar) {
        b bVar2;
        if (bVar == null) {
            if (str.length() == 8) {
                bVar = formatter_d8;
            }
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    bVar = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i10 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        bVar = formatter_d10_eur;
                    } else if (i10 > 12) {
                        bVar = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            bVar = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            bVar = formatter_d10_eur;
                        }
                    }
                } else {
                    if (charAt5 == '.' && charAt7 == '.') {
                        bVar2 = formatter_d10_de;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        bVar2 = formatter_d10_in;
                    }
                    bVar = bVar2;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    bVar = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    bVar = formatter_d10_kr;
                }
            }
        }
        if (bVar == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, bVar);
    }

    public DateTime parseZonedDateTime(String str, b bVar) {
        if (bVar == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            bVar = formatter_iso8601;
                        } else if (charAt3 == ' ') {
                            bVar = defaultFormatter;
                        }
                    } else if (charAt == '/' && charAt2 == '/') {
                        bVar = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i10 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                bVar = formatter_dt19_eur;
                            } else if (i10 > 12) {
                                bVar = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    bVar = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    bVar = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            bVar = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            bVar = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        bVar = formatter_dt19_cn_1;
                    } else {
                        bVar = formatter_dt19_cn;
                    }
                } else if (charAt11 == 45380) {
                    bVar = formatter_dt19_kr;
                }
            }
        }
        if (bVar == null) {
            return DateTime.parse(str);
        }
        return DateTime.parse(str, bVar);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
            int mask = serializerFeature.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                if ((i10 & mask) != 0 || jSONSerializer.isEnabled(serializerFeature)) {
                    dateFormatPattern = formatter_iso8601_pattern;
                } else {
                    dateFormatPattern = localDateTime.getMillisOfSecond() == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                }
            }
            write(serializeWriter, localDateTime, dateFormatPattern);
            return;
        }
        serializeWriter.writeString(obj.toString());
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, org.joda.time.LocalDateTime] */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i10) {
        b bVar;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str == null) {
                bVar = null;
            } else if ("yyyy-MM-dd HH:mm:ss".equals(str)) {
                bVar = defaultFormatter;
            } else {
                bVar = a.b(str);
            }
            if ("".equals(stringVal)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                if (stringVal.length() != 10 && stringVal.length() != 8) {
                    return (T) parseDateTime(stringVal, bVar);
                }
                return (T) parseLocalDate(stringVal, str, bVar).toLocalDateTime(LocalTime.MIDNIGHT);
            }
            if (type == LocalDate.class) {
                if (stringVal.length() == 23) {
                    return (T) LocalDateTime.parse(stringVal).toLocalDate();
                }
                return (T) parseLocalDate(stringVal, str, bVar);
            }
            if (type == LocalTime.class) {
                if (stringVal.length() == 23) {
                    return (T) LocalDateTime.parse(stringVal).toLocalTime();
                }
                return (T) LocalTime.parse(stringVal);
            }
            if (type == DateTime.class) {
                if (bVar == defaultFormatter) {
                    bVar = ISO_FIXED_FORMAT;
                }
                return (T) parseZonedDateTime(stringVal, bVar);
            }
            if (type == DateTimeZone.class) {
                return (T) DateTimeZone.forID(stringVal);
            }
            if (type == Period.class) {
                return (T) Period.parse(stringVal);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(stringVal);
            }
            if (type == Instant.class) {
                return (T) Instant.parse(stringVal);
            }
            if (type == b.class) {
                return (T) a.b(stringVal);
            }
            return null;
        }
        if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken();
            TimeZone timeZone = JSON.defaultTimeZone;
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            if (type == DateTime.class) {
                return (T) new DateTime(longValue, DateTimeZone.forTimeZone(timeZone));
            }
            ?? r72 = (T) new LocalDateTime(longValue, DateTimeZone.forTimeZone(timeZone));
            if (type == LocalDateTime.class) {
                return r72;
            }
            if (type == LocalDate.class) {
                return (T) r72.toLocalDate();
            }
            if (type == LocalTime.class) {
                return (T) r72.toLocalTime();
            }
            if (type == Instant.class) {
                return (T) new Instant(longValue);
            }
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, (k) obj, beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, k kVar, String str) {
        b b4;
        if (str.equals(formatter_iso8601_pattern)) {
            b4 = formatter_iso8601;
        } else {
            b4 = a.b(str);
        }
        serializeWriter.writeString(b4.l(kVar));
    }
}
