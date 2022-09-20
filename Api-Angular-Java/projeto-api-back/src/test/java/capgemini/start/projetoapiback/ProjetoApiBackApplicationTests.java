package capgemini.start.projetoapiback;

import capgemini.start.projetoapiback.model.Course;
import capgemini.start.projetoapiback.repository.impl.CourseRepository;
import capgemini.start.projetoapiback.service.impl.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetoApiBackApplicationTests {

	@Test
	void contextLoads() {
	}

}
