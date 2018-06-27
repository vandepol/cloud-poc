import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sprint.demo.models.OrderDetails;
import com.sprint.demo.services.MongoConfiguration;
import com.sprint.demo.services.OrderRepository;

/**
 * Test access to mongo db.
 * @author jeromeboyer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfiguration.class})
public class MongodbRepositoryTest {
	
	static final int QTY = 10;
	
	@Autowired
	protected OrderRepository repository;

	@Before
	public void init() {
		repository.deleteAll();
		for (int i = 0; i < QTY; i++) {
			OrderDetails o = new OrderDetails("order-"+i,
					 200,"200","cvv","2018-06-26",
					 "name-"+i,
					 "card-"+i);
			repository.save(o);
		}
	}
	
	@Test
	public void shouldHaveQTYelementsInList() {
		List<OrderDetails> list = repository.findAll();
		Assert.assertTrue(QTY == list.size());
	}

}
