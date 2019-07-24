package com.chingkwok.utils.interfaceFun;

import java.util.List;

/**
 * Created by guojingye on 2019/7/24
 */
@FunctionalInterface
public interface PagedResultHandler<T> {
    List<T> handle();
}
