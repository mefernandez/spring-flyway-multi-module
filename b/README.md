# Short intro

This repository contains examples on how to import an external module/library/jar into a Spring Boot (v.2.3.5) application 
and let that module manage its own Flyway scripts with its own Flyway history table.

The examples are JUnit tests showing how to configure Flyway to achieve script history independence.

# The problem

Very briefly, say you have a Spring Boot `Project A`, which depends on `Project B`.

`A --> depends --> B`

In Maven, it would look like:

`NOTE: I'll ignore some POM details`
```maven
<project>
	<groupId>com.example</groupId>
	<artifactId>project-a</artifactId>

	<dependencies>
		<dependency>
			<groupId>com.example</groupId>
			<artifactId>project-b</artifactId>
		</dependency>
	</dependencies>
</project>
```

In this case, both project A and B have their own Flyway scripts located in `db/migration`.

Project A:
- V1_script.sql
- V2_script.sql

Project B: 
- V1_some_other_script.sql
- V2_some_other_script.sql

Out of the box, Flyway will complain on app startup: 

```
Found more than one migration with version 1
```

# The solution (TL;DR)

These are the main steps. 
Beware there's some more details regarding JPA config explained down below.

1. Make sure each module has its own Flyway location path, not overlapping with any other module.

```
A -> db/migration/project-a
B -> db/migration/project-b
```

2. Create a Java `@Configuration` in Project A class like this:

```java
@Configuration
public class FlywayConfig {

  @Bean
  public FlywayMigrationInitializer mainFlywayInitializer(DataSource dataSource) {
    Flyway flyway = Flyway.configure()
        .locations("classpath:db/migration/project-a")
        .table("flyway_history_project_a")
        .baselineOnMigrate(true)
        .baselineVersion("0.0.0")
        .dataSource(dataSource)
        .load();
    return new FlywayMigrationInitializer(flyway);
  }

  @Bean
  public FlywayMigrationInitializer moduleFlywayInitializer(DataSource dataSource) {
    Flyway flyway = Flyway.configure()
        .locations("classpath:db/migration/project-b")
        .table("flyway_history_project_b")
        .baselineOnMigrate(true)
        .baselineVersion("0.0.0")
        .dataSource(dataSource)
        .load();
    return new FlywayMigrationInitializer(flyway);
  }
}
```

# Long story

:WIP:
