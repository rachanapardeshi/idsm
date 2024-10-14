package com.dealersocket.idsm.utility;


import org.springframework.data.domain.Page;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.RepresentationModel;


import java.util.ArrayList;
import java.util.List;


/**
 * A replacement for PagedResourcesAssembler which doesn't emit the "_embedded" tag.
 * @param <Domain> Domain class
 * @param <R> EntityModel class
 */
public class PagedCollectionRepresentationModelAssembler<Domain, R extends RepresentationModel<?>>  {
    public PagedCollectionResource<R> toModel(Page<Domain> page, RepresentationModelAssembler<Domain, R> resourceAssembler) {
        List<R> items = new ArrayList<>();
        for (Domain d : page.getContent()) {
            items.add(resourceAssembler.toModel(d));
        }
        PagedCollectionResource.PageMetadata pageMetadata = new PagedCollectionResource.PageMetadata();
        pageMetadata.number = page.getNumber();
        pageMetadata.size = page.getSize();
        pageMetadata.totalElements = page.getTotalElements();
        pageMetadata.totalPages = page.getTotalPages();

        PagedCollectionResource<R> rtn = new PagedCollectionResource<>(items, pageMetadata);
        return rtn;
    }
}
