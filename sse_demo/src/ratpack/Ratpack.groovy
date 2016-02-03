
import static ratpack.groovy.Groovy.ratpack
import static ratpack.groovy.Groovy.groovyTemplate
import ratpack.groovy.template.TextTemplate
import ratpack.groovy.template.TextTemplateModule

// see http://mrhaki.blogspot.ch/2016/01/ratpacked-customising-renderers-with.html

ratpack {

	bindings {
		module TextTemplateModule
	}

  handlers {
    get {
      //render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
      render groovyTemplate("index.html", name: "Jon")
    }
    get("sse") {
    	response.headers.add("Content-Type", 'text/event-stream');
    	response.headers.add("Cache-Control", 'no-cache');
    	def time = new Date()
    	render "data: The server time is: $time\n\n";
    }

    files { dir "public" }
  }
}
