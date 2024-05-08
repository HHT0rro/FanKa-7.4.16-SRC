package o0;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final ValueSet f52238b = c(0).a();

    /* renamed from: c, reason: collision with root package name */
    public static final Bridge f52239c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<Object> f52240a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements ValueSet {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<Object> f52241a;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i10, Class<T> cls) {
            Object obj = this.f52241a.get(i10);
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
            return this.f52241a.indexOfKey(i10) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i10) {
            Object obj = this.f52241a.get(i10);
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
            int size = this.f52241a.size();
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < size; i10++) {
                hashSet.add(Integer.valueOf(this.f52241a.keyAt(i10)));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10) {
            return longValue(i10, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i10, Class<T> cls) {
            ValueSet.ValueGetter valueGetter = (T) this.f52241a.get(i10);
            if (valueGetter instanceof ValueSet.ValueGetter) {
                valueGetter = (T) valueGetter.get();
            }
            if (cls.isInstance(valueGetter)) {
                return (T) valueGetter;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f52241a;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10) {
            return stringValue(i10, null);
        }

        public b(SparseArray<Object> sparseArray) {
            this.f52241a = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i10, boolean z10) {
            Object obj = this.f52241a.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i10, float f10) {
            Object obj = this.f52241a.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i10, int i11) {
            Object obj = this.f52241a.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i11;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10, long j10) {
            Object obj = this.f52241a.get(i10);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10, String str) {
            Object obj = this.f52241a.get(i10);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements Bridge {
        public c() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class) {
                return (T) Boolean.FALSE;
            }
            if (cls != Integer.TYPE && cls != Integer.class) {
                if (cls != Long.TYPE && cls != Long.class) {
                    if (cls != Double.TYPE && cls != Double.class) {
                        if (cls == Float.TYPE || cls == Float.class) {
                            return (T) new Float(0.0f);
                        }
                        return null;
                    }
                    return (T) new Double(ShadowDrawableWrapper.COS_45);
                }
                return (T) new Long(0L);
            }
            return (T) new Integer(0);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return a.f52238b;
        }
    }

    public a(SparseArray<Object> sparseArray) {
        this.f52240a = sparseArray;
    }

    public static final a b() {
        return new a(new SparseArray());
    }

    public static final a c(int i10) {
        return new a(new SparseArray(i10));
    }

    public static final a k(ValueSet valueSet) {
        if (valueSet != null && !valueSet.isEmpty()) {
            SparseArray sparseArray = new SparseArray(valueSet.size());
            for (Integer num : valueSet.keys()) {
                if (valueSet instanceof b) {
                    sparseArray.put(num.intValue(), ((b) valueSet).f52241a.get(num.intValue()));
                } else {
                    sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
                }
            }
            return new a(sparseArray);
        }
        return new a(new SparseArray());
    }

    public ValueSet a() {
        return new b(this.f52240a);
    }

    public a d(int i10, double d10) {
        this.f52240a.put(i10, Double.valueOf(d10));
        return this;
    }

    public a e(int i10, float f10) {
        this.f52240a.put(i10, Float.valueOf(f10));
        return this;
    }

    public a f(int i10, int i11) {
        this.f52240a.put(i10, Integer.valueOf(i11));
        return this;
    }

    public a g(int i10, long j10) {
        this.f52240a.put(i10, Long.valueOf(j10));
        return this;
    }

    public a h(int i10, Object obj) {
        this.f52240a.put(i10, obj);
        return this;
    }

    public a i(int i10, String str) {
        this.f52240a.put(i10, str);
        return this;
    }

    public a j(int i10, boolean z10) {
        this.f52240a.put(i10, Boolean.valueOf(z10));
        return this;
    }
}
