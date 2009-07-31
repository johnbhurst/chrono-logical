
import org.joda.time.LocalDate
import org.joda.time.contrib.hibernate.PersistentLocalDate

class Birthday {

    String name
    LocalDate birthDate

    static constraints = {
    }

    static mapping = {
        birthDate type: PersistentLocalDate
    }

}

