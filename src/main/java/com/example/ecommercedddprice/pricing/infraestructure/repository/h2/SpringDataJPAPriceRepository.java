package com.example.ecommercedddprice.pricing.infraestructure.repository.h2;

import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataJPAPriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query(value =
      "SELECT p.product_id as productId, p.brand_id as brandId, p.price_list as priceList, "
          + " p.start_date as startDate, p.end_date as endDate, p.selling_price as sellingPrice "
          + " FROM price p "
          + " WHERE p.product_id= :#{#priceFilterDto.productId} AND "
          + "      p.brand_id= :#{#priceFilterDto.brandId} AND "
          + "      :#{#priceFilterDto.localDateTime} BETWEEN p.start_date AND p.end_date "
          + " ORDER BY p.priority DESC, p.creation_timestamp DESC, p.id DESC "
          + " LIMIT 1", nativeQuery = true)
  Optional<IFullPrice> getPriceByFilter(
      @Param("priceFilterDto") PriceFilterDto priceFilterDto);
}
