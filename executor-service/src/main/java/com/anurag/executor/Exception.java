package com.anurag.executor;

import java.util.Date;
import java.util.Objects;

import lombok.Getter;

@Getter
public class Exception {

    private final long timeRange = 15;
    private long timeStamp;
    private Date lowerTimeBound;
    private Date upperTimeBound;
    private String type;
    private String requestId;

    public Exception setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        this.lowerTimeBound = getLowerTimeForGivenTimeRange(timeStamp, timeRange);
        this.upperTimeBound = new Date(this.lowerTimeBound.getTime() + timeRange * 60 * 1000);
        return this;
    }

    private Date getLowerTimeForGivenTimeRange(long timeMs, long range) {
        long time = Math.round(((double) timeMs / (double) (range * 60 * 1000))) * (range * 60 * 1000);
        return new Date(time);
    }


    public Exception setType(String type) {
        this.type = type;
        return this;
    }


    public Exception setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Exception)) {
            return false;
        }
        Exception that = (Exception) o;
        return Objects.equals(getLowerTimeBound(), that.getLowerTimeBound()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLowerTimeBound(), getType());
    }

}
