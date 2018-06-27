import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Autowired
	protected OrderRepository repository;

	@Before
	public void init() {
		repository.deleteAll();
	}

}
