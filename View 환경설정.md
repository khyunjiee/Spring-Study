### View 환경설정

**Welcome Page**

* Spring Boot가 Welcome Page를 제공
  스프링 프로젝트 resources/static 경로에 index.html을 생성하면 첫 화면에 뜬다.
* 정적 페이지

**thymeleaf 템플릿 엔진**

```java
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }

}
```

* Spring에서는 Controller 클래스 앞에 @Controller라는 어노테이션을 붙여야한다.
* @GetMapping("hello")는 /hello라는 URl이 GET 요청으로 들어왔을 때 해당 부분을 실행하라는 어노테이션이다.
* model.addAttribute("data", "hello!!");
  data라는 속성에 "hello!!"를 넣게되는 부분이다.
* return "hello"
  resources/templates 폴더 하위에 해당 리턴값의 파일을 찾아가는 부분이다.

```html
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}">안녕하세요.</p>
</body>
</html>
```

* ${data} 는 넘겨받은 attributeValue를 넣는 부분이다.





![IMG_1265FCD6348D-1](https://user-images.githubusercontent.com/49138331/90408168-72b64500-e0e2-11ea-928a-98d4b1209e7e.jpeg)