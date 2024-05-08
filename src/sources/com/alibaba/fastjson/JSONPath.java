package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.u0;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONPath implements JSONAware {
    public static final long LENGTH = -1580386065683472715L;
    public static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    /* renamed from: com.alibaba.fastjson.JSONPath$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        static {
            int[] iArr = new int[Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ArrayAccessSegment implements Segment {
        private final int index;

        public ArrayAccessSegment(int i10) {
            this.index = i10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Context {
        public final boolean eval;
        public Object object;
        public final Context parent;

        public Context(Context context, boolean z10) {
            this.parent = context;
            this.eval = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final double value;

        public DoubleOpSegement(String str, double d10, Operator operator) {
            this.propertyName = str;
            this.value = d10;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) propertyValue).doubleValue();
            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    return doubleValue == this.value;
                case 2:
                    return doubleValue != this.value;
                case 3:
                    return doubleValue >= this.value;
                case 4:
                    return doubleValue > this.value;
                case 5:
                    return doubleValue <= this.value;
                case 6:
                    return doubleValue < this.value;
                default:
                    return false;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z10) {
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.and) {
                Iterator<Filter> iterator2 = this.fitlers.iterator2();
                while (iterator2.hasNext()) {
                    if (!iterator2.next().apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<Filter> iterator22 = this.fitlers.iterator2();
            while (iterator22.hasNext()) {
                if (iterator22.next().apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class FilterSegment implements Segment {
        private final Filter filter;

        public FilterSegment(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object obj3 : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        jSONArray.add(obj3);
                    }
                }
                return jSONArray;
            }
            if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            }
            return null;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long startValue;

        public IntBetweenSegement(String str, long j10, long j11, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startValue = j10;
            this.endValue = j11;
            this.not = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                if (longExtractValue >= this.startValue && longExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = jArr;
            this.not = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                for (long j10 : this.values) {
                    if (j10 == longExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = lArr;
            this.not = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            int i10 = 0;
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i10 < length) {
                    if (lArr[i10] == null) {
                        return !this.not;
                    }
                    i10++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i10 < length2) {
                    Long l10 = lArr2[i10];
                    if (l10 != null && l10.longValue() == longExtractValue) {
                        return !this.not;
                    }
                    i10++;
                }
            }
            return this.not;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String str, long j10, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = j10;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            if (propertyValue instanceof BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = BigDecimal.valueOf(this.value);
                }
                int compareTo = this.valueDecimal.compareTo((BigDecimal) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return compareTo == 0;
                    case 2:
                        return compareTo != 0;
                    case 3:
                        return compareTo <= 0;
                    case 4:
                        return compareTo < 0;
                    case 5:
                        return compareTo >= 0;
                    case 6:
                        return compareTo > 0;
                    default:
                        return false;
                }
            }
            if (propertyValue instanceof Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = Float.valueOf((float) this.value);
                }
                int compareTo2 = this.valueFloat.compareTo((Float) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return compareTo2 == 0;
                    case 2:
                        return compareTo2 != 0;
                    case 3:
                        return compareTo2 <= 0;
                    case 4:
                        return compareTo2 < 0;
                    case 5:
                        return compareTo2 >= 0;
                    case 6:
                        return compareTo2 > 0;
                    default:
                        return false;
                }
            }
            if (propertyValue instanceof Double) {
                if (this.valueDouble == null) {
                    this.valueDouble = Double.valueOf(this.value);
                }
                int compareTo3 = this.valueDouble.compareTo((Double) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return compareTo3 == 0;
                    case 2:
                        return compareTo3 != 0;
                    case 3:
                        return compareTo3 <= 0;
                    case 4:
                        return compareTo3 < 0;
                    case 5:
                        return compareTo3 >= 0;
                    case 6:
                        return compareTo3 > 0;
                    default:
                        return false;
                }
            }
            long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    return longExtractValue == this.value;
                case 2:
                    return longExtractValue != this.value;
                case 3:
                    return longExtractValue >= this.value;
                case 4:
                    return longExtractValue > this.value;
                case 5:
                    return longExtractValue <= this.value;
                case 6:
                    return longExtractValue < this.value;
                default:
                    return false;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class JSONPathParser {
        private char ch;
        private boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        public static boolean isDigitFirst(char c4) {
            return c4 == '-' || c4 == '+' || (c4 >= '0' && c4 <= '9');
        }

        public void accept(char c4) {
            if (this.ch == c4) {
                if (isEOF()) {
                    return;
                }
                next();
            } else {
                throw new JSONPathException("expect '" + c4 + ", but '" + this.ch + "'");
            }
        }

        public Segment buildArraySegement(String str) {
            int length = str.length();
            int i10 = 0;
            char charAt = str.charAt(0);
            int i11 = length - 1;
            char charAt2 = str.charAt(i11);
            int indexOf = str.indexOf(44);
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                if (indexOf == -1) {
                    return new PropertySegment(str.substring(1, i11), false);
                }
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                while (i10 < split.length) {
                    String str2 = split[i10];
                    strArr[i10] = str2.substring(1, str2.length() - 1);
                    i10++;
                }
                return new MultiPropertySegment(strArr);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegment(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegment(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new PropertySegment(str, false);
            }
            if (indexOf != -1) {
                String[] split2 = str.split(",");
                int[] iArr = new int[split2.length];
                while (i10 < split2.length) {
                    iArr[i10] = Integer.parseInt(split2[i10]);
                    i10++;
                }
                return new MultiIndexSegment(iArr);
            }
            if (indexOf2 != -1) {
                String[] split3 = str.split(u.bD);
                int length2 = split3.length;
                int[] iArr2 = new int[length2];
                for (int i12 = 0; i12 < split3.length; i12++) {
                    String str3 = split3[i12];
                    if (str3.length() != 0) {
                        iArr2[i12] = Integer.parseInt(str3);
                    } else if (i12 == 0) {
                        iArr2[i12] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i13 = iArr2[0];
                int i14 = length2 > 1 ? iArr2[1] : -1;
                int i15 = length2 == 3 ? iArr2[2] : 1;
                if (i14 < 0 || i14 >= i13) {
                    if (i15 > 0) {
                        return new RangeSegment(i13, i14, i15);
                    }
                    throw new UnsupportedOperationException("step must greater than zero : " + i15);
                }
                throw new UnsupportedOperationException("end must greater than or equals start. start " + i13 + ",  end " + i14);
            }
            throw new UnsupportedOperationException();
        }

        public Segment[] explain() {
            String str = this.path;
            if (str != null && str.length() != 0) {
                Segment[] segmentArr = new Segment[8];
                while (true) {
                    Segment readSegement = readSegement();
                    if (readSegement == null) {
                        break;
                    }
                    if (readSegement instanceof PropertySegment) {
                        PropertySegment propertySegment = (PropertySegment) readSegement;
                        if (!propertySegment.deep && propertySegment.propertyName.equals(StringUtils.NO_PRINT_CODE)) {
                        }
                    }
                    int i10 = this.level;
                    if (i10 == segmentArr.length) {
                        Segment[] segmentArr2 = new Segment[(i10 * 3) / 2];
                        System.arraycopy(segmentArr, 0, segmentArr2, 0, i10);
                        segmentArr = segmentArr2;
                    }
                    int i11 = this.level;
                    this.level = i11 + 1;
                    segmentArr[i11] = readSegement;
                }
                int i12 = this.level;
                if (i12 == segmentArr.length) {
                    return segmentArr;
                }
                Segment[] segmentArr3 = new Segment[i12];
                System.arraycopy(segmentArr, 0, segmentArr3, 0, i12);
                return segmentArr3;
            }
            throw new IllegalArgumentException();
        }

        public Filter filterRest(Filter filter) {
            char c4 = this.ch;
            boolean z10 = c4 == '&';
            if ((c4 != '&' || getNextChar() != '&') && (this.ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            while (this.ch == ' ') {
                next();
            }
            return new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z10);
        }

        public char getNextChar() {
            return this.path.charAt(this.pos);
        }

        public boolean isEOF() {
            return this.pos >= this.path.length();
        }

        public void next() {
            String str = this.path;
            int i10 = this.pos;
            this.pos = i10 + 1;
            this.ch = str.charAt(i10);
        }

        public Segment parseArrayAccess(boolean z10) {
            Object parseArrayAccessFilter = parseArrayAccessFilter(z10);
            if (parseArrayAccessFilter instanceof Segment) {
                return (Segment) parseArrayAccessFilter;
            }
            return new FilterSegment((Filter) parseArrayAccessFilter);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
        
            r3 = r22.pos;
         */
        /* JADX WARN: Removed duplicated region for block: B:255:0x03d8 A[LOOP:9: B:253:0x03d4->B:255:0x03d8, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x03dc A[EDGE_INSN: B:256:0x03dc->B:257:0x03dc BREAK  A[LOOP:9: B:253:0x03d4->B:255:0x03d8], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:260:0x03e6  */
        /* JADX WARN: Removed duplicated region for block: B:262:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object parseArrayAccessFilter(boolean r23) {
            /*
                Method dump skipped, instructions count: 1588
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.JSONPathParser.parseArrayAccessFilter(boolean):java.lang.Object");
        }

        public double readDoubleValue(long j10) {
            int i10 = this.pos - 1;
            next();
            while (true) {
                char c4 = this.ch;
                if (c4 < '0' || c4 > '9') {
                    break;
                }
                next();
            }
            return Double.parseDouble(this.path.substring(i10, this.pos - 1)) + j10;
        }

        public long readLongValue() {
            int i10 = this.pos - 1;
            char c4 = this.ch;
            if (c4 == '+' || c4 == '-') {
                next();
            }
            while (true) {
                char c10 = this.ch;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i10, this.pos - 1));
        }

        public String readName() {
            skipWhitespace();
            char c4 = this.ch;
            if (c4 != '\\' && !Character.isJavaIdentifierStart(c4)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb2 = new StringBuilder();
            while (!isEOF()) {
                char c10 = this.ch;
                if (c10 == '\\') {
                    next();
                    sb2.append(this.ch);
                    if (isEOF()) {
                        return sb2.toString();
                    }
                    next();
                } else {
                    if (!Character.isJavaIdentifierPart(c10)) {
                        break;
                    }
                    sb2.append(this.ch);
                    next();
                }
            }
            if (isEOF() && Character.isJavaIdentifierPart(this.ch)) {
                sb2.append(this.ch);
            }
            return sb2.toString();
        }

        public Operator readOp() {
            Operator operator;
            char c4 = this.ch;
            if (c4 == '=') {
                next();
                char c10 = this.ch;
                if (c10 == '~') {
                    next();
                    operator = Operator.REG_MATCH;
                } else if (c10 == '=') {
                    next();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c4 == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c4 == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c4 == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String readName = readName();
            if ("not".equalsIgnoreCase(readName)) {
                skipWhitespace();
                String readName2 = readName();
                if ("like".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_RLIKE;
                }
                if (u0.f28637e.equalsIgnoreCase(readName2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(readName)) {
                return Operator.NOT_IN;
            }
            if ("like".equalsIgnoreCase(readName)) {
                return Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(readName)) {
                return Operator.RLIKE;
            }
            if (u0.f28637e.equalsIgnoreCase(readName)) {
                return Operator.IN;
            }
            if ("between".equalsIgnoreCase(readName)) {
                return Operator.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        public Segment readSegement() {
            boolean z10 = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegment(this.ch - '0');
                }
                char c4 = this.ch;
                if ((c4 >= 'a' && c4 <= 'z') || (c4 >= 'A' && c4 <= 'Z')) {
                    return new PropertySegment(Character.toString(c4), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c10 = this.ch;
                if (c10 != '$') {
                    if (c10 != '.' && c10 != '/') {
                        if (c10 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegment(readName(), false);
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                    next();
                    if (c10 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i10 = this.pos;
                        if (length > i10 + 3 && this.ch == '[' && this.path.charAt(i10) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                    } else {
                        z10 = false;
                    }
                    char c11 = this.ch;
                    if (c11 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return z10 ? WildCardSegment.instance_deep : WildCardSegment.instance;
                    }
                    if (isDigitFirst(c11)) {
                        return parseArrayAccess(false);
                    }
                    String readName = readName();
                    if (this.ch == '(') {
                        next();
                        if (this.ch == ')') {
                            if (!isEOF()) {
                                next();
                            }
                            if (!"size".equals(readName) && !DatabaseSourceInfoStorage.COLUMN_LENGTH.equals(readName)) {
                                if ("max".equals(readName)) {
                                    return MaxSegment.instance;
                                }
                                if (Attributes.Style.MIN.equals(readName)) {
                                    return MinSegment.instance;
                                }
                                if ("keySet".equals(readName)) {
                                    return KeySetSegment.instance;
                                }
                                throw new JSONPathException("not support jsonpath : " + this.path);
                            }
                            return SizeSegment.instance;
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                    return new PropertySegment(readName, z10);
                }
                next();
            }
            return null;
        }

        public String readString() {
            char c4 = this.ch;
            next();
            int i10 = this.pos - 1;
            while (this.ch != c4 && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i10, isEOF() ? this.pos : this.pos - 1);
            accept(c4);
            return substring;
        }

        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c4 = this.ch;
            if (c4 == '\"' || c4 == '\'') {
                return readString();
            }
            if (c4 == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        public final void skipWhitespace() {
            while (true) {
                char c4 = this.ch;
                if (c4 > ' ') {
                    return;
                }
                if (c4 != ' ' && c4 != '\r' && c4 != '\n' && c4 != '\t' && c4 != '\f' && c4 != '\b') {
                    return;
                } else {
                    next();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = new KeySetSegment();

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z10;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i10;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i10 = 0;
            } else {
                if (!obj4.startsWith(str)) {
                    return this.not;
                }
                i10 = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i10);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i10 = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 != null && !obj4.endsWith(str3)) {
                return this.not;
            }
            return !this.not;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MaxSegment implements Segment {
        public static final MaxSegment instance = new MaxSegment();

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj instanceof Collection) {
                Object obj3 = null;
                for (Object obj4 : (Collection) obj) {
                    if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) < 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MinSegment implements Segment {
        public static final MinSegment instance = new MinSegment();

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj instanceof Collection) {
                Object obj3 = null;
                for (Object obj4 : (Collection) obj) {
                    if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) > 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i10 = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i10 >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i10]));
                i10++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (parse instanceof List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, length);
                    List list = (List) parse;
                    if (iArr2[0] >= 0) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i10 = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i10 >= jArr.length) {
                    return;
                }
                jArr[i10] = TypeUtils.fnv1a_64(strArr[i10]);
                i10++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i10 = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i10 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i10], this.propertyNamesHash[i10]));
                i10++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            JSONArray jSONArray;
            Object integerValue;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            Object obj = context.object;
            if (obj == null) {
                jSONArray = new JSONArray();
                context.object = jSONArray;
            } else {
                jSONArray = (JSONArray) obj;
            }
            for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                jSONArray.add(null);
            }
            do {
                int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                if (jSONLexerBase.matchStat != 3) {
                    return;
                }
                int i10 = jSONLexerBase.token();
                if (i10 == 2) {
                    integerValue = jSONLexerBase.integerValue();
                    jSONLexerBase.nextToken(16);
                } else if (i10 == 3) {
                    integerValue = jSONLexerBase.decimalValue();
                    jSONLexerBase.nextToken(16);
                } else if (i10 != 4) {
                    integerValue = defaultJSONParser.parse();
                } else {
                    integerValue = jSONLexerBase.stringVal();
                    jSONLexerBase.nextToken(16);
                }
                jSONArray.set(seekObjectToField, integerValue);
            } while (jSONLexerBase.token() == 16);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class NotNullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NotNullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class NullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) == null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class PropertySegment implements Segment {
        private final boolean deep;
        private final String propertyName;
        private final long propertyNameHash;

        public PropertySegment(String str, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                ArrayList arrayList = new ArrayList();
                jSONPath.deepScan(obj2, this.propertyName, arrayList);
                return arrayList;
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[SYNTHETIC] */
        @Override // com.alibaba.fastjson.JSONPath.Segment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void extract(com.alibaba.fastjson.JSONPath r17, com.alibaba.fastjson.parser.DefaultJSONParser r18, com.alibaba.fastjson.JSONPath.Context r19) {
            /*
                Method dump skipped, instructions count: 418
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.PropertySegment.extract(com.alibaba.fastjson.JSONPath, com.alibaba.fastjson.parser.DefaultJSONParser, com.alibaba.fastjson.JSONPath$Context):void");
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i10, int i11, int i12) {
            this.start = i10;
            this.end = i11;
            this.step = i12;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i10 = this.start;
            if (i10 < 0) {
                i10 += intValue;
            }
            int i11 = this.end;
            if (i11 < 0) {
                i11 += intValue;
            }
            int i12 = ((i11 - i10) / this.step) + 1;
            if (i12 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i12);
            while (i10 <= i11 && i10 < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i10));
                i10 += this.step;
            }
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RefOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final Segment refSgement;

        public RefOpSegement(String str, Segment segment, Operator operator) {
            this.propertyName = str;
            this.refSgement = segment;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            Object eval = this.refSgement.eval(jSONPath, obj, obj);
            if ((eval instanceof Integer) || (eval instanceof Long) || (eval instanceof Short) || (eval instanceof Byte)) {
                long longExtractValue = TypeUtils.longExtractValue((Number) eval);
                if (!(propertyValue instanceof Integer) && !(propertyValue instanceof Long) && !(propertyValue instanceof Short) && !(propertyValue instanceof Byte)) {
                    if (propertyValue instanceof BigDecimal) {
                        int compareTo = BigDecimal.valueOf(longExtractValue).compareTo((BigDecimal) propertyValue);
                        switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                            case 1:
                                return compareTo == 0;
                            case 2:
                                return compareTo != 0;
                            case 3:
                                return compareTo <= 0;
                            case 4:
                                return compareTo < 0;
                            case 5:
                                return compareTo >= 0;
                            case 6:
                                return compareTo > 0;
                            default:
                                return false;
                        }
                    }
                } else {
                    long longExtractValue2 = TypeUtils.longExtractValue((Number) propertyValue);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            return longExtractValue2 == longExtractValue;
                        case 2:
                            return longExtractValue2 != longExtractValue;
                        case 3:
                            return longExtractValue2 >= longExtractValue;
                        case 4:
                            return longExtractValue2 > longExtractValue;
                        case 5:
                            return longExtractValue2 <= longExtractValue;
                        case 6:
                            return longExtractValue2 < longExtractValue;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RegMatchSegement implements Filter {
        private final Operator op;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RegMatchSegement(String str, Pattern pattern, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = pattern;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            return this.pattern.matcher(propertyValue.toString()).matches();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RlikeSegement(String str, String str2, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = Pattern.compile(str2);
            this.not = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class SizeSegment implements Segment {
        public static final SizeSegment instance = new SizeSegment();

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z10) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = strArr;
            this.not = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            Operator operator = this.op;
            if (operator == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            Operator operator2 = this.op;
            return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ValueSegment implements Filter {
        private boolean eq;
        private final String propertyName;
        private final long propertyNameHash;
        private final Object value;

        public ValueSegment(String str, Object obj, boolean z10) {
            this.eq = true;
            if (obj != null) {
                this.propertyName = str;
                this.propertyNameHash = TypeUtils.fnv1a_64(str);
                this.value = obj;
                this.eq = z10;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash));
            return !this.eq ? !equals : equals;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = new WildCardSegment(false);
        public static final WildCardSegment instance_deep = new WildCardSegment(true);
        private boolean deep;

        private WildCardSegment(boolean z10) {
            this.deep = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    jSONPath.deepGetPropertyValues(parse, arrayList);
                    context.object = arrayList;
                    return;
                } else {
                    if (parse instanceof JSONObject) {
                        Collection<Object> values = ((JSONObject) parse).values();
                        JSONArray jSONArray = new JSONArray(values.size());
                        Iterator<Object> iterator2 = values.iterator2();
                        while (iterator2.hasNext()) {
                            jSONArray.add(iterator2.next());
                        }
                        context.object = jSONArray;
                        return;
                    }
                    if (parse instanceof JSONArray) {
                        context.object = parse;
                        return;
                    }
                }
            }
            throw new JSONException("TODO");
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public static int compare(Object obj, Object obj2) {
        Object d10;
        Object f10;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f10 = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 != Long.class) {
                if (cls2 == Float.class) {
                    f10 = new BigDecimal(((Float) obj2).floatValue());
                } else {
                    if (cls2 == Double.class) {
                        f10 = new BigDecimal(((Double) obj2).doubleValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else {
                f10 = new BigDecimal(((Long) obj2).longValue());
            }
            obj2 = f10;
            return ((Comparable) obj).compareTo(obj2);
        }
        if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f10 = new Long(((Integer) obj2).intValue());
                obj2 = f10;
            } else {
                if (cls2 != BigDecimal.class) {
                    if (cls2 == Float.class) {
                        d10 = new Float((float) ((Long) obj).longValue());
                    } else if (cls2 == Double.class) {
                        d10 = new Double(((Long) obj).longValue());
                    }
                } else {
                    d10 = new BigDecimal(((Long) obj).longValue());
                }
                obj = d10;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d10 = new Long(((Integer) obj).intValue());
            } else if (cls2 != BigDecimal.class) {
                if (cls2 == Float.class) {
                    d10 = new Float(((Integer) obj).intValue());
                } else if (cls2 == Double.class) {
                    d10 = new Double(((Integer) obj).intValue());
                }
            } else {
                d10 = new BigDecimal(((Integer) obj).intValue());
            }
            obj = d10;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f10 = new Double(((Integer) obj2).intValue());
            } else if (cls2 != Long.class) {
                if (cls2 == Float.class) {
                    f10 = new Double(((Float) obj2).floatValue());
                }
            } else {
                f10 = new Double(((Long) obj2).longValue());
            }
            obj2 = f10;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f10 = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f10 = new Float((float) ((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d10 = new Double(((Float) obj).floatValue());
                obj = d10;
            }
            obj2 = f10;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return eqNotNull((Number) obj, (Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
            }
        }
        if (isInt) {
            if (isInt2) {
                return number.longValue() == number2.longValue();
            }
            if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        return ((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue();
    }

    public static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    public static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                JSONPath compile = compile(str);
                compile.init();
                jSONArray.add(compile.eval(obj));
            }
        }
        return jSONArray;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        Object eval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(true);
        for (String str : strArr) {
            JSONPath compile = compile(str);
            compile.init();
            Segment[] segmentArr = compile.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (eval = compile.eval(obj)) != null) {
                compile.set(jSONObject, eval);
            }
        }
        return jSONObject;
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        Object obj2 = null;
        int i10 = 0;
        Object obj3 = obj;
        int i11 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i11 >= segmentArr.length) {
                break;
            }
            if (i11 == segmentArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = segmentArr[i11].eval(this, obj, obj3);
            i11++;
        }
        if (obj3 != null) {
            if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i10 < length) {
                    collection.add(objArr[i10]);
                    i10++;
                }
                return;
            }
            Class<?> cls = obj3.getClass();
            if (cls.isArray()) {
                int length2 = Array.getLength(obj3);
                Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                System.arraycopy(obj3, 0, newInstance, 0, length2);
                while (i10 < objArr.length) {
                    Array.set(newInstance, length2 + i10, objArr[i10]);
                    i10++;
                }
                Segment segment = this.segments[r8.length - 1];
                if (segment instanceof PropertySegment) {
                    ((PropertySegment) segment).setValue(this, obj2, newInstance);
                    return;
                } else {
                    if (segment instanceof ArrayAccessSegment) {
                        ((ArrayAccessSegment) segment).setValue(this, obj2, newInstance);
                        return;
                    }
                    throw new UnsupportedOperationException();
                }
            }
            throw new JSONException("unsupported array put operation. " + ((Object) cls));
        }
        throw new JSONPathException("value not found in path " + this.path);
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i10 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                return true;
            }
            Object eval = segmentArr[i10].eval(this, obj, obj2);
            if (eval == null) {
                return false;
            }
            if (eval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(eval);
            }
            i10++;
            obj2 = eval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (eval instanceof Iterable) {
            Iterator iterator2 = ((Iterable) eval).iterator2();
            while (iterator2.hasNext()) {
                if (eq(iterator2.next(), obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(eval, obj2);
    }

    public void deepGetPropertyValues(Object obj, List<Object> list) {
        Iterable fieldValues;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                fieldValues = javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path, e2);
            }
        } else if (obj instanceof Map) {
            fieldValues = ((Map) obj).values();
        } else {
            fieldValues = obj instanceof Collection ? (Collection) obj : null;
        }
        if (fieldValues != null) {
            for (Object obj2 : fieldValues) {
                if (obj2 != null && !ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepGetPropertyValues(obj2, list);
                } else {
                    list.add(obj2);
                }
            }
            return;
        }
        throw new UnsupportedOperationException(cls.getName());
    }

    public void deepScan(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                    deepScan(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepScan(obj2, str, list);
                }
            }
            return;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                if (fieldSerializer != null) {
                    try {
                        list.add(fieldSerializer.getPropertyValueDirect(obj));
                        return;
                    } catch (IllegalAccessException e2) {
                        throw new JSONException("getFieldValue error." + str, e2);
                    } catch (InvocationTargetException e10) {
                        throw new JSONException("getFieldValue error." + str, e10);
                    }
                }
                Iterator<Object> iterator2 = javaBeanSerializer.getFieldValues(obj).iterator2();
                while (iterator2.hasNext()) {
                    deepScan(iterator2.next(), str, list);
                }
                return;
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e11);
            }
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            for (int i10 = 0; i10 < list2.size(); i10++) {
                deepScan(list2.get(i10), str, list);
            }
        }
    }

    public void deepSet(Object obj, String str, long j10, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            } else {
                Iterator iterator2 = map.values().iterator2();
                while (iterator2.hasNext()) {
                    deepSet(iterator2.next(), str, j10, obj2);
                }
                return;
            }
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer != null) {
            try {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj, obj2);
                    return;
                }
                Iterator<Object> iterator22 = getJavaBeanSerializer(cls).getObjectFieldValues(obj).iterator2();
                while (iterator22.hasNext()) {
                    deepSet(iterator22.next(), str, j10, obj2);
                }
                return;
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
            }
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i10 = 0; i10 < list.size(); i10++) {
                deepSet(list.get(i10), str, j10, obj2);
            }
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i10 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                return obj2;
            }
            obj2 = segmentArr[i10].eval(this, obj, obj2);
            i10++;
        }
    }

    public Set<?> evalKeySet(Object obj) {
        JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).h();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (Exception e2) {
            throw new JSONPathException("evalKeySet error : " + this.path, e2);
        }
    }

    public int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i10 = 0;
            Iterator iterator2 = ((Map) obj).values().iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next() != null) {
                    i10++;
                }
            }
            return i10;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e2) {
            throw new JSONPathException("evalSize error : " + this.path, e2);
        }
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        Object obj;
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        if (this.segments.length == 0) {
            return defaultJSONParser.parse();
        }
        Context context = null;
        int i10 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 < segmentArr.length) {
                Segment segment = segmentArr[i10];
                boolean z10 = true;
                boolean z11 = i10 == segmentArr.length - 1;
                if (context != null && (obj = context.object) != null) {
                    context.object = segment.eval(this, null, obj);
                } else {
                    if (!z11) {
                        Segment segment2 = segmentArr[i10 + 1];
                        if ((!(segment instanceof PropertySegment) || !((PropertySegment) segment).deep || (!(segment2 instanceof ArrayAccessSegment) && !(segment2 instanceof MultiIndexSegment) && !(segment2 instanceof MultiPropertySegment) && !(segment2 instanceof SizeSegment) && !(segment2 instanceof PropertySegment) && !(segment2 instanceof FilterSegment))) && ((!(segment2 instanceof ArrayAccessSegment) || ((ArrayAccessSegment) segment2).index >= 0) && !(segment2 instanceof FilterSegment) && !(segment instanceof WildCardSegment))) {
                            z10 = false;
                        }
                    }
                    Context context2 = new Context(context, z10);
                    segment.extract(this, defaultJSONParser, context2);
                    context = context2;
                }
                i10++;
            } else {
                return context.object;
            }
        }
    }

    public Object getArrayItem(Object obj, int i10) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i10 >= 0) {
                if (i10 < list.size()) {
                    return list.get(i10);
                }
                return null;
            }
            if (Math.abs(i10) <= list.size()) {
                return list.get(list.size() + i10);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i10 >= 0) {
                if (i10 < length) {
                    return Array.get(obj, i10);
                }
                return null;
            }
            if (Math.abs(i10) <= length) {
                return Array.get(obj, length + i10);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i10));
            return obj2 == null ? map.get(Integer.toString(i10)) : obj2;
        }
        if (obj instanceof Collection) {
            int i11 = 0;
            for (Object obj3 : (Collection) obj) {
                if (i11 == i10) {
                    return obj3;
                }
                i11++;
            }
            return null;
        }
        throw new UnsupportedOperationException();
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    public Object getPropertyValue(Object obj, String str, long j10) {
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj = JSON.parseObject((String) obj);
            } catch (Exception unused) {
            }
        }
        Object obj2 = obj;
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            return obj3 == null ? (SIZE == j10 || LENGTH == j10) ? Integer.valueOf(map.size()) : obj3 : obj3;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj2.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj2, str, j10, false);
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
            }
        }
        int i10 = 0;
        if (obj2 instanceof List) {
            List list = (List) obj2;
            if (SIZE != j10 && LENGTH != j10) {
                while (i10 < list.size()) {
                    Object obj4 = list.get(i10);
                    if (obj4 == list) {
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.add(obj4);
                    } else {
                        Object propertyValue = getPropertyValue(obj4, str, j10);
                        if (propertyValue instanceof Collection) {
                            Collection collection = (Collection) propertyValue;
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.addAll(collection);
                        } else if (propertyValue != null) {
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.add(propertyValue);
                        }
                    }
                    i10++;
                }
                return jSONArray == null ? Collections.emptyList() : jSONArray;
            }
            return Integer.valueOf(list.size());
        }
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (SIZE != j10 && LENGTH != j10) {
                JSONArray jSONArray2 = new JSONArray(objArr.length);
                while (i10 < objArr.length) {
                    Object[] objArr2 = objArr[i10];
                    if (objArr2 == objArr) {
                        jSONArray2.add(objArr2);
                    } else {
                        Object propertyValue2 = getPropertyValue(objArr2, str, j10);
                        if (propertyValue2 instanceof Collection) {
                            jSONArray2.addAll((Collection) propertyValue2);
                        } else if (propertyValue2 != null) {
                            jSONArray2.add(propertyValue2);
                        }
                    }
                    i10++;
                }
                return jSONArray2;
            }
            return Integer.valueOf(objArr.length);
        }
        if (obj2 instanceof Enum) {
            Enum r82 = (Enum) obj2;
            if (-4270347329889690746L == j10) {
                return r82.name();
            }
            if (-1014497654951707614L == j10) {
                return Integer.valueOf(r82.ordinal());
            }
        }
        if (obj2 instanceof Calendar) {
            Calendar calendar = (Calendar) obj2;
            if (8963398325558730460L == j10) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j10) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j10) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j10) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j10) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j10) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    public Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path, e2);
            }
        }
        if (obj instanceof Map) {
            return ((Map) obj).values();
        }
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        throw new UnsupportedOperationException();
    }

    public void init() {
        if (this.segments != null) {
            return;
        }
        if (StringUtils.NO_PRINT_CODE.equals(this.path)) {
            this.segments = new Segment[]{WildCardSegment.instance};
            return;
        }
        JSONPathParser jSONPathParser = new JSONPathParser(this.path);
        this.segments = jSONPathParser.explain();
        this.hasRefSegment = jSONPathParser.hasRefSegment;
    }

    public Set<?> keySet(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i10 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 < segmentArr.length) {
                obj2 = segmentArr[i10].eval(this, obj, obj2);
                i10++;
            } else {
                return evalKeySet(obj2);
            }
        }
    }

    public boolean remove(Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = null;
        Object obj3 = obj;
        int i10 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                break;
            }
            if (i10 == segmentArr.length - 1) {
                obj2 = obj3;
                break;
            }
            obj3 = segmentArr[i10].eval(this, obj, obj3);
            if (obj3 == null) {
                break;
            }
            i10++;
        }
        if (obj2 == null) {
            return false;
        }
        Segment[] segmentArr2 = this.segments;
        Segment segment = segmentArr2[segmentArr2.length - 1];
        if (segment instanceof PropertySegment) {
            PropertySegment propertySegment = (PropertySegment) segment;
            if ((obj2 instanceof Collection) && segmentArr2.length > 1) {
                Segment segment2 = segmentArr2[segmentArr2.length - 2];
                if ((segment2 instanceof RangeSegment) || (segment2 instanceof MultiIndexSegment)) {
                    Iterator iterator2 = ((Collection) obj2).iterator2();
                    while (iterator2.hasNext()) {
                        if (propertySegment.remove(this, iterator2.next())) {
                            z10 = true;
                        }
                    }
                    return z10;
                }
            }
            return propertySegment.remove(this, obj2);
        }
        if (segment instanceof ArrayAccessSegment) {
            return ((ArrayAccessSegment) segment).remove(this, obj2);
        }
        throw new UnsupportedOperationException();
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i10) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i10 >= 0) {
                if (i10 >= list.size()) {
                    return false;
                }
                list.remove(i10);
                return true;
            }
            int size = list.size() + i10;
            if (size < 0) {
                return false;
            }
            list.remove(size);
            return true;
        }
        throw new JSONPathException("unsupported set operation." + ((Object) obj.getClass()));
    }

    public boolean removePropertyValue(Object obj, String str, boolean z10) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            r1 = map.remove(str) != null;
            if (z10) {
                Iterator iterator2 = map.values().iterator2();
                while (iterator2.hasNext()) {
                    removePropertyValue(iterator2.next(), str, z10);
                }
            }
            return r1;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            if (z10) {
                return false;
            }
            throw new UnsupportedOperationException();
        }
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        if (fieldDeserializer != null) {
            fieldDeserializer.setValue(obj, (String) null);
        } else {
            r1 = false;
        }
        if (z10) {
            for (Object obj2 : getPropertyValues(obj)) {
                if (obj2 != null) {
                    removePropertyValue(obj2, str, z10);
                }
            }
        }
        return r1;
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i10, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i10 >= 0) {
                list.set(i10, obj2);
            } else {
                list.set(list.size() + i10, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i10 >= 0) {
                if (i10 < length) {
                    Array.set(obj, i10, obj2);
                }
            } else if (Math.abs(i10) <= length) {
                Array.set(obj, length + i10, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + ((Object) cls));
    }

    public boolean setPropertyValue(Object obj, String str, long j10, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        }
        if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, j10, obj2);
                }
            }
            return true;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j10);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(obj, obj2);
            return true;
        }
        throw new UnsupportedOperationException();
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i10 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 < segmentArr.length) {
                obj2 = segmentArr[i10].eval(this, obj, obj2);
                i10++;
            } else {
                return evalSize(obj2);
            }
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str != null && str.length() != 0) {
            this.path = str;
            this.serializeConfig = serializeConfig;
            this.parserConfig = parserConfig;
            return;
        }
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, "/", obj, serializeConfig);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean set(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r11 = 0
            if (r9 != 0) goto L4
            return r11
        L4:
            r8.init()
            r0 = 0
            r2 = r9
            r3 = r0
            r1 = 0
        Lb:
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            r6 = 1
            if (r1 >= r5) goto L86
            r3 = r4[r1]
            java.lang.Object r4 = r3.eval(r8, r9, r2)
            if (r4 != 0) goto L81
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            int r5 = r5 - r6
            if (r1 >= r5) goto L24
            int r5 = r1 + 1
            r4 = r4[r5]
            goto L25
        L24:
            r4 = r0
        L25:
            boolean r5 = r4 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L61
            boolean r4 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r4 == 0) goto L4b
            r4 = r3
            com.alibaba.fastjson.JSONPath$PropertySegment r4 = (com.alibaba.fastjson.JSONPath.PropertySegment) r4
            java.lang.String r4 = com.alibaba.fastjson.JSONPath.PropertySegment.access$300(r4)
            java.lang.Class r5 = r2.getClass()
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r5)
            if (r5 == 0) goto L4b
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r5.getFieldDeserializer(r4)
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r4)
            goto L4d
        L4b:
            r4 = r0
            r5 = r4
        L4d:
            if (r5 == 0) goto L5b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r5.beanInfo
            java.lang.reflect.Constructor<?> r7 = r7.defaultConstructor
            if (r7 == 0) goto L5a
            java.lang.Object r4 = r5.createInstance(r0, r4)
            goto L6c
        L5a:
            return r11
        L5b:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            goto L6c
        L61:
            boolean r4 = r4 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r4 == 0) goto L6b
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            goto L6c
        L6b:
            r4 = r0
        L6c:
            if (r4 == 0) goto L87
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L78
            com.alibaba.fastjson.JSONPath$PropertySegment r3 = (com.alibaba.fastjson.JSONPath.PropertySegment) r3
            r3.setValue(r8, r2, r4)
            goto L81
        L78:
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r5 == 0) goto L87
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r3 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r3
            r3.setValue(r8, r2, r4)
        L81:
            int r1 = r1 + 1
            r3 = r2
            r2 = r4
            goto Lb
        L86:
            r2 = r3
        L87:
            if (r2 != 0) goto L8a
            return r11
        L8a:
            com.alibaba.fastjson.JSONPath$Segment[] r9 = r8.segments
            int r11 = r9.length
            int r11 = r11 - r6
            r9 = r9[r11]
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r11 == 0) goto L9a
            com.alibaba.fastjson.JSONPath$PropertySegment r9 = (com.alibaba.fastjson.JSONPath.PropertySegment) r9
            r9.setValue(r8, r2, r10)
            return r6
        L9a:
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r11 == 0) goto La5
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r9 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r9
            boolean r9 = r9.setValue(r8, r2, r10)
            return r9
        La5:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.set(java.lang.Object, java.lang.Object, boolean):boolean");
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static Set<?> keySet(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalKeySet(compile.eval(obj));
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        if (obj == null) {
            return;
        }
        int i10 = 0;
        if (map.put(obj, str) != null) {
            if (!((obj instanceof String) || (obj instanceof Number) || (obj instanceof Date) || (obj instanceof UUID))) {
                return;
            }
        }
        map2.put(str, obj);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb5 = new StringBuilder();
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(str);
                    }
                    sb5.append("/");
                    sb5.append(key);
                    paths(map, map2, sb5.toString(), entry.getValue(), serializeConfig);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb4 = new StringBuilder();
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(str);
                }
                sb4.append("/");
                sb4.append(i10);
                paths(map, map2, sb4.toString(), obj2, serializeConfig);
                i10++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i10 < length) {
                Object obj3 = Array.get(obj, i10);
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i10);
                paths(map, map2, sb3.toString(), obj3, serializeConfig);
                i10++;
            }
            return;
        }
        if (ParserConfig.isPrimitive2(cls) || cls.isEnum()) {
            return;
        }
        ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            try {
                for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                    String key2 = entry2.getKey();
                    if (key2 instanceof String) {
                        if (str.equals("/")) {
                            sb2 = new StringBuilder();
                            sb2.append("/");
                            sb2.append(key2);
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append("/");
                            sb2.append(key2);
                        }
                        paths(map, map2, sb2.toString(), entry2.getValue(), serializeConfig);
                    }
                }
            } catch (Exception e2) {
                throw new JSONException("toJSON error", e2);
            }
        }
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig, int i10, Feature... featureArr) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i10 | Feature.OrderedField.mask);
        Object extract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return extract;
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static Object extract(String str, String str2) {
        return extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }
}
