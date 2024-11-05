

1) We are using Jackson library to deserialize the string. 
2) We are using `BigInteger` and `BigDecimal`, which are out of the box arbitrary precision numbers from Java.
3) Scenario 1 : When some of the properties and their data types are known, other properties are added with 
value as Object type to the map. This is `Player class`. Unit test `JsonStringToJavaObjectTest.testScenario1` 
covers this.
4) Scenario 2 : When we need to construct custom deserializer, where the json mapping
is not matching with class attributes. Say we have attribute endorsements for `PlayerWithEndorsements`.
   Its value should be `List<String>` for all the objects in the json path `$.endorsements`. 
   The string for a particular object is
```
   Endorsed `$.endorsements[i].category` for `$.endorsements[i].number_of_years` years.
```
   Unit test `JsonStringToJavaObjectTest.testScenario2` covers this.

5) Following command can be used to build, after `cd json-parser`, we can use JDK 11.
`mvn clean install`. And the in the build logs, the UTs print the Java Object.
6) The json used is placed here `src/test/resources/exampleJson.json`.







