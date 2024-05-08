package com.mobile.auth.gatewayauth.manager.base;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.jsoner.Jsoner;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Cache<T> implements Serializable {
    private long expiredTime;
    private String key;
    private T value;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private String f37285a;

        /* renamed from: b, reason: collision with root package name */
        private T f37286b;

        /* renamed from: c, reason: collision with root package name */
        private long f37287c;

        private a() {
        }

        public static /* synthetic */ String a(a aVar) {
            try {
                return aVar.f37285a;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }

        public static /* synthetic */ Object b(a aVar) {
            try {
                return aVar.f37286b;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }

        public static /* synthetic */ long c(a aVar) {
            try {
                return aVar.f37287c;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1L;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1L;
                }
            }
        }

        public a a(long j10) {
            try {
                this.f37287c = j10;
                return this;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }

        public a a(T t2) {
            try {
                this.f37286b = t2;
                return this;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }

        public a a(String str) {
            try {
                this.f37285a = str;
                return this;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }

        public Cache a() {
            try {
                return new Cache(this);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
    }

    public Cache() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Cache(a<T> aVar) {
        setKey(a.a((a) aVar));
        setValue(a.b(aVar));
        setExpiredTime(a.c(aVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Cache<T> fromJson(JSONObject jSONObject, JsonType<T> jsonType) {
        try {
            Cache<T> cache = (Cache<T>) new Cache();
            ArrayList arrayList = new ArrayList();
            JSONUtils.fromJson(jSONObject, cache, arrayList);
            if (arrayList.size() > 0) {
                T newInstance = jsonType.newInstance();
                if (newInstance instanceof Jsoner) {
                    ((Jsoner) newInstance).fromJson(jSONObject.optJSONObject("value"));
                    cache.setValue(newInstance);
                } else if (JSONUtils.isOriginalBoolean(newInstance.getClass()) || JSONUtils.isOriginalChar(newInstance.getClass()) || JSONUtils.isOriginalNumber(newInstance.getClass()) || JSONUtils.isOriginalString(newInstance.getClass())) {
                    cache.setValue(jSONObject.opt("value"));
                }
            }
            return cache;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static a newIpCache() {
        try {
            return new a();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public synchronized void clear() {
        try {
            this.key = null;
            this.value = null;
            this.expiredTime = 0L;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized long getExpiredTime() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1L;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1L;
            }
        }
        return this.expiredTime;
    }

    public synchronized String getKey() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return this.key;
    }

    public synchronized T getValue() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return this.value;
    }

    public synchronized boolean isValid() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
        return System.currentTimeMillis() < this.expiredTime;
    }

    public synchronized void setExpiredTime(long j10) {
        try {
            this.expiredTime = j10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized void setKey(String str) {
        try {
            this.key = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized void setValue(T t2) {
        try {
            this.value = t2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public JSONObject toJson() {
        Class<?> cls;
        T t2;
        Object obj;
        try {
            JSONObject json = JSONUtils.toJson(this, new ArrayList());
            try {
                cls = this.value.getClass();
                t2 = this.value;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!(t2 instanceof Jsoner)) {
                if (JSONUtils.isOriginalBoolean(cls) || JSONUtils.isOriginalChar(cls) || JSONUtils.isOriginalNumber(cls) || JSONUtils.isOriginalString(cls)) {
                    obj = this.value;
                }
                return json;
            }
            obj = ((Jsoner) t2).toJson();
            json.put("value", obj);
            return json;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
