dependencies {
    val hibernateVersion: String by project
    val springBootVersion: String by project
    compile("org.hibernate:hibernate-jcache")
    runtime("org.ehcache:ehcache")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    runtime("com.h2database:h2")
    runtime("mysql:mysql-connector-java")
    runtime("org.postgresql:postgresql")
}

