### Gradle

Spring Boot에서 Java의 버전을 설정해주고, 라이브러리들을 빌드해주는 툴

```xml
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}
```

tymeleaf : resources의 템플릿 엔진
web : spring-web 라이브러리
test : 요즘 SpringBoot 프로젝트를 만들면 테스트 폴더가 같이 생성되는데, junit5가 기본



```xml
repositories {
	mavenCentral()
}
```

위의 라이브러리들을 mavenCentral이라는 사이트에서 다운로드 받으라는 의미



### @SpringBootApplication

```java
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
```

@SpringBootApplication 이라는 어노테이션은 말 그대로 스프링 부트 어플리케이션이라는 뜻
Java는 메인 메서드를 기준으로 프로젝트를 실행하기 때문에 메인 메서드를 run 해주면 프로젝트가 실행됨



**프로젝트 실행 시 Gradle을 통하지 않고 intelliJ에서 Java로 바로 실행하도록 설정 바꾸기**

Preferences - Build, Execution, Deployment - Build Tools - Gradle

- Build and run using: Gradle IntelliJ IDEA
- Run tests using: Gradle IntelliJ IDEA

위와 같이 설정을 바꾸면 프로젝트 실행이 Gradle을 거치지 않기 때문에 훨씬 빨리 실행됨.