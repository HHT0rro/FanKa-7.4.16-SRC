package com.huawei.quickcard.framework.value;

import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.watcher.Expression;
import org.json.JSONArray;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardValue {
    public static final QuickCardValue EMPTY = new EmptyObject(null);

    /* renamed from: a, reason: collision with root package name */
    private Number f33971a;

    /* renamed from: b, reason: collision with root package name */
    private String f33972b;

    /* renamed from: c, reason: collision with root package name */
    private float f33973c;

    /* renamed from: d, reason: collision with root package name */
    private float f33974d;

    /* renamed from: e, reason: collision with root package name */
    private Object f33975e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33976f;

    /* renamed from: g, reason: collision with root package name */
    private Expression f33977g;

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f33978h;

    /* renamed from: i, reason: collision with root package name */
    private JSONArray f33979i;

    /* renamed from: j, reason: collision with root package name */
    private CardDataObject f33980j;

    /* renamed from: k, reason: collision with root package name */
    private float f33981k;

    /* renamed from: l, reason: collision with root package name */
    private float f33982l;
    public ValueType valueType;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class BooleanValue extends QuickCardValue {
        public BooleanValue(boolean z10) {
            this.valueType = ValueType.BOOL;
            setBoolean(z10);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getBoolean());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DataWrapperValue extends QuickCardValue {
        public DataWrapperValue(CardDataObject cardDataObject) {
            this.valueType = ValueType.WRAPPER;
            setDataWrapper(cardDataObject);
        }

        @NonNull
        public String toString() {
            return getDataWrapper().toJSON().toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DpValue extends QuickCardValue {
        public DpValue(float f10) {
            this.valueType = ValueType.DP;
            setDp(f10);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getDp());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class EmptyObject extends ObjectValue {
        public EmptyObject(Object obj) {
            super(obj);
        }

        @Override // com.huawei.quickcard.framework.value.QuickCardValue.ObjectValue
        @NonNull
        public String toString() {
            return "";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class ExpressionValue extends QuickCardValue {
        public ExpressionValue(Expression expression) {
            this.valueType = ValueType.EXPRESSION;
            setExpression(expression);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getExpression());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class JSONArrayValue extends QuickCardValue {
        public JSONArrayValue(JSONArray jSONArray) {
            this.valueType = ValueType.JSON_ARRAY;
            setJsonArray(jSONArray);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getJsonArray());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class JSONValue extends QuickCardValue {
        public JSONValue(JSONObject jSONObject) {
            this.valueType = ValueType.JSON_OBJECT;
            setJson(jSONObject);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getJson());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class NumberValue extends QuickCardValue {
        public NumberValue(Number number) {
            this.valueType = ValueType.NUMBER;
            setNumber(number);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getNumber());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class ObjectValue extends QuickCardValue {
        public ObjectValue(Object obj) {
            this.valueType = ValueType.OBJECT;
            setObject(obj);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getObject());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Percent extends QuickCardValue {
        public Percent(float f10) {
            this.valueType = ValueType.PERCENT;
            setPercent(f10);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getPercent());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class PxValue extends QuickCardValue {
        public PxValue(float f10) {
            this.valueType = ValueType.PX;
            setPx(f10);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getPx());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class SpValue extends QuickCardValue {
        public SpValue(float f10) {
            this.valueType = ValueType.SP;
            setSp(f10);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getSp());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class StringValue extends QuickCardValue {
        public StringValue(String str) {
            this.valueType = ValueType.STRING;
            setString(str);
        }

        @NonNull
        public String toString() {
            return String.valueOf(getString());
        }
    }

    private static QuickCardValue a(String str) {
        String trim = str.trim();
        if (trim.startsWith("${") && trim.endsWith(i.f4738d)) {
            return new ExpressionValue(Expression.create(trim));
        }
        return new StringValue(trim);
    }

    public static QuickCardValue wrap(Object obj) {
        if (obj == null) {
            return EMPTY;
        }
        if (obj instanceof Number) {
            return new NumberValue((Number) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        if (obj instanceof Boolean) {
            return new BooleanValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof JSONObject) {
            return new JSONValue((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return new JSONArrayValue((JSONArray) obj);
        }
        if (obj instanceof CardDataObject) {
            return new DataWrapperValue((CardDataObject) obj);
        }
        return new ObjectValue(obj);
    }

    public boolean getBoolean() {
        return this.f33976f;
    }

    public CardDataObject getDataWrapper() {
        return this.f33980j;
    }

    public float getDp() {
        return this.f33973c;
    }

    public Expression getExpression() {
        return this.f33977g;
    }

    public JSONObject getJson() {
        return this.f33978h;
    }

    public JSONArray getJsonArray() {
        return this.f33979i;
    }

    public Number getNumber() {
        return this.f33971a;
    }

    public Object getObject() {
        return this.f33975e;
    }

    public float getPercent() {
        return this.f33974d;
    }

    public float getPx() {
        return this.f33982l;
    }

    public float getSp() {
        return this.f33981k;
    }

    public String getString() {
        return this.f33972b;
    }

    public ValueType getValueType() {
        return this.valueType;
    }

    public boolean isBool() {
        return this.valueType == ValueType.BOOL;
    }

    public boolean isDp() {
        return this.valueType == ValueType.DP;
    }

    public boolean isExpression() {
        return this.valueType == ValueType.EXPRESSION;
    }

    public boolean isJson() {
        return this.valueType == ValueType.JSON_OBJECT;
    }

    public boolean isJsonArray() {
        return this.valueType == ValueType.JSON_ARRAY;
    }

    public boolean isNumber() {
        return this.valueType == ValueType.NUMBER;
    }

    public boolean isObject() {
        return this.valueType == ValueType.OBJECT;
    }

    public boolean isPercent() {
        return this.valueType == ValueType.PERCENT;
    }

    public boolean isPx() {
        return this.valueType == ValueType.PX;
    }

    public boolean isSp() {
        return this.valueType == ValueType.SP;
    }

    public boolean isString() {
        return this.valueType == ValueType.STRING;
    }

    public boolean isWrapper() {
        return this.valueType == ValueType.WRAPPER;
    }

    public void setBoolean(boolean z10) {
        this.f33976f = z10;
    }

    public void setDataWrapper(CardDataObject cardDataObject) {
        this.f33980j = cardDataObject;
    }

    public void setDp(float f10) {
        this.f33973c = f10;
    }

    public void setExpression(Expression expression) {
        this.f33977g = expression;
    }

    public void setJson(JSONObject jSONObject) {
        this.f33978h = jSONObject;
    }

    public void setJsonArray(JSONArray jSONArray) {
        this.f33979i = jSONArray;
    }

    public void setNumber(Number number) {
        this.f33971a = number;
    }

    public void setObject(Object obj) {
        this.f33975e = obj;
    }

    public void setPercent(float f10) {
        this.f33974d = f10;
    }

    public void setPx(float f10) {
        this.f33982l = f10;
    }

    public void setSp(float f10) {
        this.f33981k = f10;
    }

    public void setString(String str) {
        this.f33972b = str;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
