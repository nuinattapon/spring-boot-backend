package me.nattapon.backend;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestProductService {

	@Autowired

	private ProductService service;

	@Order(1)
	@Test
	void testCreate() throws BaseException {
		Product entity = service.create(
				TestCreateData.name, TestCreateData.price
		);

		// check not null
		Assertions.assertNotNull(entity);
		Assertions.assertNotNull(entity.getId());

		// check equals
		Assertions.assertEquals(TestCreateData.name, entity.getName());
		Assertions.assertEquals(TestCreateData.price, entity.getPrice());
	}

	@Order(2)
	@Test
	void testUpdate() throws BaseException {
		Optional<Product> opt = service.findByName(TestCreateData.name);
		Assertions.assertTrue(opt.isPresent());

		Product entity = opt.get();

		Product updatedProduct = service.updateName(entity.getId(), TestUpdateData.name);

		Assertions.assertNotNull(updatedProduct);
		Assertions.assertEquals(TestUpdateData.name, updatedProduct.getName());
	}

	@Order(3)
	@Test
	void testDelete() {
		Optional<Product> opt = service.findByName(TestUpdateData.name);
		Assertions.assertTrue(opt.isPresent());

		Product entity = opt.get();
		service.deleteById(entity.getId());

		Optional<Product> optDelete = service.findByName(TestUpdateData.name);
		Assertions.assertTrue(optDelete.isEmpty());
	}

	interface TestCreateData {

		String name = "Apple iPhone 14";
		double price = 40000f;

	}

	interface TestUpdateData {

		String name = "Apple iPhone 14 Pro";

	}

}
