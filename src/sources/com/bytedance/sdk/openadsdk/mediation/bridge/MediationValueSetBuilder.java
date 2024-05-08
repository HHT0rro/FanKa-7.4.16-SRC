package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationValueSetBuilder {

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<Object> f11298m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ValueSetImpl implements ValueSet {

        /* renamed from: m, reason: collision with root package name */
        private final SparseArray<Object> f11299m;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i10, Class<T> cls) {
            Object obj = this.f11299m.get(i10);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i10) {
            return booleanValue(i10, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i10) {
            return this.f11299m.indexOfKey(i10) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i10) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : ShadowDrawableWrapper.COS_45;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i10) {
            return floatValue(i10, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i10) {
            return intValue(i10, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f11299m.size();
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < size; i10++) {
                hashSet.add(Integer.valueOf(i10));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10) {
            return longValue(i10, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i10, Class<T> cls) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.f11299m.get(i10);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f11299m;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10) {
            return stringValue(i10, null);
        }

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.f11299m = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i10, boolean z10) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i10, float f10) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i10, int i11) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i11;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10, long j10) {
            Object obj = this.f11299m.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10, String str) {
            Object obj = this.f11299m.get(i10);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f11298m = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i10, Object obj) {
        this.f11298m.put(i10, obj);
        return this;
    }

    public <T> MediationValueSetBuilder addArray(int i10, T[] tArr) {
        this.f11298m.put(i10, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f11298m);
    }

    public static final MediationValueSetBuilder create(ValueSet valueSet) {
        if (valueSet != null && !valueSet.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            for (Integer num : valueSet.keys()) {
                sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
            }
            return new MediationValueSetBuilder(sparseArray);
        }
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i10, String str) {
        this.f11298m.put(i10, str);
        return this;
    }

    public MediationValueSetBuilder add(int i10, int i11) {
        this.f11298m.put(i10, Integer.valueOf(i11));
        return this;
    }

    public MediationValueSetBuilder add(int i10, double d10) {
        this.f11298m.put(i10, Double.valueOf(d10));
        return this;
    }

    public MediationValueSetBuilder add(int i10, boolean z10) {
        this.f11298m.put(i10, Boolean.valueOf(z10));
        return this;
    }

    public MediationValueSetBuilder add(int i10, long j10) {
        this.f11298m.put(i10, Long.valueOf(j10));
        return this;
    }

    public MediationValueSetBuilder add(int i10, float f10) {
        this.f11298m.put(i10, Float.valueOf(f10));
        return this;
    }

    public MediationValueSetBuilder add(int i10, ObjectGetter objectGetter) {
        this.f11298m.put(i10, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, StringGetter stringGetter) {
        this.f11298m.put(i10, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, DoubleGetter doubleGetter) {
        this.f11298m.put(i10, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, IntGetter intGetter) {
        this.f11298m.put(i10, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, BooleanGetter booleanGetter) {
        this.f11298m.put(i10, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, LongGetter longGetter) {
        this.f11298m.put(i10, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i10, FloatGetter floatGetter) {
        this.f11298m.put(i10, floatGetter);
        return this;
    }
}
