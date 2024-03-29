package com.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : Pageable
 * @Author : yq
 * @Date: 2021-07-28
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pageable<T> {

    @Builder.Default
    private Integer pageSize = 10;

    @Builder.Default
    private Integer pageNo = 1;

    @Builder.Default
    private Long total = 0L;

    @Builder.Default
    private Long totalPage = 0L;

    private List<T> data = Collections.emptyList();

    public static <T> Pageable<T> of(List<T> data, Long total, Integer pageNo, Integer pageSize) {

        Pageable<T> pageable = new Pageable<>();
        return pageable.instance(data, total, pageNo, pageSize);
    }

    private Pageable<T> instance(List<T> data, Long total, int pageNo, int pageSize) {
        this.pageSize = pageSize;
        this.total = total;
        this.pageNo = pageNo;
        this.totalPage = total / pageSize + (total % pageSize == 0 ? 0 : 1);
        if (data != null) {
            this.data = data;
        }
        return this;
    }

    @Transient
    public Integer getSkip() {
        if (pageNo > 0 && pageSize > 0) {
            return (pageNo - 1) * pageSize;
        }
        return 0;
    }
}
