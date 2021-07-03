# 샘플목적: 멀티모듈 & Auto-config
- 멀티모듈로 Maven 모듈 생성
- Auto-config로 모듈의 설정을 주입하여 사용(자동설정)
- 주입한 Bean 은 재정의될 수 있으며 (override)
- Bean 의 속성값은 동적으로 변경될 수 있어야 함 (in.application.yml)

## 멀티모듈 만들기
### 1. Maven Project 생성 (부모)
pom.xml >>>
```xml
...
<!-- 패키징을 pom으로 하여 자식모듈에서 상속받을 수 있도록 설정 -->
<packaging>pom</packaging>
...
```

### 2. Maven Module 생성 (자식)
pom.xml >>>
```xml
<!-- 부모 프로젝트 상속 -->
<parent>
  <groupId>sample</groupId>
  <artifactId>maven-multi-module</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</parent>
```

### 3. 메이븐 빌드로 확인
`.m2/repository` 경로에 정상생성여부 확인

## Auto-Config 모듈설정 & 외부 앱에서 사용하기
### 1. Maven Module 에 `spring-starter` 주입 (auto-config 모듈 설정)
pom.xml >>>
```xml
...
<!-- pom 타입 임포트 설정 -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>${spring-boot.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
...
<dependencies>
  <!-- spring-starter: autoconfig 위한 임포트 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
  </dependency>
  <!-- 속성값 처리를 위한 임포트 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-configuration-processor</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies>
...
```

### 2. 자동설정할 빈 / 속성 / 설정 생성 (auto-config 모듈 설정)
- 빈: SomeService, 앱에서 사용될 빈 정의
- 속성: @ConfigurationProperties 로 속성값 로딩하도록 정의 (from.application.yml)
- 설정: @Configuration 을 통해 위에 정의한 빈 등록 (SomeService)

### 3. 메이븐 빌드로 패키지 생성
App 에서 사용할 메이븐 모듈을 생성한다.

### 4. 사용하기 - 신규 App 생성 & 사용
`spring-boot` 기반의 App 을 생성하고, `dependency` 로 auto-config 메이븐 모듈을 임포트한다.

