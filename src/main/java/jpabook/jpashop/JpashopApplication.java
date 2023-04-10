package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
	Hibernate5Module은 Jackson JSON 프로세서를 Hibernate 5.x와 통합하기 위해 사용되는 Jackson 모듈입니다.
	Hibernate은 Java용 오픈소스 ORM(Object-Relational Mapping) 도구로, 데이터베이스와 객체 지향 프로그래밍 언어 간의 불일치를 해결하기 위해 사용됩니다.
	Hibernate5Module은 Jackson 라이브러리의 ObjectMapper와 함께 사용되어 Hibernate의 엔티티를 JSON 형식으로 직렬화 및 역직렬화 할 수 있도록 지원합니다.
	이 모듈은 Jackson에서 자동으로 엔티티 객체를 로드하고 프록시를 처리하며, 초기화되지 않은 컬렉션을 무시하고 자식 객체를 지연로딩합니다.
	따라서 Hibernate5Module은 Hibernate 엔티티를 JSON으로 직렬화하는 데 매우 유용합니다.
	이를 통해 클라이언트와 서버 간의 데이터 전송 및 저장소에서 엔티티를 검색하는 데 사용될 수 있습니다.


*/
@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

/*	@Bean
	Hibernate5Module hibernate5Module(){
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		//강제 lazy로딩
		hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
		return hibernate5Module;
	}*/


}
