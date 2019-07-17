package com.common.utils;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PagedResult<T> {
    List<T> items;
    long totalCount;

    public PagedResult() {
    }

    public PagedResult(List<T> items) {
        this();
        this.items = items;
    }

    public PagedResult(List<T> items, long totalCount) {
        this(items);
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return this.items;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PagedResult)) {
            return false;
        } else {
            PagedResult<?> other = (PagedResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items == null) {
                        return this.getTotalCount() == other.getTotalCount();
                    }
                } else if (this$items.equals(other$items)) {
                    return this.getTotalCount() == other.getTotalCount();
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PagedResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        long $totalCount = this.getTotalCount();
        result = result * 59 + (int)($totalCount >>> 32 ^ $totalCount);
        return result;
    }

    public String toString() {
        return "PagedResult(items=" + this.getItems() + ", totalCount=" + this.getTotalCount() + ")";
    }
}