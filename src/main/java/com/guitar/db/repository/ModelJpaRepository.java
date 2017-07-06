package com.guitar.db.repository;

import com.guitar.db.model.Model;
import com.guitar.db.model.projections.ModelDetailView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestResource(excerptProjection = ModelDetailView.class)
public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

    List<Model> findByModelTypeNameIn(List<String> types);

    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
    Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
                                             @Param("highest") BigDecimal highest,
                                             @Param("wood") String wood,
                                             Pageable page);

    List<Model> findAllModelsByType(@Param("name") String name);
}
