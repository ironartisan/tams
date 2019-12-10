## 说明
* sql文件在src/resources/db/migration

## 相关执行

#### flyway
* 版本迭代
* mvn flyway:migrate
* 版本修复
* mvn flyway:repair
* 清除数据
* mvn flyway:clean

#### mybatis.generator
* 自动生成mapper文件
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

### 运行说明
1. 更改pom.xml中org.flywaydb下的mysql数据库名称及用户名、密码。
2. 更改generatorConfig.xml中的mysql数据库名称及用户名、密码。
3. 更改application.properties的mysql数据库名称及用户名、密码。
4. 运行flyway中的版本迭代脚本，会自动生成数据库字段与数据。
5. Run，Default port is 8082，Enjoy it.