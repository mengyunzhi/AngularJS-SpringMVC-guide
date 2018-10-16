package com.mengyunzhi.SpringMvcStudy;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.BaseJsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.KlassJsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JsonPage<T> extends org.springframework.data.domain.PageImpl<T> {

    public JsonPage(final List<T> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }

    public JsonPage(final List<T> content) {
        super(content);
    }

    public JsonPage(final Page<T> page, final Pageable pageable) {
        super(page.getContent(), pageable, page.getTotalElements());
    }

    @JsonView({BaseJsonView.class})
    public int getTotalPages() {
        return super.getTotalPages();
    }

    @JsonView({BaseJsonView.class})
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @JsonView({BaseJsonView.class})
    public boolean hasNext() {
        return super.hasNext();
    }

    @JsonView({BaseJsonView.class})
    public boolean isLast() {
        return super.isLast();
    }

    @JsonView({BaseJsonView.class})
    public boolean hasContent() {
        return super.hasContent();
    }

    @JsonView({BaseJsonView.class})
    public List<T> getContent() {
        return super.getContent();
    }
}
