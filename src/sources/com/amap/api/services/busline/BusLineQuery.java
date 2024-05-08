package com.amap.api.services.busline;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f8368a;

    /* renamed from: b, reason: collision with root package name */
    private String f8369b;

    /* renamed from: e, reason: collision with root package name */
    private SearchType f8372e;

    /* renamed from: c, reason: collision with root package name */
    private int f8370c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f8371d = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f8373f = "base";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f8368a = str;
        this.f8372e = searchType;
        this.f8369b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.f8372e != busLineQuery.f8372e) {
            return false;
        }
        String str = this.f8369b;
        if (str == null) {
            if (busLineQuery.f8369b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.f8369b)) {
            return false;
        }
        if (this.f8371d != busLineQuery.f8371d || this.f8370c != busLineQuery.f8370c) {
            return false;
        }
        String str2 = this.f8368a;
        if (str2 == null) {
            if (busLineQuery.f8368a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f8368a)) {
            return false;
        }
        String str3 = this.f8373f;
        if (str3 == null) {
            if (busLineQuery.f8373f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f8373f)) {
            return false;
        }
        return true;
    }

    public SearchType getCategory() {
        return this.f8372e;
    }

    public String getCity() {
        return this.f8369b;
    }

    public String getExtensions() {
        return this.f8373f;
    }

    public int getPageNumber() {
        return this.f8371d;
    }

    public int getPageSize() {
        return this.f8370c;
    }

    public String getQueryString() {
        return this.f8368a;
    }

    public int hashCode() {
        SearchType searchType = this.f8372e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f8369b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f8371d) * 31) + this.f8370c) * 31;
        String str2 = this.f8368a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8373f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.f8372e = searchType;
    }

    public void setCity(String str) {
        this.f8369b = str;
    }

    public void setExtensions(String str) {
        this.f8373f = str;
    }

    public void setPageNumber(int i10) {
        if (i10 <= 0) {
            i10 = 1;
        }
        this.f8371d = i10;
    }

    public void setPageSize(int i10) {
        this.f8370c = i10;
    }

    public void setQueryString(String str) {
        this.f8368a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f8368a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f8368a)) {
            return false;
        }
        if (this.f8369b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f8369b)) {
            return false;
        }
        return this.f8370c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.f8372e) == 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusLineQuery m1972clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f8368a, this.f8372e, this.f8369b);
        busLineQuery.setPageNumber(this.f8371d);
        busLineQuery.setPageSize(this.f8370c);
        busLineQuery.setExtensions(this.f8373f);
        return busLineQuery;
    }
}
