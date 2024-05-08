package com.mobile.auth.gatewayauth.detectnet;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JSONUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DetectResult implements Serializable {
    private boolean cuCellularConnected;
    private long cuCellularWholeMS;
    private Set<String> requestIds = new HashSet();
    private Collection<String> sessionIds = new HashSet();
    private boolean topCellularConnected;
    private long topCellularWholeMS;
    private boolean topConnected;
    private long topWholeMS;
    private String vendorKey;

    public long getCuCellularWholeMS() {
        try {
            return this.cuCellularWholeMS;
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

    public Set<String> getRequestIds() {
        try {
            return this.requestIds;
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

    public Collection<String> getSessionIds() {
        try {
            return this.sessionIds;
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

    public long getTopCellularWholeMS() {
        try {
            return this.topCellularWholeMS;
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

    public long getTopWholeMS() {
        try {
            return this.topWholeMS;
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

    public String getVendorKey() {
        try {
            return this.vendorKey;
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

    public boolean isCuCellularConnected() {
        try {
            return this.cuCellularConnected;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean isTopCellularConnected() {
        try {
            return this.topCellularConnected;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean isTopConnected() {
        try {
            return this.topConnected;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public DetectResult setCuCellularConnected(boolean z10) {
        try {
            this.cuCellularConnected = z10;
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

    public DetectResult setCuCellularWholeMS(long j10) {
        try {
            this.cuCellularWholeMS = j10;
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

    public DetectResult setRequestIds(Set<String> set) {
        try {
            this.requestIds = set;
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

    public DetectResult setSessionIds(Collection<String> collection) {
        try {
            this.sessionIds = collection;
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

    public DetectResult setSessionIds(Set<String> set) {
        try {
            this.sessionIds = set;
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

    public DetectResult setTopCellularConnected(boolean z10) {
        try {
            this.topCellularConnected = z10;
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

    public DetectResult setTopCellularWholeMS(long j10) {
        try {
            this.topCellularWholeMS = j10;
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

    public DetectResult setTopConnected(boolean z10) {
        try {
            this.topConnected = z10;
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

    public DetectResult setTopWholeMS(long j10) {
        try {
            this.topWholeMS = j10;
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

    public DetectResult setVendorKey(String str) {
        try {
            this.vendorKey = str;
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

    public String toJson() {
        try {
            JSONObject json = JSONUtils.toJson(this, null);
            try {
                json.put("requestId", JSONUtils.jsonerCollectionString2JsonArray(this.requestIds));
                json.put("sessionId", JSONUtils.jsonerCollectionString2JsonArray(this.sessionIds));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json.toString();
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

    public String toString() {
        try {
            return "DetectResult{requestIds=" + ((Object) this.requestIds) + ", sessionIds=" + ((Object) this.sessionIds) + ", topConnected=" + this.topConnected + ", topCellularConnected=" + this.topCellularConnected + ", topWholeMS=" + this.topWholeMS + ", topCellularWholeMS=" + this.topCellularWholeMS + ", cuCellularConnected=" + this.cuCellularConnected + ", cuCellularWholeMS=" + this.cuCellularWholeMS + ", vendorKey='" + this.vendorKey + "'}";
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
