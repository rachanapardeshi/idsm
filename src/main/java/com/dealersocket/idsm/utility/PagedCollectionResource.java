package com.dealersocket.idsm.utility;


import java.util.List;

import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="PagedCollectionResource")
public class PagedCollectionResource<ItemType> extends RepresentationModel {
    public List<ItemType> items;
    public PageMetadata page;

    public PagedCollectionResource(List<ItemType> items, PageMetadata page) {
        this.items = items;
        this.page = page;
    }

    @Schema(name="PageMetadata")
    public static class PageMetadata {
        public long size;
        public long totalElements;
        public long totalPages;
        public long number;
    }
    
    @Override
    public Links getLinks() {
        return null;
    }
}
