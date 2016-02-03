@Grapes([
  @Grab('io.ratpack:ratpack-groovy:1.1.1'),
  @Grab('org.slf4j:slf4j-simple:1.7.12')
])
import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render "Hello World!dd"
        }
        get(":name") {
            render "Hello $pathTokens.name!"
        }
    }
}
