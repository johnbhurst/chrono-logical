

class BirthdayController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ birthdayInstanceList: Birthday.list( params ), birthdayInstanceTotal: Birthday.count() ]
    }

    def show = {
        def birthdayInstance = Birthday.get( params.id )

        if(!birthdayInstance) {
            flash.message = "Birthday not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ birthdayInstance : birthdayInstance ] }
    }

    def delete = {
        def birthdayInstance = Birthday.get( params.id )
        if(birthdayInstance) {
            try {
                birthdayInstance.delete(flush:true)
                flash.message = "Birthday ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Birthday ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Birthday not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def birthdayInstance = Birthday.get( params.id )

        if(!birthdayInstance) {
            flash.message = "Birthday not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ birthdayInstance : birthdayInstance ]
        }
    }

    def update = {
        def birthdayInstance = Birthday.get( params.id )
        if(birthdayInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(birthdayInstance.version > version) {
                    
                    birthdayInstance.errors.rejectValue("version", "birthday.optimistic.locking.failure", "Another user has updated this Birthday while you were editing.")
                    render(view:'edit',model:[birthdayInstance:birthdayInstance])
                    return
                }
            }
            birthdayInstance.properties = params
            if(!birthdayInstance.hasErrors() && birthdayInstance.save()) {
                flash.message = "Birthday ${params.id} updated"
                redirect(action:show,id:birthdayInstance.id)
            }
            else {
                render(view:'edit',model:[birthdayInstance:birthdayInstance])
            }
        }
        else {
            flash.message = "Birthday not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def birthdayInstance = new Birthday()
        birthdayInstance.properties = params
        return ['birthdayInstance':birthdayInstance]
    }

    def save = {
        def birthdayInstance = new Birthday(params)
        if(!birthdayInstance.hasErrors() && birthdayInstance.save()) {
            flash.message = "Birthday ${birthdayInstance.id} created"
            redirect(action:show,id:birthdayInstance.id)
        }
        else {
            render(view:'create',model:[birthdayInstance:birthdayInstance])
        }
    }
}
