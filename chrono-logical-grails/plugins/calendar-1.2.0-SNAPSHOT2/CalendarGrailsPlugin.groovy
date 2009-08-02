class CalendarGrailsPlugin {

    def version = "1.2.0-SNAPSHOT2"
    def dependsOn = [:]

    def author = "Maxwell Chiareli Xandeco"
    def authorEmail = "mchiareli@gmail.com"
    def title = "Grails Calendar Plugin"
    def description = '''
        Calendar Plugin is a lightweight and customizable date picker for grails applications,
        it provides a easy tag library, to include date picker in your application.
    '''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/Calendar+Plugin"

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }
   
    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)		
    }

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional)
    }
	                                      
    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }
	
    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
