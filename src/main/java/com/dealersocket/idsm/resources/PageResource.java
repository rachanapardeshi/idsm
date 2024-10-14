package com.dealersocket.idsm.resources;

import java.util.List;

import org.springframework.hateoas.PagedModel.PageMetadata;

public class PageResource<T> {
    private List<T> items;
    private PageMetadata page;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PageMetadata getPage() {
        return page;
    }

    public void setPage(PageMetadata page) {
        this.page = page;
    }
}
