package com.dealersocket.idsm.resources;

import java.util.List;

import com.dealersocket.idsm.model.PageMetadata;

public class VehiclePageResource<T> {
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
