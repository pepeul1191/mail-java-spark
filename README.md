# Mail Java Spark

Crear proyecto con Maven

    $ mvn archetype:generate -DgroupId=pe.softweb -DartifactId=lite -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

Ubicación de los archivos estáticos:

    src/main/resources/public

Crear war usando Maven:

    $ mvn package

Cargar dependencias bower y npm:

    $ bower install && npm install

Ejecutar Main Class usando Maven:

    $ mvn clean && mvn install && mvn exec:java -Dexec.mainClass="configs.App"

Email template de Cerberus

Reemplazo de string por key:

```
Map<String, String> values = new HashMap<String, String>();
values.put("value", x);
values.put("column", y);
StrSubstitutor sub = new StrSubstitutor(values, "%(", ")");
String result = sub.replace("There's an incorrect value '%(value)' in column # %(column)");
```


--- 

Fuentes

+ https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
+ https://stackoverflow.com/questions/9846046/run-main-class-of-maven-project
+ http://sparkjava.com/
+ http://www.simplejavamail.org/#/download
+ https://github.com/bbottema/simple-java-mail
+ https://tedgoas.github.io/Cerberus/
+ https://stackoverflow.com/questions/2286648/named-placeholders-in-string-formatting