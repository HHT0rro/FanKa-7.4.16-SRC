package com.amap.api.services.busline;

import com.amap.api.col.s.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f8387a;

    /* renamed from: b, reason: collision with root package name */
    private String f8388b;

    /* renamed from: c, reason: collision with root package name */
    private int f8389c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f8390d = 1;

    public BusStationQuery(String str, String str2) {
        this.f8387a = str;
        this.f8388b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !n.a(this.f8387a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        String str = this.f8388b;
        if (str == null) {
            if (busStationQuery.f8388b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f8388b)) {
            return false;
        }
        if (this.f8390d != busStationQuery.f8390d || this.f8389c != busStationQuery.f8389c) {
            return false;
        }
        String str2 = this.f8387a;
        if (str2 == null) {
            if (busStationQuery.f8387a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f8387a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f8388b;
    }

    public int getPageNumber() {
        return this.f8390d;
    }

    public int getPageSize() {
        return this.f8389c;
    }

    public String getQueryString() {
        return this.f8387a;
    }

    public int hashCode() {
        String str = this.f8388b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f8390d) * 31) + this.f8389c) * 31;
        String str2 = this.f8387a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f8388b = str;
    }

    public void setPageNumber(int i10) {
        if (i10 <= 0) {
            i10 = 1;
        }
        this.f8390d = i10;
    }

    public void setPageSize(int i10) {
        this.f8389c = i10;
    }

    public void setQueryString(String str) {
        this.f8387a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f8388b;
        if (str == null) {
            if (busStationQuery.f8388b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f8388b)) {
            return false;
        }
        if (this.f8389c != busStationQuery.f8389c) {
            return false;
        }
        String str2 = this.f8387a;
        if (str2 == null) {
            if (busStationQuery.f8387a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f8387a)) {
            return false;
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusStationQuery m1973clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f8387a, this.f8388b);
        busStationQuery.setPageNumber(this.f8390d);
        busStationQuery.setPageSize(this.f8389c);
        return busStationQuery;
    }
}
