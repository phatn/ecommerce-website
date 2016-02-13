package com.manifera.meshop.core.dao.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.ProductPriceRange;

public class ProductPriceRangeTest extends AbstractDomainTest {

	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			//createPriceRanges();
			List<Long> ids = new ArrayList<>();
			ids.add(52L);
			ids.add(53L);
			ids.add(54L);
			ids.add(55L);
			ids.add(56L);
			ids.add(57L);
			ids.add(102L);
			
			for(Long id : ids) {
				DecimalFormat df = new DecimalFormat("###");
				df.setMinimumFractionDigits(0);
				ProductPriceRange range = productPriceRangeDao.get(id);
				System.out.println(range);
				String sefUrl = "";
				if(range.getMin().unscaledValue().equals(BigInteger.ZERO)) {
					sefUrl = "below-";
					String a = df.format(range.getMax());
					sefUrl = sefUrl + a;
				} else if (range.getMax() == null) {
					sefUrl = "above-" + df.format(range.getMin());
				} else {
					sefUrl = "from-" + df.format(range.getMin()) +  
							"-to-" + df.format(range.getMax());
				}
				range.setSefUrl(sefUrl);
				System.out.println(sefUrl);
				System.out.println();
			}
			tx.commit();
		} catch(Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			ex.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		} finally {
			closeEntityManager();
		}
		
		System.out.println("\n========== DONE ============");
	}
	public static void createPriceRanges() {
		
		List<ProductPriceRange> ranges = new ArrayList<>();
		
		ProductPriceRange range0_500 = new ProductPriceRange();
		range0_500.setMin(BigDecimal.ZERO);
		range0_500.setMax(new BigDecimal(500));
		range0_500.setSortOrder(1);
		ranges.add(range0_500);
		
		ProductPriceRange range500_1000 = new ProductPriceRange();
		range500_1000.setMin(new BigDecimal(500));
		range500_1000.setMax(new BigDecimal(1000));
		range500_1000.setSortOrder(2);
		ranges.add(range500_1000);
		
		
		ProductPriceRange range1000_1500 = new ProductPriceRange();
		range1000_1500.setMin(new BigDecimal(1000));
		range1000_1500.setMax(new BigDecimal(1500));
		range1000_1500.setSortOrder(3);
		ranges.add(range1000_1500);
		
		ProductPriceRange range1500_2000 = new ProductPriceRange();
		range1500_2000.setMin(new BigDecimal(1500));
		range1500_2000.setMax(new BigDecimal(2000));
		range1500_2000.setSortOrder(4);
		ranges.add(range1500_2000);
				
		ProductPriceRange range2000_2500 = new ProductPriceRange();
		range2000_2500.setMin(new BigDecimal(2000));
		range2000_2500.setMax(new BigDecimal(2500));
		range2000_2500.setSortOrder(5);
		ranges.add(range2000_2500);
		
		ProductPriceRange range2500_3000 = new ProductPriceRange();
		range2500_3000.setMin(new BigDecimal(2500));
		range2500_3000.setMax(new BigDecimal(3000));
		range2500_3000.setSortOrder(5);
		ranges.add(range2500_3000);
		
		ProductPriceRange rangeAbove3000 = new ProductPriceRange();
		rangeAbove3000.setMin(new BigDecimal(3000));
		rangeAbove3000.setMax(null);
		rangeAbove3000.setSortOrder(6);
		ranges.add(rangeAbove3000);
		
		for(ProductPriceRange range : ranges) {
			productPriceRangeDao.create(range);
		}
	}
}
